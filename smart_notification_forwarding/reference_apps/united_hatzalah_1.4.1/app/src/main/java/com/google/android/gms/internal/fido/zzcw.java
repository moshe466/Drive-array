package com.google.android.gms.internal.fido;

import F0.AbstractC0008a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzcw extends zzcv {
    protected final byte[] zza;

    public zzcw(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcz) || zzd() != ((zzcz) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzcw) {
            zzcw zzcwVar = (zzcw) obj;
            int zzk = zzk();
            int zzk2 = zzcwVar.zzk();
            if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzcwVar.zzd()) {
                if (zzd <= zzcwVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzcwVar.zza;
                    int zzc = zzc() + zzd;
                    int zzc2 = zzc();
                    int zzc3 = zzcwVar.zzc();
                    while (zzc2 < zzc) {
                        if (bArr[zzc2] != bArr2[zzc3]) {
                            return false;
                        }
                        zzc2++;
                        zzc3++;
                    }
                    return true;
                }
                throw new IllegalArgumentException(AbstractC0008a.k("Ran off end of other: 0, ", zzd, zzcwVar.zzd(), ", "));
            }
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public void zze(byte[] bArr, int i, int i3, int i4) {
        System.arraycopy(this.zza, 0, bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final int zzf(int i, int i3, int i4) {
        byte[] bArr = this.zza;
        int zzc = zzc();
        byte[] bArr2 = zzde.zzd;
        for (int i5 = zzc; i5 < zzc + i4; i5++) {
            i = (i * 31) + bArr[i5];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final zzcz zzg(int i, int i3) {
        int zzj = zzcz.zzj(i, i3, zzd());
        if (zzj == 0) {
            return zzcz.zzb;
        }
        return new zzct(this.zza, zzc() + i, zzj);
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final InputStream zzh() {
        return new ByteArrayInputStream(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final ByteBuffer zzi() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }
}
