package P2;

import a.AbstractC0228a;
import s2.C0684i;

/* loaded from: classes.dex */
public final class S extends m0 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1625e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f1626f;

    public /* synthetic */ S(Object obj, int i) {
        this.f1625e = i;
        this.f1626f = obj;
    }

    @Override // P2.InterfaceC0153g0
    public final void a(Throwable th) {
        switch (this.f1625e) {
            case 0:
                ((Q) this.f1626f).dispose();
                return;
            case 1:
                ((InterfaceC0153g0) this.f1626f).a(th);
                return;
            case 2:
                n0 n0Var = (n0) this.f1626f;
                Object x3 = i().x();
                if (x3 instanceof C0171v) {
                    n0Var.resumeWith(AbstractC0228a.g(((C0171v) x3).f1707a));
                    return;
                } else {
                    n0Var.resumeWith(G.x(x3));
                    return;
                }
            default:
                ((C0163m) this.f1626f).resumeWith(C0684i.f6340a);
                return;
        }
    }
}
