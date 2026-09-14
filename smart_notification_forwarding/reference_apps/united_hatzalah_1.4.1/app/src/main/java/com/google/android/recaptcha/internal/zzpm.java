package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzpm {
    private static final zzpm zza = new zzpm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzpm(int i, int[] iArr, Object[] objArr, boolean z3) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z3;
    }

    public static zzpm zzc() {
        return zza;
    }

    public static zzpm zze(zzpm zzpmVar, zzpm zzpmVar2) {
        int i = zzpmVar.zzb + zzpmVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzpmVar.zzc, i);
        System.arraycopy(zzpmVar2.zzc, 0, copyOf, zzpmVar.zzb, zzpmVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzpmVar.zzd, i);
        System.arraycopy(zzpmVar2.zzd, 0, copyOf2, zzpmVar.zzb, zzpmVar2.zzb);
        return new zzpm(i, copyOf, copyOf2, true);
    }

    public static zzpm zzf() {
        return new zzpm(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzpm)) {
            return false;
        }
        zzpm zzpmVar = (zzpm) obj;
        int i = this.zzb;
        if (i == zzpmVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzpmVar.zzc;
            int i3 = 0;
            while (true) {
                if (i3 < i) {
                    if (iArr[i3] != iArr2[i3]) {
                        break;
                    }
                    i3++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzpmVar.zzd;
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
        int i3 = i + 527;
        int[] iArr = this.zzc;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = ((i3 * 31) + i5) * 31;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final int zza() {
        int zzA;
        int zzB;
        int zzA2;
        int i = this.zze;
        if (i == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                int i6 = i5 >>> 3;
                int i7 = i5 & 7;
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 != 2) {
                            if (i7 != 3) {
                                if (i7 == 5) {
                                    ((Integer) this.zzd[i4]).getClass();
                                    zzA2 = zzln.zzA(i6 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(new zznm("Protocol message tag had invalid wire type."));
                                }
                            } else {
                                int zzA3 = zzln.zzA(i6 << 3);
                                zzA = zzA3 + zzA3;
                                zzB = ((zzpm) this.zzd[i4]).zza();
                            }
                        } else {
                            int i8 = i6 << 3;
                            zzle zzleVar = (zzle) this.zzd[i4];
                            int zzA4 = zzln.zzA(i8);
                            int zzd = zzleVar.zzd();
                            i3 = zzln.zzA(zzd) + zzd + zzA4 + i3;
                        }
                    } else {
                        ((Long) this.zzd[i4]).getClass();
                        zzA2 = zzln.zzA(i6 << 3) + 8;
                    }
                    i3 = zzA2 + i3;
                } else {
                    int i9 = i6 << 3;
                    long longValue = ((Long) this.zzd[i4]).longValue();
                    zzA = zzln.zzA(i9);
                    zzB = zzln.zzB(longValue);
                }
                i3 = zzB + zzA + i3;
            }
            this.zze = i3;
            return i3;
        }
        return i;
    }

    public final int zzb() {
        int i = this.zze;
        if (i == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4] >>> 3;
                zzle zzleVar = (zzle) this.zzd[i4];
                int zzA = zzln.zzA(8);
                int zzA2 = zzln.zzA(i5) + zzln.zzA(16);
                int zzA3 = zzln.zzA(24);
                int zzd = zzleVar.zzd();
                i3 += zzA + zzA + zzA2 + AbstractC0008a.d(zzd, zzd, zzA3);
            }
            this.zze = i3;
            return i3;
        }
        return i;
    }

    public final zzpm zzd(zzpm zzpmVar) {
        if (zzpmVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzpmVar.zzb;
        zzm(i);
        System.arraycopy(zzpmVar.zzc, 0, this.zzc, this.zzb, zzpmVar.zzb);
        System.arraycopy(zzpmVar.zzd, 0, this.zzd, this.zzb, zzpmVar.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzg() {
        if (this.zzf) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzok.zzb(sb, i, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i3 = this.zzb;
        iArr[i3] = i;
        this.zzd[i3] = obj;
        this.zzb = i3 + 1;
    }

    public final void zzk(zzpy zzpyVar) {
        for (int i = 0; i < this.zzb; i++) {
            zzpyVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzpy zzpyVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i3 = this.zzc[i];
                Object obj = this.zzd[i];
                int i4 = i3 & 7;
                int i5 = i3 >>> 3;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 5) {
                                    zzpyVar.zzk(i5, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(new zznm("Protocol message tag had invalid wire type."));
                                }
                            } else {
                                zzpyVar.zzF(i5);
                                ((zzpm) obj).zzl(zzpyVar);
                                zzpyVar.zzh(i5);
                            }
                        } else {
                            zzpyVar.zzd(i5, (zzle) obj);
                        }
                    } else {
                        zzpyVar.zzm(i5, ((Long) obj).longValue());
                    }
                } else {
                    zzpyVar.zzt(i5, ((Long) obj).longValue());
                }
            }
        }
    }

    private zzpm() {
        this(0, new int[8], new Object[8], true);
    }
}
