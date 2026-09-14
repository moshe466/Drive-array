package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* loaded from: classes.dex */
final class zzdo implements Runnable {
    private final /* synthetic */ int zzwj;
    private final /* synthetic */ int zzwk;
    private final /* synthetic */ int zzwl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdo(zzdi zzdiVar, int i, int i2, int i3) {
        this.zzwj = i;
        this.zzwk = i2;
        this.zzwl = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdc zzdcVar;
        zzdcVar = zzdi.zzvc;
        zzdcVar.zza(MotionEvent.obtain(0L, this.zzwj, 0, this.zzwk, this.zzwl, 0));
    }
}
