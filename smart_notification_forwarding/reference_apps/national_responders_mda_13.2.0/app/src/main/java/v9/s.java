package v9;

import java.util.Collection;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final da.i f14802a;

    /* renamed from: b, reason: collision with root package name */
    private final Collection<a> f14803b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f14804c;

    /* JADX WARN: Multi-variable type inference failed */
    public s(da.i iVar, Collection<? extends a> collection, boolean z10) {
        y8.k.e(iVar, "nullabilityQualifier");
        y8.k.e(collection, "qualifierApplicabilityTypes");
        this.f14802a = iVar;
        this.f14803b = collection;
        this.f14804c = z10;
    }

    public /* synthetic */ s(da.i iVar, Collection collection, boolean z10, int i10, y8.g gVar) {
        this(iVar, collection, (i10 & 4) != 0 ? iVar.c() == da.h.NOT_NULL : z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ s b(s sVar, da.i iVar, Collection collection, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = sVar.f14802a;
        }
        if ((i10 & 2) != 0) {
            collection = sVar.f14803b;
        }
        if ((i10 & 4) != 0) {
            z10 = sVar.f14804c;
        }
        return sVar.a(iVar, collection, z10);
    }

    public final s a(da.i iVar, Collection<? extends a> collection, boolean z10) {
        y8.k.e(iVar, "nullabilityQualifier");
        y8.k.e(collection, "qualifierApplicabilityTypes");
        return new s(iVar, collection, z10);
    }

    public final boolean c() {
        return this.f14804c;
    }

    public final boolean d() {
        return this.f14802a.c() == da.h.NOT_NULL && this.f14804c;
    }

    public final da.i e() {
        return this.f14802a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return y8.k.a(this.f14802a, sVar.f14802a) && y8.k.a(this.f14803b, sVar.f14803b) && this.f14804c == sVar.f14804c;
    }

    public final Collection<a> f() {
        return this.f14803b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f14802a.hashCode() * 31) + this.f14803b.hashCode()) * 31;
        boolean z10 = this.f14804c;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f14802a + ", qualifierApplicabilityTypes=" + this.f14803b + ", affectsTypeParameterBasedTypes=" + this.f14804c + ')';
    }
}
