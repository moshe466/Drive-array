package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlp implements zzlq {
    private final zzdk zza;
    private final int zzb;

    public zzlp(zzdk zzdkVar) {
        this.zza = zzdkVar;
        this.zzb = zzdkVar.zzc() + zzdkVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3;
        if (bArr2.length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr2, i, bArr2.length);
            zzbe zza = zzze.zza(zzdd.zze().zza(this.zza).zza(zzaaf.zza(Arrays.copyOf(bArr, this.zza.zzb()), zzbj.zza())).zzb(zzaaf.zza(Arrays.copyOfRange(bArr, this.zza.zzb(), this.zza.zzc() + this.zza.zzb()), zzbj.zza())).zza());
            bArr3 = zzlm.zza;
            return zza.zza(copyOfRange, bArr3);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
