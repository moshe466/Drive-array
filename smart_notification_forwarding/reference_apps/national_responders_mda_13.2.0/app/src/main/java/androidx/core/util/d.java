package androidx.core.util;

/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f2495a;

    /* renamed from: b, reason: collision with root package name */
    public final S f2496b;

    public d(F f10, S s10) {
        this.f2495a = f10;
        this.f2496b = s10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f2495a, this.f2495a) && c.a(dVar.f2496b, this.f2496b);
    }

    public int hashCode() {
        F f10 = this.f2495a;
        int hashCode = f10 == null ? 0 : f10.hashCode();
        S s10 = this.f2496b;
        return hashCode ^ (s10 != null ? s10.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f2495a + " " + this.f2496b + "}";
    }
}
