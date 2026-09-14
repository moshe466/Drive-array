package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbhg implements zzbus {
    private zzbod zzelr;
    private zzczt zzelt;
    private final /* synthetic */ zzbgr zzerr;
    private zzbrm zzers;
    private zzcxw zzert;
    private zzcns zzexc;

    private zzbhg(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzbup> zza(zzcxw zzcxwVar) {
        this.zzert = zzcxwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzbup> zza(zzczt zzcztVar) {
        this.zzelt = zzcztVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    /* renamed from: zzaek, reason: merged with bridge method [inline-methods] */
    public final zzbup zzadg() {
        zzdxm.zza(this.zzers, (Class<zzbrm>) zzbrm.class);
        zzdxm.zza(this.zzelr, (Class<zzbod>) zzbod.class);
        zzdxm.zza(this.zzexc, (Class<zzcns>) zzcns.class);
        return new zzbhj(this.zzerr, new zzbnb(), new zzdai(), new zzbny(), new zzcee(), this.zzers, this.zzelr, new zzdaq(), this.zzexc, this.zzelt, this.zzert);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final /* synthetic */ zzbus zzb(zzcns zzcnsVar) {
        this.zzexc = (zzcns) zzdxm.checkNotNull(zzcnsVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final /* synthetic */ zzbus zzd(zzbod zzbodVar) {
        this.zzelr = (zzbod) zzdxm.checkNotNull(zzbodVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final /* synthetic */ zzbus zzd(zzbrm zzbrmVar) {
        this.zzers = (zzbrm) zzdxm.checkNotNull(zzbrmVar);
        return this;
    }
}
