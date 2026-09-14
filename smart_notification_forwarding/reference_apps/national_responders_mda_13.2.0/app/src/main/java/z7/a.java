package z7;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class a implements c8.a {

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f16246f = new AtomicBoolean();

    /* renamed from: z7.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0344a implements Runnable {
        RunnableC0344a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    }

    @Override // c8.a
    public final void dispose() {
        if (this.f16246f.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                f();
            } else {
                b8.a.a().b(new RunnableC0344a());
            }
        }
    }

    public final boolean e() {
        return this.f16246f.get();
    }

    protected abstract void f();
}
