package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class zzbfc implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzato zzeev;
    private final /* synthetic */ zzbfb zzehv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfc(zzbfb zzbfbVar, zzato zzatoVar) {
        this.zzehv = zzbfbVar;
        this.zzeev = zzatoVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzehv.zza(view, this.zzeev, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
