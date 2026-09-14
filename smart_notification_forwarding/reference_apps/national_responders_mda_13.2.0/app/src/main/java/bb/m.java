package bb;

import java.util.List;

/* loaded from: classes.dex */
public abstract class m extends i0 {
    @Override // bb.b0
    public ua.h A() {
        return f1().A();
    }

    @Override // bb.b0
    public List<v0> V0() {
        return f1().V0();
    }

    @Override // bb.b0
    public t0 W0() {
        return f1().W0();
    }

    @Override // bb.b0
    public boolean X0() {
        return f1().X0();
    }

    protected abstract i0 f1();

    @Override // bb.g1
    public i0 g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return h1((i0) gVar.g(f1()));
    }

    public abstract m h1(i0 i0Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return f1().u();
    }
}
