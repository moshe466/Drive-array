package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class zzjq implements zzbi {
    private final zzpo<zzjn> zza;
    private final zzon zzb;

    public zzjq(zzjn zzjnVar, zzpo<zzjn> zzpoVar, zzon zzonVar, zzon zzonVar2) {
        this.zza = zzpoVar;
        this.zzb = zzonVar2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        for (zzjn zzjnVar : this.zza.zza(bArr)) {
            try {
                byte[] zza = zzjnVar.zza.zza(bArr, bArr2);
                this.zzb.zza(zzjnVar.zzb, bArr.length);
                return zza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
