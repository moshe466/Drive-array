package pa;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final la.a f13326a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13327b;

    public f(la.a aVar, int i10) {
        y8.k.e(aVar, "classId");
        this.f13326a = aVar;
        this.f13327b = i10;
    }

    public final la.a a() {
        return this.f13326a;
    }

    public final int b() {
        return this.f13327b;
    }

    public final int c() {
        return this.f13327b;
    }

    public final la.a d() {
        return this.f13326a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return y8.k.a(this.f13326a, fVar.f13326a) && this.f13327b == fVar.f13327b;
    }

    public int hashCode() {
        return (this.f13326a.hashCode() * 31) + this.f13327b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int c10 = c();
        for (int i10 = 0; i10 < c10; i10++) {
            sb2.append("kotlin/Array<");
        }
        sb2.append(d());
        int c11 = c();
        for (int i11 = 0; i11 < c11; i11++) {
            sb2.append(">");
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
