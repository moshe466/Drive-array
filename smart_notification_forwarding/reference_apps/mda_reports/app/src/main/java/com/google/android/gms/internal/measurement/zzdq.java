package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzdt zzdtVar) {
        if ((i >>> 3) == 0) {
            throw zzfo.d();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return b(bArr, i2, zzdtVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return a(bArr, i2, zzdtVar) + zzdtVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzfo.d();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = a(bArr, i2, zzdtVar);
            i6 = zzdtVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = a(i6, bArr, i2, i3, zzdtVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzfo.g();
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzfl<?> zzflVar, zzdt zzdtVar) {
        zzfg zzfgVar = (zzfg) zzflVar;
        int a = a(bArr, i2, zzdtVar);
        while (true) {
            zzfgVar.zzd(zzdtVar.zza);
            if (a >= i3) {
                break;
            }
            int a2 = a(bArr, a, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            a = a(bArr, a2, zzdtVar);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzhy zzhyVar, zzdt zzdtVar) {
        if ((i >>> 3) == 0) {
            throw zzfo.d();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int b = b(bArr, i2, zzdtVar);
            zzhyVar.a(i, Long.valueOf(zzdtVar.zzb));
            return b;
        }
        if (i4 == 1) {
            zzhyVar.a(i, Long.valueOf(b(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int a = a(bArr, i2, zzdtVar);
            int i5 = zzdtVar.zza;
            if (i5 < 0) {
                throw zzfo.b();
            }
            if (i5 > bArr.length - a) {
                throw zzfo.a();
            }
            zzhyVar.a(i, i5 == 0 ? zzdu.zza : zzdu.zza(bArr, a, i5));
            return a + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzfo.d();
            }
            zzhyVar.a(i, Integer.valueOf(a(bArr, i2)));
            return i2 + 4;
        }
        zzhy a2 = zzhy.a();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int a3 = a(bArr, i2, zzdtVar);
            int i8 = zzdtVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = a3;
                break;
            }
            int a4 = a(i7, bArr, a3, i3, a2, zzdtVar);
            i7 = i8;
            i2 = a4;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzfo.g();
        }
        zzhyVar.a(i, a2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, zzdt zzdtVar) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b = bArr[i2];
        if (b < 0) {
            int i7 = i5 | ((b & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b2 = bArr[i6];
            if (b2 >= 0) {
                i3 = b2 << Ascii.SO;
            } else {
                i5 = i7 | ((b2 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b3 = bArr[i8];
                if (b3 >= 0) {
                    i4 = b3 << Ascii.NAK;
                } else {
                    i7 = i5 | ((b3 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b4 = bArr[i6];
                    if (b4 >= 0) {
                        i3 = b4 << Ascii.FS;
                    } else {
                        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                zzdtVar.zza = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            zzdtVar.zza = i7 | i3;
            return i8;
        }
        i4 = b << 7;
        zzdtVar.zza = i5 | i4;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzhd<?> zzhdVar, int i, byte[] bArr, int i2, int i3, zzfl<?> zzflVar, zzdt zzdtVar) {
        int a = a(zzhdVar, bArr, i2, i3, zzdtVar);
        while (true) {
            zzflVar.add(zzdtVar.zzc);
            if (a >= i3) {
                break;
            }
            int a2 = a(bArr, a, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            a = a(zzhdVar, bArr, a2, i3, zzdtVar);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzhd zzhdVar, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) {
        zzgs zzgsVar = (zzgs) zzhdVar;
        Object zza = zzgsVar.zza();
        int a = zzgsVar.a(zza, bArr, i, i2, i3, zzdtVar);
        zzgsVar.zzc((zzgs) zza);
        zzdtVar.zzc = zza;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzhd zzhdVar, byte[] bArr, int i, int i2, zzdt zzdtVar) {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = a(i4, bArr, i3, zzdtVar);
            i4 = zzdtVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzfo.a();
        }
        Object zza = zzhdVar.zza();
        int i6 = i4 + i5;
        zzhdVar.zza(zza, bArr, i5, i6, zzdtVar);
        zzhdVar.zzc(zza);
        zzdtVar.zzc = zza;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, zzdt zzdtVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return a(b, bArr, i2, zzdtVar);
        }
        zzdtVar.zza = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, zzfl<?> zzflVar, zzdt zzdtVar) {
        zzfg zzfgVar = (zzfg) zzflVar;
        int a = a(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza + a;
        while (a < i2) {
            a = a(bArr, a, zzdtVar);
            zzfgVar.zzd(zzdtVar.zza);
        }
        if (a == i2) {
            return a;
        }
        throw zzfo.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, zzdt zzdtVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzdtVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzdtVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(b(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(byte[] bArr, int i, zzdt zzdtVar) {
        int a = a(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 < 0) {
            throw zzfo.b();
        }
        if (i2 == 0) {
            zzdtVar.zzc = "";
            return a;
        }
        zzdtVar.zzc = new String(bArr, a, i2, zzff.a);
        return a + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, zzdt zzdtVar) {
        int a = a(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 < 0) {
            throw zzfo.b();
        }
        if (i2 == 0) {
            zzdtVar.zzc = "";
            return a;
        }
        zzdtVar.zzc = zzie.a(bArr, a, i2);
        return a + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, zzdt zzdtVar) {
        int a = a(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 < 0) {
            throw zzfo.b();
        }
        if (i2 > bArr.length - a) {
            throw zzfo.a();
        }
        if (i2 == 0) {
            zzdtVar.zzc = zzdu.zza;
            return a;
        }
        zzdtVar.zzc = zzdu.zza(bArr, a, i2);
        return a + i2;
    }
}
