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
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class DocumentReference {
    private final FirebaseFirestore firestore;
    private final DocumentKey key;

    public DocumentReference(DocumentKey documentKey, FirebaseFirestore firebaseFirestore) {
        this.key = (DocumentKey) Preconditions.checkNotNull(documentKey);
        this.firestore = firebaseFirestore;
    }

    public static DocumentReference a(ResourcePath resourcePath, FirebaseFirestore firebaseFirestore) {
        if (resourcePath.length() % 2 == 0) {
            return new DocumentReference(DocumentKey.fromPath(resourcePath), firebaseFirestore);
        }
        throw new IllegalArgumentException("Invalid document reference. Document references must have an even number of segments, but " + resourcePath.canonicalString() + " has " + resourcePath.length());
    }

    public static /* synthetic */ DocumentSnapshot a(DocumentReference documentReference, Task task) {
        Document document = (Document) task.getResult();
        return new DocumentSnapshot(documentReference.firestore, documentReference.key, document, true, document != null && document.hasLocalMutations());
    }

    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source, DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        FirebaseFirestoreException firebaseFirestoreException2;
        if (firebaseFirestoreException != null) {
            taskCompletionSource.setException(firebaseFirestoreException);
            return;
        }
        try {
            ((ListenerRegistration) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (!documentSnapshot.exists() && documentSnapshot.getMetadata().isFromCache()) {
                firebaseFirestoreException2 = new FirebaseFirestoreException("Failed to get document because the client is offline.", FirebaseFirestoreException.Code.UNAVAILABLE);
            } else {
                if (!documentSnapshot.exists() || !documentSnapshot.getMetadata().isFromCache() || source != Source.SERVER) {
                    taskCompletionSource.setResult(documentSnapshot);
                    return;
                }
                firebaseFirestoreException2 = new FirebaseFirestoreException("Failed to get document from server. (However, this document does exist in the local cache. Run again without setting source to SERVER to retrieve the cached document.)", FirebaseFirestoreException.Code.UNAVAILABLE);
            }
            taskCompletionSource.setException(firebaseFirestoreException2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Assert.fail(e, "Failed to register a listener for a single document", new Object[0]);
        } catch (ExecutionException e2) {
            throw Assert.fail(e2, "Failed to register a listener for a single document", new Object[0]);
        }
    }

    public static /* synthetic */ void a(DocumentReference documentReference, EventListener eventListener, ViewSnapshot viewSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            eventListener.onEvent(null, firebaseFirestoreException);
            return;
        }
        Assert.hardAssert(viewSnapshot != null, "Got event without value or error set", new Object[0]);
        Assert.hardAssert(viewSnapshot.getDocuments().size() <= 1, "Too many documents returned on a document query", new Object[0]);
        Document document = viewSnapshot.getDocuments().getDocument(documentReference.key);
        eventListener.onEvent(document != null ? DocumentSnapshot.a(documentReference.firestore, document, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document.getKey())) : DocumentSnapshot.a(documentReference.firestore, documentReference.key, viewSnapshot.isFromCache(), false), null);
    }

    private ListenerRegistration addSnapshotListenerInternal(Executor executor, EventManager.ListenOptions listenOptions, @Nullable Activity activity, EventListener<DocumentSnapshot> eventListener) {
        AsyncEventListener asyncEventListener = new AsyncEventListener(executor, DocumentReference$$Lambda$3.lambdaFactory$(this, eventListener));
        return ActivityScope.bind(activity, new ListenerRegistrationImpl(this.firestore.a(), this.firestore.a().listen(asQuery(), listenOptions, asyncEventListener), asyncEventListener));
    }

    private com.google.firebase.firestore.core.Query asQuery() {
        return com.google.firebase.firestore.core.Query.atPath(this.key.getPath());
    }

    @NonNull
    private Task<DocumentSnapshot> getViaSnapshotListener(Source source) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        listenOptions.includeDocumentMetadataChanges = true;
        listenOptions.includeQueryMetadataChanges = true;
        listenOptions.waitForSyncWhenOnline = true;
        taskCompletionSource2.setResult(addSnapshotListenerInternal(Executors.DIRECT_EXECUTOR, listenOptions, null, DocumentReference$$Lambda$2.lambdaFactory$(taskCompletionSource, taskCompletionSource2, source)));
        return taskCompletionSource.getTask();
    }

    private static EventManager.ListenOptions internalOptions(MetadataChanges metadataChanges) {
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        listenOptions.includeDocumentMetadataChanges = metadataChanges == MetadataChanges.INCLUDE;
        listenOptions.includeQueryMetadataChanges = metadataChanges == MetadataChanges.INCLUDE;
        listenOptions.waitForSyncWhenOnline = false;
        return listenOptions;
    }

    private Task<Void> update(@NonNull UserData.ParsedUpdateData parsedUpdateData) {
        return this.firestore.a().write(parsedUpdateData.toMutationList(this.key, Precondition.exists(true))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    public DocumentKey a() {
        return this.key;
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(activity, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<DocumentSnapshot> eventListener) {
        Preconditions.checkNotNull(activity, "Provided activity must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(Executors.DEFAULT_CALLBACK_EXECUTOR, internalOptions(metadataChanges), activity, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull MetadataChanges metadataChanges, @NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, metadataChanges, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(executor, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<DocumentSnapshot> eventListener) {
        Preconditions.checkNotNull(executor, "Provided executor must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(executor, internalOptions(metadataChanges), null, eventListener);
    }

    @NonNull
    public CollectionReference collection(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided collection path must not be null.");
        return new CollectionReference(this.key.getPath().append(ResourcePath.fromString(str)), this.firestore);
    }

    @NonNull
    public Task<Void> delete() {
        return this.firestore.a().write(Collections.singletonList(new DeleteMutation(this.key, Precondition.NONE))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentReference)) {
            return false;
        }
        DocumentReference documentReference = (DocumentReference) obj;
        return this.key.equals(documentReference.key) && this.firestore.equals(documentReference.firestore);
    }

    @NonNull
    public Task<DocumentSnapshot> get() {
        return get(Source.DEFAULT);
    }

    @NonNull
    public Task<DocumentSnapshot> get(@NonNull Source source) {
        return source == Source.CACHE ? this.firestore.a().getDocumentFromLocalCache(this.key).continueWith(Executors.DIRECT_EXECUTOR, DocumentReference$$Lambda$1.lambdaFactory$(this)) : getViaSnapshotListener(source);
    }

    @NonNull
    public FirebaseFirestore getFirestore() {
        return this.firestore;
    }

    @NonNull
    public String getId() {
        return this.key.getPath().getLastSegment();
    }

    @NonNull
    public CollectionReference getParent() {
        return new CollectionReference(this.key.getPath().popLast(), this.firestore);
    }

    @NonNull
    public String getPath() {
        return this.key.getPath().canonicalString();
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.firestore.hashCode();
    }

    @NonNull
    public Task<Void> set(@NonNull Object obj) {
        return set(obj, SetOptions.a);
    }

    @NonNull
    public Task<Void> set(@NonNull Object obj, @NonNull SetOptions setOptions) {
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions, "Provided options must not be null.");
        return this.firestore.a().write((setOptions.a() ? this.firestore.b().parseMergeData(obj, setOptions.getFieldMask()) : this.firestore.b().parseSetData(obj)).toMutationList(this.key, Precondition.NONE)).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    @NonNull
    public Task<Void> update(@NonNull FieldPath fieldPath, @Nullable Object obj, Object... objArr) {
        return update(this.firestore.b().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, obj, objArr)));
    }

    @NonNull
    public Task<Void> update(@NonNull String str, @Nullable Object obj, Object... objArr) {
        return update(this.firestore.b().parseUpdateData(Util.collectUpdateArguments(1, str, obj, objArr)));
    }

    @NonNull
    public Task<Void> update(@NonNull Map<String, Object> map) {
        return update(this.firestore.b().parseUpdateData(map));
    }
}
