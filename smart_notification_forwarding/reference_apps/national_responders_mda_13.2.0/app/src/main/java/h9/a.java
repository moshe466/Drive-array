package h9;

import n9.p0;

/* loaded from: classes.dex */
public class a extends p9.l<f<?>, l8.w> {

    /* renamed from: a, reason: collision with root package name */
    private final j f10501a;

    public a(j jVar) {
        y8.k.e(jVar, "container");
        this.f10501a = jVar;
    }

    @Override // p9.l, n9.o
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public f<?> f(n9.x xVar, l8.w wVar) {
        y8.k.e(xVar, "descriptor");
        y8.k.e(wVar, "data");
        return new k(this.f10501a, xVar);
    }

    @Override // n9.o
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public f<?> j(p0 p0Var, l8.w wVar) {
        y8.k.e(p0Var, "descriptor");
        y8.k.e(wVar, "data");
        int i10 = (p0Var.K() != null ? 1 : 0) + (p0Var.U() != null ? 1 : 0);
        if (p0Var.P()) {
            if (i10 == 0) {
                return new l(this.f10501a, p0Var);
            }
            if (i10 == 1) {
                return new n(this.f10501a, p0Var);
            }
            if (i10 == 2) {
                return new o(this.f10501a, p0Var);
            }
        } else {
            if (i10 == 0) {
                return new r(this.f10501a, p0Var);
            }
            if (i10 == 1) {
                return new s(this.f10501a, p0Var);
            }
            if (i10 == 2) {
                return new t(this.f10501a, p0Var);
            }
        }
        throw new b0("Unsupported property: " + p0Var);
    }
}
