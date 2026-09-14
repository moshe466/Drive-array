package com.google.android.recaptcha.internal;

import java.util.List;

/* loaded from: classes.dex */
final class zznv {
    public static final List zza(Object obj, long j2) {
        int i;
        zznk zznkVar = (zznk) zzps.zzf(obj, j2);
        if (!zznkVar.zzc()) {
            int size = zznkVar.size();
            if (size == 0) {
                i = 10;
            } else {
                i = size + size;
            }
            zznk zzd = zznkVar.zzd(i);
            zzps.zzs(obj, j2, zzd);
            return zzd;
        }
        return zznkVar;
    }
}
