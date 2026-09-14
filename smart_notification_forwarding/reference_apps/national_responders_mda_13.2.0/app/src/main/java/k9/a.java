package k9;

import java.util.ServiceLoader;
import n9.d0;
import n9.h0;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0228a f11205a = C0228a.f11206a;

    /* renamed from: k9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0228a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0228a f11206a = new C0228a();

        /* renamed from: b, reason: collision with root package name */
        private static final l8.h<a> f11207b;

        /* renamed from: k9.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0229a extends y8.l implements x8.a<a> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0229a f11208f = new C0229a();

            C0229a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a b() {
                ServiceLoader load = ServiceLoader.load(a.class, a.class.getClassLoader());
                y8.k.d(load, "implementations");
                a aVar = (a) m8.o.I(load);
                if (aVar != null) {
                    return aVar;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        static {
            l8.h<a> a10;
            a10 = l8.j.a(kotlin.b.PUBLICATION, C0229a.f11208f);
            f11207b = a10;
        }

        private C0228a() {
        }

        public final a a() {
            return f11207b.getValue();
        }
    }

    h0 a(ab.n nVar, d0 d0Var, Iterable<? extends o9.b> iterable, o9.c cVar, o9.a aVar, boolean z10);
}
