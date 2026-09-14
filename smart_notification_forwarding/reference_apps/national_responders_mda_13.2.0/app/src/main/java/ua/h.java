package ua;

import java.util.Collection;
import java.util.Set;
import m8.r0;
import n9.p0;
import n9.u0;

/* loaded from: classes.dex */
public interface h extends k {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14537a = a.f14538a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f14538a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final x8.l<la.e, Boolean> f14539b = C0299a.f14540f;

        /* renamed from: ua.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0299a extends y8.l implements x8.l<la.e, Boolean> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0299a f14540f = new C0299a();

            C0299a() {
                super(1);
            }

            public final boolean a(la.e eVar) {
                y8.k.e(eVar, "it");
                return true;
            }

            @Override // x8.l
            public /* bridge */ /* synthetic */ Boolean h(la.e eVar) {
                return Boolean.valueOf(a(eVar));
            }
        }

        private a() {
        }

        public final x8.l<la.e, Boolean> a() {
            return f14539b;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i {

        /* renamed from: b, reason: collision with root package name */
        public static final b f14541b = new b();

        private b() {
        }

        @Override // ua.i, ua.h
        public Set<la.e> c() {
            Set<la.e> b10;
            b10 = r0.b();
            return b10;
        }

        @Override // ua.i, ua.h
        public Set<la.e> d() {
            Set<la.e> b10;
            b10 = r0.b();
            return b10;
        }

        @Override // ua.i, ua.h
        public Set<la.e> f() {
            Set<la.e> b10;
            b10 = r0.b();
            return b10;
        }
    }

    Collection<? extends p0> a(la.e eVar, u9.b bVar);

    Collection<? extends u0> b(la.e eVar, u9.b bVar);

    Set<la.e> c();

    Set<la.e> d();

    Set<la.e> f();
}
