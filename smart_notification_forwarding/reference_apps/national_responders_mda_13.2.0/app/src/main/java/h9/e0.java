package h9;

/* loaded from: classes.dex */
public class e0 extends y8.x {
    private static j i(y8.c cVar) {
        e9.d k10 = cVar.k();
        return k10 instanceof j ? (j) k10 : b.f10502i;
    }

    @Override // y8.x
    public e9.e a(y8.i iVar) {
        return new k(i(iVar), iVar.c(), iVar.m(), iVar.j());
    }

    @Override // y8.x
    public e9.b b(Class cls) {
        return g.a(cls);
    }

    @Override // y8.x
    public e9.d c(Class cls, String str) {
        return new p(cls, str);
    }

    @Override // y8.x
    public e9.f d(y8.m mVar) {
        return new n(i(mVar), mVar.c(), mVar.m(), mVar.j());
    }

    @Override // y8.x
    public e9.h e(y8.q qVar) {
        return new r(i(qVar), qVar.c(), qVar.m(), qVar.j());
    }

    @Override // y8.x
    public e9.i f(y8.s sVar) {
        return new s(i(sVar), sVar.c(), sVar.m(), sVar.j());
    }

    @Override // y8.x
    public String g(y8.h hVar) {
        k a10;
        e9.e a11 = g9.b.a(hVar);
        return (a11 == null || (a10 = k0.a(a11)) == null) ? super.g(hVar) : g0.f10543b.e(a10.p());
    }

    @Override // y8.x
    public String h(y8.l lVar) {
        return g(lVar);
    }
}
