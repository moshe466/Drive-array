package l;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f11714j = new int[0];

    /* renamed from: k, reason: collision with root package name */
    private static final Object[] f11715k = new Object[0];

    /* renamed from: l, reason: collision with root package name */
    private static Object[] f11716l;

    /* renamed from: m, reason: collision with root package name */
    private static int f11717m;

    /* renamed from: n, reason: collision with root package name */
    private static Object[] f11718n;

    /* renamed from: o, reason: collision with root package name */
    private static int f11719o;

    /* renamed from: f, reason: collision with root package name */
    private int[] f11720f;

    /* renamed from: g, reason: collision with root package name */
    Object[] f11721g;

    /* renamed from: h, reason: collision with root package name */
    int f11722h;

    /* renamed from: i, reason: collision with root package name */
    private f<E, E> f11723i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        a() {
        }

        @Override // l.f
        protected void a() {
            b.this.clear();
        }

        @Override // l.f
        protected Object b(int i10, int i11) {
            return b.this.f11721g[i10];
        }

        @Override // l.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // l.f
        protected int d() {
            return b.this.f11722h;
        }

        @Override // l.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // l.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // l.f
        protected void g(E e10, E e11) {
            b.this.add(e10);
        }

        @Override // l.f
        protected void h(int i10) {
            b.this.t(i10);
        }

        @Override // l.f
        protected E i(int i10, E e10) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i10) {
        if (i10 == 0) {
            this.f11720f = f11714j;
            this.f11721g = f11715k;
        } else {
            c(i10);
        }
        this.f11722h = 0;
    }

    private void c(int i10) {
        if (i10 == 8) {
            synchronized (b.class) {
                Object[] objArr = f11718n;
                if (objArr != null) {
                    this.f11721g = objArr;
                    f11718n = (Object[]) objArr[0];
                    this.f11720f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f11719o--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f11716l;
                if (objArr2 != null) {
                    this.f11721g = objArr2;
                    f11716l = (Object[]) objArr2[0];
                    this.f11720f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f11717m--;
                    return;
                }
            }
        }
        this.f11720f = new int[i10];
        this.f11721g = new Object[i10];
    }

    private static void g(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f11719o < 10) {
                    objArr[0] = f11718n;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f11718n = objArr;
                    f11719o++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f11717m < 10) {
                    objArr[0] = f11716l;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f11716l = objArr;
                    f11717m++;
                }
            }
        }
    }

    private f<E, E> j() {
        if (this.f11723i == null) {
            this.f11723i = new a();
        }
        return this.f11723i;
    }

    private int l(Object obj, int i10) {
        int i11 = this.f11722h;
        if (i11 == 0) {
            return -1;
        }
        int a10 = c.a(this.f11720f, i11, i10);
        if (a10 < 0 || obj.equals(this.f11721g[a10])) {
            return a10;
        }
        int i12 = a10 + 1;
        while (i12 < i11 && this.f11720f[i12] == i10) {
            if (obj.equals(this.f11721g[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = a10 - 1; i13 >= 0 && this.f11720f[i13] == i10; i13--) {
            if (obj.equals(this.f11721g[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    private int s() {
        int i10 = this.f11722h;
        if (i10 == 0) {
            return -1;
        }
        int a10 = c.a(this.f11720f, i10, 0);
        if (a10 < 0 || this.f11721g[a10] == null) {
            return a10;
        }
        int i11 = a10 + 1;
        while (i11 < i10 && this.f11720f[i11] == 0) {
            if (this.f11721g[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = a10 - 1; i12 >= 0 && this.f11720f[i12] == 0; i12--) {
            if (this.f11721g[i12] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e10) {
        int i10;
        int l10;
        if (e10 == null) {
            l10 = s();
            i10 = 0;
        } else {
            int hashCode = e10.hashCode();
            i10 = hashCode;
            l10 = l(e10, hashCode);
        }
        if (l10 >= 0) {
            return false;
        }
        int i11 = ~l10;
        int i12 = this.f11722h;
        int[] iArr = this.f11720f;
        if (i12 >= iArr.length) {
            int i13 = 4;
            if (i12 >= 8) {
                i13 = (i12 >> 1) + i12;
            } else if (i12 >= 4) {
                i13 = 8;
            }
            Object[] objArr = this.f11721g;
            c(i13);
            int[] iArr2 = this.f11720f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f11721g, 0, objArr.length);
            }
            g(iArr, objArr, this.f11722h);
        }
        int i14 = this.f11722h;
        if (i11 < i14) {
            int[] iArr3 = this.f11720f;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr2 = this.f11721g;
            System.arraycopy(objArr2, i11, objArr2, i15, this.f11722h - i11);
        }
        this.f11720f[i11] = i10;
        this.f11721g[i11] = e10;
        this.f11722h++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        f(this.f11722h + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= add(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f11722h;
        if (i10 != 0) {
            g(this.f11720f, this.f11721g, i10);
            this.f11720f = f11714j;
            this.f11721g = f11715k;
            this.f11722h = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f11722h; i10++) {
                try {
                    if (!set.contains(u(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void f(int i10) {
        int[] iArr = this.f11720f;
        if (iArr.length < i10) {
            Object[] objArr = this.f11721g;
            c(i10);
            int i11 = this.f11722h;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f11720f, 0, i11);
                System.arraycopy(objArr, 0, this.f11721g, 0, this.f11722h);
            }
            g(iArr, objArr, this.f11722h);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f11720f;
        int i10 = this.f11722h;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? s() : l(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f11722h <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return j().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        t(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= remove(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.f11722h - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f11721g[i10])) {
                t(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f11722h;
    }

    public E t(int i10) {
        Object[] objArr = this.f11721g;
        E e10 = (E) objArr[i10];
        int i11 = this.f11722h;
        if (i11 <= 1) {
            g(this.f11720f, objArr, i11);
            this.f11720f = f11714j;
            this.f11721g = f11715k;
            this.f11722h = 0;
        } else {
            int[] iArr = this.f11720f;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i12 = i11 - 1;
                this.f11722h = i12;
                if (i10 < i12) {
                    int i13 = i10 + 1;
                    System.arraycopy(iArr, i13, iArr, i10, i12 - i10);
                    Object[] objArr2 = this.f11721g;
                    System.arraycopy(objArr2, i13, objArr2, i10, this.f11722h - i10);
                }
                this.f11721g[this.f11722h] = null;
            } else {
                c(i11 > 8 ? i11 + (i11 >> 1) : 8);
                this.f11722h--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f11720f, 0, i10);
                    System.arraycopy(objArr, 0, this.f11721g, 0, i10);
                }
                int i14 = this.f11722h;
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    System.arraycopy(iArr, i15, this.f11720f, i10, i14 - i10);
                    System.arraycopy(objArr, i15, this.f11721g, i10, this.f11722h - i10);
                }
            }
        }
        return e10;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i10 = this.f11722h;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f11721g, 0, objArr, 0, i10);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f11722h) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f11722h));
        }
        System.arraycopy(this.f11721g, 0, tArr, 0, this.f11722h);
        int length = tArr.length;
        int i10 = this.f11722h;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11722h * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f11722h; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            E u10 = u(i10);
            if (u10 != this) {
                sb2.append(u10);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public E u(int i10) {
        return (E) this.f11721g[i10];
    }
}
