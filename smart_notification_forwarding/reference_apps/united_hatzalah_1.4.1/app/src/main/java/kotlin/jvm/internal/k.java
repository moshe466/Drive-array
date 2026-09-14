package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class k implements g, Serializable {
    private final int arity;

    public k(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        s.f5313a.getClass();
        String a2 = t.a(this);
        j.d(a2, "renderLambdaToString(...)");
        return a2;
    }
}
