package y8;

/* loaded from: classes.dex */
public final class p implements d {

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f15949f;

    public p(Class<?> cls, String str) {
        k.e(cls, "jClass");
        k.e(str, "moduleName");
        this.f15949f = cls;
    }

    @Override // y8.d
    public Class<?> b() {
        return this.f15949f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && k.a(b(), ((p) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
