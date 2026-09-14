package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
final class j0 extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f11634a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f11635b = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, x8.l<Throwable, Throwable>> f11636c = new WeakHashMap<>();

    private j0() {
    }

    @Override // kotlinx.coroutines.internal.e
    public x8.l<Throwable, Throwable> a(Class<? extends Throwable> cls) {
        x8.l<Throwable, Throwable> b10;
        ReentrantReadWriteLock reentrantReadWriteLock = f11635b;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            x8.l<Throwable, Throwable> lVar = f11636c.get(cls);
            if (lVar != null) {
                return lVar;
            }
            readLock = reentrantReadWriteLock.readLock();
            int i10 = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            int i11 = 0;
            while (i11 < readHoldCount) {
                i11++;
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                WeakHashMap<Class<? extends Throwable>, x8.l<Throwable, Throwable>> weakHashMap = f11636c;
                x8.l<Throwable, Throwable> lVar2 = weakHashMap.get(cls);
                if (lVar2 == null) {
                    b10 = h.b(cls);
                    weakHashMap.put(cls, b10);
                    return b10;
                }
                while (i10 < readHoldCount) {
                    i10++;
                    readLock.lock();
                }
                writeLock.unlock();
                return lVar2;
            } finally {
                while (i10 < readHoldCount) {
                    i10++;
                    readLock.lock();
                }
                writeLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }
}
