package r3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class u implements o4.d, o4.c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<o4.b<Object>, Executor>> f13771a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Queue<o4.a<?>> f13772b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private final Executor f13773c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Executor executor) {
        this.f13773c = executor;
    }

    private synchronized Set<Map.Entry<o4.b<Object>, Executor>> e(o4.a<?> aVar) {
        ConcurrentHashMap<o4.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f13771a.get(aVar.b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    @Override // o4.d
    public <T> void a(Class<T> cls, o4.b<? super T> bVar) {
        b(cls, this.f13773c, bVar);
    }

    @Override // o4.d
    public synchronized <T> void b(Class<T> cls, Executor executor, o4.b<? super T> bVar) {
        c0.b(cls);
        c0.b(bVar);
        c0.b(executor);
        if (!this.f13771a.containsKey(cls)) {
            this.f13771a.put(cls, new ConcurrentHashMap<>());
        }
        this.f13771a.get(cls).put(bVar, executor);
    }

    @Override // o4.d
    public synchronized <T> void c(Class<T> cls, o4.b<? super T> bVar) {
        c0.b(cls);
        c0.b(bVar);
        if (this.f13771a.containsKey(cls)) {
            ConcurrentHashMap<o4.b<Object>, Executor> concurrentHashMap = this.f13771a.get(cls);
            concurrentHashMap.remove(bVar);
            if (concurrentHashMap.isEmpty()) {
                this.f13771a.remove(cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Queue<o4.a<?>> queue;
        synchronized (this) {
            queue = this.f13772b;
            if (queue != null) {
                this.f13772b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            Iterator<o4.a<?>> it = queue.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
        }
    }

    public void g(o4.a<?> aVar) {
        c0.b(aVar);
        synchronized (this) {
            Queue<o4.a<?>> queue = this.f13772b;
            if (queue != null) {
                queue.add(aVar);
                return;
            }
            for (Map.Entry<o4.b<Object>, Executor> entry : e(aVar)) {
                entry.getValue().execute(t.a(entry, aVar));
            }
        }
    }
}
