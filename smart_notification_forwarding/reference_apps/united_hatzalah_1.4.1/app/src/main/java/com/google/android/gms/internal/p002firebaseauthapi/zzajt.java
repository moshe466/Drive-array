package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import e0.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzajt extends zzajw {
    private final int zzc;
    private final int zzd;

    public zzajt(byte[] bArr, int i, int i3) {
        super(bArr);
        zzajp.zza(i, i + i3, bArr.length);
        this.zzc = i;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final byte zza(int i) {
        int zzb = zzb();
        if (((zzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(a.c(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(AbstractC0008a.k("Index > length: ", i, zzb, ", "));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final void zza(byte[] bArr, int i, int i3, int i4) {
        System.arraycopy(this.zzb, zze(), bArr, 0, i4);
    }
}
