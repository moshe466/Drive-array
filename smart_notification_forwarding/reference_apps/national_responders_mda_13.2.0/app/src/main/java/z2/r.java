package z2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class r<T> implements s<T> {

    /* renamed from: a, reason: collision with root package name */
    private final CountDownLatch f16120a = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(q qVar) {
    }

    @Override // z2.e
    public final void a() {
        this.f16120a.countDown();
    }

    @Override // z2.h
    public final void b(T t10) {
        this.f16120a.countDown();
    }

    public final void c() {
        this.f16120a.await();
    }

    @Override // z2.g
    public final void d(Exception exc) {
        this.f16120a.countDown();
    }

    public final boolean e(long j10, TimeUnit timeUnit) {
        return this.f16120a.await(j10, timeUnit);
    }
}
