package t2;

import F0.AbstractC0008a;
import a.AbstractC0228a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: t2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0707i extends AbstractC0714p {
    public static boolean b0(Iterable iterable, Object obj) {
        int i;
        kotlin.jvm.internal.j.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (iterable instanceof List) {
            i = ((List) iterable).indexOf(obj);
        } else {
            Iterator it = iterable.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    if (i3 >= 0) {
                        if (kotlin.jvm.internal.j.a(obj, next)) {
                            i = i3;
                            break;
                        }
                        i3++;
                    } else {
                        AbstractC0708j.X();
                        throw null;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
        }
        if (i < 0) {
            return false;
        }
        return true;
    }

    public static List c0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        int size = list.size() - 1;
        if (size < 0) {
            size = 0;
        }
        return m0(size, list);
    }

    public static ArrayList d0(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object e0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object f0(Set set) {
        kotlin.jvm.internal.j.e(set, "<this>");
        if (set instanceof List) {
            List list = (List) set;
            if (!list.isEmpty()) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = set.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static final void g0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, F2.l lVar) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            AbstractC0228a.b(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String h0(Iterable iterable, String str, String str2, String str3, F2.l lVar, int i) {
        String prefix;
        String postfix;
        if ((i & 1) != 0) {
            str = ", ";
        }
        String separator = str;
        if ((i & 2) != 0) {
            prefix = "";
        } else {
            prefix = str2;
        }
        if ((i & 4) != 0) {
            postfix = "";
        } else {
            postfix = str3;
        }
        if ((i & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.j.e(iterable, "<this>");
        kotlin.jvm.internal.j.e(separator, "separator");
        kotlin.jvm.internal.j.e(prefix, "prefix");
        kotlin.jvm.internal.j.e(postfix, "postfix");
        StringBuilder sb = new StringBuilder();
        g0(iterable, sb, separator, prefix, postfix, "...", lVar);
        return sb.toString();
    }

    public static Object i0(List list) {
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static ArrayList j0(List list, Collection collection) {
        kotlin.jvm.internal.j.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(list.size() + collection.size());
        arrayList.addAll(collection);
        arrayList.addAll(list);
        return arrayList;
    }

    public static List k0(ArrayList arrayList) {
        kotlin.jvm.internal.j.e(arrayList, "<this>");
        if (arrayList.size() <= 1) {
            return q0(arrayList);
        }
        Object[] array = arrayList.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        kotlin.jvm.internal.j.e(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return AbstractC0705g.B(array);
    }

    public static List l0(Comparator comparator, Iterable iterable) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return q0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            kotlin.jvm.internal.j.e(array, "<this>");
            if (array.length > 1) {
                Arrays.sort(array, comparator);
            }
            return AbstractC0705g.B(array);
        }
        List t02 = t0(iterable);
        if (((ArrayList) t02).size() > 1) {
            Collections.sort(t02, comparator);
        }
        return t02;
    }

    public static List m0(int i, List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        if (i >= 0) {
            C0716r c0716r = C0716r.f6476a;
            if (i == 0) {
                return c0716r;
            }
            if (i >= list.size()) {
                return q0(list);
            }
            if (i == 1) {
                if (!list.isEmpty()) {
                    return T.b.B(list.get(0));
                }
                throw new NoSuchElementException("List is empty.");
            }
            ArrayList arrayList = new ArrayList(i);
            Iterator it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                arrayList.add(it.next());
                i3++;
                if (i3 == i) {
                    break;
                }
            }
            int size = arrayList.size();
            if (size != 0) {
                if (size != 1) {
                    return arrayList;
                }
                return T.b.B(arrayList.get(0));
            }
            return c0716r;
        }
        throw new IllegalArgumentException(AbstractC0008a.j(i, "Requested element count ", " is less than zero.").toString());
    }

    public static byte[] n0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        byte[] bArr = new byte[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((Number) it.next()).byteValue();
            i++;
        }
        return bArr;
    }

    public static final void o0(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] p0(ArrayList arrayList) {
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            iArr[i] = ((Number) obj).intValue();
            i++;
        }
        return iArr;
    }

    public static List q0(Iterable iterable) {
        Object next;
        kotlin.jvm.internal.j.e(iterable, "<this>");
        boolean z3 = iterable instanceof Collection;
        C0716r c0716r = C0716r.f6476a;
        if (z3) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return s0(collection);
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = collection.iterator().next();
                }
                return T.b.B(next);
            }
            return c0716r;
        }
        List t02 = t0(iterable);
        ArrayList arrayList = (ArrayList) t02;
        int size2 = arrayList.size();
        if (size2 != 0) {
            if (size2 != 1) {
                return t02;
            }
            return T.b.B(arrayList.get(0));
        }
        return c0716r;
    }

    public static long[] r0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        long[] jArr = new long[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = ((Number) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public static ArrayList s0(Collection collection) {
        kotlin.jvm.internal.j.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List t0(Iterable iterable) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return s0((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        o0(iterable, arrayList);
        return arrayList;
    }

    public static Set u0(Collection collection) {
        Object next;
        kotlin.jvm.internal.j.e(collection, "<this>");
        int size = collection.size();
        if (size != 0) {
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(u.F(collection.size()));
                o0(collection, linkedHashSet);
                return linkedHashSet;
            }
            if (collection instanceof List) {
                next = ((List) collection).get(0);
            } else {
                next = collection.iterator().next();
            }
            return m3.b.M(next);
        }
        return t.f6478a;
    }

    public static ArrayList v0(ArrayList arrayList, F2.l lVar) {
        int i = 1;
        p3.h.g(2, 1);
        int size = arrayList.size();
        if (size % 1 == 0) {
            i = 0;
        }
        ArrayList arrayList2 = new ArrayList(i + size);
        C0700b c0700b = new C0700b(arrayList);
        for (int i3 = 0; i3 >= 0 && i3 < size; i3++) {
            int i4 = size - i3;
            if (2 <= i4) {
                i4 = 2;
            }
            if (i4 < 2) {
                break;
            }
            int i5 = i4 + i3;
            p3.h.f(i3, i5, ((ArrayList) c0700b.f6466d).size());
            c0700b.f6464b = i3;
            c0700b.f6465c = i5 - i3;
            arrayList2.add(lVar.invoke(c0700b));
        }
        return arrayList2;
    }
}
