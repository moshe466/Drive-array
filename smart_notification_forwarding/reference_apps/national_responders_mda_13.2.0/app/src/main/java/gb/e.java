package gb;

import bb.b0;
import gb.b;
import k9.j;
import n9.d1;
import n9.x;

/* loaded from: classes.dex */
final class e implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final e f10352a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10353b = "second parameter must be of type KProperty<*> or its supertype";

    private e() {
    }

    @Override // gb.b
    public String a() {
        return f10353b;
    }

    @Override // gb.b
    public boolean b(x xVar) {
        y8.k.e(xVar, "functionDescriptor");
        d1 d1Var = xVar.l().get(1);
        j.b bVar = k9.j.f11228d;
        y8.k.d(d1Var, "secondParameter");
        b0 a10 = bVar.a(ra.a.l(d1Var));
        if (a10 == null) {
            return false;
        }
        b0 b10 = d1Var.b();
        y8.k.d(b10, "secondParameter.type");
        return eb.a.g(a10, eb.a.j(b10));
    }

    @Override // gb.b
    public String c(x xVar) {
        return b.a.a(this, xVar);
    }
}
