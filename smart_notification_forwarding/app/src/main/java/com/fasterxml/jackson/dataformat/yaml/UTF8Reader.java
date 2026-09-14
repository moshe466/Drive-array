package com.fasterxml.jackson.dataformat.yaml;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class UTF8Reader extends Reader {
    private static final int DEFAULT_BUFFER_SIZE = 8000;
    protected static final ThreadLocal<SoftReference<byte[][]>> _bufferRecycler = new ThreadLocal<>();
    private final boolean _autoClose;
    protected final byte[][] _bufferHolder;
    int _byteCount;
    int _charCount;
    protected byte[] _inputBuffer;
    protected int _inputEnd;
    protected int _inputPtr;
    private InputStream _inputSource;
    protected int _surrogate;
    private char[] _tmpBuffer;

    public UTF8Reader(InputStream inputStream, boolean z) {
        super(inputStream == null ? new Object() : inputStream);
        this._surrogate = -1;
        this._charCount = 0;
        this._byteCount = 0;
        this._tmpBuffer = null;
        this._inputSource = inputStream;
        byte[][] _findBufferHolder = _findBufferHolder();
        this._bufferHolder = _findBufferHolder;
        byte[] bArr = _findBufferHolder[0];
        if (bArr == null) {
            bArr = new byte[DEFAULT_BUFFER_SIZE];
        } else {
            _findBufferHolder[0] = null;
        }
        this._inputBuffer = bArr;
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._autoClose = z;
    }

    public UTF8Reader(byte[] bArr, int i, int i2, boolean z) {
        super(new Object());
        this._surrogate = -1;
        this._charCount = 0;
        this._byteCount = 0;
        this._tmpBuffer = null;
        this._inputSource = null;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputEnd = i + i2;
        this._autoClose = z;
        this._bufferHolder = null;
    }

    private static byte[][] _findBufferHolder() {
        ThreadLocal<SoftReference<byte[][]>> threadLocal = _bufferRecycler;
        SoftReference<byte[][]> softReference = threadLocal.get();
        byte[][] bArr = softReference != null ? softReference.get() : null;
        if (bArr != null) {
            return bArr;
        }
        byte[][] bArr2 = new byte[1];
        threadLocal.set(new SoftReference<>(bArr2));
        return bArr2;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this._inputSource;
        if (inputStream != null) {
            this._inputSource = null;
            if (this._autoClose) {
                inputStream.close();
            }
        }
        freeBuffers();
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this._tmpBuffer == null) {
            this._tmpBuffer = new char[1];
        }
        if (read(this._tmpBuffer, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuffer[0];
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0087 A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(char[] r16, int r17, int r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.UTF8Reader.read(char[], int, int):int");
    }

    protected final InputStream getStream() {
        return this._inputSource;
    }

    protected final int readBytes() throws IOException {
        this._inputPtr = 0;
        this._inputEnd = 0;
        InputStream inputStream = this._inputSource;
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read > 0) {
            this._inputEnd = read;
        }
        return read;
    }

    protected final int readBytesAt(int i) throws IOException {
        InputStream inputStream = this._inputSource;
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int read = inputStream.read(bArr, i, bArr.length - i);
        if (read > 0) {
            this._inputEnd += read;
        }
        return read;
    }

    public final void freeBuffers() {
        byte[] bArr;
        byte[][] bArr2 = this._bufferHolder;
        if (bArr2 == null || (bArr = this._inputBuffer) == null) {
            return;
        }
        this._inputBuffer = null;
        bArr2[0] = bArr;
    }

    private void reportInvalidInitial(int i, int i2) throws IOException {
        throw new CharConversionException("Invalid UTF-8 start byte 0x" + Integer.toHexString(i) + " (at char #" + (this._charCount + i2 + 1) + ", byte #" + ((this._byteCount + this._inputPtr) - 1) + ")");
    }

    private void reportInvalidOther(int i, int i2) throws IOException {
        throw new CharConversionException("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i) + " (at char #" + (this._charCount + i2) + ", byte #" + ((this._byteCount + this._inputPtr) - 1) + ")");
    }

    private void reportUnexpectedEOF(int i, int i2) throws IOException {
        throw new CharConversionException("Unexpected EOF in the middle of a multi-byte char: got " + i + ", needed " + i2 + ", at char #" + this._charCount + ", byte #" + (this._byteCount + i) + ")");
    }

    private boolean loadMore(int i) throws IOException {
        int i2;
        this._byteCount += this._inputEnd - i;
        if (i > 0) {
            if (this._inputPtr > 0) {
                if (this._bufferHolder == null) {
                    throw new IllegalStateException("Internal error: need to move partially decoded character; buffer not modifiable");
                }
                for (int i3 = 0; i3 < i; i3++) {
                    byte[] bArr = this._inputBuffer;
                    bArr[i3] = bArr[this._inputPtr + i3];
                }
                this._inputPtr = 0;
                this._inputEnd = i;
            }
        } else {
            int readBytes = readBytes();
            if (readBytes < 1) {
                freeBuffers();
                if (readBytes < 0) {
                    return false;
                }
                reportStrangeStream();
            }
        }
        byte b = this._inputBuffer[this._inputPtr];
        if (b >= 0) {
            return true;
        }
        if ((b & 224) == 192) {
            i2 = 2;
        } else if ((b & 240) == 224) {
            i2 = 3;
        } else if ((b & 248) == 240) {
            i2 = 4;
        } else {
            reportInvalidInitial(b & UByte.MAX_VALUE, 0);
            i2 = 1;
        }
        while (true) {
            int i4 = this._inputPtr + i2;
            int i5 = this._inputEnd;
            if (i4 <= i5) {
                return true;
            }
            int readBytesAt = readBytesAt(i5);
            if (readBytesAt < 1) {
                if (readBytesAt < 0) {
                    freeBuffers();
                    reportUnexpectedEOF(this._inputEnd, i2);
                }
                reportStrangeStream();
            }
        }
    }

    protected void reportBounds(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    protected void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
