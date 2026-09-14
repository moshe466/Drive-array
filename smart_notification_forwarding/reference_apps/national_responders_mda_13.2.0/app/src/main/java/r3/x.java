package r3;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x<T> implements r4.b<Set<T>> {

    /* renamed from: b, reason: collision with root package name */
    private volatile Set<T> f13778b = null;

    /* renamed from: a, reason: collision with root package name */
    private volatile Set<r4.b<T>> f13777a = Collections.newSetFromMap(new ConcurrentHashMap());

    x(Collection<r4.b<T>> collection) {
        this.f13777a.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x<?> b(Collection<r4.b<?>> collection) {
        return new x<>((Set) collection);
    }

    private synchronized void d() {
        Iterator<r4.b<T>> it = this.f13777a.iterator();
        while (it.hasNext()) {
            this.f13778b.add(it.next().get());
        }
        this.f13777a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(r4.b<T> bVar) {
        Set set;
        if (this.f13778b == null) {
            set = this.f13777a;
        } else {
            set = this.f13778b;
            bVar = (r4.b<T>) bVar.get();
        }
        set.add(bVar);
    }

    @Override // r4.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        if (this.f13778b == null) {
            synchronized (this) {
                if (this.f13778b == null) {
                    this.f13778b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f13778b);
    }
}
