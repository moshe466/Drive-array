package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.remote.Stream.StreamCallback;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class AbstractStream<ReqT, RespT, CallbackT extends Stream.StreamCallback> implements Stream<CallbackT> {
    private static final double BACKOFF_FACTOR = 1.5d;
    private static final long BACKOFF_INITIAL_DELAY_MS = TimeUnit.SECONDS.toMillis(1);
    private static final long BACKOFF_MAX_DELAY_MS = TimeUnit.MINUTES.toMillis(1);
    private static final long IDLE_TIMEOUT_MS = TimeUnit.MINUTES.toMillis(1);
    final ExponentialBackoff a;
    final CallbackT b;
    private ClientCall<ReqT, RespT> call;
    private final FirestoreChannel firestoreChannel;

    @Nullable
    private AsyncQueue.DelayedTask idleTimer;
    private final AsyncQueue.TimerId idleTimerId;
    private final MethodDescriptor<ReqT, RespT> methodDescriptor;
    private final AsyncQueue workerQueue;
    private Stream.State state = Stream.State.Initial;
    private long closeCount = 0;
    private final AbstractStream<ReqT, RespT, CallbackT>.IdleTimeoutRunnable idleTimeoutRunnable = new IdleTimeoutRunnable();

    /* loaded from: classes2.dex */
    public class CloseGuardedRunner {
        private final long initialCloseCount;

        CloseGuardedRunner(long j) {
            this.initialCloseCount = j;
        }

        void a(Runnable runnable) {
            AbstractStream.this.workerQueue.verifyIsCurrentThread();
            if (AbstractStream.this.closeCount == this.initialCloseCount) {
                runnable.run();
            } else {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public class IdleTimeoutRunnable implements Runnable {
        IdleTimeoutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractStream.this.handleIdleCloseTimer();
        }
    }

    /* loaded from: classes2.dex */
    public class StreamObserver implements IncomingStreamObserver<RespT> {
        private final AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner dispatcher;

        StreamObserver(AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner closeGuardedRunner) {
            this.dispatcher = closeGuardedRunner;
        }

        public static /* synthetic */ void a(StreamObserver streamObserver) {
            Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(AbstractStream.this)));
            AbstractStream.this.onOpen();
        }

        public static /* synthetic */ void a(StreamObserver streamObserver, Metadata metadata) {
            if (Logger.isDebugEnabled()) {
                HashMap hashMap = new HashMap();
                for (String str : metadata.keys()) {
                    if (Datastore.a.contains(str.toLowerCase(Locale.ENGLISH))) {
                        hashMap.put(str, (String) metadata.get(Metadata.Key.of(str, Metadata.ASCII_STRING_MARSHALLER)));
                    }
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(AbstractStream.this)), hashMap);
            }
        }

        public static /* synthetic */ void a(StreamObserver streamObserver, Status status) {
            if (status.isOk()) {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(AbstractStream.this)));
            } else {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(AbstractStream.this)), status);
            }
            AbstractStream.this.a(status);
        }

        public static /* synthetic */ void a(StreamObserver streamObserver, Object obj) {
            if (Logger.isDebugEnabled()) {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream received: %s", Integer.valueOf(System.identityHashCode(AbstractStream.this)), obj);
            }
            AbstractStream.this.onNext(obj);
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onClose(Status status) {
            this.dispatcher.a(AbstractStream$StreamObserver$$Lambda$4.lambdaFactory$(this, status));
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onHeaders(Metadata metadata) {
            this.dispatcher.a(AbstractStream$StreamObserver$$Lambda$1.lambdaFactory$(this, metadata));
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onNext(RespT respt) {
            this.dispatcher.a(AbstractStream$StreamObserver$$Lambda$2.lambdaFactory$(this, respt));
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onOpen() {
            this.dispatcher.a(AbstractStream$StreamObserver$$Lambda$3.lambdaFactory$(this));
        }
    }

    public AbstractStream(FirestoreChannel firestoreChannel, MethodDescriptor<ReqT, RespT> methodDescriptor, AsyncQueue asyncQueue, AsyncQueue.TimerId timerId, AsyncQueue.TimerId timerId2, CallbackT callbackt) {
        this.firestoreChannel = firestoreChannel;
        this.methodDescriptor = methodDescriptor;
        this.workerQueue = asyncQueue;
        this.idleTimerId = timerId2;
        this.b = callbackt;
        this.a = new ExponentialBackoff(asyncQueue, timerId, BACKOFF_INITIAL_DELAY_MS, 1.5d, BACKOFF_MAX_DELAY_MS);
    }

    private void cancelIdleCheck() {
        AsyncQueue.DelayedTask delayedTask = this.idleTimer;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.idleTimer = null;
        }
    }

    private void close(Stream.State state, Status status) {
        Assert.hardAssert(isStarted(), "Only started streams should be closed.", new Object[0]);
        Assert.hardAssert(state == Stream.State.Error || status.equals(Status.OK), "Can't provide an error when not in an error state.", new Object[0]);
        this.workerQueue.verifyIsCurrentThread();
        if (Datastore.isMissingSslCiphers(status)) {
            Util.crashMainThread(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", status.getCause()));
        }
        cancelIdleCheck();
        this.a.cancel();
        this.closeCount++;
        Status.Code code = status.getCode();
        if (code == Status.Code.OK) {
            this.a.reset();
        } else if (code == Status.Code.RESOURCE_EXHAUSTED) {
            Logger.debug(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            this.a.resetToMax();
        } else if (code == Status.Code.UNAUTHENTICATED) {
            this.firestoreChannel.invalidateToken();
        }
        if (state != Stream.State.Error) {
            Logger.debug(getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            b();
        }
        if (this.call != null) {
            if (status.isOk()) {
                Logger.debug(getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.call.halfClose();
            }
            this.call = null;
        }
        this.state = state;
        this.b.onClose(status);
    }

    public static /* synthetic */ void e(AbstractStream abstractStream) {
        Assert.hardAssert(abstractStream.state == Stream.State.Backoff, "State should still be backoff but was %s", abstractStream.state);
        abstractStream.state = Stream.State.Initial;
        abstractStream.start();
        Assert.hardAssert(abstractStream.isStarted(), "Stream should have started", new Object[0]);
    }

    public void handleIdleCloseTimer() {
        if (isOpen()) {
            close(Stream.State.Initial, Status.OK);
        }
    }

    public void onOpen() {
        this.state = Stream.State.Open;
        this.b.onOpen();
    }

    private void performBackoff() {
        Assert.hardAssert(this.state == Stream.State.Error, "Should only perform backoff in an error state", new Object[0]);
        this.state = Stream.State.Backoff;
        this.a.backoffAndRun(AbstractStream$$Lambda$1.lambdaFactory$(this));
    }

    public void a() {
        if (isOpen() && this.idleTimer == null) {
            this.idleTimer = this.workerQueue.enqueueAfterDelay(this.idleTimerId, IDLE_TIMEOUT_MS, this.idleTimeoutRunnable);
        }
    }

    @VisibleForTesting
    void a(Status status) {
        Assert.hardAssert(isStarted(), "Can't handle server close on non-started stream!", new Object[0]);
        close(Stream.State.Error, status);
    }

    public void a(ReqT reqt) {
        this.workerQueue.verifyIsCurrentThread();
        Logger.debug(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        cancelIdleCheck();
        this.call.sendMessage(reqt);
    }

    protected void b() {
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void inhibitBackoff() {
        Assert.hardAssert(!isStarted(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.workerQueue.verifyIsCurrentThread();
        this.state = Stream.State.Initial;
        this.a.reset();
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isOpen() {
        this.workerQueue.verifyIsCurrentThread();
        return this.state == Stream.State.Open;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isStarted() {
        this.workerQueue.verifyIsCurrentThread();
        Stream.State state = this.state;
        return state == Stream.State.Starting || state == Stream.State.Open || state == Stream.State.Backoff;
    }

    public abstract void onNext(RespT respt);

    @Override // com.google.firebase.firestore.remote.Stream
    public void start() {
        this.workerQueue.verifyIsCurrentThread();
        Assert.hardAssert(this.call == null, "Last call still set", new Object[0]);
        Assert.hardAssert(this.idleTimer == null, "Idle timer still set", new Object[0]);
        Stream.State state = this.state;
        if (state == Stream.State.Error) {
            performBackoff();
            return;
        }
        Assert.hardAssert(state == Stream.State.Initial, "Already started", new Object[0]);
        this.call = this.firestoreChannel.a((MethodDescriptor) this.methodDescriptor, (IncomingStreamObserver) new StreamObserver(new CloseGuardedRunner(this.closeCount)));
        this.state = Stream.State.Starting;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void stop() {
        if (isStarted()) {
            close(Stream.State.Initial, Status.OK);
        }
    }
}
