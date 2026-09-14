package P2;

import F0.G1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w2.InterfaceC0763d;

/* renamed from: P2.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0165o extends AbstractC0159j0 {

    /* renamed from: e, reason: collision with root package name */
    public final C0163m f1678e;

    public C0165o(C0163m c0163m) {
        this.f1678e = c0163m;
    }

    @Override // P2.InterfaceC0153g0
    public final void a(Throwable th) {
        w0 i = i();
        C0163m c0163m = this.f1678e;
        Throwable p = c0163m.p(i);
        if (c0163m.u()) {
            InterfaceC0763d interfaceC0763d = c0163m.f1673d;
            kotlin.jvm.internal.j.c(interfaceC0763d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            U2.g gVar = (U2.g) interfaceC0763d;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U2.g.f2349k;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(gVar);
                G1 g12 = U2.a.f2340d;
                if (kotlin.jvm.internal.j.a(obj, g12)) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, g12, p)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != g12) {
                            break;
                        }
                    }
                    return;
                } else {
                    if (obj instanceof Throwable) {
                        return;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
            }
        }
        c0163m.m(p);
        if (!c0163m.u()) {
            c0163m.n();
        }
    }
}
