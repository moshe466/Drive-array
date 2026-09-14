package t2;

import a.AbstractC0228a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: t2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0705g extends E1.b {
    public static List B(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        List asList = Arrays.asList(objArr);
        kotlin.jvm.internal.j.d(asList, "asList(...)");
        return asList;
    }

    public static boolean C(Object[] objArr, Object obj) {
        int i;
        kotlin.jvm.internal.j.e(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i = 0;
            while (i < length) {
                if (objArr[i] == null) {
                    break;
                }
                i++;
            }
            i = -1;
        } else {
            int length2 = objArr.length;
            for (int i3 = 0; i3 < length2; i3++) {
                if (obj.equals(objArr[i3])) {
                    i = i3;
                    break;
                }
            }
            i = -1;
        }
        if (i < 0) {
            return false;
        }
        return true;
    }

    public static void D(int i, int i3, int[] iArr, int[] destination, int i4) {
        kotlin.jvm.internal.j.e(iArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(iArr, i3, destination, i, i4 - i3);
    }

    public static void E(Object[] objArr, int i, Object[] destination, int i3, int i4) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(objArr, i3, destination, i, i4 - i3);
    }

    public static /* synthetic */ void F(Object[] objArr, int i, Object[] objArr2, int i3, int i4) {
        if ((i4 & 4) != 0) {
            i = 0;
        }
        E(objArr, 0, objArr2, i, i3);
    }

    public static byte[] G(byte[] bArr, int i, int i3) {
        kotlin.jvm.internal.j.e(bArr, "<this>");
        E1.b.d(i3, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i3);
        kotlin.jvm.internal.j.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Object[] H(Object[] objArr, int i, int i3) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        E1.b.d(i3, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i, i3);
        kotlin.jvm.internal.j.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final void I(Object[] objArr, int i, int i3) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        Arrays.fill(objArr, i, i3, (Object) null);
    }

    public static ArrayList J(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object K(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static String L(byte[] bArr, String str, F2.l lVar, int i) {
        String str2;
        String str3 = "";
        if ((i & 2) != 0) {
            str2 = "";
        } else {
            str2 = "[";
        }
        if ((i & 4) == 0) {
            str3 = "]";
        }
        if ((i & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.j.e(bArr, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str2);
        int i3 = 0;
        for (byte b4 : bArr) {
            i3++;
            if (i3 > 1) {
                sb.append((CharSequence) str);
            }
            if (lVar != null) {
                sb.append((CharSequence) lVar.invoke(Byte.valueOf(b4)));
            } else {
                sb.append((CharSequence) String.valueOf((int) b4));
            }
        }
        sb.append((CharSequence) str3);
        return sb.toString();
    }

    public static String M(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        int i = 0;
        for (Object obj : objArr) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) ",");
            }
            AbstractC0228a.b(sb, obj, null);
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }

    public static byte[] N(byte b4, byte[] bArr) {
        kotlin.jvm.internal.j.e(bArr, "<this>");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b4;
        return copyOf;
    }

    public static List O(byte[] bArr, K2.f indices) {
        kotlin.jvm.internal.j.e(indices, "indices");
        if (indices.isEmpty()) {
            return C0716r.f6476a;
        }
        return new C0706h(G(bArr, indices.f1118a, indices.f1119b + 1));
    }

    public static final void P(Object[] objArr, HashSet hashSet) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        for (Object obj : objArr) {
            hashSet.add(obj);
        }
    }

    public static List Q(long[] jArr) {
        kotlin.jvm.internal.j.e(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            if (length != 1) {
                ArrayList arrayList = new ArrayList(jArr.length);
                for (long j2 : jArr) {
                    arrayList.add(Long.valueOf(j2));
                }
                return arrayList;
            }
            return T.b.B(Long.valueOf(jArr[0]));
        }
        return C0716r.f6476a;
    }

    public static List R(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            if (length != 1) {
                return new ArrayList(new C0703e(objArr, false));
            }
            return T.b.B(objArr[0]);
        }
        return C0716r.f6476a;
    }

    public static Set S(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(u.F(objArr.length));
        P(objArr, linkedHashSet);
        return linkedHashSet;
    }

    public static Set T(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            if (length != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(u.F(objArr.length));
                P(objArr, linkedHashSet);
                return linkedHashSet;
            }
            return m3.b.M(objArr[0]);
        }
        return t.f6478a;
    }
}
