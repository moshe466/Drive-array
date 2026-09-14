package r9;

import java.util.List;
import l8.w;
import m8.q;
import m9.f;
import n9.d0;
import n9.f0;
import p9.x;
import xa.k;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public static final a f13815c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final xa.j f13816a;

    /* renamed from: b, reason: collision with root package name */
    private final r9.a f13817b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final k a(ClassLoader classLoader) {
            List d10;
            List g10;
            y8.k.e(classLoader, "classLoader");
            ab.f fVar = new ab.f("RuntimeModuleData");
            m9.f fVar2 = new m9.f(fVar, f.a.FROM_DEPENDENCIES);
            la.e u10 = la.e.u("<runtime module for " + classLoader + '>');
            y8.k.d(u10, "special(\"<runtime module for $classLoader>\")");
            x xVar = new x(u10, fVar, fVar2, null, null, null, 56, null);
            fVar2.L0(xVar);
            fVar2.Q0(xVar, true);
            g gVar = new g(classLoader);
            ea.e eVar = new ea.e();
            y9.j jVar = new y9.j();
            f0 f0Var = new f0(fVar, xVar);
            y9.f c10 = l.c(classLoader, xVar, fVar, f0Var, gVar, eVar, jVar, null, 128, null);
            ea.d a10 = l.a(xVar, fVar, f0Var, c10, gVar, eVar);
            eVar.n(a10);
            w9.g gVar2 = w9.g.f15324a;
            y8.k.d(gVar2, "EMPTY");
            sa.b bVar = new sa.b(c10, gVar2);
            jVar.c(bVar);
            ClassLoader classLoader2 = w.class.getClassLoader();
            y8.k.d(classLoader2, "stdlibClassLoader");
            g gVar3 = new g(classLoader2);
            m9.g P0 = fVar2.P0();
            m9.g P02 = fVar2.P0();
            k.a aVar = k.a.f15605a;
            kotlin.reflect.jvm.internal.impl.types.checker.m a11 = kotlin.reflect.jvm.internal.impl.types.checker.l.f11584b.a();
            d10 = q.d();
            m9.h hVar = new m9.h(fVar, gVar3, xVar, f0Var, P0, P02, aVar, a11, new ta.b(fVar, d10));
            xVar.i1(xVar);
            g10 = q.g(bVar.a(), hVar);
            xVar.c1(new p9.i(g10));
            return new k(a10.a(), new r9.a(eVar, gVar), null);
        }
    }

    private k(xa.j jVar, r9.a aVar) {
        this.f13816a = jVar;
        this.f13817b = aVar;
    }

    public /* synthetic */ k(xa.j jVar, r9.a aVar, y8.g gVar) {
        this(jVar, aVar);
    }

    public final xa.j a() {
        return this.f13816a;
    }

    public final d0 b() {
        return this.f13816a.p();
    }

    public final r9.a c() {
        return this.f13817b;
    }
}
