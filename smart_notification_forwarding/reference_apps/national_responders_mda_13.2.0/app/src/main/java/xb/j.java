package xb;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xb.d;

/* loaded from: classes.dex */
final class j implements Closeable {

    /* renamed from: l, reason: collision with root package name */
    private static final Logger f15811l = Logger.getLogger(e.class.getName());

    /* renamed from: f, reason: collision with root package name */
    private final bc.d f15812f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f15813g;

    /* renamed from: h, reason: collision with root package name */
    private final bc.c f15814h;

    /* renamed from: i, reason: collision with root package name */
    private int f15815i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f15816j;

    /* renamed from: k, reason: collision with root package name */
    final d.b f15817k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(bc.d dVar, boolean z10) {
        this.f15812f = dVar;
        this.f15813g = z10;
        bc.c cVar = new bc.c();
        this.f15814h = cVar;
        this.f15817k = new d.b(cVar);
        this.f15815i = 16384;
    }

    private void d0(int i10, long j10) {
        while (j10 > 0) {
            int min = (int) Math.min(this.f15815i, j10);
            long j11 = min;
            j10 -= j11;
            j(i10, min, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.f15812f.l(this.f15814h, j11);
        }
    }

    private static void e0(bc.d dVar, int i10) {
        dVar.A((i10 >>> 16) & 255);
        dVar.A((i10 >>> 8) & 255);
        dVar.A(i10 & 255);
    }

    void D(boolean z10, int i10, List<c> list) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        this.f15817k.g(list);
        long n02 = this.f15814h.n0();
        int min = (int) Math.min(this.f15815i, n02);
        long j10 = min;
        byte b10 = n02 == j10 ? (byte) 4 : (byte) 0;
        if (z10) {
            b10 = (byte) (b10 | 1);
        }
        j(i10, min, (byte) 1, b10);
        this.f15812f.l(this.f15814h, j10);
        if (n02 > j10) {
            d0(i10, n02 - j10);
        }
    }

    public int H() {
        return this.f15815i;
    }

    public synchronized void M(boolean z10, int i10, int i11) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        j(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
        this.f15812f.t(i10);
        this.f15812f.t(i11);
        this.f15812f.flush();
    }

    public synchronized void N(int i10, int i11, List<c> list) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        this.f15817k.g(list);
        long n02 = this.f15814h.n0();
        int min = (int) Math.min(this.f15815i - 4, n02);
        long j10 = min;
        j(i10, min + 4, (byte) 5, n02 == j10 ? (byte) 4 : (byte) 0);
        this.f15812f.t(i11 & Integer.MAX_VALUE);
        this.f15812f.l(this.f15814h, j10);
        if (n02 > j10) {
            d0(i10, n02 - j10);
        }
    }

    public synchronized void O(int i10, b bVar) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        if (bVar.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        j(i10, 4, (byte) 3, (byte) 0);
        this.f15812f.t(bVar.httpCode);
        this.f15812f.flush();
    }

    public synchronized void a0(m mVar) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        int i10 = 0;
        j(0, mVar.j() * 6, (byte) 4, (byte) 0);
        while (i10 < 10) {
            if (mVar.g(i10)) {
                this.f15812f.r(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                this.f15812f.t(mVar.b(i10));
            }
            i10++;
        }
        this.f15812f.flush();
    }

    public synchronized void b0(boolean z10, int i10, int i11, List<c> list) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        D(z10, i10, list);
    }

    public synchronized void c(m mVar) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        this.f15815i = mVar.f(this.f15815i);
        if (mVar.c() != -1) {
            this.f15817k.e(mVar.c());
        }
        j(0, 0, (byte) 4, (byte) 1);
        this.f15812f.flush();
    }

    public synchronized void c0(int i10, long j10) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            throw e.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
        j(i10, 4, (byte) 8, (byte) 0);
        this.f15812f.t((int) j10);
        this.f15812f.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f15816j = true;
        this.f15812f.close();
    }

    public synchronized void d() {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        if (this.f15813g) {
            Logger logger = f15811l;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(sb.c.r(">> CONNECTION %s", e.f15701a.v()));
            }
            this.f15812f.h(e.f15701a.F());
            this.f15812f.flush();
        }
    }

    public synchronized void f(boolean z10, int i10, bc.c cVar, int i11) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        g(i10, z10 ? (byte) 1 : (byte) 0, cVar, i11);
    }

    public synchronized void flush() {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        this.f15812f.flush();
    }

    void g(int i10, byte b10, bc.c cVar, int i11) {
        j(i10, i11, (byte) 0, b10);
        if (i11 > 0) {
            this.f15812f.l(cVar, i11);
        }
    }

    public void j(int i10, int i11, byte b10, byte b11) {
        Logger logger = f15811l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.b(false, i10, i11, b10, b11));
        }
        int i12 = this.f15815i;
        if (i11 > i12) {
            throw e.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw e.c("reserved bit set: %s", Integer.valueOf(i10));
        }
        e0(this.f15812f, i11);
        this.f15812f.A(b10 & 255);
        this.f15812f.A(b11 & 255);
        this.f15812f.t(i10 & Integer.MAX_VALUE);
    }

    public synchronized void v(int i10, b bVar, byte[] bArr) {
        if (this.f15816j) {
            throw new IOException("closed");
        }
        if (bVar.httpCode == -1) {
            throw e.c("errorCode.httpCode == -1", new Object[0]);
        }
        j(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f15812f.t(i10);
        this.f15812f.t(bVar.httpCode);
        if (bArr.length > 0) {
            this.f15812f.h(bArr);
        }
        this.f15812f.flush();
    }
}
