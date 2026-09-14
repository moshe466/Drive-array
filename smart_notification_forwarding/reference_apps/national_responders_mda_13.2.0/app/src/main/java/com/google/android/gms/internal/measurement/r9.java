package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r9 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f5571a = F();

    /* renamed from: b, reason: collision with root package name */
    private static final ha<?, ?> f5572b = g(false);

    /* renamed from: c, reason: collision with root package name */
    private static final ha<?, ?> f5573c = g(true);

    /* renamed from: d, reason: collision with root package name */
    private static final ha<?, ?> f5574d = new ja();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof l8) {
            l8 l8Var = (l8) list;
            i10 = 0;
            while (i11 < size) {
                i10 += v6.n0(l8Var.d(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += v6.n0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static ha<?, ?> B() {
        return f5574d;
    }

    public static void C(int i10, List<Long> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.r(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * v6.g0(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof p7) {
            p7 p7Var = (p7) list;
            i10 = 0;
            while (i11 < size) {
                i10 += v6.B0(p7Var.f(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += v6.B0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    private static Class<?> F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void G(int i10, List<Long> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.l(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return I(list) + (size * v6.g0(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof p7) {
            p7 p7Var = (p7) list;
            i10 = 0;
            while (i11 < size) {
                i10 += v6.k0(p7Var.f(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += v6.k0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    private static Class<?> J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void K(int i10, List<Long> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.h(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return M(list) + (size * v6.g0(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof p7) {
            p7 p7Var = (p7) list;
            i10 = 0;
            while (i11 < size) {
                i10 += v6.o0(p7Var.f(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += v6.o0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void N(int i10, List<Long> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.a(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int O(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return P(list) + (size * v6.g0(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof p7) {
            p7 p7Var = (p7) list;
            i10 = 0;
            while (i11 < size) {
                i10 += v6.s0(p7Var.f(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += v6.s0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void Q(int i10, List<Long> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.w(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int R(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * v6.x0(i10, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int S(List<?> list) {
        return list.size() << 2;
    }

    public static void T(int i10, List<Integer> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.k(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int U(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * v6.q0(i10, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int V(List<?> list) {
        return list.size() << 3;
    }

    public static void W(int i10, List<Integer> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.D(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int X(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * v6.H(i10, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Y(List<?> list) {
        return list.size();
    }

    public static void Z(int i10, List<Integer> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.n(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, Object obj, p9 p9Var) {
        return obj instanceof c8 ? v6.c(i10, (c8) obj) : v6.F(i10, (y8) obj, p9Var);
    }

    public static void a0(int i10, List<Integer> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.A(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i10, List<?> list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int g02 = v6.g0(i10) * size;
        if (list instanceof e8) {
            e8 e8Var = (e8) list;
            while (i11 < size) {
                Object d10 = e8Var.d(i11);
                g02 += d10 instanceof d6 ? v6.I((d6) d10) : v6.K((String) d10);
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                g02 += obj instanceof d6 ? v6.I((d6) obj) : v6.K((String) obj);
                i11++;
            }
        }
        return g02;
    }

    public static void b0(int i10, List<Integer> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.G(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10, List<?> list, p9 p9Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int g02 = v6.g0(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            g02 += obj instanceof c8 ? v6.d((c8) obj) : v6.e((y8) obj, p9Var);
        }
        return g02;
    }

    public static void c0(int i10, List<Integer> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.m(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * v6.g0(i10));
    }

    public static void d0(int i10, List<Boolean> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.e(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof l8) {
            l8 l8Var = (l8) list;
            i10 = 0;
            while (i11 < size) {
                i10 += v6.d0(l8Var.d(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += v6.d0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static ha<?, ?> f() {
        return f5572b;
    }

    private static ha<?, ?> g(boolean z10) {
        try {
            Class<?> J = J();
            if (J == null) {
                return null;
            }
            return (ha) J.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused) {
            return null;
        }
    }

    static <UT, UB> UB h(int i10, int i11, UB ub2, ha<UT, UB> haVar) {
        if (ub2 == null) {
            ub2 = haVar.a();
        }
        haVar.b(ub2, i10, i11);
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB i(int i10, List<Integer> list, t7 t7Var, UB ub2, ha<UT, UB> haVar) {
        if (t7Var == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = list.get(i12).intValue();
                if (t7Var.b(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    ub2 = (UB) h(i10, intValue, ub2, haVar);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!t7Var.b(intValue2)) {
                    ub2 = (UB) h(i10, intValue2, ub2, haVar);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static void j(int i10, List<String> list, bb bbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.J(i10, list);
    }

    public static void k(int i10, List<?> list, bb bbVar, p9 p9Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.f(i10, list, p9Var);
    }

    public static void l(int i10, List<Double> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.t(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends g7<FT>> void m(a7<FT> a7Var, T t10, T t11) {
        e7<FT> b10 = a7Var.b(t11);
        if (b10.f5287a.isEmpty()) {
            return;
        }
        a7Var.f(t10).f(b10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void n(r8 r8Var, T t10, T t11, long j10) {
        na.j(t10, j10, r8Var.c(na.F(t10, j10), na.F(t11, j10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void o(ha<UT, UB> haVar, T t10, T t11) {
        haVar.e(t10, haVar.i(haVar.f(t10), haVar.f(t11)));
    }

    public static void p(Class<?> cls) {
        Class<?> cls2;
        if (!l7.class.isAssignableFrom(cls) && (cls2 = f5571a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(int i10, List<d6> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int g02 = size * v6.g0(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            g02 += v6.I(list.get(i11));
        }
        return g02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i10, List<y8> list, p9 p9Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += v6.U(i10, list.get(i12), p9Var);
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return u(list) + (size * v6.g0(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof l8) {
            l8 l8Var = (l8) list;
            i10 = 0;
            while (i11 < size) {
                i10 += v6.i0(l8Var.d(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += v6.i0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static ha<?, ?> v() {
        return f5573c;
    }

    public static void w(int i10, List<d6> list, bb bbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.u(i10, list);
    }

    public static void x(int i10, List<?> list, bb bbVar, p9 p9Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.I(i10, list, p9Var);
    }

    public static void y(int i10, List<Float> list, bb bbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bbVar.B(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * v6.g0(i10));
    }
}
