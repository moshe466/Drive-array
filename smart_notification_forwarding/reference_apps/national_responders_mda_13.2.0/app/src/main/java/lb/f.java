package lb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class f<T, R, E> implements h<E> {

    /* renamed from: a, reason: collision with root package name */
    private final h<T> f11876a;

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<T, R> f11877b;

    /* renamed from: c, reason: collision with root package name */
    private final x8.l<R, Iterator<E>> f11878c;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<E>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final Iterator<T> f11879f;

        /* renamed from: g, reason: collision with root package name */
        private Iterator<? extends E> f11880g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ f<T, R, E> f11881h;

        a(f<T, R, E> fVar) {
            this.f11881h = fVar;
            this.f11879f = ((f) fVar).f11876a.iterator();
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final boolean b() {
            /*
                r5 = this;
                java.util.Iterator<? extends E> r0 = r5.f11880g
                r1 = 1
                r2 = 0
                if (r0 == 0) goto Le
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                if (r0 == 0) goto L14
                r0 = 0
                r5.f11880g = r0
            L14:
                java.util.Iterator<? extends E> r0 = r5.f11880g
                if (r0 != 0) goto L45
                java.util.Iterator<T> r0 = r5.f11879f
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L21
                return r2
            L21:
                java.util.Iterator<T> r0 = r5.f11879f
                java.lang.Object r0 = r0.next()
                lb.f<T, R, E> r3 = r5.f11881h
                x8.l r3 = lb.f.b(r3)
                lb.f<T, R, E> r4 = r5.f11881h
                x8.l r4 = lb.f.d(r4)
                java.lang.Object r0 = r4.h(r0)
                java.lang.Object r0 = r3.h(r0)
                java.util.Iterator r0 = (java.util.Iterator) r0
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L14
                r5.f11880g = r0
            L45:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: lb.f.a.b():boolean");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return b();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f11880g;
            y8.k.b(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(h<? extends T> hVar, x8.l<? super T, ? extends R> lVar, x8.l<? super R, ? extends Iterator<? extends E>> lVar2) {
        y8.k.e(hVar, "sequence");
        y8.k.e(lVar, "transformer");
        y8.k.e(lVar2, "iterator");
        this.f11876a = hVar;
        this.f11877b = lVar;
        this.f11878c = lVar2;
    }

    @Override // lb.h
    public Iterator<E> iterator() {
        return new a(this);
    }
}
