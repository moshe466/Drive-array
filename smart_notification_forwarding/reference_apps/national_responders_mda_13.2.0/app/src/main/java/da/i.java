package da;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final h f8771a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f8772b;

    public i(h hVar, boolean z10) {
        y8.k.e(hVar, "qualifier");
        this.f8771a = hVar;
        this.f8772b = z10;
    }

    public /* synthetic */ i(h hVar, boolean z10, int i10, y8.g gVar) {
        this(hVar, (i10 & 2) != 0 ? false : z10);
    }

    public static /* synthetic */ i b(i iVar, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar = iVar.f8771a;
        }
        if ((i10 & 2) != 0) {
            z10 = iVar.f8772b;
        }
        return iVar.a(hVar, z10);
    }

    public final i a(h hVar, boolean z10) {
        y8.k.e(hVar, "qualifier");
        return new i(hVar, z10);
    }

    public final h c() {
        return this.f8771a;
    }

    public final boolean d() {
        return this.f8772b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f8771a == iVar.f8771a && this.f8772b == iVar.f8772b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f8771a.hashCode() * 31;
        boolean z10 = this.f8772b;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f8771a + ", isForWarningOnly=" + this.f8772b + ')';
    }
}
