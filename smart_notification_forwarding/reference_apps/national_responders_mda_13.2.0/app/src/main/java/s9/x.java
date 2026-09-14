package s9;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import s9.f;

/* loaded from: classes.dex */
public final class x extends n implements f, ca.y {

    /* renamed from: a, reason: collision with root package name */
    private final TypeVariable<?> f14183a;

    public x(TypeVariable<?> typeVariable) {
        y8.k.e(typeVariable, "typeVariable");
        this.f14183a = typeVariable;
    }

    @Override // s9.f
    public AnnotatedElement V() {
        TypeVariable<?> typeVariable = this.f14183a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // ca.d
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public c e(la.b bVar) {
        return f.a.a(this, bVar);
    }

    @Override // ca.d
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public List<c> u() {
        return f.a.b(this);
    }

    @Override // ca.y
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public List<l> getUpperBounds() {
        List<l> d10;
        Type[] bounds = this.f14183a.getBounds();
        y8.k.d(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new l(type));
        }
        l lVar = (l) m8.o.f0(arrayList);
        if (!y8.k.a(lVar == null ? null : lVar.Z(), Object.class)) {
            return arrayList;
        }
        d10 = m8.q.d();
        return d10;
    }

    @Override // ca.t
    public la.e c() {
        la.e r10 = la.e.r(this.f14183a.getName());
        y8.k.d(r10, "identifier(typeVariable.name)");
        return r10;
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && y8.k.a(this.f14183a, ((x) obj).f14183a);
    }

    public int hashCode() {
        return this.f14183a.hashCode();
    }

    public String toString() {
        return x.class.getName() + ": " + this.f14183a;
    }

    @Override // ca.d
    public boolean v() {
        return f.a.c(this);
    }
}
