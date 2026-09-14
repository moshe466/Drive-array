package kb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class a<E> implements Iterable<E> {

    /* renamed from: i, reason: collision with root package name */
    private static final a<Object> f11323i = new a<>();

    /* renamed from: f, reason: collision with root package name */
    final E f11324f;

    /* renamed from: g, reason: collision with root package name */
    final a<E> f11325g;

    /* renamed from: h, reason: collision with root package name */
    private final int f11326h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kb.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0230a<E> implements Iterator<E> {

        /* renamed from: f, reason: collision with root package name */
        private a<E> f11327f;

        public C0230a(a<E> aVar) {
            this.f11327f = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return ((a) this.f11327f).f11326h > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.f11327f;
            E e10 = aVar.f11324f;
            this.f11327f = aVar.f11325g;
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private a() {
        this.f11326h = 0;
        this.f11324f = null;
        this.f11325g = null;
    }

    private a(E e10, a<E> aVar) {
        this.f11324f = e10;
        this.f11325g = aVar;
        this.f11326h = aVar.f11326h + 1;
    }

    public static <E> a<E> f() {
        return (a<E>) f11323i;
    }

    private Iterator<E> g(int i10) {
        return new C0230a(t(i10));
    }

    private a<E> l(Object obj) {
        if (this.f11326h == 0) {
            return this;
        }
        if (this.f11324f.equals(obj)) {
            return this.f11325g;
        }
        a<E> l10 = this.f11325g.l(obj);
        return l10 == this.f11325g ? this : new a<>(this.f11324f, l10);
    }

    private a<E> t(int i10) {
        if (i10 < 0 || i10 > this.f11326h) {
            throw new IndexOutOfBoundsException();
        }
        return i10 == 0 ? this : this.f11325g.t(i10 - 1);
    }

    public E get(int i10) {
        if (i10 < 0 || i10 > this.f11326h) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return g(i10).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException("Index: " + i10);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return g(0);
    }

    public a<E> j(int i10) {
        return l(get(i10));
    }

    public a<E> s(E e10) {
        return new a<>(e10, this);
    }

    public int size() {
        return this.f11326h;
    }
}
