package bc;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class k implements s {

    /* renamed from: f, reason: collision with root package name */
    private final e f4312f;

    /* renamed from: g, reason: collision with root package name */
    private final Inflater f4313g;

    /* renamed from: h, reason: collision with root package name */
    private int f4314h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4315i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f4312f = eVar;
        this.f4313g = inflater;
    }

    private void d() {
        int i10 = this.f4314h;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f4313g.getRemaining();
        this.f4314h -= remaining;
        this.f4312f.q(remaining);
    }

    @Override // bc.s
    public long G(c cVar, long j10) {
        boolean c10;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f4315i) {
            throw new IllegalStateException("closed");
        }
        if (j10 == 0) {
            return 0L;
        }
        do {
            c10 = c();
            try {
                o q02 = cVar.q0(1);
                int inflate = this.f4313g.inflate(q02.f4328a, q02.f4330c, (int) Math.min(j10, 8192 - q02.f4330c));
                if (inflate > 0) {
                    q02.f4330c += inflate;
                    long j11 = inflate;
                    cVar.f4298g += j11;
                    return j11;
                }
                if (!this.f4313g.finished() && !this.f4313g.needsDictionary()) {
                }
                d();
                if (q02.f4329b != q02.f4330c) {
                    return -1L;
                }
                cVar.f4297f = q02.b();
                p.a(q02);
                return -1L;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        } while (!c10);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean c() {
        if (!this.f4313g.needsInput()) {
            return false;
        }
        d();
        if (this.f4313g.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f4312f.z()) {
            return true;
        }
        o oVar = this.f4312f.a().f4297f;
        int i10 = oVar.f4330c;
        int i11 = oVar.f4329b;
        int i12 = i10 - i11;
        this.f4314h = i12;
        this.f4313g.setInput(oVar.f4328a, i11, i12);
        return false;
    }

    @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f4315i) {
            return;
        }
        this.f4313g.end();
        this.f4315i = true;
        this.f4312f.close();
    }

    @Override // bc.s
    public t e() {
        return this.f4312f.e();
    }
}
