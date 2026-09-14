package aa;

import n9.a1;
import w9.k;
import y8.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final k f333a;

    /* renamed from: b, reason: collision with root package name */
    private final b f334b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f335c;

    /* renamed from: d, reason: collision with root package name */
    private final a1 f336d;

    public a(k kVar, b bVar, boolean z10, a1 a1Var) {
        y8.k.e(kVar, "howThisTypeIsUsed");
        y8.k.e(bVar, "flexibility");
        this.f333a = kVar;
        this.f334b = bVar;
        this.f335c = z10;
        this.f336d = a1Var;
    }

    public /* synthetic */ a(k kVar, b bVar, boolean z10, a1 a1Var, int i10, g gVar) {
        this(kVar, (i10 & 2) != 0 ? b.INFLEXIBLE : bVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? null : a1Var);
    }

    public static /* synthetic */ a b(a aVar, k kVar, b bVar, boolean z10, a1 a1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = aVar.f333a;
        }
        if ((i10 & 2) != 0) {
            bVar = aVar.f334b;
        }
        if ((i10 & 4) != 0) {
            z10 = aVar.f335c;
        }
        if ((i10 & 8) != 0) {
            a1Var = aVar.f336d;
        }
        return aVar.a(kVar, bVar, z10, a1Var);
    }

    public final a a(k kVar, b bVar, boolean z10, a1 a1Var) {
        y8.k.e(kVar, "howThisTypeIsUsed");
        y8.k.e(bVar, "flexibility");
        return new a(kVar, bVar, z10, a1Var);
    }

    public final b c() {
        return this.f334b;
    }

    public final k d() {
        return this.f333a;
    }

    public final a1 e() {
        return this.f336d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f333a == aVar.f333a && this.f334b == aVar.f334b && this.f335c == aVar.f335c && y8.k.a(this.f336d, aVar.f336d);
    }

    public final boolean f() {
        return this.f335c;
    }

    public final a g(b bVar) {
        y8.k.e(bVar, "flexibility");
        return b(this, null, bVar, false, null, 13, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f333a.hashCode() * 31) + this.f334b.hashCode()) * 31;
        boolean z10 = this.f335c;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        a1 a1Var = this.f336d;
        return i11 + (a1Var == null ? 0 : a1Var.hashCode());
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f333a + ", flexibility=" + this.f334b + ", isForAnnotationParameter=" + this.f335c + ", upperBoundOfTypeParameter=" + this.f336d + ')';
    }
}
