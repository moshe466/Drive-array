package N0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class i implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final Y0.b[] f1462a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f1463b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1464c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f1465d;

    public i(Y0.b[] bVarArr) {
        this.f1462a = bVarArr;
        this.f1463b = new int[bVarArr.length];
        int i = 0;
        for (int i3 = 0; i3 < bVarArr.length; i3++) {
            long size = (bVarArr[i3].size() + 1048575) / 1048576;
            if (size <= 2147483647L) {
                this.f1463b[i3] = (int) size;
                i = (int) (i + size);
            } else {
                throw new RuntimeException(String.format("Number of chunks in dataSource[%d] is greater than max int.", Integer.valueOf(i3)));
            }
        }
        this.f1464c = i;
        this.f1465d = new AtomicInteger(0);
    }

    @Override // java.util.function.Supplier
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final h get() {
        Y0.b[] bVarArr;
        int andIncrement = this.f1465d.getAndIncrement();
        if (andIncrement >= 0 && andIncrement < this.f1464c) {
            long j2 = andIncrement;
            int i = 0;
            while (true) {
                bVarArr = this.f1462a;
                if (i >= bVarArr.length) {
                    break;
                }
                long j3 = this.f1463b[i];
                if (j2 < j3) {
                    break;
                }
                j2 -= j3;
                i++;
            }
            long j4 = j2 * 1048576;
            int min = (int) Math.min(bVarArr[i].size() - j4, 1048576L);
            ByteBuffer allocate = ByteBuffer.allocate(min);
            try {
                bVarArr[i].b(j4, allocate, min);
                allocate.rewind();
                return new h(andIncrement, allocate, min);
            } catch (IOException e4) {
                throw new IllegalStateException("Failed to read chunk", e4);
            }
        }
        return null;
    }
}
