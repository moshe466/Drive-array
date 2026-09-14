package ra;

import bb.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jb.b;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import lb.n;
import m8.o;
import m8.p;
import m8.q;
import m8.r;
import n9.d0;
import n9.d1;
import n9.g0;
import n9.h;
import n9.m;
import n9.o0;
import n9.p0;
import pa.g;
import x8.l;
import y8.i;
import y8.k;
import y8.v;
import y8.w;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: ra.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0284a implements b.c<d1> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0284a f13821a = new C0284a();

        C0284a() {
        }

        @Override // jb.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<d1> a(d1 d1Var) {
            int n10;
            Collection<d1> g10 = d1Var.g();
            n10 = r.n(g10, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = g10.iterator();
            while (it.hasNext()) {
                arrayList.add(((d1) it.next()).a());
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    /* synthetic */ class b extends i implements l<d1, Boolean> {

        /* renamed from: o, reason: collision with root package name */
        public static final b f13822o = new b();

        b() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "declaresDefaultValue";
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(d1 d1Var) {
            return Boolean.valueOf(n(d1Var));
        }

        @Override // y8.c
        public final e9.d k() {
            return w.b(d1.class);
        }

        @Override // y8.c
        public final String m() {
            return "declaresDefaultValue()Z";
        }

        public final boolean n(d1 d1Var) {
            k.e(d1Var, "p0");
            return d1Var.k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements b.c<n9.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f13823a;

        c(boolean z10) {
            this.f13823a = z10;
        }

        @Override // jb.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<n9.b> a(n9.b bVar) {
            List d10;
            if (this.f13823a) {
                bVar = bVar == null ? null : bVar.a();
            }
            Collection<? extends n9.b> g10 = bVar != null ? bVar.g() : null;
            if (g10 != null) {
                return g10;
            }
            d10 = q.d();
            return d10;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends b.AbstractC0222b<n9.b, n9.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v<n9.b> f13824a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l<n9.b, Boolean> f13825b;

        /* JADX WARN: Multi-variable type inference failed */
        d(v<n9.b> vVar, l<? super n9.b, Boolean> lVar) {
            this.f13824a = vVar;
            this.f13825b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jb.b.AbstractC0222b, jb.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(n9.b bVar) {
            k.e(bVar, "current");
            if (this.f13824a.f15950f == null && this.f13825b.h(bVar).booleanValue()) {
                this.f13824a.f15950f = bVar;
            }
        }

        @Override // jb.b.d
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(n9.b bVar) {
            k.e(bVar, "current");
            return this.f13824a.f15950f == null;
        }

        @Override // jb.b.d
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public n9.b a() {
            return this.f13824a.f15950f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends y8.l implements l<m, m> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f13826f = new e();

        e() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m h(m mVar) {
            k.e(mVar, "it");
            return mVar.d();
        }
    }

    static {
        k.d(la.e.r("value"), "identifier(\"value\")");
    }

    public static final boolean a(d1 d1Var) {
        List b10;
        k.e(d1Var, "<this>");
        b10 = p.b(d1Var);
        Boolean e10 = jb.b.e(b10, C0284a.f13821a, b.f13822o);
        k.d(e10, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return e10.booleanValue();
    }

    public static final g<?> b(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        k.e(cVar, "<this>");
        return (g) o.I(cVar.a().values());
    }

    public static final n9.b c(n9.b bVar, boolean z10, l<? super n9.b, Boolean> lVar) {
        List b10;
        k.e(bVar, "<this>");
        k.e(lVar, "predicate");
        v vVar = new v();
        b10 = p.b(bVar);
        return (n9.b) jb.b.b(b10, new c(z10), new d(vVar, lVar));
    }

    public static /* synthetic */ n9.b d(n9.b bVar, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return c(bVar, z10, lVar);
    }

    public static final la.b e(m mVar) {
        k.e(mVar, "<this>");
        la.c j10 = j(mVar);
        if (!j10.f()) {
            j10 = null;
        }
        if (j10 == null) {
            return null;
        }
        return j10.l();
    }

    public static final n9.e f(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        k.e(cVar, "<this>");
        h A = cVar.b().W0().A();
        if (A instanceof n9.e) {
            return (n9.e) A;
        }
        return null;
    }

    public static final k9.h g(m mVar) {
        k.e(mVar, "<this>");
        return l(mVar).w();
    }

    public static final la.a h(h hVar) {
        m d10;
        la.a h10;
        if (hVar == null || (d10 = hVar.d()) == null) {
            return null;
        }
        if (d10 instanceof g0) {
            return new la.a(((g0) d10).f(), hVar.c());
        }
        if (!(d10 instanceof n9.i) || (h10 = h((h) d10)) == null) {
            return null;
        }
        return h10.d(hVar.c());
    }

    public static final la.b i(m mVar) {
        k.e(mVar, "<this>");
        la.b n10 = na.d.n(mVar);
        k.d(n10, "getFqNameSafe(this)");
        return n10;
    }

    public static final la.c j(m mVar) {
        k.e(mVar, "<this>");
        la.c m10 = na.d.m(mVar);
        k.d(m10, "getFqName(this)");
        return m10;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.checker.g k(d0 d0Var) {
        k.e(d0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.o oVar = (kotlin.reflect.jvm.internal.impl.types.checker.o) d0Var.Q0(kotlin.reflect.jvm.internal.impl.types.checker.h.a());
        kotlin.reflect.jvm.internal.impl.types.checker.g gVar = oVar == null ? null : (kotlin.reflect.jvm.internal.impl.types.checker.g) oVar.a();
        return gVar == null ? g.a.f11566a : gVar;
    }

    public static final d0 l(m mVar) {
        k.e(mVar, "<this>");
        d0 g10 = na.d.g(mVar);
        k.d(g10, "getContainingModule(this)");
        return g10;
    }

    public static final lb.h<m> m(m mVar) {
        lb.h<m> k10;
        k.e(mVar, "<this>");
        k10 = n.k(n(mVar), 1);
        return k10;
    }

    public static final lb.h<m> n(m mVar) {
        lb.h<m> f10;
        k.e(mVar, "<this>");
        f10 = lb.l.f(mVar, e.f13826f);
        return f10;
    }

    public static final n9.b o(n9.b bVar) {
        k.e(bVar, "<this>");
        if (!(bVar instanceof o0)) {
            return bVar;
        }
        p0 y02 = ((o0) bVar).y0();
        k.d(y02, "correspondingProperty");
        return y02;
    }

    public static final n9.e p(n9.e eVar) {
        k.e(eVar, "<this>");
        for (b0 b0Var : eVar.s().W0().x()) {
            if (!k9.h.a0(b0Var)) {
                h A = b0Var.W0().A();
                if (na.d.w(A)) {
                    Objects.requireNonNull(A, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (n9.e) A;
                }
            }
        }
        return null;
    }

    public static final boolean q(d0 d0Var) {
        k.e(d0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.o oVar = (kotlin.reflect.jvm.internal.impl.types.checker.o) d0Var.Q0(kotlin.reflect.jvm.internal.impl.types.checker.h.a());
        return (oVar == null ? null : (kotlin.reflect.jvm.internal.impl.types.checker.g) oVar.a()) != null;
    }

    public static final n9.e r(d0 d0Var, la.b bVar, u9.b bVar2) {
        k.e(d0Var, "<this>");
        k.e(bVar, "topLevelClassFqName");
        k.e(bVar2, "location");
        bVar.d();
        la.b e10 = bVar.e();
        k.d(e10, "topLevelClassFqName.parent()");
        ua.h A = d0Var.C(e10).A();
        la.e g10 = bVar.g();
        k.d(g10, "topLevelClassFqName.shortName()");
        h g11 = A.g(g10, bVar2);
        if (g11 instanceof n9.e) {
            return (n9.e) g11;
        }
        return null;
    }
}
