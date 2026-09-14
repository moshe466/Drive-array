package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbit implements zzbow {
    private final zzczn zzfbk;
    private final zzczt zzfbl;
    private final zzdda zzfbm;

    public zzbit(zzczt zzcztVar, zzdda zzddaVar) {
        this.zzfbl = zzcztVar;
        this.zzfbm = zzddaVar;
        this.zzfbk = zzcztVar.zzgmi.zzgmf;
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(int i) {
        this.zzfbm.zza(this.zzfbl, null, this.zzfbk.zzdbt);
    }
}
