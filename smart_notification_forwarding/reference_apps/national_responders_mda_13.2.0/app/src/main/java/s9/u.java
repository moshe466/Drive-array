package s9;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class u extends n implements ca.u {

    /* renamed from: a, reason: collision with root package name */
    private final la.b f14178a;

    public u(la.b bVar) {
        y8.k.e(bVar, "fqName");
        this.f14178a = bVar;
    }

    @Override // ca.u
    public Collection<ca.g> S(x8.l<? super la.e, Boolean> lVar) {
        List d10;
        y8.k.e(lVar, "nameFilter");
        d10 = m8.q.d();
        return d10;
    }

    @Override // ca.d
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public List<ca.a> u() {
        List<ca.a> d10;
        d10 = m8.q.d();
        return d10;
    }

    @Override // ca.d
    public ca.a e(la.b bVar) {
        y8.k.e(bVar, "fqName");
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && y8.k.a(f(), ((u) obj).f());
    }

    @Override // ca.u
    public la.b f() {
        return this.f14178a;
    }

    public int hashCode() {
        return f().hashCode();
    }

    @Override // ca.u
    public Collection<ca.u> n() {
        List d10;
        d10 = m8.q.d();
        return d10;
    }

    public String toString() {
        return u.class.getName() + ": " + f();
    }

    @Override // ca.d
    public boolean v() {
        return false;
    }
}
