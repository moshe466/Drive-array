package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.h0;

/* loaded from: classes.dex */
public class g0<T extends h0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a, reason: collision with root package name */
    private T[] f11620a;

    private final T[] f() {
        T[] tArr = this.f11620a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new h0[4];
            this.f11620a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
        y8.k.d(copyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((h0[]) copyOf);
        this.f11620a = tArr3;
        return tArr3;
    }

    private final void j(int i10) {
        this._size = i10;
    }

    private final void k(int i10) {
        while (true) {
            int i11 = (i10 * 2) + 1;
            if (i11 >= c()) {
                return;
            }
            T[] tArr = this.f11620a;
            y8.k.b(tArr);
            int i12 = i11 + 1;
            if (i12 < c()) {
                T t10 = tArr[i12];
                y8.k.b(t10);
                T t11 = tArr[i11];
                y8.k.b(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    i11 = i12;
                }
            }
            T t12 = tArr[i10];
            y8.k.b(t12);
            T t13 = tArr[i11];
            y8.k.b(t13);
            if (((Comparable) t12).compareTo(t13) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    private final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f11620a;
            y8.k.b(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            y8.k.b(t10);
            T t11 = tArr[i10];
            y8.k.b(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    private final void m(int i10, int i11) {
        T[] tArr = this.f11620a;
        y8.k.b(tArr);
        T t10 = tArr[i11];
        y8.k.b(t10);
        T t11 = tArr[i10];
        y8.k.b(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.k(i10);
        t11.k(i11);
    }

    public final void a(T t10) {
        if (nb.d0.a()) {
            if (!(t10.o() == null)) {
                throw new AssertionError();
            }
        }
        t10.l(this);
        T[] f10 = f();
        int c10 = c();
        j(c10 + 1);
        f10[c10] = t10;
        t10.k(c10);
        l(c10);
    }

    public final T b() {
        T[] tArr = this.f11620a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b10;
        synchronized (this) {
            b10 = b();
        }
        return b10;
    }

    public final boolean g(T t10) {
        boolean z10;
        synchronized (this) {
            z10 = true;
            if (t10.o() == null) {
                z10 = false;
            } else {
                int j10 = t10.j();
                if (nb.d0.a()) {
                    if (!(j10 >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(j10);
            }
        }
        return z10;
    }

    public final T h(int i10) {
        if (nb.d0.a()) {
            if (!(c() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f11620a;
        y8.k.b(tArr);
        j(c() - 1);
        if (i10 < c()) {
            m(i10, c());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                T t10 = tArr[i10];
                y8.k.b(t10);
                T t11 = tArr[i11];
                y8.k.b(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    m(i10, i11);
                    l(i11);
                }
            }
            k(i10);
        }
        T t12 = tArr[c()];
        y8.k.b(t12);
        if (nb.d0.a()) {
            if (!(t12.o() == this)) {
                throw new AssertionError();
            }
        }
        t12.l(null);
        t12.k(-1);
        tArr[c()] = null;
        return t12;
    }

    public final T i() {
        T h10;
        synchronized (this) {
            h10 = c() > 0 ? h(0) : null;
        }
        return h10;
    }
}
