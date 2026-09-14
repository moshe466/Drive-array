package N0;

import F0.AbstractC0008a;
import F0.C0092v0;
import com.google.android.gms.common.ConnectionResult;
import io.flutter.embedding.android.KeyboardMap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f1435a;

    /* renamed from: b, reason: collision with root package name */
    public c f1436b;

    /* renamed from: c, reason: collision with root package name */
    public C0092v0 f1437c;

    /* renamed from: d, reason: collision with root package name */
    public int f1438d;

    /* renamed from: e, reason: collision with root package name */
    public int f1439e = 1;

    /* renamed from: f, reason: collision with root package name */
    public String f1440f;

    /* renamed from: g, reason: collision with root package name */
    public String f1441g;

    /* renamed from: h, reason: collision with root package name */
    public int f1442h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public ByteBuffer f1443j;

    /* renamed from: k, reason: collision with root package name */
    public int f1444k;

    public d(ByteBuffer byteBuffer) {
        b bVar;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer.hasRemaining() && (bVar = b.b(byteBuffer)) != null) {
            if (bVar.f1427a == 3) {
                break;
            }
        }
        bVar = null;
        if (bVar != null) {
            this.f1435a = bVar.c();
            return;
        }
        throw new Exception("No XML chunk in file");
    }

    public static ByteBuffer f(int i, ByteBuffer byteBuffer, int i3) {
        if (i >= 0) {
            if (i3 >= i) {
                int capacity = byteBuffer.capacity();
                if (i3 <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(i3);
                        byteBuffer.position(i);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        return slice;
                    } finally {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                    }
                }
                throw new IllegalArgumentException(AbstractC0008a.k("end > capacity: ", i3, capacity, " > "));
            }
            throw new IllegalArgumentException(AbstractC0008a.k("end < start: ", i3, i, " < "));
        }
        throw new IllegalArgumentException(e0.a.c(i, "start: "));
    }

    public static ByteBuffer g(ByteBuffer byteBuffer, long j2, long j3) {
        if (j2 >= 0) {
            if (j3 >= j2) {
                int capacity = byteBuffer.capacity();
                if (j3 <= byteBuffer.capacity()) {
                    return f((int) j2, byteBuffer, (int) j3);
                }
                throw new IllegalArgumentException("end > capacity: " + j3 + " > " + capacity);
            }
            StringBuilder x3 = AbstractC0008a.x("end < start: ", " < ", j3);
            x3.append(j2);
            throw new IllegalArgumentException(x3.toString());
        }
        throw new IllegalArgumentException(AbstractC0008a.l("start: ", j2));
    }

    public final a a(int i) {
        if (this.f1439e == 3) {
            if (i >= 0) {
                if (i < this.f1442h) {
                    if (this.i == null) {
                        this.i = new ArrayList(this.f1442h);
                        for (int i3 = 0; i3 < this.f1442h; i3++) {
                            int i4 = this.f1444k;
                            int i5 = i3 * i4;
                            ByteBuffer f4 = f(i5, this.f1443j, i4 + i5);
                            f4.getInt();
                            long j2 = f4.getInt() & KeyboardMap.kValueMask;
                            f4.position(f4.position() + 7);
                            this.i.add(new a(j2, f4.get() & ForkServer.ERROR, (int) (f4.getInt() & KeyboardMap.kValueMask), this.f1436b, this.f1437c));
                        }
                    }
                    return (a) this.i.get(i);
                }
                throw new IndexOutOfBoundsException(AbstractC0008a.r(new StringBuilder("index must be <= attr count ("), this.f1442h, ")"));
            }
            throw new IndexOutOfBoundsException("index must be >= 0");
        }
        throw new IndexOutOfBoundsException("Current event not a START_ELEMENT");
    }

    public final int b(int i) {
        a a2 = a(i);
        int i3 = a2.f1423b;
        if (i3 != 1) {
            switch (i3) {
                case 16:
                case 17:
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    break;
                default:
                    throw new Exception(e0.a.c(i3, "Cannot coerce to int: value type "));
            }
        }
        return a2.f1424c;
    }

    public final int c(int i) {
        a a2 = a(i);
        C0092v0 c0092v0 = a2.f1426e;
        if (c0092v0 != null) {
            long j2 = a2.f1422a;
            if (j2 >= 0 && j2 < c0092v0.f692a) {
                return ((ByteBuffer) c0092v0.f693b).getInt(((int) j2) * 4);
            }
            return 0;
        }
        return 0;
    }

    public final String d(int i) {
        a a2 = a(i);
        int i3 = a2.f1424c;
        int i4 = a2.f1423b;
        boolean z3 = true;
        if (i4 != 1) {
            if (i4 != 3) {
                switch (i4) {
                    case 16:
                        return Integer.toString(i3);
                    case 17:
                        return "0x" + Integer.toHexString(i3);
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        if (i3 == 0) {
                            z3 = false;
                        }
                        return Boolean.toString(z3);
                    default:
                        throw new Exception(e0.a.c(i4, "Cannot coerce to string: value type "));
                }
            }
            return a2.f1425d.c(i3 & KeyboardMap.kValueMask);
        }
        return "@" + Integer.toHexString(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0191, code lost:
    
        r20.f1439e = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0194, code lost:
    
        return 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e() {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N0.d.e():int");
    }
}
