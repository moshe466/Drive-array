package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import t.C0694j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TopicsSubscriber {
    static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final long RPC_TIMEOUT_SEC = 30;
    private final Context context;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new C0694j(0);
    private boolean syncScheduledOrRunning = false;

    /* JADX WARN: Type inference failed for: r0v0, types: [t.j, java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>>] */
    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging;
        this.metadata = metadata;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context;
        this.syncExecutor = scheduledExecutorService;
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        synchronized (this.pendingOperations) {
            try {
                String serialize = topicOperation.serialize();
                if (this.pendingOperations.containsKey(serialize)) {
                    arrayDeque = this.pendingOperations.get(serialize);
                } else {
                    ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                    this.pendingOperations.put(serialize, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static <T> void awaitTask(Task<T> task) {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e4) {
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE, e4);
        } catch (ExecutionException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e5);
            }
            throw ((IOException) cause);
        }
    }

    private void blockingSubscribeToTopic(String str) {
        awaitTask(this.rpc.subscribeToTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) {
        awaitTask(this.rpc.unsubscribeFromTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    public static Task<TopicsSubscriber> createInstance(final FirebaseMessaging firebaseMessaging, final Metadata metadata, final GmsRpc gmsRpc, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TopicsSubscriber lambda$createInstance$0;
                lambda$createInstance$0 = TopicsSubscriber.lambda$createInstance$0(context, scheduledExecutorService, firebaseMessaging, metadata, gmsRpc);
                return lambda$createInstance$0;
            }
        });
    }

    public static boolean isDebugLogEnabled() {
        if (!Log.isLoggable(Constants.TAG, 3)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TopicsSubscriber lambda$createInstance$0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        return new TopicsSubscriber(firebaseMessaging, metadata, TopicsStore.getInstance(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    private void markCompletePendingOperation(TopicOperation topicOperation) {
        synchronized (this.pendingOperations) {
            try {
                String serialize = topicOperation.serialize();
                if (!this.pendingOperations.containsKey(serialize)) {
                    return;
                }
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.pendingOperations.get(serialize);
                TaskCompletionSource<Void> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.setResult(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.pendingOperations.remove(serialize);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0L);
        }
    }

    public TopicsStore getStore() {
        return this.store;
    }

    public boolean hasPendingOperation() {
        if (this.store.getNextTopicOperation() != null) {
            return true;
        }
        return false;
    }

    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[Catch: IOException -> 0x001d, TryCatch #0 {IOException -> 0x001d, blocks: (B:3:0x0001, B:11:0x002e, B:14:0x0032, B:16:0x003f, B:17:0x0043, B:19:0x0050, B:20:0x0013, B:23:0x001f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean performTopicOperation(com.google.firebase.messaging.TopicOperation r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r6.getOperation()     // Catch: java.io.IOException -> L1d
            int r2 = r1.hashCode()     // Catch: java.io.IOException -> L1d
            r3 = 83
            r4 = 1
            if (r2 == r3) goto L1f
            r3 = 85
            if (r2 == r3) goto L13
            goto L29
        L13:
            java.lang.String r2 = "U"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L29
            r1 = r4
            goto L2a
        L1d:
            r6 = move-exception
            goto L54
        L1f:
            java.lang.String r2 = "S"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L29
            r1 = r0
            goto L2a
        L29:
            r1 = -1
        L2a:
            if (r1 == 0) goto L43
            if (r1 == r4) goto L32
            isDebugLogEnabled()     // Catch: java.io.IOException -> L1d
            goto L53
        L32:
            java.lang.String r1 = r6.getTopic()     // Catch: java.io.IOException -> L1d
            r5.blockingUnsubscribeFromTopic(r1)     // Catch: java.io.IOException -> L1d
            boolean r1 = isDebugLogEnabled()     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L53
            r6.getTopic()     // Catch: java.io.IOException -> L1d
            goto L53
        L43:
            java.lang.String r1 = r6.getTopic()     // Catch: java.io.IOException -> L1d
            r5.blockingSubscribeToTopic(r1)     // Catch: java.io.IOException -> L1d
            boolean r1 = isDebugLogEnabled()     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L53
            r6.getTopic()     // Catch: java.io.IOException -> L1d
        L53:
            return r4
        L54:
            java.lang.String r1 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r2 = r6.getMessage()
            boolean r1 = r1.equals(r2)
            java.lang.String r2 = "FirebaseMessaging"
            if (r1 != 0) goto L88
            java.lang.String r1 = "INTERNAL_SERVER_ERROR"
            java.lang.String r3 = r6.getMessage()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L88
            java.lang.String r1 = "TOO_MANY_SUBSCRIBERS"
            java.lang.String r3 = r6.getMessage()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L7b
            goto L88
        L7b:
            java.lang.String r1 = r6.getMessage()
            if (r1 != 0) goto L87
            java.lang.String r6 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r2, r6)
            return r0
        L87:
            throw r6
        L88:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Topic operation failed: "
            r1.<init>(r3)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = ". Will retry Topic operation."
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            android.util.Log.e(r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.performTopicOperation(com.google.firebase.messaging.TopicOperation):boolean");
    }

    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j2) {
        this.syncExecutor.schedule(runnable, j2, TimeUnit.SECONDS);
    }

    public Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public synchronized void setSyncScheduledOrRunning(boolean z3) {
        this.syncScheduledOrRunning = z3;
    }

    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    public Task<Void> subscribeToTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    public boolean syncTopics() {
        while (true) {
            synchronized (this) {
                try {
                    TopicOperation nextTopicOperation = this.store.getNextTopicOperation();
                    if (nextTopicOperation == null) {
                        isDebugLogEnabled();
                        return true;
                    }
                    if (!performTopicOperation(nextTopicOperation)) {
                        return false;
                    }
                    this.store.removeTopicOperation(nextTopicOperation);
                    markCompletePendingOperation(nextTopicOperation);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void syncWithDelaySecondsInternal(long j2) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, 2 * j2), MAX_DELAY_SEC)), j2);
        setSyncScheduledOrRunning(true);
    }

    public Task<Void> unsubscribeFromTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }
}
