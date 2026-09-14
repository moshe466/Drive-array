package kotlin.jvm.internal;

/* loaded from: classes.dex */
public final class l implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5309a;

    public l(Class jClass) {
        j.e(jClass, "jClass");
        this.f5309a = jClass;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f5309a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            if (j.a(this.f5309a, ((l) obj).f5309a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f5309a.hashCode();
    }

    public final String toString() {
        return this.f5309a.toString() + " (Kotlin reflection is not available)";
    }
}
