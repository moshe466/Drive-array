package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class zzcnx implements com.google.android.gms.ads.internal.zze {
    private final /* synthetic */ zzbtw zzgcd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnx(zzcnw zzcnwVar, zzbtw zzbtwVar) {
        this.zzgcd = zzbtwVar;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzg(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjr() {
        this.zzgcd.zzadj().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjs() {
        this.zzgcd.zzadk().onAdImpression();
        this.zzgcd.zzadl().zzaia();
    }
}
