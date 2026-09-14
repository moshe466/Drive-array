package b8;

import android.os.Handler;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import y7.e;

/* loaded from: classes.dex */
final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f4145a;

    /* loaded from: classes.dex */
    private static final class a extends e.b {

        /* renamed from: f, reason: collision with root package name */
        private final Handler f4146f;

        /* renamed from: g, reason: collision with root package name */
        private volatile boolean f4147g;

        a(Handler handler) {
            this.f4146f = handler;
        }

        @Override // y7.e.b
        public c8.a a(Runnable runnable, long j10, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            if (j10 < 0) {
                throw new IllegalArgumentException("delay < 0: " + j10);
            }
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f4147g) {
                return c8.b.a();
            }
            RunnableC0070b runnableC0070b = new RunnableC0070b(this.f4146f, j8.a.d(runnable));
            Message obtain = Message.obtain(this.f4146f, runnableC0070b);
            obtain.obj = this;
            this.f4146f.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
            if (!this.f4147g) {
                return runnableC0070b;
            }
            this.f4146f.removeCallbacks(runnableC0070b);
            return c8.b.a();
        }

        @Override // c8.a
        public void dispose() {
            this.f4147g = true;
            this.f4146f.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: b8.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class RunnableC0070b implements Runnable, c8.a {

        /* renamed from: f, reason: collision with root package name */
        private final Handler f4148f;

        /* renamed from: g, reason: collision with root package name */
        private final Runnable f4149g;

        RunnableC0070b(Handler handler, Runnable runnable) {
            this.f4148f = handler;
            this.f4149g = runnable;
        }

        @Override // c8.a
        public void dispose() {
            this.f4148f.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4149g.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                j8.a.c(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler) {
        this.f4145a = handler;
    }

    @Override // y7.e
    public e.b a() {
        return new a(this.f4145a);
    }

    @Override // y7.e
    public c8.a c(Runnable runnable, long j10, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        if (j10 < 0) {
            throw new IllegalArgumentException("delay < 0: " + j10);
        }
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0070b runnableC0070b = new RunnableC0070b(this.f4145a, j8.a.d(runnable));
        this.f4145a.postDelayed(runnableC0070b, timeUnit.toMillis(j10));
        return runnableC0070b;
    }
}
