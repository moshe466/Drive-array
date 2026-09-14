package s9;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import s9.w;

/* loaded from: classes.dex */
public final class l extends w implements ca.j {

    /* renamed from: b, reason: collision with root package name */
    private final Type f14171b;

    /* renamed from: c, reason: collision with root package name */
    private final ca.i f14172c;

    public l(Type type) {
        ca.i jVar;
        y8.k.e(type, "reflectType");
        this.f14171b = type;
        Type Z = Z();
        if (Z instanceof Class) {
            jVar = new j((Class) Z);
        } else if (Z instanceof TypeVariable) {
            jVar = new x((TypeVariable) Z);
        } else {
            if (!(Z instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + Z.getClass() + "): " + Z);
            }
            Type rawType = ((ParameterizedType) Z).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            jVar = new j((Class) rawType);
        }
        this.f14172c = jVar;
    }

    @Override // ca.j
    public List<ca.x> A() {
        int n10;
        List<Type> d10 = b.d(Z());
        w.a aVar = w.f14182a;
        n10 = m8.r.n(d10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = d10.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // ca.j
    public String D() {
        return Z().toString();
    }

    @Override // ca.j
    public boolean W() {
        Type Z = Z();
        if (!(Z instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) Z).getTypeParameters();
        y8.k.d(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }

    @Override // ca.j
    public String X() {
        throw new UnsupportedOperationException(y8.k.j("Type not found: ", Z()));
    }

    @Override // s9.w
    public Type Z() {
        return this.f14171b;
    }

    @Override // ca.j
    public ca.i a() {
        return this.f14172c;
    }

    @Override // s9.w, ca.d
    public ca.a e(la.b bVar) {
        y8.k.e(bVar, "fqName");
        return null;
    }

    @Override // ca.d
    public Collection<ca.a> u() {
        List d10;
        d10 = m8.q.d();
        return d10;
    }

    @Override // ca.d
    public boolean v() {
        return false;
    }
}
