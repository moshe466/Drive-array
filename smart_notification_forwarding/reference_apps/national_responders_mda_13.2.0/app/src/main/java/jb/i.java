package jb;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class i<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    private int f11080f;

    /* renamed from: g, reason: collision with root package name */
    private Object f11081g;

    /* loaded from: classes.dex */
    private static class b<T> implements Iterator<T> {

        /* renamed from: f, reason: collision with root package name */
        private static final b f11082f = new b();

        private b() {
        }

        public static <T> b<T> b() {
            return f11082f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    private class c extends d<E> {

        /* renamed from: g, reason: collision with root package name */
        private final int f11083g;

        public c() {
            super();
            this.f11083g = ((AbstractList) i.this).modCount;
        }

        @Override // jb.i.d
        protected void b() {
            if (((AbstractList) i.this).modCount == this.f11083g) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) i.this).modCount + "; expected: " + this.f11083g);
        }

        @Override // jb.i.d
        protected E c() {
            return (E) i.this.f11081g;
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            i.this.clear();
        }
    }

    /* loaded from: classes.dex */
    private static abstract class d<T> implements Iterator<T> {

        /* renamed from: f, reason: collision with root package name */
        private boolean f11085f;

        private d() {
        }

        protected abstract void b();

        protected abstract T c();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f11085f;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f11085f) {
                throw new NoSuchElementException();
            }
            this.f11085f = true;
            b();
            return c();
        }
    }

    private static /* synthetic */ void c(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i10 == 2 || i10 == 3) {
            objArr[1] = "iterator";
        } else if (i10 == 5 || i10 == 6 || i10 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i10) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 5 && i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        int i11;
        if (i10 < 0 || i10 > (i11 = this.f11080f)) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f11080f);
        }
        if (i11 == 0) {
            this.f11081g = e10;
        } else if (i11 == 1 && i10 == 0) {
            this.f11081g = new Object[]{e10, this.f11081g};
        } else {
            Object[] objArr = new Object[i11 + 1];
            if (i11 == 1) {
                objArr[0] = this.f11081g;
            } else {
                Object[] objArr2 = (Object[]) this.f11081g;
                System.arraycopy(objArr2, 0, objArr, 0, i10);
                System.arraycopy(objArr2, i10, objArr, i10 + 1, this.f11080f - i10);
            }
            objArr[i10] = e10;
            this.f11081g = objArr;
        }
        this.f11080f++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        int i10 = this.f11080f;
        if (i10 == 0) {
            this.f11081g = e10;
        } else if (i10 == 1) {
            this.f11081g = new Object[]{this.f11081g, e10};
        } else {
            Object[] objArr = (Object[]) this.f11081g;
            int length = objArr.length;
            if (i10 >= length) {
                int i11 = ((length * 3) / 2) + 1;
                int i12 = i10 + 1;
                if (i11 < i12) {
                    i11 = i12;
                }
                Object[] objArr2 = new Object[i11];
                this.f11081g = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f11080f] = e10;
        }
        this.f11080f++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f11081g = null;
        this.f11080f = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        int i11;
        if (i10 >= 0 && i10 < (i11 = this.f11080f)) {
            return i11 == 1 ? (E) this.f11081g : (E) ((Object[]) this.f11081g)[i10];
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f11080f);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int i10 = this.f11080f;
        if (i10 == 0) {
            b b10 = b.b();
            if (b10 == null) {
                c(2);
            }
            return b10;
        }
        if (i10 == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            c(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        int i11;
        E e10;
        if (i10 < 0 || i10 >= (i11 = this.f11080f)) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f11080f);
        }
        if (i11 == 1) {
            e10 = (E) this.f11081g;
            this.f11081g = null;
        } else {
            Object[] objArr = (Object[]) this.f11081g;
            Object obj = objArr[i10];
            if (i11 == 2) {
                this.f11081g = objArr[1 - i10];
            } else {
                int i12 = (i11 - i10) - 1;
                if (i12 > 0) {
                    System.arraycopy(objArr, i10 + 1, objArr, i10, i12);
                }
                objArr[this.f11080f - 1] = null;
            }
            e10 = (E) obj;
        }
        this.f11080f--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f11080f)) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f11080f);
        }
        if (i11 == 1) {
            E e11 = (E) this.f11081g;
            this.f11081g = e10;
            return e11;
        }
        Object[] objArr = (Object[]) this.f11081g;
        E e12 = (E) objArr[i10];
        objArr[i10] = e10;
        return e12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11080f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            c(4);
        }
        int length = tArr.length;
        int i10 = this.f11080f;
        if (i10 == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.f11081g;
                return tArr2;
            }
            tArr[0] = this.f11081g;
        } else {
            if (length < i10) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.f11081g, i10, tArr.getClass());
                if (tArr3 == null) {
                    c(6);
                }
                return tArr3;
            }
            if (i10 != 0) {
                System.arraycopy(this.f11081g, 0, tArr, 0, i10);
            }
        }
        int i11 = this.f11080f;
        if (length > i11) {
            tArr[i11] = 0;
        }
        return tArr;
    }
}
