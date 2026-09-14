package n3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class a<T> extends n<T> {

        /* renamed from: f, reason: collision with root package name */
        boolean f12197f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f12198g;

        a(Object obj) {
            this.f12198g = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f12197f;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f12197f) {
                throw new NoSuchElementException();
            }
            this.f12197f = true;
            return (T) this.f12198g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b<T> extends n3.a<T> {

        /* renamed from: j, reason: collision with root package name */
        static final o<Object> f12199j = new b(new Object[0], 0, 0, 0);

        /* renamed from: h, reason: collision with root package name */
        private final T[] f12200h;

        /* renamed from: i, reason: collision with root package name */
        private final int f12201i;

        b(T[] tArr, int i10, int i11, int i12) {
            super(i11, i12);
            this.f12200h = tArr;
            this.f12201i = i10;
        }

        @Override // n3.a
        protected T b(int i10) {
            return this.f12200h[this.f12201i + i10];
        }
    }

    public static boolean a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !m3.c.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    static <T> o<T> b() {
        return (o<T>) b.f12199j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> o<T> c(T[] tArr, int i10, int i11, int i12) {
        m3.d.d(i11 >= 0);
        m3.d.k(i10, i10 + i11, tArr.length);
        m3.d.i(i12, i11);
        return i11 == 0 ? b() : new b(tArr, i10, i11, i12);
    }

    public static <T> n<T> d(T t10) {
        return new a(t10);
    }
}
