package com.google.android.recaptcha.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlk extends zzln {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzlk(byte[] bArr, int i, int i3) {
        super(null);
        int length = bArr.length;
        if (((length - i3) | i3) >= 0) {
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i3;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i3)));
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzb(byte b4) {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            this.zzd = i + 1;
            bArr[i] = b4;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
        }
    }

    public final void zzc(byte[] bArr, int i, int i3) {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i3);
            this.zzd += i3;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i3)), e4);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzd(int i, boolean z3) {
        zzt(i << 3);
        zzb(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zze(int i, zzle zzleVar) {
        zzt((i << 3) | 2);
        zzt(zzleVar.zzd());
        zzleVar.zzh(this);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzf(int i, int i3) {
        zzt((i << 3) | 5);
        zzg(i3);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzg(int i) {
        try {
            byte[] bArr = this.zzb;
            int i3 = this.zzd;
            int i4 = i3 + 1;
            this.zzd = i4;
            bArr[i3] = (byte) (i & 255);
            int i5 = i3 + 2;
            this.zzd = i5;
            bArr[i4] = (byte) ((i >> 8) & 255);
            int i6 = i3 + 3;
            this.zzd = i6;
            bArr[i5] = (byte) ((i >> 16) & 255);
            this.zzd = i3 + 4;
            bArr[i6] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzh(int i, long j2) {
        zzt((i << 3) | 1);
        zzi(j2);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzi(long j2) {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            int i3 = i + 1;
            this.zzd = i3;
            bArr[i] = (byte) (((int) j2) & 255);
            int i4 = i + 2;
            this.zzd = i4;
            bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
            int i5 = i + 3;
            this.zzd = i5;
            bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
            int i6 = i + 4;
            this.zzd = i6;
            bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
            int i7 = i + 5;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i + 6;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i + 7;
            this.zzd = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.zzd = i + 8;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzj(int i, int i3) {
        zzt(i << 3);
        zzk(i3);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzk(int i) {
        if (i >= 0) {
            zzt(i);
        } else {
            zzv(i);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzl(byte[] bArr, int i, int i3) {
        zzc(bArr, 0, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzm(int i, zzoi zzoiVar, zzow zzowVar) {
        zzt((i << 3) | 2);
        zzt(((zzko) zzoiVar).zza(zzowVar));
        zzowVar.zzj(zzoiVar, this.zza);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzn(int i, zzoi zzoiVar) {
        zzt(11);
        zzs(2, i);
        zzt(26);
        zzt(zzoiVar.zzo());
        zzoiVar.zze(this);
        zzt(12);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzo(int i, zzle zzleVar) {
        zzt(11);
        zzs(2, i);
        zze(3, zzleVar);
        zzt(12);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzp(int i, String str) {
        zzt((i << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) {
        int i = this.zzd;
        try {
            int zzA = zzln.zzA(str.length() * 3);
            int zzA2 = zzln.zzA(str.length());
            if (zzA2 == zzA) {
                int i3 = i + zzA2;
                this.zzd = i3;
                int zzb = zzpv.zzb(str, this.zzb, i3, this.zzc - i3);
                this.zzd = i;
                zzt((zzb - i) - zzA2);
                this.zzd = zzb;
                return;
            }
            zzt(zzpv.zzc(str));
            byte[] bArr = this.zzb;
            int i4 = this.zzd;
            this.zzd = zzpv.zzb(str, bArr, i4, this.zzc - i4);
        } catch (zzpu e4) {
            this.zzd = i;
            zzD(str, e4);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzll(e5);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzr(int i, int i3) {
        zzt((i << 3) | i3);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzs(int i, int i3) {
        zzt(i << 3);
        zzt(i3);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzt(int i) {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr[i3] = (byte) ((i | 128) & 255);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
            }
        }
        byte[] bArr2 = this.zzb;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        bArr2[i4] = (byte) i;
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzu(int i, long j2) {
        zzt(i << 3);
        zzv(j2);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzv(long j2) {
        boolean z3;
        z3 = zzln.zzc;
        if (!z3 || this.zzc - this.zzd < 10) {
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    bArr[i] = (byte) ((((int) j2) | 128) & 255);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
                }
            }
            byte[] bArr2 = this.zzb;
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            bArr2[i3] = (byte) j2;
            return;
        }
        while (true) {
            int i4 = (int) j2;
            if ((j2 & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                zzps.zzn(bArr3, i5, (byte) i4);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i6 = this.zzd;
            this.zzd = i6 + 1;
            zzps.zzn(bArr4, i6, (byte) ((i4 | 128) & 255));
            j2 >>>= 7;
        }
    }
}
