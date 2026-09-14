package gb;

import gb.b;
import java.util.Collection;
import java.util.List;
import n9.d1;
import n9.x;

/* loaded from: classes.dex */
final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final h f10358a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10359b = "should not have varargs or parameters with default values";

    private h() {
    }

    @Override // gb.b
    public String a() {
        return f10359b;
    }

    @Override // gb.b
    public boolean b(x xVar) {
        y8.k.e(xVar, "functionDescriptor");
        List<d1> l10 = xVar.l();
        y8.k.d(l10, "functionDescriptor.valueParameters");
        if (!(l10 instanceof Collection) || !l10.isEmpty()) {
            for (d1 d1Var : l10) {
                y8.k.d(d1Var, "it");
                if (!(!ra.a.a(d1Var) && d1Var.R() == null)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // gb.b
    public String c(x xVar) {
        return b.a.a(this, xVar);
    }
}
