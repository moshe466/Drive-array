package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final /* synthetic */ class zzchw implements Callable {
    private final zzchr zzfwx;

    private zzchw(zzchr zzchrVar) {
        this.zzfwx = zzchrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable a(zzchr zzchrVar) {
        return new zzchw(zzchrVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzfwx.getWritableDatabase();
    }
}
