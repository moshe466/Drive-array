package n3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import n3.e;

/* loaded from: classes.dex */
public abstract class g<E> extends e<E> implements List<E>, RandomAccess {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends n3.a<E> {
        a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // n3.a
        protected E b(int i10) {
            return g.this.get(i10);
        }
    }

    /* loaded from: classes.dex */
    public static final class b<E> extends e.a<E> {

        /* renamed from: a, reason: collision with root package name */
        Object[] f12191a;

        /* renamed from: b, reason: collision with root package name */
        private int f12192b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f12193c;

        public b() {
            this(4);
        }

        b(int i10) {
            this.f12191a = new Object[i10];
            this.f12192b = 0;
        }

        private void d(int i10) {
            Object[] objArr = this.f12191a;
            if (objArr.length < i10) {
                this.f12191a = Arrays.copyOf(objArr, e.a.a(objArr.length, i10));
            } else if (!this.f12193c) {
                return;
            } else {
                this.f12191a = Arrays.copyOf(objArr, objArr.length);
            }
            this.f12193c = false;
        }

        public b<E> b(E e10) {
            m3.d.h(e10);
            d(this.f12192b + 1);
            Object[] objArr = this.f12191a;
            int i10 = this.f12192b;
            this.f12192b = i10 + 1;
            objArr[i10] = e10;
            return this;
        }

        public g<E> c() {
            this.f12193c = true;
            return g.l(this.f12191a, this.f12192b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g<E> {

        /* renamed from: g, reason: collision with root package name */
        final transient int f12194g;

        /* renamed from: h, reason: collision with root package name */
        final transient int f12195h;

        c(int i10, int i11) {
            this.f12194g = i10;
            this.f12195h = i11;
        }

        @Override // java.util.List
        public E get(int i10) {
            m3.d.f(i10, this.f12195h);
            return g.this.get(i10 + this.f12194g);
        }

        @Override // n3.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // n3.g, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // n3.g, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f12195h;
        }

        @Override // n3.g, java.util.List
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public g<E> subList(int i10, int i11) {
            m3.d.k(i10, i11, this.f12195h);
            g gVar = g.this;
            int i12 = this.f12194g;
            return gVar.subList(i10 + i12, i11 + i12);
        }
    }

    static <E> g<E> l(Object[] objArr, int i10) {
        if (i10 == 0) {
            return w();
        }
        if (i10 != 1) {
            if (i10 < objArr.length) {
                objArr = Arrays.copyOf(objArr, i10);
            }
            return new l(objArr);
        }
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        return x(obj);
    }

    public static <E> b<E> s() {
        return new b<>();
    }

    public static <E> g<E> w() {
        return (g<E>) l.f12202h;
    }

    public static <E> g<E> x(E e10) {
        return new m(e10);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // n3.e
    int c(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return i.a(this, obj);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        m3.d.h(consumer);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            consumer.accept(get(i10));
        }
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return i.b(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return i.d(this, obj);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void replaceAll(UnaryOperator<E> unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<E> spliterator() {
        return d.a(size(), 1296, new IntFunction() { // from class: n3.f
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return g.this.get(i10);
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public n<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public o<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public o<E> listIterator(int i10) {
        return new a(size(), i10);
    }

    @Override // java.util.List
    /* renamed from: y */
    public g<E> subList(int i10, int i11) {
        m3.d.k(i10, i11, size());
        int i12 = i11 - i10;
        return i12 == size() ? this : i12 == 0 ? w() : i12 == 1 ? x(get(i10)) : z(i10, i11);
    }

    g<E> z(int i10, int i11) {
        return new c(i10, i11 - i10);
    }
}
