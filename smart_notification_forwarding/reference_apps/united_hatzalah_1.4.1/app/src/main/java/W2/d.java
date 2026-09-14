package W2;

import P2.A;
import P2.AbstractC0141a0;
import U2.u;
import java.util.concurrent.Executor;
import w2.C0769j;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class d extends AbstractC0141a0 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static final d f2531c = new A();

    /* renamed from: d, reason: collision with root package name */
    public static final A f2532d;

    /* JADX WARN: Type inference failed for: r0v0, types: [P2.A, W2.d] */
    static {
        A a2 = m.f2548c;
        int i = u.f2378a;
        if (64 >= i) {
            i = 64;
        }
        int j2 = U2.a.j("kotlinx.coroutines.io.parallelism", i, 12);
        a2.getClass();
        if (j2 >= 1) {
            if (j2 < l.f2543d) {
                if (j2 >= 1) {
                    a2 = new U2.h(a2, j2);
                } else {
                    throw new IllegalArgumentException(e0.a.c(j2, "Expected positive parallelism level, but got ").toString());
                }
            }
            f2532d = a2;
            return;
        }
        throw new IllegalArgumentException(e0.a.c(j2, "Expected positive parallelism level, but got ").toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // P2.A
    public final void d(InterfaceC0768i interfaceC0768i, Runnable runnable) {
        f2532d.d(interfaceC0768i, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(C0769j.f6733a, runnable);
    }

    @Override // P2.A
    public final String toString() {
        return "Dispatchers.IO";
    }
}
