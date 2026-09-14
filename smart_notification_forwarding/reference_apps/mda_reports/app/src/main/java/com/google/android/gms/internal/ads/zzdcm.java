package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [O] */
/* loaded from: classes.dex */
public final class zzdcm<O> implements zzdgt<O> {
    private final /* synthetic */ zzdca zzgqi;
    private final /* synthetic */ zzdcj zzgqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdcm(zzdcj zzdcjVar, zzdca zzdcaVar) {
        this.zzgqj = zzdcjVar;
        this.zzgqi = zzdcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void onSuccess(O o) {
        this.zzgqj.a.zzgqb.zzc(this.zzgqi);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        this.zzgqj.a.zzgqb.zza(this.zzgqi, th);
    }
}
