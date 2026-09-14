package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzzv {
    public static boolean zza(@Nullable zzaae zzaaeVar, @Nullable zzaac zzaacVar, String... strArr) {
        if (zzaaeVar == null || zzaacVar == null || !zzaaeVar.a || zzaacVar == null) {
            return false;
        }
        return zzaaeVar.zza(zzaacVar, com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime(), strArr);
    }

    @Nullable
    public static zzaac zzb(@Nullable zzaae zzaaeVar) {
        if (zzaaeVar == null) {
            return null;
        }
        return zzaaeVar.zzex(com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime());
    }
}
