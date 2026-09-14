package nb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class j0<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f12397i = AtomicIntegerFieldUpdater.newUpdater(j0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    private final boolean n0() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f12397i.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // kotlinx.coroutines.internal.z, nb.a
    protected void k0(Object obj) {
        p8.d a10;
        if (n0()) {
            return;
        }
        a10 = q8.c.a(this.f11665h);
        kotlinx.coroutines.internal.g.c(a10, r.a(obj, this.f11665h), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.z, nb.g1
    public void m(Object obj) {
        k0(obj);
    }
}
