package r9;

import ea.m;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class g implements ea.m {

    /* renamed from: a, reason: collision with root package name */
    private final ClassLoader f13811a;

    /* renamed from: b, reason: collision with root package name */
    private final ya.d f13812b;

    public g(ClassLoader classLoader) {
        y8.k.e(classLoader, "classLoader");
        this.f13811a = classLoader;
        this.f13812b = new ya.d();
    }

    private final m.a d(String str) {
        f a10;
        Class<?> a11 = e.a(this.f13811a, str);
        if (a11 == null || (a10 = f.f13808c.a(a11)) == null) {
            return null;
        }
        return new m.a.b(a10, null, 2, null);
    }

    @Override // ea.m
    public m.a a(ca.g gVar) {
        y8.k.e(gVar, "javaClass");
        la.b f10 = gVar.f();
        String b10 = f10 == null ? null : f10.b();
        if (b10 == null) {
            return null;
        }
        return d(b10);
    }

    @Override // xa.s
    public InputStream b(la.b bVar) {
        y8.k.e(bVar, "packageFqName");
        if (bVar.i(k9.k.f11245k)) {
            return this.f13812b.a(ya.a.f16003m.n(bVar));
        }
        return null;
    }

    @Override // ea.m
    public m.a c(la.a aVar) {
        String b10;
        y8.k.e(aVar, "classId");
        b10 = h.b(aVar);
        return d(b10);
    }
}
