package io.fabric.sdk.android.services.events;

/* loaded from: classes2.dex */
public interface FileRollOverManager {
    void cancelTimeBasedFileRollOver();

    boolean rollFileOver();

    void scheduleTimeBasedRollOverIfNeeded();
}
