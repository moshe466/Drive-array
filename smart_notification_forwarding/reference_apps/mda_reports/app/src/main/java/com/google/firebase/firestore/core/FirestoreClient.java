package com.google.firebase.firestore.core;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Function;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.local.IndexFreeQueryEngine;
import com.google.firebase.firestore.local.LocalSerializer;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.MemoryPersistence;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.AndroidConnectivityMonitor;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class FirestoreClient implements RemoteStore.RemoteStoreCallback {
    private static final String LOG_TAG = "FirestoreClient";
    private final AsyncQueue asyncQueue;
    private final CredentialsProvider credentialsProvider;
    private final DatabaseInfo databaseInfo;
    private EventManager eventManager;
    private LocalStore localStore;

    @Nullable
    private LruGarbageCollector.Scheduler lruScheduler;
    private final GrpcMetadataProvider metadataProvider;
    private Persistence persistence;
    private RemoteStore remoteStore;
    private SyncEngine syncEngine;

    public FirestoreClient(Context context, DatabaseInfo databaseInfo, FirebaseFirestoreSettings firebaseFirestoreSettings, CredentialsProvider credentialsProvider, AsyncQueue asyncQueue, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.databaseInfo = databaseInfo;
        this.credentialsProvider = credentialsProvider;
        this.asyncQueue = asyncQueue;
        this.metadataProvider = grpcMetadataProvider;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$1.lambdaFactory$(this, taskCompletionSource, context, firebaseFirestoreSettings));
        credentialsProvider.setChangeListener(FirestoreClient$$Lambda$2.lambdaFactory$(this, atomicBoolean, taskCompletionSource, asyncQueue));
    }

    public static /* synthetic */ ViewSnapshot a(FirestoreClient firestoreClient, Query query) {
        QueryResult executeQuery = firestoreClient.localStore.executeQuery(query, true);
        View view = new View(query, executeQuery.getRemoteKeys());
        return view.applyChanges(view.computeDocChanges(executeQuery.getDocuments())).getSnapshot();
    }

    public static /* synthetic */ Document a(Task task) {
        MaybeDocument maybeDocument = (MaybeDocument) task.getResult();
        if (maybeDocument instanceof Document) {
            return (Document) maybeDocument;
        }
        if (maybeDocument instanceof NoDocument) {
            return null;
        }
        throw new FirebaseFirestoreException("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", FirebaseFirestoreException.Code.UNAVAILABLE);
    }

    public static /* synthetic */ void a(FirestoreClient firestoreClient, TaskCompletionSource taskCompletionSource, Context context, FirebaseFirestoreSettings firebaseFirestoreSettings) {
        try {
            firestoreClient.initialize(context, (User) Tasks.await(taskCompletionSource.getTask()), firebaseFirestoreSettings.isPersistenceEnabled(), firebaseFirestoreSettings.getCacheSizeBytes());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static /* synthetic */ void a(FirestoreClient firestoreClient, User user) {
        Assert.hardAssert(firestoreClient.syncEngine != null, "SyncEngine not yet initialized", new Object[0]);
        Logger.debug(LOG_TAG, "Credential changed. Current user: %s", user.getUid());
        firestoreClient.syncEngine.handleCredentialChange(user);
    }

    public static /* synthetic */ void a(FirestoreClient firestoreClient, AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, AsyncQueue asyncQueue, User user) {
        if (!atomicBoolean.compareAndSet(false, true)) {
            asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$15.lambdaFactory$(firestoreClient, user));
        } else {
            Assert.hardAssert(!taskCompletionSource.getTask().isComplete(), "Already fulfilled first user task", new Object[0]);
            taskCompletionSource.setResult(user);
        }
    }

    public static /* synthetic */ void b(FirestoreClient firestoreClient) {
        firestoreClient.remoteStore.enableNetwork();
    }

    public static /* synthetic */ void c(FirestoreClient firestoreClient) {
        firestoreClient.remoteStore.shutdown();
        firestoreClient.persistence.shutdown();
        LruGarbageCollector.Scheduler scheduler = firestoreClient.lruScheduler;
        if (scheduler != null) {
            scheduler.stop();
        }
    }

    private void initialize(Context context, User user, boolean z, long j) {
        LruGarbageCollector lruGarbageCollector;
        Logger.debug(LOG_TAG, "Initializing. user=%s", user.getUid());
        if (z) {
            SQLitePersistence sQLitePersistence = new SQLitePersistence(context, this.databaseInfo.getPersistenceKey(), this.databaseInfo.getDatabaseId(), new LocalSerializer(new RemoteSerializer(this.databaseInfo.getDatabaseId())), LruGarbageCollector.Params.WithCacheSizeBytes(j));
            lruGarbageCollector = sQLitePersistence.getReferenceDelegate().getGarbageCollector();
            this.persistence = sQLitePersistence;
        } else {
            this.persistence = MemoryPersistence.createEagerGcMemoryPersistence();
            lruGarbageCollector = null;
        }
        this.persistence.start();
        this.localStore = new LocalStore(this.persistence, new IndexFreeQueryEngine(), user);
        if (lruGarbageCollector != null) {
            this.lruScheduler = lruGarbageCollector.newScheduler(this.asyncQueue, this.localStore);
            this.lruScheduler.start();
        }
        this.remoteStore = new RemoteStore(this, this.localStore, new Datastore(this.databaseInfo, this.asyncQueue, this.credentialsProvider, context, this.metadataProvider), this.asyncQueue, new AndroidConnectivityMonitor(context));
        this.syncEngine = new SyncEngine(this.localStore, this.remoteStore, user);
        this.eventManager = new EventManager(this.syncEngine);
        this.localStore.start();
        this.remoteStore.start();
    }

    private void verifyNotTerminated() {
        if (isTerminated()) {
            throw new IllegalStateException("The client has already been terminated");
        }
    }

    public void addSnapshotsInSyncListener(EventListener<Void> eventListener) {
        verifyNotTerminated();
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$14.lambdaFactory$(this, eventListener));
    }

    public Task<Void> disableNetwork() {
        verifyNotTerminated();
        return this.asyncQueue.enqueue(FirestoreClient$$Lambda$3.lambdaFactory$(this));
    }

    public Task<Void> enableNetwork() {
        verifyNotTerminated();
        return this.asyncQueue.enqueue(FirestoreClient$$Lambda$4.lambdaFactory$(this));
    }

    public Task<Document> getDocumentFromLocalCache(DocumentKey documentKey) {
        Continuation continuation;
        verifyNotTerminated();
        Task enqueue = this.asyncQueue.enqueue(FirestoreClient$$Lambda$8.lambdaFactory$(this, documentKey));
        continuation = FirestoreClient$$Lambda$9.instance;
        return enqueue.continueWith(continuation);
    }

    public Task<ViewSnapshot> getDocumentsFromLocalCache(Query query) {
        verifyNotTerminated();
        return this.asyncQueue.enqueue(FirestoreClient$$Lambda$10.lambdaFactory$(this, query));
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i) {
        return this.syncEngine.getRemoteKeysForTarget(i);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleOnlineStateChange(OnlineState onlineState) {
        this.syncEngine.handleOnlineStateChange(onlineState);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRejectedListen(int i, Status status) {
        this.syncEngine.handleRejectedListen(i, status);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRejectedWrite(int i, Status status) {
        this.syncEngine.handleRejectedWrite(i, status);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRemoteEvent(RemoteEvent remoteEvent) {
        this.syncEngine.handleRemoteEvent(remoteEvent);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
        this.syncEngine.handleSuccessfulWrite(mutationBatchResult);
    }

    public boolean isTerminated() {
        return this.asyncQueue.isShuttingDown();
    }

    public QueryListener listen(Query query, EventManager.ListenOptions listenOptions, EventListener<ViewSnapshot> eventListener) {
        verifyNotTerminated();
        QueryListener queryListener = new QueryListener(query, listenOptions, eventListener);
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$6.lambdaFactory$(this, queryListener));
        return queryListener;
    }

    public void removeSnapshotsInSyncListener(EventListener<Void> eventListener) {
        if (isTerminated()) {
            return;
        }
        this.eventManager.removeSnapshotsInSyncListener(eventListener);
    }

    public void stopListening(QueryListener queryListener) {
        if (isTerminated()) {
            return;
        }
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$7.lambdaFactory$(this, queryListener));
    }

    public Task<Void> terminate() {
        this.credentialsProvider.removeChangeListener();
        return this.asyncQueue.enqueueAndInitiateShutdown(FirestoreClient$$Lambda$5.lambdaFactory$(this));
    }

    public <TResult> Task<TResult> transaction(Function<Transaction, Task<TResult>> function) {
        verifyNotTerminated();
        return AsyncQueue.callTask(this.asyncQueue.getExecutor(), FirestoreClient$$Lambda$12.lambdaFactory$(this, function));
    }

    public Task<Void> waitForPendingWrites() {
        verifyNotTerminated();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$13.lambdaFactory$(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task<Void> write(List<Mutation> list) {
        verifyNotTerminated();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$11.lambdaFactory$(this, list, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
