package com.google.firebase.firestore;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.ServerTimestampValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class Query {
    final com.google.firebase.firestore.core.Query a;
    final FirebaseFirestore b;

    /* loaded from: classes2.dex */
    public enum Direction {
        ASCENDING,
        DESCENDING
    }

    public Query(com.google.firebase.firestore.core.Query query, FirebaseFirestore firebaseFirestore) {
        this.a = (com.google.firebase.firestore.core.Query) Preconditions.checkNotNull(query);
        this.b = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    public static /* synthetic */ QuerySnapshot a(Query query, Task task) {
        return new QuerySnapshot(new Query(query.a, query.b), (ViewSnapshot) task.getResult(), query.b);
    }

    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source, QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            taskCompletionSource.setException(firebaseFirestoreException);
            return;
        }
        try {
            ((ListenerRegistration) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (querySnapshot.getMetadata().isFromCache() && source == Source.SERVER) {
                taskCompletionSource.setException(new FirebaseFirestoreException("Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to SERVER to retrieve the cached documents.)", FirebaseFirestoreException.Code.UNAVAILABLE));
            } else {
                taskCompletionSource.setResult(querySnapshot);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Assert.fail(e, "Failed to register a listener for a query result", new Object[0]);
        } catch (ExecutionException e2) {
            throw Assert.fail(e2, "Failed to register a listener for a query result", new Object[0]);
        }
    }

    public static /* synthetic */ void a(Query query, EventListener eventListener, ViewSnapshot viewSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            eventListener.onEvent(null, firebaseFirestoreException);
        } else {
            Assert.hardAssert(viewSnapshot != null, "Got event without value or error set", new Object[0]);
            eventListener.onEvent(new QuerySnapshot(query, viewSnapshot, query.b), null);
        }
    }

    private ListenerRegistration addSnapshotListenerInternal(Executor executor, EventManager.ListenOptions listenOptions, @Nullable Activity activity, EventListener<QuerySnapshot> eventListener) {
        validateHasExplicitOrderByForLimitToLast();
        AsyncEventListener asyncEventListener = new AsyncEventListener(executor, Query$$Lambda$3.lambdaFactory$(this, eventListener));
        return ActivityScope.bind(activity, new ListenerRegistrationImpl(this.b.a(), this.b.a().listen(this.a, listenOptions, asyncEventListener), asyncEventListener));
    }

    private Bound boundFromDocumentSnapshot(String str, DocumentSnapshot documentSnapshot, boolean z) {
        Preconditions.checkNotNull(documentSnapshot, "Provided snapshot must not be null.");
        if (!documentSnapshot.exists()) {
            throw new IllegalArgumentException("Can't use a DocumentSnapshot for a document that doesn't exist for " + str + "().");
        }
        Document a = documentSnapshot.a();
        ArrayList arrayList = new ArrayList();
        for (OrderBy orderBy : this.a.getOrderBy()) {
            if (orderBy.getField().equals(com.google.firebase.firestore.model.FieldPath.KEY_PATH)) {
                arrayList.add(ReferenceValue.valueOf(this.b.c(), a.getKey()));
            } else {
                com.google.firebase.firestore.model.value.FieldValue field = a.getField(orderBy.getField());
                if (field instanceof ServerTimestampValue) {
                    throw new IllegalArgumentException("Invalid query. You are trying to start or end a query using a document for which the field '" + orderBy.getField() + "' is an uncommitted server timestamp. (Since the value of this field is unknown, you cannot start/end a query with it.)");
                }
                if (field == null) {
                    throw new IllegalArgumentException("Invalid query. You are trying to start or end a query using a document for which the field '" + orderBy.getField() + "' (used as the orderBy) does not exist.");
                }
                arrayList.add(field);
            }
        }
        return new Bound(arrayList, z);
    }

    private Bound boundFromFields(String str, Object[] objArr, boolean z) {
        com.google.firebase.firestore.model.value.FieldValue parseQueryValue;
        List<OrderBy> explicitOrderBy = this.a.getExplicitOrderBy();
        if (objArr.length > explicitOrderBy.size()) {
            throw new IllegalArgumentException("Too many arguments provided to " + str + "(). The number of arguments must be less than or equal to the number of orderBy() clauses.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (!explicitOrderBy.get(i).getField().equals(com.google.firebase.firestore.model.FieldPath.KEY_PATH)) {
                parseQueryValue = this.b.b().parseQueryValue(obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new IllegalArgumentException("Invalid query. Expected a string for document ID in " + str + "(), but got " + obj + ".");
                }
                String str2 = (String) obj;
                if (!this.a.isCollectionGroupQuery() && str2.contains("/")) {
                    throw new IllegalArgumentException("Invalid query. When querying a collection and ordering by FieldPath.documentId(), the value passed to " + str + "() must be a plain document ID, but '" + str2 + "' contains a slash.");
                }
                ResourcePath append = this.a.getPath().append(ResourcePath.fromString(str2));
                if (!DocumentKey.isDocumentKey(append)) {
                    throw new IllegalArgumentException("Invalid query. When querying a collection group and ordering by FieldPath.documentId(), the value passed to " + str + "() must result in a valid document path, but '" + append + "' is not because it contains an odd number of segments.");
                }
                parseQueryValue = ReferenceValue.valueOf(this.b.c(), DocumentKey.fromPath(append));
            }
            arrayList.add(parseQueryValue);
        }
        return new Bound(arrayList, z);
    }

    private Task<QuerySnapshot> getViaSnapshotListener(Source source) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        listenOptions.includeDocumentMetadataChanges = true;
        listenOptions.includeQueryMetadataChanges = true;
        listenOptions.waitForSyncWhenOnline = true;
        taskCompletionSource2.setResult(addSnapshotListenerInternal(Executors.DIRECT_EXECUTOR, listenOptions, null, Query$$Lambda$2.lambdaFactory$(taskCompletionSource, taskCompletionSource2, source)));
        return taskCompletionSource.getTask();
    }

    private static EventManager.ListenOptions internalOptions(MetadataChanges metadataChanges) {
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        listenOptions.includeDocumentMetadataChanges = metadataChanges == MetadataChanges.INCLUDE;
        listenOptions.includeQueryMetadataChanges = metadataChanges == MetadataChanges.INCLUDE;
        listenOptions.waitForSyncWhenOnline = false;
        return listenOptions;
    }

    private Query orderBy(@NonNull com.google.firebase.firestore.model.FieldPath fieldPath, @NonNull Direction direction) {
        Preconditions.checkNotNull(direction, "Provided direction must not be null.");
        if (this.a.getStartAt() != null) {
            throw new IllegalArgumentException("Invalid query. You must not call Query.startAt() or Query.startAfter() before calling Query.orderBy().");
        }
        if (this.a.getEndAt() != null) {
            throw new IllegalArgumentException("Invalid query. You must not call Query.endAt() or Query.endBefore() before calling Query.orderBy().");
        }
        validateOrderByField(fieldPath);
        return new Query(this.a.orderBy(OrderBy.getInstance(direction == Direction.ASCENDING ? OrderBy.Direction.ASCENDING : OrderBy.Direction.DESCENDING, fieldPath)), this.b);
    }

    private ReferenceValue parseDocumentIdValue(Object obj) {
        DatabaseId c;
        DocumentKey a;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid document ID, but it was an empty string.");
            }
            if (!this.a.isCollectionGroupQuery() && str.contains("/")) {
                throw new IllegalArgumentException("Invalid query. When querying a collection by FieldPath.documentId() you must provide a plain document ID, but '" + str + "' contains a '/' character.");
            }
            ResourcePath append = this.a.getPath().append(ResourcePath.fromString(str));
            if (!DocumentKey.isDocumentKey(append)) {
                throw new IllegalArgumentException("Invalid query. When querying a collection group by FieldPath.documentId(), the value provided must result in a valid document path, but '" + append + "' is not because it has an odd number of segments (" + append.length() + ").");
            }
            c = getFirestore().c();
            a = DocumentKey.fromPath(append);
        } else {
            if (!(obj instanceof DocumentReference)) {
                throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid String or DocumentReference, but it was of type: " + Util.typeName(obj));
            }
            c = getFirestore().c();
            a = ((DocumentReference) obj).a();
        }
        return ReferenceValue.valueOf(c, a);
    }

    private void validateDisjunctiveFilterElements(Object obj, Filter.Operator operator) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() != 0) {
                if (list.size() > 10) {
                    throw new IllegalArgumentException("Invalid Query. '" + operator.toString() + "' filters support a maximum of 10 elements in the value array.");
                }
                if (list.contains(null)) {
                    throw new IllegalArgumentException("Invalid Query. '" + operator.toString() + "' filters cannot contain 'null' in the value array.");
                }
                if (list.contains(Double.valueOf(Double.NaN)) || list.contains(Float.valueOf(Float.NaN))) {
                    throw new IllegalArgumentException("Invalid Query. '" + operator.toString() + "' filters cannot contain 'NaN' in the value array.");
                }
                return;
            }
        }
        throw new IllegalArgumentException("Invalid Query. A non-empty array is required for '" + operator.toString() + "' filters.");
    }

    private void validateHasExplicitOrderByForLimitToLast() {
        if (this.a.hasLimitToLast() && this.a.getExplicitOrderBy().isEmpty()) {
            throw new IllegalStateException("limitToLast() queries require specifying at least one orderBy() clause");
        }
    }

    private void validateNewFilter(Filter filter) {
        if (filter instanceof FieldFilter) {
            FieldFilter fieldFilter = (FieldFilter) filter;
            Filter.Operator operator = fieldFilter.getOperator();
            List<Filter.Operator> asList = Arrays.asList(Filter.Operator.ARRAY_CONTAINS, Filter.Operator.ARRAY_CONTAINS_ANY);
            List<Filter.Operator> asList2 = Arrays.asList(Filter.Operator.ARRAY_CONTAINS_ANY, Filter.Operator.IN);
            boolean contains = asList.contains(operator);
            boolean contains2 = asList2.contains(operator);
            if (fieldFilter.isInequality()) {
                com.google.firebase.firestore.model.FieldPath inequalityField = this.a.inequalityField();
                com.google.firebase.firestore.model.FieldPath field = filter.getField();
                if (inequalityField != null && !inequalityField.equals(field)) {
                    throw new IllegalArgumentException(String.format("All where filters other than whereEqualTo() must be on the same field. But you have filters on '%s' and '%s'", inequalityField.canonicalString(), field.canonicalString()));
                }
                com.google.firebase.firestore.model.FieldPath firstOrderByField = this.a.getFirstOrderByField();
                if (firstOrderByField != null) {
                    validateOrderByFieldMatchesInequality(firstOrderByField, field);
                    return;
                }
                return;
            }
            if (contains2 || contains) {
                Filter.Operator findFilterOperator = contains2 ? this.a.findFilterOperator(asList2) : null;
                if (findFilterOperator == null && contains) {
                    findFilterOperator = this.a.findFilterOperator(asList);
                }
                if (findFilterOperator != null) {
                    if (findFilterOperator == operator) {
                        throw new IllegalArgumentException("Invalid Query. You cannot use more than one '" + operator.toString() + "' filter.");
                    }
                    throw new IllegalArgumentException("Invalid Query. You cannot use '" + operator.toString() + "' filters with '" + findFilterOperator.toString() + "' filters.");
                }
            }
        }
    }

    private void validateOrderByField(com.google.firebase.firestore.model.FieldPath fieldPath) {
        com.google.firebase.firestore.model.FieldPath inequalityField = this.a.inequalityField();
        if (this.a.getFirstOrderByField() != null || inequalityField == null) {
            return;
        }
        validateOrderByFieldMatchesInequality(fieldPath, inequalityField);
    }

    private void validateOrderByFieldMatchesInequality(com.google.firebase.firestore.model.FieldPath fieldPath, com.google.firebase.firestore.model.FieldPath fieldPath2) {
        if (fieldPath.equals(fieldPath2)) {
            return;
        }
        String canonicalString = fieldPath2.canonicalString();
        throw new IllegalArgumentException(String.format("Invalid query. You have an inequality where filter (whereLessThan(), whereGreaterThan(), etc.) on field '%s' and so you must also have '%s' as your first orderBy() field, but your first orderBy() is currently on field '%s' instead.", canonicalString, canonicalString, fieldPath.canonicalString()));
    }

    private Query whereHelper(@NonNull FieldPath fieldPath, Filter.Operator operator, Object obj) {
        com.google.firebase.firestore.model.value.FieldValue parseQueryValue;
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Preconditions.checkNotNull(operator, "Provided op must not be null.");
        if (!fieldPath.a().isKeyField()) {
            if (operator == Filter.Operator.IN || operator == Filter.Operator.ARRAY_CONTAINS_ANY) {
                validateDisjunctiveFilterElements(obj, operator);
            }
            parseQueryValue = this.b.b().parseQueryValue(obj, operator == Filter.Operator.IN);
        } else {
            if (operator == Filter.Operator.ARRAY_CONTAINS || operator == Filter.Operator.ARRAY_CONTAINS_ANY) {
                throw new IllegalArgumentException("Invalid query. You can't perform '" + operator.toString() + "' queries on FieldPath.documentId().");
            }
            if (operator == Filter.Operator.IN) {
                validateDisjunctiveFilterElements(obj, operator);
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(parseDocumentIdValue(it.next()));
                }
                parseQueryValue = ArrayValue.fromList(arrayList);
            } else {
                parseQueryValue = parseDocumentIdValue(obj);
            }
        }
        FieldFilter create = FieldFilter.create(fieldPath.a(), operator, parseQueryValue);
        validateNewFilter(create);
        return new Query(this.a.filter(create), this.b);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(activity, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        Preconditions.checkNotNull(activity, "Provided activity must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(Executors.DEFAULT_CALLBACK_EXECUTOR, internalOptions(metadataChanges), activity, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, metadataChanges, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(executor, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        Preconditions.checkNotNull(executor, "Provided executor must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(executor, internalOptions(metadataChanges), null, eventListener);
    }

    @NonNull
    public Query endAt(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.a.endAt(boundFromDocumentSnapshot("endAt", documentSnapshot, false)), this.b);
    }

    @NonNull
    public Query endAt(Object... objArr) {
        return new Query(this.a.endAt(boundFromFields("endAt", objArr, false)), this.b);
    }

    @NonNull
    public Query endBefore(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.a.endAt(boundFromDocumentSnapshot("endBefore", documentSnapshot, true)), this.b);
    }

    @NonNull
    public Query endBefore(Object... objArr) {
        return new Query(this.a.endAt(boundFromFields("endBefore", objArr, true)), this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Query)) {
            return false;
        }
        Query query = (Query) obj;
        return this.a.equals(query.a) && this.b.equals(query.b);
    }

    @NonNull
    public Task<QuerySnapshot> get() {
        return get(Source.DEFAULT);
    }

    @NonNull
    public Task<QuerySnapshot> get(@NonNull Source source) {
        validateHasExplicitOrderByForLimitToLast();
        return source == Source.CACHE ? this.b.a().getDocumentsFromLocalCache(this.a).continueWith(Executors.DIRECT_EXECUTOR, Query$$Lambda$1.lambdaFactory$(this)) : getViaSnapshotListener(source);
    }

    @NonNull
    public FirebaseFirestore getFirestore() {
        return this.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @NonNull
    public Query limit(long j) {
        if (j > 0) {
            return new Query(this.a.limitToFirst(j), this.b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limit (" + j + ") is invalid. Limit must be positive.");
    }

    @NonNull
    public Query limitToLast(long j) {
        if (j > 0) {
            return new Query(this.a.limitToLast(j), this.b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limitToLast (" + j + ") is invalid. Limit must be positive.");
    }

    @NonNull
    public Query orderBy(@NonNull FieldPath fieldPath) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return orderBy(fieldPath.a(), Direction.ASCENDING);
    }

    @NonNull
    public Query orderBy(@NonNull FieldPath fieldPath, @NonNull Direction direction) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return orderBy(fieldPath.a(), direction);
    }

    @NonNull
    public Query orderBy(@NonNull String str) {
        return orderBy(FieldPath.a(str), Direction.ASCENDING);
    }

    @NonNull
    public Query orderBy(@NonNull String str, @NonNull Direction direction) {
        return orderBy(FieldPath.a(str), direction);
    }

    @NonNull
    public Query startAfter(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.a.startAt(boundFromDocumentSnapshot("startAfter", documentSnapshot, false)), this.b);
    }

    @NonNull
    public Query startAfter(Object... objArr) {
        return new Query(this.a.startAt(boundFromFields("startAfter", objArr, false)), this.b);
    }

    @NonNull
    public Query startAt(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.a.startAt(boundFromDocumentSnapshot("startAt", documentSnapshot, true)), this.b);
    }

    @NonNull
    public Query startAt(Object... objArr) {
        return new Query(this.a.startAt(boundFromFields("startAt", objArr, true)), this.b);
    }

    @NonNull
    public Query whereArrayContains(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.ARRAY_CONTAINS, obj);
    }

    @NonNull
    public Query whereArrayContains(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.a(str), Filter.Operator.ARRAY_CONTAINS, obj);
    }

    @NonNull
    public Query whereArrayContainsAny(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return whereHelper(fieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, list);
    }

    @NonNull
    public Query whereArrayContainsAny(@NonNull String str, @NonNull List<? extends Object> list) {
        return whereHelper(FieldPath.a(str), Filter.Operator.ARRAY_CONTAINS_ANY, list);
    }

    @NonNull
    public Query whereEqualTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return whereHelper(fieldPath, Filter.Operator.EQUAL, obj);
    }

    @NonNull
    public Query whereEqualTo(@NonNull String str, @Nullable Object obj) {
        return whereHelper(FieldPath.a(str), Filter.Operator.EQUAL, obj);
    }

    @NonNull
    public Query whereGreaterThan(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.GREATER_THAN, obj);
    }

    @NonNull
    public Query whereGreaterThan(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.a(str), Filter.Operator.GREATER_THAN, obj);
    }

    @NonNull
    public Query whereGreaterThanOrEqualTo(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.GREATER_THAN_OR_EQUAL, obj);
    }

    @NonNull
    public Query whereGreaterThanOrEqualTo(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.a(str), Filter.Operator.GREATER_THAN_OR_EQUAL, obj);
    }

    @NonNull
    public Query whereIn(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return whereHelper(fieldPath, Filter.Operator.IN, list);
    }

    @NonNull
    public Query whereIn(@NonNull String str, @NonNull List<? extends Object> list) {
        return whereHelper(FieldPath.a(str), Filter.Operator.IN, list);
    }

    @NonNull
    public Query whereLessThan(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.LESS_THAN, obj);
    }

    @NonNull
    public Query whereLessThan(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.a(str), Filter.Operator.LESS_THAN, obj);
    }

    @NonNull
    public Query whereLessThanOrEqualTo(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.LESS_THAN_OR_EQUAL, obj);
    }

    @NonNull
    public Query whereLessThanOrEqualTo(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.a(str), Filter.Operator.LESS_THAN_OR_EQUAL, obj);
    }
}
