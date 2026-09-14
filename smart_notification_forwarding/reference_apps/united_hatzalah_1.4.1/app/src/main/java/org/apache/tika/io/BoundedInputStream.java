package org.apache.tika.io;

import a3.c;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BoundedInputStream extends InputStream {
    private static final int EOF = -1;
    private final InputStream in;
    private final long max;
    private long pos;

    public BoundedInputStream(long j2, InputStream inputStream) {
        this.max = j2;
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.in.available();
    }

    public long getPos() {
        return this.pos;
    }

    public boolean hasHitBound() {
        if (this.pos >= this.max) {
            return true;
        }
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        long j2 = this.max;
        if (j2 >= 0 && this.pos >= j2) {
            return -1;
        }
        int read = this.in.read();
        this.pos++;
        return read;
    }

    @Override // java.io.InputStream
    public byte[] readNBytes(int i) {
        byte[] readNBytes;
        readNBytes = this.in.readNBytes(i);
        return readNBytes;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.in.reset();
        this.pos = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        long j3 = this.max;
        if (j3 >= 0) {
            j2 = Math.min(j2, j3 - this.pos);
        }
        long skip = this.in.skip(j2);
        this.pos += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public long transferTo(OutputStream outputStream) {
        return c.b(this, outputStream);
    }

    @Override // java.io.InputStream
    public int readNBytes(byte[] bArr, int i, int i3) {
        int readNBytes;
        readNBytes = this.in.readNBytes(bArr, i, i3);
        return readNBytes;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i3) {
        long j2 = this.max;
        if (j2 >= 0 && this.pos >= j2) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) (j2 >= 0 ? Math.min(i3, j2 - this.pos) : i3));
        if (read == -1) {
            return -1;
        }
        this.pos += read;
        return read;
    }
}
