package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class zzis implements zzbe {
    private static final ThreadLocal<Cipher> zza = new zziu();

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher zzb() {
        try {
            Cipher cipher = zza.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e4) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e4);
        }
    }

    public static zzbe zza(zzeb zzebVar) {
        return zzhc.zza(zzebVar, (zzhb<Cipher>) new zzhb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzir
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhb
            public final Object zza() {
                Cipher zzb;
                zzb = zzis.zzb();
                return zzb;
            }
        });
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        throw new NoSuchMethodError();
    }
}
