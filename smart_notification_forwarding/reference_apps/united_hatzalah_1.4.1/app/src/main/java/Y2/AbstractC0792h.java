package y2;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import w2.InterfaceC0763d;

/* renamed from: y2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0792h extends AbstractC0791g implements kotlin.jvm.internal.g {

    /* renamed from: a, reason: collision with root package name */
    public final int f6764a;

    public AbstractC0792h(InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f6764a = 2;
    }

    @Override // kotlin.jvm.internal.g
    public final int getArity() {
        return this.f6764a;
    }

    @Override // y2.AbstractC0785a
    public final String toString() {
        if (getCompletion() == null) {
            s.f5313a.getClass();
            String a2 = t.a(this);
            j.d(a2, "renderLambdaToString(...)");
            return a2;
        }
        return super.toString();
    }
}
