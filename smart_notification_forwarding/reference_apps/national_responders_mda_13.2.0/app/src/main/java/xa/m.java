package xa;

import n9.g0;
import n9.h0;
import n9.j0;

/* loaded from: classes.dex */
public final class m implements g {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f15615a;

    public m(h0 h0Var) {
        y8.k.e(h0Var, "packageFragmentProvider");
        this.f15615a = h0Var;
    }

    @Override // xa.g
    public f a(la.a aVar) {
        f a10;
        y8.k.e(aVar, "classId");
        h0 h0Var = this.f15615a;
        la.b h10 = aVar.h();
        y8.k.d(h10, "classId.packageFqName");
        for (g0 g0Var : j0.b(h0Var, h10)) {
            if ((g0Var instanceof n) && (a10 = ((n) g0Var).U0().a(aVar)) != null) {
                return a10;
            }
        }
        return null;
    }
}
