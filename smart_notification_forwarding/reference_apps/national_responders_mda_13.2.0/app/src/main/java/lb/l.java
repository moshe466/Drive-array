package lb;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends k {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f11887a;

        public a(Iterator it) {
            this.f11887a = it;
        }

        @Override // lb.h
        public Iterator<T> iterator() {
            return this.f11887a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    static final class b<T> extends y8.l implements x8.l<h<? extends T>, Iterator<? extends T>> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f11888f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterator<T> h(h<? extends T> hVar) {
            y8.k.e(hVar, "it");
            return hVar.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class c<T> extends y8.l implements x8.l<T, T> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f11889f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        public final T h(T t10) {
            return t10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class d<T> extends y8.l implements x8.l<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x8.a<T> f11890f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(x8.a<? extends T> aVar) {
            super(1);
            this.f11890f = aVar;
        }

        @Override // x8.l
        public final T h(T t10) {
            y8.k.e(t10, "it");
            return this.f11890f.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class e<T> extends y8.l implements x8.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ T f11891f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(T t10) {
            super(0);
            this.f11891f = t10;
        }

        @Override // x8.a
        public final T b() {
            return this.f11891f;
        }
    }

    public static <T> h<T> a(Iterator<? extends T> it) {
        y8.k.e(it, "<this>");
        return b(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> h<T> b(h<? extends T> hVar) {
        y8.k.e(hVar, "<this>");
        return hVar instanceof lb.a ? hVar : new lb.a(hVar);
    }

    public static <T> h<T> c() {
        return lb.d.f11868a;
    }

    public static final <T> h<T> d(h<? extends h<? extends T>> hVar) {
        y8.k.e(hVar, "<this>");
        return e(hVar, b.f11888f);
    }

    private static final <T, R> h<R> e(h<? extends T> hVar, x8.l<? super T, ? extends Iterator<? extends R>> lVar) {
        return hVar instanceof p ? ((p) hVar).d(lVar) : new f(hVar, c.f11889f, lVar);
    }

    public static <T> h<T> f(T t10, x8.l<? super T, ? extends T> lVar) {
        y8.k.e(lVar, "nextFunction");
        return t10 == null ? lb.d.f11868a : new g(new e(t10), lVar);
    }

    public static <T> h<T> g(x8.a<? extends T> aVar) {
        y8.k.e(aVar, "nextFunction");
        return b(new g(aVar, new d(aVar)));
    }

    public static final <T> h<T> h(T... tArr) {
        h<T> k10;
        h<T> c10;
        y8.k.e(tArr, "elements");
        if (tArr.length == 0) {
            c10 = c();
            return c10;
        }
        k10 = m8.k.k(tArr);
        return k10;
    }
}
