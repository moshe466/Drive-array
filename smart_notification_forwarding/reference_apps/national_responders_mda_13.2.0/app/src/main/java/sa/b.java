package sa;

import ca.c0;
import m8.o;
import n9.e;
import ua.h;
import w9.g;
import y8.k;
import y9.f;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final f f14191a;

    /* renamed from: b, reason: collision with root package name */
    private final g f14192b;

    public b(f fVar, g gVar) {
        k.e(fVar, "packageFragmentProvider");
        k.e(gVar, "javaResolverCache");
        this.f14191a = fVar;
        this.f14192b = gVar;
    }

    public final f a() {
        return this.f14191a;
    }

    public final e b(ca.g gVar) {
        k.e(gVar, "javaClass");
        la.b f10 = gVar.f();
        if (f10 != null && gVar.J() == c0.SOURCE) {
            return this.f14192b.d(f10);
        }
        ca.g r10 = gVar.r();
        if (r10 != null) {
            e b10 = b(r10);
            h u02 = b10 == null ? null : b10.u0();
            n9.h g10 = u02 == null ? null : u02.g(gVar.c(), u9.d.FROM_JAVA_LOADER);
            if (g10 instanceof e) {
                return (e) g10;
            }
            return null;
        }
        if (f10 == null) {
            return null;
        }
        f fVar = this.f14191a;
        la.b e10 = f10.e();
        k.d(e10, "fqName.parent()");
        z9.h hVar = (z9.h) o.J(fVar.a(e10));
        if (hVar == null) {
            return null;
        }
        return hVar.W0(gVar);
    }
}
