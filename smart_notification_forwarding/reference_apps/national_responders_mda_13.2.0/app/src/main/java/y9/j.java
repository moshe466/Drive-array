package y9;

/* loaded from: classes.dex */
public final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    public sa.b f16001a;

    @Override // y9.i
    public n9.e a(ca.g gVar) {
        y8.k.e(gVar, "javaClass");
        return b().b(gVar);
    }

    public final sa.b b() {
        sa.b bVar = this.f16001a;
        if (bVar != null) {
            return bVar;
        }
        y8.k.o("resolver");
        throw null;
    }

    public final void c(sa.b bVar) {
        y8.k.e(bVar, "<set-?>");
        this.f16001a = bVar;
    }
}
