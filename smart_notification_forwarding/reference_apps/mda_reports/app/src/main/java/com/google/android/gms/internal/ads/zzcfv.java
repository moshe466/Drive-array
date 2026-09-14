package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class zzcfv implements zzdgf<zzaqk, zzczt> {
    private final zzbqs zzfvd;

    public zzcfv(zzbqs zzbqsVar) {
        this.zzfvd = zzbqsVar;
    }

    protected abstract zzdhe<zzczt> zze(zzaqk zzaqkVar);

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final /* synthetic */ zzdhe<zzczt> zzf(zzaqk zzaqkVar) {
        zzaqk zzaqkVar2 = zzaqkVar;
        this.zzfvd.zzb(zzaqkVar2);
        zzdhe<zzczt> zze = zze(zzaqkVar2);
        zzdgs.zza(zze, new zzcfy(this), zzazd.zzdwj);
        return zze;
    }
}
