package P2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: P2.h0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0155h0 extends AbstractC0159j0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f1664f = AtomicIntegerFieldUpdater.newUpdater(C0155h0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0153g0 f1665e;

    public C0155h0(InterfaceC0153g0 interfaceC0153g0) {
        this.f1665e = interfaceC0153g0;
    }

    @Override // P2.InterfaceC0153g0
    public final void a(Throwable th) {
        if (f1664f.compareAndSet(this, 0, 1)) {
            this.f1665e.a(th);
        }
    }
}
