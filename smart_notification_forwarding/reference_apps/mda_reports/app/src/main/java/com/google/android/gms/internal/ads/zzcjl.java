package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
final class zzcjl extends zzamv {
    private zzcip<zzani, zzcjy> zzfyr;
    private final /* synthetic */ zzcjk zzfys;

    private zzcjl(zzcjk zzcjkVar, zzcip<zzani, zzcjy> zzcipVar) {
        this.zzfys = zzcjkVar;
        this.zzfyr = zzcipVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamw
    public final void zzdl(String str) {
        this.zzfyr.zzfyf.onAdFailedToLoad(0);
    }

    @Override // com.google.android.gms.internal.ads.zzamw
    public final void zzx(IObjectWrapper iObjectWrapper) {
        zzcjk.a(this.zzfys, (View) ObjectWrapper.unwrap(iObjectWrapper));
        this.zzfyr.zzfyf.onAdLoaded();
    }
}
