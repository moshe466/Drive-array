package U2;

import P2.A0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public abstract class s extends d implements A0 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2375d = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f2376c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public s(long j2, s sVar, int i) {
        super(sVar);
        this.f2376c = j2;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // U2.d
    public final boolean d() {
        if (f2375d.get(this) == g() && c() != null) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (f2375d.addAndGet(this, -65536) == g() && c() != null) {
            return true;
        }
        return false;
    }

    public abstract int g();

    public abstract void h(int i, InterfaceC0768i interfaceC0768i);

    public final void i() {
        if (f2375d.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f2375d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == g() && c() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
