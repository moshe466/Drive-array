package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class v6 extends e6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f5636b = Logger.getLogger(v6.class.getName());

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f5637c = na.m();

    /* renamed from: a, reason: collision with root package name */
    x6 f5638a;

    /* loaded from: classes.dex */
    public static class a extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        a(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L11
                java.lang.String r3 = r0.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.v6.a.<init>(java.lang.String, java.lang.Throwable):void");
        }

        a(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* loaded from: classes.dex */
    private static class b extends v6 {

        /* renamed from: d, reason: collision with root package name */
        private final byte[] f5639d;

        /* renamed from: e, reason: collision with root package name */
        private final int f5640e;

        /* renamed from: f, reason: collision with root package name */
        private int f5641f;

        b(byte[] bArr, int i10, int i11) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            if ((i11 | 0 | (bArr.length - i11)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i11)));
            }
            this.f5639d = bArr;
            this.f5641f = 0;
            this.f5640e = i11;
        }

        private final void F0(byte[] bArr, int i10, int i11) {
            try {
                System.arraycopy(bArr, i10, this.f5639d, this.f5641f, i11);
                this.f5641f += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f5641f), Integer.valueOf(this.f5640e), Integer.valueOf(i11)), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void O(int i10) {
            if (!v6.f5637c || a6.b() || b() < 5) {
                while ((i10 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f5639d;
                        int i11 = this.f5641f;
                        this.f5641f = i11 + 1;
                        bArr[i11] = (byte) ((i10 & 127) | 128);
                        i10 >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f5641f), Integer.valueOf(this.f5640e), 1), e10);
                    }
                }
                byte[] bArr2 = this.f5639d;
                int i12 = this.f5641f;
                this.f5641f = i12 + 1;
                bArr2[i12] = (byte) i10;
                return;
            }
            if ((i10 & (-128)) == 0) {
                byte[] bArr3 = this.f5639d;
                int i13 = this.f5641f;
                this.f5641f = i13 + 1;
                na.l(bArr3, i13, (byte) i10);
                return;
            }
            byte[] bArr4 = this.f5639d;
            int i14 = this.f5641f;
            this.f5641f = i14 + 1;
            na.l(bArr4, i14, (byte) (i10 | 128));
            int i15 = i10 >>> 7;
            if ((i15 & (-128)) == 0) {
                byte[] bArr5 = this.f5639d;
                int i16 = this.f5641f;
                this.f5641f = i16 + 1;
                na.l(bArr5, i16, (byte) i15);
                return;
            }
            byte[] bArr6 = this.f5639d;
            int i17 = this.f5641f;
            this.f5641f = i17 + 1;
            na.l(bArr6, i17, (byte) (i15 | 128));
            int i18 = i15 >>> 7;
            if ((i18 & (-128)) == 0) {
                byte[] bArr7 = this.f5639d;
                int i19 = this.f5641f;
                this.f5641f = i19 + 1;
                na.l(bArr7, i19, (byte) i18);
                return;
            }
            byte[] bArr8 = this.f5639d;
            int i20 = this.f5641f;
            this.f5641f = i20 + 1;
            na.l(bArr8, i20, (byte) (i18 | 128));
            int i21 = i18 >>> 7;
            if ((i21 & (-128)) == 0) {
                byte[] bArr9 = this.f5639d;
                int i22 = this.f5641f;
                this.f5641f = i22 + 1;
                na.l(bArr9, i22, (byte) i21);
                return;
            }
            byte[] bArr10 = this.f5639d;
            int i23 = this.f5641f;
            this.f5641f = i23 + 1;
            na.l(bArr10, i23, (byte) (i21 | 128));
            byte[] bArr11 = this.f5639d;
            int i24 = this.f5641f;
            this.f5641f = i24 + 1;
            na.l(bArr11, i24, (byte) (i21 >>> 7));
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void P(int i10, int i11) {
            m(i10, 0);
            j(i11);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void R(int i10, d6 d6Var) {
            m(1, 3);
            X(2, i10);
            o(3, d6Var);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void X(int i10, int i11) {
            m(i10, 0);
            O(i11);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void Y(int i10, long j10) {
            m(i10, 1);
            Z(j10);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void Z(long j10) {
            try {
                byte[] bArr = this.f5639d;
                int i10 = this.f5641f;
                int i11 = i10 + 1;
                this.f5641f = i11;
                bArr[i10] = (byte) j10;
                int i12 = i11 + 1;
                this.f5641f = i12;
                bArr[i11] = (byte) (j10 >> 8);
                int i13 = i12 + 1;
                this.f5641f = i13;
                bArr[i12] = (byte) (j10 >> 16);
                int i14 = i13 + 1;
                this.f5641f = i14;
                bArr[i13] = (byte) (j10 >> 24);
                int i15 = i14 + 1;
                this.f5641f = i15;
                bArr[i14] = (byte) (j10 >> 32);
                int i16 = i15 + 1;
                this.f5641f = i16;
                bArr[i15] = (byte) (j10 >> 40);
                int i17 = i16 + 1;
                this.f5641f = i17;
                bArr[i16] = (byte) (j10 >> 48);
                this.f5641f = i17 + 1;
                bArr[i17] = (byte) (j10 >> 56);
            } catch (IndexOutOfBoundsException e10) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f5641f), Integer.valueOf(this.f5640e), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.e6
        public final void a(byte[] bArr, int i10, int i11) {
            F0(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final int b() {
            return this.f5640e - this.f5641f;
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void e0(int i10) {
            try {
                byte[] bArr = this.f5639d;
                int i11 = this.f5641f;
                int i12 = i11 + 1;
                this.f5641f = i12;
                bArr[i11] = (byte) i10;
                int i13 = i12 + 1;
                this.f5641f = i13;
                bArr[i12] = (byte) (i10 >> 8);
                int i14 = i13 + 1;
                this.f5641f = i14;
                bArr[i13] = (byte) (i10 >> 16);
                this.f5641f = i14 + 1;
                bArr[i14] = (byte) (i10 >>> 24);
            } catch (IndexOutOfBoundsException e10) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f5641f), Integer.valueOf(this.f5640e), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void g(byte b10) {
            try {
                byte[] bArr = this.f5639d;
                int i10 = this.f5641f;
                this.f5641f = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f5641f), Integer.valueOf(this.f5640e), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void j(int i10) {
            if (i10 >= 0) {
                O(i10);
            } else {
                t(i10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void j0(int i10, int i11) {
            m(i10, 5);
            e0(i11);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void m(int i10, int i11) {
            O((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void n(int i10, long j10) {
            m(i10, 0);
            t(j10);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void o(int i10, d6 d6Var) {
            m(i10, 2);
            u(d6Var);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void p(int i10, y8 y8Var) {
            m(1, 3);
            X(2, i10);
            m(3, 2);
            v(y8Var);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        final void q(int i10, y8 y8Var, p9 p9Var) {
            m(i10, 2);
            u5 u5Var = (u5) y8Var;
            int l10 = u5Var.l();
            if (l10 == -1) {
                l10 = p9Var.e(u5Var);
                u5Var.m(l10);
            }
            O(l10);
            p9Var.f(y8Var, this.f5638a);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void r(int i10, String str) {
            m(i10, 2);
            w(str);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void s(int i10, boolean z10) {
            m(i10, 0);
            g(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void t(long j10) {
            if (v6.f5637c && b() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f5639d;
                    int i10 = this.f5641f;
                    this.f5641f = i10 + 1;
                    na.l(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f5639d;
                int i11 = this.f5641f;
                this.f5641f = i11 + 1;
                na.l(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f5639d;
                    int i12 = this.f5641f;
                    this.f5641f = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f5641f), Integer.valueOf(this.f5640e), 1), e10);
                }
            }
            byte[] bArr4 = this.f5639d;
            int i13 = this.f5641f;
            this.f5641f = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void u(d6 d6Var) {
            O(d6Var.f());
            d6Var.v(this);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void v(y8 y8Var) {
            O(y8Var.b());
            y8Var.h(this);
        }

        @Override // com.google.android.gms.internal.measurement.v6
        public final void w(String str) {
            int i10 = this.f5641f;
            try {
                int o02 = v6.o0(str.length() * 3);
                int o03 = v6.o0(str.length());
                if (o03 != o02) {
                    O(qa.d(str));
                    this.f5641f = qa.e(str, this.f5639d, this.f5641f, b());
                    return;
                }
                int i11 = i10 + o03;
                this.f5641f = i11;
                int e10 = qa.e(str, this.f5639d, i11, b());
                this.f5641f = i10;
                O((e10 - i10) - o03);
                this.f5641f = e10;
            } catch (ua e11) {
                this.f5641f = i10;
                x(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new a(e12);
            }
        }
    }

    private v6() {
    }

    public static int A(float f10) {
        return 4;
    }

    public static int A0(int i10, int i11) {
        return o0(i10 << 3) + 4;
    }

    public static int B(int i10, double d10) {
        return o0(i10 << 3) + 8;
    }

    public static int B0(int i10) {
        return k0(i10);
    }

    public static int C(int i10, float f10) {
        return o0(i10 << 3) + 4;
    }

    public static int C0(int i10, int i11) {
        return o0(i10 << 3) + k0(i11);
    }

    public static int D(int i10, c8 c8Var) {
        return (o0(8) << 1) + p0(2, i10) + c(3, c8Var);
    }

    @Deprecated
    public static int D0(int i10) {
        return o0(i10);
    }

    public static int E(int i10, y8 y8Var) {
        return (o0(8) << 1) + p0(2, i10) + o0(24) + J(y8Var);
    }

    private static int E0(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(int i10, y8 y8Var, p9 p9Var) {
        return o0(i10 << 3) + e(y8Var, p9Var);
    }

    public static int G(int i10, String str) {
        return o0(i10 << 3) + K(str);
    }

    public static int H(int i10, boolean z10) {
        return o0(i10 << 3) + 1;
    }

    public static int I(d6 d6Var) {
        int f10 = d6Var.f();
        return o0(f10) + f10;
    }

    public static int J(y8 y8Var) {
        int b10 = y8Var.b();
        return o0(b10) + b10;
    }

    public static int K(String str) {
        int length;
        try {
            length = qa.d(str);
        } catch (ua unused) {
            length = str.getBytes(o7.f5516a).length;
        }
        return o0(length) + length;
    }

    public static int L(boolean z10) {
        return 1;
    }

    public static int M(byte[] bArr) {
        int length = bArr.length;
        return o0(length) + length;
    }

    public static int T(int i10, d6 d6Var) {
        int o02 = o0(i10 << 3);
        int f10 = d6Var.f();
        return o02 + o0(f10) + f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int U(int i10, y8 y8Var, p9 p9Var) {
        int o02 = o0(i10 << 3) << 1;
        u5 u5Var = (u5) y8Var;
        int l10 = u5Var.l();
        if (l10 == -1) {
            l10 = p9Var.e(u5Var);
            u5Var.m(l10);
        }
        return o02 + l10;
    }

    @Deprecated
    public static int V(y8 y8Var) {
        return y8Var.b();
    }

    public static int b0(int i10, long j10) {
        return o0(i10 << 3) + i0(j10);
    }

    public static int c(int i10, c8 c8Var) {
        int o02 = o0(i10 << 3);
        int b10 = c8Var.b();
        return o02 + o0(b10) + b10;
    }

    public static int c0(int i10, d6 d6Var) {
        return (o0(8) << 1) + p0(2, i10) + T(3, d6Var);
    }

    public static int d(c8 c8Var) {
        int b10 = c8Var.b();
        return o0(b10) + b10;
    }

    public static int d0(long j10) {
        return i0(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(y8 y8Var, p9 p9Var) {
        u5 u5Var = (u5) y8Var;
        int l10 = u5Var.l();
        if (l10 == -1) {
            l10 = p9Var.e(u5Var);
            u5Var.m(l10);
        }
        return o0(l10) + l10;
    }

    public static v6 f(byte[] bArr) {
        return new b(bArr, 0, bArr.length);
    }

    public static int g0(int i10) {
        return o0(i10 << 3);
    }

    public static int h0(int i10, long j10) {
        return o0(i10 << 3) + i0(j10);
    }

    public static int i0(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            i10 = 6;
            j10 >>>= 28;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int k0(int i10) {
        if (i10 >= 0) {
            return o0(i10);
        }
        return 10;
    }

    public static int l0(int i10, int i11) {
        return o0(i10 << 3) + k0(i11);
    }

    public static int m0(int i10, long j10) {
        return o0(i10 << 3) + i0(y0(j10));
    }

    public static int n0(long j10) {
        return i0(y0(j10));
    }

    public static int o0(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int p0(int i10, int i11) {
        return o0(i10 << 3) + o0(i11);
    }

    public static int q0(int i10, long j10) {
        return o0(i10 << 3) + 8;
    }

    public static int r0(long j10) {
        return 8;
    }

    public static int s0(int i10) {
        return o0(E0(i10));
    }

    public static int t0(int i10, int i11) {
        return o0(i10 << 3) + o0(E0(i11));
    }

    public static int u0(int i10, long j10) {
        return o0(i10 << 3) + 8;
    }

    public static int v0(long j10) {
        return 8;
    }

    public static int w0(int i10) {
        return 4;
    }

    public static int x0(int i10, int i11) {
        return o0(i10 << 3) + 4;
    }

    private static long y0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int z(double d10) {
        return 8;
    }

    public static int z0(int i10) {
        return 4;
    }

    public final void N() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void O(int i10);

    public abstract void P(int i10, int i11);

    public final void Q(int i10, long j10) {
        n(i10, y0(j10));
    }

    public abstract void R(int i10, d6 d6Var);

    public final void S(long j10) {
        t(y0(j10));
    }

    public final void W(int i10) {
        O(E0(i10));
    }

    public abstract void X(int i10, int i11);

    public abstract void Y(int i10, long j10);

    public abstract void Z(long j10);

    public abstract int b();

    public abstract void e0(int i10);

    public final void f0(int i10, int i11) {
        X(i10, E0(i11));
    }

    public abstract void g(byte b10);

    public final void h(double d10) {
        Z(Double.doubleToRawLongBits(d10));
    }

    public final void i(float f10) {
        e0(Float.floatToRawIntBits(f10));
    }

    public abstract void j(int i10);

    public abstract void j0(int i10, int i11);

    public final void k(int i10, double d10) {
        Y(i10, Double.doubleToRawLongBits(d10));
    }

    public final void l(int i10, float f10) {
        j0(i10, Float.floatToRawIntBits(f10));
    }

    public abstract void m(int i10, int i11);

    public abstract void n(int i10, long j10);

    public abstract void o(int i10, d6 d6Var);

    public abstract void p(int i10, y8 y8Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void q(int i10, y8 y8Var, p9 p9Var);

    public abstract void r(int i10, String str);

    public abstract void s(int i10, boolean z10);

    public abstract void t(long j10);

    public abstract void u(d6 d6Var);

    public abstract void v(y8 y8Var);

    public abstract void w(String str);

    final void x(String str, ua uaVar) {
        f5636b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) uaVar);
        byte[] bytes = str.getBytes(o7.f5516a);
        try {
            O(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (a e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new a(e11);
        }
    }

    public final void y(boolean z10) {
        g(z10 ? (byte) 1 : (byte) 0);
    }
}
