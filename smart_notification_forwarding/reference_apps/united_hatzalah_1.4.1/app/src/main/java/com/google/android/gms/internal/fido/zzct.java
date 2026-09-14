package com.google.android.gms.internal.fido;

import F0.AbstractC0008a;
import e0.a;

/* loaded from: classes.dex */
final class zzct extends zzcw {
    private final int zzc;
    private final int zzd;

    public zzct(byte[] bArr, int i, int i3) {
        super(bArr);
        zzcz.zzj(i, i + i3, bArr.length);
        this.zzc = i;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zza(int i) {
        int i3 = this.zzd;
        if (((i3 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(a.c(i, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(AbstractC0008a.k("Index > length: ", i, i3, ", "));
        }
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.fido.zzcw
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final void zze(byte[] bArr, int i, int i3, int i4) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i4);
    }
}
