package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zzbqq implements Runnable {
    private final WeakReference<zzbqp> zzfhv;

    private zzbqq(zzbqp zzbqpVar) {
        this.zzfhv = new WeakReference<>(zzbqpVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbqp zzbqpVar = this.zzfhv.get();
        if (zzbqpVar != null) {
            zzbqp.a(zzbqpVar);
        }
    }
}
