package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
final class zziu extends ThreadLocal<Cipher> {
    private static Cipher zza() {
        try {
            Cipher zza = zzzd.zza.zza("AES/GCM-SIV/NoPadding");
            if (!zzhc.zza(zza)) {
                return null;
            }
            return zza;
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* synthetic */ Cipher initialValue() {
        return zza();
    }
}
