package P2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class M extends U2.r {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f1620e = AtomicIntegerFieldUpdater.newUpdater(M.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // U2.r, P2.w0
    public final void h(Object obj) {
        i(obj);
    }

    @Override // U2.r, P2.w0
    public final void i(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f1620e;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1) {
                    U2.a.g(G.t(obj), m3.b.z(this.f2374d));
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
