package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzdur {
    private static final zzdur zzhrd = new zzdur(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzhhm;
    private int zzhml;
    private Object[] zzhoy;
    private int[] zzhre;

    private zzdur() {
        this(0, new int[8], new Object[8], true);
    }

    private zzdur(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzhml = -1;
        this.count = i;
        this.zzhre = iArr;
        this.zzhoy = objArr;
        this.zzhhm = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdur a() {
        return new zzdur();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdur a(zzdur zzdurVar, zzdur zzdurVar2) {
        int i = zzdurVar.count + zzdurVar2.count;
        int[] copyOf = Arrays.copyOf(zzdurVar.zzhre, i);
        System.arraycopy(zzdurVar2.zzhre, 0, copyOf, zzdurVar.count, zzdurVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzdurVar.zzhoy, i);
        System.arraycopy(zzdurVar2.zzhoy, 0, copyOf2, zzdurVar.count, zzdurVar2.count);
        return new zzdur(i, copyOf, copyOf2, true);
    }

    private static void zzb(int i, Object obj, zzdvl zzdvlVar) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzdvlVar.zzo(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzdvlVar.zzi(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzdvlVar.zza(i2, (zzdqk) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                throw new RuntimeException(zzdse.f());
            }
            zzdvlVar.zzae(i2, ((Integer) obj).intValue());
        } else if (zzdvlVar.zzazg() == zzdrt.zze.zzhnd) {
            zzdvlVar.zzgi(i2);
            ((zzdur) obj).zzb(zzdvlVar);
            zzdvlVar.zzgj(i2);
        } else {
            zzdvlVar.zzgj(i2);
            ((zzdur) obj).zzb(zzdvlVar);
            zzdvlVar.zzgi(i2);
        }
    }

    public static zzdur zzbcf() {
        return zzhrd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, Object obj) {
        if (!this.zzhhm) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.count;
        if (i2 == this.zzhre.length) {
            int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
            this.zzhre = Arrays.copyOf(this.zzhre, i3);
            this.zzhoy = Arrays.copyOf(this.zzhoy, i3);
        }
        int[] iArr = this.zzhre;
        int i4 = this.count;
        iArr[i4] = i;
        this.zzhoy[i4] = obj;
        this.count = i4 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzdvl zzdvlVar) {
        if (zzdvlVar.zzazg() == zzdrt.zze.zzhne) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzdvlVar.zzc(this.zzhre[i] >>> 3, this.zzhoy[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzdvlVar.zzc(this.zzhre[i2] >>> 3, this.zzhoy[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzdtf.a(sb, i, String.valueOf(this.zzhre[i2] >>> 3), this.zzhoy[i2]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzdur)) {
            return false;
        }
        zzdur zzdurVar = (zzdur) obj;
        int i = this.count;
        if (i == zzdurVar.count) {
            int[] iArr = this.zzhre;
            int[] iArr2 = zzdurVar.zzhre;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.zzhoy;
                Object[] objArr2 = zzdurVar.zzhoy;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzhre;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzhoy;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzaxq() {
        this.zzhhm = false;
    }

    public final int zzazu() {
        int zzk;
        int i = this.zzhml;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzhre[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zzk = zzdrb.zzk(i5, ((Long) this.zzhoy[i3]).longValue());
            } else if (i6 == 1) {
                zzk = zzdrb.zzm(i5, ((Long) this.zzhoy[i3]).longValue());
            } else if (i6 == 2) {
                zzk = zzdrb.zzc(i5, (zzdqk) this.zzhoy[i3]);
            } else if (i6 == 3) {
                zzk = (zzdrb.zzfz(i5) << 1) + ((zzdur) this.zzhoy[i3]).zzazu();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzdse.f());
                }
                zzk = zzdrb.zzai(i5, ((Integer) this.zzhoy[i3]).intValue());
            }
            i2 += zzk;
        }
        this.zzhml = i2;
        return i2;
    }

    public final void zzb(zzdvl zzdvlVar) {
        if (this.count == 0) {
            return;
        }
        if (zzdvlVar.zzazg() == zzdrt.zze.zzhnd) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzhre[i], this.zzhoy[i], zzdvlVar);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzhre[i2], this.zzhoy[i2], zzdvlVar);
        }
    }

    public final int zzbch() {
        int i = this.zzhml;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzdrb.zzd(this.zzhre[i3] >>> 3, (zzdqk) this.zzhoy[i3]);
        }
        this.zzhml = i2;
        return i2;
    }
}
