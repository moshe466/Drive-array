package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpa {
    private static final zzpa zza = new zzpa();
    private final Map<String, zzce> zzb = new HashMap();

    public static zzpa zza() {
        return zza;
    }

    private final synchronized void zza(String str, zzce zzceVar) {
        try {
            if (this.zzb.containsKey(str)) {
                if (this.zzb.get(str).equals(zzceVar)) {
                    return;
                }
                throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(this.zzb.get(str)) + "), cannot insert " + String.valueOf(zzceVar));
            }
            this.zzb.put(str, zzceVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zza(Map<String, zzce> map) {
        for (Map.Entry<String, zzce> entry : map.entrySet()) {
            zza(entry.getKey(), entry.getValue());
        }
    }
}
