package org.apache.tika.io;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class TailStream extends FilterInputStream {
    private static final int SKIP_SIZE = 4096;
    private long bytesRead;
    private int currentIndex;
    private byte[] markBuffer;
    private long markBytesRead;
    private int markIndex;
    private final byte[] tailBuffer;
    private final int tailSize;

    public TailStream(InputStream inputStream, int i) {
        super(inputStream);
        this.tailSize = i;
        this.tailBuffer = new byte[i];
    }

    private void appendBuf(byte[] bArr, int i, int i3) {
        if (i3 >= this.tailSize) {
            replaceTailBuffer(bArr, i, i3);
        } else {
            copyToTailBuffer(bArr, i, i3);
        }
        this.bytesRead += i3;
    }

    private void appendByte(byte b4) {
        byte[] bArr = this.tailBuffer;
        int i = this.currentIndex;
        int i3 = i + 1;
        this.currentIndex = i3;
        bArr[i] = b4;
        if (i3 >= this.tailSize) {
            this.currentIndex = 0;
        }
        this.bytesRead++;
    }

    private void copyToTailBuffer(byte[] bArr, int i, int i3) {
        int min = Math.min(this.tailSize - this.currentIndex, i3);
        System.arraycopy(bArr, i, this.tailBuffer, this.currentIndex, min);
        System.arraycopy(bArr, i + min, this.tailBuffer, 0, i3 - min);
        this.currentIndex = (this.currentIndex + i3) % this.tailSize;
    }

    private void replaceTailBuffer(byte[] bArr, int i, int i3) {
        int i4 = i + i3;
        int i5 = this.tailSize;
        System.arraycopy(bArr, i4 - i5, this.tailBuffer, 0, i5);
        this.currentIndex = 0;
    }

    public byte[] getTail() {
        int min = (int) Math.min(this.tailSize, this.bytesRead);
        byte[] bArr = new byte[min];
        byte[] bArr2 = this.tailBuffer;
        int i = this.currentIndex;
        System.arraycopy(bArr2, i, bArr, 0, min - i);
        byte[] bArr3 = this.tailBuffer;
        int i3 = this.currentIndex;
        System.arraycopy(bArr3, 0, bArr, min - i3, i3);
        return bArr;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        int i3 = this.tailSize;
        byte[] bArr = new byte[i3];
        this.markBuffer = bArr;
        System.arraycopy(this.tailBuffer, 0, bArr, 0, i3);
        this.markIndex = this.currentIndex;
        this.markBytesRead = this.bytesRead;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read != -1) {
            appendByte((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        byte[] bArr = this.markBuffer;
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.tailBuffer, 0, this.tailSize);
            this.currentIndex = this.markIndex;
            this.bytesRead = this.markBytesRead;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        int min = (int) Math.min(j2, 4096L);
        byte[] bArr = new byte[min];
        long j3 = 0;
        int i = 0;
        while (j3 < j2 && i != -1) {
            i = read(bArr, 0, (int) Math.min(min, j2 - j3));
            if (i != -1) {
                j3 += i;
            }
        }
        if (i < 0 && j3 == 0) {
            return -1L;
        }
        return j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int read = super.read(bArr);
        if (read > 0) {
            appendBuf(bArr, 0, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i3) {
        int read = super.read(bArr, i, i3);
        if (read > 0) {
            appendBuf(bArr, i, read);
        }
        return read;
    }
}
