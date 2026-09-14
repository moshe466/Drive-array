package m8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes.dex */
public class y extends x {

    /* loaded from: classes.dex */
    public static final class a<T> implements lb.h<T> {

        /* renamed from: a */
        final /* synthetic */ Iterable f12048a;

        public a(Iterable iterable) {
            this.f12048a = iterable;
        }

        @Override // lb.h
        public Iterator<T> iterator() {
            return this.f12048a.iterator();
        }
    }

    /* loaded from: classes.dex */
    public static final class b<T> extends y8.l implements x8.a<Iterator<? extends T>> {

        /* renamed from: f */
        final /* synthetic */ Iterable<T> f12049f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Iterable<? extends T> iterable) {
            super(0);
            this.f12049f = iterable;
        }

        @Override // x8.a
        /* renamed from: a */
        public final Iterator<T> b() {
            return this.f12049f.iterator();
        }
    }

    public static <T> lb.h<T> A(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> boolean B(Iterable<? extends T> iterable, T t10) {
        y8.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t10) : L(iterable, t10) >= 0;
    }

    public static <T> List<T> C(Iterable<? extends T> iterable) {
        Set q02;
        List<T> n02;
        y8.k.e(iterable, "<this>");
        q02 = q0(iterable);
        n02 = n0(q02);
        return n02;
    }

    public static <T> List<T> D(Iterable<? extends T> iterable, int i10) {
        ArrayList arrayList;
        List<T> k10;
        List<T> b10;
        List<T> d10;
        List<T> n02;
        y8.k.e(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            n02 = n0(iterable);
            return n02;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i10;
            if (size <= 0) {
                d10 = q.d();
                return d10;
            }
            if (size == 1) {
                b10 = p.b(o.R(iterable));
                return b10;
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i10 < size2) {
                        arrayList.add(((List) iterable).get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t10 : iterable) {
            if (i11 >= i10) {
                arrayList.add(t10);
            } else {
                i11++;
            }
        }
        k10 = q.k(arrayList);
        return k10;
    }

    public static <T> List<T> E(List<? extends T> list, int i10) {
        int a10;
        y8.k.e(list, "<this>");
        if (i10 >= 0) {
            a10 = d9.f.a(list.size() - i10, 0);
            return i0(list, a10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> List<T> F(Iterable<? extends T> iterable, x8.l<? super T, Boolean> lVar) {
        y8.k.e(iterable, "<this>");
        y8.k.e(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (lVar.h(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static <T> T G(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) o.H((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T H(List<? extends T> list) {
        y8.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T I(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T J(List<? extends T> list) {
        y8.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T K(List<? extends T> list, int i10) {
        y8.k.e(list, "<this>");
        if (i10 < 0 || i10 > q.f(list)) {
            return null;
        }
        return list.get(i10);
    }

    public static final <T> int L(Iterable<? extends T> iterable, T t10) {
        y8.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                q.m();
            }
            if (y8.k.a(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> Set<T> M(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Set<T> q02;
        y8.k.e(iterable, "<this>");
        y8.k.e(iterable2, "other");
        q02 = q0(iterable);
        v.t(q02, iterable2);
        return q02;
    }

    public static final <T, A extends Appendable> A N(Iterable<? extends T> iterable, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, x8.l<? super T, ? extends CharSequence> lVar) {
        y8.k.e(iterable, "<this>");
        y8.k.e(a10, "buffer");
        y8.k.e(charSequence, "separator");
        y8.k.e(charSequence2, "prefix");
        y8.k.e(charSequence3, "postfix");
        y8.k.e(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : iterable) {
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

    public static /* synthetic */ Appendable O(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, x8.l lVar, int i11, Object obj) {
        return N(iterable, appendable, (i11 & 2) != 0 ? ", " : charSequence, (i11 & 4) != 0 ? "" : charSequence2, (i11 & 8) == 0 ? charSequence3 : "", (i11 & 16) != 0 ? -1 : i10, (i11 & 32) != 0 ? "..." : charSequence4, (i11 & 64) != 0 ? null : lVar);
    }

    public static <T> String P(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, x8.l<? super T, ? extends CharSequence> lVar) {
        y8.k.e(iterable, "<this>");
        y8.k.e(charSequence, "separator");
        y8.k.e(charSequence2, "prefix");
        y8.k.e(charSequence3, "postfix");
        y8.k.e(charSequence4, "truncated");
        String sb2 = ((StringBuilder) N(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        y8.k.d(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String Q(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, x8.l lVar, int i11, Object obj) {
        String P;
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
        P = P(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
        return P;
    }

    public static <T> T R(Iterable<? extends T> iterable) {
        T next;
        y8.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) o.S((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T S(List<? extends T> list) {
        y8.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(q.f(list));
    }

    public static <T> T T(Iterable<? extends T> iterable) {
        T next;
        y8.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T U(List<? extends T> list) {
        y8.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T, R> List<R> V(Iterable<? extends T> iterable, x8.l<? super T, ? extends R> lVar) {
        int n10;
        y8.k.e(iterable, "<this>");
        y8.k.e(lVar, "transform");
        n10 = r.n(iterable, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(lVar.h(it.next()));
        }
        return arrayList;
    }

    public static <T extends Comparable<? super T>> T W(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> X(Iterable<? extends T> iterable, T t10) {
        int n10;
        y8.k.e(iterable, "<this>");
        n10 = r.n(iterable, 10);
        ArrayList arrayList = new ArrayList(n10);
        boolean z10 = false;
        for (T t11 : iterable) {
            boolean z11 = true;
            if (!z10 && y8.k.a(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(t11);
            }
        }
        return arrayList;
    }

    public static <T> List<T> Y(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        List<T> a02;
        y8.k.e(iterable, "<this>");
        y8.k.e(iterable2, "elements");
        if (iterable instanceof Collection) {
            a02 = a0((Collection) iterable, iterable2);
            return a02;
        }
        ArrayList arrayList = new ArrayList();
        v.r(arrayList, iterable);
        v.r(arrayList, iterable2);
        return arrayList;
    }

    public static <T> List<T> Z(Iterable<? extends T> iterable, T t10) {
        List<T> b02;
        y8.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            b02 = b0((Collection) iterable, t10);
            return b02;
        }
        ArrayList arrayList = new ArrayList();
        v.r(arrayList, iterable);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> List<T> a0(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        y8.k.e(collection, "<this>");
        y8.k.e(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            v.r(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static <T> List<T> b0(Collection<? extends T> collection, T t10) {
        y8.k.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> T c0(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) o.d0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static <T> T d0(List<? extends T> list) {
        y8.k.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T> T e0(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> T f0(List<? extends T> list) {
        y8.k.e(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T extends Comparable<? super T>> List<T> g0(Iterable<? extends T> iterable) {
        List<T> c10;
        List<T> n02;
        y8.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> o02 = o0(iterable);
            u.p(o02);
            return o02;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            n02 = n0(iterable);
            return n02;
        }
        Object[] array = collection.toArray(new Comparable[0]);
        y8.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        y8.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sorted>");
        Comparable[] comparableArr = (Comparable[]) array;
        j.h(comparableArr);
        c10 = j.c(comparableArr);
        return c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> h0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        List<T> c10;
        List<T> n02;
        y8.k.e(iterable, "<this>");
        y8.k.e(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> o02 = o0(iterable);
            u.q(o02, comparator);
            return o02;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            n02 = n0(iterable);
            return n02;
        }
        Object[] array = collection.toArray(new Object[0]);
        y8.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        y8.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sortedWith>");
        j.i(array, comparator);
        c10 = j.c(array);
        return c10;
    }

    public static final <T> List<T> i0(Iterable<? extends T> iterable, int i10) {
        List<T> k10;
        List<T> b10;
        List<T> n02;
        List<T> d10;
        y8.k.e(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            d10 = q.d();
            return d10;
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                n02 = n0(iterable);
                return n02;
            }
            if (i10 == 1) {
                b10 = p.b(o.G(iterable));
                return b10;
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        k10 = q.k(arrayList);
        return k10;
    }

    public static <T> List<T> j0(List<? extends T> list, int i10) {
        List<T> b10;
        List<T> n02;
        List<T> d10;
        y8.k.e(list, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            d10 = q.d();
            return d10;
        }
        int size = list.size();
        if (i10 >= size) {
            n02 = n0(list);
            return n02;
        }
        if (i10 == 1) {
            b10 = p.b(o.S(list));
            return b10;
        }
        ArrayList arrayList = new ArrayList(i10);
        if (list instanceof RandomAccess) {
            for (int i11 = size - i10; i11 < size; i11++) {
                arrayList.add(list.get(i11));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C k0(Iterable<? extends T> iterable, C c10) {
        y8.k.e(iterable, "<this>");
        y8.k.e(c10, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c10.add(it.next());
        }
        return c10;
    }

    public static final <T> HashSet<T> l0(Iterable<? extends T> iterable) {
        int n10;
        int d10;
        y8.k.e(iterable, "<this>");
        n10 = r.n(iterable, 12);
        d10 = k0.d(n10);
        return (HashSet) k0(iterable, new HashSet(d10));
    }

    public static int[] m0(Collection<Integer> collection) {
        y8.k.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    public static <T> List<T> n0(Iterable<? extends T> iterable) {
        List<T> k10;
        List<T> d10;
        List<T> b10;
        y8.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            k10 = q.k(o0(iterable));
            return k10;
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            d10 = q.d();
            return d10;
        }
        if (size != 1) {
            return p0(collection);
        }
        b10 = p.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        return b10;
    }

    public static final <T> List<T> o0(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        return iterable instanceof Collection ? p0((Collection) iterable) : (List) k0(iterable, new ArrayList());
    }

    public static final <T> List<T> p0(Collection<? extends T> collection) {
        y8.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> q0(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) k0(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> r0(Iterable<? extends T> iterable) {
        Set<T> b10;
        Set<T> a10;
        int d10;
        y8.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return r0.d((Set) k0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            b10 = r0.b();
            return b10;
        }
        if (size != 1) {
            d10 = k0.d(collection.size());
            return (Set) k0(iterable, new LinkedHashSet(d10));
        }
        a10 = q0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        return a10;
    }

    public static <T> Set<T> s0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Set<T> q02;
        y8.k.e(iterable, "<this>");
        y8.k.e(iterable2, "other");
        q02 = q0(iterable);
        v.r(q02, iterable2);
        return q02;
    }

    public static <T> Iterable<d0<T>> t0(Iterable<? extends T> iterable) {
        y8.k.e(iterable, "<this>");
        return new e0(new b(iterable));
    }

    public static <T, R> List<l8.n<T, R>> u0(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        int n10;
        int n11;
        y8.k.e(iterable, "<this>");
        y8.k.e(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        n10 = r.n(iterable, 10);
        n11 = r.n(iterable2, 10);
        ArrayList arrayList = new ArrayList(Math.min(n10, n11));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(l8.t.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> boolean z(Iterable<? extends T> iterable, x8.l<? super T, Boolean> lVar) {
        y8.k.e(iterable, "<this>");
        y8.k.e(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!lVar.h(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
