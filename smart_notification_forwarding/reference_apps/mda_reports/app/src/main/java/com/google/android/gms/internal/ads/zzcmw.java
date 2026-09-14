package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
final class zzcmw extends zzary {
    private final /* synthetic */ zzbqj zzgaz;
    private final /* synthetic */ zzboq zzgba;
    private final /* synthetic */ zzbpm zzgbb;
    private final /* synthetic */ zzbte zzgbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcmw(zzcms zzcmsVar, zzbqj zzbqjVar, zzboq zzboqVar, zzbpm zzbpmVar, zzbte zzbteVar) {
        this.zzgaz = zzbqjVar;
        this.zzgba = zzboqVar;
        this.zzgbb = zzbpmVar;
        this.zzgbc = zzbteVar;
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(IObjectWrapper iObjectWrapper, zzasd zzasdVar) {
        this.zzgbc.zza(zzasdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.zzgaz.zztf();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgbc.zzrs();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgaz.zzte();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgba.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgbb.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.zzgbb.onRewardedVideoCompleted();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }
}
