package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzann {
    private static final zzann zza = new zzann(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzann() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzann zzc() {
        return zza;
    }

    public static zzann zzd() {
        return new zzann();
    }

    private final void zzf() {
        if (this.zzf) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzann)) {
            return false;
        }
        zzann zzannVar = (zzann) obj;
        int i = this.zzb;
        if (i == zzannVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzannVar.zzc;
            int i3 = 0;
            while (true) {
                if (i3 < i) {
                    if (iArr[i3] != iArr2[i3]) {
                        break;
                    }
                    i3++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzannVar.zzd;
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

    public final int zza() {
        int zze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                zze = zzakg.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                zze = zzakg.zza(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                zze = zzakg.zza(i6, (zzajp) this.zzd[i4]);
            } else if (i7 == 3) {
                i3 = ((zzann) this.zzd[i4]).zza() + (zzakg.zzi(i6) << 1) + i3;
            } else if (i7 == 5) {
                zze = zzakg.zzc(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzalf.zza());
            }
            i3 = zze + i3;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            i3 += zzakg.zzb(this.zzc[i4] >>> 3, (zzajp) this.zzd[i4]);
        }
        this.zze = i3;
        return i3;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzann(int i, int[] iArr, Object[] objArr, boolean z3) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z3;
    }

    public final void zzb(zzaof zzaofVar) {
        if (this.zzb == 0) {
            return;
        }
        if (zzaofVar.zza() == 1) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzaofVar);
            }
            return;
        }
        for (int i3 = this.zzb - 1; i3 >= 0; i3--) {
            zza(this.zzc[i3], this.zzd[i3], zzaofVar);
        }
    }

    public final zzann zza(zzann zzannVar) {
        if (zzannVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzannVar.zzb;
        zza(i);
        System.arraycopy(zzannVar.zzc, 0, this.zzc, this.zzb, zzannVar.zzb);
        System.arraycopy(zzannVar.zzd, 0, this.zzd, this.zzb, zzannVar.zzb);
        this.zzb = i;
        return this;
    }

    public static zzann zza(zzann zzannVar, zzann zzannVar2) {
        int i = zzannVar.zzb + zzannVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzannVar.zzc, i);
        System.arraycopy(zzannVar2.zzc, 0, copyOf, zzannVar.zzb, zzannVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzannVar.zzd, i);
        System.arraycopy(zzannVar2.zzd, 0, copyOf2, zzannVar.zzb, zzannVar2.zzb);
        return new zzann(i, copyOf, copyOf2, true);
    }

    private final void zza(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i3 = this.zzb;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i) {
                i = i4;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final void zza(StringBuilder sb, int i) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzamh.zza(sb, i, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    public final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i3 = this.zzb;
        iArr[i3] = i;
        this.zzd[i3] = obj;
        this.zzb = i3 + 1;
    }

    public final void zza(zzaof zzaofVar) {
        if (zzaofVar.zza() == 2) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzaofVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzaofVar.zza(this.zzc[i3] >>> 3, this.zzd[i3]);
        }
    }

    private static void zza(int i, Object obj, zzaof zzaofVar) {
        int i3 = i >>> 3;
        int i4 = i & 7;
        if (i4 == 0) {
            zzaofVar.zzb(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 1) {
            zzaofVar.zza(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 2) {
            zzaofVar.zza(i3, (zzajp) obj);
            return;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzaofVar.zzb(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzalf.zza());
        }
        if (zzaofVar.zza() == 1) {
            zzaofVar.zzb(i3);
            ((zzann) obj).zzb(zzaofVar);
            zzaofVar.zza(i3);
        } else {
            zzaofVar.zza(i3);
            ((zzann) obj).zzb(zzaofVar);
            zzaofVar.zzb(i3);
        }
    }
}
