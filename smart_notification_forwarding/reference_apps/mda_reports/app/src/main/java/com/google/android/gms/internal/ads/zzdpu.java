package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zzdpu extends WeakReference<Throwable> {
    private final int zzhhd;

    public zzdpu(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzhhd = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzdpu.class) {
            if (this == obj) {
                return true;
            }
            zzdpu zzdpuVar = (zzdpu) obj;
            if (this.zzhhd == zzdpuVar.zzhhd && get() == zzdpuVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzhhd;
    }
}
