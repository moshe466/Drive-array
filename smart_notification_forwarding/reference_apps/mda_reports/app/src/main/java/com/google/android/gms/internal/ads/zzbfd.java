package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbfd implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzato zzeev;
    private final /* synthetic */ int zzeew;
    private final /* synthetic */ zzbfb zzehv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfd(zzbfb zzbfbVar, View view, zzato zzatoVar, int i) {
        this.zzehv = zzbfbVar;
        this.val$view = view;
        this.zzeev = zzatoVar;
        this.zzeew = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzehv.zza(this.val$view, this.zzeev, this.zzeew - 1);
    }
}
