package io.fabric.sdk.android.services.concurrency;

/* loaded from: classes2.dex */
public interface PriorityProvider<T> extends Comparable<T> {
    Priority getPriority();
}
