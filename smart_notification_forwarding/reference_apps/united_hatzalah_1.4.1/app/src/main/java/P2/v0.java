package P2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0684i;

/* loaded from: classes.dex */
public final /* synthetic */ class v0 extends kotlin.jvm.internal.i implements F2.q {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f1708a = new kotlin.jvm.internal.i(3, w0.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // F2.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object x3;
        C0684i c0684i;
        w0 w0Var = (w0) obj;
        X2.c cVar = (X2.c) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w0.f1709a;
        do {
            x3 = w0Var.x();
            boolean z3 = x3 instanceof InterfaceC0147d0;
            c0684i = C0684i.f6340a;
            if (!z3) {
                cVar.f2624b = c0684i;
                return c0684i;
            }
        } while (w0Var.L(x3) < 0);
        cVar.f2623a = G.o(w0Var, false, new q0(w0Var, cVar, 1), 3);
        return c0684i;
    }
}
