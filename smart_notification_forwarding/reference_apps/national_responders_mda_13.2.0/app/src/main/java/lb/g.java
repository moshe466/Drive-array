package lb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g<T> implements h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final x8.a<T> f11882a;

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<T, T> f11883b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<T>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private T f11884f;

        /* renamed from: g, reason: collision with root package name */
        private int f11885g = -2;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ g<T> f11886h;

        a(g<T> gVar) {
            this.f11886h = gVar;
        }

        private final void b() {
            T t10;
            if (this.f11885g == -2) {
                t10 = (T) ((g) this.f11886h).f11882a.b();
            } else {
                x8.l lVar = ((g) this.f11886h).f11883b;
                T t11 = this.f11884f;
                y8.k.b(t11);
                t10 = (T) lVar.h(t11);
            }
            this.f11884f = t10;
            this.f11885g = t10 == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11885g < 0) {
                b();
            }
            return this.f11885g == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f11885g < 0) {
                b();
            }
            if (this.f11885g == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f11884f;
            y8.k.c(t10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f11885g = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(x8.a<? extends T> aVar, x8.l<? super T, ? extends T> lVar) {
        y8.k.e(aVar, "getInitialValue");
        y8.k.e(lVar, "getNextValue");
        this.f11882a = aVar;
        this.f11883b = lVar;
    }

    @Override // lb.h
    public Iterator<T> iterator() {
        return new a(this);
    }
}
