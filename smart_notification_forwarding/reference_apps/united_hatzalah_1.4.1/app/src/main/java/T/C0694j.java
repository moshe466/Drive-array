package t;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import t2.AbstractC0705g;
import u.AbstractC0717a;

/* renamed from: t.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0694j {

    /* renamed from: a, reason: collision with root package name */
    public int[] f6364a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f6365b;

    /* renamed from: c, reason: collision with root package name */
    public int f6366c;

    public C0694j(int i) {
        int[] iArr;
        Object[] objArr;
        if (i == 0) {
            iArr = AbstractC0717a.f6499a;
        } else {
            iArr = new int[i];
        }
        this.f6364a = iArr;
        if (i == 0) {
            objArr = AbstractC0717a.f6500b;
        } else {
            objArr = new Object[i << 1];
        }
        this.f6365b = objArr;
    }

    public final int a(Object obj) {
        int i = this.f6366c * 2;
        Object[] objArr = this.f6365b;
        if (obj == null) {
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i) {
        int i3 = this.f6366c;
        int[] iArr = this.f6364a;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, i);
            kotlin.jvm.internal.j.d(copyOf, "copyOf(this, newSize)");
            this.f6364a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6365b, i * 2);
            kotlin.jvm.internal.j.d(copyOf2, "copyOf(this, newSize)");
            this.f6365b = copyOf2;
        }
        if (this.f6366c == i3) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i, Object obj) {
        int i3 = this.f6366c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = AbstractC0717a.a(i3, i, this.f6364a);
        if (a2 < 0 || kotlin.jvm.internal.j.a(obj, this.f6365b[a2 << 1])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f6364a[i4] == i) {
            if (kotlin.jvm.internal.j.a(obj, this.f6365b[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f6364a[i5] == i; i5--) {
            if (kotlin.jvm.internal.j.a(obj, this.f6365b[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public final void clear() {
        if (this.f6366c > 0) {
            this.f6364a = AbstractC0717a.f6499a;
            this.f6365b = AbstractC0717a.f6500b;
            this.f6366c = 0;
        }
        if (this.f6366c <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        if (d(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (a(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final int d(Object obj) {
        if (obj == null) {
            return e();
        }
        return c(obj.hashCode(), obj);
    }

    public final int e() {
        int i = this.f6366c;
        if (i == 0) {
            return -1;
        }
        int a2 = AbstractC0717a.a(i, 0, this.f6364a);
        if (a2 < 0 || this.f6365b[a2 << 1] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i && this.f6364a[i3] == 0) {
            if (this.f6365b[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f6364a[i4] == 0; i4--) {
            if (this.f6365b[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof C0694j) {
                int i = this.f6366c;
                if (i != ((C0694j) obj).f6366c) {
                    return false;
                }
                C0694j c0694j = (C0694j) obj;
                for (int i3 = 0; i3 < i; i3++) {
                    Object f4 = f(i3);
                    Object i4 = i(i3);
                    Object obj2 = c0694j.get(f4);
                    if (i4 == null) {
                        if (obj2 != null || !c0694j.containsKey(f4)) {
                            return false;
                        }
                    } else if (!i4.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f6366c != ((Map) obj).size()) {
                return false;
            }
            int i5 = this.f6366c;
            for (int i6 = 0; i6 < i5; i6++) {
                Object f5 = f(i6);
                Object i7 = i(i6);
                Object obj3 = ((Map) obj).get(f5);
                if (i7 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(f5)) {
                        return false;
                    }
                } else if (!i7.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        if (i >= 0 && i < this.f6366c) {
            return this.f6365b[i << 1];
        }
        throw new IllegalArgumentException(e0.a.c(i, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final Object g(int i) {
        int i3;
        if (i >= 0 && i < (i3 = this.f6366c)) {
            Object[] objArr = this.f6365b;
            int i4 = i << 1;
            Object obj = objArr[i4 + 1];
            if (i3 <= 1) {
                clear();
                return obj;
            }
            int i5 = i3 - 1;
            int[] iArr = this.f6364a;
            int i6 = 8;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                int[] copyOf = Arrays.copyOf(iArr, i6);
                kotlin.jvm.internal.j.d(copyOf, "copyOf(this, newSize)");
                this.f6364a = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.f6365b, i6 << 1);
                kotlin.jvm.internal.j.d(copyOf2, "copyOf(this, newSize)");
                this.f6365b = copyOf2;
                if (i3 == this.f6366c) {
                    if (i > 0) {
                        AbstractC0705g.D(0, 0, iArr, this.f6364a, i);
                        AbstractC0705g.E(objArr, 0, this.f6365b, 0, i4);
                    }
                    if (i < i5) {
                        int i7 = i + 1;
                        AbstractC0705g.D(i, i7, iArr, this.f6364a, i3);
                        AbstractC0705g.E(objArr, i4, this.f6365b, i7 << 1, i3 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    AbstractC0705g.D(i, i8, iArr, iArr, i3);
                    Object[] objArr2 = this.f6365b;
                    AbstractC0705g.E(objArr2, i4, objArr2, i8 << 1, i3 << 1);
                }
                Object[] objArr3 = this.f6365b;
                int i9 = i5 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            }
            if (i3 == this.f6366c) {
                this.f6366c = i5;
                return obj;
            }
            throw new ConcurrentModificationException();
        }
        throw new IllegalArgumentException(e0.a.c(i, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public Object get(Object obj) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return this.f6365b[(d2 << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return this.f6365b[(d2 << 1) + 1];
        }
        return obj2;
    }

    public final Object h(int i, Object obj) {
        if (i >= 0 && i < this.f6366c) {
            int i3 = (i << 1) + 1;
            Object[] objArr = this.f6365b;
            Object obj2 = objArr[i3];
            objArr[i3] = obj;
            return obj2;
        }
        throw new IllegalArgumentException(e0.a.c(i, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final int hashCode() {
        int i;
        int[] iArr = this.f6364a;
        Object[] objArr = this.f6365b;
        int i3 = this.f6366c;
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            int i7 = iArr[i5];
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i6 += i ^ i7;
            i5++;
            i4 += 2;
        }
        return i6;
    }

    public final Object i(int i) {
        if (i >= 0 && i < this.f6366c) {
            return this.f6365b[(i << 1) + 1];
        }
        throw new IllegalArgumentException(e0.a.c(i, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final boolean isEmpty() {
        if (this.f6366c <= 0) {
            return true;
        }
        return false;
    }

    public final Object put(Object obj, Object obj2) {
        int i;
        int e4;
        int i3 = this.f6366c;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        if (obj != null) {
            e4 = c(i, obj);
        } else {
            e4 = e();
        }
        if (e4 >= 0) {
            int i4 = (e4 << 1) + 1;
            Object[] objArr = this.f6365b;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~e4;
        int[] iArr = this.f6364a;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i6);
            kotlin.jvm.internal.j.d(copyOf, "copyOf(this, newSize)");
            this.f6364a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6365b, i6 << 1);
            kotlin.jvm.internal.j.d(copyOf2, "copyOf(this, newSize)");
            this.f6365b = copyOf2;
            if (i3 != this.f6366c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr2 = this.f6364a;
            int i7 = i5 + 1;
            AbstractC0705g.D(i7, i5, iArr2, iArr2, i3);
            Object[] objArr2 = this.f6365b;
            AbstractC0705g.E(objArr2, i7 << 1, objArr2, i5 << 1, this.f6366c << 1);
        }
        int i8 = this.f6366c;
        if (i3 == i8) {
            int[] iArr3 = this.f6364a;
            if (i5 < iArr3.length) {
                iArr3[i5] = i;
                Object[] objArr3 = this.f6365b;
                int i9 = i5 << 1;
                objArr3[i9] = obj;
                objArr3[i9 + 1] = obj2;
                this.f6366c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 == null) {
            return put(obj, obj2);
        }
        return obj3;
    }

    public Object remove(Object obj) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return g(d2);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return h(d2, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f6366c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6366c * 28);
        sb.append('{');
        int i = this.f6366c;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object f4 = f(i3);
            if (f4 != sb) {
                sb.append(f4);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object i4 = i(i3);
            if (i4 != sb) {
                sb.append(i4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final boolean remove(Object obj, Object obj2) {
        int d2 = d(obj);
        if (d2 < 0 || !kotlin.jvm.internal.j.a(obj2, i(d2))) {
            return false;
        }
        g(d2);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int d2 = d(obj);
        if (d2 < 0 || !kotlin.jvm.internal.j.a(obj2, i(d2))) {
            return false;
        }
        h(d2, obj3);
        return true;
    }
}
