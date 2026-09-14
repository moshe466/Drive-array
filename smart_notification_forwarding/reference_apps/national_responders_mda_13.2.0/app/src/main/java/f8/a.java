package f8;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public enum a implements c8.a {
    DISPOSED;

    public static boolean dispose(AtomicReference<c8.a> atomicReference) {
        c8.a andSet;
        c8.a aVar = atomicReference.get();
        a aVar2 = DISPOSED;
        if (aVar == aVar2 || (andSet = atomicReference.getAndSet(aVar2)) == aVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(c8.a aVar) {
        return aVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<c8.a> atomicReference, c8.a aVar) {
        c8.a aVar2;
        do {
            aVar2 = atomicReference.get();
            if (aVar2 == DISPOSED) {
                if (aVar == null) {
                    return false;
                }
                aVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(aVar2, aVar));
        return true;
    }

    public static void reportDisposableSet() {
        j8.a.c(new IllegalStateException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<c8.a> atomicReference, c8.a aVar) {
        c8.a aVar2;
        do {
            aVar2 = atomicReference.get();
            if (aVar2 == DISPOSED) {
                if (aVar == null) {
                    return false;
                }
                aVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(aVar2, aVar));
        if (aVar2 == null) {
            return true;
        }
        aVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<c8.a> atomicReference, c8.a aVar) {
        g8.b.a(aVar, "d is null");
        if (atomicReference.compareAndSet(null, aVar)) {
            return true;
        }
        aVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean validate(c8.a aVar, c8.a aVar2) {
        if (aVar2 == null) {
            j8.a.c(new NullPointerException("next is null"));
            return false;
        }
        if (aVar == null) {
            return true;
        }
        aVar2.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // c8.a
    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
