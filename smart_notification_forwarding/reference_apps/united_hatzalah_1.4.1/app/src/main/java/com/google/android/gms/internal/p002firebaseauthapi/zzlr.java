package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlr implements zzlq {
    private final zzjh zza;
    private final int zzb;

    public zzlr(zzjh zzjhVar) {
        this.zza = zzjhVar;
        this.zzb = zzjhVar.zzb();
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
            zzbi zza = zzyr.zza(zzja.zzc().zza(this.zza).zza(zzaaf.zza(bArr, zzbj.zza())).zza());
            bArr3 = zzlm.zza;
            return zza.zza(copyOfRange, bArr3);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
