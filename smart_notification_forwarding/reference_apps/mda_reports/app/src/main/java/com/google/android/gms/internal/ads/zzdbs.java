package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdbs implements zzdxg<zzdhd> {
    private static final zzdbs zzgpq = new zzdbs();

    public static zzdbs zzapw() {
        return zzgpq;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzdhd zzdhdVar;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcpc)).booleanValue()) {
            zzdhdVar = zzazd.zzdwg;
        } else {
            zzdhdVar = ((Boolean) zzve.zzoy().zzd(zzzn.zzcpb)).booleanValue() ? zzazd.zzdwe : zzazd.zzdwi;
        }
        return (zzdhd) zzdxm.zza(zzdhdVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
