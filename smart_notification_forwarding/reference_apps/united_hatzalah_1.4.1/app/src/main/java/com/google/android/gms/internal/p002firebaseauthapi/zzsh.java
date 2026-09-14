package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzsh implements zzqz {
    private static final zzix.zza zza = zzix.zza.zza;

    public zzsh(zzqp zzqpVar) {
        if (zza.zza()) {
        } else {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
    }
}
