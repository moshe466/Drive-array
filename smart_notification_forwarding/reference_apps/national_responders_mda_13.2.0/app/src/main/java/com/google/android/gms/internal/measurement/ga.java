package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class ga {

    /* renamed from: f, reason: collision with root package name */
    private static final ga f5335f = new ga(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    private int f5336a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f5337b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f5338c;

    /* renamed from: d, reason: collision with root package name */
    private int f5339d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5340e;

    private ga() {
        this(0, new int[8], new Object[8], true);
    }

    private ga(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f5339d = -1;
        this.f5336a = i10;
        this.f5337b = iArr;
        this.f5338c = objArr;
        this.f5340e = z10;
    }

    public static ga a() {
        return f5335f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ga b(ga gaVar, ga gaVar2) {
        int i10 = gaVar.f5336a + gaVar2.f5336a;
        int[] copyOf = Arrays.copyOf(gaVar.f5337b, i10);
        System.arraycopy(gaVar2.f5337b, 0, copyOf, gaVar.f5336a, gaVar2.f5336a);
        Object[] copyOf2 = Arrays.copyOf(gaVar.f5338c, i10);
        System.arraycopy(gaVar2.f5338c, 0, copyOf2, gaVar.f5336a, gaVar2.f5336a);
        return new ga(i10, copyOf, copyOf2, true);
    }

    private static void d(int i10, Object obj, bb bbVar) {
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            bbVar.L(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 1) {
            bbVar.z(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 2) {
            bbVar.x(i11, (d6) obj);
            return;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw new RuntimeException(x7.d());
            }
            bbVar.v(i11, ((Integer) obj).intValue());
        } else if (bbVar.zza() == eb.f5290a) {
            bbVar.b(i11);
            ((ga) obj).h(bbVar);
            bbVar.d(i11);
        } else {
            bbVar.d(i11);
            ((ga) obj).h(bbVar);
            bbVar.b(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ga g() {
        return new ga();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i10, Object obj) {
        if (!this.f5340e) {
            throw new UnsupportedOperationException();
        }
        int i11 = this.f5336a;
        int[] iArr = this.f5337b;
        if (i11 == iArr.length) {
            int i12 = i11 + (i11 < 4 ? 8 : i11 >> 1);
            this.f5337b = Arrays.copyOf(iArr, i12);
            this.f5338c = Arrays.copyOf(this.f5338c, i12);
        }
        int[] iArr2 = this.f5337b;
        int i13 = this.f5336a;
        iArr2[i13] = i10;
        this.f5338c[i13] = obj;
        this.f5336a = i13 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(bb bbVar) {
        if (bbVar.zza() == eb.f5291b) {
            for (int i10 = this.f5336a - 1; i10 >= 0; i10--) {
                bbVar.q(this.f5337b[i10] >>> 3, this.f5338c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f5336a; i11++) {
            bbVar.q(this.f5337b[i11] >>> 3, this.f5338c[i11]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ga)) {
            return false;
        }
        ga gaVar = (ga) obj;
        int i10 = this.f5336a;
        if (i10 == gaVar.f5336a) {
            int[] iArr = this.f5337b;
            int[] iArr2 = gaVar.f5337b;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    z10 = true;
                    break;
                }
                if (iArr[i11] != iArr2[i11]) {
                    z10 = false;
                    break;
                }
                i11++;
            }
            if (z10) {
                Object[] objArr = this.f5338c;
                Object[] objArr2 = gaVar.f5338c;
                int i12 = this.f5336a;
                int i13 = 0;
                while (true) {
                    if (i13 >= i12) {
                        z11 = true;
                        break;
                    }
                    if (!objArr[i13].equals(objArr2[i13])) {
                        z11 = false;
                        break;
                    }
                    i13++;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f5336a; i11++) {
            z8.d(sb2, i10, String.valueOf(this.f5337b[i11] >>> 3), this.f5338c[i11]);
        }
    }

    public final void h(bb bbVar) {
        if (this.f5336a == 0) {
            return;
        }
        if (bbVar.zza() == eb.f5290a) {
            for (int i10 = 0; i10 < this.f5336a; i10++) {
                d(this.f5337b[i10], this.f5338c[i10], bbVar);
            }
            return;
        }
        for (int i11 = this.f5336a - 1; i11 >= 0; i11--) {
            d(this.f5337b[i11], this.f5338c[i11], bbVar);
        }
    }

    public final int hashCode() {
        int i10 = this.f5336a;
        int i11 = (i10 + 527) * 31;
        int[] iArr = this.f5337b;
        int i12 = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = (i11 + i13) * 31;
        Object[] objArr = this.f5338c;
        int i16 = this.f5336a;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = (i12 * 31) + objArr[i17].hashCode();
        }
        return i15 + i12;
    }

    public final void i() {
        this.f5340e = false;
    }

    public final int j() {
        int i10 = this.f5339d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f5336a; i12++) {
            i11 += v6.c0(this.f5337b[i12] >>> 3, (d6) this.f5338c[i12]);
        }
        this.f5339d = i11;
        return i11;
    }

    public final int k() {
        int h02;
        int i10 = this.f5339d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f5336a; i12++) {
            int i13 = this.f5337b[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 == 0) {
                h02 = v6.h0(i14, ((Long) this.f5338c[i12]).longValue());
            } else if (i15 == 1) {
                h02 = v6.q0(i14, ((Long) this.f5338c[i12]).longValue());
            } else if (i15 == 2) {
                h02 = v6.T(i14, (d6) this.f5338c[i12]);
            } else if (i15 == 3) {
                h02 = (v6.g0(i14) << 1) + ((ga) this.f5338c[i12]).k();
            } else {
                if (i15 != 5) {
                    throw new IllegalStateException(x7.d());
                }
                h02 = v6.x0(i14, ((Integer) this.f5338c[i12]).intValue());
            }
            i11 += h02;
        }
        this.f5339d = i11;
        return i11;
    }
}
