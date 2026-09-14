package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class zzbdp implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzato zzeev;
    private final /* synthetic */ zzbdl zzeex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdp(zzbdl zzbdlVar, zzato zzatoVar) {
        this.zzeex = zzbdlVar;
        this.zzeev = zzatoVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzeex.zza(view, this.zzeev, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
