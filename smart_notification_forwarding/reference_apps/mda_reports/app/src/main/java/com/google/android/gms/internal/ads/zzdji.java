package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdji extends zzdih<zzdlk, zzdlj> {
    private final /* synthetic */ zzdjg zzgzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdji(zzdjg zzdjgVar, Class cls) {
        super(cls);
        this.zzgzd = zzdjgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ void zzc(zzdlk zzdlkVar) {
        zzdlk zzdlkVar2 = zzdlkVar;
        zzdpo.zzez(zzdlkVar2.getKeySize());
        zzdjg zzdjgVar = this.zzgzd;
        zzdjg.zza(zzdlkVar2.zzath());
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlj zzd(zzdlk zzdlkVar) {
        zzdlk zzdlkVar2 = zzdlkVar;
        return (zzdlj) zzdlj.zzati().zzc(zzdlkVar2.zzath()).zzaa(zzdqk.zzu(zzdpn.zzey(zzdlkVar2.getKeySize()))).zzee(0).zzbaf();
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlk zzq(zzdqk zzdqkVar) {
        return zzdlk.zzz(zzdqkVar);
    }
}
