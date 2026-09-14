package r9;

import ca.u;
import java.util.Set;
import mb.r;
import v9.q;

/* loaded from: classes.dex */
public final class d implements q {

    /* renamed from: a, reason: collision with root package name */
    private final ClassLoader f13807a;

    public d(ClassLoader classLoader) {
        y8.k.e(classLoader, "classLoader");
        this.f13807a = classLoader;
    }

    @Override // v9.q
    public u a(la.b bVar) {
        y8.k.e(bVar, "fqName");
        return new s9.u(bVar);
    }

    @Override // v9.q
    public ca.g b(q.a aVar) {
        String t10;
        y8.k.e(aVar, "request");
        la.a a10 = aVar.a();
        la.b h10 = a10.h();
        y8.k.d(h10, "classId.packageFqName");
        String b10 = a10.i().b();
        y8.k.d(b10, "classId.relativeClassName.asString()");
        t10 = r.t(b10, '.', '$', false, 4, null);
        if (!h10.d()) {
            t10 = h10.b() + '.' + t10;
        }
        Class<?> a11 = e.a(this.f13807a, t10);
        if (a11 != null) {
            return new s9.j(a11);
        }
        return null;
    }

    @Override // v9.q
    public Set<String> c(la.b bVar) {
        y8.k.e(bVar, "packageFqName");
        return null;
    }
}
