package com.google.android.gms.internal.auth;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzgz {
    private static final zzgz zza = new zzgz(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzgz(int i, int[] iArr, Object[] objArr, boolean z3) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z3;
    }

    public static zzgz zza() {
        return zza;
    }

    public static zzgz zzb(zzgz zzgzVar, zzgz zzgzVar2) {
        int i = zzgzVar.zzb + zzgzVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzgzVar.zzc, i);
        System.arraycopy(zzgzVar2.zzc, 0, copyOf, zzgzVar.zzb, zzgzVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgzVar.zzd, i);
        System.arraycopy(zzgzVar2.zzd, 0, copyOf2, zzgzVar.zzb, zzgzVar2.zzb);
        return new zzgz(i, copyOf, copyOf2, true);
    }

    public static zzgz zzc() {
        return new zzgz(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgz)) {
            return false;
        }
        zzgz zzgzVar = (zzgz) obj;
        int i = this.zzb;
        if (i == zzgzVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgzVar.zzc;
            int i3 = 0;
            while (true) {
                if (i3 < i) {
                    if (iArr[i3] != iArr2[i3]) {
                        break;
                    }
                    i3++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgzVar.zzd;
                    int i4 = this.zzb;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i3 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final void zzd() {
        this.zze = false;
    }

    public final void zze(StringBuilder sb, int i) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzfy.zzb(sb, i, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    public final void zzf(int i, Object obj) {
        int i3;
        if (this.zze) {
            int i4 = this.zzb;
            int[] iArr = this.zzc;
            if (i4 == iArr.length) {
                if (i4 < 4) {
                    i3 = 8;
                } else {
                    i3 = i4 >> 1;
                }
                int i5 = i4 + i3;
                this.zzc = Arrays.copyOf(iArr, i5);
                this.zzd = Arrays.copyOf(this.zzd, i5);
            }
            int[] iArr2 = this.zzc;
            int i6 = this.zzb;
            iArr2[i6] = i;
            this.zzd[i6] = obj;
            this.zzb = i6 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    private zzgz() {
        this(0, new int[8], new Object[8], true);
    }
}
