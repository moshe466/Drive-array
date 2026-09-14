package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbho implements zzcpf {
    private zzbod zzelr;
    private final /* synthetic */ zzbgr zzerr;
    private zzcpj zzezx;

    private zzbho(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpf
    public final /* synthetic */ zzcpf zza(zzcpj zzcpjVar) {
        this.zzezx = (zzcpj) zzdxm.checkNotNull(zzcpjVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpf
    public final zzcpg zzaet() {
        zzdxm.zza(this.zzelr, (Class<zzbod>) zzbod.class);
        zzdxm.zza(this.zzezx, (Class<zzcpj>) zzcpj.class);
        return new zzbhr(this.zzerr, this.zzezx, new zzbnb(), new zzcee(), this.zzelr, new zzdaq());
    }

    @Override // com.google.android.gms.internal.ads.zzcpf
    public final /* synthetic */ zzcpf zzf(zzbod zzbodVar) {
        this.zzelr = (zzbod) zzdxm.checkNotNull(zzbodVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpf
    @Deprecated
    public final /* synthetic */ zzcpf zzf(zzbrm zzbrmVar) {
        zzdxm.checkNotNull(zzbrmVar);
        return this;
    }
}
