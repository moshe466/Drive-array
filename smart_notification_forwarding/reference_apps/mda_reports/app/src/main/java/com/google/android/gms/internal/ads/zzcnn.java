package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class zzcnn implements com.google.android.gms.ads.internal.zze {
    private final /* synthetic */ zzczt zzgav;
    private final /* synthetic */ zzczl zzgaw;
    private final /* synthetic */ zzazl zzgbu;
    private final /* synthetic */ zzcnt zzgbv;
    private final /* synthetic */ zzcnl zzgbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnn(zzcnl zzcnlVar, zzazl zzazlVar, zzczt zzcztVar, zzczl zzczlVar, zzcnt zzcntVar) {
        this.zzgbw = zzcnlVar;
        this.zzgbu = zzazlVar;
        this.zzgav = zzcztVar;
        this.zzgaw = zzczlVar;
        this.zzgbv = zzcntVar;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzg(View view) {
        zzcnq zzcnqVar;
        zzazl zzazlVar = this.zzgbu;
        zzcnqVar = this.zzgbw.zzgbr;
        zzazlVar.set(zzcnqVar.zza(this.zzgav, this.zzgaw, view, this.zzgbv));
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjr() {
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjs() {
    }
}
