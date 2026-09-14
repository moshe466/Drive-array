package P1;

import K1.o;
import L1.i;
import R1.h;
import R1.j;
import W1.F;
import W1.s0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class e {
    static {
        L1.g[] gVarArr = {new L1.g(K1.c.class, 9)};
        HashMap hashMap = new HashMap();
        for (L1.g gVar : gVarArr) {
            Class cls = gVar.f1289a;
            Class cls2 = gVar.f1289a;
            if (!hashMap.containsKey(cls)) {
                hashMap.put(cls2, gVar);
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls2.getCanonicalName());
            }
        }
        if (gVarArr.length > 0) {
            Class cls3 = gVarArr[0].f1289a;
        }
        Collections.unmodifiableMap(hashMap);
        int i = s0.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e4) {
            throw new ExceptionInInitializerError(e4);
        }
    }

    public static void a() {
        o.h(g.f1592b);
        if (O1.a.a()) {
            return;
        }
        o.f(new i(F.class, new L1.g[]{new L1.g(K1.c.class, 9)}, 8), true);
        j jVar = d.f1583a;
        h hVar = h.f1992b;
        hVar.e(d.f1583a);
        hVar.d(d.f1584b);
        hVar.c(d.f1585c);
        hVar.b(d.f1586d);
    }
}
