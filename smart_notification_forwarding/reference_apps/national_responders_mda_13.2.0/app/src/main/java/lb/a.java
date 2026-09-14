package lb;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a<T> implements h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<h<T>> f11863a;

    public a(h<? extends T> hVar) {
        y8.k.e(hVar, "sequence");
        this.f11863a = new AtomicReference<>(hVar);
    }

    @Override // lb.h
    public Iterator<T> iterator() {
        h<T> andSet = this.f11863a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
