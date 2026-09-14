package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class zzdn {
    public static zzdj zza(zzdj zzdjVar) {
        if (!(zzdjVar instanceof zzdl)) {
            if (zzdjVar instanceof zzdk) {
                return zzdjVar;
            }
            if (zzdjVar instanceof Serializable) {
                return new zzdk(zzdjVar);
            }
            return new zzdl(zzdjVar);
        }
        return zzdjVar;
    }

    public static zzdj zzb(Object obj) {
        return new zzdm(obj);
    }
}
