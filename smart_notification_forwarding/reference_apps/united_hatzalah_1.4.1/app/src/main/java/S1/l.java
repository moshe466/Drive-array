package S1;

import W1.C0204b;
import W1.s0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class l {
    static {
        L1.g[] gVarArr = {new L1.g(K1.j.class, 11)};
        HashMap hashMap = new HashMap();
        L1.g gVar = gVarArr[0];
        Class cls = gVar.f1289a;
        if (!hashMap.containsKey(cls)) {
            hashMap.put(cls, gVar);
            Class cls2 = gVarArr[0].f1289a;
            Collections.unmodifiableMap(hashMap);
            int i = s0.CONFIG_NAME_FIELD_NUMBER;
            try {
                a();
                return;
            } catch (GeneralSecurityException e4) {
                throw new ExceptionInInitializerError(e4);
            }
        }
        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
    }

    public static void a() {
        K1.o.h(o.f2154c);
        K1.o.h(h.f2138a);
        K1.o.f(new b(), true);
        R1.j jVar = k.f2145a;
        R1.h hVar = R1.h.f1992b;
        hVar.e(k.f2145a);
        hVar.d(k.f2146b);
        hVar.c(k.f2147c);
        hVar.b(k.f2148d);
        R1.g gVar = R1.g.f1990b;
        gVar.b(b.f2115f);
        if (O1.a.a()) {
            return;
        }
        K1.o.f(new b(C0204b.class, new L1.g[]{new L1.g(K1.j.class, 10)}), true);
        hVar.e(e.f2134a);
        hVar.d(e.f2135b);
        hVar.c(e.f2136c);
        hVar.b(e.f2137d);
        gVar.b(b.f2114e);
    }
}
