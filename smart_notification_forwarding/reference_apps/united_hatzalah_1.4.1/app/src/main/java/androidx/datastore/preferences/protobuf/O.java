package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class O {

    /* renamed from: c, reason: collision with root package name */
    public static final O f3120c = new O();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3122b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final B f3121a = new B();

    public final S a(Class cls) {
        S v2;
        Class cls2;
        AbstractC0255w.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f3122b;
        S s3 = (S) concurrentHashMap.get(cls);
        if (s3 == null) {
            B b4 = this.f3121a;
            b4.getClass();
            Class cls3 = T.f3130a;
            if (!AbstractC0253u.class.isAssignableFrom(cls) && (cls2 = T.f3130a) != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
            Q a2 = ((A) b4.f3089a).a(cls);
            int i = a2.f3129d;
            AbstractC0234a abstractC0234a = a2.f3126a;
            if ((i & 2) == 2) {
                if (AbstractC0253u.class.isAssignableFrom(cls)) {
                    v2 = new K(T.f3132c, AbstractC0248o.f3211a, abstractC0234a);
                } else {
                    Y y = T.f3131b;
                    C0247n c0247n = AbstractC0248o.f3212b;
                    if (c0247n != null) {
                        v2 = new K(y, c0247n, abstractC0234a);
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
            } else if (AbstractC0253u.class.isAssignableFrom(cls)) {
                C0247n c0247n2 = null;
                L l3 = M.f3119b;
                C0257y c0257y = AbstractC0258z.f3251b;
                a0 a0Var = T.f3132c;
                if (T.k.b(a2.a()) != 1) {
                    c0247n2 = AbstractC0248o.f3211a;
                }
                C0247n c0247n3 = c0247n2;
                F f4 = G.f3098b;
                int[] iArr = J.f3101n;
                if (a2 instanceof Q) {
                    v2 = J.v(a2, l3, c0257y, a0Var, c0247n3, f4);
                } else {
                    a2.getClass();
                    throw new ClassCastException();
                }
            } else {
                C0247n c0247n4 = null;
                L l4 = M.f3118a;
                C0257y c0257y2 = AbstractC0258z.f3250a;
                Y y3 = T.f3131b;
                if (T.k.b(a2.a()) == 1 || (c0247n4 = AbstractC0248o.f3212b) != null) {
                    C0247n c0247n5 = c0247n4;
                    F f5 = G.f3097a;
                    int[] iArr2 = J.f3101n;
                    if (a2 instanceof Q) {
                        v2 = J.v(a2, l4, c0257y2, y3, c0247n5, f5);
                    } else {
                        a2.getClass();
                        throw new ClassCastException();
                    }
                } else {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
            }
            S s4 = (S) concurrentHashMap.putIfAbsent(cls, v2);
            if (s4 != null) {
                return s4;
            }
            return v2;
        }
        return s3;
    }
}
