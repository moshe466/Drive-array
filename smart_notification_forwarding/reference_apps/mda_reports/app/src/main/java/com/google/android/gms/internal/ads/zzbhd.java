package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbhd implements zzblf {
    private zzbod zzelr;
    private zzczt zzelt;
    private zzbvi zzelu;
    private final /* synthetic */ zzbgr zzerr;
    private zzbrm zzers;
    private zzcxw zzert;
    private zzcns zzexc;
    private zzbma zzexd;
    private zzbkf zzexe;

    private zzbhd(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf zza(zzbma zzbmaVar) {
        this.zzexd = (zzbma) zzdxm.checkNotNull(zzbmaVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf zza(zzcns zzcnsVar) {
        this.zzexc = (zzcns) zzdxm.checkNotNull(zzcnsVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzblg> zza(zzcxw zzcxwVar) {
        this.zzert = zzcxwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe<zzblg> zza(zzczt zzcztVar) {
        this.zzelt = zzcztVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    /* renamed from: zzaee, reason: merged with bridge method [inline-methods] */
    public final zzblg zzadg() {
        zzdxm.zza(this.zzers, (Class<zzbrm>) zzbrm.class);
        zzdxm.zza(this.zzelr, (Class<zzbod>) zzbod.class);
        zzdxm.zza(this.zzexc, (Class<zzcns>) zzcns.class);
        zzdxm.zza(this.zzexd, (Class<zzbma>) zzbma.class);
        zzdxm.zza(this.zzexe, (Class<zzbkf>) zzbkf.class);
        zzdxm.zza(this.zzelu, (Class<zzbvi>) zzbvi.class);
        return new zzbhc(this.zzerr, this.zzexe, this.zzelu, new zzbnb(), new zzdai(), new zzbny(), new zzcee(), this.zzers, this.zzelr, new zzdaq(), this.zzexc, this.zzexd, this.zzelt, this.zzert);
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf zzb(zzbkf zzbkfVar) {
        this.zzexe = (zzbkf) zzdxm.checkNotNull(zzbkfVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf zzb(zzbvi zzbviVar) {
        this.zzelu = (zzbvi) zzdxm.checkNotNull(zzbviVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf zzc(zzbod zzbodVar) {
        this.zzelr = (zzbod) zzdxm.checkNotNull(zzbodVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf zzc(zzbrm zzbrmVar) {
        this.zzers = (zzbrm) zzdxm.checkNotNull(zzbrmVar);
        return this;
    }
}
