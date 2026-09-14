package androidx.datastore.preferences.protobuf;

import a.AbstractC0228a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0244k extends AbstractC0228a {

    /* renamed from: o, reason: collision with root package name */
    public static final Logger f3196o = Logger.getLogger(C0244k.class.getName());
    public static final boolean p = f0.f3170e;

    /* renamed from: j, reason: collision with root package name */
    public B f3197j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f3198k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3199l;

    /* renamed from: m, reason: collision with root package name */
    public int f3200m;

    /* renamed from: n, reason: collision with root package name */
    public final R.m0 f3201n;

    public C0244k(R.m0 m0Var, int i) {
        if (i >= 0) {
            int max = Math.max(i, 20);
            this.f3198k = new byte[max];
            this.f3199l = max;
            this.f3201n = m0Var;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public static int K(int i, C0240g c0240g) {
        int M3 = M(i);
        int size = c0240g.size();
        return N(size) + size + M3;
    }

    public static int L(String str) {
        int length;
        try {
            length = i0.a(str);
        } catch (h0 unused) {
            length = str.getBytes(AbstractC0255w.f3236a).length;
        }
        return N(length) + length;
    }

    public static int M(int i) {
        return N(i << 3);
    }

    public static int N(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int O(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    @Override // a.AbstractC0228a
    public final void E(byte[] bArr, int i, int i3) {
        S(bArr, i, i3);
    }

    public final void F(int i) {
        int i3 = this.f3200m;
        int i4 = i3 + 1;
        this.f3200m = i4;
        byte[] bArr = this.f3198k;
        bArr[i3] = (byte) (i & 255);
        int i5 = i3 + 2;
        this.f3200m = i5;
        bArr[i4] = (byte) ((i >> 8) & 255);
        int i6 = i3 + 3;
        this.f3200m = i6;
        bArr[i5] = (byte) ((i >> 16) & 255);
        this.f3200m = i3 + 4;
        bArr[i6] = (byte) ((i >> 24) & 255);
    }

    public final void G(long j2) {
        int i = this.f3200m;
        int i3 = i + 1;
        this.f3200m = i3;
        byte[] bArr = this.f3198k;
        bArr[i] = (byte) (j2 & 255);
        int i4 = i + 2;
        this.f3200m = i4;
        bArr[i3] = (byte) ((j2 >> 8) & 255);
        int i5 = i + 3;
        this.f3200m = i5;
        bArr[i4] = (byte) ((j2 >> 16) & 255);
        int i6 = i + 4;
        this.f3200m = i6;
        bArr[i5] = (byte) (255 & (j2 >> 24));
        int i7 = i + 5;
        this.f3200m = i7;
        bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
        int i8 = i + 6;
        this.f3200m = i8;
        bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
        int i9 = i + 7;
        this.f3200m = i9;
        bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
        this.f3200m = i + 8;
        bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
    }

    public final void H(int i, int i3) {
        I((i << 3) | i3);
    }

    public final void I(int i) {
        boolean z3 = p;
        byte[] bArr = this.f3198k;
        if (z3) {
            while ((i & (-128)) != 0) {
                int i3 = this.f3200m;
                this.f3200m = i3 + 1;
                f0.j(bArr, i3, (byte) ((i | 128) & 255));
                i >>>= 7;
            }
            int i4 = this.f3200m;
            this.f3200m = i4 + 1;
            f0.j(bArr, i4, (byte) i);
            return;
        }
        while ((i & (-128)) != 0) {
            int i5 = this.f3200m;
            this.f3200m = i5 + 1;
            bArr[i5] = (byte) ((i | 128) & 255);
            i >>>= 7;
        }
        int i6 = this.f3200m;
        this.f3200m = i6 + 1;
        bArr[i6] = (byte) i;
    }

    public final void J(long j2) {
        boolean z3 = p;
        byte[] bArr = this.f3198k;
        if (z3) {
            while ((j2 & (-128)) != 0) {
                int i = this.f3200m;
                this.f3200m = i + 1;
                f0.j(bArr, i, (byte) ((((int) j2) | 128) & 255));
                j2 >>>= 7;
            }
            int i3 = this.f3200m;
            this.f3200m = i3 + 1;
            f0.j(bArr, i3, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            int i4 = this.f3200m;
            this.f3200m = i4 + 1;
            bArr[i4] = (byte) ((((int) j2) | 128) & 255);
            j2 >>>= 7;
        }
        int i5 = this.f3200m;
        this.f3200m = i5 + 1;
        bArr[i5] = (byte) j2;
    }

    public final void P() {
        this.f3201n.write(this.f3198k, 0, this.f3200m);
        this.f3200m = 0;
    }

    public final void Q(int i) {
        if (this.f3199l - this.f3200m < i) {
            P();
        }
    }

    public final void R(byte b4) {
        if (this.f3200m == this.f3199l) {
            P();
        }
        int i = this.f3200m;
        this.f3200m = i + 1;
        this.f3198k[i] = b4;
    }

    public final void S(byte[] bArr, int i, int i3) {
        int i4 = this.f3200m;
        int i5 = this.f3199l;
        int i6 = i5 - i4;
        byte[] bArr2 = this.f3198k;
        if (i6 >= i3) {
            System.arraycopy(bArr, i, bArr2, i4, i3);
            this.f3200m += i3;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i4, i6);
        int i7 = i + i6;
        int i8 = i3 - i6;
        this.f3200m = i5;
        P();
        if (i8 <= i5) {
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            this.f3200m = i8;
        } else {
            this.f3201n.write(bArr, i7, i8);
        }
    }

    public final void T(int i, boolean z3) {
        Q(11);
        H(i, 0);
        byte b4 = z3 ? (byte) 1 : (byte) 0;
        int i3 = this.f3200m;
        this.f3200m = i3 + 1;
        this.f3198k[i3] = b4;
    }

    public final void U(int i, C0240g c0240g) {
        f0(i, 2);
        V(c0240g);
    }

    public final void V(C0240g c0240g) {
        h0(c0240g.size());
        E(c0240g.f3176b, c0240g.k(), c0240g.size());
    }

    public final void W(int i, int i3) {
        Q(14);
        H(i, 5);
        F(i3);
    }

    public final void X(int i) {
        Q(4);
        F(i);
    }

    public final void Y(int i, long j2) {
        Q(18);
        H(i, 1);
        G(j2);
    }

    public final void Z(long j2) {
        Q(8);
        G(j2);
    }

    public final void a0(int i, int i3) {
        Q(20);
        H(i, 0);
        if (i3 >= 0) {
            I(i3);
        } else {
            J(i3);
        }
    }

    public final void b0(int i) {
        if (i >= 0) {
            h0(i);
        } else {
            j0(i);
        }
    }

    public final void c0(int i, AbstractC0234a abstractC0234a, S s3) {
        f0(i, 2);
        h0(abstractC0234a.a(s3));
        s3.d(abstractC0234a, this.f3197j);
    }

    public final void d0(int i, String str) {
        f0(i, 2);
        e0(str);
    }

    public final void e0(String str) {
        try {
            int length = str.length() * 3;
            int N3 = N(length);
            int i = N3 + length;
            int i3 = this.f3199l;
            if (i > i3) {
                byte[] bArr = new byte[length];
                int m4 = i0.f3191a.m(str, bArr, 0, length);
                h0(m4);
                S(bArr, 0, m4);
                return;
            }
            if (i > i3 - this.f3200m) {
                P();
            }
            int N4 = N(str.length());
            int i4 = this.f3200m;
            byte[] bArr2 = this.f3198k;
            try {
                try {
                    if (N4 == N3) {
                        int i5 = i4 + N4;
                        this.f3200m = i5;
                        int m5 = i0.f3191a.m(str, bArr2, i5, i3 - i5);
                        this.f3200m = i4;
                        I((m5 - i4) - N4);
                        this.f3200m = m5;
                    } else {
                        int a2 = i0.a(str);
                        I(a2);
                        this.f3200m = i0.f3191a.m(str, bArr2, this.f3200m, a2);
                    }
                } catch (h0 e4) {
                    this.f3200m = i4;
                    throw e4;
                }
            } catch (ArrayIndexOutOfBoundsException e5) {
                throw new CodedOutputStream$OutOfSpaceException(e5);
            }
        } catch (h0 e6) {
            f3196o.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e6);
            byte[] bytes = str.getBytes(AbstractC0255w.f3236a);
            try {
                h0(bytes.length);
                E(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e7) {
                throw new CodedOutputStream$OutOfSpaceException(e7);
            }
        }
    }

    public final void f0(int i, int i3) {
        h0((i << 3) | i3);
    }

    public final void g0(int i, int i3) {
        Q(20);
        H(i, 0);
        I(i3);
    }

    public final void h0(int i) {
        Q(5);
        I(i);
    }

    public final void i0(int i, long j2) {
        Q(20);
        H(i, 0);
        J(j2);
    }

    public final void j0(long j2) {
        Q(10);
        J(j2);
    }
}
