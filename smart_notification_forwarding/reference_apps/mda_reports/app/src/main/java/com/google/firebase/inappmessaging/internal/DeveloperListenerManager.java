package com.google.firebase.inappmessaging.internal;

import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class DeveloperListenerManager {
    private static final int KEEP_ALIVE_TIME_SECONDS = 15;
    private static final int POOL_SIZE = 1;
    private Map<FirebaseInAppMessagingClickListener, ClicksExecutorAndListener> registeredClickListeners = new HashMap();
    private Map<FirebaseInAppMessagingDisplayErrorListener, ErrorsExecutorAndListener> registeredErrorListeners = new HashMap();
    private Map<FirebaseInAppMessagingImpressionListener, ImpressionExecutorAndListener> registeredImpressionListeners = new HashMap();
    public static DeveloperListenerManager instance = new DeveloperListenerManager();
    private static BlockingQueue<Runnable> mCallbackQueue = new LinkedBlockingQueue();
    private static final ThreadPoolExecutor CALLBACK_QUEUE_EXECUTOR = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, mCallbackQueue, new FIAMThreadFactory("EventListeners-"));

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ClicksExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingClickListener> {
        FirebaseInAppMessagingClickListener a;

        public ClicksExecutorAndListener(DeveloperListenerManager developerListenerManager, FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
            super(null);
            this.a = firebaseInAppMessagingClickListener;
        }

        public ClicksExecutorAndListener(DeveloperListenerManager developerListenerManager, FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
            super(executor);
            this.a = firebaseInAppMessagingClickListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingClickListener getListener() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ErrorsExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDisplayErrorListener> {
        FirebaseInAppMessagingDisplayErrorListener a;

        public ErrorsExecutorAndListener(DeveloperListenerManager developerListenerManager, FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
            super(null);
            this.a = firebaseInAppMessagingDisplayErrorListener;
        }

        public ErrorsExecutorAndListener(DeveloperListenerManager developerListenerManager, FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
            super(executor);
            this.a = firebaseInAppMessagingDisplayErrorListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingDisplayErrorListener getListener() {
            return this.a;
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class ExecutorAndListener<T> {
        private final Executor executor;

        public ExecutorAndListener(Executor executor) {
            this.executor = executor;
        }

        public abstract T getListener();

        public Executor withExecutor(Executor executor) {
            Executor executor2 = this.executor;
            return executor2 == null ? executor : executor2;
        }
    }

    /* loaded from: classes2.dex */
    static class FIAMThreadFactory implements ThreadFactory {
        private final String mNameSuffix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        FIAMThreadFactory(@NonNull String str) {
            this.mNameSuffix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, "FIAM-" + this.mNameSuffix + this.threadNumber.getAndIncrement());
            thread.setDaemon(false);
            thread.setPriority(9);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ImpressionExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingImpressionListener> {
        FirebaseInAppMessagingImpressionListener a;

        public ImpressionExecutorAndListener(DeveloperListenerManager developerListenerManager, FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
            super(null);
            this.a = firebaseInAppMessagingImpressionListener;
        }

        public ImpressionExecutorAndListener(DeveloperListenerManager developerListenerManager, FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
            super(executor);
            this.a = firebaseInAppMessagingImpressionListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingImpressionListener getListener() {
            return this.a;
        }
    }

    static {
        CALLBACK_QUEUE_EXECUTOR.allowCoreThreadTimeOut(true);
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(this, firebaseInAppMessagingClickListener));
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(this, firebaseInAppMessagingClickListener, executor));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(this, firebaseInAppMessagingDisplayErrorListener));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(this, firebaseInAppMessagingDisplayErrorListener, executor));
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(this, firebaseInAppMessagingImpressionListener));
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(this, firebaseInAppMessagingImpressionListener, executor));
    }

    public void displayErrorEncountered(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        for (ErrorsExecutorAndListener errorsExecutorAndListener : this.registeredErrorListeners.values()) {
            errorsExecutorAndListener.withExecutor(CALLBACK_QUEUE_EXECUTOR).execute(DeveloperListenerManager$$Lambda$2.lambdaFactory$(errorsExecutorAndListener, inAppMessage, inAppMessagingErrorReason));
        }
    }

    public void impressionDetected(InAppMessage inAppMessage) {
        for (ImpressionExecutorAndListener impressionExecutorAndListener : this.registeredImpressionListeners.values()) {
            impressionExecutorAndListener.withExecutor(CALLBACK_QUEUE_EXECUTOR).execute(DeveloperListenerManager$$Lambda$1.lambdaFactory$(impressionExecutorAndListener, inAppMessage));
        }
    }

    public void messageClicked(InAppMessage inAppMessage, Action action) {
        for (ClicksExecutorAndListener clicksExecutorAndListener : this.registeredClickListeners.values()) {
            clicksExecutorAndListener.withExecutor(CALLBACK_QUEUE_EXECUTOR).execute(DeveloperListenerManager$$Lambda$3.lambdaFactory$(clicksExecutorAndListener, inAppMessage, action));
        }
    }

    public void removeClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.remove(firebaseInAppMessagingClickListener);
    }

    public void removeDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.remove(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.remove(firebaseInAppMessagingImpressionListener);
    }
}
