package s9;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class v extends w implements ca.v {

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f14179b;

    /* renamed from: c, reason: collision with root package name */
    private final Collection<ca.a> f14180c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f14181d;

    public v(Class<?> cls) {
        List d10;
        y8.k.e(cls, "reflectType");
        this.f14179b = cls;
        d10 = m8.q.d();
        this.f14180c = d10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s9.w
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public Class<?> Z() {
        return this.f14179b;
    }

    @Override // ca.v
    public k9.i b() {
        if (y8.k.a(Z(), Void.TYPE)) {
            return null;
        }
        return sa.d.get(Z().getName()).getPrimitiveType();
    }

    @Override // ca.d
    public Collection<ca.a> u() {
        return this.f14180c;
    }

    @Override // ca.d
    public boolean v() {
        return this.f14181d;
    }
}
