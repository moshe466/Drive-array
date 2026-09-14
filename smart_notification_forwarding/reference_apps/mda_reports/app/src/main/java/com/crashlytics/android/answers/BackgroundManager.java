package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BackgroundManager {
    private static final int BACKGROUND_DELAY = 5000;
    private final ScheduledExecutorService executorService;
    private final List<Listener> listeners = new ArrayList();
    private volatile boolean flushOnBackground = true;
    final AtomicReference<ScheduledFuture<?>> a = new AtomicReference<>();
    boolean b = true;

    /* loaded from: classes.dex */
    public interface Listener {
        void onBackground();
    }

    public BackgroundManager(ScheduledExecutorService scheduledExecutorService) {
        this.executorService = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBackground() {
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onBackground();
        }
    }

    public void onActivityPaused() {
        if (!this.flushOnBackground || this.b) {
            return;
        }
        this.b = true;
        try {
            this.a.compareAndSet(null, this.executorService.schedule(new Runnable() { // from class: com.crashlytics.android.answers.BackgroundManager.1
                @Override // java.lang.Runnable
                public void run() {
                    BackgroundManager.this.a.set(null);
                    BackgroundManager.this.notifyBackground();
                }
            }, 5000L, TimeUnit.MILLISECONDS));
        } catch (RejectedExecutionException e) {
            Fabric.getLogger().d(Answers.TAG, "Failed to schedule background detector", e);
        }
    }

    public void onActivityResumed() {
        this.b = false;
        ScheduledFuture<?> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void setFlushOnBackground(boolean z) {
        this.flushOnBackground = z;
    }
}
