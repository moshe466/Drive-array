package jb;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import l8.w;
import m8.r0;
import y8.z;

/* loaded from: classes.dex */
public final class j<T> extends AbstractSet<T> {

    /* renamed from: h, reason: collision with root package name */
    public static final b f11086h = new b(null);

    /* renamed from: f, reason: collision with root package name */
    private Object f11087f;

    /* renamed from: g, reason: collision with root package name */
    private int f11088g;

    /* loaded from: classes.dex */
    private static final class a<T> implements Iterator<T>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final Iterator<T> f11089f;

        public a(T[] tArr) {
            y8.k.e(tArr, "array");
            this.f11089f = y8.b.a(tArr);
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11089f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f11089f.next();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }

        public final <T> j<T> a() {
            return new j<>(null);
        }

        public final <T> j<T> b(Collection<? extends T> collection) {
            y8.k.e(collection, "set");
            j<T> jVar = new j<>(null);
            jVar.addAll(collection);
            return jVar;
        }
    }

    /* loaded from: classes.dex */
    private static final class c<T> implements Iterator<T>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final T f11090f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f11091g = true;

        public c(T t10) {
            this.f11090f = t10;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11091g;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f11091g) {
                throw new NoSuchElementException();
            }
            this.f11091g = false;
            return this.f11090f;
        }
    }

    private j() {
    }

    public /* synthetic */ j(y8.g gVar) {
        this();
    }

    public static final <T> j<T> c() {
        return f11086h.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t10) {
        boolean m10;
        Object[] objArr;
        LinkedHashSet c10;
        if (size() == 0) {
            this.f11087f = t10;
        } else if (size() == 1) {
            if (y8.k.a(this.f11087f, t10)) {
                return false;
            }
            this.f11087f = new Object[]{this.f11087f, t10};
        } else if (size() < 5) {
            Object obj = this.f11087f;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            m10 = m8.k.m(objArr2, t10);
            if (m10) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr3 = new Object[objArr2.length];
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                c10 = r0.c(objArr3);
                c10.add(t10);
                objArr = c10;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                y8.k.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                copyOf[copyOf.length - 1] = t10;
                objArr = copyOf;
            }
            w wVar = w.f11824a;
            this.f11087f = objArr;
        } else {
            Object obj2 = this.f11087f;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!z.b(obj2).add(t10)) {
                return false;
            }
        }
        g(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f11087f = null;
        g(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean m10;
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return y8.k.a(this.f11087f, obj);
        }
        if (size() >= 5) {
            Object obj2 = this.f11087f;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
            return ((Set) obj2).contains(obj);
        }
        Object obj3 = this.f11087f;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        m10 = m8.k.m((Object[]) obj3, obj);
        return m10;
    }

    public int f() {
        return this.f11088g;
    }

    public void g(int i10) {
        this.f11088g = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        Set b10;
        if (size() == 0) {
            b10 = Collections.emptySet();
        } else {
            if (size() == 1) {
                return new c(this.f11087f);
            }
            if (size() < 5) {
                Object obj = this.f11087f;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
                return new a((Object[]) obj);
            }
            Object obj2 = this.f11087f;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            b10 = z.b(obj2);
        }
        return b10.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }
}
