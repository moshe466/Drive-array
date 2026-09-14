package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.grpc.KnownLength;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class ReadableBuffers {
    private static final ReadableBuffer EMPTY_BUFFER = new ByteArrayWrapper(new byte[0]);

    /* loaded from: classes2.dex */
    private static final class BufferInputStream extends InputStream implements KnownLength {
        final ReadableBuffer a;

        public BufferInputStream(ReadableBuffer readableBuffer) {
            this.a = (ReadableBuffer) Preconditions.checkNotNull(readableBuffer, "buffer");
        }

        @Override // java.io.InputStream, io.grpc.KnownLength
        public int available() {
            return this.a.readableBytes();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.a.readableBytes() == 0) {
                return -1;
            }
            return this.a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (this.a.readableBytes() == 0) {
                return -1;
            }
            int min = Math.min(this.a.readableBytes(), i2);
            this.a.readBytes(bArr, i, min);
            return min;
        }
    }

    /* loaded from: classes2.dex */
    private static class ByteArrayWrapper extends AbstractReadableBuffer {
        int a;
        final int b;
        final byte[] c;

        ByteArrayWrapper(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        ByteArrayWrapper(byte[] bArr, int i, int i2) {
            Preconditions.checkArgument(i >= 0, "offset must be >= 0");
            Preconditions.checkArgument(i2 >= 0, "length must be >= 0");
            int i3 = i2 + i;
            Preconditions.checkArgument(i3 <= bArr.length, "offset + length exceeds array boundary");
            this.c = (byte[]) Preconditions.checkNotNull(bArr, "bytes");
            this.a = i;
            this.b = i3;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public byte[] array() {
            return this.c;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public int arrayOffset() {
            return this.a;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public boolean hasArray() {
            return true;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public ByteArrayWrapper readBytes(int i) {
            a(i);
            int i2 = this.a;
            this.a = i2 + i;
            return new ByteArrayWrapper(this.c, i2, i);
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(OutputStream outputStream, int i) {
            a(i);
            outputStream.write(this.c, this.a, i);
            this.a += i;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(ByteBuffer byteBuffer) {
            Preconditions.checkNotNull(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            a(remaining);
            byteBuffer.put(this.c, this.a, remaining);
            this.a += remaining;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(byte[] bArr, int i, int i2) {
            System.arraycopy(this.c, this.a, bArr, i, i2);
            this.a += i2;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readUnsignedByte() {
            a(1);
            byte[] bArr = this.c;
            int i = this.a;
            this.a = i + 1;
            return bArr[i] & 255;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readableBytes() {
            return this.b - this.a;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void skipBytes(int i) {
            a(i);
            this.a += i;
        }
    }

    /* loaded from: classes2.dex */
    private static class ByteReadableBufferWrapper extends AbstractReadableBuffer {
        final ByteBuffer a;

        ByteReadableBufferWrapper(ByteBuffer byteBuffer) {
            this.a = (ByteBuffer) Preconditions.checkNotNull(byteBuffer, "bytes");
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public byte[] array() {
            return this.a.array();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public int arrayOffset() {
            return this.a.arrayOffset() + this.a.position();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public boolean hasArray() {
            return this.a.hasArray();
        }

        @Override // io.grpc.internal.ReadableBuffer
        public ByteReadableBufferWrapper readBytes(int i) {
            a(i);
            ByteBuffer duplicate = this.a.duplicate();
            duplicate.limit(this.a.position() + i);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + i);
            return new ByteReadableBufferWrapper(duplicate);
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(OutputStream outputStream, int i) {
            a(i);
            if (hasArray()) {
                outputStream.write(array(), arrayOffset(), i);
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.position() + i);
            } else {
                byte[] bArr = new byte[i];
                this.a.get(bArr);
                outputStream.write(bArr);
            }
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(ByteBuffer byteBuffer) {
            Preconditions.checkNotNull(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            a(remaining);
            int limit = this.a.limit();
            ByteBuffer byteBuffer2 = this.a;
            byteBuffer2.limit(byteBuffer2.position() + remaining);
            byteBuffer.put(this.a);
            this.a.limit(limit);
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(byte[] bArr, int i, int i2) {
            a(i2);
            this.a.get(bArr, i, i2);
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readUnsignedByte() {
            a(1);
            return this.a.get() & 255;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readableBytes() {
            return this.a.remaining();
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void skipBytes(int i) {
            a(i);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + i);
        }
    }

    private ReadableBuffers() {
    }

    public static ReadableBuffer empty() {
        return EMPTY_BUFFER;
    }

    public static ReadableBuffer ignoreClose(ReadableBuffer readableBuffer) {
        return new ForwardingReadableBuffer(readableBuffer) { // from class: io.grpc.internal.ReadableBuffers.1
            @Override // io.grpc.internal.ForwardingReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    public static InputStream openStream(ReadableBuffer readableBuffer, boolean z) {
        if (!z) {
            readableBuffer = ignoreClose(readableBuffer);
        }
        return new BufferInputStream(readableBuffer);
    }

    public static byte[] readArray(ReadableBuffer readableBuffer) {
        Preconditions.checkNotNull(readableBuffer, "buffer");
        int readableBytes = readableBuffer.readableBytes();
        byte[] bArr = new byte[readableBytes];
        readableBuffer.readBytes(bArr, 0, readableBytes);
        return bArr;
    }

    public static String readAsString(ReadableBuffer readableBuffer, Charset charset) {
        Preconditions.checkNotNull(charset, HttpRequest.PARAM_CHARSET);
        return new String(readArray(readableBuffer), charset);
    }

    public static String readAsStringUtf8(ReadableBuffer readableBuffer) {
        return readAsString(readableBuffer, Charsets.UTF_8);
    }

    public static ReadableBuffer wrap(ByteBuffer byteBuffer) {
        return new ByteReadableBufferWrapper(byteBuffer);
    }

    public static ReadableBuffer wrap(byte[] bArr) {
        return new ByteArrayWrapper(bArr, 0, bArr.length);
    }

    public static ReadableBuffer wrap(byte[] bArr, int i, int i2) {
        return new ByteArrayWrapper(bArr, i, i2);
    }
}
