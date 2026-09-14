package W0;

import F0.AbstractC0008a;
import F0.C0047j2;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c implements Y0.b {

    /* renamed from: a, reason: collision with root package name */
    public final Y0.b[] f2448a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2449b;

    public c(Y0.b... bVarArr) {
        this.f2448a = bVarArr;
        this.f2449b = Arrays.stream(bVarArr).mapToLong(new Object()).sum();
    }

    @Override // Y0.b
    public final void a(long j2, long j3, Y0.a aVar) {
        Y0.a aVar2;
        if (j2 + j3 <= this.f2449b) {
            Y0.b[] bVarArr = this.f2448a;
            int length = bVarArr.length;
            int i = 0;
            long j4 = j2;
            long j5 = j3;
            while (i < length) {
                Y0.b bVar = bVarArr[i];
                if (j4 >= bVar.size()) {
                    j4 -= bVar.size();
                    aVar2 = aVar;
                } else {
                    long size = bVar.size() - j4;
                    if (size >= j5) {
                        bVar.a(j4, j5, aVar);
                        return;
                    }
                    aVar2 = aVar;
                    bVar.a(j4, size, aVar2);
                    j5 -= size;
                    j4 = 0;
                }
                i++;
                aVar = aVar2;
            }
            return;
        }
        throw new IndexOutOfBoundsException("Requested more than available");
    }

    @Override // Y0.b
    public final void b(long j2, ByteBuffer byteBuffer, int i) {
        a(j2, i, new C0047j2(byteBuffer, 8));
    }

    @Override // Y0.b
    public final ByteBuffer c(int i, long j2) {
        long j3 = i;
        if (j2 + j3 <= this.f2449b) {
            int i3 = 0;
            long j4 = j2;
            while (true) {
                Y0.b[] bVarArr = this.f2448a;
                if (i3 < bVarArr.length) {
                    if (j4 < bVarArr[i3].size()) {
                        g gVar = new g(Integer.valueOf(i3), Long.valueOf(j4));
                        int intValue = ((Integer) gVar.f2458a).intValue();
                        long longValue = ((Long) gVar.f2459b).longValue();
                        long j5 = j3 + longValue;
                        Y0.b[] bVarArr2 = this.f2448a;
                        if (j5 <= bVarArr2[intValue].size()) {
                            return bVarArr2[intValue].c(i, longValue);
                        }
                        ByteBuffer allocate = ByteBuffer.allocate(i);
                        while (intValue < bVarArr2.length && allocate.hasRemaining()) {
                            bVarArr2[intValue].b(longValue, allocate, Math.toIntExact(Math.min(bVarArr2[intValue].size() - longValue, allocate.remaining())));
                            intValue++;
                            longValue = 0;
                        }
                        allocate.rewind();
                        return allocate;
                    }
                    j4 -= bVarArr[i3].size();
                    i3++;
                } else {
                    StringBuilder x3 = AbstractC0008a.x("Access is out of bound, offset: ", ", totalSize: ", j2);
                    x3.append(this.f2449b);
                    throw new IndexOutOfBoundsException(x3.toString());
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Requested more than available");
        }
    }

    @Override // Y0.b
    public final long size() {
        return this.f2449b;
    }
}
