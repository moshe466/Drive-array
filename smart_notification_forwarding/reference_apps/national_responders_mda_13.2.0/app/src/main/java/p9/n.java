package p9;

import bb.t0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import n9.a1;
import n9.p0;
import n9.u0;
import n9.v0;
import ua.h;

/* loaded from: classes.dex */
public class n extends g {

    /* renamed from: n, reason: collision with root package name */
    private final t0 f13231n;

    /* renamed from: o, reason: collision with root package name */
    private final ua.h f13232o;

    /* renamed from: p, reason: collision with root package name */
    private final ab.i<Set<la.e>> f13233p;

    /* renamed from: q, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f13234q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ua.i {

        /* renamed from: b, reason: collision with root package name */
        private final ab.g<la.e, Collection<? extends u0>> f13235b;

        /* renamed from: c, reason: collision with root package name */
        private final ab.g<la.e, Collection<? extends p0>> f13236c;

        /* renamed from: d, reason: collision with root package name */
        private final ab.i<Collection<n9.m>> f13237d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f13238e;

        /* renamed from: p9.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0275a implements x8.l<la.e, Collection<? extends u0>> {
            C0275a(n nVar) {
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends u0> h(la.e eVar) {
                return a.this.m(eVar);
            }
        }

        /* loaded from: classes.dex */
        class b implements x8.l<la.e, Collection<? extends p0>> {
            b(n nVar) {
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends p0> h(la.e eVar) {
                return a.this.n(eVar);
            }
        }

