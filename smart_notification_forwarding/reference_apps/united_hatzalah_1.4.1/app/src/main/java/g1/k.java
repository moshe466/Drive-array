package g1;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f4699a;

    public k(String str) {
        this.f4699a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof k) && kotlin.jvm.internal.j.a(this.f4699a, ((k) obj).f4699a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f4699a.hashCode();
    }

    public final String toString() {
        return this.f4699a;
    }
}
