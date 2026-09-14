package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final /* synthetic */ class zzcsa implements Callable {
    static final Callable a = new zzcsa();

    private zzcsa() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new zzcry(com.google.android.gms.ads.internal.zzq.zzla().zzwx(), com.google.android.gms.ads.internal.zzq.zzla().zzwy());
    }
}
