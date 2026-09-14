package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class Y {

    /* renamed from: c, reason: collision with root package name */
    public static final Y f4075c = new Y();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f4077b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final K f4076a = new K();

    public final b0 a(Class cls) {
        b0 A3;
        Class cls2;
        B.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f4077b;
        b0 b0Var = (b0) concurrentHashMap.get(cls);
        if (b0Var == null) {
            K k4 = this.f4076a;
            k4.getClass();
            Class cls3 = c0.f4088a;
            if (!AbstractC0351x.class.isAssignableFrom(cls) && (cls2 = c0.f4088a) != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
            }
            a0 a2 = ((J) k4.f4050a).a(cls);
            int i = a2.f4084d;
            AbstractC0329a abstractC0329a = a2.f4081a;
            if ((i & 2) == 2) {
                if (AbstractC0351x.class.isAssignableFrom(cls)) {
                    A3 = new T(c0.f4091d, r.f4148a, abstractC0329a);
                } else {
                    d0 d0Var = c0.f4089b;
                    C0345q c0345q = r.f4149b;
                    if (c0345q != null) {
                        A3 = new T(d0Var, c0345q, abstractC0329a);
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
            } else if (AbstractC0351x.class.isAssignableFrom(cls)) {
                if ((a2.f4084d & 1) == 1) {
                    A3 = S.A(a2, V.f4074b, H.f4046b, c0.f4091d, r.f4148a, N.f4054b);
                } else {
                    A3 = S.A(a2, V.f4074b, H.f4046b, c0.f4091d, null, N.f4054b);
                }
            } else if ((a2.f4084d & 1) == 1) {
                U u3 = V.f4073a;
                F f4 = H.f4045a;
                d0 d0Var2 = c0.f4089b;
                C0345q c0345q2 = r.f4149b;
                if (c0345q2 != null) {
                    A3 = S.A(a2, u3, f4, d0Var2, c0345q2, N.f4053a);
                } else {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
            } else {
                A3 = S.A(a2, V.f4073a, H.f4045a, c0.f4090c, null, N.f4053a);
            }
            b0 b0Var2 = (b0) concurrentHashMap.putIfAbsent(cls, A3);
            if (b0Var2 != null) {
                return b0Var2;
            }
            return A3;
        }
        return b0Var;
    }
}
