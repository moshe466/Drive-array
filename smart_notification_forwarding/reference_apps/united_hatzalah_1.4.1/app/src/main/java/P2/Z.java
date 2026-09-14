package P2;

import t2.C0704f;

/* loaded from: classes.dex */
public abstract class Z extends A {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f1637f = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f1638c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1639d;

    /* renamed from: e, reason: collision with root package name */
    public C0704f f1640e;

    public final void f(boolean z3) {
        long j2;
        long j3 = this.f1638c;
        if (z3) {
            j2 = 4294967296L;
        } else {
            j2 = 1;
        }
        long j4 = j3 - j2;
        this.f1638c = j4;
        if (j4 <= 0 && this.f1639d) {
            shutdown();
        }
    }

    public abstract Thread g();

    public final void h(boolean z3) {
        long j2;
        long j3 = this.f1638c;
        if (z3) {
            j2 = 4294967296L;
        } else {
            j2 = 1;
        }
        this.f1638c = j2 + j3;
        if (!z3) {
            this.f1639d = true;
        }
    }

    public abstract long i();

    public final boolean j() {
        Object removeFirst;
        C0704f c0704f = this.f1640e;
        if (c0704f == null) {
            return false;
        }
        if (c0704f.isEmpty()) {
            removeFirst = null;
        } else {
            removeFirst = c0704f.removeFirst();
        }
        N n4 = (N) removeFirst;
        if (n4 == null) {
            return false;
        }
        n4.run();
        return true;
    }

    public void k(long j2, W w3) {
        H.f1614m.o(j2, w3);
    }

    public abstract void shutdown();
}
