package P2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0684i;

/* loaded from: classes.dex */
public final /* synthetic */ class t0 extends kotlin.jvm.internal.i implements F2.q {

    /* renamed from: a, reason: collision with root package name */
    public static final t0 f1699a = new kotlin.jvm.internal.i(3, w0.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // F2.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        w0 w0Var = (w0) obj;
        X2.c cVar = (X2.c) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w0.f1709a;
        while (true) {
            Object x3 = w0Var.x();
            if (!(x3 instanceof InterfaceC0147d0)) {
                if (!(x3 instanceof C0171v)) {
                    x3 = G.x(x3);
                }
                cVar.f2624b = x3;
            } else if (w0Var.L(x3) >= 0) {
                cVar.f2623a = G.o(w0Var, false, new q0(w0Var, cVar, 0), 3);
                break;
            }
        }
        return C0684i.f6340a;
    }
}
