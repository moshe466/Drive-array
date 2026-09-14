package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* loaded from: classes.dex */
final class zzdp implements Runnable {
    private final /* synthetic */ MotionEvent zzwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdp(zzdi zzdiVar, MotionEvent motionEvent) {
        this.zzwm = motionEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdc zzdcVar;
        zzdcVar = zzdi.zzvc;
        zzdcVar.zza(this.zzwm);
    }
}
