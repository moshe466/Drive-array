package m8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {

    /* loaded from: classes.dex */
    public static final class a extends b<Integer> implements RandomAccess {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int[] f12042g;

        a(int[] iArr) {
            this.f12042g = iArr;
        }

        @Override // m8.a
        public int c() {
            return this.f12042g.length;
        }

        @Override // m8.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return f(((Number) obj).intValue());
            }
            return false;
        }

        public boolean f(int i10) {
            return k.l(this.f12042g, i10);
        }

        @Override // m8.b, java.util.List
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer get(int i10) {
            return Integer.valueOf(this.f12042g[i10]);
        }

        @Override // m8.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return j(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // m8.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12042g.length == 0;
        }

        public int j(int i10) {
            return k.u(this.f12042g, i10);
        }

        @Override // m8.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return s(((Number) obj).intValue());
            }
            return -1;
        }

        public int s(int i10) {
            return k.A(this.f12042g, i10);
        }
    }

    public static List<Integer> b(int[] iArr) {
        y8.k.e(iArr, "<this>");
        return new a(iArr);
    }

    public static <T> List<T> c(T[] tArr) {
        y8.k.e(tArr, "<this>");
        List<T> a10 = l.a(tArr);
        y8.k.d(a10, "asList(this)");
        return a10;
    }

    public static final <T> T[] d(T[] tArr, T[] tArr2, int i10, int i11, int i12) {
        y8.k.e(tArr, "<this>");
        y8.k.e(tArr2, "destination");
        System.arraycopy(tArr, i11, tArr2, i10, i12 - i11);
        return tArr2;
    }

    public static /* synthetic */ Object[] e(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return d(objArr, objArr2, i10, i11, i12);
    }

    public static <T> T[] f(T[] tArr, int i10, int i11) {
        y8.k.e(tArr, "<this>");
        h.a(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        y8.k.d(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static void g(int[] iArr, int i10, int i11, int i12) {
        y8.k.e(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    public static final <T> void h(T[] tArr) {
        y8.k.e(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void i(T[] tArr, Comparator<? super T> comparator) {
        y8.k.e(tArr, "<this>");
        y8.k.e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
