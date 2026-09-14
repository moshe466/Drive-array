package M2;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f1407a;

    public a(d dVar) {
        this.f1407a = new AtomicReference(dVar);
    }

    @Override // M2.d
    public final Iterator iterator() {
        d dVar = (d) this.f1407a.getAndSet(null);
        if (dVar != null) {
            return dVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
