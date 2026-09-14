package bc;

import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: f, reason: collision with root package name */
    public final c f4322f = new c();

    /* renamed from: g, reason: collision with root package name */
    public final r f4323g;

    /* renamed from: h, reason: collision with root package name */
    boolean f4324h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        Objects.requireNonNull(rVar, "sink == null");
        this.f4323g = rVar;
    }

    @Override // bc.d
    public d A(int i10) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.A(i10);
        return F();
    }

    @Override // bc.d
    public d F() {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        long a02 = this.f4322f.a0();
        if (a02 > 0) {
            this.f4323g.l(this.f4322f, a02);
        }
        return this;
    }

    @Override // bc.d
    public d K(f fVar) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.K(fVar);
        return F();
    }

    @Override // bc.d
    public d S(String str) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.S(str);
        return F();
    }

    @Override // bc.d
    public d U(long j10) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.U(j10);
        return F();
    }

    @Override // bc.d
    public c a() {
        return this.f4322f;
    }

    @Override // bc.d
    public d b(byte[] bArr, int i10, int i11) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.b(bArr, i10, i11);
        return F();
    }

    @Override // bc.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f4324h) {
            return;
        }
        Throwable th = null;
        try {
            c cVar = this.f4322f;
            long j10 = cVar.f4298g;
            if (j10 > 0) {
                this.f4323g.l(cVar, j10);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f4323g.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f4324h = true;
        if (th != null) {
            u.e(th);
        }
    }

    @Override // bc.r
    public t e() {
        return this.f4323g.e();
    }

    @Override // bc.d, bc.r, java.io.Flushable
    public void flush() {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f4322f;
        long j10 = cVar.f4298g;
        if (j10 > 0) {
            this.f4323g.l(cVar, j10);
        }
        this.f4323g.flush();
    }

    @Override // bc.d
    public d h(byte[] bArr) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.h(bArr);
        return F();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f4324h;
    }

    @Override // bc.r
    public void l(c cVar, long j10) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.l(cVar, j10);
        F();
    }

    @Override // bc.d
    public long n(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long G = sVar.G(this.f4322f, 8192L);
            if (G == -1) {
                return j10;
            }
            j10 += G;
            F();
        }
    }

    @Override // bc.d
    public d o(long j10) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.o(j10);
        return F();
    }

    @Override // bc.d
    public d r(int i10) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.r(i10);
        return F();
    }

    @Override // bc.d
    public d t(int i10) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        this.f4322f.t(i10);
        return F();
    }

    public String toString() {
        return "buffer(" + this.f4323g + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.f4324h) {
            throw new IllegalStateException("closed");
        }
        int write = this.f4322f.write(byteBuffer);
        F();
        return write;
    }
}
