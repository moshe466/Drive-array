package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class EnabledEventsStrategy<T> implements EventsStrategy<T> {
    protected final Context a;
    protected final EventsFilesManager<T> b;
    final ScheduledExecutorService c;
    volatile int e = -1;
    final AtomicReference<ScheduledFuture<?>> d = new AtomicReference<>();

    public EnabledEventsStrategy(Context context, ScheduledExecutorService scheduledExecutorService, EventsFilesManager<T> eventsFilesManager) {
        this.a = context;
        this.c = scheduledExecutorService;
        this.b = eventsFilesManager;
    }

    void a() {
        FilesSender filesSender = getFilesSender();
        if (filesSender == null) {
            CommonUtils.logControlled(this.a, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.logControlled(this.a, "Sending all files");
        List<File> batchOfFilesToSend = this.b.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            try {
                CommonUtils.logControlled(this.a, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(batchOfFilesToSend.size())));
                boolean send = filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.b.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                } else {
                    batchOfFilesToSend = this.b.getBatchOfFilesToSend();
                }
            } catch (Exception e) {
                CommonUtils.logControlledError(this.a, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
            }
        }
        if (i == 0) {
            this.b.deleteOldestInRollOverIfOverMax();
        }
    }

    void a(long j, long j2) {
        if (this.d.get() == null) {
            TimeBasedFileRollOverRunnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.a, this);
            CommonUtils.logControlled(this.a, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.d.set(this.c.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.logControlledError(this.a, "Failed to schedule time based file roll over", e);
            }
        }
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    public void cancelTimeBasedFileRollOver() {
        if (this.d.get() != null) {
            CommonUtils.logControlled(this.a, "Cancelling time-based rollover because no events are currently being generated.");
            this.d.get().cancel(false);
            this.d.set(null);
        }
    }

    @Override // io.fabric.sdk.android.services.events.EventsManager
    public void deleteAllEvents() {
        this.b.deleteAllEventsFiles();
    }

    public int getRollover() {
        return this.e;
    }

    @Override // io.fabric.sdk.android.services.events.EventsManager
    public void recordEvent(T t) {
        CommonUtils.logControlled(this.a, t.toString());
        try {
            this.b.writeEvent(t);
        } catch (IOException e) {
            CommonUtils.logControlledError(this.a, "Failed to write event.", e);
        }
        scheduleTimeBasedRollOverIfNeeded();
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    public boolean rollFileOver() {
        try {
            return this.b.rollFileOver();
        } catch (IOException e) {
            CommonUtils.logControlledError(this.a, "Failed to roll file over.", e);
            return false;
        }
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.e != -1) {
            a(this.e, this.e);
        }
    }

    @Override // io.fabric.sdk.android.services.events.EventsManager
    public void sendEvents() {
        a();
    }
}
