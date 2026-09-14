package h;

import F0.RunnableC0064o;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class E implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4728a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f4729b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final F f4730c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f4731d;

    public E(F f4) {
        this.f4730c = f4;
    }

    public final void a() {
        synchronized (this.f4728a) {
            try {
                Runnable runnable = (Runnable) this.f4729b.poll();
                this.f4731d = runnable;
                if (runnable != null) {
                    this.f4730c.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f4728a) {
            try {
                this.f4729b.add(new RunnableC0064o(10, this, runnable));
                if (this.f4731d == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
