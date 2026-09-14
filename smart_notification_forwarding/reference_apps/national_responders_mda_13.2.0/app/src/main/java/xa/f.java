package xa;

import n9.v0;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final ia.c f15571a;

    /* renamed from: b, reason: collision with root package name */
    private final ga.c f15572b;

    /* renamed from: c, reason: collision with root package name */
    private final ia.a f15573c;

    /* renamed from: d, reason: collision with root package name */
    private final v0 f15574d;

    public f(ia.c cVar, ga.c cVar2, ia.a aVar, v0 v0Var) {
        y8.k.e(cVar, "nameResolver");
        y8.k.e(cVar2, "classProto");
        y8.k.e(aVar, "metadataVersion");
        y8.k.e(v0Var, "sourceElement");
        this.f15571a = cVar;
        this.f15572b = cVar2;
        this.f15573c = aVar;
        this.f15574d = v0Var;
    }

    public final ia.c a() {
        return this.f15571a;
    }

    public final ga.c b() {
        return this.f15572b;
    }

    public final ia.a c() {
        return this.f15573c;
    }

    public final v0 d() {
        return this.f15574d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return y8.k.a(this.f15571a, fVar.f15571a) && y8.k.a(this.f15572b, fVar.f15572b) && y8.k.a(this.f15573c, fVar.f15573c) && y8.k.a(this.f15574d, fVar.f15574d);
    }

    public int hashCode() {
        return (((((this.f15571a.hashCode() * 31) + this.f15572b.hashCode()) * 31) + this.f15573c.hashCode()) * 31) + this.f15574d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f15571a + ", classProto=" + this.f15572b + ", metadataVersion=" + this.f15573c + ", sourceElement=" + this.f15574d + ')';
    }
}
