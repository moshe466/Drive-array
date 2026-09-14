package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes.dex */
public final class zzcsy implements zzdxg<zzcsz> {
    private final zzdxp<PackageInfo> zzfur;
    private final zzdxp<ApplicationInfo> zzfvc;

    private zzcsy(zzdxp<ApplicationInfo> zzdxpVar, zzdxp<PackageInfo> zzdxpVar2) {
        this.zzfvc = zzdxpVar;
        this.zzfur = zzdxpVar2;
    }

    public static zzcsy zzar(zzdxp<ApplicationInfo> zzdxpVar, zzdxp<PackageInfo> zzdxpVar2) {
        return new zzcsy(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcsz(this.zzfvc.get(), this.zzfur.get());
    }
}
