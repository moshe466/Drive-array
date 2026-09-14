package bc;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class j implements s {

    /* renamed from: g, reason: collision with root package name */
    private final e f4308g;

    /* renamed from: h, reason: collision with root package name */
    private final Inflater f4309h;

    /* renamed from: i, reason: collision with root package name */
    private final k f4310i;

    /* renamed from: f, reason: collision with root package name */
    private int f4307f = 0;

    /* renamed from: j, reason: collision with root package name */
    private final CRC32 f4311j = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f4309h = inflater;
        e b10 = l.b(sVar);
        this.f4308g = b10;
        this.f4310i = new k(b10, inflater);
    }

    private void c(String str, int i10, int i11) {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    private void d() {
        this.f4308g.R(10L);
        byte d02 = this.f4308g.a().d0(3L);
        boolean z10 = ((d02 >> 1) & 1) == 1;
        if (z10) {
            g(this.f4308g.a(), 0L, 10L);
        }
        c("ID1ID2", 8075, this.f4308g.L());
        this.f4308g.q(8L);
        if (((d02 >> 2) & 1) == 1) {
            this.f4308g.R(2L);
            if (z10) {
                g(this.f4308g.a(), 0L, 2L);
            }
            long E = this.f4308g.a().E();
            this.f4308g.R(E);
            if (z10) {
                g(this.f4308g.a(), 0L, E);
            }
            this.f4308g.q(E);
        }
        if (((d02 >> 3) & 1) == 1) {
            long V = this.f4308g.V((byte) 0);
            if (V == -1) {
                throw new EOFException();
            }
            if (z10) {
                g(this.f4308g.a(), 0L, V + 1);
            }
            this.f4308g.q(V + 1);
        }
        if (((d02 >> 4) & 1) == 1) {
            long V2 = this.f4308g.V((byte) 0);
            if (V2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                g(this.f4308g.a(), 0L, V2 + 1);
            }
            this.f4308g.q(V2 + 1);
        }
        if (z10) {
            c("FHCRC", this.f4308g.E(), (short) this.f4311j.getValue());
            this.f4311j.reset();
        }
    }

    private void f() {
        c("CRC", this.f4308g.y(), (int) this.f4311j.getValue());
        c("ISIZE", this.f4308g.y(), (int) this.f4309h.getBytesWritten());
    }

    private void g(c cVar, long j10, long j11) {
        o oVar = cVar.f4297f;
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
            int min = (int) Math.min(oVar.f4330c - r7, j11);
            this.f4311j.update(oVar.f4328a, (int) (oVar.f4329b + j10), min);
            j11 -= min;
            oVar = oVar.f4333f;
            j10 = 0;
        }
    }

    @Override // bc.s
    public long G(c cVar, long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f4307f == 0) {
            d();
            this.f4307f = 1;
        }
        if (this.f4307f == 1) {
            long j11 = cVar.f4298g;
            long G = this.f4310i.G(cVar, j10);
            if (G != -1) {
                g(cVar, j11, G);
                return G;
            }
            this.f4307f = 2;
        }
        if (this.f4307f == 2) {
            f();
            this.f4307f = 3;
            if (!this.f4308g.z()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4310i.close();
    }

    @Override // bc.s
    public t e() {
        return this.f4308g.e();
    }
}
