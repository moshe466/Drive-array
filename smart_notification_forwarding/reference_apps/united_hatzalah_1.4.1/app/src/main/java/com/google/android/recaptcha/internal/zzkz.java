package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import e0.a;

/* loaded from: classes.dex */
final class zzkz extends zzlc {
    private final int zzc;

    public zzkz(byte[] bArr, int i, int i3) {
        super(bArr);
        zzle.zzi(0, i3, bArr.length);
        this.zzc = i3;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final byte zza(int i) {
        int i3 = this.zzc;
        if (((i3 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(a.c(i, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(AbstractC0008a.k("Index > length: ", i, i3, ", "));
        }
        return ((zzlc) this).zza[i];
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final byte zzb(int i) {
        return ((zzlc) this).zza[i];
    }

    @Override // com.google.android.recaptcha.internal.zzlc
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final void zze(byte[] bArr, int i, int i3, int i4) {
        System.arraycopy(((zzlc) this).zza, 0, bArr, 0, i4);
    }
}
