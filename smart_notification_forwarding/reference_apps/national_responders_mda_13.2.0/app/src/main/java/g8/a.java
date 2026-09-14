package g8;

import java.util.Comparator;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final e8.a f9910a;

    /* renamed from: b, reason: collision with root package name */
    static final e8.c<Object> f9911b;

    /* renamed from: c, reason: collision with root package name */
    public static final e8.c<Throwable> f9912c;

    /* renamed from: g8.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class RunnableC0175a implements Runnable {
        RunnableC0175a() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* loaded from: classes.dex */
    static class b implements e8.a {
        b() {
        }

        @Override // e8.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* loaded from: classes.dex */
    static class c implements e8.c<Object> {
        c() {
        }

        @Override // e8.c
        public void a(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: classes.dex */
    static class d implements e8.c<Throwable> {
        d() {
        }

        @Override // e8.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            j8.a.c(th);
        }
    }

    /* loaded from: classes.dex */
    static class e {
        e() {
        }
    }

    /* loaded from: classes.dex */
    static class f {
        f() {
        }
    }

    /* loaded from: classes.dex */
    static class g {
        g() {
        }
    }

    /* loaded from: classes.dex */
    static class h implements Callable<Object> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes.dex */
    static class j implements e8.c<hc.a> {
        j() {
        }

        @Override // e8.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(hc.a aVar) {
            aVar.a(Long.MAX_VALUE);
        }
    }

    /* loaded from: classes.dex */
    static class k implements e8.d<Object, Object> {
        k() {
        }

        @Override // e8.d
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static {
        new k();
        new RunnableC0175a();
        f9910a = new b();
        f9911b = new c();
        f9912c = new d();
        new e();
        new f();
        new g();
        new h();
        new i();
        new j();
    }

    public static <T> e8.c<T> a() {
        return (e8.c<T>) f9911b;
    }
}
