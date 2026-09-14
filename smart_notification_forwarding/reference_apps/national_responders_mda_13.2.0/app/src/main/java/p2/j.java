package p2;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class j extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f13043a;

    public j(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f13043a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == j.class) {
            if (this == obj) {
                return true;
            }
            j jVar = (j) obj;
            if (this.f13043a == jVar.f13043a && get() == jVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13043a;
    }
}
