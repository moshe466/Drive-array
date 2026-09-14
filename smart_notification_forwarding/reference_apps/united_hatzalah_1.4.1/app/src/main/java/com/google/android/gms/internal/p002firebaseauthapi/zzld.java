package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class zzld implements zzbh {
    private final zzpo<zzla> zza;
    private final zzon zzb;

    public zzld(zzpo<zzla> zzpoVar, zzon zzonVar) {
        this.zza = zzpoVar;
        this.zzb = zzonVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        for (zzla zzlaVar : this.zza.zza(bArr)) {
            try {
                byte[] zza = zzlaVar.zza.zza(bArr, bArr2);
                this.zzb.zza(zzlaVar.zzb, bArr.length);
                return zza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
