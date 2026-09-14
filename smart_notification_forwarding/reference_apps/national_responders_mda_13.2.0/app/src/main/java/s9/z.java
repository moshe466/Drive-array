package s9;

import ca.b0;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import s9.w;

/* loaded from: classes.dex */
public final class z extends w implements b0 {

    /* renamed from: b, reason: collision with root package name */
    private final WildcardType f14188b;

    /* renamed from: c, reason: collision with root package name */
    private final Collection<ca.a> f14189c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f14190d;

    public z(WildcardType wildcardType) {
        List d10;
        y8.k.e(wildcardType, "reflectType");
        this.f14188b = wildcardType;
        d10 = m8.q.d();
        this.f14189c = d10;
    }

    @Override // ca.b0
    public boolean K() {
        y8.k.d(Z().getUpperBounds(), "reflectType.upperBounds");
        return !y8.k.a(m8.g.q(r0), Object.class);
    }

    @Override // ca.b0
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public w o() {
        Type[] upperBounds = Z().getUpperBounds();
        Type[] lowerBounds = Z().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(y8.k.j("Wildcard types with many bounds are not yet supported: ", Z()));
        }
        if (lowerBounds.length == 1) {
            w.a aVar = w.f14182a;
            y8.k.d(lowerBounds, "lowerBounds");
            Object D = m8.g.D(lowerBounds);
            y8.k.d(D, "lowerBounds.single()");
            return aVar.a((Type) D);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        y8.k.d(upperBounds, "upperBounds");
        Type type = (Type) m8.g.D(upperBounds);
        if (y8.k.a(type, Object.class)) {
            return null;
        }
        w.a aVar2 = w.f14182a;
        y8.k.d(type, "ub");
        return aVar2.a(type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s9.w
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public WildcardType Z() {
        return this.f14188b;
    }

    @Override // ca.d
    public Collection<ca.a> u() {
        return this.f14189c;
    }

    @Override // ca.d
    public boolean v() {
        return this.f14190d;
    }
}
