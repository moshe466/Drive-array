package X0;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class b implements Y0.a, Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final Y0.a f2583a;

    /* renamed from: b, reason: collision with root package name */
    public Inflater f2584b = new Inflater(true);

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2585c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f2586d;

    /* renamed from: e, reason: collision with root package name */
    public long f2587e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2588f;

    public b(Y0.a aVar) {
        this.f2583a = aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2588f = true;
        this.f2586d = null;
        this.f2585c = null;
        Inflater inflater = this.f2584b;
        if (inflater != null) {
            inflater.end();
            this.f2584b = null;
        }
    }

    @Override // Y0.a
    public final void d(byte[] bArr, int i, int i3) {
        if (!this.f2588f) {
            this.f2584b.setInput(bArr, i, i3);
            if (this.f2585c == null) {
                this.f2585c = new byte[65536];
            }
            while (!this.f2584b.finished()) {
                try {
                    int inflate = this.f2584b.inflate(this.f2585c);
                    if (inflate != 0) {
                        this.f2583a.d(this.f2585c, 0, inflate);
                        this.f2587e += inflate;
                    } else {
                        return;
                    }
                } catch (DataFormatException e4) {
                    throw new IOException("Failed to inflate data", e4);
                }
            }
            return;
        }
        throw new IllegalStateException("Closed");
    }

    @Override // Y0.a
    public final void e(ByteBuffer byteBuffer) {
        if (!this.f2588f) {
            if (byteBuffer.hasArray()) {
                d(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            if (this.f2586d == null) {
                this.f2586d = new byte[65536];
            }
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(byteBuffer.remaining(), this.f2586d.length);
                byteBuffer.get(this.f2586d, 0, min);
                d(this.f2586d, 0, min);
            }
            return;
        }
        throw new IllegalStateException("Closed");
    }
}
