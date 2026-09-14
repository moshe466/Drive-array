package Y2;

import F0.G1;
import P2.C0163m;
import P2.G;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0684i;
import x2.EnumC0779a;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class d extends h implements a {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2711g = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public d(boolean z3) {
        super(z3 ? 1 : 0);
        G1 g12;
        if (z3) {
            g12 = null;
        } else {
            g12 = e.f2712a;
        }
        this.owner$volatile = g12;
    }

    public final boolean c() {
        if (Math.max(h.f2719f.get(this), 0) != 0) {
            return false;
        }
        return true;
    }

    public final Object d(AbstractC0787c abstractC0787c) {
        boolean e4 = e();
        C0684i c0684i = C0684i.f6340a;
        if (!e4) {
            C0163m m4 = G.m(m3.b.z(abstractC0787c));
            try {
                a(new c(this, m4));
                Object q3 = m4.q();
                EnumC0779a enumC0779a = EnumC0779a.f6740a;
                if (q3 != enumC0779a) {
                    q3 = c0684i;
                }
                if (q3 == enumC0779a) {
                    return q3;
                }
            } catch (Throwable th) {
                m4.x();
                throw th;
            }
        }
        return c0684i;
    }

    public final boolean e() {
        int i;
        char c4;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h.f2719f;
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 > 1) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > 1) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 1));
            } else {
                if (i3 <= 0) {
                    c4 = 1;
                    break;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 - 1)) {
                    f2711g.set(this, null);
                    c4 = 0;
                    break;
                }
            }
        }
        if (c4 == 0) {
            return true;
        }
        if (c4 == 1) {
            return false;
        }
        if (c4 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
    }

    public final void f(Object obj) {
        while (c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2711g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            G1 g12 = e.f2712a;
            if (obj2 != g12) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, g12)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                b();
                return;
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        return "Mutex@" + G.l(this) + "[isLocked=" + c() + ",owner=" + f2711g.get(this) + ']';
    }
}
