package L1;

import F0.b3;
import W1.C0204b;
import W1.C0210h;
import W1.C0214l;
import W1.C0225x;
import W1.F;
import W1.J;
import W1.O;
import W1.Q;
import W1.m0;
import W1.p0;
import W1.u0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1289a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1290b;

    public g(Class cls, int i) {
        this.f1290b = i;
        this.f1289a = cls;
    }

    public final Object a(AbstractC0329a abstractC0329a) {
        switch (this.f1290b) {
            case 0:
                C0210h c0210h = (C0210h) abstractC0329a;
                g[] gVarArr = {new g(X1.j.class, 1)};
                HashMap hashMap = new HashMap();
                for (g gVar : gVarArr) {
                    Class cls = gVar.f1289a;
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, gVar);
                    } else {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
                    }
                }
                if (gVarArr.length > 0) {
                    Class cls2 = gVarArr[0].f1289a;
                }
                Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                C0214l z3 = c0210h.z();
                g gVar2 = (g) unmodifiableMap.get(X1.j.class);
                if (gVar2 != null) {
                    X1.j jVar = (X1.j) gVar2.a(z3);
                    g[] gVarArr2 = {new g(K1.j.class, 11)};
                    HashMap hashMap2 = new HashMap();
                    for (g gVar3 : gVarArr2) {
                        Class cls3 = gVar3.f1289a;
                        if (!hashMap2.containsKey(cls3)) {
                            hashMap2.put(cls3, gVar3);
                        } else {
                            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                        }
                    }
                    if (gVarArr2.length > 0) {
                        Class cls4 = gVarArr2[0].f1289a;
                    }
                    Map unmodifiableMap2 = Collections.unmodifiableMap(hashMap2);
                    Q A3 = c0210h.A();
                    g gVar4 = (g) unmodifiableMap2.get(K1.j.class);
                    if (gVar4 != null) {
                        return new X1.g(jVar, (K1.j) gVar4.a(A3), c0210h.A().B().A());
                    }
                    throw new IllegalArgumentException("Requested primitive class " + K1.j.class.getCanonicalName() + " not supported.");
                }
                throw new IllegalArgumentException("Requested primitive class " + X1.j.class.getCanonicalName() + " not supported.");
            case 1:
                C0214l c0214l = (C0214l) abstractC0329a;
                return new X1.a(c0214l.A().k(), c0214l.B().y());
            case 2:
                W1.r rVar = (W1.r) abstractC0329a;
                return new X1.b(rVar.z().k(), rVar.A().y());
            case 3:
                return new X1.c(((C0225x) abstractC0329a).y().k(), 0);
            case 4:
                return new N1.a(((W1.B) abstractC0329a).y().k());
            case 5:
                return new X1.c(((J) abstractC0329a).y().k(), 1);
            case 6:
                String x3 = ((m0) abstractC0329a).y().x();
                return K1.i.a(x3).c(x3);
            case 7:
                p0 p0Var = (p0) abstractC0329a;
                String y = p0Var.y().y();
                return new y(p0Var.y().x(), K1.i.a(y).c(y));
            case 8:
                return new X1.c(((u0) abstractC0329a).y().k(), 2);
            case 9:
                return new X1.d(((F) abstractC0329a).y().k());
            case 10:
                C0204b c0204b = (C0204b) abstractC0329a;
                return new X1.m(new b3(c0204b.z().k()), c0204b.A().y());
            default:
                Q q3 = (Q) abstractC0329a;
                O z4 = q3.B().z();
                SecretKeySpec secretKeySpec = new SecretKeySpec(q3.A().k(), "HMAC");
                int A4 = q3.B().A();
                int ordinal = z4.ordinal();
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            if (ordinal != 4) {
                                if (ordinal == 5) {
                                    return new X1.m(new X1.l("HMACSHA224", secretKeySpec), A4);
                                }
                                throw new GeneralSecurityException("unknown hash");
                            }
                            return new X1.m(new X1.l("HMACSHA512", secretKeySpec), A4);
                        }
                        return new X1.m(new X1.l("HMACSHA256", secretKeySpec), A4);
                    }
                    return new X1.m(new X1.l("HMACSHA384", secretKeySpec), A4);
                }
                return new X1.m(new X1.l("HMACSHA1", secretKeySpec), A4);
        }
    }
}
