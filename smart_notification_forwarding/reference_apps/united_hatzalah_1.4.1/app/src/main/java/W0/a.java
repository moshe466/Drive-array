package W0;

import F0.AbstractC0008a;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a implements Y0.b {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f2446a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2447b;

    public a(ByteBuffer byteBuffer, boolean z3) {
        ByteBuffer byteBuffer2;
        if (z3) {
            byteBuffer2 = byteBuffer.slice();
        } else {
            byteBuffer2 = byteBuffer;
        }
        this.f2446a = byteBuffer2;
        this.f2447b = byteBuffer.remaining();
    }

    @Override // Y0.b
    public final void a(long j2, long j3, Y0.a aVar) {
        int i = this.f2447b;
        if (j3 >= 0 && j3 <= i) {
            aVar.e(c((int) j3, j2));
            return;
        }
        throw new IndexOutOfBoundsException("size: " + j3 + ", source size: " + i);
    }

    @Override // Y0.b
    public final void b(long j2, ByteBuffer byteBuffer, int i) {
        byteBuffer.put(c(i, j2));
    }

    @Override // Y0.b
    public final ByteBuffer c(int i, long j2) {
        ByteBuffer slice;
        long j3 = i;
        int i3 = this.f2447b;
        if (j2 >= 0) {
            if (j3 >= 0) {
                long j4 = i3;
                if (j2 <= j4) {
                    long j5 = j2 + j3;
                    if (j5 >= j2) {
                        if (j5 <= j4) {
                            int i4 = (int) j2;
                            int i5 = i + i4;
                            synchronized (this.f2446a) {
                                this.f2446a.position(0);
                                this.f2446a.limit(i5);
                                this.f2446a.position(i4);
                                slice = this.f2446a.slice();
                            }
                            return slice;
                        }
                        StringBuilder x3 = AbstractC0008a.x("offset (", ") + size (", j2);
                        x3.append(j3);
                        x3.append(") > source size (");
                        x3.append(i3);
                        x3.append(")");
                        throw new IndexOutOfBoundsException(x3.toString());
                    }
                    throw new IndexOutOfBoundsException(e0.a.g(AbstractC0008a.x("offset (", ") + size (", j2), j3, ") overflow"));
                }
                throw new IndexOutOfBoundsException("offset (" + j2 + ") > source size (" + i3 + ")");
            }
            throw new IndexOutOfBoundsException(AbstractC0008a.l("size: ", j3));
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.l("offset: ", j2));
    }

    @Override // Y0.b
    public final long size() {
        return this.f2447b;
    }
}
