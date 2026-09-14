package da;

import bb.b0;
import n9.a1;

/* loaded from: classes.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f8843a;

    /* renamed from: b, reason: collision with root package name */
    private final v9.s f8844b;

    /* renamed from: c, reason: collision with root package name */
    private final a1 f8845c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f8846d;

    public o(b0 b0Var, v9.s sVar, a1 a1Var, boolean z10) {
        y8.k.e(b0Var, "type");
        this.f8843a = b0Var;
        this.f8844b = sVar;
        this.f8845c = a1Var;
        this.f8846d = z10;
    }

    public final b0 a() {
        return this.f8843a;
    }

    public final v9.s b() {
        return this.f8844b;
    }

    public final a1 c() {
        return this.f8845c;
    }

    public final boolean d() {
        return this.f8846d;
    }

    public final b0 e() {
        return this.f8843a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return y8.k.a(this.f8843a, oVar.f8843a) && y8.k.a(this.f8844b, oVar.f8844b) && y8.k.a(this.f8845c, oVar.f8845c) && this.f8846d == oVar.f8846d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f8843a.hashCode() * 31;
        v9.s sVar = this.f8844b;
        int hashCode2 = (hashCode + (sVar == null ? 0 : sVar.hashCode())) * 31;
        a1 a1Var = this.f8845c;
        int hashCode3 = (hashCode2 + (a1Var != null ? a1Var.hashCode() : 0)) * 31;
        boolean z10 = this.f8846d;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode3 + i10;
    }

    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.f8843a + ", defaultQualifiers=" + this.f8844b + ", typeParameterForArgument=" + this.f8845c + ", isFromStarProjection=" + this.f8846d + ')';
    }
}
