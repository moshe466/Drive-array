package ab;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import l8.w;

/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f354c;

    /* renamed from: d, reason: collision with root package name */
    private final x8.l<InterruptedException, w> f355d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Runnable runnable, x8.l<? super InterruptedException, w> lVar) {
        this(new ReentrantLock(), runnable, lVar);
        y8.k.e(runnable, "checkCancelled");
        y8.k.e(lVar, "interruptedExceptionHandler");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Lock lock, Runnable runnable, x8.l<? super InterruptedException, w> lVar) {
        super(lock);
        y8.k.e(lock, "lock");
        y8.k.e(runnable, "checkCancelled");
        y8.k.e(lVar, "interruptedExceptionHandler");
        this.f354c = runnable;
        this.f355d = lVar;
    }

    @Override // ab.d, ab.k
    public void b() {
        while (!c().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f354c.run();
            } catch (InterruptedException e10) {
                this.f355d.h(e10);
                return;
            }
        }
    }
}
