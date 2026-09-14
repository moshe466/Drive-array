package fb;

import y8.k;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f9682a;

    /* renamed from: b, reason: collision with root package name */
    private final T f9683b;

    public a(T t10, T t11) {
        this.f9682a = t10;
        this.f9683b = t11;
    }

    public final T a() {
        return this.f9682a;
    }

    public final T b() {
        return this.f9683b;
    }

    public final T c() {
        return this.f9682a;
    }

    public final T d() {
        return this.f9683b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f9682a, aVar.f9682a) && k.a(this.f9683b, aVar.f9683b);
    }

    public int hashCode() {
        T t10 = this.f9682a;
        int hashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f9683b;
        return hashCode + (t11 != null ? t11.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f9682a + ", upper=" + this.f9683b + ')';
    }
}
