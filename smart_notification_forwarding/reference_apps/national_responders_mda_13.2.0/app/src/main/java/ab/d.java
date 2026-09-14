package ab;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class d implements k {

    /* renamed from: b, reason: collision with root package name */
    private final Lock f356b;

    public d(Lock lock) {
        y8.k.e(lock, "lock");
        this.f356b = lock;
    }

    public /* synthetic */ d(Lock lock, int i10, y8.g gVar) {
        this((i10 & 1) != 0 ? new ReentrantLock() : lock);
    }

    @Override // ab.k
    public void a() {
        this.f356b.unlock();
    }

    @Override // ab.k
    public void b() {
        this.f356b.lock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Lock c() {
        return this.f356b;
    }
}
