package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzlc extends zzlb {
    protected final byte[] zza;

    public zzlc(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzle) || zzd() != ((zzle) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzlc) {
            zzlc zzlcVar = (zzlc) obj;
            int zzj = zzj();
            int zzj2 = zzlcVar.zzj();
            if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzlcVar.zzd()) {
                if (zzd <= zzlcVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzlcVar.zza;
                    zzlcVar.zzc();
                    int i = 0;
                    int i3 = 0;
                    while (i < zzd) {
                        if (bArr[i] != bArr2[i3]) {
                            return false;
                        }
                        i++;
                        i3++;
                    }
                    return true;
                }
                throw new IllegalArgumentException(AbstractC0008a.k("Ran off end of other: 0, ", zzd, zzlcVar.zzd(), ", "));
            }
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public void zze(byte[] bArr, int i, int i3, int i4) {
        System.arraycopy(this.zza, 0, bArr, 0, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final int zzf(int i, int i3, int i4) {
        return zznl.zzb(i, this.zza, 0, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final zzle zzg(int i, int i3) {
        int zzi = zzle.zzi(0, i3, zzd());
        if (zzi == 0) {
            return zzle.zzb;
        }
        return new zzkz(this.zza, 0, zzi);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final void zzh(zzkw zzkwVar) {
        ((zzlk) zzkwVar).zzc(this.zza, 0, zzd());
    }
}
