package jb;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f11078a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11079b;

    public f(String str, int i10) {
        y8.k.e(str, "number");
        this.f11078a = str;
        this.f11079b = i10;
    }

    public final String a() {
        return this.f11078a;
    }

    public final int b() {
        return this.f11079b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return y8.k.a(this.f11078a, fVar.f11078a) && this.f11079b == fVar.f11079b;
    }

    public int hashCode() {
        return (this.f11078a.hashCode() * 31) + this.f11079b;
    }

    public String toString() {
        return "NumberWithRadix(number=" + this.f11078a + ", radix=" + this.f11079b + ')';
    }
}
