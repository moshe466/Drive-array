package com.google.firebase.firestore;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.EmptyCredentialsProvider;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class FirebaseFirestore {
    private static final String TAG = "FirebaseFirestore";
    private final AsyncQueue asyncQueue;
    private volatile FirestoreClient client;
    private final Context context;
    private final CredentialsProvider credentialsProvider;
    private final UserDataConverter dataConverter;
    private final DatabaseId databaseId;
    private final FirebaseApp firebaseApp;
    private final InstanceRegistry instanceRegistry;
    private final GrpcMetadataProvider metadataProvider;
    private final String persistenceKey;
    private FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().build();

    /* loaded from: classes2.dex */
    public interface InstanceRegistry {
        void remove(@NonNull String str);
    }

    @VisibleForTesting
    FirebaseFirestore(Context context, DatabaseId databaseId, String str, CredentialsProvider credentialsProvider, AsyncQueue asyncQueue, @Nullable FirebaseApp firebaseApp, InstanceRegistry instanceRegistry, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.context = (Context) Preconditions.checkNotNull(context);
        this.databaseId = (DatabaseId) Preconditions.checkNotNull((DatabaseId) Preconditions.checkNotNull(databaseId));
        this.dataConverter = new UserDataConverter(databaseId);
        this.persistenceKey = (String) Preconditions.checkNotNull(str);
        this.credentialsProvider = (CredentialsProvider) Preconditions.checkNotNull(credentialsProvider);
        this.asyncQueue = (AsyncQueue) Preconditions.checkNotNull(asyncQueue);
        this.firebaseApp = firebaseApp;
        this.instanceRegistry = instanceRegistry;
        this.metadataProvider = grpcMetadataProvider;
    }

    @NonNull
    public static FirebaseFirestore a(@NonNull Context context, @NonNull FirebaseApp firebaseApp, @Nullable InternalAuthProvider internalAuthProvider, @NonNull String str, @NonNull InstanceRegistry instanceRegistry, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        CredentialsProvider firebaseAuthCredentialsProvider;
        String projectId = firebaseApp.getOptions().getProjectId();
        if (projectId == null) {
            throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
        }
        DatabaseId forDatabase = DatabaseId.forDatabase(projectId, str);
        AsyncQueue asyncQueue = new AsyncQueue();
        if (internalAuthProvider == null) {
            Logger.debug(TAG, "Firebase Auth not available, falling back to unauthenticated usage.", new Object[0]);
            firebaseAuthCredentialsProvider = new EmptyCredentialsProvider();
        } else {
            firebaseAuthCredentialsProvider = new FirebaseAuthCredentialsProvider(internalAuthProvider);
        }
        return new FirebaseFirestore(context, forDatabase, firebaseApp.getName(), firebaseAuthCredentialsProvider, asyncQueue, firebaseApp, instanceRegistry, grpcMetadataProvider);
    }

    public static /* synthetic */ void a(FirebaseFirestore firebaseFirestore, TaskCompletionSource taskCompletionSource) {
        try {
            if (firebaseFirestore.client != null && !firebaseFirestore.client.isTerminated()) {
                throw new FirebaseFirestoreException("Persistence cannot be cleared while the firestore instance is running.", FirebaseFirestoreException.Code.FAILED_PRECONDITION);
            }
            SQLitePersistence.clearPersistence(firebaseFirestore.context, firebaseFirestore.databaseId, firebaseFirestore.persistenceKey);
            taskCompletionSource.setResult(null);
        } catch (FirebaseFirestoreException e) {
            taskCompletionSource.setException(e);
        }
    }

    public static /* synthetic */ void a(FirebaseFirestore firebaseFirestore, AsyncEventListener asyncEventListener) {
        asyncEventListener.mute();
        firebaseFirestore.client.removeSnapshotsInSyncListener(asyncEventListener);
    }

    public static /* synthetic */ void a(Runnable runnable, Void r2, FirebaseFirestoreException firebaseFirestoreException) {
        Assert.hardAssert(firebaseFirestoreException == null, "snapshots-in-sync listeners should never get errors.", new Object[0]);
        runnable.run();
    }

    private ListenerRegistration addSnapshotsInSyncListener(Executor executor, @Nullable Activity activity, @NonNull Runnable runnable) {
        ensureClientConfigured();
        AsyncEventListener asyncEventListener = new AsyncEventListener(executor, FirebaseFirestore$$Lambda$3.lambdaFactory$(runnable));
        this.client.addSnapshotsInSyncListener(asyncEventListener);
        return ActivityScope.bind(activity, FirebaseFirestore$$Lambda$4.lambdaFactory$(this, asyncEventListener));
    }

    private void ensureClientConfigured() {
        if (this.client != null) {
            return;
        }
        synchronized (this.databaseId) {
            if (this.client != null) {
                return;
            }
            this.client = new FirestoreClient(this.context, new DatabaseInfo(this.databaseId, this.persistenceKey, this.settings.getHost(), this.settings.isSslEnabled()), this.settings, this.credentialsProvider, this.asyncQueue, this.metadataProvider);
        }
    }

    @NonNull
    public static FirebaseFirestore getInstance() {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        if (firebaseApp != null) {
            return getInstance(firebaseApp, DatabaseId.DEFAULT_DATABASE_ID);
        }
        throw new IllegalStateException("You must call FirebaseApp.initializeApp first.");
    }

    @NonNull
    public static FirebaseFirestore getInstance(@NonNull FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, DatabaseId.DEFAULT_DATABASE_ID);
    }

    @NonNull
    private static FirebaseFirestore getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        Preconditions.checkNotNull(firebaseApp, "Provided FirebaseApp must not be null.");
        FirestoreMultiDbComponent firestoreMultiDbComponent = (FirestoreMultiDbComponent) firebaseApp.get(FirestoreMultiDbComponent.class);
        Preconditions.checkNotNull(firestoreMultiDbComponent, "Firestore component is not present.");
        return firestoreMultiDbComponent.a(str);
    }

    private <ResultT> Task<ResultT> runTransaction(Transaction.Function<ResultT> function, Executor executor) {
        ensureClientConfigured();
        return this.client.transaction(FirebaseFirestore$$Lambda$1.lambdaFactory$(this, executor, function));
    }

    public static void setLoggingEnabled(boolean z) {
        Logger.setLogLevel(z ? Logger.Level.DEBUG : Logger.Level.WARN);
    }

    public FirestoreClient a() {
        return this.client;
    }

    public void a(DocumentReference documentReference) {
        Preconditions.checkNotNull(documentReference, "Provided DocumentReference must not be null.");
        if (documentReference.getFirestore() != this) {
            throw new IllegalArgumentException("Provided document reference is from a different Cloud Firestore instance.");
        }
    }

    @NonNull
    public ListenerRegistration addSnapshotsInSyncListener(@NonNull Activity activity, @NonNull Runnable runnable) {
        return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, activity, runnable);
    }

    @NonNull
    public ListenerRegistration addSnapshotsInSyncListener(@NonNull Runnable runnable) {
        return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, runnable);
    }

    @NonNull
    public ListenerRegistration addSnapshotsInSyncListener(@NonNull Executor executor, @NonNull Runnable runnable) {
        return addSnapshotsInSyncListener(executor, null, runnable);
    }

    public UserDataConverter b() {
        return this.dataConverter;
    }

    @NonNull
    public WriteBatch batch() {
        ensureClientConfigured();
        return new WriteBatch(this);
    }

    public DatabaseId c() {
        return this.databaseId;
    }

    @NonNull
    public Task<Void> clearPersistence() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.asyncQueue.enqueueAndForgetEvenAfterShutdown(FirebaseFirestore$$Lambda$2.lambdaFactory$(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public CollectionReference collection(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided collection path must not be null.");
        ensureClientConfigured();
        return new CollectionReference(ResourcePath.fromString(str), this);
    }

    @NonNull
    public Query collectionGroup(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided collection ID must not be null.");
        if (str.contains("/")) {
            throw new IllegalArgumentException(String.format("Invalid collectionId '%s'. Collection IDs must not contain '/'.", str));
        }
        ensureClientConfigured();
        return new Query(new com.google.firebase.firestore.core.Query(ResourcePath.EMPTY, str), this);
    }

    public Task<Void> d() {
        ensureClientConfigured();
        return this.client.terminate();
    }

    @NonNull
    public Task<Void> disableNetwork() {
        ensureClientConfigured();
        return this.client.disableNetwork();
    }

    @NonNull
    public DocumentReference document(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided document path must not be null.");
        ensureClientConfigured();
        return DocumentReference.a(ResourcePath.fromString(str), this);
    }

    @NonNull
    public Task<Void> enableNetwork() {
        ensureClientConfigured();
        return this.client.enableNetwork();
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.firebaseApp;
    }

    @NonNull
    public FirebaseFirestoreSettings getFirestoreSettings() {
        return this.settings;
    }

    @NonNull
    public Task<Void> runBatch(@NonNull WriteBatch.Function function) {
        WriteBatch batch = batch();
        function.apply(batch);
        return batch.commit();
    }

    @NonNull
    public <TResult> Task<TResult> runTransaction(@NonNull Transaction.Function<TResult> function) {
        Preconditions.checkNotNull(function, "Provided transaction update function must not be null.");
        return runTransaction(function, com.google.firebase.firestore.core.Transaction.getDefaultExecutor());
    }

    public void setFirestoreSettings(@NonNull FirebaseFirestoreSettings firebaseFirestoreSettings) {
        synchronized (this.databaseId) {
            Preconditions.checkNotNull(firebaseFirestoreSettings, "Provided settings must not be null.");
            if (this.client != null && !this.settings.equals(firebaseFirestoreSettings)) {
                throw new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
            }
            this.settings = firebaseFirestoreSettings;
        }
    }

    @NonNull
    public Task<Void> terminate() {
        this.instanceRegistry.remove(c().getDatabaseId());
        return d();
    }

    @NonNull
    public Task<Void> waitForPendingWrites() {
        return this.client.waitForPendingWrites();
    }
}
