package bb;

import java.util.List;

/* loaded from: classes.dex */
public abstract class i1 extends b0 {
    public i1() {
        super(null);
    }

    @Override // bb.b0
    public ua.h A() {
        return a1().A();
    }

    @Override // bb.b0
    public List<v0> V0() {
        return a1().V0();
    }

    @Override // bb.b0
    public t0 W0() {
        return a1().W0();
    }

    @Override // bb.b0
    public boolean X0() {
        return a1().X0();
    }

    @Override // bb.b0
    public final g1 Z0() {
        b0 a12 = a1();
        while (a12 instanceof i1) {
            a12 = ((i1) a12).a1();
        }
        return (g1) a12;
    }

    protected abstract b0 a1();

    public boolean b1() {
        return true;
    }

    public String toString() {
        return b1() ? a1().toString() : "<Not computed yet>";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return a1().u();
    }
}
