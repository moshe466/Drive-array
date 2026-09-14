package ea;

import fa.a;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import m8.q0;
import m8.r0;
import n9.g0;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f9295b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Set<a.EnumC0166a> f9296c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<a.EnumC0166a> f9297d;

    /* renamed from: e, reason: collision with root package name */
    private static final ka.f f9298e;

    /* renamed from: f, reason: collision with root package name */
    private static final ka.f f9299f;

    /* renamed from: g, reason: collision with root package name */
    private static final ka.f f9300g;

    /* renamed from: a, reason: collision with root package name */
    public xa.j f9301a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final ka.f a() {
            return e.f9300g;
        }

        public final Set<a.EnumC0166a> b() {
            return e.f9296c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.a<Collection<? extends la.e>> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f9302f = new b();

        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<la.e> b() {
            List d10;
            d10 = m8.q.d();
            return d10;
        }
    }

    static {
        Set<a.EnumC0166a> a10;
        Set<a.EnumC0166a> e10;
        a10 = q0.a(a.EnumC0166a.CLASS);
        f9296c = a10;
        e10 = r0.e(a.EnumC0166a.FILE_FACADE, a.EnumC0166a.MULTIFILE_CLASS_PART);
        f9297d = e10;
        f9298e = new ka.f(1, 1, 2);
        f9299f = new ka.f(1, 1, 11);
        f9300g = new ka.f(1, 1, 13);
    }

    private final za.e e(o oVar) {
        if (!f().g().b()) {
            if (oVar.a().j()) {
                return za.e.FIR_UNSTABLE;
            }
            if (oVar.a().k()) {
                return za.e.IR_UNSTABLE;
            }
        }
        return za.e.STABLE;
    }

    private final xa.r<ka.f> g(o oVar) {
        if (h() || oVar.a().d().h()) {
            return null;
        }
        return new xa.r<>(oVar.a().d(), ka.f.f11311g, oVar.getLocation(), oVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h() {
        return f().g().e();
    }

    private final boolean i(o oVar) {
        return !f().g().c() && oVar.a().i() && y8.k.a(oVar.a().d(), f9299f);
    }

    private final boolean j(o oVar) {
        return (f().g().g() && (oVar.a().i() || y8.k.a(oVar.a().d(), f9298e))) || i(oVar);
    }

    private final String[] l(o oVar, Set<? extends a.EnumC0166a> set) {
        fa.a a10 = oVar.a();
        String[] a11 = a10.a();
        if (a11 == null) {
            a11 = a10.b();
        }
        if (a11 != null && set.contains(a10.c())) {
            return a11;
        }
        return null;
    }

    public final ua.h d(g0 g0Var, o oVar) {
        l8.n<ka.g, ga.l> nVar;
        y8.k.e(g0Var, "descriptor");
        y8.k.e(oVar, "kotlinClass");
        String[] l10 = l(oVar, f9297d);
        if (l10 == null) {
            return null;
        }
        String[] g10 = oVar.a().g();
        try {
        } catch (Throwable th) {
            if (h() || oVar.a().d().h()) {
                throw th;
            }
            nVar = null;
        }
        if (g10 == null) {
            return null;
        }
        try {
            ka.h hVar = ka.h.f11321a;
            nVar = ka.h.m(l10, g10);
            if (nVar == null) {
                return null;
            }
            ka.g a10 = nVar.a();
            ga.l b10 = nVar.b();
            return new za.i(g0Var, b10, a10, oVar.a().d(), new i(oVar, b10, a10, g(oVar), j(oVar), e(oVar)), f(), b.f9302f);
        } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
            throw new IllegalStateException(y8.k.j("Could not read data from ", oVar.getLocation()), e10);
        }
    }

    public final xa.j f() {
        xa.j jVar = this.f9301a;
        if (jVar != null) {
            return jVar;
        }
        y8.k.o("components");
        throw null;
    }

    public final xa.f k(o oVar) {
        String[] g10;
        l8.n<ka.g, ga.c> nVar;
        y8.k.e(oVar, "kotlinClass");
        String[] l10 = l(oVar, f9295b.b());
        if (l10 == null || (g10 = oVar.a().g()) == null) {
            return null;
        }
        try {
            try {
                ka.h hVar = ka.h.f11321a;
                nVar = ka.h.i(l10, g10);
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw new IllegalStateException(y8.k.j("Could not read data from ", oVar.getLocation()), e10);
            }
        } catch (Throwable th) {
            if (h() || oVar.a().d().h()) {
                throw th;
            }
            nVar = null;
        }
        if (nVar == null) {
            return null;
        }
        return new xa.f(nVar.a(), nVar.b(), oVar.a().d(), new q(oVar, g(oVar), j(oVar), e(oVar)));
    }

    public final n9.e m(o oVar) {
        y8.k.e(oVar, "kotlinClass");
        xa.f k10 = k(oVar);
        if (k10 == null) {
            return null;
        }
        return f().f().d(oVar.d(), k10);
    }

    public final void n(d dVar) {
        y8.k.e(dVar, "components");
        o(dVar.a());
    }

    public final void o(xa.j jVar) {
        y8.k.e(jVar, "<set-?>");
        this.f9301a = jVar;
    }
}
