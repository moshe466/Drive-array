package h9;

import h9.d;
import h9.e;
import ja.a;
import java.lang.reflect.Method;
import k9.k;
import ka.e;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import n9.p0;
import n9.q0;
import n9.r0;
import n9.v0;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    private static final la.a f10581a;

    /* renamed from: b, reason: collision with root package name */
    public static final h0 f10582b = new h0();

    static {
        la.a m10 = la.a.m(new la.b("java.lang.Void"));
        y8.k.d(m10, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        f10581a = m10;
    }

    private h0() {
    }

    private final k9.i a(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        sa.d dVar = sa.d.get(cls.getSimpleName());
        y8.k.d(dVar, "JvmPrimitiveType.get(simpleName)");
        return dVar.getPrimitiveType();
    }

    private final boolean b(n9.x xVar) {
        if (na.c.m(xVar) || na.c.n(xVar)) {
            return true;
        }
        return y8.k.a(xVar.c(), m9.a.f12051e.a()) && xVar.l().isEmpty();
    }

    private final d.e d(n9.x xVar) {
        return new d.e(new e.b(e(xVar), ea.t.c(xVar, false, false, 1, null)));
    }

    private final String e(n9.b bVar) {
        String b10 = v9.b0.b(bVar);
        if (b10 != null) {
            return b10;
        }
        if (bVar instanceof q0) {
            String k10 = ra.a.o(bVar).c().k();
            y8.k.d(k10, "descriptor.propertyIfAccessor.name.asString()");
            return v9.x.a(k10);
        }
        if (bVar instanceof r0) {
            String k11 = ra.a.o(bVar).c().k();
            y8.k.d(k11, "descriptor.propertyIfAccessor.name.asString()");
            return v9.x.d(k11);
        }
        String k12 = bVar.c().k();
        y8.k.d(k12, "descriptor.name.asString()");
        return k12;
    }

    public final la.a c(Class<?> cls) {
        y8.k.e(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            y8.k.d(componentType, "klass.componentType");
            k9.i a10 = a(componentType);
            if (a10 != null) {
                return new la.a(k9.k.f11246l, a10.getArrayTypeName());
            }
            la.a m10 = la.a.m(k.a.f11265h.l());
            y8.k.d(m10, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return m10;
        }
        if (y8.k.a(cls, Void.TYPE)) {
            return f10581a;
        }
        k9.i a11 = a(cls);
        if (a11 != null) {
            return new la.a(k9.k.f11246l, a11.getTypeName());
        }
        la.a b10 = s9.b.b(cls);
        if (!b10.k()) {
            m9.c cVar = m9.c.f12055a;
            la.b b11 = b10.b();
            y8.k.d(b11, "classId.asSingleFqName()");
            la.a n10 = cVar.n(b11);
            if (n10 != null) {
                return n10;
            }
        }
        return b10;
    }

    public final e f(p0 p0Var) {
        y8.k.e(p0Var, "possiblyOverriddenProperty");
        n9.b L = na.d.L(p0Var);
        y8.k.d(L, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        p0 a10 = ((p0) L).a();
        y8.k.d(a10, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (a10 instanceof za.j) {
            za.j jVar = (za.j) a10;
            ga.n Y = jVar.Y();
            i.f<ga.n, a.d> fVar = ja.a.f10976d;
            y8.k.d(fVar, "JvmProtoBuf.propertySignature");
            a.d dVar = (a.d) ia.e.a(Y, fVar);
            if (dVar != null) {
                return new e.c(a10, Y, dVar, jVar.O0(), jVar.z0());
            }
        } else if (a10 instanceof x9.g) {
            v0 k10 = ((x9.g) a10).k();
            if (!(k10 instanceof ba.a)) {
                k10 = null;
            }
            ba.a aVar = (ba.a) k10;
            ca.l b10 = aVar != null ? aVar.b() : null;
            if (b10 instanceof s9.p) {
                return new e.a(((s9.p) b10).c0());
            }
            if (!(b10 instanceof s9.s)) {
                throw new b0("Incorrect resolution sequence for Java field " + a10 + " (source = " + b10 + ')');
            }
            Method c02 = ((s9.s) b10).c0();
            r0 M0 = a10.M0();
            v0 k11 = M0 != null ? M0.k() : null;
            if (!(k11 instanceof ba.a)) {
                k11 = null;
            }
            ba.a aVar2 = (ba.a) k11;
            ca.l b11 = aVar2 != null ? aVar2.b() : null;
            if (!(b11 instanceof s9.s)) {
                b11 = null;
            }
            s9.s sVar = (s9.s) b11;
            return new e.b(c02, sVar != null ? sVar.c0() : null);
        }
        q0 t10 = a10.t();
        y8.k.b(t10);
        d.e d10 = d(t10);
        r0 M02 = a10.M0();
        return new e.d(d10, M02 != null ? d(M02) : null);
    }

    public final d g(n9.x xVar) {
        Method c02;
        e.b b10;
        e.b e10;
        y8.k.e(xVar, "possiblySubstitutedFunction");
        n9.b L = na.d.L(xVar);
        y8.k.d(L, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        n9.x a10 = ((n9.x) L).a();
        y8.k.d(a10, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (a10 instanceof za.b) {
            za.b bVar = (za.b) a10;
            kotlin.reflect.jvm.internal.impl.protobuf.q Y = bVar.Y();
            if ((Y instanceof ga.i) && (e10 = ka.h.f11321a.e((ga.i) Y, bVar.O0(), bVar.z0())) != null) {
                return new d.e(e10);
            }
            if (!(Y instanceof ga.d) || (b10 = ka.h.f11321a.b((ga.d) Y, bVar.O0(), bVar.z0())) == null) {
                return d(a10);
            }
            n9.m d10 = xVar.d();
            y8.k.d(d10, "possiblySubstitutedFunction.containingDeclaration");
            return na.f.b(d10) ? new d.e(b10) : new d.C0189d(b10);
        }
        if (a10 instanceof x9.f) {
            v0 k10 = ((x9.f) a10).k();
            if (!(k10 instanceof ba.a)) {
                k10 = null;
            }
            ba.a aVar = (ba.a) k10;
            ca.l b11 = aVar != null ? aVar.b() : null;
            s9.s sVar = (s9.s) (b11 instanceof s9.s ? b11 : null);
            if (sVar != null && (c02 = sVar.c0()) != null) {
                return new d.c(c02);
            }
            throw new b0("Incorrect resolution sequence for Java method " + a10);
        }
        if (!(a10 instanceof x9.c)) {
            if (b(a10)) {
                return d(a10);
            }
            throw new b0("Unknown origin of " + a10 + " (" + a10.getClass() + ')');
        }
        v0 k11 = ((x9.c) a10).k();
        if (!(k11 instanceof ba.a)) {
            k11 = null;
        }
        ba.a aVar2 = (ba.a) k11;
        ca.l b12 = aVar2 != null ? aVar2.b() : null;
        if (b12 instanceof s9.m) {
            return new d.b(((s9.m) b12).c0());
        }
        if (b12 instanceof s9.j) {
            s9.j jVar = (s9.j) b12;
            if (jVar.E()) {
                return new d.a(jVar.V());
            }
        }
        throw new b0("Incorrect resolution sequence for Java constructor " + a10 + " (" + b12 + ')');
    }
}
