package s9;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import s9.w;

/* loaded from: classes.dex */
public final class i extends w implements ca.f {

    /* renamed from: b, reason: collision with root package name */
    private final Type f14157b;

    /* renamed from: c, reason: collision with root package name */
    private final w f14158c;

    /* renamed from: d, reason: collision with root package name */
    private final Collection<ca.a> f14159d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f14160e;

    public i(Type type) {
        w.a aVar;
        Type componentType;
        String str;
        List d10;
        y8.k.e(type, "reflectType");
        this.f14157b = type;
        Type Z = Z();
        if (!(Z instanceof GenericArrayType)) {
            if (Z instanceof Class) {
                Class cls = (Class) Z;
                if (cls.isArray()) {
                    aVar = w.f14182a;
                    componentType = cls.getComponentType();
                    str = "getComponentType()";
                }
            }
            throw new IllegalArgumentException("Not an array type (" + Z().getClass() + "): " + Z());
        }
        aVar = w.f14182a;
        componentType = ((GenericArrayType) Z).getGenericComponentType();
        str = "genericComponentType";
        y8.k.d(componentType, str);
        this.f14158c = aVar.a(componentType);
        d10 = m8.q.d();
        this.f14159d = d10;
    }

    @Override // s9.w
    protected Type Z() {
        return this.f14157b;
    }

    @Override // ca.f
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public w p() {
        return this.f14158c;
    }

    @Override // ca.d
    public Collection<ca.a> u() {
        return this.f14159d;
    }

    @Override // ca.d
    public boolean v() {
        return this.f14160e;
    }
}
