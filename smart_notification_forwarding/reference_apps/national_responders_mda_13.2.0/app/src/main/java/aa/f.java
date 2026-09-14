package aa;

import bb.b0;
import bb.h0;
import bb.i0;
import bb.v;
import bb.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import l8.n;
import m8.r;
import m8.y;
import mb.s;
import ua.h;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class f extends v implements h0 {

    /* loaded from: classes.dex */
    static final class a extends l implements x8.l<String, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f353f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(String str) {
            k.e(str, "it");
            return k.j("(raw) ", str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(i0 i0Var, i0 i0Var2) {
        this(i0Var, i0Var2, false);
        k.e(i0Var, "lowerBound");
        k.e(i0Var2, "upperBound");
    }

    private f(i0 i0Var, i0 i0Var2, boolean z10) {
        super(i0Var, i0Var2);
        if (z10) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a.b(i0Var, i0Var2);
    }

    private static final boolean j1(String str, String str2) {
        String S;
        S = s.S(str2, "out ");
        return k.a(str, S) || k.a(str2, "*");
    }

    private static final List<String> k1(kotlin.reflect.jvm.internal.impl.renderer.c cVar, b0 b0Var) {
        int n10;
        List<v0> V0 = b0Var.V0();
        n10 = r.n(V0, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = V0.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.y((v0) it.next()));
        }
        return arrayList;
    }

    private static final String l1(String str, String str2) {
        boolean z10;
        String f02;
        String c02;
        z10 = s.z(str, '<', false, 2, null);
        if (!z10) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        f02 = s.f0(str, '<', null, 2, null);
        sb2.append(f02);
        sb2.append('<');
        sb2.append(str2);
        sb2.append('>');
        c02 = s.c0(str, '>', null, 2, null);
        sb2.append(c02);
        return sb2.toString();
    }

    @Override // bb.v, bb.b0
    public h A() {
        n9.h o10 = W0().o();
        n9.e eVar = o10 instanceof n9.e ? (n9.e) o10 : null;
        if (eVar == null) {
            throw new IllegalStateException(k.j("Incorrect classifier: ", W0().o()).toString());
        }
        h J = eVar.J(e.f345b);
        k.d(J, "classDescriptor.getMemberScope(RawSubstitution)");
        return J;
    }

    @Override // bb.v
    public i0 d1() {
        return e1();
    }

    @Override // bb.v
    public String g1(kotlin.reflect.jvm.internal.impl.renderer.c cVar, kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
        String Q;
        List u02;
        k.e(cVar, "renderer");
        k.e(fVar, "options");
        String x10 = cVar.x(e1());
        String x11 = cVar.x(f1());
        if (fVar.m()) {
            return "raw (" + x10 + ".." + x11 + ')';
        }
        if (f1().V0().isEmpty()) {
            return cVar.u(x10, x11, eb.a.e(this));
        }
        List<String> k12 = k1(cVar, e1());
        List<String> k13 = k1(cVar, f1());
        Q = y.Q(k12, ", ", null, null, 0, null, a.f353f, 30, null);
        u02 = y.u0(k12, k13);
        boolean z10 = true;
        if (!(u02 instanceof Collection) || !u02.isEmpty()) {
            Iterator it = u02.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n nVar = (n) it.next();
                if (!j1((String) nVar.c(), (String) nVar.d())) {
                    z10 = false;
                    break;
                }
            }
        }
        if (z10) {
            x11 = l1(x11, Q);
        }
        String l12 = l1(x10, Q);
        return k.a(l12, x11) ? l12 : cVar.u(l12, x11, eb.a.e(this));
    }

    @Override // bb.g1
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public f a1(boolean z10) {
        return new f(e1().a1(z10), f1().a1(z10));
    }

    @Override // bb.g1
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public v g1(g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        return new f((i0) gVar.g(e1()), (i0) gVar.g(f1()), true);
    }

    @Override // bb.g1
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public f c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        k.e(gVar, "newAnnotations");
        return new f(e1().c1(gVar), f1().c1(gVar));
    }
}
