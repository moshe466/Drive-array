package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class zzmx implements zzme {
    private final zzly zza;
    private final zzms zzb;

    public zzmx(zzly zzlyVar) {
        zzms zzmwVar;
        this.zza = zzlyVar;
        try {
            zzmwVar = zzmu.zzb();
        } catch (GeneralSecurityException unused) {
            zzmwVar = new zzmw();
        }
        this.zzb = zzmwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzme
    public final byte[] zza(byte[] bArr, zzmh zzmhVar) {
        byte[] zza = this.zzb.zza(zzmhVar.zza().zzb(), bArr);
        byte[] zza2 = zzyt.zza(bArr, zzmhVar.zzb().zzb());
        byte[] zza3 = zzmn.zza(zzmn.zzb);
        zzly zzlyVar = this.zza;
        return zzlyVar.zza(null, zza, "eae_prk", zza2, "shared_secret", zza3, zzlyVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzme
    public final byte[] zza() {
        if (Arrays.equals(this.zza.zzb(), zzmn.zzf)) {
            return zzmn.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
