package r3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Set<Class<? super T>> f13719a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<q> f13720b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13721c;

    /* renamed from: d, reason: collision with root package name */
    private final int f13722d;

    /* renamed from: e, reason: collision with root package name */
    private final h<T> f13723e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<Class<?>> f13724f;

    /* loaded from: classes.dex */
    public static class b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Set<Class<? super T>> f13725a;

        /* renamed from: b, reason: collision with root package name */
        private final Set<q> f13726b;

        /* renamed from: c, reason: collision with root package name */
        private int f13727c;

        /* renamed from: d, reason: collision with root package name */
        private int f13728d;

        /* renamed from: e, reason: collision with root package name */
        private h<T> f13729e;

        /* renamed from: f, reason: collision with root package name */
        private Set<Class<?>> f13730f;

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.f13725a = hashSet;
            this.f13726b = new HashSet();
            this.f13727c = 0;
            this.f13728d = 0;
            this.f13730f = new HashSet();
            c0.c(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                c0.c(cls2, "Null interface");
            }
            Collections.addAll(this.f13725a, clsArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b<T> g() {
            this.f13728d = 1;
            return this;
        }

        private b<T> h(int i10) {
            c0.d(this.f13727c == 0, "Instantiation type has already been set.");
            this.f13727c = i10;
            return this;
        }

        private void i(Class<?> cls) {
            c0.a(!this.f13725a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(q qVar) {
            c0.c(qVar, "Null dependency");
            i(qVar.b());
            this.f13726b.add(qVar);
            return this;
        }

        public b<T> c() {
            return h(1);
        }

        public d<T> d() {
            c0.d(this.f13729e != null, "Missing required property: factory.");
            return new d<>(new HashSet(this.f13725a), new HashSet(this.f13726b), this.f13727c, this.f13728d, this.f13729e, this.f13730f);
        }

        public b<T> e() {
            return h(2);
        }

        public b<T> f(h<T> hVar) {
            this.f13729e = (h) c0.c(hVar, "Null factory");
            return this;
        }
    }

    private d(Set<Class<? super T>> set, Set<q> set2, int i10, int i11, h<T> hVar, Set<Class<?>> set3) {
        this.f13719a = Collections.unmodifiableSet(set);
        this.f13720b = Collections.unmodifiableSet(set2);
        this.f13721c = i10;
        this.f13722d = i11;
        this.f13723e = hVar;
        this.f13724f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> b(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> d<T> g(T t10, Class<T> cls) {
        return h(cls).f(c.b(t10)).d();
    }

    public static <T> b<T> h(Class<T> cls) {
        return a(cls).g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object l(Object obj, e eVar) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object m(Object obj, e eVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> d<T> n(T t10, Class<T> cls, Class<? super T>... clsArr) {
        return b(cls, clsArr).f(r3.b.b(t10)).d();
    }

    public Set<q> c() {
        return this.f13720b;
    }

    public h<T> d() {
        return this.f13723e;
    }

    public Set<Class<? super T>> e() {
        return this.f13719a;
    }

    public Set<Class<?>> f() {
        return this.f13724f;
    }

    public boolean i() {
        return this.f13721c == 1;
    }

    public boolean j() {
        return this.f13721c == 2;
    }

    public boolean k() {
        return this.f13722d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f13719a.toArray()) + ">{" + this.f13721c + ", type=" + this.f13722d + ", deps=" + Arrays.toString(this.f13720b.toArray()) + "}";
    }
}
