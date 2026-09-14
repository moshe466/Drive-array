package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdjd extends zzdih<zzdlg, zzdlf> {
    private final /* synthetic */ zzdjc zzgzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdjd(zzdjc zzdjcVar, Class cls) {
        super(cls);
        this.zzgzc = zzdjcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ void zzc(zzdlg zzdlgVar) {
        zzdlg zzdlgVar2 = zzdlgVar;
        new zzdjg().zzasg().zzc(zzdlgVar2.zzate());
        new zzdkq().zzasg().zzc(zzdlgVar2.zzatf());
        zzdpo.zzez(zzdlgVar2.zzate().getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlf zzd(zzdlg zzdlgVar) {
        zzdlg zzdlgVar2 = zzdlgVar;
        zzdlj zzd = new zzdjg().zzasg().zzd(zzdlgVar2.zzate());
        return (zzdlf) zzdlf.zzatc().zzb(zzd).zzb(new zzdkq().zzasg().zzd(zzdlgVar2.zzatf())).zzed(0).zzbaf();
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlg zzq(zzdqk zzdqkVar) {
        return zzdlg.zzx(zzdqkVar);
    }
}
