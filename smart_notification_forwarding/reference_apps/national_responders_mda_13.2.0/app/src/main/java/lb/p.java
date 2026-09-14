package lb;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class p<T, R> implements h<R> {

    /* renamed from: a, reason: collision with root package name */
    private final h<T> f11901a;

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<T, R> f11902b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<R>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final Iterator<T> f11903f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ p<T, R> f11904g;

        a(p<T, R> pVar) {
            this.f11904g = pVar;
            this.f11903f = ((p) pVar).f11901a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11903f.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((p) this.f11904g).f11902b.h(this.f11903f.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(h<? extends T> hVar, x8.l<? super T, ? extends R> lVar) {
        y8.k.e(hVar, "sequence");
        y8.k.e(lVar, "transformer");
        this.f11901a = hVar;
        this.f11902b = lVar;
    }

    public final <E> h<E> d(x8.l<? super R, ? extends Iterator<? extends E>> lVar) {
        y8.k.e(lVar, "iterator");
        return new f(this.f11901a, this.f11902b, lVar);
    }

    @Override // lb.h
    public Iterator<R> iterator() {
        return new a(this);
    }
}
