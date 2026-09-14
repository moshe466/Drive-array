package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbhn implements zzcbh {
    private zzbod zzelr;
    private zzczt zzelt;
    private final /* synthetic */ zzbgr zzerr;
    private zzbrm zzers;
    private zzcxw zzert;

    private zzbhn(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzcbi> zza(zzcxw zzcxwVar) {
        this.zzert = zzcxwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzcbi> zza(zzczt zzcztVar) {
        this.zzelt = zzcztVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    /* renamed from: zzaes, reason: merged with bridge method [inline-methods] */
    public final zzcbi zzadg() {
        zzdxm.zza(this.zzers, (Class<zzbrm>) zzbrm.class);
        zzdxm.zza(this.zzelr, (Class<zzbod>) zzbod.class);
        return new zzbhm(this.zzerr, new zzbnb(), new zzdai(), new zzbny(), new zzcee(), this.zzers, this.zzelr, new zzdaq(), this.zzelt, this.zzert);
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final /* synthetic */ zzcbh zze(zzbod zzbodVar) {
        this.zzelr = (zzbod) zzdxm.checkNotNull(zzbodVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final /* synthetic */ zzcbh zze(zzbrm zzbrmVar) {
        this.zzers = (zzbrm) zzdxm.checkNotNull(zzbrmVar);
        return this;
    }
}
