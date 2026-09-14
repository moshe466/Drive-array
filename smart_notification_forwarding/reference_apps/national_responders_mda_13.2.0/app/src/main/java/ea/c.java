package ea;

import bb.a0;
import bb.b0;
import bb.c1;
import bb.h1;
import bb.t0;
import bb.v0;
import n9.a1;
import n9.g0;
import n9.q0;
import n9.z0;

/* loaded from: classes.dex */
public final class c {
    public static final String a(n9.e eVar, w<?> wVar) {
        String t10;
        y8.k.e(eVar, "klass");
        y8.k.e(wVar, "typeMappingConfiguration");
        String c10 = wVar.c(eVar);
        if (c10 != null) {
            return c10;
        }
        n9.m d10 = eVar.d();
        y8.k.d(d10, "klass.containingDeclaration");
        String n10 = la.g.c(eVar.c()).n();
        y8.k.d(n10, "safeIdentifier(klass.name).identifier");
        if (d10 instanceof g0) {
            la.b f10 = ((g0) d10).f();
            if (f10.d()) {
                return n10;
            }
            StringBuilder sb2 = new StringBuilder();
            String b10 = f10.b();
            y8.k.d(b10, "fqName.asString()");
            t10 = mb.r.t(b10, '.', '/', false, 4, null);
            sb2.append(t10);
            sb2.append('/');
            sb2.append(n10);
            return sb2.toString();
        }
        n9.e eVar2 = d10 instanceof n9.e ? (n9.e) d10 : null;
        if (eVar2 == null) {
            throw new IllegalArgumentException("Unexpected container: " + d10 + " for " + eVar);
        }
        String d11 = wVar.d(eVar2);
        if (d11 == null) {
            d11 = a(eVar2, wVar);
        }
        return d11 + '$' + n10;
    }

    public static /* synthetic */ String b(n9.e eVar, w wVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            wVar = x.f9332a;
        }
        return a(eVar, wVar);
    }

    public static final boolean c(n9.a aVar) {
        y8.k.e(aVar, "descriptor");
        if (aVar instanceof n9.l) {
            return true;
        }
        b0 i10 = aVar.i();
        y8.k.b(i10);
        if (k9.h.J0(i10)) {
            b0 i11 = aVar.i();
            y8.k.b(i11);
            if (!c1.l(i11) && !(aVar instanceof q0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
    public static final <T> T d(b0 b0Var, k<T> kVar, y yVar, w<? extends T> wVar, h<T> hVar, x8.q<? super b0, ? super T, ? super y, l8.w> qVar) {
        T t10;
        b0 b0Var2;
        Object d10;
        y8.k.e(b0Var, "kotlinType");
        y8.k.e(kVar, "factory");
        y8.k.e(yVar, "mode");
        y8.k.e(wVar, "typeMappingConfiguration");
        y8.k.e(qVar, "writeGenericType");
        b0 a10 = wVar.a(b0Var);
        if (a10 != null) {
            return (T) d(a10, kVar, yVar, wVar, hVar, qVar);
        }
        if (k9.g.o(b0Var)) {
            return (T) d(k9.l.b(b0Var, wVar.b()), kVar, yVar, wVar, hVar, qVar);
        }
        kotlin.reflect.jvm.internal.impl.types.checker.p pVar = kotlin.reflect.jvm.internal.impl.types.checker.p.f11591a;
        Object b10 = z.b(pVar, b0Var, kVar, yVar);
        if (b10 != null) {
            ?? r92 = (Object) z.a(kVar, b10, yVar.d());
            qVar.f(b0Var, r92, yVar);
            return r92;
        }
        t0 W0 = b0Var.W0();
        if (W0 instanceof a0) {
            a0 a0Var = (a0) W0;
            b0 d11 = a0Var.d();
            if (d11 == null) {
                d11 = wVar.g(a0Var.x());
            }
            return (T) d(eb.a.m(d11), kVar, yVar, wVar, hVar, qVar);
        }
        n9.h o10 = W0.o();
        if (o10 == null) {
            throw new UnsupportedOperationException(y8.k.j("no descriptor for type constructor of ", b0Var));
        }
        if (bb.t.r(o10)) {
            T t11 = (T) kVar.b("error/NonExistentClass");
            wVar.e(b0Var, (n9.e) o10);
            return t11;
        }
        boolean z10 = o10 instanceof n9.e;
        if (z10 && k9.h.b0(b0Var)) {
            if (b0Var.V0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            v0 v0Var = b0Var.V0().get(0);
            b0 b11 = v0Var.b();
            y8.k.d(b11, "memberProjection.type");
            if (v0Var.c() == h1.IN_VARIANCE) {
                d10 = kVar.b("java/lang/Object");
            } else {
                h1 c10 = v0Var.c();
                y8.k.d(c10, "memberProjection.projectionKind");
                d10 = d(b11, kVar, yVar.f(c10, true), wVar, hVar, qVar);
            }
            return (T) kVar.a(y8.k.j("[", kVar.d(d10)));
        }
        if (!z10) {
            if (o10 instanceof a1) {
                return (T) d(eb.a.f((a1) o10), kVar, yVar, wVar, null, jb.d.b());
            }
            if ((o10 instanceof z0) && yVar.b()) {
                return (T) d(((z0) o10).D0(), kVar, yVar, wVar, hVar, qVar);
            }
            throw new UnsupportedOperationException(y8.k.j("Unknown type ", b0Var));
        }
        if (na.f.b(o10) && !yVar.c() && (b0Var2 = (b0) bb.u.a(pVar, b0Var)) != null) {
            return (T) d(b0Var2, kVar, yVar.g(), wVar, hVar, qVar);
        }
        if (yVar.e() && k9.h.q0((n9.e) o10)) {
            t10 = (Object) kVar.f();
        } else {
            n9.e eVar = (n9.e) o10;
            n9.e a11 = eVar.a();
            y8.k.d(a11, "descriptor.original");
            T f10 = wVar.f(a11);
            if (f10 == null) {
                if (eVar.r() == n9.f.ENUM_ENTRY) {
                    eVar = (n9.e) eVar.d();
                }
                n9.e a12 = eVar.a();
                y8.k.d(a12, "enumClassIfEnumEntry.original");
                t10 = (Object) kVar.b(a(a12, wVar));
            } else {
                t10 = (Object) f10;
            }
        }
        qVar.f(b0Var, t10, yVar);
        return t10;
    }

    public static /* synthetic */ Object e(b0 b0Var, k kVar, y yVar, w wVar, h hVar, x8.q qVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            qVar = jb.d.b();
        }
        return d(b0Var, kVar, yVar, wVar, hVar, qVar);
    }
}
