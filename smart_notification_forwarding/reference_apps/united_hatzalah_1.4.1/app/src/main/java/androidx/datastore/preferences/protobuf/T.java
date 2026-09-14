package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class T {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f3130a;

    /* renamed from: b, reason: collision with root package name */
    public static final Y f3131b;

    /* renamed from: c, reason: collision with root package name */
    public static final a0 f3132c;

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.datastore.preferences.protobuf.a0, java.lang.Object] */
    static {
        Class<?> cls;
        Class<?> cls2;
        O o2 = O.f3120c;
        Y y = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f3130a = cls;
        try {
            O o4 = O.f3120c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                y = (Y) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        f3131b = y;
        f3132c = new Object();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0244k.O(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0244k.M(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0244k.M(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0244k.O(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0244k.O(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = ((Integer) list.get(i3)).intValue();
            i += C0244k.N((intValue >> 31) ^ (intValue << 1));
        }
        return i;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            long longValue = ((Long) list.get(i3)).longValue();
            i += C0244k.O((longValue >> 63) ^ (longValue << 1));
        }
        return i;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0244k.N(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0244k.O(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    public static void k(Y y, Object obj, Object obj2) {
        ((a0) y).getClass();
        AbstractC0253u abstractC0253u = (AbstractC0253u) obj;
        Z z3 = abstractC0253u.unknownFields;
        Z z4 = ((AbstractC0253u) obj2).unknownFields;
        Z z5 = Z.f3148f;
        if (!z5.equals(z4)) {
            if (z5.equals(z3)) {
                int i = z3.f3149a + z4.f3149a;
                int[] copyOf = Arrays.copyOf(z3.f3150b, i);
                System.arraycopy(z4.f3150b, 0, copyOf, z3.f3149a, z4.f3149a);
                Object[] copyOf2 = Arrays.copyOf(z3.f3151c, i);
                System.arraycopy(z4.f3151c, 0, copyOf2, z3.f3149a, z4.f3149a);
                z3 = new Z(i, copyOf, copyOf2, true);
            } else {
                z3.getClass();
                if (!z4.equals(z5)) {
                    if (z3.f3153e) {
                        int i3 = z3.f3149a + z4.f3149a;
                        z3.a(i3);
                        System.arraycopy(z4.f3150b, 0, z3.f3150b, z3.f3149a, z4.f3149a);
                        System.arraycopy(z4.f3151c, 0, z3.f3151c, z3.f3149a, z4.f3149a);
                        z3.f3149a = i3;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        abstractC0253u.unknownFields = z3;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void m(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Boolean) list.get(i5)).getClass();
                    Logger logger = C0244k.f3196o;
                    i4++;
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.R(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.T(i, ((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
        }
    }

    public static void n(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Double) list.get(i5)).getClass();
                    Logger logger = C0244k.f3196o;
                    i4 += 8;
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.Z(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                double doubleValue = ((Double) list.get(i3)).doubleValue();
                c0244k.getClass();
                c0244k.Y(i, Double.doubleToRawLongBits(doubleValue));
                i3++;
            }
        }
    }

    public static void o(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0244k.O(((Integer) list.get(i5)).intValue());
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.b0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.a0(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void p(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Integer) list.get(i5)).getClass();
                    Logger logger = C0244k.f3196o;
                    i4 += 4;
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.X(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.W(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void q(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Long) list.get(i5)).getClass();
                    Logger logger = C0244k.f3196o;
                    i4 += 8;
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.Z(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.Y(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void r(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Float) list.get(i5)).getClass();
                    Logger logger = C0244k.f3196o;
                    i4 += 4;
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.X(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                float floatValue = ((Float) list.get(i3)).floatValue();
                c0244k.getClass();
                c0244k.W(i, Float.floatToRawIntBits(floatValue));
                i3++;
            }
        }
    }

    public static void s(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0244k.O(((Integer) list.get(i5)).intValue());
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.b0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.a0(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void t(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0244k.O(((Long) list.get(i5)).longValue());
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.j0(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.i0(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void u(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Integer) list.get(i5)).getClass();
                    Logger logger = C0244k.f3196o;
                    i4 += 4;
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.X(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.W(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void v(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Long) list.get(i5)).getClass();
                    Logger logger = C0244k.f3196o;
                    i4 += 8;
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.Z(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.Y(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void w(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    int intValue = ((Integer) list.get(i5)).intValue();
                    i4 += C0244k.N((intValue >> 31) ^ (intValue << 1));
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    int intValue2 = ((Integer) list.get(i3)).intValue();
                    c0244k.h0((intValue2 >> 31) ^ (intValue2 << 1));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                int intValue3 = ((Integer) list.get(i3)).intValue();
                c0244k.g0(i, (intValue3 >> 31) ^ (intValue3 << 1));
                i3++;
            }
        }
    }

    public static void x(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    long longValue = ((Long) list.get(i5)).longValue();
                    i4 += C0244k.O((longValue >> 63) ^ (longValue << 1));
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    long longValue2 = ((Long) list.get(i3)).longValue();
                    c0244k.j0((longValue2 >> 63) ^ (longValue2 << 1));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                long longValue3 = ((Long) list.get(i3)).longValue();
                c0244k.i0(i, (longValue3 >> 63) ^ (longValue3 << 1));
                i3++;
            }
        }
    }

    public static void y(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0244k.N(((Integer) list.get(i5)).intValue());
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.h0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.g0(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void z(int i, List list, B b4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0244k c0244k = (C0244k) b4.f3089a;
            int i3 = 0;
            if (z3) {
                c0244k.f0(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0244k.O(((Long) list.get(i5)).longValue());
                }
                c0244k.h0(i4);
                while (i3 < list.size()) {
                    c0244k.j0(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0244k.i0(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static Object j(Object obj, int i, InterfaceC0254v interfaceC0254v, Object obj2, Y y) {
        return obj2;
    }
}
