package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbgt implements zzbvl {
    private zzbod zzelr;
    private zzczt zzelt;
    private zzbvi zzelu;
    private final /* synthetic */ zzbgr zzerr;
    private zzbrm zzers;
    private zzcxw zzert;

    private zzbgt(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzbvm> zza(zzcxw zzcxwVar) {
        this.zzert = zzcxwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzbvm> zza(zzczt zzcztVar) {
        this.zzelt = zzcztVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbvl
    public final /* synthetic */ zzbvl zza(zzbod zzbodVar) {
        this.zzelr = (zzbod) zzdxm.checkNotNull(zzbodVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbvl
    public final /* synthetic */ zzbvl zza(zzbrm zzbrmVar) {
        this.zzers = (zzbrm) zzdxm.checkNotNull(zzbrmVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbvl
    public final /* synthetic */ zzbvl zza(zzbvi zzbviVar) {
        this.zzelu = (zzbvi) zzdxm.checkNotNull(zzbviVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    /* renamed from: zzadf, reason: merged with bridge method [inline-methods] */
    public final zzbvm zzadg() {
        zzdxm.zza(this.zzers, (Class<zzbrm>) zzbrm.class);
        zzdxm.zza(this.zzelr, (Class<zzbod>) zzbod.class);
        zzdxm.zza(this.zzelu, (Class<zzbvi>) zzbvi.class);
        return new zzbgs(this.zzerr, this.zzelu, new zzbnb(), new zzdai(), new zzbny(), new zzcee(), this.zzers, this.zzelr, new zzdaq(), this.zzelt, this.zzert);
    }
}