        /* loaded from: classes.dex */
        class c implements x8.a<Collection<n9.m>> {
            c(n nVar) {
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<n9.m> b() {
                return a.this.l();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d extends na.h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Set f13242a;

            d(a aVar, Set set) {
                this.f13242a = set;
            }

            private static /* synthetic */ void f(int i10) {
                Object[] objArr = new Object[3];
                if (i10 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i10 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i10 == 1 || i10 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // na.i
            public void a(n9.b bVar) {
                if (bVar == null) {
                    f(0);
                }
                na.j.N(bVar, null);
                this.f13242a.add(bVar);
            }

            @Override // na.h
            protected void e(n9.b bVar, n9.b bVar2) {
                if (bVar == null) {
                    f(1);
                }
                if (bVar2 == null) {
                    f(2);
                }
            }
        }

        public a(n nVar, ab.n nVar2) {
            if (nVar2 == null) {
                h(0);
            }
            this.f13238e = nVar;
            this.f13235b = nVar2.i(new C0275a(nVar));
            this.f13236c = nVar2.i(new b(nVar));
            this.f13237d = nVar2.a(new c(nVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void h(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p9.n.a.h(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<n9.m> l() {
            HashSet hashSet = new HashSet();
            for (la.e eVar : (Set) this.f13238e.f13233p.b()) {
                u9.d dVar = u9.d.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(b(eVar, dVar));
                hashSet.addAll(a(eVar, dVar));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<? extends u0> m(la.e eVar) {
            if (eVar == null) {
                h(8);
            }
            return p(eVar, o().b(eVar, u9.d.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<? extends p0> n(la.e eVar) {
            if (eVar == null) {
                h(4);
            }
            return p(eVar, o().a(eVar, u9.d.FOR_NON_TRACKED_SCOPE));
        }

        private ua.h o() {
            ua.h A = this.f13238e.o().x().iterator().next().A();
            if (A == null) {
                h(9);
            }
            return A;
        }

        private <D extends n9.b> Collection<? extends D> p(la.e eVar, Collection<? extends D> collection) {
            if (eVar == null) {
                h(10);
            }
            if (collection == null) {
                h(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            na.j.f12341d.y(eVar, collection, Collections.emptySet(), this.f13238e, new d(this, linkedHashSet));
            return linkedHashSet;
        }

        @Override // ua.i, ua.h
        public Collection<? extends p0> a(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(1);
            }
            if (bVar == null) {
                h(2);
            }
            Collection<? extends p0> h10 = this.f13236c.h(eVar);
            if (h10 == null) {
                h(3);
            }
            return h10;
        }

        @Override // ua.i, ua.h
        public Collection<? extends u0> b(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(5);
            }
            if (bVar == null) {
                h(6);
            }
            Collection<? extends u0> h10 = this.f13235b.h(eVar);
            if (h10 == null) {
                h(7);
            }
            return h10;
        }

        @Override // ua.i, ua.h
        public Set<la.e> c() {
            Set<la.e> set = (Set) this.f13238e.f13233p.b();
            if (set == null) {
                h(17);
            }
            return set;
        }

        @Override // ua.i, ua.h
        public Set<la.e> d() {
            Set<la.e> set = (Set) this.f13238e.f13233p.b();
            if (set == null) {
                h(19);
            }
            return set;
        }

        @Override // ua.i, ua.k
        public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
            if (dVar == null) {
                h(13);
            }
            if (lVar == null) {
                h(14);
            }
            Collection<n9.m> b10 = this.f13237d.b();
            if (b10 == null) {
                h(15);
            }
            return b10;
        }

        @Override // ua.i, ua.h
        public Set<la.e> f() {
            Set<la.e> emptySet = Collections.emptySet();
            if (emptySet == null) {
                h(18);
            }
            return emptySet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private n(ab.n nVar, n9.e eVar, bb.b0 b0Var, la.e eVar2, ab.i<Set<la.e>> iVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        super(nVar, eVar, eVar2, v0Var, false);
        if (nVar == null) {
            I0(6);
        }
        if (eVar == null) {
            I0(7);
        }
        if (b0Var == null) {
            I0(8);
        }
        if (eVar2 == null) {
            I0(9);
        }
        if (iVar == null) {
            I0(10);
        }
        if (gVar == null) {
            I0(11);
        }
        if (v0Var == null) {
            I0(12);
        }
        this.f13234q = gVar;
        this.f13231n = new bb.i(this, Collections.emptyList(), Collections.singleton(b0Var), nVar);
        this.f13232o = new a(this, nVar);
        this.f13233p = iVar;
    }

    private static /* synthetic */ void I0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static n W0(ab.n nVar, n9.e eVar, la.e eVar2, ab.i<Set<la.e>> iVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        if (nVar == null) {
            I0(0);
        }
        if (eVar == null) {
            I0(1);
        }
        if (eVar2 == null) {
            I0(2);
        }
        if (iVar == null) {
            I0(3);
        }
        if (gVar == null) {
            I0(4);
        }
        if (v0Var == null) {
            I0(5);
        }
        return new n(nVar, eVar, eVar.s(), eVar2, iVar, gVar, v0Var);
    }

    @Override // n9.e
    public n9.e A0() {
        return null;
    }

    @Override // n9.e, n9.i
    public List<a1> B() {
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            I0(22);
        }
        return emptyList;
    }

    @Override // n9.z
    public boolean H0() {
        return false;
    }

    @Override // n9.e
    public boolean N() {
        return false;
    }

    @Override // n9.e
    public boolean R0() {
        return false;
    }

    @Override // n9.e
    public boolean W() {
        return false;
    }

    @Override // n9.e
    public Collection<n9.e> g0() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            I0(23);
        }
        return emptyList;
    }

    @Override // n9.e, n9.q, n9.z
    public n9.u h() {
        n9.u uVar = n9.t.f12303e;
        if (uVar == null) {
            I0(20);
        }
        return uVar;
    }

    @Override // n9.e
    public boolean j0() {
        return false;
    }

    @Override // n9.z
    public boolean l0() {
        return false;
    }

    @Override // n9.i
    public boolean m0() {
        return false;
    }

    @Override // n9.h
    public t0 o() {
        t0 t0Var = this.f13231n;
        if (t0Var == null) {
            I0(17);
        }
        return t0Var;
    }

    @Override // n9.e, n9.z
    public n9.a0 p() {
        n9.a0 a0Var = n9.a0.FINAL;
        if (a0Var == null) {
            I0(19);
        }
        return a0Var;
    }

    @Override // n9.e
    public Collection<n9.d> q() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            I0(16);
        }
        return emptyList;
    }

    @Override // n9.e
    public n9.f r() {
        n9.f fVar = n9.f.ENUM_ENTRY;
        if (fVar == null) {
            I0(18);
        }
        return fVar;
    }

    public String toString() {
        return "enum entry " + c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar = this.f13234q;
        if (gVar == null) {
            I0(21);
        }
        return gVar;
    }

    @Override // p9.t
    public ua.h v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            I0(13);
        }
        ua.h hVar = this.f13232o;
        if (hVar == null) {
            I0(14);
        }
        return hVar;
    }

    @Override // n9.e
    public n9.d w0() {
        return null;
    }

    @Override // n9.e
    public boolean x() {
        return false;
    }

    @Override // n9.e
    public ua.h x0() {
        h.b bVar = h.b.f14541b;
        if (bVar == null) {
            I0(15);
        }
        return bVar;
    }
}
