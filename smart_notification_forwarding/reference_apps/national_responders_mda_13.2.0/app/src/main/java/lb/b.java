package lb;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b<T> implements h<T>, c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final h<T> f11864a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11865b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<T>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final Iterator<T> f11866f;

        /* renamed from: g, reason: collision with root package name */
        private int f11867g;

        a(b<T> bVar) {
            this.f11866f = ((b) bVar).f11864a.iterator();
            this.f11867g = ((b) bVar).f11865b;
        }

        private final void b() {
            while (this.f11867g > 0 && this.f11866f.hasNext()) {
                this.f11866f.next();
                this.f11867g--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f11866f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            b();
            return this.f11866f.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(h<? extends T> hVar, int i10) {
        y8.k.e(hVar, "sequence");
        this.f11864a = hVar;
        this.f11865b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // lb.c
    public h<T> a(int i10) {
        int i11 = this.f11865b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f11864a, i11);
    }

    @Override // lb.h
    public Iterator<T> iterator() {
        return new a(this);
    }
}
