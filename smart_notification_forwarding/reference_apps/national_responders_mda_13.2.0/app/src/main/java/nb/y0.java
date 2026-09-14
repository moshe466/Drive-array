package nb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
final class y0 extends c1 {

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f12437k = AtomicIntegerFieldUpdater.newUpdater(y0.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: j, reason: collision with root package name */
    private final x8.l<Throwable, l8.w> f12438j;

    /* JADX WARN: Multi-variable type inference failed */
    public y0(x8.l<? super Throwable, l8.w> lVar) {
        this.f12438j = lVar;
    }

    @Override // x8.l
    public /* bridge */ /* synthetic */ l8.w h(Throwable th) {
        w(th);
        return l8.w.f11824a;
    }

    @Override // nb.p
    public void w(Throwable th) {
        if (f12437k.compareAndSet(this, 0, 1)) {
            this.f12438j.h(th);
        }
    }
}
