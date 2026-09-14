package P2;

import java.util.concurrent.locks.LockSupport;
import w2.InterfaceC0768i;

/* renamed from: P2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0154h extends AbstractC0140a {

    /* renamed from: d, reason: collision with root package name */
    public final Thread f1662d;

    /* renamed from: e, reason: collision with root package name */
    public final Z f1663e;

    public C0154h(InterfaceC0768i interfaceC0768i, Thread thread, Z z3) {
        super(interfaceC0768i, true);
        this.f1662d = thread;
        this.f1663e = z3;
    }

    @Override // P2.w0
    public final void h(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f1662d;
        if (!kotlin.jvm.internal.j.a(currentThread, thread)) {
            LockSupport.unpark(thread);
        }
    }
}
