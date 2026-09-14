package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbar extends zzbaj {
    @Override // com.google.android.gms.internal.ads.zzbaj
    @Nullable
    public final zzbag zza(Context context, zzbaz zzbazVar, int i, boolean z, zzaae zzaaeVar, zzbaw zzbawVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        boolean z2 = false;
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbay zzbayVar = new zzbay(context, zzbazVar.zzyr(), zzbazVar.zzyp(), zzaaeVar, zzbazVar.zzym());
        if (Build.VERSION.SDK_INT >= 16 && i == 2) {
            z2 = true;
        }
        return z2 ? new zzbbc(context, zzbayVar, zzbazVar, z, zzbaj.a(zzbazVar), zzbawVar) : new zzazx(context, z, zzbaj.a(zzbazVar), zzbawVar, new zzbay(context, zzbazVar.zzyr(), zzbazVar.zzyp(), zzaaeVar, zzbazVar.zzym()));
    }
}
