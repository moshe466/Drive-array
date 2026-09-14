package v9;

import bb.i0;
import n9.o0;
import n9.p0;
import n9.u0;

/* loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<n9.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f14756f = new a();

        a() {
            super(1);
        }

        public final boolean a(n9.b bVar) {
            y8.k.e(bVar, "it");
            return i.f14789a.b(ra.a.o(bVar));
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(n9.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.l<n9.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f14757f = new b();

        b() {
            super(1);
        }

        public final boolean a(n9.b bVar) {
            y8.k.e(bVar, "it");
            return e.f14779m.l((u0) bVar);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(n9.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<n9.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f14758f = new c();

        c() {
            super(1);
        }

        public final boolean a(n9.b bVar) {
            y8.k.e(bVar, "it");
            if (k9.h.e0(bVar)) {
                f fVar = f.f14781m;
                if (f.m(bVar) != null) {
                    return true;
                }
            }
            return false;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(n9.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    public static final boolean a(n9.b bVar) {
        y8.k.e(bVar, "<this>");
        return d(bVar) != null;
    }

    public static final String b(n9.b bVar) {
        la.e j10;
        y8.k.e(bVar, "callableMemberDescriptor");
        n9.b c10 = c(bVar);
        n9.b o10 = c10 == null ? null : ra.a.o(c10);
        if (o10 == null) {
            return null;
        }
        if (o10 instanceof p0) {
            return i.f14789a.a(o10);
        }
        if (!(o10 instanceof u0) || (j10 = e.f14779m.j((u0) o10)) == null) {
            return null;
        }
        return j10.k();
    }

    private static final n9.b c(n9.b bVar) {
        if (k9.h.e0(bVar)) {
            return d(bVar);
        }
        return null;
    }

    public static final <T extends n9.b> T d(T t10) {
        x8.l lVar;
        y8.k.e(t10, "<this>");
        if (!c0.f14765a.f().contains(t10.c()) && !g.f14784a.d().contains(ra.a.o(t10).c())) {
            return null;
        }
        if (t10 instanceof p0 ? true : t10 instanceof o0) {
            lVar = a.f14756f;
        } else {
            if (!(t10 instanceof u0)) {
                return null;
            }
            lVar = b.f14757f;
        }
        return (T) ra.a.d(t10, false, lVar, 1, null);
    }

    public static final <T extends n9.b> T e(T t10) {
        y8.k.e(t10, "<this>");
        T t11 = (T) d(t10);
        if (t11 != null) {
            return t11;
        }
        f fVar = f.f14781m;
        la.e c10 = t10.c();
        y8.k.d(c10, "name");
        if (fVar.l(c10)) {
            return (T) ra.a.d(t10, false, c.f14758f, 1, null);
        }
        return null;
    }

    public static final boolean f(n9.e eVar, n9.a aVar) {
        y8.k.e(eVar, "<this>");
        y8.k.e(aVar, "specialCallableDescriptor");
        i0 s10 = ((n9.e) aVar.d()).s();
        y8.k.d(s10, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        while (true) {
            eVar = na.d.s(eVar);
            if (eVar == null) {
                return false;
            }
            if (!(eVar instanceof x9.d)) {
                if (kotlin.reflect.jvm.internal.impl.types.checker.t.b(eVar.s(), s10) != null) {
                    return !k9.h.e0(eVar);
                }
            }
        }
    }

    public static final boolean g(n9.b bVar) {
        y8.k.e(bVar, "<this>");
        return ra.a.o(bVar).d() instanceof x9.d;
    }

    public static final boolean h(n9.b bVar) {
        y8.k.e(bVar, "<this>");
        return g(bVar) || k9.h.e0(bVar);
    }
}
