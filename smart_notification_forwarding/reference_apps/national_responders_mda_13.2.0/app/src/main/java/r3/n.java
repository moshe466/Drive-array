package r3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class n extends r3.a implements k4.a {

    /* renamed from: g, reason: collision with root package name */
    private static final r4.b<Set<Object>> f13749g = m.a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<d<?>, r4.b<?>> f13750a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, r4.b<?>> f13751b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, x<?>> f13752c;

    /* renamed from: d, reason: collision with root package name */
    private final List<r4.b<i>> f13753d;

    /* renamed from: e, reason: collision with root package name */
    private final u f13754e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicReference<Boolean> f13755f;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Executor f13756a;

        /* renamed from: b, reason: collision with root package name */
        private final List<r4.b<i>> f13757b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private final List<d<?>> f13758c = new ArrayList();

        b(Executor executor) {
            this.f13756a = executor;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ i e(i iVar) {
            return iVar;
        }

        public b a(d<?> dVar) {
            this.f13758c.add(dVar);
            return this;
        }

        public b b(i iVar) {
            this.f13757b.add(o.a(iVar));
            return this;
        }

        public b c(Collection<r4.b<i>> collection) {
            this.f13757b.addAll(collection);
            return this;
        }

        public n d() {
            return new n(this.f13756a, this.f13757b, this.f13758c);
        }
    }

    private n(Executor executor, Iterable<r4.b<i>> iterable, Collection<d<?>> collection) {
        this.f13750a = new HashMap();
        this.f13751b = new HashMap();
        this.f13752c = new HashMap();
        this.f13755f = new AtomicReference<>();
        u uVar = new u(executor);
        this.f13754e = uVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(d.n(uVar, u.class, o4.d.class, o4.c.class));
        arrayList.add(d.n(this, k4.a.class, new Class[0]));
        for (d<?> dVar : collection) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        this.f13753d = i(iterable);
        f(arrayList);
    }

    public static b e(Executor executor) {
        return new b(executor);
    }

    private void f(List<d<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<r4.b<i>> it = this.f13753d.iterator();
            while (it.hasNext()) {
                try {
                    i iVar = it.next().get();
                    if (iVar != null) {
                        list.addAll(iVar.getComponents());
                        it.remove();
                    }
                } catch (v unused) {
                    it.remove();
                }
            }
            if (this.f13750a.isEmpty()) {
                p.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f13750a.keySet());
                arrayList2.addAll(list);
                p.a(arrayList2);
            }
            for (d<?> dVar : list) {
                this.f13750a.put(dVar, new w(j.a(this, dVar)));
            }
            arrayList.addAll(o(list));
            arrayList.addAll(p());
            n();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        m();
    }

    private void g(Map<d<?>, r4.b<?>> map, boolean z10) {
        for (Map.Entry<d<?>, r4.b<?>> entry : map.entrySet()) {
            d<?> key = entry.getKey();
            r4.b<?> value = entry.getValue();
            if (key.i() || (key.j() && z10)) {
                value.get();
            }
        }
        this.f13754e.d();
    }

    private static <T> List<T> i(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    private void m() {
        Boolean bool = this.f13755f.get();
        if (bool != null) {
            g(this.f13750a, bool.booleanValue());
        }
    }

    private void n() {
        Map map;
        Class<?> b10;
        r4.b a10;
        for (d<?> dVar : this.f13750a.keySet()) {
            for (q qVar : dVar.c()) {
                if (qVar.f() && !this.f13752c.containsKey(qVar.b())) {
                    map = this.f13752c;
                    b10 = qVar.b();
                    a10 = x.b(Collections.emptySet());
                } else if (this.f13751b.containsKey(qVar.b())) {
                    continue;
                } else {
                    if (qVar.e()) {
                        throw new y(String.format("Unsatisfied dependency for component %s: %s", dVar, qVar.b()));
                    }
                    if (!qVar.f()) {
                        map = this.f13751b;
                        b10 = qVar.b();
                        a10 = b0.a();
                    }
                }
                map.put(b10, a10);
            }
        }
    }

    private List<Runnable> o(List<d<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (d<?> dVar : list) {
            if (dVar.k()) {
                r4.b<?> bVar = this.f13750a.get(dVar);
                for (Class<? super Object> cls : dVar.e()) {
                    if (this.f13751b.containsKey(cls)) {
                        arrayList.add(k.a((b0) this.f13751b.get(cls), bVar));
                    } else {
                        this.f13751b.put(cls, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> p() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry<d<?>, r4.b<?>> entry : this.f13750a.entrySet()) {
            d<?> key = entry.getKey();
            if (!key.k()) {
                r4.b<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (this.f13752c.containsKey(entry2.getKey())) {
                x<?> xVar = this.f13752c.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(l.a(xVar, (r4.b) it.next()));
                }
            } else {
                this.f13752c.put((Class) entry2.getKey(), x.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    @Override // r3.e
    public synchronized <T> r4.b<T> c(Class<T> cls) {
        c0.c(cls, "Null interface requested.");
        return (r4.b) this.f13751b.get(cls);
    }

    @Override // r3.e
    public synchronized <T> r4.b<Set<T>> d(Class<T> cls) {
        x<?> xVar = this.f13752c.get(cls);
        if (xVar != null) {
            return xVar;
        }
        return (r4.b<Set<T>>) f13749g;
    }

    public void h(boolean z10) {
        HashMap hashMap;
        if (this.f13755f.compareAndSet(null, Boolean.valueOf(z10))) {
            synchronized (this) {
                hashMap = new HashMap(this.f13750a);
            }
            g(hashMap, z10);
        }
    }
}
