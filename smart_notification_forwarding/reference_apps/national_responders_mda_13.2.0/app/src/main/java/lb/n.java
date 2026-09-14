package lb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.q;
import m8.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements Iterable<T>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f11892f;

        public a(h hVar) {
            this.f11892f = hVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f11892f.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class b<T> extends y8.l implements x8.l<T, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f11893f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean h(T t10) {
            return Boolean.valueOf(t10 == null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes.dex */
    public /* synthetic */ class c<R> extends y8.j implements x8.l<h<? extends R>, Iterator<? extends R>> {

        /* renamed from: o, reason: collision with root package name */
        public static final c f11894o = new c();

        c() {
            super(1, h.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> h(h<? extends R> hVar) {
            y8.k.e(hVar, "p0");
            return hVar.iterator();
        }
    }

    public static <T> Iterable<T> i(h<? extends T> hVar) {
        y8.k.e(hVar, "<this>");
        return new a(hVar);
    }

    public static <T> int j(h<? extends T> hVar) {
        y8.k.e(hVar, "<this>");
        Iterator<? extends T> it = hVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                q.l();
            }
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> h<T> k(h<? extends T> hVar, int i10) {
        y8.k.e(hVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? hVar : hVar instanceof lb.c ? ((lb.c) hVar).a(i10) : new lb.b(hVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> h<T> l(h<? extends T> hVar, x8.l<? super T, Boolean> lVar) {
        y8.k.e(hVar, "<this>");
        y8.k.e(lVar, "predicate");
        return new e(hVar, true, lVar);
    }

    public static <T> h<T> m(h<? extends T> hVar, x8.l<? super T, Boolean> lVar) {
        y8.k.e(hVar, "<this>");
        y8.k.e(lVar, "predicate");
        return new e(hVar, false, lVar);
    }

    public static <T> h<T> n(h<? extends T> hVar) {
        h<T> m10;
        y8.k.e(hVar, "<this>");
        m10 = m(hVar, b.f11893f);
        y8.k.c(m10, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return m10;
    }

    public static <T> T o(h<? extends T> hVar) {
        y8.k.e(hVar, "<this>");
        Iterator<? extends T> it = hVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T, R> h<R> p(h<? extends T> hVar, x8.l<? super T, ? extends h<? extends R>> lVar) {
        y8.k.e(hVar, "<this>");
        y8.k.e(lVar, "transform");
        return new f(hVar, lVar, c.f11894o);
    }

    public static <T, R> h<R> q(h<? extends T> hVar, x8.l<? super T, ? extends R> lVar) {
        y8.k.e(hVar, "<this>");
        y8.k.e(lVar, "transform");
        return new p(hVar, lVar);
    }

    public static <T, R> h<R> r(h<? extends T> hVar, x8.l<? super T, ? extends R> lVar) {
        h<R> n10;
        y8.k.e(hVar, "<this>");
        y8.k.e(lVar, "transform");
        n10 = n(new p(hVar, lVar));
        return n10;
    }

    public static <T> h<T> s(h<? extends T> hVar, Iterable<? extends T> iterable) {
        h A;
        y8.k.e(hVar, "<this>");
        y8.k.e(iterable, "elements");
        A = y.A(iterable);
        return l.d(l.h(hVar, A));
    }

    public static <T> h<T> t(h<? extends T> hVar, T t10) {
        y8.k.e(hVar, "<this>");
        return l.d(l.h(hVar, l.h(t10)));
    }

    public static <T> h<T> u(h<? extends T> hVar, x8.l<? super T, Boolean> lVar) {
        y8.k.e(hVar, "<this>");
        y8.k.e(lVar, "predicate");
        return new o(hVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C v(h<? extends T> hVar, C c10) {
        y8.k.e(hVar, "<this>");
        y8.k.e(c10, "destination");
        Iterator<? extends T> it = hVar.iterator();
        while (it.hasNext()) {
            c10.add(it.next());
        }
        return c10;
    }

    public static <T> List<T> w(h<? extends T> hVar) {
        List x10;
        List<T> k10;
        y8.k.e(hVar, "<this>");
        x10 = x(hVar);
        k10 = q.k(x10);
        return k10;
    }

    public static <T> List<T> x(h<? extends T> hVar) {
        y8.k.e(hVar, "<this>");
        return (List) v(hVar, new ArrayList());
    }
}
