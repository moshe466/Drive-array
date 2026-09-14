package pa;

import bb.b0;
import n9.d0;

/* loaded from: classes.dex */
public abstract class g<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f13328a;

    public g(T t10) {
        this.f13328a = t10;
    }

    public abstract b0 a(d0 d0Var);

    public T b() {
        return this.f13328a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            T b10 = b();
            g gVar = obj instanceof g ? (g) obj : null;
            if (!y8.k.a(b10, gVar != null ? gVar.b() : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        T b10 = b();
        if (b10 == null) {
            return 0;
        }
        return b10.hashCode();
    }

    public String toString() {
        return String.valueOf(b());
    }
}
