package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    @Nullable
    Segment a;
    long b;

    /* loaded from: classes3.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            }
            if (i > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = buffer.b;
            Segment a = buffer.a(i);
            int i2 = 8192 - a.c;
            a.c = 8192;
            long j2 = i2;
            this.buffer.b = j + j2;
            this.segment = a;
            this.offset = j;
            this.data = a.a;
            this.start = 8192 - i2;
            this.end = 8192;
            return j2;
        }

        public final int next() {
            long j = this.offset;
            if (j != this.buffer.b) {
                return seek(j == -1 ? 0L : j + (this.end - this.start));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.b;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    Buffer buffer2 = this.buffer;
                    Segment segment = buffer2.a.g;
                    int i = segment.c;
                    long j4 = i - segment.b;
                    if (j4 > j3) {
                        segment.c = (int) (i - j3);
                        break;
                    }
                    buffer2.a = segment.pop();
                    SegmentPool.a(segment);
                    j3 -= j4;
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    Segment a = this.buffer.a(1);
                    int min = (int) Math.min(j5, 8192 - a.c);
                    a.c += min;
                    j5 -= min;
                    if (z) {
                        this.segment = a;
                        this.offset = j2;
                        this.data = a.a;
                        int i2 = a.c;
                        this.start = i2 - min;
                        this.end = i2;
                        z = false;
                    }
                }
            }
            this.buffer.b = j;
            return j2;
        }

        public final int seek(long j) {
            if (j >= -1) {
                Buffer buffer = this.buffer;
                long j2 = buffer.b;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    long j3 = 0;
                    Segment segment = buffer.a;
                    Segment segment2 = this.segment;
                    if (segment2 != null) {
                        long j4 = this.offset - (this.start - segment2.b);
                        if (j4 > j) {
                            j2 = j4;
                            segment2 = segment;
                            segment = segment2;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segment2 = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = segment2.c;
                            int i2 = segment2.b;
                            if (j < (i - i2) + j3) {
                                break;
                            }
                            j3 += i - i2;
                            segment2 = segment2.f;
                        }
                    } else {
                        segment2 = segment;
                        j3 = j2;
                        while (j3 > j) {
                            segment2 = segment2.g;
                            j3 -= segment2.c - segment2.b;
                        }
                    }
                    if (this.readWrite && segment2.d) {
                        Segment b = segment2.b();
                        Buffer buffer2 = this.buffer;
                        if (buffer2.a == segment2) {
                            buffer2.a = b;
                        }
                        segment2 = segment2.push(b);
                        segment2.g.pop();
                    }
                    this.segment = segment2;
                    this.offset = j;
                    this.data = segment2.a;
                    this.start = segment2.b + ((int) (j - j3));
                    this.end = segment2.c;
                    return this.end - this.start;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.b)));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (this.a != null) {
                messageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
                Segment segment = this.a;
                while (true) {
                    segment = segment.f;
                    if (segment == this.a) {
                        break;
                    }
                    messageDigest.update(segment.a, segment.b, segment.c - segment.b);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            if (this.a != null) {
                mac.update(this.a.a, this.a.b, this.a.c - this.a.b);
                Segment segment = this.a;
                while (true) {
                    segment = segment.f;
                    if (segment == this.a) {
                        break;
                    }
                    mac.update(segment.a, segment.b, segment.c - segment.b);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private boolean rangeEquals(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.c;
        byte[] bArr = segment.a;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.f;
                byte[] bArr2 = segment.a;
                bArr = bArr2;
                i = segment.b;
                i4 = segment.c;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    private void readFrom(InputStream inputStream, long j, boolean z) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment a = a(1);
            int read = inputStream.read(a.a, a.c, (int) Math.min(j, 8192 - a.c));
            if (read == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            } else {
                a.c += read;
                long j2 = read;
                this.b += j2;
                j -= j2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(okio.Options r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            okio.Segment r2 = r1.a
            r3 = -2
            if (r2 != 0) goto L13
            if (r19 == 0) goto Lc
            return r3
        Lc:
            okio.ByteString r2 = okio.ByteString.EMPTY
            int r0 = r0.indexOf(r2)
            return r0
        L13:
            byte[] r4 = r2.a
            int r5 = r2.b
            int r6 = r2.c
            int[] r0 = r0.b
            r7 = 0
            r8 = -1
            r9 = r5
            r11 = r6
            r10 = -1
            r5 = r2
            r6 = r4
            r4 = 0
        L23:
            int r12 = r4 + 1
            r4 = r0[r4]
            int r13 = r12 + 1
            r12 = r0[r12]
            if (r12 == r8) goto L2e
            r10 = r12
        L2e:
            if (r5 != 0) goto L31
            goto L58
        L31:
            r12 = 0
            if (r4 >= 0) goto L6c
            int r4 = r4 * (-1)
            int r14 = r13 + r4
        L38:
            int r4 = r9 + 1
            r9 = r6[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r15 = r13 + 1
            r13 = r0[r13]
            if (r9 == r13) goto L45
            return r10
        L45:
            if (r15 != r14) goto L49
            r9 = 1
            goto L4a
        L49:
            r9 = 0
        L4a:
            if (r4 != r11) goto L64
            okio.Segment r4 = r5.f
            int r5 = r4.b
            byte[] r6 = r4.a
            int r11 = r4.c
            if (r4 != r2) goto L5f
            if (r9 != 0) goto L5c
        L58:
            if (r19 == 0) goto L5b
            return r3
        L5b:
            return r10
        L5c:
            r4 = r5
            r5 = r12
            goto L64
        L5f:
            r16 = r5
            r5 = r4
            r4 = r16
        L64:
            if (r9 == 0) goto L69
            r9 = r0[r15]
            goto L91
        L69:
            r9 = r4
            r13 = r15
            goto L38
        L6c:
            int r14 = r9 + 1
            r9 = r6[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r15 = r13 + r4
        L74:
            if (r13 != r15) goto L77
            return r10
        L77:
            r3 = r0[r13]
            if (r9 != r3) goto L99
            int r13 = r13 + r4
            r9 = r0[r13]
            if (r14 != r11) goto L90
            okio.Segment r3 = r5.f
            int r4 = r3.b
            byte[] r5 = r3.a
            int r6 = r3.c
            r11 = r6
            r6 = r5
            if (r3 != r2) goto L8e
            r5 = r12
            goto L91
        L8e:
            r5 = r3
            goto L91
        L90:
            r4 = r14
        L91:
            if (r9 < 0) goto L94
            return r9
        L94:
            int r3 = -r9
            r9 = r4
            r4 = r3
            r3 = -2
            goto L23
        L99:
            int r13 = r13 + 1
            r3 = -2
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.a(okio.Options, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(long j) {
        String readUtf8;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (getByte(j3) == 13) {
                readUtf8 = readUtf8(j3);
                j2 = 2;
                skip(j2);
                return readUtf8;
            }
        }
        readUtf8 = readUtf8(j);
        skip(j2);
        return readUtf8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment a(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.a;
        if (segment != null) {
            Segment segment2 = segment.g;
            return (segment2.c + i > 8192 || !segment2.e) ? segment2.push(SegmentPool.a()) : segment2;
        }
        this.a = SegmentPool.a();
        Segment segment3 = this.a;
        segment3.g = segment3;
        segment3.f = segment3;
        return segment3;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.b == 0) {
            return buffer;
        }
        buffer.a = this.a.a();
        Segment segment = buffer.a;
        segment.g = segment;
        segment.f = segment;
        Segment segment2 = this.a;
        while (true) {
            segment2 = segment2.f;
            if (segment2 == this.a) {
                buffer.b = this.b;
                return buffer;
            }
            buffer.a.g.push(segment2.a());
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.a.g;
        return (segment.c >= 8192 || !segment.e) ? j : j - (r3 - segment.b);
    }

    public final Buffer copyTo(OutputStream outputStream) {
        return copyTo(outputStream, 0L, this.b);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.b, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.a;
        while (true) {
            int i = segment.c;
            int i2 = segment.b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.c - r10, j2);
            outputStream.write(segment.a, (int) (segment.b + j), min);
            j2 -= min;
            segment = segment.f;
            j = 0;
        }
        return this;
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.b, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.b += j2;
        Segment segment = this.a;
        while (true) {
            int i = segment.c;
            int i2 = segment.b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.f;
        }
        while (j2 > 0) {
            Segment a = segment.a();
            a.b = (int) (a.b + j);
            a.c = Math.min(a.b + ((int) j2), a.c);
            Segment segment2 = buffer.a;
            if (segment2 == null) {
                a.g = a;
                a.f = a;
                buffer.a = a;
            } else {
                segment2.g.push(a);
            }
            j2 -= a.c - a.b;
            segment = segment.f;
            j = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.b;
        if (j != buffer.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment segment = this.a;
        Segment segment2 = buffer.a;
        int i = segment.b;
        int i2 = segment2.b;
        while (j2 < this.b) {
            long min = Math.min(segment.c - i, segment2.c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (i5 < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (segment.a[i4] != segment2.a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == segment.c) {
                segment = segment.f;
                i = segment.b;
            } else {
                i = i4;
            }
            if (i3 == segment2.c) {
                segment2 = segment2.f;
                i2 = segment2.b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.b == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    public final byte getByte(long j) {
        int i;
        Util.checkOffsetAndCount(this.b, j, 1L);
        long j2 = this.b;
        if (j2 - j <= j) {
            long j3 = j - j2;
            Segment segment = this.a;
            do {
                segment = segment.g;
                int i2 = segment.c;
                i = segment.b;
                j3 += i2 - i;
            } while (j3 < 0);
            return segment.a[i + ((int) j3)];
        }
        Segment segment2 = this.a;
        while (true) {
            int i3 = segment2.c;
            int i4 = segment2.b;
            long j4 = i3 - i4;
            if (j < j4) {
                return segment2.a[i4 + ((int) j)];
            }
            j -= j4;
            segment2 = segment2.f;
        }
    }

    public int hashCode() {
        Segment segment = this.a;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.c;
            for (int i3 = segment.b; i3 < i2; i3++) {
                i = (i * 31) + segment.a[i3];
            }
            segment = segment.f;
        } while (segment != this.a);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (segment = this.a) == null) {
            return -1L;
        }
        long j5 = this.b;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = (segment.c - segment.b) + j5;
                if (j3 >= j) {
                    break;
                }
                segment = segment.f;
            }
        } else {
            while (j5 > j) {
                segment = segment.g;
                j5 -= segment.c - segment.b;
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = segment.a;
            int min = (int) Math.min(segment.c, (segment.b + j4) - j5);
            for (int i = (int) ((segment.b + j6) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - segment.b) + j5;
                }
            }
            j6 = (segment.c - segment.b) + j5;
            segment = segment.f;
            j5 = j6;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) {
        byte[] bArr;
        Segment segment;
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment2 = this.a;
        long j3 = -1;
        if (segment2 == null) {
            return -1L;
        }
        long j4 = this.b;
        if (j4 - j >= j) {
            while (true) {
                j4 = j2;
                j2 = (segment2.c - segment2.b) + j4;
                if (j2 >= j) {
                    break;
                }
                segment2 = segment2.f;
            }
        } else {
            while (j4 > j) {
                segment2 = segment2.g;
                j4 -= segment2.c - segment2.b;
            }
        }
        byte b = byteString.getByte(0);
        int size = byteString.size();
        long j5 = 1 + (this.b - size);
        long j6 = j;
        Segment segment3 = segment2;
        long j7 = j4;
        while (j7 < j5) {
            byte[] bArr2 = segment3.a;
            int min = (int) Math.min(segment3.c, (segment3.b + j5) - j7);
            int i = (int) ((segment3.b + j6) - j7);
            while (i < min) {
                if (bArr2[i] == b) {
                    bArr = bArr2;
                    segment = segment3;
                    if (rangeEquals(segment3, i + 1, byteString, 1, size)) {
                        return (i - segment.b) + j7;
                    }
                } else {
                    bArr = bArr2;
                    segment = segment3;
                }
                i++;
                segment3 = segment;
                bArr2 = bArr;
            }
            j6 = (r6.c - r6.b) + j7;
            segment3 = segment3.f;
            j3 = -1;
            j7 = j6;
        }
        return j3;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.a;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.b;
        if (j3 - j >= j) {
            while (true) {
                j3 = j2;
                j2 = (segment.c - segment.b) + j3;
                if (j2 >= j) {
                    break;
                }
                segment = segment.f;
            }
        } else {
            while (j3 > j) {
                segment = segment.g;
                j3 -= segment.c - segment.b;
            }
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.b) {
                byte[] bArr = segment.a;
                i = (int) ((segment.b + j) - j3);
                int i2 = segment.c;
                while (i < i2) {
                    byte b3 = bArr[i];
                    if (b3 != b && b3 != b2) {
                        i++;
                    }
                    return (i - segment.b) + j3;
                }
                j = (segment.c - segment.b) + j3;
                segment = segment.f;
                j3 = j;
            }
            return -1L;
        }
        byte[] a = byteString.a();
        while (j3 < this.b) {
            byte[] bArr2 = segment.a;
            i = (int) ((segment.b + j) - j3);
            int i3 = segment.c;
            while (i < i3) {
                byte b4 = bArr2[i];
                for (byte b5 : a) {
                    if (b4 == b5) {
                        return (i - segment.b) + j3;
                    }
                }
                i++;
            }
            j = (segment.c - segment.b) + j3;
            segment = segment.f;
            j3 = j;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.b > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }
        };
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.b - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        Segment segment = this.a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.c - segment.b);
        byteBuffer.put(segment.a, segment.b, min);
        segment.b += min;
        this.b -= min;
        if (segment.b == segment.c) {
            this.a = segment.pop();
            SegmentPool.a(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.c - segment.b);
        System.arraycopy(segment.a, segment.b, bArr, i, min);
        segment.b += min;
        this.b -= min;
        if (segment.b == segment.c) {
            this.a = segment.pop();
            SegmentPool.a(segment);
        }
        return min;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.b;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer.write(this, j);
        return j;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) {
        long j = this.b;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.a;
        int i = segment.b;
        int i2 = segment.c;
        int i3 = i + 1;
        byte b = segment.a[i];
        this.b = j - 1;
        if (i3 == i2) {
            this.a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.b = i3;
        }
        return b;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) {
        Util.checkOffsetAndCount(this.b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) {
        return new ByteString(readByteArray(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae A[EDGE_INSN: B:47:0x00ae->B:41:0x00ae BREAK  A[LOOP:0: B:4:0x0010->B:46:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lb9
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L10:
            okio.Segment r10 = r0.a
            byte[] r11 = r10.a
            int r12 = r10.b
            int r13 = r10.c
        L18:
            if (r12 >= r13) goto L9a
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6c
            r1 = 57
            if (r15 > r1) goto L6c
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L38
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L76
        L3f:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong(r3)
            okio.Buffer r1 = r1.writeByte(r15)
            if (r5 != 0) goto L51
            r1.readByte()
        L51:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6c:
            r1 = 45
            if (r15 != r1) goto L7b
            if (r7 != 0) goto L7b
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L76:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L18
        L7b:
            if (r7 == 0) goto L7f
            r6 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9a:
            if (r12 != r13) goto La6
            okio.Segment r1 = r10.pop()
            r0.a = r1
            okio.SegmentPool.a(r10)
            goto La8
        La6:
            r10.b = r12
        La8:
            if (r6 != 0) goto Lae
            okio.Segment r1 = r0.a
            if (r1 != 0) goto L10
        Lae:
            long r1 = r0.b
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.b = r1
            if (r5 == 0) goto Lb7
            goto Lb8
        Lb7:
            long r3 = -r3
        Lb8:
            return r3
        Lb9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto Lc2
        Lc1:
            throw r1
        Lc2:
            goto Lc1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) {
        long j2 = this.b;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5 A[EDGE_INSN: B:41:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.Segment r6 = r15.a
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r1 == 0) goto L76
            r0 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            okio.Segment r7 = r6.pop()
            r15.a = r7
            okio.SegmentPool.a(r6)
            goto L9f
        L9d:
            r6.b = r8
        L9f:
            if (r0 != 0) goto La5
            okio.Segment r6 = r15.a
            if (r6 != 0) goto Lb
        La5:
            long r2 = r15.b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.b = r2
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb5
        Lb4:
            throw r0
        Lb5:
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.b;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        Segment segment = this.a;
        int i = segment.b;
        int i2 = segment.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.b = j - 4;
        if (i8 == i2) {
            this.a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.b = i8;
        }
        return i9;
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        long j = this.b;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        Segment segment = this.a;
        int i = segment.b;
        int i2 = segment.c;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.a;
        long j2 = (bArr[i] & 255) << 56;
        long j3 = ((bArr[r11] & 255) << 48) | j2;
        long j4 = j3 | ((bArr[r6] & 255) << 40);
        long j5 = j4 | ((bArr[r11] & 255) << 32) | ((bArr[r6] & 255) << 24);
        long j6 = j5 | ((bArr[r9] & 255) << 16);
        long j7 = j6 | ((bArr[r6] & 255) << 8);
        int i3 = i + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j8 = j7 | (bArr[r9] & 255);
        this.b = j - 8;
        if (i3 == i2) {
            this.a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.b = i3;
        }
        return j8;
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.b;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        Segment segment = this.a;
        int i = segment.b;
        int i2 = segment.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b = j - 2;
        if (i4 == i2) {
            this.a = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.b = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) {
        Util.checkOffsetAndCount(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.a;
        int i = segment.b;
        if (i + j > segment.c) {
            return new String(readByteArray(j), charset);
        }
        String str = new String(segment.a, i, (int) j, charset);
        segment.b = (int) (segment.b + j);
        this.b -= j;
        if (segment.b == segment.c) {
            this.a = segment.pop();
            SegmentPool.a(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.b, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) {
        return readString(j, Util.UTF_8);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        int i;
        int i2;
        int i3;
        if (this.b == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
        if ((b & 128) == 0) {
            i = b & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((b & 224) == 192) {
            i = b & Ascii.US;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & Ascii.SI;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.b < j) {
            throw new EOFException("size < " + i2 + ": " + this.b + " (to read code point prefixed 0x" + Integer.toHexString(b) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return a(indexOf);
        }
        long j = this.b;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return a(indexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return a(j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.b >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        int a = a(options, false);
        if (a == -1) {
            return -1;
        }
        try {
            skip(options.a[a].size());
            return a;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public final ByteString sha1() {
        return digest(CommonUtils.SHA1_INSTANCE);
    }

    public final ByteString sha256() {
        return digest(CommonUtils.SHA256_INSTANCE);
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.b;
    }

    @Override // okio.BufferedSource
    public void skip(long j) {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.c - r0.b);
            long j2 = min;
            this.b -= j2;
            j -= j2;
            Segment segment = this.a;
            segment.b += min;
            if (segment.b == segment.c) {
                this.a = segment.pop();
                SegmentPool.a(segment);
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.b;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public final ByteString snapshot(int i) {
        return i == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment a = a(1);
            int min = Math.min(i, 8192 - a.c);
            byteBuffer.get(a.a, a.c, min);
            i -= min;
            a.c += min;
        }
        this.b += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment a = a(1);
            int min = Math.min(i3 - i, 8192 - a.c);
            System.arraycopy(bArr, i, a.a, a.c, min);
            i += min;
            a.c += min;
        }
        this.b += j;
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.b, 0L, j);
        while (j > 0) {
            Segment segment = buffer.a;
            if (j < segment.c - segment.b) {
                Segment segment2 = this.a;
                Segment segment3 = segment2 != null ? segment2.g : null;
                if (segment3 != null && segment3.e) {
                    if ((segment3.c + j) - (segment3.d ? 0 : segment3.b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        buffer.a.writeTo(segment3, (int) j);
                        buffer.b -= j;
                        this.b += j;
                        return;
                    }
                }
                buffer.a = buffer.a.split((int) j);
            }
            Segment segment4 = buffer.a;
            long j2 = segment4.c - segment4.b;
            buffer.a = segment4.pop();
            Segment segment5 = this.a;
            if (segment5 == null) {
                this.a = segment4;
                Segment segment6 = this.a;
                segment6.g = segment6;
                segment6.f = segment6;
            } else {
                segment5.g.push(segment4).compact();
            }
            buffer.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment a = a(1);
        byte[] bArr = a.a;
        int i2 = a.c;
        a.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment a = a(i);
        byte[] bArr = a.a;
        int i2 = a.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        a.c += i;
        this.b += i;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment a = a(numberOfTrailingZeros);
        byte[] bArr = a.a;
        int i = a.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        a.c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment a = a(4);
        byte[] bArr = a.a;
        int i2 = a.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        a.c = i5 + 1;
        this.b += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment a = a(8);
        byte[] bArr = a.a;
        int i = a.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        a.c = i8 + 1;
        this.b += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment a = a(2);
        byte[] bArr = a.a;
        int i2 = a.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        a.c = i3 + 1;
        this.b += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytesShort((short) i));
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(Util.UTF_8)) {
                return writeUtf8(str, i, i2);
            }
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream) {
        return writeTo(outputStream, this.b);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.b, 0L, j);
        Segment segment = this.a;
        while (j > 0) {
            int min = (int) Math.min(j, segment.c - segment.b);
            outputStream.write(segment.a, segment.b, min);
            segment.b += min;
            long j2 = min;
            this.b -= j2;
            j -= j2;
            if (segment.b == segment.c) {
                Segment pop = segment.pop();
                this.a = pop;
                SegmentPool.a(segment);
                segment = pop;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                Segment a = a(1);
                byte[] bArr = a.a;
                int i4 = a.c - i;
                int min = Math.min(i2, 8192 - i4);
                int i5 = i + 1;
                bArr[i + i4] = (byte) charAt;
                while (i5 < min) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) charAt2;
                    i5++;
                }
                int i6 = a.c;
                int i7 = (i4 + i5) - i6;
                a.c = i6 + i7;
                this.b += i7;
                i = i5;
            } else {
                if (charAt < 2048) {
                    i3 = (charAt >> 6) | 192;
                } else if (charAt < 55296 || charAt > 57343) {
                    writeByte((charAt >> '\f') | 224);
                    i3 = ((charAt >> 6) & 63) | 128;
                } else {
                    int i8 = i + 1;
                    char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        writeByte(63);
                        i = i8;
                    } else {
                        int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                        writeByte((i9 >> 18) | 240);
                        writeByte(((i9 >> 12) & 63) | 128);
                        writeByte(((i9 >> 6) & 63) | 128);
                        writeByte((i9 & 63) | 128);
                        i += 2;
                    }
                }
                writeByte(i3);
                writeByte((charAt & '?') | 128);
                i++;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i >= 55296 && i <= 57343) {
                        writeByte(63);
                        return this;
                    }
                    i2 = (i >> 12) | 224;
                } else {
                    if (i > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                    writeByte((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                }
                writeByte(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            writeByte(i3);
            i = (i & 63) | 128;
        }
        writeByte(i);
        return this;
    }
}
