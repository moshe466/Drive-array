package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdqg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzdqf zzdqfVar) {
        if ((i >>> 3) == 0) {
            throw zzdse.d();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return b(bArr, i2, zzdqfVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return a(bArr, i2, zzdqfVar) + zzdqfVar.zzhhq;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzdse.d();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = a(bArr, i2, zzdqfVar);
            i6 = zzdqfVar.zzhhq;
            if (i6 == i5) {
                break;
            }
            i2 = a(i6, bArr, i2, i3, zzdqfVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzdse.h();
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzdsb<?> zzdsbVar, zzdqf zzdqfVar) {
        zzdrw zzdrwVar = (zzdrw) zzdsbVar;
        int a = a(bArr, i2, zzdqfVar);
        while (true) {
            zzdrwVar.zzgl(zzdqfVar.zzhhq);
            if (a >= i3) {
                break;
            }
            int a2 = a(bArr, a, zzdqfVar);
            if (i != zzdqfVar.zzhhq) {
                break;
            }
            a = a(bArr, a2, zzdqfVar);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzdur zzdurVar, zzdqf zzdqfVar) {
        if ((i >>> 3) == 0) {
            throw zzdse.d();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int b = b(bArr, i2, zzdqfVar);
            zzdurVar.a(i, Long.valueOf(zzdqfVar.zzhhr));
            return b;
        }
        if (i4 == 1) {
            zzdurVar.a(i, Long.valueOf(b(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int a = a(bArr, i2, zzdqfVar);
            int i5 = zzdqfVar.zzhhq;
            if (i5 < 0) {
                throw zzdse.b();
            }
            if (i5 > bArr.length - a) {
                throw zzdse.a();
            }
            zzdurVar.a(i, i5 == 0 ? zzdqk.zzhhx : zzdqk.zzi(bArr, a, i5));
            return a + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzdse.d();
            }
            zzdurVar.a(i, Integer.valueOf(a(bArr, i2)));
            return i2 + 4;
        }
        zzdur a2 = zzdur.a();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int a3 = a(bArr, i2, zzdqfVar);
            int i8 = zzdqfVar.zzhhq;
            i7 = i8;
            if (i8 == i6) {
                i2 = a3;
                break;
            }
            int a4 = a(i7, bArr, a3, i3, a2, zzdqfVar);
            i7 = i8;
            i2 = a4;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzdse.h();
        }
        zzdurVar.a(i, a2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, zzdqf zzdqfVar) {
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
                                zzdqfVar.zzhhq = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            zzdqfVar.zzhhq = i7 | i3;
            return i8;
        }
        i4 = b << 7;
        zzdqfVar.zzhhq = i5 | i4;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzdua<?> zzduaVar, int i, byte[] bArr, int i2, int i3, zzdsb<?> zzdsbVar, zzdqf zzdqfVar) {
        int a = a(zzduaVar, bArr, i2, i3, zzdqfVar);
        while (true) {
            zzdsbVar.add(zzdqfVar.zzhhs);
            if (a >= i3) {
                break;
            }
            int a2 = a(bArr, a, zzdqfVar);
            if (i != zzdqfVar.zzhhq) {
                break;
            }
            a = a(zzduaVar, bArr, a2, i3, zzdqfVar);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzdua zzduaVar, byte[] bArr, int i, int i2, int i3, zzdqf zzdqfVar) {
        zzdti zzdtiVar = (zzdti) zzduaVar;
        Object newInstance = zzdtiVar.newInstance();
        int a = zzdtiVar.a(newInstance, bArr, i, i2, i3, zzdqfVar);
        zzdtiVar.zzan(newInstance);
        zzdqfVar.zzhhs = newInstance;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzdua zzduaVar, byte[] bArr, int i, int i2, zzdqf zzdqfVar) {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = a(i4, bArr, i3, zzdqfVar);
            i4 = zzdqfVar.zzhhq;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzdse.a();
        }
        Object newInstance = zzduaVar.newInstance();
        int i6 = i4 + i5;
        zzduaVar.zza(newInstance, bArr, i5, i6, zzdqfVar);
        zzduaVar.zzan(newInstance);
        zzdqfVar.zzhhs = newInstance;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, zzdqf zzdqfVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return a(b, bArr, i2, zzdqfVar);
        }
        zzdqfVar.zzhhq = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, zzdsb<?> zzdsbVar, zzdqf zzdqfVar) {
        zzdrw zzdrwVar = (zzdrw) zzdsbVar;
        int a = a(bArr, i, zzdqfVar);
        int i2 = zzdqfVar.zzhhq + a;
        while (a < i2) {
            a = a(bArr, a, zzdqfVar);
            zzdrwVar.zzgl(zzdqfVar.zzhhq);
        }
        if (a == i2) {
            return a;
        }
        throw zzdse.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, zzdqf zzdqfVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzdqfVar.zzhhr = j;
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
        zzdqfVar.zzhhr = j2;
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
    public static int c(byte[] bArr, int i, zzdqf zzdqfVar) {
        int a = a(bArr, i, zzdqfVar);
        int i2 = zzdqfVar.zzhhq;
        if (i2 < 0) {
            throw zzdse.b();
        }
        if (i2 == 0) {
            zzdqfVar.zzhhs = "";
            return a;
        }
        zzdqfVar.zzhhs = new String(bArr, a, i2, zzdrv.a);
        return a + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, zzdqf zzdqfVar) {
        int a = a(bArr, i, zzdqfVar);
        int i2 = zzdqfVar.zzhhq;
        if (i2 < 0) {
            throw zzdse.b();
        }
        if (i2 == 0) {
            zzdqfVar.zzhhs = "";
            return a;
        }
        zzdqfVar.zzhhs = zzdva.a(bArr, a, i2);
        return a + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, zzdqf zzdqfVar) {
        int a = a(bArr, i, zzdqfVar);
        int i2 = zzdqfVar.zzhhq;
        if (i2 < 0) {
            throw zzdse.b();
        }
        if (i2 > bArr.length - a) {
            throw zzdse.a();
        }
        if (i2 == 0) {
            zzdqfVar.zzhhs = zzdqk.zzhhx;
            return a;
        }
        zzdqfVar.zzhhs = zzdqk.zzi(bArr, a, i2);
        return a + i2;
    }
}
