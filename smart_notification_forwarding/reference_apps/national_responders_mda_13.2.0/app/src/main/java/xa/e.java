package xa;

import bb.i0;
import ga.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m8.g0;
import m8.k0;
import m8.l0;
import n9.d0;
import n9.d1;
import n9.f0;
import n9.v0;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f15568a;

    /* renamed from: b, reason: collision with root package name */
    private final f0 f15569b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15570a;

        static {
            int[] iArr = new int[b.C0176b.c.EnumC0179c.values().length];
            iArr[b.C0176b.c.EnumC0179c.BYTE.ordinal()] = 1;
            iArr[b.C0176b.c.EnumC0179c.CHAR.ordinal()] = 2;
            iArr[b.C0176b.c.EnumC0179c.SHORT.ordinal()] = 3;
            iArr[b.C0176b.c.EnumC0179c.INT.ordinal()] = 4;
            iArr[b.C0176b.c.EnumC0179c.LONG.ordinal()] = 5;
            iArr[b.C0176b.c.EnumC0179c.FLOAT.ordinal()] = 6;
            iArr[b.C0176b.c.EnumC0179c.DOUBLE.ordinal()] = 7;
            iArr[b.C0176b.c.EnumC0179c.BOOLEAN.ordinal()] = 8;
            iArr[b.C0176b.c.EnumC0179c.STRING.ordinal()] = 9;
            iArr[b.C0176b.c.EnumC0179c.CLASS.ordinal()] = 10;
            iArr[b.C0176b.c.EnumC0179c.ENUM.ordinal()] = 11;
            iArr[b.C0176b.c.EnumC0179c.ANNOTATION.ordinal()] = 12;
            iArr[b.C0176b.c.EnumC0179c.ARRAY.ordinal()] = 13;
            f15570a = iArr;
        }
    }

    public e(d0 d0Var, f0 f0Var) {
        y8.k.e(d0Var, "module");
        y8.k.e(f0Var, "notFoundClasses");
        this.f15568a = d0Var;
        this.f15569b = f0Var;
    }

    private final boolean b(pa.g<?> gVar, bb.b0 b0Var, b.C0176b.c cVar) {
        Iterable e10;
        b.C0176b.c.EnumC0179c U = cVar.U();
        int i10 = U == null ? -1 : a.f15570a[U.ordinal()];
        if (i10 == 10) {
            n9.h o10 = b0Var.W0().o();
            n9.e eVar = o10 instanceof n9.e ? (n9.e) o10 : null;
            if (eVar != null && !k9.h.q0(eVar)) {
                return false;
            }
        } else {
            if (i10 != 13) {
                return y8.k.a(gVar.a(this.f15568a), b0Var);
            }
            if (!((gVar instanceof pa.b) && ((pa.b) gVar).b().size() == cVar.L().size())) {
                throw new IllegalStateException(y8.k.j("Deserialized ArrayValue should have the same number of elements as the original array value: ", gVar).toString());
            }
            bb.b0 k10 = c().k(b0Var);
            y8.k.d(k10, "builtIns.getArrayElementType(expectedType)");
            pa.b bVar = (pa.b) gVar;
            e10 = m8.q.e(bVar.b());
            if (!(e10 instanceof Collection) || !((Collection) e10).isEmpty()) {
                Iterator it = e10.iterator();
                while (it.hasNext()) {
                    int b10 = ((g0) it).b();
                    pa.g<?> gVar2 = bVar.b().get(b10);
                    b.C0176b.c J = cVar.J(b10);
                    y8.k.d(J, "value.getArrayElement(i)");
                    if (!b(gVar2, k10, J)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final k9.h c() {
        return this.f15568a.w();
    }

    private final l8.n<la.e, pa.g<?>> d(b.C0176b c0176b, Map<la.e, ? extends d1> map, ia.c cVar) {
        d1 d1Var = map.get(v.b(cVar, c0176b.x()));
        if (d1Var == null) {
            return null;
        }
        la.e b10 = v.b(cVar, c0176b.x());
        bb.b0 b11 = d1Var.b();
        y8.k.d(b11, "parameter.type");
        b.C0176b.c y10 = c0176b.y();
        y8.k.d(y10, "proto.value");
        return new l8.n<>(b10, g(b11, y10, cVar));
    }

    private final n9.e e(la.a aVar) {
        return n9.w.c(this.f15568a, aVar, this.f15569b);
    }

    private final pa.g<?> g(bb.b0 b0Var, b.C0176b.c cVar, ia.c cVar2) {
        pa.g<?> f10 = f(b0Var, cVar, cVar2);
        if (!b(f10, b0Var, cVar)) {
            f10 = null;
        }
        if (f10 != null) {
            return f10;
        }
        return pa.k.f13334b.a("Unexpected argument value: actual type " + cVar.U() + " != expected type " + b0Var);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(ga.b bVar, ia.c cVar) {
        Map h10;
        int n10;
        int d10;
        int a10;
        y8.k.e(bVar, "proto");
        y8.k.e(cVar, "nameResolver");
        n9.e e10 = e(v.a(cVar, bVar.B()));
        h10 = l0.h();
        if (bVar.y() != 0 && !bb.t.r(e10) && na.d.t(e10)) {
            Collection<n9.d> q10 = e10.q();
            y8.k.d(q10, "annotationClass.constructors");
            n9.d dVar = (n9.d) m8.o.e0(q10);
            if (dVar != null) {
                List<d1> l10 = dVar.l();
                y8.k.d(l10, "constructor.valueParameters");
                n10 = m8.r.n(l10, 10);
                d10 = k0.d(n10);
                a10 = d9.f.a(d10, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
                for (Object obj : l10) {
                    linkedHashMap.put(((d1) obj).c(), obj);
                }
                List<b.C0176b> z10 = bVar.z();
                y8.k.d(z10, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (b.C0176b c0176b : z10) {
                    y8.k.d(c0176b, "it");
                    l8.n<la.e, pa.g<?>> d11 = d(c0176b, linkedHashMap, cVar);
                    if (d11 != null) {
                        arrayList.add(d11);
                    }
                }
                h10 = l0.p(arrayList);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(e10.s(), h10, v0.f12324a);
    }

    public final pa.g<?> f(bb.b0 b0Var, b.C0176b.c cVar, ia.c cVar2) {
        pa.g<?> dVar;
        int n10;
        y8.k.e(b0Var, "expectedType");
        y8.k.e(cVar, "value");
        y8.k.e(cVar2, "nameResolver");
        Boolean d10 = ia.b.M.d(cVar.Q());
        y8.k.d(d10, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = d10.booleanValue();
        b.C0176b.c.EnumC0179c U = cVar.U();
        switch (U == null ? -1 : a.f15570a[U.ordinal()]) {
            case 1:
                byte S = (byte) cVar.S();
                if (booleanValue) {
                    dVar = new pa.w(S);
                    break;
                } else {
                    dVar = new pa.d(S);
                    break;
                }
            case 2:
                return new pa.e((char) cVar.S());
            case 3:
                short S2 = (short) cVar.S();
                if (booleanValue) {
                    dVar = new pa.z(S2);
                    break;
                } else {
                    dVar = new pa.u(S2);
                    break;
                }
            case 4:
                int S3 = (int) cVar.S();
                return booleanValue ? new pa.x(S3) : new pa.m(S3);
            case 5:
                long S4 = cVar.S();
                return booleanValue ? new pa.y(S4) : new pa.r(S4);
            case 6:
                return new pa.l(cVar.R());
            case 7:
                return new pa.i(cVar.O());
            case 8:
                return new pa.c(cVar.S() != 0);
            case 9:
                return new pa.v(cVar2.a(cVar.T()));
            case 10:
                return new pa.q(v.a(cVar2, cVar.M()), cVar.I());
            case 11:
                return new pa.j(v.a(cVar2, cVar.M()), v.b(cVar2, cVar.P()));
            case 12:
                ga.b H = cVar.H();
                y8.k.d(H, "value.annotation");
                return new pa.a(a(H, cVar2));
            case 13:
                pa.h hVar = pa.h.f13329a;
                List<b.C0176b.c> L = cVar.L();
                y8.k.d(L, "value.arrayElementList");
                n10 = m8.r.n(L, 10);
                ArrayList arrayList = new ArrayList(n10);
                for (b.C0176b.c cVar3 : L) {
                    i0 i10 = c().i();
                    y8.k.d(i10, "builtIns.anyType");
                    y8.k.d(cVar3, "it");
                    arrayList.add(f(i10, cVar3, cVar2));
                }
                return hVar.a(arrayList, b0Var);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + cVar.U() + " (expected " + b0Var + ')').toString());
        }
        return dVar;
    }
}
