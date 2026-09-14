package u7;

import java.lang.Enum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class b0<E extends Enum<E>, S extends Enum<S>> {

    /* renamed from: b, reason: collision with root package name */
    private a<E, S> f14409b;

    /* renamed from: c, reason: collision with root package name */
    private Lock f14410c;

    /* renamed from: a, reason: collision with root package name */
    private Object f14408a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<v<S>> f14411d = new ArrayList<>();

    /* loaded from: classes.dex */
    public interface a<E extends Enum<E>, S extends Enum<S>> {
        S a();

        void b(b0<E, S> b0Var, E e10);
    }

    public b0(a<E, S> aVar) {
        this.f14409b = aVar;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f14410c = reentrantReadWriteLock.readLock();
        reentrantReadWriteLock.writeLock();
    }

    public void a(E e10) {
        synchronized (this.f14408a) {
            this.f14409b.b(this, e10);
        }
    }

    public void b(a<E, S> aVar) {
        synchronized (this.f14408a) {
            a<E, S> aVar2 = this.f14409b;
            this.f14409b = aVar;
            try {
                this.f14410c.lock();
                Iterator<v<S>> it = this.f14411d.iterator();
                while (it.hasNext()) {
                    it.next().a(aVar2.a(), aVar.a());
                }
            } finally {
                this.f14410c.unlock();
            }
        }
    }
}
