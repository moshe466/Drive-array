package bc;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f4296h = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: f, reason: collision with root package name */
    o f4297f;

    /* renamed from: g, reason: collision with root package name */
    long f4298g;

    @Override // bc.d
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public c S(String str) {
        return B0(str, 0, str.length());
    }

    @Override // bc.e
    public byte[] B(long j10) {
        u.b(this.f4298g, 0L, j10);
        if (j10 <= 2147483647L) {
            byte[] bArr = new byte[(int) j10];
            k(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
    }

    public c B0(String str, int i10, int i11) {
        int i12;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                o q02 = q0(1);
                byte[] bArr = q02.f4328a;
                int i13 = q02.f4330c - i10;
                int min = Math.min(i11, 8192 - i13);
                int i14 = i10 + 1;
                bArr[i10 + i13] = (byte) charAt;
                while (i14 < min) {
                    char charAt2 = str.charAt(i14);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i14 + i13] = (byte) charAt2;
                    i14++;
                }
                int i15 = q02.f4330c;
                int i16 = (i13 + i14) - i15;
                q02.f4330c = i15 + i16;
                this.f4298g += i16;
                i10 = i14;
            } else {
                if (charAt < 2048) {
                    i12 = (charAt >> 6) | 192;
                } else if (charAt < 55296 || charAt > 57343) {
                    A((charAt >> '\f') | 224);
                    i12 = ((charAt >> 6) & 63) | 128;
                } else {
                    int i17 = i10 + 1;
                    char charAt3 = i17 < i11 ? str.charAt(i17) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        A(63);
                        i10 = i17;
                    } else {
                        int i18 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                        A((i18 >> 18) | 240);
                        A(((i18 >> 12) & 63) | 128);
                        A(((i18 >> 6) & 63) | 128);
                        A((i18 & 63) | 128);
                        i10 += 2;
                    }
                }
                A(i12);
                A((charAt & '?') | 128);
                i10++;
            }
        }
        return this;
    }

    public c C0(int i10) {
        int i11;
        int i12;
        if (i10 >= 128) {
            if (i10 < 2048) {
                i12 = (i10 >> 6) | 192;
            } else {
                if (i10 < 65536) {
                    if (i10 >= 55296 && i10 <= 57343) {
                        A(63);
                        return this;
                    }
                    i11 = (i10 >> 12) | 224;
                } else {
                    if (i10 > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
                    }
                    A((i10 >> 18) | 240);
                    i11 = ((i10 >> 12) & 63) | 128;
                }
                A(i11);
                i12 = ((i10 >> 6) & 63) | 128;
            }
            A(i12);
            i10 = (i10 & 63) | 128;
        }
        A(i10);
        return this;
    }

    @Override // bc.e
    public short E() {
        return u.d(L());
    }

    @Override // bc.s
    public long G(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        long j11 = this.f4298g;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        cVar.l(this, j10);
        return j10;
    }

    @Override // bc.e
    public String J(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long e02 = e0((byte) 10, 0L, j11);
        if (e02 != -1) {
            return m0(e02);
        }
        if (j11 < n0() && d0(j11 - 1) == 13 && d0(j11) == 10) {
            return m0(j11);
        }
        c cVar = new c();
        b0(cVar, 0L, Math.min(32L, n0()));
        throw new EOFException("\\n not found: limit=" + Math.min(n0(), j10) + " content=" + cVar.i0().v() + (char) 8230);
    }

    @Override // bc.e
    public short L() {
        long j10 = this.f4298g;
        if (j10 < 2) {
            throw new IllegalStateException("size < 2: " + this.f4298g);
        }
        o oVar = this.f4297f;
        int i10 = oVar.f4329b;
        int i11 = oVar.f4330c;
        if (i11 - i10 < 2) {
            return (short) (((Z() & 255) << 8) | (Z() & 255));
        }
        byte[] bArr = oVar.f4328a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
        this.f4298g = j10 - 2;
        if (i13 == i11) {
            this.f4297f = oVar.b();
            p.a(oVar);
        } else {
            oVar.f4329b = i13;
        }
        return (short) i14;
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.f4298g == 0) {
            return cVar;
        }
        o d10 = this.f4297f.d();
        cVar.f4297f = d10;
        d10.f4334g = d10;
        d10.f4333f = d10;
        o oVar = this.f4297f;
        while (true) {
            oVar = oVar.f4333f;
            if (oVar == this.f4297f) {
                cVar.f4298g = this.f4298g;
                return cVar;
            }
            cVar.f4297f.f4334g.c(oVar.d());
        }
    }

    @Override // bc.e
    public void R(long j10) {
        if (this.f4298g < j10) {
            throw new EOFException();
        }
    }

    @Override // bc.e
    public boolean T(long j10, f fVar) {
        return f0(j10, fVar, 0, fVar.B());
    }

    @Override // bc.e
    public long V(byte b10) {
        return e0(b10, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5 A[EDGE_INSN: B:41:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    @Override // bc.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long W() {
        /*
            r15 = this;
            long r0 = r15.f4298g
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            bc.o r6 = r15.f4297f
            byte[] r7 = r6.f4328a
            int r8 = r6.f4329b
            int r9 = r6.f4330c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            bc.c r0 = new bc.c
            r0.<init>()
            bc.c r0 = r0.o(r4)
            bc.c r0 = r0.A(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.k0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            bc.o r7 = r6.b()
            r15.f4297f = r7
            bc.p.a(r6)
            goto L9f
        L9d:
            r6.f4329b = r8
        L9f:
            if (r1 != 0) goto La5
            bc.o r6 = r15.f4297f
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.f4298g
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f4298g = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bc.c.W():long");
    }

    @Override // bc.e
    public String X(Charset charset) {
        try {
            return j0(this.f4298g, charset);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // bc.e
    public byte Z() {
        long j10 = this.f4298g;
        if (j10 == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f4297f;
        int i10 = oVar.f4329b;
        int i11 = oVar.f4330c;
        int i12 = i10 + 1;
        byte b10 = oVar.f4328a[i10];
        this.f4298g = j10 - 1;
        if (i12 == i11) {
            this.f4297f = oVar.b();
            p.a(oVar);
        } else {
            oVar.f4329b = i12;
        }
        return b10;
    }

    @Override // bc.e, bc.d
    public c a() {
        return this;
    }

    public final long a0() {
        long j10 = this.f4298g;
        if (j10 == 0) {
            return 0L;
        }
        o oVar = this.f4297f.f4334g;
        return (oVar.f4330c >= 8192 || !oVar.f4332e) ? j10 : j10 - (r3 - oVar.f4329b);
    }

    public final c b0(c cVar, long j10, long j11) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.b(this.f4298g, j10, j11);
        if (j11 == 0) {
            return this;
        }
        cVar.f4298g += j11;
        o oVar = this.f4297f;
        while (true) {
            int i10 = oVar.f4330c;
            int i11 = oVar.f4329b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            oVar = oVar.f4333f;
        }
        while (j11 > 0) {
            o d10 = oVar.d();
            int i12 = (int) (d10.f4329b + j10);
            d10.f4329b = i12;
            d10.f4330c = Math.min(i12 + ((int) j11), d10.f4330c);
            o oVar2 = cVar.f4297f;
            if (oVar2 == null) {
                d10.f4334g = d10;
                d10.f4333f = d10;
                cVar.f4297f = d10;
            } else {
                oVar2.f4334g.c(d10);
            }
            j11 -= d10.f4330c - d10.f4329b;
            oVar = oVar.f4333f;
            j10 = 0;
        }
        return this;
    }

    @Override // bc.d
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public c F() {
        return this;
    }

    @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void d() {
        try {
            q(this.f4298g);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public final byte d0(long j10) {
        int i10;
        u.b(this.f4298g, j10, 1L);
        long j11 = this.f4298g;
        if (j11 - j10 <= j10) {
            long j12 = j10 - j11;
            o oVar = this.f4297f;
            do {
                oVar = oVar.f4334g;
                int i11 = oVar.f4330c;
                i10 = oVar.f4329b;
                j12 += i11 - i10;
            } while (j12 < 0);
            return oVar.f4328a[i10 + ((int) j12)];
        }
        o oVar2 = this.f4297f;
        while (true) {
            int i12 = oVar2.f4330c;
            int i13 = oVar2.f4329b;
            long j13 = i12 - i13;
            if (j10 < j13) {
                return oVar2.f4328a[i13 + ((int) j10)];
            }
            j10 -= j13;
            oVar2 = oVar2.f4333f;
        }
    }

    @Override // bc.s
    public t e() {
        return t.f4339d;
    }

    public long e0(byte b10, long j10, long j11) {
        o oVar;
        long j12 = 0;
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f4298g), Long.valueOf(j10), Long.valueOf(j11)));
        }
        long j13 = this.f4298g;
        long j14 = j11 > j13 ? j13 : j11;
        if (j10 == j14 || (oVar = this.f4297f) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                oVar = oVar.f4334g;
                j13 -= oVar.f4330c - oVar.f4329b;
            }
        } else {
            while (true) {
                long j15 = (oVar.f4330c - oVar.f4329b) + j12;
                if (j15 >= j10) {
                    break;
                }
                oVar = oVar.f4333f;
                j12 = j15;
            }
            j13 = j12;
        }
        long j16 = j10;
        while (j13 < j14) {
            byte[] bArr = oVar.f4328a;
            int min = (int) Math.min(oVar.f4330c, (oVar.f4329b + j14) - j13);
            for (int i10 = (int) ((oVar.f4329b + j16) - j13); i10 < min; i10++) {
                if (bArr[i10] == b10) {
                    return (i10 - oVar.f4329b) + j13;
                }
            }
            j13 += oVar.f4330c - oVar.f4329b;
            oVar = oVar.f4333f;
            j16 = j13;
        }
        return -1L;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j10 = this.f4298g;
        if (j10 != cVar.f4298g) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        o oVar = this.f4297f;
        o oVar2 = cVar.f4297f;
        int i10 = oVar.f4329b;
        int i11 = oVar2.f4329b;
        while (j11 < this.f4298g) {
            long min = Math.min(oVar.f4330c - i10, oVar2.f4330c - i11);
            int i12 = 0;
            while (i12 < min) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (oVar.f4328a[i10] != oVar2.f4328a[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == oVar.f4330c) {
                oVar = oVar.f4333f;
                i10 = oVar.f4329b;
            }
            if (i11 == oVar2.f4330c) {
                oVar2 = oVar2.f4333f;
                i11 = oVar2.f4329b;
            }
            j11 += min;
        }
        return true;
    }

    public boolean f0(long j10, f fVar, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.f4298g - j10 < i11 || fVar.B() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (d0(i12 + j10) != fVar.u(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // bc.d, bc.r, java.io.Flushable
    public void flush() {
    }

    public int g0(byte[] bArr, int i10, int i11) {
        u.b(bArr.length, i10, i11);
        o oVar = this.f4297f;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i11, oVar.f4330c - oVar.f4329b);
        System.arraycopy(oVar.f4328a, oVar.f4329b, bArr, i10, min);
        int i12 = oVar.f4329b + min;
        oVar.f4329b = i12;
        this.f4298g -= min;
        if (i12 == oVar.f4330c) {
            this.f4297f = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public byte[] h0() {
        try {
            return B(this.f4298g);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public int hashCode() {
        o oVar = this.f4297f;
        if (oVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = oVar.f4330c;
            for (int i12 = oVar.f4329b; i12 < i11; i12++) {
                i10 = (i10 * 31) + oVar.f4328a[i12];
            }
            oVar = oVar.f4333f;
        } while (oVar != this.f4297f);
        return i10;
    }

    public f i0() {
        return new f(h0());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public String j0(long j10, Charset charset) {
        u.b(this.f4298g, 0L, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j10 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        }
        if (j10 == 0) {
            return "";
        }
        o oVar = this.f4297f;
        int i10 = oVar.f4329b;
        if (i10 + j10 > oVar.f4330c) {
            return new String(B(j10), charset);
        }
        String str = new String(oVar.f4328a, i10, (int) j10, charset);
        int i11 = (int) (oVar.f4329b + j10);
        oVar.f4329b = i11;
        this.f4298g -= j10;
        if (i11 == oVar.f4330c) {
            this.f4297f = oVar.b();
            p.a(oVar);
        }
        return str;
    }

    @Override // bc.e
    public void k(byte[] bArr) {
        int i10 = 0;
        while (i10 < bArr.length) {
            int g02 = g0(bArr, i10, bArr.length - i10);
            if (g02 == -1) {
                throw new EOFException();
            }
            i10 += g02;
        }
    }

    public String k0() {
        try {
            return j0(this.f4298g, u.f4343a);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // bc.r
    public void l(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.b(cVar.f4298g, 0L, j10);
        while (j10 > 0) {
            o oVar = cVar.f4297f;
            if (j10 < oVar.f4330c - oVar.f4329b) {
                o oVar2 = this.f4297f;
                o oVar3 = oVar2 != null ? oVar2.f4334g : null;
                if (oVar3 != null && oVar3.f4332e) {
                    if ((oVar3.f4330c + j10) - (oVar3.f4331d ? 0 : oVar3.f4329b) <= 8192) {
                        oVar.f(oVar3, (int) j10);
                        cVar.f4298g -= j10;
                        this.f4298g += j10;
                        return;
                    }
                }
                cVar.f4297f = oVar.e((int) j10);
            }
            o oVar4 = cVar.f4297f;
            long j11 = oVar4.f4330c - oVar4.f4329b;
            cVar.f4297f = oVar4.b();
            o oVar5 = this.f4297f;
            if (oVar5 == null) {
                this.f4297f = oVar4;
                oVar4.f4334g = oVar4;
                oVar4.f4333f = oVar4;
            } else {
                oVar5.f4334g.c(oVar4).a();
            }
            cVar.f4298g -= j11;
            this.f4298g += j11;
            j10 -= j11;
        }
    }

    public String l0(long j10) {
        return j0(j10, u.f4343a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m0(long j10) {
        String l02;
        long j11 = 1;
        if (j10 > 0) {
            long j12 = j10 - 1;
            if (d0(j12) == 13) {
                l02 = l0(j12);
                j11 = 2;
                q(j11);
                return l02;
            }
        }
        l02 = l0(j10);
        q(j11);
        return l02;
    }

    @Override // bc.d
    public long n(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long G = sVar.G(this, 8192L);
            if (G == -1) {
                return j10;
            }
            j10 += G;
        }
    }

    public final long n0() {
        return this.f4298g;
    }

    public final f o0() {
        long j10 = this.f4298g;
        if (j10 <= 2147483647L) {
            return p0((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f4298g);
    }

    @Override // bc.e
    public f p(long j10) {
        return new f(B(j10));
    }

    public final f p0(int i10) {
        return i10 == 0 ? f.f4300j : new q(this, i10);
    }

    @Override // bc.e
    public void q(long j10) {
        while (j10 > 0) {
            if (this.f4297f == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j10, r0.f4330c - r0.f4329b);
            long j11 = min;
            this.f4298g -= j11;
            j10 -= j11;
            o oVar = this.f4297f;
            int i10 = oVar.f4329b + min;
            oVar.f4329b = i10;
            if (i10 == oVar.f4330c) {
                this.f4297f = oVar.b();
                p.a(oVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o q0(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.f4297f;
        if (oVar != null) {
            o oVar2 = oVar.f4334g;
            return (oVar2.f4330c + i10 > 8192 || !oVar2.f4332e) ? oVar2.c(p.b()) : oVar2;
        }
        o b10 = p.b();
        this.f4297f = b10;
        b10.f4334g = b10;
        b10.f4333f = b10;
        return b10;
    }

    @Override // bc.d
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public c K(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.H(this);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        o oVar = this.f4297f;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f4330c - oVar.f4329b);
        byteBuffer.put(oVar.f4328a, oVar.f4329b, min);
        int i10 = oVar.f4329b + min;
        oVar.f4329b = i10;
        this.f4298g -= min;
        if (i10 == oVar.f4330c) {
            this.f4297f = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // bc.e
    public int s() {
        long j10 = this.f4298g;
        if (j10 < 4) {
            throw new IllegalStateException("size < 4: " + this.f4298g);
        }
        o oVar = this.f4297f;
        int i10 = oVar.f4329b;
        int i11 = oVar.f4330c;
        if (i11 - i10 < 4) {
            return ((Z() & 255) << 24) | ((Z() & 255) << 16) | ((Z() & 255) << 8) | (Z() & 255);
        }
        byte[] bArr = oVar.f4328a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = i16 | (bArr[i15] & 255);
        this.f4298g = j10 - 4;
        if (i17 == i11) {
            this.f4297f = oVar.b();
            p.a(oVar);
        } else {
            oVar.f4329b = i17;
        }
        return i18;
    }

    @Override // bc.d
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public c h(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // bc.d
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public c b(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = i11;
        u.b(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            o q02 = q0(1);
            int min = Math.min(i12 - i10, 8192 - q02.f4330c);
            System.arraycopy(bArr, i10, q02.f4328a, q02.f4330c, min);
            i10 += min;
            q02.f4330c += min;
        }
        this.f4298g += j10;
        return this;
    }

    public String toString() {
        return o0().toString();
    }

    @Override // bc.d
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public c A(int i10) {
        o q02 = q0(1);
        byte[] bArr = q02.f4328a;
        int i11 = q02.f4330c;
        q02.f4330c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f4298g++;
        return this;
    }

    @Override // bc.d
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public c U(long j10) {
        if (j10 == 0) {
            return A(48);
        }
        boolean z10 = false;
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return S("-9223372036854775808");
            }
            z10 = true;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < 10000000000L ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        o q02 = q0(i10);
        byte[] bArr = q02.f4328a;
        int i11 = q02.f4330c + i10;
        while (j10 != 0) {
            i11--;
            bArr[i11] = f4296h[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z10) {
            bArr[i11 - 1] = 45;
        }
        q02.f4330c += i10;
        this.f4298g += i10;
        return this;
    }

    @Override // bc.d
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public c o(long j10) {
        if (j10 == 0) {
            return A(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        o q02 = q0(numberOfTrailingZeros);
        byte[] bArr = q02.f4328a;
        int i10 = q02.f4330c;
        for (int i11 = (i10 + numberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = f4296h[(int) (15 & j10)];
            j10 >>>= 4;
        }
        q02.f4330c += numberOfTrailingZeros;
        this.f4298g += numberOfTrailingZeros;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            o q02 = q0(1);
            int min = Math.min(i10, 8192 - q02.f4330c);
            byteBuffer.get(q02.f4328a, q02.f4330c, min);
            i10 -= min;
            q02.f4330c += min;
        }
        this.f4298g += remaining;
        return remaining;
    }

    @Override // bc.e
    public String x() {
        return J(Long.MAX_VALUE);
    }

    @Override // bc.d
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public c t(int i10) {
        o q02 = q0(4);
        byte[] bArr = q02.f4328a;
        int i11 = q02.f4330c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        q02.f4330c = i14 + 1;
        this.f4298g += 4;
        return this;
    }

    @Override // bc.e
    public int y() {
        return u.c(s());
    }

    @Override // bc.d
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public c r(int i10) {
        o q02 = q0(2);
        byte[] bArr = q02.f4328a;
        int i11 = q02.f4330c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        q02.f4330c = i12 + 1;
        this.f4298g += 2;
        return this;
    }

    @Override // bc.e
    public boolean z() {
        return this.f4298g == 0;
    }

    public c z0(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(u.f4343a)) {
                return B0(str, i10, i11);
            }
            byte[] bytes = str.substring(i10, i11).getBytes(charset);
            return b(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
    }
}
