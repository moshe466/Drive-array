package ea;

import bb.b0;
import ea.w;
import java.util.Collection;

/* loaded from: classes.dex */
public final class x implements w<j> {

    /* renamed from: a, reason: collision with root package name */
    public static final x f9332a = new x();

    private x() {
    }

    @Override // ea.w
    public b0 a(b0 b0Var) {
        return w.a.b(this, b0Var);
    }

    @Override // ea.w
    public boolean b() {
        return w.a.c(this);
    }

    @Override // ea.w
    public String c(n9.e eVar) {
        return w.a.a(this, eVar);
    }

    @Override // ea.w
    public String d(n9.e eVar) {
        y8.k.e(eVar, "classDescriptor");
        return null;
    }

    @Override // ea.w
    public void e(b0 b0Var, n9.e eVar) {
        y8.k.e(b0Var, "kotlinType");
        y8.k.e(eVar, "descriptor");
    }

    @Override // ea.w
    public b0 g(Collection<? extends b0> collection) {
        String Q;
        y8.k.e(collection, "types");
        Q = m8.y.Q(collection, null, null, null, 0, null, null, 63, null);
        throw new AssertionError(y8.k.j("There should be no intersection type in existing descriptors, but found: ", Q));
    }

    @Override // ea.w
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public j f(n9.e eVar) {
        y8.k.e(eVar, "classDescriptor");
        return null;
    }
}
