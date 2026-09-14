package lb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class o<T> implements h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final h<T> f11895a;

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<T, Boolean> f11896b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<T>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final Iterator<T> f11897f;

        /* renamed from: g, reason: collision with root package name */
        private int f11898g = -1;

        /* renamed from: h, reason: collision with root package name */
        private T f11899h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ o<T> f11900i;

        a(o<T> oVar) {
            this.f11900i = oVar;
            this.f11897f = ((o) oVar).f11895a.iterator();
        }

        private final void b() {
            if (this.f11897f.hasNext()) {
                T next = this.f11897f.next();
                if (((Boolean) ((o) this.f11900i).f11896b.h(next)).booleanValue()) {
                    this.f11898g = 1;
                    this.f11899h = next;
                    return;
                }
            }
            this.f11898g = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11898g == -1) {
                b();
            }
            return this.f11898g == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f11898g == -1) {
                b();
            }
            if (this.f11898g == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f11899h;
            this.f11899h = null;
            this.f11898g = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(h<? extends T> hVar, x8.l<? super T, Boolean> lVar) {
        y8.k.e(hVar, "sequence");
        y8.k.e(lVar, "predicate");
        this.f11895a = hVar;
        this.f11896b = lVar;
    }

    @Override // lb.h
    public Iterator<T> iterator() {
        return new a(this);
    }
}
