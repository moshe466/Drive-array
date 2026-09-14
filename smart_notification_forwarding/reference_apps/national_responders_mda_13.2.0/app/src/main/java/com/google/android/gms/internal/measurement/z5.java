package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, byte[] bArr, int i11, int i12, c6 c6Var) {
        if ((i10 >>> 3) == 0) {
            throw x7.c();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return k(bArr, i11, c6Var);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return i(bArr, i11, c6Var) + c6Var.f5233a;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw x7.c();
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = i(bArr, i11, c6Var);
            i15 = c6Var.f5233a;
            if (i15 == i14) {
                break;
            }
            i11 = a(i15, bArr, i11, i12, c6Var);
        }
        if (i11 > i12 || i15 != i14) {
            throw x7.e();
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i10, byte[] bArr, int i11, int i12, u7<?> u7Var, c6 c6Var) {
        p7 p7Var = (p7) u7Var;
        int i13 = i(bArr, i11, c6Var);
        while (true) {
            p7Var.j(c6Var.f5233a);
            if (i13 >= i12) {
                break;
            }
            int i14 = i(bArr, i13, c6Var);
            if (i10 != c6Var.f5233a) {
                break;
            }
            i13 = i(bArr, i14, c6Var);
        }
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10, byte[] bArr, int i11, int i12, ga gaVar, c6 c6Var) {
        if ((i10 >>> 3) == 0) {
            throw x7.c();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int k10 = k(bArr, i11, c6Var);
            gaVar.c(i10, Long.valueOf(c6Var.f5234b));
            return k10;
        }
        if (i13 == 1) {
            gaVar.c(i10, Long.valueOf(l(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int i14 = i(bArr, i11, c6Var);
            int i15 = c6Var.f5233a;
            if (i15 < 0) {
                throw x7.b();
            }
            if (i15 > bArr.length - i14) {
                throw x7.a();
            }
            gaVar.c(i10, i15 == 0 ? d6.f5256g : d6.t(bArr, i14, i15));
            return i14 + i15;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw x7.c();
            }
            gaVar.c(i10, Integer.valueOf(h(bArr, i11)));
            return i11 + 4;
        }
        ga g10 = ga.g();
        int i16 = (i10 & (-8)) | 4;
        int i17 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int i18 = i(bArr, i11, c6Var);
            int i19 = c6Var.f5233a;
            i17 = i19;
            if (i19 == i16) {
                i11 = i18;
                break;
            }
            int c10 = c(i17, bArr, i18, i12, g10, c6Var);
            i17 = i19;
            i11 = c10;
        }
        if (i11 > i12 || i17 != i16) {
            throw x7.e();
        }
        gaVar.c(i10, g10);
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i10, byte[] bArr, int i11, c6 c6Var) {
        int i12;
        int i13;
        int i14 = i10 & 127;
        int i15 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 < 0) {
            int i16 = i14 | ((b10 & Byte.MAX_VALUE) << 7);
            int i17 = i15 + 1;
            byte b11 = bArr[i15];
            if (b11 >= 0) {
                i12 = b11 << 14;
            } else {
                i14 = i16 | ((b11 & Byte.MAX_VALUE) << 14);
                i15 = i17 + 1;
                byte b12 = bArr[i17];
                if (b12 >= 0) {
                    i13 = b12 << 21;
                } else {
                    i16 = i14 | ((b12 & Byte.MAX_VALUE) << 21);
                    i17 = i15 + 1;
                    byte b13 = bArr[i15];
                    if (b13 >= 0) {
                        i12 = b13 << 28;
                    } else {
                        int i18 = i16 | ((b13 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i19 = i17 + 1;
                            if (bArr[i17] >= 0) {
                                c6Var.f5233a = i18;
                                return i19;
                            }
                            i17 = i19;
                        }
                    }
                }
            }
            c6Var.f5233a = i16 | i12;
            return i17;
        }
        i13 = b10 << 7;
        c6Var.f5233a = i14 | i13;
        return i15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(p9<?> p9Var, int i10, byte[] bArr, int i11, int i12, u7<?> u7Var, c6 c6Var) {
        int g10 = g(p9Var, bArr, i11, i12, c6Var);
        while (true) {
            u7Var.add(c6Var.f5235c);
            if (g10 >= i12) {
                break;
            }
            int i13 = i(bArr, g10, c6Var);
            if (i10 != c6Var.f5233a) {
                break;
            }
            g10 = g(p9Var, bArr, i13, i12, c6Var);
        }
        return g10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(p9 p9Var, byte[] bArr, int i10, int i11, int i12, c6 c6Var) {
        b9 b9Var = (b9) p9Var;
        Object zza = b9Var.zza();
        int n10 = b9Var.n(zza, bArr, i10, i11, i12, c6Var);
        b9Var.d(zza);
        c6Var.f5235c = zza;
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(p9 p9Var, byte[] bArr, int i10, int i11, c6 c6Var) {
        int i12 = i10 + 1;
        int i13 = bArr[i10];
        if (i13 < 0) {
            i12 = d(i13, bArr, i12, c6Var);
            i13 = c6Var.f5233a;
        }
        int i14 = i12;
        if (i13 < 0 || i13 > i11 - i14) {
            throw x7.a();
        }
        Object zza = p9Var.zza();
        int i15 = i13 + i14;
        p9Var.g(zza, bArr, i14, i15, c6Var);
        p9Var.d(zza);
        c6Var.f5235c = zza;
        return i15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(byte[] bArr, int i10, c6 c6Var) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return d(b10, bArr, i11, c6Var);
        }
        c6Var.f5233a = b10;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(byte[] bArr, int i10, u7<?> u7Var, c6 c6Var) {
        p7 p7Var = (p7) u7Var;
        int i11 = i(bArr, i10, c6Var);
        int i12 = c6Var.f5233a + i11;
        while (i11 < i12) {
            i11 = i(bArr, i11, c6Var);
            p7Var.j(c6Var.f5233a);
        }
        if (i11 == i12) {
            return i11;
        }
        throw x7.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(byte[] bArr, int i10, c6 c6Var) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 >= 0) {
            c6Var.f5234b = j10;
            return i11;
        }
        int i12 = i11 + 1;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | ((b10 & Byte.MAX_VALUE) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & Byte.MAX_VALUE) << i13;
            b10 = bArr[i12];
            i12 = i14;
        }
        c6Var.f5234b = j11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long l(byte[] bArr, int i10) {
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double m(byte[] bArr, int i10) {
        return Double.longBitsToDouble(l(bArr, i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(byte[] bArr, int i10, c6 c6Var) {
        int i11 = i(bArr, i10, c6Var);
        int i12 = c6Var.f5233a;
        if (i12 < 0) {
            throw x7.b();
        }
        if (i12 == 0) {
            c6Var.f5235c = "";
            return i11;
        }
        c6Var.f5235c = new String(bArr, i11, i12, o7.f5516a);
        return i11 + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float o(byte[] bArr, int i10) {
        return Float.intBitsToFloat(h(bArr, i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(byte[] bArr, int i10, c6 c6Var) {
        int i11 = i(bArr, i10, c6Var);
        int i12 = c6Var.f5233a;
        if (i12 < 0) {
            throw x7.b();
        }
        if (i12 == 0) {
            c6Var.f5235c = "";
            return i11;
        }
        c6Var.f5235c = qa.k(bArr, i11, i12);
        return i11 + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(byte[] bArr, int i10, c6 c6Var) {
        int i11 = i(bArr, i10, c6Var);
        int i12 = c6Var.f5233a;
        if (i12 < 0) {
            throw x7.b();
        }
        if (i12 > bArr.length - i11) {
            throw x7.a();
        }
        if (i12 == 0) {
            c6Var.f5235c = d6.f5256g;
            return i11;
        }
        c6Var.f5235c = d6.t(bArr, i11, i12);
        return i11 + i12;
    }
}
