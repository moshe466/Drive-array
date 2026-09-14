package U;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f2315a;

    public f(String name) {
        kotlin.jvm.internal.j.e(name, "name");
        this.f2315a = name;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return kotlin.jvm.internal.j.a(this.f2315a, ((f) obj).f2315a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2315a.hashCode();
    }

    public final String toString() {
        return this.f2315a;
    }
}
