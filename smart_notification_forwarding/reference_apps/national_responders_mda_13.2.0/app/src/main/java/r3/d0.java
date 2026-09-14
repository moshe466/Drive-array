package r3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d0 extends r3.a {

    /* renamed from: a, reason: collision with root package name */
    private final Set<Class<?>> f13731a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Class<?>> f13732b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<Class<?>> f13733c;

    /* renamed from: d, reason: collision with root package name */
    private final Set<Class<?>> f13734d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<Class<?>> f13735e;

    /* renamed from: f, reason: collision with root package name */
    private final e f13736f;

    /* loaded from: classes.dex */
    private static class a implements o4.c {

        /* renamed from: a, reason: collision with root package name */
        private final o4.c f13737a;

        public a(Set<Class<?>> set, o4.c cVar) {
            this.f13737a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(d<?> dVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (q qVar : dVar.c()) {
            if (qVar.d()) {
                boolean f10 = qVar.f();
                Class<?> b10 = qVar.b();
                if (f10) {
                    hashSet4.add(b10);
                } else {
                    hashSet.add(b10);
                }
            } else if (qVar.c()) {
                hashSet3.add(qVar.b());
            } else {
                boolean f11 = qVar.f();
                Class<?> b11 = qVar.b();
                if (f11) {
                    hashSet5.add(b11);
                } else {
                    hashSet2.add(b11);
                }
            }
        }
        if (!dVar.f().isEmpty()) {
            hashSet.add(o4.c.class);
        }
        this.f13731a = Collections.unmodifiableSet(hashSet);
        this.f13732b = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.f13733c = Collections.unmodifiableSet(hashSet4);
        this.f13734d = Collections.unmodifiableSet(hashSet5);
        this.f13735e = dVar.f();
        this.f13736f = eVar;
    }

    @Override // r3.a, r3.e
    public <T> T a(Class<T> cls) {
        if (!this.f13731a.contains(cls)) {
            throw new s(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t10 = (T) this.f13736f.a(cls);
        return !cls.equals(o4.c.class) ? t10 : (T) new a(this.f13735e, (o4.c) t10);
    }

    @Override // r3.a, r3.e
    public <T> Set<T> b(Class<T> cls) {
        if (this.f13733c.contains(cls)) {
            return this.f13736f.b(cls);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // r3.e
    public <T> r4.b<T> c(Class<T> cls) {
        if (this.f13732b.contains(cls)) {
            return this.f13736f.c(cls);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // r3.e
    public <T> r4.b<Set<T>> d(Class<T> cls) {
        if (this.f13734d.contains(cls)) {
            return this.f13736f.d(cls);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
