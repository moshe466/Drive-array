package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0329a implements P {
    protected int memoizedHashCode;

    public abstract int b(b0 b0Var);

    public final String c(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract AbstractC0349v d();

    public final byte[] e() {
        try {
            int b4 = ((AbstractC0351x) this).b(null);
            byte[] bArr = new byte[b4];
            C0341m c0341m = new C0341m(bArr, b4);
            f(c0341m);
            if (b4 - c0341m.f4134m == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e4) {
            throw new RuntimeException(c("byte array"), e4);
        }
    }

    public abstract void f(C0341m c0341m);
}
