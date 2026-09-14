package s9;

import ca.x;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* loaded from: classes.dex */
public abstract class w implements ca.x {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14182a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final w a(Type type) {
            y8.k.e(type, "type");
            boolean z10 = type instanceof Class;
            if (z10) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new v(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z10 && ((Class) type).isArray())) ? new i(type) : type instanceof WildcardType ? new z((WildcardType) type) : new l(type);
        }
    }

    protected abstract Type Z();

    @Override // ca.d
    public ca.a e(la.b bVar) {
        return x.a.a(this, bVar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && y8.k.a(Z(), ((w) obj).Z());
    }

    public int hashCode() {
        return Z().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + Z();
    }
}
