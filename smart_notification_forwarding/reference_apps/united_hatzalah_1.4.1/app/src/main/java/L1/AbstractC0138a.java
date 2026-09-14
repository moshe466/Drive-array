package L1;

import W1.C0210h;
import W1.C0225x;
import W1.J;
import W1.m0;
import W1.p0;
import W1.s0;
import W1.u0;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: L1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0138a {
    static {
        g[] gVarArr = {new g(K1.a.class, 0)};
        HashMap hashMap = new HashMap();
        g gVar = gVarArr[0];
        Class cls = gVar.f1289a;
        if (!hashMap.containsKey(cls)) {
            hashMap.put(cls, gVar);
            Class cls2 = gVarArr[0].f1289a;
            Collections.unmodifiableMap(hashMap);
            g[] gVarArr2 = {new g(K1.a.class, 3)};
            HashMap hashMap2 = new HashMap();
            g gVar2 = gVarArr2[0];
            Class cls3 = gVar2.f1289a;
            if (!hashMap2.containsKey(cls3)) {
                hashMap2.put(cls3, gVar2);
                Class cls4 = gVarArr2[0].f1289a;
                Collections.unmodifiableMap(hashMap2);
                g[] gVarArr3 = {new g(K1.a.class, 4)};
                HashMap hashMap3 = new HashMap();
                g gVar3 = gVarArr3[0];
                Class cls5 = gVar3.f1289a;
                if (!hashMap3.containsKey(cls5)) {
                    hashMap3.put(cls5, gVar3);
                    Class cls6 = gVarArr3[0].f1289a;
                    Collections.unmodifiableMap(hashMap3);
                    g[] gVarArr4 = {new g(K1.a.class, 2)};
                    HashMap hashMap4 = new HashMap();
                    g gVar4 = gVarArr4[0];
                    Class cls7 = gVar4.f1289a;
                    if (!hashMap4.containsKey(cls7)) {
                        hashMap4.put(cls7, gVar4);
                        Class cls8 = gVarArr4[0].f1289a;
                        Collections.unmodifiableMap(hashMap4);
                        g[] gVarArr5 = {new g(K1.a.class, 6)};
                        HashMap hashMap5 = new HashMap();
                        g gVar5 = gVarArr5[0];
                        Class cls9 = gVar5.f1289a;
                        if (!hashMap5.containsKey(cls9)) {
                            hashMap5.put(cls9, gVar5);
                            Class cls10 = gVarArr5[0].f1289a;
                            Collections.unmodifiableMap(hashMap5);
                            g[] gVarArr6 = {new g(K1.a.class, 7)};
                            HashMap hashMap6 = new HashMap();
                            g gVar6 = gVarArr6[0];
                            Class cls11 = gVar6.f1289a;
                            if (!hashMap6.containsKey(cls11)) {
                                hashMap6.put(cls11, gVar6);
                                Class cls12 = gVarArr6[0].f1289a;
                                Collections.unmodifiableMap(hashMap6);
                                g[] gVarArr7 = {new g(K1.a.class, 5)};
                                HashMap hashMap7 = new HashMap();
                                g gVar7 = gVarArr7[0];
                                Class cls13 = gVar7.f1289a;
                                if (!hashMap7.containsKey(cls13)) {
                                    hashMap7.put(cls13, gVar7);
                                    Class cls14 = gVarArr7[0].f1289a;
                                    Collections.unmodifiableMap(hashMap7);
                                    g[] gVarArr8 = {new g(K1.a.class, 8)};
                                    HashMap hashMap8 = new HashMap();
                                    g gVar8 = gVarArr8[0];
                                    Class cls15 = gVar8.f1289a;
                                    if (!hashMap8.containsKey(cls15)) {
                                        hashMap8.put(cls15, gVar8);
                                        Class cls16 = gVarArr8[0].f1289a;
                                        Collections.unmodifiableMap(hashMap8);
                                        int i = s0.CONFIG_NAME_FIELD_NUMBER;
                                        try {
                                            a();
                                            return;
                                        } catch (GeneralSecurityException e4) {
                                            throw new ExceptionInInitializerError(e4);
                                        }
                                    }
                                    throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls15.getCanonicalName());
                                }
                                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls13.getCanonicalName());
                            }
                            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls11.getCanonicalName());
                        }
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls9.getCanonicalName());
                    }
                    throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls7.getCanonicalName());
                }
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls5.getCanonicalName());
            }
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
        }
        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
    }

    public static void a() {
        K1.o.h(e.f1288b);
        S1.l.a();
        Class<C0210h> cls = C0210h.class;
        i iVar = new i(cls, new g[]{new g(K1.a.class, 0)}, 0);
        int i = 1;
        K1.o.f(iVar, true);
        R1.j jVar = l.f1320a;
        R1.h hVar = R1.h.f1992b;
        hVar.e(l.f1320a);
        hVar.d(l.f1321b);
        hVar.c(l.f1322c);
        hVar.b(l.f1323d);
        int i3 = 3;
        K1.o.f(new i(C0225x.class, new g[]{new g(K1.a.class, 3)}, 2), true);
        hVar.e(r.f1336a);
        hVar.d(r.f1337b);
        hVar.c(r.f1338c);
        hVar.b(r.f1339d);
        if (O1.a.a()) {
            return;
        }
        K1.o.f(new i(W1.r.class, new g[]{new g(K1.a.class, 2)}, i), true);
        hVar.e(o.f1328a);
        hVar.d(o.f1329b);
        hVar.c(o.f1330c);
        hVar.b(o.f1331d);
        int i4 = 4;
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            K1.o.f(new i(W1.B.class, new g[]{new g(K1.a.class, 4)}, i3), true);
            hVar.e(u.f1342a);
            hVar.d(u.f1343b);
            hVar.c(u.f1344c);
            hVar.b(u.f1345d);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
        }
        K1.o.f(new i(J.class, new g[]{new g(K1.a.class, 5)}, i4), true);
        R1.j jVar2 = x.f1346a;
        R1.h hVar2 = R1.h.f1992b;
        hVar2.e(x.f1346a);
        hVar2.d(x.f1347b);
        hVar2.c(x.f1348c);
        hVar2.b(x.f1349d);
        Class<m0> cls2 = m0.class;
        K1.o.f(new i(cls2, new g[]{new g(K1.a.class, 6)}, 5), true);
        Class<p0> cls3 = p0.class;
        K1.o.f(new i(cls3, new g[]{new g(K1.a.class, 7)}, 6), true);
        Class<u0> cls4 = u0.class;
        K1.o.f(new i(cls4, new g[]{new g(K1.a.class, 8)}, 7), true);
        hVar2.e(B.f1280a);
        hVar2.d(B.f1281b);
        hVar2.c(B.f1282c);
        hVar2.b(B.f1283d);
    }
}
