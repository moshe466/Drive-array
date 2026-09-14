package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f11390a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f11391b;

    /* renamed from: c, reason: collision with root package name */
    private int f11392c;

    /* renamed from: d, reason: collision with root package name */
    private int f11393d;

    /* renamed from: e, reason: collision with root package name */
    private int f11394e;

    /* renamed from: f, reason: collision with root package name */
    private final InputStream f11395f;

    /* renamed from: g, reason: collision with root package name */
    private int f11396g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11397h;

    /* renamed from: i, reason: collision with root package name */
    private int f11398i;

    /* renamed from: j, reason: collision with root package name */
    private int f11399j;

    /* renamed from: k, reason: collision with root package name */
    private int f11400k;

    /* renamed from: l, reason: collision with root package name */
    private int f11401l;

    /* renamed from: m, reason: collision with root package name */
    private int f11402m;

    /* renamed from: n, reason: collision with root package name */
    private a f11403n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    private e(InputStream inputStream) {
        this.f11397h = false;
        this.f11399j = Integer.MAX_VALUE;
        this.f11401l = 64;
        this.f11402m = 67108864;
        this.f11403n = null;
        this.f11390a = new byte[4096];
        this.f11392c = 0;
        this.f11394e = 0;
        this.f11398i = 0;
        this.f11395f = inputStream;
        this.f11391b = false;
    }

    private e(p pVar) {
        this.f11397h = false;
        this.f11399j = Integer.MAX_VALUE;
        this.f11401l = 64;
        this.f11402m = 67108864;
        this.f11403n = null;
        this.f11390a = pVar.f11449g;
        int L = pVar.L();
        this.f11394e = L;
        this.f11392c = L + pVar.size();
        this.f11398i = -this.f11394e;
        this.f11395f = null;
        this.f11391b = true;
    }

    public static int B(int i10, InputStream inputStream) {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & 127;
        int i12 = 7;
        while (i12 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw k.k();
            }
            i11 |= (read & 127) << i12;
            if ((read & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        while (i12 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw k.k();
            }
            if ((read2 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        throw k.f();
    }

    private void N() {
        int i10 = this.f11392c + this.f11393d;
        this.f11392c = i10;
        int i11 = this.f11398i + i10;
        int i12 = this.f11399j;
        if (i11 <= i12) {
            this.f11393d = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f11393d = i13;
        this.f11392c = i10 - i13;
    }

    private void O(int i10) {
        if (!T(i10)) {
            throw k.k();
        }
    }

    private void S(int i10) {
        if (i10 < 0) {
            throw k.g();
        }
        int i11 = this.f11398i;
        int i12 = this.f11394e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f11399j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw k.k();
        }
        int i15 = this.f11392c;
        int i16 = i15 - i12;
        this.f11394e = i15;
        while (true) {
            O(1);
            int i17 = i10 - i16;
            int i18 = this.f11392c;
            if (i17 <= i18) {
                this.f11394e = i17;
                return;
            } else {
                i16 += i18;
                this.f11394e = i18;
            }
        }
    }

    private boolean T(int i10) {
        int i11 = this.f11394e;
        if (i11 + i10 <= this.f11392c) {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i10);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
        if (this.f11398i + i11 + i10 > this.f11399j) {
            return false;
        }
        a aVar = this.f11403n;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f11395f != null) {
            int i12 = this.f11394e;
            if (i12 > 0) {
                int i13 = this.f11392c;
                if (i13 > i12) {
                    byte[] bArr = this.f11390a;
                    System.arraycopy(bArr, i12, bArr, 0, i13 - i12);
                }
                this.f11398i += i12;
                this.f11392c -= i12;
                this.f11394e = 0;
            }
            InputStream inputStream = this.f11395f;
            byte[] bArr2 = this.f11390a;
            int i14 = this.f11392c;
            int read = inputStream.read(bArr2, i14, bArr2.length - i14);
            if (read == 0 || read < -1 || read > this.f11390a.length) {
                StringBuilder sb3 = new StringBuilder(102);
                sb3.append("InputStream#read(byte[]) returned invalid result: ");
                sb3.append(read);
                sb3.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb3.toString());
            }
            if (read > 0) {
                this.f11392c += read;
                if ((this.f11398i + i10) - this.f11402m > 0) {
                    throw k.j();
                }
                N();
                if (this.f11392c >= i10) {
                    return true;
                }
                return T(i10);
            }
        }
        return false;
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    private void d(int i10) {
        if (this.f11392c - this.f11394e < i10) {
            O(i10);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e h(p pVar) {
        e eVar = new e(pVar);
        try {
            eVar.j(pVar.size());
            return eVar;
        } catch (k e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    private byte[] x(int i10) {
        if (i10 <= 0) {
            if (i10 == 0) {
                return j.f11438a;
            }
            throw k.g();
        }
        int i11 = this.f11398i;
        int i12 = this.f11394e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f11399j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw k.k();
        }
        if (i10 < 4096) {
            byte[] bArr = new byte[i10];
            int i15 = this.f11392c - i12;
            System.arraycopy(this.f11390a, i12, bArr, 0, i15);
            this.f11394e = this.f11392c;
            int i16 = i10 - i15;
            d(i16);
            System.arraycopy(this.f11390a, 0, bArr, i15, i16);
            this.f11394e = i16;
            return bArr;
        }
        int i17 = this.f11392c;
        this.f11398i = i11 + i17;
        this.f11394e = 0;
        this.f11392c = 0;
        int i18 = i17 - i12;
        int i19 = i10 - i18;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i19 > 0) {
            int min = Math.min(i19, 4096);
            byte[] bArr2 = new byte[min];
            int i20 = 0;
            while (i20 < min) {
                InputStream inputStream = this.f11395f;
                int read = inputStream == null ? -1 : inputStream.read(bArr2, i20, min - i20);
                if (read == -1) {
                    throw k.k();
                }
                this.f11398i += read;
                i20 += read;
            }
            i19 -= min;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(this.f11390a, i12, bArr3, 0, i18);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, i18, bArr4.length);
            i18 += bArr4.length;
        }
        return bArr3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int A() {
        /*
            r9 = this;
            int r0 = r9.f11394e
            int r1 = r9.f11392c
            if (r1 != r0) goto L8
            goto L7c
        L8:
            byte[] r2 = r9.f11390a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L13
            r9.f11394e = r3
            return r0
        L13:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L19
            goto L7c
        L19:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2d
            r5 = -128(0xffffffffffffff80, double:NaN)
        L29:
            long r2 = r3 ^ r5
            int r0 = (int) r2
            goto L82
        L2d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L3f
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L3d:
            r1 = r3
            goto L82
        L3f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L4f
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L29
        L4f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L82
        L7c:
            long r0 = r9.D()
            int r1 = (int) r0
            return r1
        L82:
            r9.f11394e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.e.A():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r2[r0] < 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long C() {
        /*
            Method dump skipped, instructions count: 194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.e.C():long");
    }

    long D() {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            j10 |= (r3 & Byte.MAX_VALUE) << i10;
            if ((w() & 128) == 0) {
                return j10;
            }
        }
        throw k.f();
    }

    public int E() {
        return y();
    }

    public long F() {
        return z();
    }

    public int G() {
        return b(A());
    }

    public long H() {
        return c(C());
    }

    public String I() {
        int A = A();
        int i10 = this.f11392c;
        int i11 = this.f11394e;
        if (A > i10 - i11 || A <= 0) {
            return A == 0 ? "" : new String(x(A), "UTF-8");
        }
        String str = new String(this.f11390a, i11, A, "UTF-8");
        this.f11394e += A;
        return str;
    }

    public String J() {
        byte[] x10;
        int A = A();
        int i10 = this.f11394e;
        if (A <= this.f11392c - i10 && A > 0) {
            x10 = this.f11390a;
            this.f11394e = i10 + A;
        } else {
            if (A == 0) {
                return "";
            }
            x10 = x(A);
            i10 = 0;
        }
        if (y.f(x10, i10, i10 + A)) {
            return new String(x10, i10, A, "UTF-8");
        }
        throw k.d();
    }

    public int K() {
        if (f()) {
            this.f11396g = 0;
            return 0;
        }
        int A = A();
        this.f11396g = A;
        if (z.a(A) != 0) {
            return this.f11396g;
        }
        throw k.c();
    }

    public int L() {
        return A();
    }

    public long M() {
        return C();
    }

    public boolean P(int i10, f fVar) {
        int b10 = z.b(i10);
        if (b10 == 0) {
            long t10 = t();
            fVar.o0(i10);
            fVar.z0(t10);
            return true;
        }
        if (b10 == 1) {
            long z10 = z();
            fVar.o0(i10);
            fVar.V(z10);
            return true;
        }
        if (b10 == 2) {
            d l10 = l();
            fVar.o0(i10);
            fVar.P(l10);
            return true;
        }
        if (b10 == 3) {
            fVar.o0(i10);
            Q(fVar);
            int c10 = z.c(z.a(i10), 4);
            a(c10);
            fVar.o0(c10);
            return true;
        }
        if (b10 == 4) {
            return false;
        }
        if (b10 != 5) {
            throw k.e();
        }
        int y10 = y();
        fVar.o0(i10);
        fVar.U(y10);
        return true;
    }

    public void Q(f fVar) {
        int K;
        do {
            K = K();
            if (K == 0) {
                return;
            }
        } while (P(K, fVar));
    }

    public void R(int i10) {
        int i11 = this.f11392c;
        int i12 = this.f11394e;
        if (i10 > i11 - i12 || i10 < 0) {
            S(i10);
        } else {
            this.f11394e = i12 + i10;
        }
    }

    public void a(int i10) {
        if (this.f11396g != i10) {
            throw k.b();
        }
    }

    public int e() {
        int i10 = this.f11399j;
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10 - (this.f11398i + this.f11394e);
    }

    public boolean f() {
        return this.f11394e == this.f11392c && !T(1);
    }

    public void i(int i10) {
        this.f11399j = i10;
        N();
    }

    public int j(int i10) {
        if (i10 < 0) {
            throw k.g();
        }
        int i11 = i10 + this.f11398i + this.f11394e;
        int i12 = this.f11399j;
        if (i11 > i12) {
            throw k.k();
        }
        this.f11399j = i11;
        N();
        return i12;
    }

    public boolean k() {
        return C() != 0;
    }

    public d l() {
        int A = A();
        int i10 = this.f11392c;
        int i11 = this.f11394e;
        if (A > i10 - i11 || A <= 0) {
            return A == 0 ? d.f11383f : new p(x(A));
        }
        d cVar = (this.f11391b && this.f11397h) ? new c(this.f11390a, this.f11394e, A) : d.l(this.f11390a, i11, A);
        this.f11394e += A;
        return cVar;
    }

    public double m() {
        return Double.longBitsToDouble(z());
    }

    public int n() {
        return A();
    }

    public int o() {
        return y();
    }

    public long p() {
        return z();
    }

    public float q() {
        return Float.intBitsToFloat(y());
    }

    public void r(int i10, q.a aVar, g gVar) {
        int i11 = this.f11400k;
        if (i11 >= this.f11401l) {
            throw k.h();
        }
        this.f11400k = i11 + 1;
        aVar.l(this, gVar);
        a(z.c(i10, 4));
        this.f11400k--;
    }

    public int s() {
        return A();
    }

    public long t() {
        return C();
    }

    public <T extends q> T u(s<T> sVar, g gVar) {
        int A = A();
        if (this.f11400k >= this.f11401l) {
            throw k.h();
        }
        int j10 = j(A);
        this.f11400k++;
        T c10 = sVar.c(this, gVar);
        a(0);
        this.f11400k--;
        i(j10);
        return c10;
    }

    public void v(q.a aVar, g gVar) {
        int A = A();
        if (this.f11400k >= this.f11401l) {
            throw k.h();
        }
        int j10 = j(A);
        this.f11400k++;
        aVar.l(this, gVar);
        a(0);
        this.f11400k--;
        i(j10);
    }

    public byte w() {
        if (this.f11394e == this.f11392c) {
            O(1);
        }
        byte[] bArr = this.f11390a;
        int i10 = this.f11394e;
        this.f11394e = i10 + 1;
        return bArr[i10];
    }

    public int y() {
        int i10 = this.f11394e;
        if (this.f11392c - i10 < 4) {
            O(4);
            i10 = this.f11394e;
        }
        byte[] bArr = this.f11390a;
        this.f11394e = i10 + 4;
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public long z() {
        int i10 = this.f11394e;
        if (this.f11392c - i10 < 8) {
            O(8);
            i10 = this.f11394e;
        }
        byte[] bArr = this.f11390a;
        this.f11394e = i10 + 8;
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }
}
