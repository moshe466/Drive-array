package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.Objects;
import com.google.firebase.database.core.ChildEventRegistration;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PathIndex;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.ValueIndex;

/* loaded from: classes2.dex */
public class Query {
    protected final Repo a;
    protected final Path b;
    protected final QueryParams c;
    private final boolean orderByCalled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Query(Repo repo, Path path) {
        this.a = repo;
        this.b = path;
        this.c = QueryParams.DEFAULT_PARAMS;
        this.orderByCalled = false;
    }

    Query(Repo repo, Path path, QueryParams queryParams, boolean z) {
        this.a = repo;
        this.b = path;
        this.c = queryParams;
        this.orderByCalled = z;
        Utilities.hardAssert(queryParams.isValid(), "Validation of queries failed.");
    }

    private void addEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().recordEventRegistration(eventRegistration);
        this.a.scheduleNow(new Runnable() { // from class: com.google.firebase.database.Query.3
            @Override // java.lang.Runnable
            public void run() {
                Query.this.a.addEventCallback(eventRegistration);
            }
        });
    }

    private Query endAt(Node node, String str) {
        Validation.validateNullableKey(str);
        if (!node.isLeafNode() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for endAt()");
        }
        ChildKey fromString = str != null ? ChildKey.fromString(str) : null;
        if (this.c.hasEnd()) {
            throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
        }
        QueryParams endAt = this.c.endAt(node, fromString);
        validateLimit(endAt);
        validateQueryEndpoints(endAt);
        return new Query(this.a, this.b, endAt, this.orderByCalled);
    }

    private void removeEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().zombifyForRemove(eventRegistration);
        this.a.scheduleNow(new Runnable() { // from class: com.google.firebase.database.Query.2
            @Override // java.lang.Runnable
            public void run() {
                Query.this.a.removeEventCallback(eventRegistration);
            }
        });
    }

    private Query startAt(Node node, String str) {
        Validation.validateNullableKey(str);
        if (!node.isLeafNode() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt()");
        }
        if (this.c.hasStart()) {
            throw new IllegalArgumentException("Can't call startAt() or equalTo() multiple times");
        }
        QueryParams startAt = this.c.startAt(node, str != null ? ChildKey.fromString(str) : null);
        validateLimit(startAt);
        validateQueryEndpoints(startAt);
        return new Query(this.a, this.b, startAt, this.orderByCalled);
    }

    private void validateEqualToCall() {
        if (this.c.hasStart()) {
            throw new IllegalArgumentException("Can't call equalTo() and startAt() combined");
        }
        if (this.c.hasEnd()) {
            throw new IllegalArgumentException("Can't call equalTo() and endAt() combined");
        }
    }

    private void validateLimit(QueryParams queryParams) {
        if (queryParams.hasStart() && queryParams.hasEnd() && queryParams.hasLimit() && !queryParams.hasAnchoredLimit()) {
            throw new IllegalArgumentException("Can't combine startAt(), endAt() and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private void validateNoOrderByCall() {
        if (this.orderByCalled) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    private void validateQueryEndpoints(QueryParams queryParams) {
        if (!queryParams.getIndex().equals(KeyIndex.getInstance())) {
            if (queryParams.getIndex().equals(PriorityIndex.getInstance())) {
                if ((queryParams.hasStart() && !PriorityUtilities.isValidPriority(queryParams.getIndexStartValue())) || (queryParams.hasEnd() && !PriorityUtilities.isValidPriority(queryParams.getIndexEndValue()))) {
                    throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), endAt(), or equalTo() must be valid priorities.");
                }
                return;
            }
            return;
        }
        if (queryParams.hasStart()) {
            Node indexStartValue = queryParams.getIndexStartValue();
            if (!Objects.equal(queryParams.getIndexStartName(), ChildKey.getMinName()) || !(indexStartValue instanceof StringNode)) {
                throw new IllegalArgumentException("You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
        if (queryParams.hasEnd()) {
            Node indexEndValue = queryParams.getIndexEndValue();
            if (!queryParams.getIndexEndName().equals(ChildKey.getMaxName()) || !(indexEndValue instanceof StringNode)) {
                throw new IllegalArgumentException("You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
    }

    @NonNull
    public ChildEventListener addChildEventListener(@NonNull ChildEventListener childEventListener) {
        addEventRegistration(new ChildEventRegistration(this.a, childEventListener, getSpec()));
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(@NonNull final ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.a, new ValueEventListener() { // from class: com.google.firebase.database.Query.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                valueEventListener.onCancelled(databaseError);
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                Query.this.removeEventListener(this);
                valueEventListener.onDataChange(dataSnapshot);
            }
        }, getSpec()));
    }

    @NonNull
    public ValueEventListener addValueEventListener(@NonNull ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.a, valueEventListener, getSpec()));
        return valueEventListener;
    }

    @NonNull
    public Query endAt(double d) {
        return endAt(d, (String) null);
    }

    @NonNull
    public Query endAt(double d, @Nullable String str) {
        return endAt(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query endAt(@Nullable String str) {
        return endAt(str, (String) null);
    }

    @NonNull
    public Query endAt(@Nullable String str, @Nullable String str2) {
        return endAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query endAt(boolean z) {
        return endAt(z, (String) null);
    }

    @NonNull
    public Query endAt(boolean z, @Nullable String str) {
        return endAt(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query equalTo(double d) {
        validateEqualToCall();
        return startAt(d).endAt(d);
    }

    @NonNull
    public Query equalTo(double d, @Nullable String str) {
        validateEqualToCall();
        return startAt(d, str).endAt(d, str);
    }

    @NonNull
    public Query equalTo(@Nullable String str) {
        validateEqualToCall();
        return startAt(str).endAt(str);
    }

    @NonNull
    public Query equalTo(@Nullable String str, @Nullable String str2) {
        validateEqualToCall();
        return startAt(str, str2).endAt(str, str2);
    }

    @NonNull
    public Query equalTo(boolean z) {
        validateEqualToCall();
        return startAt(z).endAt(z);
    }

    @NonNull
    public Query equalTo(boolean z, @Nullable String str) {
        validateEqualToCall();
        return startAt(z, str).endAt(z, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Path getPath() {
        return this.b;
    }

    @NonNull
    public DatabaseReference getRef() {
        return new DatabaseReference(this.a, getPath());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Repo getRepo() {
        return this.a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public QuerySpec getSpec() {
        return new QuerySpec(this.b, this.c);
    }

    public void keepSynced(final boolean z) {
        if (!this.b.isEmpty() && this.b.getFront().equals(ChildKey.getInfoKey())) {
            throw new DatabaseException("Can't call keepSynced() on .info paths.");
        }
        this.a.scheduleNow(new Runnable() { // from class: com.google.firebase.database.Query.4
            @Override // java.lang.Runnable
            public void run() {
                Query query = Query.this;
                query.a.keepSynced(query.getSpec(), z);
            }
        });
    }

    @NonNull
    public Query limitToFirst(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.c.hasLimit()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new Query(this.a, this.b, this.c.limitToFirst(i), this.orderByCalled);
    }

    @NonNull
    public Query limitToLast(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.c.hasLimit()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new Query(this.a, this.b, this.c.limitToLast(i), this.orderByCalled);
    }

    @NonNull
    public Query orderByChild(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("Key can't be null");
        }
        if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByKey() instead!");
        }
        if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByPriority() instead!");
        }
        if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByValue() instead!");
        }
        Validation.validatePathString(str);
        validateNoOrderByCall();
        Path path = new Path(str);
        if (path.size() == 0) {
            throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
        }
        return new Query(this.a, this.b, this.c.orderBy(new PathIndex(path)), true);
    }

    @NonNull
    public Query orderByKey() {
        validateNoOrderByCall();
        QueryParams orderBy = this.c.orderBy(KeyIndex.getInstance());
        validateQueryEndpoints(orderBy);
        return new Query(this.a, this.b, orderBy, true);
    }

    @NonNull
    public Query orderByPriority() {
        validateNoOrderByCall();
        QueryParams orderBy = this.c.orderBy(PriorityIndex.getInstance());
        validateQueryEndpoints(orderBy);
        return new Query(this.a, this.b, orderBy, true);
    }

    @NonNull
    public Query orderByValue() {
        validateNoOrderByCall();
        return new Query(this.a, this.b, this.c.orderBy(ValueIndex.getInstance()), true);
    }

    public void removeEventListener(@NonNull ChildEventListener childEventListener) {
        if (childEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        removeEventRegistration(new ChildEventRegistration(this.a, childEventListener, getSpec()));
    }

    public void removeEventListener(@NonNull ValueEventListener valueEventListener) {
        if (valueEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        removeEventRegistration(new ValueEventRegistration(this.a, valueEventListener, getSpec()));
    }

    @NonNull
    public Query startAt(double d) {
        return startAt(d, (String) null);
    }

    @NonNull
    public Query startAt(double d, @Nullable String str) {
        return startAt(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query startAt(@Nullable String str) {
        return startAt(str, (String) null);
    }

    @NonNull
    public Query startAt(@Nullable String str, @Nullable String str2) {
        return startAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query startAt(boolean z) {
        return startAt(z, (String) null);
    }

    @NonNull
    public Query startAt(boolean z, @Nullable String str) {
        return startAt(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }
}
