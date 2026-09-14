package e3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class g extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public volatile ByteArrayInputStream f4462a;

    /* renamed from: b, reason: collision with root package name */
    public volatile byte[] f4463b;

    /* renamed from: c, reason: collision with root package name */
    public int f4464c;

    /* renamed from: d, reason: collision with root package name */
    public int f4465d;

    /* renamed from: e, reason: collision with root package name */
    public int f4466e;

    /* renamed from: f, reason: collision with root package name */
    public int f4467f;

    public final int a(ByteArrayInputStream byteArrayInputStream, byte[] bArr) {
        int i = this.f4466e;
        if (i != -1) {
            int i3 = this.f4467f - i;
            int i4 = this.f4465d;
            if (i3 < i4) {
                if (i == 0 && i4 > bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f4463b = bArr2;
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i5 = this.f4467f - this.f4466e;
                this.f4467f = i5;
                this.f4466e = 0;
                this.f4464c = 0;
                int read = byteArrayInputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.f4467f;
                if (read > 0) {
                    i6 += read;
                }
                this.f4464c = i6;
                return read;
            }
        }
        int read2 = byteArrayInputStream.read(bArr);
        if (read2 > 0) {
            this.f4466e = -1;
            this.f4467f = 0;
            this.f4464c = read2;
        }
        return read2;
    }

    @Override // java.io.InputStream
    public final int available() {
        ByteArrayInputStream byteArrayInputStream = this.f4462a;
        if (this.f4463b != null && byteArrayInputStream != null) {
            return byteArrayInputStream.available() + (this.f4464c - this.f4467f);
        }
        throw new IOException("Stream is closed");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4463b = null;
        ByteArrayInputStream byteArrayInputStream = this.f4462a;
        this.f4462a = null;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f4465d = i;
        this.f4466e = this.f4467f;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final void reset() {
        if (this.f4463b != null) {
            int i = this.f4466e;
            if (-1 != i) {
                this.f4467f = i;
                return;
            }
            throw new IOException("Mark has been invalidated");
        }
        throw new IOException("Stream is closed");
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        byte[] bArr = this.f4463b;
        ByteArrayInputStream byteArrayInputStream = this.f4462a;
        if (bArr != null) {
            if (j2 < 1) {
                return 0L;
            }
            if (byteArrayInputStream != null) {
                int i = this.f4464c;
                int i3 = this.f4467f;
                int i4 = i - i3;
                long j3 = i4;
                if (j3 >= j2) {
                    this.f4467f = i3 + ((int) j2);
                    return j2;
                }
                this.f4467f = i;
                if (this.f4466e != -1 && j2 <= this.f4465d) {
                    if (a(byteArrayInputStream, bArr) == -1) {
                        return j3;
                    }
                    int i5 = this.f4464c;
                    int i6 = this.f4467f;
                    if (i5 - i6 >= j2 - j3) {
                        this.f4467f = (((int) j2) - i4) + i6;
                        return j2;
                    }
                    this.f4467f = i5;
                    return r2 + i4;
                }
                return byteArrayInputStream.skip(j2 - j3) + j3;
            }
            throw new IOException("Stream is closed");
        }
        throw new IOException("Stream is closed");
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f4463b;
        ByteArrayInputStream byteArrayInputStream = this.f4462a;
        if (bArr != null && byteArrayInputStream != null) {
            if (this.f4467f < this.f4464c || a(byteArrayInputStream, bArr) != -1) {
                if (bArr != this.f4463b && (bArr = this.f4463b) == null) {
                    throw new IOException("Stream is closed");
                }
                int i = this.f4464c;
                int i3 = this.f4467f;
                if (i - i3 > 0) {
                    this.f4467f = i3 + 1;
                    return bArr[i3] & ForkServer.ERROR;
                }
            }
            return -1;
        }
        throw new IOException("Stream is closed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0052, code lost:
    
        return -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077 A[SYNTHETIC] */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            byte[] r0 = r6.f4463b
            java.lang.String r1 = "Stream is closed"
            if (r0 == 0) goto L8e
            int r2 = r7.length
            int r2 = r2 - r9
            if (r8 > r2) goto L88
            if (r8 < 0) goto L88
            if (r9 < 0) goto L88
            if (r9 != 0) goto L12
            r7 = 0
            return r7
        L12:
            java.io.ByteArrayInputStream r2 = r6.f4462a
            if (r2 == 0) goto L82
            int r3 = r6.f4467f
            int r4 = r6.f4464c
            if (r3 >= r4) goto L36
            int r4 = r4 - r3
            if (r4 < r9) goto L20
            r4 = r9
        L20:
            java.lang.System.arraycopy(r0, r3, r7, r8, r4)
            int r3 = r6.f4467f
            int r3 = r3 + r4
            r6.f4467f = r3
            if (r4 == r9) goto L35
            int r3 = r2.available()
            if (r3 != 0) goto L31
            goto L35
        L31:
            int r8 = r8 + r4
            int r3 = r9 - r4
            goto L37
        L35:
            return r4
        L36:
            r3 = r9
        L37:
            int r4 = r6.f4466e
            r5 = -1
            if (r4 != r5) goto L4a
            int r4 = r0.length
            if (r3 < r4) goto L4a
            int r4 = r2.read(r7, r8, r3)
            if (r4 != r5) goto L74
            if (r3 != r9) goto L48
            goto L52
        L48:
            int r9 = r9 - r3
            return r9
        L4a:
            int r4 = r6.a(r2, r0)
            if (r4 != r5) goto L55
            if (r3 != r9) goto L53
        L52:
            return r5
        L53:
            int r9 = r9 - r3
            return r9
        L55:
            byte[] r4 = r6.f4463b
            if (r0 == r4) goto L64
            byte[] r0 = r6.f4463b
            if (r0 == 0) goto L5e
            goto L64
        L5e:
            java.io.IOException r7 = new java.io.IOException
            r7.<init>(r1)
            throw r7
        L64:
            int r4 = r6.f4464c
            int r5 = r6.f4467f
            int r4 = r4 - r5
            if (r4 < r3) goto L6c
            r4 = r3
        L6c:
            java.lang.System.arraycopy(r0, r5, r7, r8, r4)
            int r5 = r6.f4467f
            int r5 = r5 + r4
            r6.f4467f = r5
        L74:
            int r3 = r3 - r4
            if (r3 != 0) goto L78
            return r9
        L78:
            int r5 = r2.available()
            if (r5 != 0) goto L80
            int r9 = r9 - r3
            return r9
        L80:
            int r8 = r8 + r4
            goto L37
        L82:
            java.io.IOException r7 = new java.io.IOException
            r7.<init>(r1)
            throw r7
        L88:
            java.lang.IndexOutOfBoundsException r7 = new java.lang.IndexOutOfBoundsException
            r7.<init>()
            throw r7
        L8e:
            java.io.IOException r7 = new java.io.IOException
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.g.read(byte[], int, int):int");
    }
}
