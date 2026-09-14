package y7;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f15926f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f15927g;

        a(e eVar, Runnable runnable, b bVar) {
            this.f15926f = runnable;
            this.f15927g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f15926f.run();
            } finally {
                this.f15927g.dispose();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b implements c8.a {
        public abstract c8.a a(Runnable runnable, long j10, TimeUnit timeUnit);
    }

    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
    }

    public abstract b a();

    public c8.a b(Runnable runnable) {
        return c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public c8.a c(Runnable runnable, long j10, TimeUnit timeUnit) {
        b a10 = a();
        a10.a(new a(this, j8.a.d(runnable), a10), j10, timeUnit);
        return a10;
    }
}
