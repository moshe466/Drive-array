package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class Y {
    public abstract Z a(Object obj);

    public final boolean b(int i, C0243j c0243j, Object obj) {
        int i3 = c0243j.f3193b;
        int i4 = i3 >>> 3;
        int i5 = i3 & 7;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            return false;
                        }
                        if (i5 == 5) {
                            c0243j.w(5);
                            ((Z) obj).c(5 | (i4 << 3), Integer.valueOf(c0243j.f3192a.r()));
                            return true;
                        }
                        throw InvalidProtocolBufferException.b();
                    }
                    Z z3 = new Z(0, new int[8], new Object[8], true);
                    int i6 = i4 << 3;
                    int i7 = i6 | 4;
                    int i8 = i + 1;
                    if (i8 >= 100) {
                        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
                    }
                    while (c0243j.a() != Integer.MAX_VALUE && b(i8, c0243j, z3)) {
                    }
                    if (i7 == c0243j.f3193b) {
                        if (z3.f3153e) {
                            z3.f3153e = false;
                        }
                        ((Z) obj).c(i6 | 3, z3);
                        return true;
                    }
                    throw new IOException("Protocol message end-group tag did not match expected tag.");
                }
                ((Z) obj).c((i4 << 3) | 2, c0243j.e());
                return true;
            }
            c0243j.w(1);
            ((Z) obj).c((i4 << 3) | 1, Long.valueOf(c0243j.f3192a.s()));
            return true;
        }
        c0243j.w(0);
        ((Z) obj).c(i4 << 3, Long.valueOf(c0243j.f3192a.v()));
        return true;
    }
}
