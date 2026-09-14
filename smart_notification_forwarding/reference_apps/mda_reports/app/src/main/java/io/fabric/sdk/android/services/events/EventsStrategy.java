package io.fabric.sdk.android.services.events;

/* loaded from: classes2.dex */
public interface EventsStrategy<T> extends FileRollOverManager, EventsManager<T> {
    FilesSender getFilesSender();
}
