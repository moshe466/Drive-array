package com.google.android.gms.internal.auth;

import F0.AbstractC0008a;
import e0.a;

/* loaded from: classes.dex */
final class zzdy extends zzeb {
    private final int zzc;

    public zzdy(byte[] bArr, int i, int i3) {
        super(bArr);
        zzee.zzi(0, i3, bArr.length);
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.auth.zzeb, com.google.android.gms.internal.auth.zzee
    public final byte zza(int i) {
        int i3 = this.zzc;
        if (((i3 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(a.c(i, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(AbstractC0008a.k("Index > length: ", i, i3, ", "));
        }
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.auth.zzeb, com.google.android.gms.internal.auth.zzee
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzeb, com.google.android.gms.internal.auth.zzee
    public final int zzd() {
        return this.zzc;
    }
}
