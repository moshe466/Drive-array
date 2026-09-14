package U2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2363a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new m(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2363a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int a2 = mVar.a(runnable);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                if (a2 == 2) {
                    return false;
                }
            } else {
                m c4 = mVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c4) && atomicReferenceFieldUpdater.get(this) == mVar) {
                }
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2363a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar.b()) {
                return;
            }
            m c4 = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c4) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }

    public final int c() {
        m mVar = (m) f2363a.get(this);
        mVar.getClass();
        long j2 = m.f2366f.get(mVar);
        return (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j2))) & 1073741823;
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2363a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            Object d2 = mVar.d();
            if (d2 != m.f2367g) {
                return d2;
            }
            m c4 = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c4) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }
}
