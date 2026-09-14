package m8;

/* loaded from: classes.dex */
public final class d0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f12035a;

    /* renamed from: b, reason: collision with root package name */
    private final T f12036b;

    public d0(int i10, T t10) {
        this.f12035a = i10;
        this.f12036b = t10;
    }

    public final int a() {
        return this.f12035a;
    }

    public final T b() {
        return this.f12036b;
    }

    public final int c() {
        return this.f12035a;
    }

    public final T d() {
        return this.f12036b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f12035a == d0Var.f12035a && y8.k.a(this.f12036b, d0Var.f12036b);
    }

    public int hashCode() {
        int i10 = this.f12035a * 31;
        T t10 = this.f12036b;
        return i10 + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f12035a + ", value=" + this.f12036b + ')';
    }
}
