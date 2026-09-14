package na;

import bb.t0;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import n9.a1;
import n9.b;
import n9.g0;
import n9.v0;
import n9.z;
import na.j;
import x8.p;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f12330a = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements p<n9.m, n9.m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f12331f = new a();

        a() {
            super(2);
        }

        public final boolean a(n9.m mVar, n9.m mVar2) {
            return false;
        }

        @Override // x8.p
        public /* bridge */ /* synthetic */ Boolean g(n9.m mVar, n9.m mVar2) {
            return Boolean.valueOf(a(mVar, mVar2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: na.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0258b implements f.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f12333b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ n9.a f12334c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n9.a f12335d;

        /* renamed from: na.b$b$a */
        /* loaded from: classes.dex */
        static final class a extends y8.l implements p<n9.m, n9.m, Boolean> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n9.a f12336f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ n9.a f12337g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(n9.a aVar, n9.a aVar2) {
                super(2);
                this.f12336f = aVar;
                this.f12337g = aVar2;
            }

            public final boolean a(n9.m mVar, n9.m mVar2) {
                return y8.k.a(mVar, this.f12336f) && y8.k.a(mVar2, this.f12337g);
            }

            @Override // x8.p
            public /* bridge */ /* synthetic */ Boolean g(n9.m mVar, n9.m mVar2) {
                return Boolean.valueOf(a(mVar, mVar2));
            }
        }

        C0258b(boolean z10, n9.a aVar, n9.a aVar2) {
            this.f12333b = z10;
            this.f12334c = aVar;
            this.f12335d = aVar2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.f.a
        public final boolean a(t0 t0Var, t0 t0Var2) {
            y8.k.e(t0Var, "c1");
            y8.k.e(t0Var2, "c2");
            if (y8.k.a(t0Var, t0Var2)) {
                return true;
            }
            n9.h o10 = t0Var.o();
            n9.h o11 = t0Var2.o();
            if ((o10 instanceof a1) && (o11 instanceof a1)) {
                return b.this.g((a1) o10, (a1) o11, this.f12333b, new a(this.f12334c, this.f12335d));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements p<n9.m, n9.m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f12338f = new c();

        c() {
            super(2);
        }

        public final boolean a(n9.m mVar, n9.m mVar2) {
            return false;
        }

        @Override // x8.p
        public /* bridge */ /* synthetic */ Boolean g(n9.m mVar, n9.m mVar2) {
            return Boolean.valueOf(a(mVar, mVar2));
        }
    }

    private b() {
    }

    public static /* synthetic */ boolean c(b bVar, n9.a aVar, n9.a aVar2, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, int i10, Object obj) {
        return bVar.b(aVar, aVar2, z10, (i10 & 8) != 0 ? true : z11, (i10 & 16) != 0 ? false : z12, gVar);
    }

    private final boolean d(n9.e eVar, n9.e eVar2) {
        return y8.k.a(eVar.o(), eVar2.o());
    }

    public static /* synthetic */ boolean f(b bVar, n9.m mVar, n9.m mVar2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        return bVar.e(mVar, mVar2, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(a1 a1Var, a1 a1Var2, boolean z10, p<? super n9.m, ? super n9.m, Boolean> pVar) {
        if (y8.k.a(a1Var, a1Var2)) {
            return true;
        }
        return !y8.k.a(a1Var.d(), a1Var2.d()) && i(a1Var, a1Var2, pVar, z10) && a1Var.j() == a1Var2.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean h(b bVar, a1 a1Var, a1 a1Var2, boolean z10, p pVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            pVar = c.f12338f;
        }
        return bVar.g(a1Var, a1Var2, z10, pVar);
    }

    private final boolean i(n9.m mVar, n9.m mVar2, p<? super n9.m, ? super n9.m, Boolean> pVar, boolean z10) {
        n9.m d10 = mVar.d();
        n9.m d11 = mVar2.d();
        return ((d10 instanceof n9.b) || (d11 instanceof n9.b)) ? pVar.g(d10, d11).booleanValue() : f(this, d10, d11, z10, false, 8, null);
    }

    private final v0 j(n9.a aVar) {
        while (aVar instanceof n9.b) {
            n9.b bVar = (n9.b) aVar;
            if (bVar.r() != b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends n9.b> g10 = bVar.g();
            y8.k.d(g10, "overriddenDescriptors");
            aVar = (n9.b) m8.o.e0(g10);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.k();
    }

    public final boolean b(n9.a aVar, n9.a aVar2, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(aVar, "a");
        y8.k.e(aVar2, "b");
        y8.k.e(gVar, "kotlinTypeRefiner");
        if (y8.k.a(aVar, aVar2)) {
            return true;
        }
        if (!y8.k.a(aVar.c(), aVar2.c())) {
            return false;
        }
        if (z11 && (aVar instanceof z) && (aVar2 instanceof z) && ((z) aVar).l0() != ((z) aVar2).l0()) {
            return false;
        }
        if ((y8.k.a(aVar.d(), aVar2.d()) && (!z10 || !y8.k.a(j(aVar), j(aVar2)))) || d.E(aVar) || d.E(aVar2) || !i(aVar, aVar2, a.f12331f, z10)) {
            return false;
        }
        j k10 = j.k(gVar, new C0258b(z10, aVar, aVar2));
        y8.k.d(k10, "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }");
        j.i.a c10 = k10.H(aVar, aVar2, null, !z12).c();
        j.i.a aVar3 = j.i.a.OVERRIDABLE;
        return c10 == aVar3 && k10.H(aVar2, aVar, null, z12 ^ true).c() == aVar3;
    }

    public final boolean e(n9.m mVar, n9.m mVar2, boolean z10, boolean z11) {
        if ((mVar instanceof n9.e) && (mVar2 instanceof n9.e)) {
            return d((n9.e) mVar, (n9.e) mVar2);
        }
        if ((mVar instanceof a1) && (mVar2 instanceof a1)) {
            return h(this, (a1) mVar, (a1) mVar2, z10, null, 8, null);
        }
        if ((mVar instanceof n9.a) && (mVar2 instanceof n9.a)) {
            return c(this, (n9.a) mVar, (n9.a) mVar2, z10, z11, false, g.a.f11566a, 16, null);
        }
        boolean z12 = mVar instanceof g0;
        Object obj = mVar;
        Object obj2 = mVar2;
        if (z12) {
            boolean z13 = mVar2 instanceof g0;
            obj = mVar;
            obj2 = mVar2;
            if (z13) {
                obj = ((g0) mVar).f();
                obj2 = ((g0) mVar2).f();
            }
        }
        return y8.k.a(obj, obj2);
    }
}
