package m8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public class k extends j {

    /* loaded from: classes.dex */
    public static final class a<T> implements Iterable<T>, z8.a {

        /* renamed from: f */
        final /* synthetic */ Object[] f12043f;

        public a(Object[] objArr) {
            this.f12043f = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return y8.b.a(this.f12043f);
        }
    }

    /* loaded from: classes.dex */
    public static final class b<T> implements lb.h<T> {

        /* renamed from: a */
        final /* synthetic */ Object[] f12044a;

        public b(Object[] objArr) {
            this.f12044a = objArr;
        }

        @Override // lb.h
        public Iterator<T> iterator() {
            return y8.b.a(this.f12044a);
        }
    }

    /* loaded from: classes.dex */
    public static final class c<T> extends y8.l implements x8.a<Iterator<? extends T>> {

        /* renamed from: f */
        final /* synthetic */ T[] f12045f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(T[] tArr) {
            super(0);
            this.f12045f = tArr;
        }

        @Override // x8.a
        /* renamed from: a */
        public final Iterator<T> b() {
            return y8.b.a(this.f12045f);
        }
    }

    public static final int A(int[] iArr, int i10) {
        y8.k.e(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (i10 == iArr[length]) {
                    return length;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return -1;
    }

    public static <T, R> List<R> B(T[] tArr, x8.l<? super T, ? extends R> lVar) {
        y8.k.e(tArr, "<this>");
        y8.k.e(lVar, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t10 : tArr) {
            arrayList.add(lVar.h(t10));
        }
        return arrayList;
    }

    public static char C(char[] cArr) {
        y8.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T D(T[] tArr) {
        y8.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T E(T[] tArr) {
        y8.k.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] F(T[] tArr, Comparator<? super T> comparator) {
        y8.k.e(tArr, "<this>");
        y8.k.e(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        y8.k.d(tArr2, "copyOf(this, size)");
        j.i(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> G(T[] tArr, Comparator<? super T> comparator) {
        List<T> c10;
        y8.k.e(tArr, "<this>");
        y8.k.e(comparator, "comparator");
        c10 = j.c(F(tArr, comparator));
        return c10;
    }

    public static final <T, C extends Collection<? super T>> C H(T[] tArr, C c10) {
        y8.k.e(tArr, "<this>");
        y8.k.e(c10, "destination");
        for (T t10 : tArr) {
            c10.add(t10);
        }
        return c10;
    }

    public static List<Byte> I(byte[] bArr) {
        List<Byte> d10;
        List<Byte> b10;
        y8.k.e(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return R(bArr);
        }
        b10 = p.b(Byte.valueOf(bArr[0]));
        return b10;
    }

    public static List<Character> J(char[] cArr) {
        List<Character> d10;
        List<Character> b10;
        y8.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return S(cArr);
        }
        b10 = p.b(Character.valueOf(cArr[0]));
        return b10;
    }

    public static List<Double> K(double[] dArr) {
        List<Double> d10;
        List<Double> b10;
        y8.k.e(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return T(dArr);
        }
        b10 = p.b(Double.valueOf(dArr[0]));
        return b10;
    }

    public static List<Float> L(float[] fArr) {
        List<Float> d10;
        List<Float> b10;
        y8.k.e(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return U(fArr);
        }
        b10 = p.b(Float.valueOf(fArr[0]));
        return b10;
    }

    public static List<Integer> M(int[] iArr) {
        List<Integer> d10;
        List<Integer> b10;
        y8.k.e(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return V(iArr);
        }
        b10 = p.b(Integer.valueOf(iArr[0]));
        return b10;
    }

    public static List<Long> N(long[] jArr) {
        List<Long> d10;
        List<Long> b10;
        y8.k.e(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return W(jArr);
        }
        b10 = p.b(Long.valueOf(jArr[0]));
        return b10;
    }

    public static <T> List<T> O(T[] tArr) {
        List<T> d10;
        List<T> b10;
        y8.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return X(tArr);
        }
        b10 = p.b(tArr[0]);
        return b10;
    }

    public static List<Short> P(short[] sArr) {
        List<Short> d10;
        List<Short> b10;
        y8.k.e(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return Y(sArr);
        }
        b10 = p.b(Short.valueOf(sArr[0]));
        return b10;
    }

    public static List<Boolean> Q(boolean[] zArr) {
        List<Boolean> d10;
        List<Boolean> b10;
        y8.k.e(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        if (length != 1) {
            return Z(zArr);
        }
        b10 = p.b(Boolean.valueOf(zArr[0]));
        return b10;
    }

    public static final List<Byte> R(byte[] bArr) {
        y8.k.e(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    public static final List<Character> S(char[] cArr) {
        y8.k.e(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    public static final List<Double> T(double[] dArr) {
        y8.k.e(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    public static final List<Float> U(float[] fArr) {
        y8.k.e(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    public static final List<Integer> V(int[] iArr) {
        y8.k.e(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static final List<Long> W(long[] jArr) {
        y8.k.e(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static final <T> List<T> X(T[] tArr) {
        y8.k.e(tArr, "<this>");
        return new ArrayList(q.c(tArr));
    }

    public static final List<Short> Y(short[] sArr) {
        y8.k.e(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    public static final List<Boolean> Z(boolean[] zArr) {
        y8.k.e(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    public static <T> Set<T> a0(T[] tArr) {
        Set<T> b10;
        Set<T> a10;
        int d10;
        y8.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            b10 = r0.b();
            return b10;
        }
        if (length != 1) {
            d10 = k0.d(tArr.length);
            return (Set) H(tArr, new LinkedHashSet(d10));
        }
        a10 = q0.a(tArr[0]);
        return a10;
    }

    public static <T> Iterable<d0<T>> b0(T[] tArr) {
        y8.k.e(tArr, "<this>");
        return new e0(new c(tArr));
    }

    public static <T, R> List<l8.n<T, R>> c0(T[] tArr, R[] rArr) {
        y8.k.e(tArr, "<this>");
        y8.k.e(rArr, "other");
        int min = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i10 = 0; i10 < min; i10++) {
            arrayList.add(l8.t.a(tArr[i10], rArr[i10]));
        }
        return arrayList;
    }

    public static <T> Iterable<T> j(T[] tArr) {
        List d10;
        y8.k.e(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return new a(tArr);
        }
        d10 = q.d();
        return d10;
    }

    public static <T> lb.h<T> k(T[] tArr) {
        lb.h<T> c10;
        y8.k.e(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return new b(tArr);
        }
        c10 = lb.l.c();
        return c10;
    }

    public static final boolean l(int[] iArr, int i10) {
        y8.k.e(iArr, "<this>");
        return u(iArr, i10) >= 0;
    }

    public static <T> boolean m(T[] tArr, T t10) {
        int v10;
        y8.k.e(tArr, "<this>");
        v10 = v(tArr, t10);
        return v10 >= 0;
    }

    public static <T> List<T> n(T[] tArr) {
        y8.k.e(tArr, "<this>");
        return (List) o(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C o(T[] tArr, C c10) {
        y8.k.e(tArr, "<this>");
        y8.k.e(c10, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }

    public static <T> T p(T[] tArr) {
        y8.k.e(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static <T> T q(T[] tArr) {
        y8.k.e(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final int r(int[] iArr) {
        y8.k.e(iArr, "<this>");
        return iArr.length - 1;
    }

    public static <T> int s(T[] tArr) {
        y8.k.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static Integer t(int[] iArr, int i10) {
        y8.k.e(iArr, "<this>");
        if (i10 < 0 || i10 > r(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i10]);
    }

    public static final int u(int[] iArr, int i10) {
        y8.k.e(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static <T> int v(T[] tArr, T t10) {
        y8.k.e(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (y8.k.a(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A w(T[] tArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, x8.l<? super T, ? extends CharSequence> lVar) {
        y8.k.e(tArr, "<this>");
        y8.k.e(a10, "buffer");
        y8.k.e(charSequence, "separator");
        y8.k.e(charSequence2, "prefix");
        y8.k.e(charSequence3, "postfix");
        y8.k.e(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            mb.j.a(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <T> String x(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, x8.l<? super T, ? extends CharSequence> lVar) {
        y8.k.e(tArr, "<this>");
        y8.k.e(charSequence, "separator");
        y8.k.e(charSequence2, "prefix");
        y8.k.e(charSequence3, "postfix");
        y8.k.e(charSequence4, "truncated");
        String sb2 = ((StringBuilder) w(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        y8.k.d(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String y(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, x8.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return x(objArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static <T> T z(T[] tArr) {
        int s10;
        y8.k.e(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        s10 = s(tArr);
        return tArr[s10];
    }
}
