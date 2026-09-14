package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpm implements Runnable {
    private final /* synthetic */ zzpg zzbjg;
    private final /* synthetic */ Surface zzbjo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpm(zzpg zzpgVar, Surface surface) {
        this.zzbjg = zzpgVar;
        this.zzbjo = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpd zzpdVar;
        zzpdVar = this.zzbjg.zzbjh;
        zzpdVar.zza(this.zzbjo);
    }
}
