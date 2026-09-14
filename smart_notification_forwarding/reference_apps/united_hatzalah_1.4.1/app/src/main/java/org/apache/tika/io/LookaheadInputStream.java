package org.apache.tika.io;

import java.io.InputStream;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public class LookaheadInputStream extends InputStream {
    private final byte[] buffer;
    private InputStream stream;
    private int buffered = 0;
    private int position = 0;
    private int mark = 0;

    public LookaheadInputStream(InputStream inputStream, int i) {
        this.stream = inputStream;
        this.buffer = new byte[i];
        if (inputStream != null) {
            inputStream.mark(i);
        }
    }

    private void fill() {
        InputStream inputStream;
        if (available() == 0) {
            int i = this.buffered;
            byte[] bArr = this.buffer;
            if (i < bArr.length && (inputStream = this.stream) != null) {
                int read = inputStream.read(bArr, i, bArr.length - i);
                if (read != -1) {
                    this.buffered += read;
                } else {
                    close();
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.buffered - this.position;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            inputStream.reset();
            this.stream = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.mark = this.position;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        fill();
        int i = this.buffered;
        int i3 = this.position;
        if (i <= i3) {
            return -1;
        }
        byte[] bArr = this.buffer;
        this.position = i3 + 1;
        return bArr[i3] & ForkServer.ERROR;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.position = this.mark;
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        fill();
        long min = Math.min(j2, available());
        this.position = (int) (this.position + min);
        return min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i3) {
        fill();
        int i4 = this.buffered;
        int i5 = this.position;
        if (i4 <= i5) {
            return -1;
        }
        int min = Math.min(i3, i4 - i5);
        System.arraycopy(this.buffer, this.position, bArr, i, min);
        this.position += min;
        return min;
    }
}
