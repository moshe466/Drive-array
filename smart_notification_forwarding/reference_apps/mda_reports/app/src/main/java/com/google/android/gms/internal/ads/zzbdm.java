package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbdm implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzato zzeev;
    private final /* synthetic */ int zzeew;
    private final /* synthetic */ zzbdl zzeex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdm(zzbdl zzbdlVar, View view, zzato zzatoVar, int i) {
        this.zzeex = zzbdlVar;
        this.val$view = view;
        this.zzeev = zzatoVar;
        this.zzeew = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeex.zza(this.val$view, this.zzeev, this.zzeew - 1);
    }
}
