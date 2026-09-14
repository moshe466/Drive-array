package e3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class d extends FilterInputStream {
    private final d3.c afterRead;
    private boolean closed;
    private final d3.a exceptionHandler;

    public d(InputStream inputStream) {
        super(inputStream);
        this.exceptionHandler = new c(0);
        this.afterRead = d3.c.i;
    }

    public void afterRead(int i) {
        this.afterRead.getClass();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        if (((FilterInputStream) this).in != null && !isClosed()) {
            try {
                return ((FilterInputStream) this).in.available();
            } catch (IOException e4) {
                handleIOException(e4);
                return 0;
            }
        }
        return 0;
    }

    public void checkOpen() {
        if (!isClosed()) {
        } else {
            throw new IOException("Closed");
        }
    }

    public void handleIOException(IOException iOException) {
        this.exceptionHandler.accept(iOException);
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        if (((FilterInputStream) this).in != null) {
            ((FilterInputStream) this).in.mark(i);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        if (((FilterInputStream) this).in != null && ((FilterInputStream) this).in.markSupported()) {
            return true;
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i = 1;
        try {
            beforeRead(1);
            int read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                i = -1;
            }
            afterRead(i);
            return read;
        } catch (IOException e4) {
            handleIOException(e4);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e4) {
            handleIOException(e4);
        }
    }

    public d setReference(InputStream inputStream) {
        ((FilterInputStream) this).in = inputStream;
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        try {
            return ((FilterInputStream) this).in.skip(j2);
        } catch (IOException e4) {
            handleIOException(e4);
            return 0L;
        }
    }

    public InputStream unwrap() {
        return ((FilterInputStream) this).in;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        try {
            byte[] bArr2 = a3.c.f2765a;
            beforeRead(bArr == null ? 0 : bArr.length);
            int read = ((FilterInputStream) this).in.read(bArr);
            afterRead(read);
            return read;
        } catch (IOException e4) {
            handleIOException(e4);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i3) {
        try {
            beforeRead(i3);
            int read = ((FilterInputStream) this).in.read(bArr, i, i3);
            afterRead(read);
            return read;
        } catch (IOException e4) {
            handleIOException(e4);
            return -1;
        }
    }

    public void beforeRead(int i) {
    }
}
