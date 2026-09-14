package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzck {
    private static final zzck zza = new zzck();

    private zzck() {
    }

    public static zzck zza() {
        return zza;
    }

    public static zzck zza(zzck zzckVar) {
        if (zzckVar != null) {
            return zzckVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
