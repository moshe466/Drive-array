package R2;

import F0.G1;
import P2.AbstractC0140a;
import P2.G;
import P2.w0;
import R.L;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.JobCancellationException;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class o extends AbstractC0140a implements p, g {

    /* renamed from: d, reason: collision with root package name */
    public final c f2069d;

    public o(InterfaceC0768i interfaceC0768i, c cVar) {
        super(interfaceC0768i, true);
        this.f2069d = cVar;
    }

    @Override // P2.AbstractC0140a
    public final void P(Throwable th, boolean z3) {
        if (!this.f2069d.g(th, false) && !z3) {
            G.n(th, this.f1641c);
        }
    }

    @Override // P2.AbstractC0140a
    public final void Q(Object obj) {
        this.f2069d.g(null, false);
    }

    public final void S(L l3) {
        c cVar = this.f2069d;
        cVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f2033m;
        while (!atomicReferenceFieldUpdater.compareAndSet(cVar, null, l3)) {
            if (atomicReferenceFieldUpdater.get(cVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(cVar);
                    G1 g12 = e.f2050q;
                    if (obj == g12) {
                        G1 g13 = e.f2051r;
                        while (!atomicReferenceFieldUpdater.compareAndSet(cVar, g12, g13)) {
                            if (atomicReferenceFieldUpdater.get(cVar) != g12) {
                                break;
                            }
                        }
                        l3.invoke(cVar.l());
                        return;
                    }
                    if (obj == e.f2051r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked");
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            }
        }
    }

    @Override // R2.r
    public final Object b(Object obj) {
        return this.f2069d.b(obj);
    }

    @Override // P2.w0, P2.InterfaceC0157i0
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(n(), null, this);
        }
        l(cancellationException);
    }

    @Override // R2.r
    public final Object d(Object obj, InterfaceC0763d interfaceC0763d) {
        return this.f2069d.d(obj, interfaceC0763d);
    }

    @Override // P2.w0
    public final void l(CancellationException cancellationException) {
        CancellationException N3 = w0.N(this, cancellationException);
        this.f2069d.g(N3, true);
        k(N3);
    }
}
