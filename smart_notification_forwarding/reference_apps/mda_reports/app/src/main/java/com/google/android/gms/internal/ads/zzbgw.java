package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbgw implements zzbjz {
    private zzbod zzelr;
    private zzczt zzelt;
    private final /* synthetic */ zzbgr zzerr;
    private zzbrm zzers;
    private zzcxw zzert;

    private zzbgw(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjz
    @Deprecated
    public final /* synthetic */ zzbjz zza(zzbkf zzbkfVar) {
        zzdxm.checkNotNull(zzbkfVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzbka> zza(zzcxw zzcxwVar) {
        this.zzert = zzcxwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzbka> zza(zzczt zzcztVar) {
        this.zzelt = zzcztVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzbka zzadg() {
        zzdxm.zza(this.zzers, (Class<zzbrm>) zzbrm.class);
        zzdxm.zza(this.zzelr, (Class<zzbod>) zzbod.class);
        return new zzbgz(this.zzerr, new zzbnb(), new zzdai(), new zzbny(), new zzcee(), this.zzers, this.zzelr, new zzdaq(), this.zzelt, this.zzert);
    }

    @Override // com.google.android.gms.internal.ads.zzbjz
    public final /* synthetic */ zzbjz zzb(zzbod zzbodVar) {
        this.zzelr = (zzbod) zzdxm.checkNotNull(zzbodVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbjz
    public final /* synthetic */ zzbjz zzb(zzbrm zzbrmVar) {
        this.zzers = (zzbrm) zzdxm.checkNotNull(zzbrmVar);
        return this;
    }
}
