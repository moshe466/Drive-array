package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcfl implements zzdxg<zzdhe<zzaqk>> {
    private final zzdxp<zzavu> zzemi;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<zzdcr> zzfet;
    private final zzdxp<String> zzfrr;
    private final zzdxp<zzdhe<Bundle>> zzfuo;
    private final zzdxp<ApplicationInfo> zzfup;
    private final zzdxp<List<String>> zzfuq;
    private final zzdxp<PackageInfo> zzfur;
    private final zzdxp<zzdhe<String>> zzfus;
    private final zzdxp<String> zzfut;

    private zzcfl(zzdxp<zzdcr> zzdxpVar, zzdxp<zzdhe<Bundle>> zzdxpVar2, zzdxp<zzazb> zzdxpVar3, zzdxp<ApplicationInfo> zzdxpVar4, zzdxp<String> zzdxpVar5, zzdxp<List<String>> zzdxpVar6, zzdxp<PackageInfo> zzdxpVar7, zzdxp<zzdhe<String>> zzdxpVar8, zzdxp<zzavu> zzdxpVar9, zzdxp<String> zzdxpVar10) {
        this.zzfet = zzdxpVar;
        this.zzfuo = zzdxpVar2;
        this.zzfdb = zzdxpVar3;
        this.zzfup = zzdxpVar4;
        this.zzfrr = zzdxpVar5;
        this.zzfuq = zzdxpVar6;
        this.zzfur = zzdxpVar7;
        this.zzfus = zzdxpVar8;
        this.zzemi = zzdxpVar9;
        this.zzfut = zzdxpVar10;
    }

    public static zzcfl zza(zzdxp<zzdcr> zzdxpVar, zzdxp<zzdhe<Bundle>> zzdxpVar2, zzdxp<zzazb> zzdxpVar3, zzdxp<ApplicationInfo> zzdxpVar4, zzdxp<String> zzdxpVar5, zzdxp<List<String>> zzdxpVar6, zzdxp<PackageInfo> zzdxpVar7, zzdxp<zzdhe<String>> zzdxpVar8, zzdxp<zzavu> zzdxpVar9, zzdxp<String> zzdxpVar10) {
        return new zzcfl(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6, zzdxpVar7, zzdxpVar8, zzdxpVar9, zzdxpVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzdcr zzdcrVar = this.zzfet.get();
        final zzdhe<Bundle> zzdheVar = this.zzfuo.get();
        final zzazb zzazbVar = this.zzfdb.get();
        final ApplicationInfo applicationInfo = this.zzfup.get();
        final String str = this.zzfrr.get();
        final List<String> list = this.zzfuq.get();
        final PackageInfo packageInfo = this.zzfur.get();
        final zzdhe<String> zzdheVar2 = this.zzfus.get();
        final zzavu zzavuVar = this.zzemi.get();
        final String str2 = this.zzfut.get();
        return (zzdhe) zzdxm.zza(zzdcrVar.zza((zzdcr) zzdco.REQUEST_PARCEL, zzdheVar, zzdheVar2).zzb(new Callable(zzdheVar, zzazbVar, applicationInfo, str, list, packageInfo, zzdheVar2, zzavuVar, str2) { // from class: com.google.android.gms.internal.ads.zzcfm
            private final zzazb zzfek;
            private final zzdhe zzfpn;
            private final String zzfru;
            private final ApplicationInfo zzfuu;
            private final List zzfuv;
            private final PackageInfo zzfuw;
            private final zzdhe zzfux;
            private final zzavu zzfuy;
            private final String zzfuz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpn = zzdheVar;
                this.zzfek = zzazbVar;
                this.zzfuu = applicationInfo;
                this.zzfru = str;
                this.zzfuv = list;
                this.zzfuw = packageInfo;
                this.zzfux = zzdheVar2;
                this.zzfuy = zzavuVar;
                this.zzfuz = str2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdhe zzdheVar3 = this.zzfpn;
                zzazb zzazbVar2 = this.zzfek;
                ApplicationInfo applicationInfo2 = this.zzfuu;
                String str3 = this.zzfru;
                List list2 = this.zzfuv;
                PackageInfo packageInfo2 = this.zzfuw;
                zzdhe zzdheVar4 = this.zzfux;
                zzavu zzavuVar2 = this.zzfuy;
                return new zzaqk((Bundle) zzdheVar3.get(), zzazbVar2, applicationInfo2, str3, list2, packageInfo2, (String) zzdheVar4.get(), zzavuVar2.zzvy(), this.zzfuz, null, null);
            }
        }).zzaqg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
