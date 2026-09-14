package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdkr extends zzdih<zzdlb, zzdky> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkr(zzdkp zzdkpVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ void zzc(zzdlb zzdlbVar) {
        zzdlb zzdlbVar2 = zzdlbVar;
        zzdkp.zza(zzdlbVar2.zzast());
        zzdkp.zzea(zzdlbVar2.getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdky zzd(zzdlb zzdlbVar) {
        zzdlb zzdlbVar2 = zzdlbVar;
        return (zzdky) zzdky.zzasu().zzec(0).zzu(zzdqk.zzu(zzdpn.zzey(zzdlbVar2.getKeySize()))).zzd(zzdlbVar2.zzast()).zzbaf();
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlb zzq(zzdqk zzdqkVar) {
        return zzdlb.zzv(zzdqkVar);
    }
}
