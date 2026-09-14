package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.ProviderException;
import javax.crypto.BadPaddingException;

/* loaded from: classes.dex */
public final class zzne implements zzbe {
    private static final String zza = "zzne";
    private final zzbe zzb;

    public zzne(String str) {
        this.zzb = zznc.zza(str);
    }

    private static void zza() {
        try {
            Thread.sleep((int) (Math.random() * 100.0d));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        try {
            return this.zzb.zzb(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException unused) {
            zza();
            return this.zzb.zzb(bArr, bArr2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        try {
            return this.zzb.zza(bArr, bArr2);
        } catch (BadPaddingException e4) {
            throw e4;
        } catch (GeneralSecurityException | ProviderException unused) {
            zza();
            return this.zzb.zza(bArr, bArr2);
        }
    }
}
