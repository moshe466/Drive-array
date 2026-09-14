package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class G extends H {
    @Override // com.google.crypto.tink.shaded.protobuf.H
    public final void a(long j2, Object obj) {
        ((AbstractC0330b) ((A) n0.f4138c.i(j2, obj))).f4085a = false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.H
    public final void b(Object obj, long j2, Object obj2) {
        m0 m0Var = n0.f4138c;
        A a2 = (A) m0Var.i(j2, obj);
        A a4 = (A) m0Var.i(j2, obj2);
        int size = a2.size();
        int size2 = a4.size();
        if (size > 0 && size2 > 0) {
            if (!((AbstractC0330b) a2).f4085a) {
                a2 = a2.a(size2 + size);
            }
            a2.addAll(a4);
        }
        if (size > 0) {
            a4 = a2;
        }
        n0.p(obj, j2, a4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.H
    public final List c(long j2, Object obj) {
        int i;
        A a2 = (A) n0.f4138c.i(j2, obj);
        if (!((AbstractC0330b) a2).f4085a) {
            int size = a2.size();
            if (size == 0) {
                i = 10;
            } else {
                i = size * 2;
            }
            A a4 = a2.a(i);
            n0.p(obj, j2, a4);
            return a4;
        }
        return a2;
    }
}
