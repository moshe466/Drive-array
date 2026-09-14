package p2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes.dex */
final class f extends FilterInputStream {

    /* renamed from: f, reason: collision with root package name */
    private long f13040f;

    /* renamed from: g, reason: collision with root package name */
    private long f13041g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(InputStream inputStream, long j10) {
        super(inputStream);
        this.f13041g = -1L;
        Objects.requireNonNull(inputStream);
        this.f13040f = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.f13040f);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
        this.f13041g = this.f13040f;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (this.f13040f == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f13040f--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        long j10 = this.f13040f;
        if (j10 == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i10, (int) Math.min(i11, j10));
        if (read != -1) {
            this.f13040f -= read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f13041g == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f13040f = this.f13041g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j10) {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j10, this.f13040f));
        this.f13040f -= skip;
        return skip;
    }
}
