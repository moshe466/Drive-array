package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcsz implements zzcty<Bundle>, zzcub<zzcty<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsz(ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo;
        this.zzdip = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcty<Bundle>> zzanc() {
        return zzdgs.zzaj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdip;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
    }
}
