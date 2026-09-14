package P2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class m0 extends U2.j implements InterfaceC0153g0, Q, InterfaceC0147d0 {

    /* renamed from: d, reason: collision with root package name */
    public w0 f1675d;

    @Override // P2.InterfaceC0147d0
    public final y0 c() {
        return null;
    }

    @Override // P2.Q
    public final void dispose() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        w0 i = i();
        while (true) {
            Object x3 = i.x();
            if (x3 instanceof m0) {
                if (x3 == this) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = w0.f1709a;
                    T t3 = G.f1612j;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(i, x3, t3)) {
                        if (atomicReferenceFieldUpdater2.get(i) != x3) {
                            break;
                        }
                    }
                    return;
                }
                return;
            }
            if (!(x3 instanceof InterfaceC0147d0) || ((InterfaceC0147d0) x3).c() == null) {
                return;
            }
            while (true) {
                Object f4 = f();
                if (f4 instanceof U2.p) {
                    U2.j jVar = ((U2.p) f4).f2373a;
                    return;
                }
                if (f4 == this) {
                    return;
                }
                kotlin.jvm.internal.j.c(f4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                U2.j jVar2 = (U2.j) f4;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = U2.j.f2362c;
                U2.p pVar = (U2.p) atomicReferenceFieldUpdater3.get(jVar2);
                if (pVar == null) {
                    pVar = new U2.p(jVar2);
                    atomicReferenceFieldUpdater3.set(jVar2, pVar);
                }
                do {
                    atomicReferenceFieldUpdater = U2.j.f2360a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, f4, pVar)) {
                        jVar2.d();
                        return;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == f4);
            }
        }
    }

    public InterfaceC0157i0 getParent() {
        return i();
    }

    public final w0 i() {
        w0 w0Var = this.f1675d;
        if (w0Var != null) {
            return w0Var;
        }
        kotlin.jvm.internal.j.i("job");
        throw null;
    }

    @Override // P2.InterfaceC0147d0
    public final boolean isActive() {
        return true;
    }

    @Override // U2.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + G.l(this) + "[job@" + G.l(i()) + ']';
    }
}
