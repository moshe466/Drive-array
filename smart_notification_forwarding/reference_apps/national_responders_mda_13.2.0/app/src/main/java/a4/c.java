package a4;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c implements Flushable {

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f185f;

    /* renamed from: g, reason: collision with root package name */
    private final int f186g;

    /* renamed from: h, reason: collision with root package name */
    private int f187h = 0;

    /* renamed from: i, reason: collision with root package name */
    private final OutputStream f188i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f188i = outputStream;
        this.f185f = bArr;
        this.f186g = bArr.length;
    }

    public static int B(long j10) {
        return s(j10);
    }

    public static int C(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static c D(OutputStream outputStream) {
        return E(outputStream, 4096);
    }

    public static c E(OutputStream outputStream, int i10) {
        return new c(outputStream, new byte[i10]);
    }

    private void G() {
        OutputStream outputStream = this.f188i;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f185f, 0, this.f187h);
        this.f187h = 0;
    }

    public static int c(int i10, boolean z10) {
        return w(i10) + d(z10);
    }

    public static int d(boolean z10) {
        return 1;
    }

    public static int f(int i10, a4.a aVar) {
        return w(i10) + g(aVar);
    }

    public static int g(a4.a aVar) {
        return q(aVar.f()) + aVar.f();
    }

    public static int i(int i10, int i11) {
        return w(i10) + j(i11);
    }

    public static int j(int i10) {
        return p(i10);
    }

    public static int k(int i10, float f10) {
        return w(i10) + m(f10);
    }

    public static int m(float f10) {
        return 4;
    }

    public static int p(int i10) {
        if (i10 >= 0) {
            return q(i10);
        }
        return 10;
    }

    public static int q(int i10) {
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

    public static int s(long j10) {
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (((-16384) & j10) == 0) {
            return 2;
        }
        if (((-2097152) & j10) == 0) {
            return 3;
        }
        if (((-268435456) & j10) == 0) {
            return 4;
        }
        if (((-34359738368L) & j10) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j10) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j10) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j10) == 0) {
            return 8;
        }
        return (j10 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int u(int i10, int i11) {
        return w(i10) + v(i11);
    }

    public static int v(int i10) {
        return q(C(i10));
    }

    public static int w(int i10) {
        return q(e.a(i10, 0));
    }

    public static int x(int i10, int i11) {
        return w(i10) + y(i11);
    }

    public static int y(int i10) {
        return q(i10);
    }

    public static int z(int i10, long j10) {
        return w(i10) + B(j10);
    }

    public void H(int i10, boolean z10) {
        e0(i10, 0);
        I(z10);
    }

    public void I(boolean z10) {
        T(z10 ? 1 : 0);
    }

    public void J(int i10, a4.a aVar) {
        e0(i10, 2);
        L(aVar);
    }

    public void L(a4.a aVar) {
        a0(aVar.f());
        V(aVar);
    }

    public void M(int i10, int i11) {
        e0(i10, 0);
        N(i11);
    }

    public void N(int i10) {
        Q(i10);
    }

    public void O(int i10, float f10) {
        e0(i10, 5);
        P(f10);
    }

    public void P(float f10) {
        Z(Float.floatToRawIntBits(f10));
    }

    public void Q(int i10) {
        if (i10 >= 0) {
            a0(i10);
        } else {
            b0(i10);
        }
    }

    public void R(byte b10) {
        if (this.f187h == this.f186g) {
            G();
        }
        byte[] bArr = this.f185f;
        int i10 = this.f187h;
        this.f187h = i10 + 1;
        bArr[i10] = b10;
    }

    public void T(int i10) {
        R((byte) i10);
    }

    public void V(a4.a aVar) {
        W(aVar, 0, aVar.f());
    }

    public void W(a4.a aVar, int i10, int i11) {
        int i12 = this.f186g;
        int i13 = this.f187h;
        if (i12 - i13 >= i11) {
            aVar.d(this.f185f, i10, i13, i11);
            this.f187h += i11;
            return;
        }
        int i14 = i12 - i13;
        aVar.d(this.f185f, i10, i13, i14);
        int i15 = i10 + i14;
        int i16 = i11 - i14;
        this.f187h = this.f186g;
        G();
        if (i16 <= this.f186g) {
            aVar.d(this.f185f, i15, 0, i16);
            this.f187h = i16;
            return;
        }
        InputStream e10 = aVar.e();
        long j10 = i15;
        if (j10 != e10.skip(j10)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i16 > 0) {
            int min = Math.min(i16, this.f186g);
            int read = e10.read(this.f185f, 0, min);
            if (read != min) {
                throw new IllegalStateException("Read failed.");
            }
            this.f188i.write(this.f185f, 0, read);
            i16 -= read;
        }
    }

    public void X(byte[] bArr) {
        Y(bArr, 0, bArr.length);
    }

    public void Y(byte[] bArr, int i10, int i11) {
        int i12 = this.f186g;
        int i13 = this.f187h;
        if (i12 - i13 >= i11) {
            System.arraycopy(bArr, i10, this.f185f, i13, i11);
            this.f187h += i11;
            return;
        }
        int i14 = i12 - i13;
        System.arraycopy(bArr, i10, this.f185f, i13, i14);
        int i15 = i10 + i14;
        int i16 = i11 - i14;
        this.f187h = this.f186g;
        G();
        if (i16 > this.f186g) {
            this.f188i.write(bArr, i15, i16);
        } else {
            System.arraycopy(bArr, i15, this.f185f, 0, i16);
            this.f187h = i16;
        }
    }

    public void Z(int i10) {
        T(i10 & 255);
        T((i10 >> 8) & 255);
        T((i10 >> 16) & 255);
        T((i10 >> 24) & 255);
    }

    public void a0(int i10) {
        while ((i10 & (-128)) != 0) {
            T((i10 & 127) | 128);
            i10 >>>= 7;
        }
        T(i10);
    }

    public void b0(long j10) {
        while (((-128) & j10) != 0) {
            T((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        T((int) j10);
    }

    public void c0(int i10, int i11) {
        e0(i10, 0);
        d0(i11);
    }

    public void d0(int i10) {
        a0(C(i10));
    }

    public void e0(int i10, int i11) {
        a0(e.a(i10, i11));
    }

    public void f0(int i10, int i11) {
        e0(i10, 0);
        g0(i11);
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f188i != null) {
            G();
        }
    }

    public void g0(int i10) {
        a0(i10);
    }

    public void h0(int i10, long j10) {
        e0(i10, 0);
        i0(j10);
    }

    public void i0(long j10) {
        b0(j10);
    }
}
