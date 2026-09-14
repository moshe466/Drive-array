package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcfu implements zzdxg<PackageInfo> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<ApplicationInfo> zzfvc;

    private zzcfu(zzdxp<Context> zzdxpVar, zzdxp<ApplicationInfo> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfvc = zzdxpVar2;
    }

    public static zzcfu zzae(zzdxp<Context> zzdxpVar, zzdxp<ApplicationInfo> zzdxpVar2) {
        return new zzcfu(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return zzcfi.zza(this.zzejv.get(), this.zzfvc.get());
    }
}
