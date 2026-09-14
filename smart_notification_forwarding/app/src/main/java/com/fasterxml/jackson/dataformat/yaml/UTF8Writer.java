package com.fasterxml.jackson.dataformat.yaml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public final class UTF8Writer extends Writer {
    private static final int DEFAULT_BUFFER_SIZE = 8000;
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    protected static final ThreadLocal<SoftReference<byte[][]>> _bufferRecycler = new ThreadLocal<>();
    protected final byte[][] _bufferHolder;
    private OutputStream _out;
    private byte[] _outBuffer;
    private final int _outBufferEnd;
    private int _outPtr;
    int _surrogate = 0;

    public UTF8Writer(OutputStream outputStream) {
        this._out = outputStream;
        byte[][] _findBufferHolder = _findBufferHolder();
        this._bufferHolder = _findBufferHolder;
        byte[] bArr = _findBufferHolder[0];
        if (bArr == null) {
            bArr = new byte[DEFAULT_BUFFER_SIZE];
        } else {
            _findBufferHolder[0] = null;
        }
        this._outBuffer = bArr;
        this._outBufferEnd = bArr.length - 4;
        this._outPtr = 0;
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

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] bArr;
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            OutputStream outputStream2 = this._out;
            this._out = null;
            byte[][] bArr2 = this._bufferHolder;
            if (bArr2 != null && (bArr = this._outBuffer) != null) {
                this._outBuffer = null;
                bArr2[0] = bArr;
            }
            outputStream2.close();
            int i2 = this._surrogate;
            this._surrogate = 0;
            if (i2 > 0) {
                throwIllegal(i2);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0025, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(char[] r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.UTF8Writer.write(char[], int, int):void");
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        int i2;
        if (this._surrogate > 0) {
            i = convertSurrogate(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                throwIllegal(i);
            }
            this._surrogate = i;
            return;
        }
        int i3 = this._outPtr;
        if (i3 >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, i3);
            this._outPtr = 0;
        }
        if (i < 128) {
            byte[] bArr = this._outBuffer;
            int i4 = this._outPtr;
            this._outPtr = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        int i5 = this._outPtr;
        if (i < 2048) {
            byte[] bArr2 = this._outBuffer;
            int i6 = i5 + 1;
            bArr2[i5] = (byte) ((i >> 6) | 192);
            i2 = i6 + 1;
            bArr2[i6] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            byte[] bArr3 = this._outBuffer;
            int i7 = i5 + 1;
            bArr3[i5] = (byte) ((i >> 12) | 224);
            int i8 = i7 + 1;
            bArr3[i7] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i8] = (byte) ((i & 63) | 128);
            i2 = i8 + 1;
        } else {
            if (i > 1114111) {
                throwIllegal(i);
            }
            byte[] bArr4 = this._outBuffer;
            int i9 = i5 + 1;
            bArr4[i5] = (byte) ((i >> 18) | 240);
            int i10 = i9 + 1;
            bArr4[i9] = (byte) (((i >> 12) & 63) | 128);
            int i11 = i10 + 1;
            bArr4[i10] = (byte) (((i >> 6) & 63) | 128);
            i2 = i11 + 1;
            bArr4[i11] = (byte) ((i & 63) | 128);
        }
        this._outPtr = i2;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0029, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(java.lang.String r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.UTF8Writer.write(java.lang.String, int, int):void");
    }

    private int convertSurrogate(int i) throws IOException {
        int i2 = this._surrogate;
        this._surrogate = 0;
        if (i < 56320 || i > 57343) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
        }
        return ((i2 - 55296) << 10) + 65536 + (i - 56320);
    }

    private void throwIllegal(int i) throws IOException {
        if (i > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i < 55296) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i <= 56319) {
            throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }
}
