package e5;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import z4.b;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    final Class<? super T> f9148a;

    /* renamed from: b, reason: collision with root package name */
    final Type f9149b;

    /* renamed from: c, reason: collision with root package name */
    final int f9150c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        Type d10 = d(getClass());
        this.f9149b = d10;
        this.f9148a = (Class<? super T>) b.k(d10);
        this.f9150c = d10.hashCode();
    }

    a(Type type) {
        Type b10 = b.b((Type) z4.a.b(type));
        this.f9149b = b10;
        this.f9148a = (Class<? super T>) b.k(b10);
        this.f9150c = b10.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    static Type d(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> c() {
        return this.f9148a;
    }

    public final Type e() {
        return this.f9149b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f9149b, ((a) obj).f9149b);
    }

    public final int hashCode() {
        return this.f9150c;
    }

    public final String toString() {
        return b.u(this.f9149b);
    }
}
