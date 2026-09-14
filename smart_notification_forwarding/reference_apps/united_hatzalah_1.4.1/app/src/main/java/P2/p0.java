package P2;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class p0 implements InterfaceC0147d0 {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f1683b = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_isCompleting$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1684c = AtomicReferenceFieldUpdater.newUpdater(p0.class, Object.class, "_rootCause$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1685d = AtomicReferenceFieldUpdater.newUpdater(p0.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final y0 f1686a;

    public p0(y0 y0Var, Throwable th) {
        this.f1686a = y0Var;
        this._rootCause$volatile = th;
    }

    public final void a(Throwable th) {
        Throwable b4 = b();
        if (b4 == null) {
            f1684c.set(this, th);
            return;
        }
        if (th != b4) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1685d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(obj);
                arrayList.add(th);
                atomicReferenceFieldUpdater.set(this, arrayList);
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
    }

    public final Throwable b() {
        return (Throwable) f1684c.get(this);
    }

    @Override // P2.InterfaceC0147d0
    public final y0 c() {
        return this.f1686a;
    }

    public final boolean d() {
        if (b() != null) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (f1683b.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final ArrayList f(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1685d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            throw new IllegalStateException(("State is " + obj).toString());
        }
        Throwable b4 = b();
        if (b4 != null) {
            arrayList.add(0, b4);
        }
        if (th != null && !th.equals(b4)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, G.f1611h);
        return arrayList;
    }

    @Override // P2.InterfaceC0147d0
    public final boolean isActive() {
        if (b() == null) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "Finishing[cancelling=" + d() + ", completing=" + e() + ", rootCause=" + b() + ", exceptions=" + f1685d.get(this) + ", list=" + this.f1686a + ']';
    }
}
