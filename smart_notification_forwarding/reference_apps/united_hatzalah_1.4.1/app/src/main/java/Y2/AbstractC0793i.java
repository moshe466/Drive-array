package y2;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import w2.InterfaceC0763d;

/* renamed from: y2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0793i extends AbstractC0787c implements kotlin.jvm.internal.g {
    private final int arity;

    public AbstractC0793i(int i, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    @Override // y2.AbstractC0785a
    public String toString() {
        if (getCompletion() == null) {
            s.f5313a.getClass();
            String a2 = t.a(this);
            j.d(a2, "renderLambdaToString(...)");
            return a2;
        }
        return super.toString();
    }
}
