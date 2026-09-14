package p9;

import bb.c1;
import bb.g1;
import bb.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import n9.a1;
import n9.v0;
import n9.z0;
import p9.i0;
import ua.h;

/* loaded from: classes.dex */
public abstract class d extends k implements z0 {

    /* renamed from: j, reason: collision with root package name */
    private final n9.u f13175j;

    /* renamed from: k, reason: collision with root package name */
    private List<? extends a1> f13176k;

    /* renamed from: l, reason: collision with root package name */
    private final c f13177l;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, bb.i0> {
        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final bb.i0 h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            n9.h e10 = gVar.e(d.this);
            if (e10 == null) {
                return null;
            }
            return e10.s();
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<g1, Boolean> {
        b() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
        
            if (((r5 instanceof n9.a1) && !y8.k.a(((n9.a1) r5).d(), r0)) != false) goto L13;
         */
        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean h(bb.g1 r5) {
            /*
                r4 = this;
                java.lang.String r0 = "type"
                y8.k.d(r5, r0)
                boolean r0 = bb.d0.a(r5)
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L2d
                p9.d r0 = p9.d.this
                bb.t0 r5 = r5.W0()
                n9.h r5 = r5.o()
                boolean r3 = r5 instanceof n9.a1
                if (r3 == 0) goto L29
                n9.a1 r5 = (n9.a1) r5
                n9.m r5 = r5.d()
                boolean r5 = y8.k.a(r5, r0)
                if (r5 != 0) goto L29
                r5 = 1
                goto L2a
            L29:
                r5 = 0
            L2a:
                if (r5 == 0) goto L2d
                goto L2e
            L2d:
                r1 = 0
            L2e:
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: p9.d.b.h(bb.g1):java.lang.Boolean");
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements t0 {
        c() {
        }

        @Override // bb.t0
        public List<a1> B() {
            return d.this.X0();
        }

        @Override // bb.t0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public z0 o() {
            return d.this;
        }

        public String toString() {
            return "[typealias " + o().c().k() + ']';
        }

        @Override // bb.t0
        public k9.h w() {
            return ra.a.g(o());
        }

        @Override // bb.t0
        public Collection<bb.b0> x() {
            Collection<bb.b0> x10 = o().L().W0().x();
            y8.k.d(x10, "declarationDescriptor.underlyingType.constructor.supertypes");
            return x10;
        }

        @Override // bb.t0
        public t0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "kotlinTypeRefiner");
            return this;
        }

        @Override // bb.t0
        public boolean z() {
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, v0 v0Var, n9.u uVar) {
        super(mVar, gVar, eVar, v0Var);
        y8.k.e(mVar, "containingDeclaration");
        y8.k.e(gVar, "annotations");
        y8.k.e(eVar, "name");
        y8.k.e(v0Var, "sourceElement");
        y8.k.e(uVar, "visibilityImpl");
        this.f13175j = uVar;
        this.f13177l = new c();
    }

    @Override // n9.i
    public List<a1> B() {
        List list = this.f13176k;
        if (list != null) {
            return list;
        }
        y8.k.o("declaredTypeParametersImpl");
        throw null;
    }

    @Override // n9.z
    public boolean H0() {
        return false;
    }

    @Override // n9.z
    public boolean I() {
        return false;
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        y8.k.e(oVar, "visitor");
        return oVar.i(this, d10);
    }

    protected abstract ab.n M();

    /* JADX INFO: Access modifiers changed from: protected */
    public final bb.i0 U0() {
        n9.e n10 = n();
        ua.h E0 = n10 == null ? null : n10.E0();
        if (E0 == null) {
            E0 = h.b.f14541b;
        }
        bb.i0 u10 = c1.u(this, E0, new a());
        y8.k.d(u10, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        return u10;
    }

    @Override // p9.k, p9.j, n9.m
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public z0 a() {
        return (z0) super.a();
    }

    public final Collection<h0> W0() {
        List d10;
        n9.e n10 = n();
        if (n10 == null) {
            d10 = m8.q.d();
            return d10;
        }
        Collection<n9.d> q10 = n10.q();
        y8.k.d(q10, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (n9.d dVar : q10) {
            i0.a aVar = i0.L;
            ab.n M = M();
            y8.k.d(dVar, "it");
            h0 b10 = aVar.b(M, this, dVar);
            if (b10 != null) {
                arrayList.add(b10);
            }
        }
        return arrayList;
    }

    protected abstract List<a1> X0();

    public final void Y0(List<? extends a1> list) {
        y8.k.e(list, "declaredTypeParameters");
        this.f13176k = list;
    }

    @Override // n9.q, n9.z
    public n9.u h() {
        return this.f13175j;
    }

    @Override // n9.z
    public boolean l0() {
        return false;
    }

    @Override // n9.i
    public boolean m0() {
        return c1.c(L(), new b());
    }

    @Override // n9.h
    public t0 o() {
        return this.f13177l;
    }

    @Override // p9.j
    public String toString() {
        return y8.k.j("typealias ", c().k());
    }
}
