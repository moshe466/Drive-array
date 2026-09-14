package W2;

import P2.AbstractC0141a0;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public abstract class h extends AbstractC0141a0 {

    /* renamed from: c, reason: collision with root package name */
    public c f2535c;

    @Override // P2.A
    public final void d(InterfaceC0768i interfaceC0768i, Runnable runnable) {
        c cVar = this.f2535c;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f2520k;
        cVar.b(runnable, l.f2546g);
    }
}
