package bc;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements e {

    /* renamed from: f, reason: collision with root package name */
    public final c f4325f = new c();

    /* renamed from: g, reason: collision with root package name */
    public final s f4326g;

    /* renamed from: h, reason: collision with root package name */
    boolean f4327h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        Objects.requireNonNull(sVar, "source == null");
        this.f4326g = sVar;
    }

    @Override // bc.e
    public byte[] B(long j10) {
        R(j10);
        return this.f4325f.B(j10);
    }

    @Override // bc.e
    public short E() {
        R(2L);
        return this.f4325f.E();
    }

    @Override // bc.s
    public long G(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f4327h) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f4325f;
        if (cVar2.f4298g == 0 && this.f4326g.G(cVar2, 8192L) == -1) {
            return -1L;
        }
        return this.f4325f.G(cVar, Math.min(j10, this.f4325f.f4298g));
    }

    @Override // bc.e
    public String J(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long c10 = c((byte) 10, 0L, j11);
        if (c10 != -1) {
            return this.f4325f.m0(c10);
        }
        if (j11 < Long.MAX_VALUE && f(j11) && this.f4325f.d0(j11 - 1) == 13 && f(1 + j11) && this.f4325f.d0(j11) == 10) {
            return this.f4325f.m0(j11);
        }
        c cVar = new c();
        c cVar2 = this.f4325f;
        cVar2.b0(cVar, 0L, Math.min(32L, cVar2.n0()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f4325f.n0(), j10) + " content=" + cVar.i0().v() + (char) 8230);
    }

    @Override // bc.e
    public short L() {
        R(2L);
        return this.f4325f.L();
    }

    @Override // bc.e
    public void R(long j10) {
        if (!f(j10)) {
            throw new EOFException();
        }
    }

    @Override // bc.e
    public boolean T(long j10, f fVar) {
        return d(j10, fVar, 0, fVar.B());
    }

    @Override // bc.e
    public long V(byte b10) {
        return c(b10, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // bc.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long W() {
        /*
            r6 = this;
            r0 = 1
            r6.R(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.f(r3)
            if (r3 == 0) goto L4a
            bc.c r3 = r6.f4325f
            long r4 = (long) r1
            byte r3 = r3.d0(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            bc.c r0 = r6.f4325f
            long r0 = r0.W()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bc.n.W():long");
    }

    @Override // bc.e
    public String X(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f4325f.n(this.f4326g);
        return this.f4325f.X(charset);
    }

    @Override // bc.e
    public byte Z() {
        R(1L);
        return this.f4325f.Z();
    }

    @Override // bc.e, bc.d
    public c a() {
        return this.f4325f;
    }

    public long c(byte b10, long j10, long j11) {
        if (this.f4327h) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j10), Long.valueOf(j11)));
        }
        while (j10 < j11) {
            long e02 = this.f4325f.e0(b10, j10, j11);
            if (e02 == -1) {
                c cVar = this.f4325f;
                long j12 = cVar.f4298g;
                if (j12 >= j11 || this.f4326g.G(cVar, 8192L) == -1) {
                    break;
                }
                j10 = Math.max(j10, j12);
            } else {
                return e02;
            }
        }
        return -1L;
    }

    @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f4327h) {
            return;
        }
        this.f4327h = true;
        this.f4326g.close();
        this.f4325f.d();
    }

    public boolean d(long j10, f fVar, int i10, int i11) {
        if (this.f4327h) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || i10 < 0 || i11 < 0 || fVar.B() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            long j11 = i12 + j10;
            if (!f(1 + j11) || this.f4325f.d0(j11) != fVar.u(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // bc.s
    public t e() {
        return this.f4326g.e();
    }

    public boolean f(long j10) {
        c cVar;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f4327h) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f4325f;
            if (cVar.f4298g >= j10) {
                return true;
            }
        } while (this.f4326g.G(cVar, 8192L) != -1);
        return false;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f4327h;
    }

    @Override // bc.e
    public void k(byte[] bArr) {
        try {
            R(bArr.length);
            this.f4325f.k(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                c cVar = this.f4325f;
                long j10 = cVar.f4298g;
                if (j10 <= 0) {
                    throw e10;
                }
                int g02 = cVar.g0(bArr, i10, (int) j10);
                if (g02 == -1) {
                    throw new AssertionError();
                }
                i10 += g02;
            }
        }
    }

    @Override // bc.e
    public f p(long j10) {
        R(j10);
        return this.f4325f.p(j10);
    }

    @Override // bc.e
    public void q(long j10) {
        if (this.f4327h) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            c cVar = this.f4325f;
            if (cVar.f4298g == 0 && this.f4326g.G(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j10, this.f4325f.n0());
            this.f4325f.q(min);
            j10 -= min;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        c cVar = this.f4325f;
        if (cVar.f4298g == 0 && this.f4326g.G(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f4325f.read(byteBuffer);
    }

    @Override // bc.e
    public int s() {
        R(4L);
        return this.f4325f.s();
    }

    public String toString() {
        return "buffer(" + this.f4326g + ")";
    }

    @Override // bc.e
    public String x() {
        return J(Long.MAX_VALUE);
    }

    @Override // bc.e
    public int y() {
        R(4L);
        return this.f4325f.y();
    }

    @Override // bc.e
    public boolean z() {
        if (this.f4327h) {
            throw new IllegalStateException("closed");
        }
        return this.f4325f.z() && this.f4326g.G(this.f4325f, 8192L) == -1;
    }
}
