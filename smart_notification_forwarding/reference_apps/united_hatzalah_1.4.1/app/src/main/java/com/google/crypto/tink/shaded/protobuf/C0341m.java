package com.google.crypto.tink.shaded.protobuf;

import a.AbstractC0228a;
import java.util.logging.Logger;

/* renamed from: com.google.crypto.tink.shaded.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0341m extends AbstractC0228a {

    /* renamed from: n, reason: collision with root package name */
    public static final Logger f4129n = Logger.getLogger(C0341m.class.getName());

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f4130o = n0.f4140e;

    /* renamed from: j, reason: collision with root package name */
    public K f4131j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f4132k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4133l;

    /* renamed from: m, reason: collision with root package name */
    public int f4134m;

    public C0341m(byte[] bArr, int i) {
        if (((bArr.length - i) | i) >= 0) {
            this.f4132k = bArr;
            this.f4134m = 0;
            this.f4133l = i;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
    }

    public static int F(int i, AbstractC0337i abstractC0337i) {
        return G(abstractC0337i) + M(i);
    }

    public static int G(AbstractC0337i abstractC0337i) {
        int size = abstractC0337i.size();
        return N(size) + size;
    }

    public static int H(int i) {
        return M(i) + 4;
    }

    public static int I(int i) {
        return M(i) + 8;
    }

    public static int J(int i, AbstractC0329a abstractC0329a, b0 b0Var) {
        return abstractC0329a.b(b0Var) + (M(i) * 2);
    }

    public static int K(int i) {
        if (i >= 0) {
            return N(i);
        }
        return 10;
    }

    public static int L(String str) {
        int length;
        try {
            length = q0.b(str);
        } catch (p0 unused) {
            length = str.getBytes(B.f4029a).length;
        }
        return N(length) + length;
    }

    public static int M(int i) {
        return N(i << 3);
    }

    public static int N(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        if ((i & (-268435456)) == 0) {
            return 4;
        }
        return 5;
    }

    public static int O(long j2) {
        int i;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            j2 >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j2) != 0) {
            i += 2;
            j2 >>>= 14;
        }
        if ((j2 & (-16384)) != 0) {
            return i + 1;
        }
        return i;
    }

    public final void P(byte b4) {
        try {
            byte[] bArr = this.f4132k;
            int i = this.f4134m;
            this.f4134m = i + 1;
            bArr[i] = b4;
        } catch (IndexOutOfBoundsException e4) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4134m), Integer.valueOf(this.f4133l), 1), e4);
        }
    }

    public final void Q(byte[] bArr, int i, int i3) {
        try {
            System.arraycopy(bArr, i, this.f4132k, this.f4134m, i3);
            this.f4134m += i3;
        } catch (IndexOutOfBoundsException e4) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4134m), Integer.valueOf(this.f4133l), Integer.valueOf(i3)), e4);
        }
    }

    public final void R(int i, int i3) {
        W(i, 5);
        S(i3);
    }

    public final void S(int i) {
        try {
            byte[] bArr = this.f4132k;
            int i3 = this.f4134m;
            int i4 = i3 + 1;
            this.f4134m = i4;
            bArr[i3] = (byte) (i & 255);
            int i5 = i3 + 2;
            this.f4134m = i5;
            bArr[i4] = (byte) ((i >> 8) & 255);
            int i6 = i3 + 3;
            this.f4134m = i6;
            bArr[i5] = (byte) ((i >> 16) & 255);
            this.f4134m = i3 + 4;
            bArr[i6] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4134m), Integer.valueOf(this.f4133l), 1), e4);
        }
    }

    public final void T(int i, long j2) {
        W(i, 1);
        U(j2);
    }

    public final void U(long j2) {
        try {
            byte[] bArr = this.f4132k;
            int i = this.f4134m;
            int i3 = i + 1;
            this.f4134m = i3;
            bArr[i] = (byte) (((int) j2) & 255);
            int i4 = i + 2;
            this.f4134m = i4;
            bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
            int i5 = i + 3;
            this.f4134m = i5;
            bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
            int i6 = i + 4;
            this.f4134m = i6;
            bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
            int i7 = i + 5;
            this.f4134m = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i + 6;
            this.f4134m = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i + 7;
            this.f4134m = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.f4134m = i + 8;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4134m), Integer.valueOf(this.f4133l), 1), e4);
        }
    }

    public final void V(int i) {
        if (i >= 0) {
            X(i);
        } else {
            Z(i);
        }
    }

    public final void W(int i, int i3) {
        X((i << 3) | i3);
    }

    public final void X(int i) {
        while (true) {
            int i3 = i & (-128);
            byte[] bArr = this.f4132k;
            if (i3 == 0) {
                int i4 = this.f4134m;
                this.f4134m = i4 + 1;
                bArr[i4] = (byte) i;
                return;
            } else {
                try {
                    int i5 = this.f4134m;
                    this.f4134m = i5 + 1;
                    bArr[i5] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4134m), Integer.valueOf(this.f4133l), 1), e4);
                }
            }
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4134m), Integer.valueOf(this.f4133l), 1), e4);
        }
    }

    public final void Y(int i, long j2) {
        W(i, 0);
        Z(j2);
    }

    public final void Z(long j2) {
        boolean z3 = f4130o;
        int i = this.f4133l;
        byte[] bArr = this.f4132k;
        if (z3 && i - this.f4134m >= 10) {
            while ((j2 & (-128)) != 0) {
                int i3 = this.f4134m;
                this.f4134m = i3 + 1;
                n0.k(bArr, i3, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            int i4 = this.f4134m;
            this.f4134m = i4 + 1;
            n0.k(bArr, i4, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            try {
                int i5 = this.f4134m;
                this.f4134m = i5 + 1;
                bArr[i5] = (byte) ((((int) j2) & 127) | 128);
                j2 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4134m), Integer.valueOf(i), 1), e4);
            }
        }
        int i6 = this.f4134m;
        this.f4134m = i6 + 1;
        bArr[i6] = (byte) j2;
    }
}
