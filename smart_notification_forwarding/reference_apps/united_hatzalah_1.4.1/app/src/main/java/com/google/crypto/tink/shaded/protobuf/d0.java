package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class d0 {
    public abstract e0 a(Object obj);

    public final boolean b(Object obj, C0340l c0340l) {
        int i = c0340l.f4126b;
        int i3 = i >>> 3;
        int i4 = i & 7;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            return false;
                        }
                        if (i4 == 5) {
                            c0340l.v(5);
                            ((e0) obj).d((i3 << 3) | 5, Integer.valueOf(c0340l.f4125a.r()));
                            return true;
                        }
                        throw InvalidProtocolBufferException.c();
                    }
                    e0 c4 = e0.c();
                    int i5 = i3 << 3;
                    int i6 = i5 | 4;
                    while (c0340l.a() != Integer.MAX_VALUE && b(c4, c0340l)) {
                    }
                    if (i6 == c0340l.f4126b) {
                        c4.f4100e = false;
                        ((e0) obj).d(i5 | 3, c4);
                        return true;
                    }
                    throw new IOException("Protocol message end-group tag did not match expected tag.");
                }
                ((e0) obj).d((i3 << 3) | 2, c0340l.e());
                return true;
            }
            c0340l.v(1);
            ((e0) obj).d((i3 << 3) | 1, Long.valueOf(c0340l.f4125a.s()));
            return true;
        }
        c0340l.v(0);
        ((e0) obj).d(i3 << 3, Long.valueOf(c0340l.f4125a.v()));
        return true;
    }
}
