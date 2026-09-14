package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdjo extends zzdih<zzdlw, zzdlv> {
    private final /* synthetic */ zzdjm zzgzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdjo(zzdjm zzdjmVar, Class cls) {
        super(cls);
        this.zzgzf = zzdjmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ void zzc(zzdlw zzdlwVar) {
        zzdpo.zzez(zzdlwVar.getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlv zzd(zzdlw zzdlwVar) {
        return (zzdlv) zzdlv.zzatw().zzag(zzdqk.zzu(zzdpn.zzey(zzdlwVar.getKeySize()))).zzeg(0).zzbaf();
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlw zzq(zzdqk zzdqkVar) {
        return zzdlw.zzaf(zzdqkVar);
    }
}
