package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public abstract class EventsHandler<T> implements EventsStorageListener {
    protected final Context a;
    protected final ScheduledExecutorService b;
    protected EventsStrategy<T> c;

    public EventsHandler(Context context, EventsStrategy<T> eventsStrategy, EventsFilesManager eventsFilesManager, ScheduledExecutorService scheduledExecutorService) {
        this.a = context.getApplicationContext();
        this.b = scheduledExecutorService;
        this.c = eventsStrategy;
        eventsFilesManager.registerRollOverListener(this);
    }

    protected abstract EventsStrategy<T> a();

    protected void a(Runnable runnable) {
        try {
            this.b.submit(runnable);
        } catch (Exception e) {
            CommonUtils.logControlledError(this.a, "Failed to submit events task", e);
        }
    }

    protected void b(Runnable runnable) {
        try {
            this.b.submit(runnable).get();
        } catch (Exception e) {
            CommonUtils.logControlledError(this.a, "Failed to run events task", e);
        }
    }

    public void disable() {
        a(new Runnable() { // from class: io.fabric.sdk.android.services.events.EventsHandler.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsStrategy<T> eventsStrategy = EventsHandler.this.c;
                    EventsHandler.this.c = EventsHandler.this.a();
                    eventsStrategy.deleteAllEvents();
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.a, "Failed to disable events.", e);
                }
            }
        });
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorageListener
    public void onRollOver(String str) {
        a(new Runnable() { // from class: io.fabric.sdk.android.services.events.EventsHandler.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.c.sendEvents();
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.a, "Failed to send events files.", e);
                }
            }
        });
    }

    public void recordEventAsync(final T t, final boolean z) {
        a(new Runnable() { // from class: io.fabric.sdk.android.services.events.EventsHandler.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.c.recordEvent(t);
                    if (z) {
                        EventsHandler.this.c.rollFileOver();
                    }
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.a, "Failed to record event.", e);
                }
            }
        });
    }

    public void recordEventSync(final T t) {
        b(new Runnable() { // from class: io.fabric.sdk.android.services.events.EventsHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.c.recordEvent(t);
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.a, "Crashlytics failed to record event", e);
                }
            }
        });
    }
}
