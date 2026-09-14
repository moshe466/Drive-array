package W0;

import F0.AbstractC0008a;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class d implements Y0.b {

    /* renamed from: a, reason: collision with root package name */
    public final FileChannel f2450a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2451b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2452c;

    public d(FileChannel fileChannel) {
        this.f2450a = fileChannel;
        this.f2451b = 0L;
        this.f2452c = -1L;
    }

    public static void d(long j2, long j3, long j4) {
        if (j2 >= 0) {
            if (j3 >= 0) {
                if (j2 <= j4) {
                    long j5 = j2 + j3;
                    if (j5 >= j2) {
                        if (j5 <= j4) {
                            return;
                        }
                        StringBuilder x3 = AbstractC0008a.x("offset (", ") + size (", j2);
                        x3.append(j3);
                        x3.append(") > source size (");
                        x3.append(j4);
                        x3.append(")");
                        throw new IndexOutOfBoundsException(x3.toString());
                    }
                    throw new IndexOutOfBoundsException(e0.a.g(AbstractC0008a.x("offset (", ") + size (", j2), j3, ") overflow"));
                }
                throw new IndexOutOfBoundsException(e0.a.g(AbstractC0008a.x("offset (", ") > source size (", j2), j4, ")"));
            }
            throw new IndexOutOfBoundsException(AbstractC0008a.l("size: ", j3));
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.l("offset: ", j2));
    }

    @Override // Y0.b
    public final void a(long j2, long j3, Y0.a aVar) {
        d(j2, j3, size());
        if (j3 != 0) {
            long j4 = this.f2451b + j2;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect((int) Math.min(j3, 1048576L));
            long j5 = j4;
            long j6 = j3;
            while (j6 > 0) {
                int min = (int) Math.min(j6, allocateDirect.capacity());
                allocateDirect.limit(min);
                synchronized (this.f2450a) {
                    try {
                        this.f2450a.position(j5);
                        int i = min;
                        while (i > 0) {
                            int read = this.f2450a.read(allocateDirect);
                            if (read >= 0) {
                                i -= read;
                            } else {
                                throw new IOException("Unexpected EOF encountered");
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                allocateDirect.flip();
                aVar.e(allocateDirect);
                allocateDirect.clear();
                long j7 = min;
                j5 += j7;
                j6 -= j7;
            }
        }
    }

    @Override // Y0.b
    public final void b(long j2, ByteBuffer byteBuffer, int i) {
        int read;
        d(j2, i, size());
        if (i == 0) {
            return;
        }
        if (i <= byteBuffer.remaining()) {
            long j3 = this.f2451b + j2;
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                while (i > 0) {
                    synchronized (this.f2450a) {
                        this.f2450a.position(j3);
                        read = this.f2450a.read(byteBuffer);
                    }
                    j3 += read;
                    i -= read;
                }
                return;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        throw new BufferOverflowException();
    }

    @Override // Y0.b
    public final ByteBuffer c(int i, long j2) {
        if (i >= 0) {
            ByteBuffer allocate = ByteBuffer.allocate(i);
            b(j2, allocate, i);
            allocate.flip();
            return allocate;
        }
        throw new IndexOutOfBoundsException(e0.a.c(i, "size: "));
    }

    public final Y0.b e(long j2, long j3) {
        long size = size();
        d(j2, j3, size);
        if (j2 == 0 && j3 == size) {
            return this;
        }
        return new d(this.f2450a, this.f2451b + j2, j3);
    }

    @Override // Y0.b
    public final long size() {
        long j2 = this.f2452c;
        if (j2 == -1) {
            try {
                return this.f2450a.size();
            } catch (IOException unused) {
                return 0L;
            }
        }
        return j2;
    }

    public d(FileChannel fileChannel, long j2, long j3) {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0008a.l("offset: ", j3));
        }
        if (j3 >= 0) {
            this.f2450a = fileChannel;
            this.f2451b = j2;
            this.f2452c = j3;
            return;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.l("size: ", j3));
    }
}
