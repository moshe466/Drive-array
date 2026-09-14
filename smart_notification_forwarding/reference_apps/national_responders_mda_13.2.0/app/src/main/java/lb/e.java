package lb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e<T> implements h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final h<T> f11869a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f11870b;

    /* renamed from: c, reason: collision with root package name */
    private final x8.l<T, Boolean> f11871c;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<T>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final Iterator<T> f11872f;

        /* renamed from: g, reason: collision with root package name */
        private int f11873g = -1;

        /* renamed from: h, reason: collision with root package name */
        private T f11874h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ e<T> f11875i;

        a(e<T> eVar) {
            this.f11875i = eVar;
            this.f11872f = ((e) eVar).f11869a.iterator();
        }

        private final void b() {
            int i10;
            while (true) {
                if (!this.f11872f.hasNext()) {
                    i10 = 0;
                    break;
                }
                T next = this.f11872f.next();
                if (((Boolean) ((e) this.f11875i).f11871c.h(next)).booleanValue() == ((e) this.f11875i).f11870b) {
                    this.f11874h = next;
                    i10 = 1;
                    break;
                }
            }
            this.f11873g = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11873g == -1) {
                b();
            }
            return this.f11873g == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f11873g == -1) {
                b();
            }
            if (this.f11873g == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f11874h;
            this.f11874h = null;
            this.f11873g = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(h<? extends T> hVar, boolean z10, x8.l<? super T, Boolean> lVar) {
        y8.k.e(hVar, "sequence");
        y8.k.e(lVar, "predicate");
        this.f11869a = hVar;
        this.f11870b = z10;
        this.f11871c = lVar;
    }

    @Override // lb.h
    public Iterator<T> iterator() {
        return new a(this);
    }
}
