package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcdj implements zzbow, zzbqb, zzbqx {
    private final zzcds zzfsm;
    private final zzcdv zzfsn;

    public zzcdj(zzcds zzcdsVar, zzcdv zzcdvVar) {
        this.zzfsm = zzcdsVar;
        this.zzfsn = zzcdvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(int i) {
        this.zzfsn.a(this.zzfsm.zzqu());
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final void onAdLoaded() {
        this.zzfsn.a(this.zzfsm.zzqu());
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzaqk zzaqkVar) {
        this.zzfsm.zzi(zzaqkVar.zzdlu);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzczt zzcztVar) {
        this.zzfsm.zzc(zzcztVar);
    }
}
