package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f4088a;

    /* renamed from: b, reason: collision with root package name */
    public static final d0 f4089b;

    /* renamed from: c, reason: collision with root package name */
    public static final d0 f4090c;

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f4091d;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.crypto.tink.shaded.protobuf.f0, java.lang.Object] */
    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f4088a = cls;
        f4089b = v(false);
        f4090c = v(true);
        f4091d = new Object();
    }

    public static void A(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Double) list.get(i5)).getClass();
                    Logger logger = C0341m.f4129n;
                    i4 += 8;
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.U(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                double doubleValue = ((Double) list.get(i3)).doubleValue();
                c0341m.getClass();
                c0341m.T(i, Double.doubleToRawLongBits(doubleValue));
                i3++;
            }
        }
    }

    public static void B(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            if (z3) {
                c0341m.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += C0341m.K(((Integer) list.get(i4)).intValue());
                }
                c0341m.X(i3);
                for (int i5 = 0; i5 < list.size(); i5++) {
                    c0341m.V(((Integer) list.get(i5)).intValue());
                }
                return;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                c0341m.W(i, 0);
                c0341m.V(intValue);
            }
        }
    }

    public static void C(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Integer) list.get(i5)).getClass();
                    Logger logger = C0341m.f4129n;
                    i4 += 4;
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.S(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0341m.R(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void D(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Long) list.get(i5)).getClass();
                    Logger logger = C0341m.f4129n;
                    i4 += 8;
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.U(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0341m.T(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void E(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Float) list.get(i5)).getClass();
                    Logger logger = C0341m.f4129n;
                    i4 += 4;
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.S(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                float floatValue = ((Float) list.get(i3)).floatValue();
                c0341m.getClass();
                c0341m.R(i, Float.floatToRawIntBits(floatValue));
                i3++;
            }
        }
    }

    public static void F(int i, List list, K k4, b0 b0Var) {
        if (list != null && !list.isEmpty()) {
            k4.getClass();
            for (int i3 = 0; i3 < list.size(); i3++) {
                k4.b(i, list.get(i3), b0Var);
            }
        }
    }

    public static void G(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            if (z3) {
                c0341m.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += C0341m.K(((Integer) list.get(i4)).intValue());
                }
                c0341m.X(i3);
                for (int i5 = 0; i5 < list.size(); i5++) {
                    c0341m.V(((Integer) list.get(i5)).intValue());
                }
                return;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                c0341m.W(i, 0);
                c0341m.V(intValue);
            }
        }
    }

    public static void H(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0341m.O(((Long) list.get(i5)).longValue());
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.Z(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0341m.Y(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void I(int i, List list, K k4, b0 b0Var) {
        if (list != null && !list.isEmpty()) {
            k4.getClass();
            for (int i3 = 0; i3 < list.size(); i3++) {
                k4.c(i, list.get(i3), b0Var);
            }
        }
    }

    public static void J(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Integer) list.get(i5)).getClass();
                    Logger logger = C0341m.f4129n;
                    i4 += 4;
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.S(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0341m.R(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void K(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Long) list.get(i5)).getClass();
                    Logger logger = C0341m.f4129n;
                    i4 += 8;
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.U(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0341m.T(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void L(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            if (z3) {
                c0341m.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    int intValue = ((Integer) list.get(i4)).intValue();
                    i3 += C0341m.N((intValue >> 31) ^ (intValue << 1));
                }
                c0341m.X(i3);
                for (int i5 = 0; i5 < list.size(); i5++) {
                    int intValue2 = ((Integer) list.get(i5)).intValue();
                    c0341m.X((intValue2 >> 31) ^ (intValue2 << 1));
                }
                return;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue3 = ((Integer) list.get(i6)).intValue();
                c0341m.W(i, 0);
                c0341m.X((intValue3 >> 31) ^ (intValue3 << 1));
            }
        }
    }

    public static void M(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    long longValue = ((Long) list.get(i5)).longValue();
                    i4 += C0341m.O((longValue >> 63) ^ (longValue << 1));
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    long longValue2 = ((Long) list.get(i3)).longValue();
                    c0341m.Z((longValue2 >> 63) ^ (longValue2 << 1));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                long longValue3 = ((Long) list.get(i3)).longValue();
                c0341m.Y(i, (longValue3 >> 63) ^ (longValue3 << 1));
                i3++;
            }
        }
    }

    public static void N(int i, List list, K k4) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            if (list instanceof E) {
                E e4 = (E) list;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    Object f4 = e4.f(i3);
                    if (f4 instanceof String) {
                        String str = (String) f4;
                        c0341m.W(i, 2);
                        int i4 = c0341m.f4133l;
                        byte[] bArr = c0341m.f4132k;
                        int i5 = c0341m.f4134m;
                        try {
                            int N3 = C0341m.N(str.length() * 3);
                            int N4 = C0341m.N(str.length());
                            if (N4 == N3) {
                                int i6 = i5 + N4;
                                c0341m.f4134m = i6;
                                int m4 = q0.f4147a.m(str, bArr, i6, i4 - i6);
                                c0341m.f4134m = i5;
                                c0341m.X((m4 - i5) - N4);
                                c0341m.f4134m = m4;
                            } else {
                                c0341m.X(q0.b(str));
                                int i7 = c0341m.f4134m;
                                c0341m.f4134m = q0.f4147a.m(str, bArr, i7, i4 - i7);
                            }
                        } catch (p0 e5) {
                            c0341m.f4134m = i5;
                            C0341m.f4129n.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e5);
                            byte[] bytes = str.getBytes(B.f4029a);
                            try {
                                c0341m.X(bytes.length);
                                c0341m.Q(bytes, 0, bytes.length);
                            } catch (IndexOutOfBoundsException e6) {
                                throw new CodedOutputStream$OutOfSpaceException(e6);
                            }
                        } catch (IndexOutOfBoundsException e7) {
                            throw new CodedOutputStream$OutOfSpaceException(e7);
                        }
                    } else {
                        AbstractC0337i abstractC0337i = (AbstractC0337i) f4;
                        c0341m.W(i, 2);
                        c0341m.X(abstractC0337i.size());
                        C0336h c0336h = (C0336h) abstractC0337i;
                        c0341m.Q(c0336h.f4105d, c0336h.l(), c0336h.size());
                    }
                }
                return;
            }
            for (int i8 = 0; i8 < list.size(); i8++) {
                String str2 = (String) list.get(i8);
                c0341m.W(i, 2);
                int i9 = c0341m.f4133l;
                byte[] bArr2 = c0341m.f4132k;
                int i10 = c0341m.f4134m;
                try {
                    int N5 = C0341m.N(str2.length() * 3);
                    int N6 = C0341m.N(str2.length());
                    if (N6 == N5) {
                        int i11 = i10 + N6;
                        c0341m.f4134m = i11;
                        int m5 = q0.f4147a.m(str2, bArr2, i11, i9 - i11);
                        c0341m.f4134m = i10;
                        c0341m.X((m5 - i10) - N6);
                        c0341m.f4134m = m5;
                    } else {
                        c0341m.X(q0.b(str2));
                        int i12 = c0341m.f4134m;
                        c0341m.f4134m = q0.f4147a.m(str2, bArr2, i12, i9 - i12);
                    }
                } catch (p0 e8) {
                    c0341m.f4134m = i10;
                    C0341m.f4129n.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e8);
                    byte[] bytes2 = str2.getBytes(B.f4029a);
                    try {
                        c0341m.X(bytes2.length);
                        c0341m.Q(bytes2, 0, bytes2.length);
                    } catch (IndexOutOfBoundsException e9) {
                        throw new CodedOutputStream$OutOfSpaceException(e9);
                    }
                } catch (IndexOutOfBoundsException e10) {
                    throw new CodedOutputStream$OutOfSpaceException(e10);
                }
            }
        }
    }

    public static void O(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            if (z3) {
                c0341m.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += C0341m.N(((Integer) list.get(i4)).intValue());
                }
                c0341m.X(i3);
                for (int i5 = 0; i5 < list.size(); i5++) {
                    c0341m.X(((Integer) list.get(i5)).intValue());
                }
                return;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                c0341m.W(i, 0);
                c0341m.X(intValue);
            }
        }
    }

    public static void P(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            int i3 = 0;
            if (z3) {
                c0341m.W(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0341m.O(((Long) list.get(i5)).longValue());
                }
                c0341m.X(i4);
                while (i3 < list.size()) {
                    c0341m.Z(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0341m.Y(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int M3 = C0341m.M(i) * size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            M3 += C0341m.G((AbstractC0337i) list.get(i3));
        }
        return M3;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0341m.M(i) * size) + c(list);
    }

    public static int c(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC0352y) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            if (size <= 0) {
                return 0;
            }
            abstractC0352y.h(0);
            throw null;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0341m.K(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    public static int d(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return C0341m.H(i) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return C0341m.I(i) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0341m.M(i) * size) + i(list);
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC0352y) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            if (size <= 0) {
                return 0;
            }
            abstractC0352y.h(0);
            throw null;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0341m.K(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    public static int j(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (C0341m.M(i) * list.size()) + k(list);
    }

    public static int k(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof I) {
            I i = (I) list;
            if (size <= 0) {
                return 0;
            }
            i.h(0);
            throw null;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += C0341m.O(((Long) list.get(i4)).longValue());
        }
        return i3;
    }

    public static int l(int i, List list, b0 b0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int M3 = C0341m.M(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            int b4 = ((AbstractC0329a) list.get(i3)).b(b0Var);
            M3 += C0341m.N(b4) + b4;
        }
        return M3;
    }

    public static int m(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0341m.M(i) * size) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC0352y) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            if (size <= 0) {
                return 0;
            }
            abstractC0352y.h(0);
            throw null;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = ((Integer) list.get(i3)).intValue();
            i += C0341m.N((intValue >> 31) ^ (intValue << 1));
        }
        return i;
    }

    public static int o(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0341m.M(i) * size) + p(list);
    }

    public static int p(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof I) {
            I i = (I) list;
            if (size <= 0) {
                return 0;
            }
            i.h(0);
            throw null;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            long longValue = ((Long) list.get(i4)).longValue();
            i3 += C0341m.O((longValue >> 63) ^ (longValue << 1));
        }
        return i3;
    }

    public static int q(int i, List list) {
        int L3;
        int L4;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int M3 = C0341m.M(i) * size;
        if (list instanceof E) {
            E e4 = (E) list;
            while (i3 < size) {
                Object f4 = e4.f(i3);
                if (f4 instanceof AbstractC0337i) {
                    L4 = C0341m.G((AbstractC0337i) f4);
                } else {
                    L4 = C0341m.L((String) f4);
                }
                M3 = L4 + M3;
                i3++;
            }
            return M3;
        }
        while (i3 < size) {
            Object obj = list.get(i3);
            if (obj instanceof AbstractC0337i) {
                L3 = C0341m.G((AbstractC0337i) obj);
            } else {
                L3 = C0341m.L((String) obj);
            }
            M3 = L3 + M3;
            i3++;
        }
        return M3;
    }

    public static int r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0341m.M(i) * size) + s(list);
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC0352y) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            if (size <= 0) {
                return 0;
            }
            abstractC0352y.h(0);
            throw null;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += C0341m.N(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    public static int t(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0341m.M(i) * size) + u(list);
    }

    public static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof I) {
            I i = (I) list;
            if (size <= 0) {
                return 0;
            }
            i.h(0);
            throw null;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += C0341m.O(((Long) list.get(i4)).longValue());
        }
        return i3;
    }

    public static d0 v(boolean z3) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (d0) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z3));
            } catch (Throwable unused2) {
                return null;
            }
        }
        return null;
    }

    public static void w(d0 d0Var, Object obj, Object obj2) {
        ((f0) d0Var).getClass();
        AbstractC0351x abstractC0351x = (AbstractC0351x) obj;
        e0 e0Var = abstractC0351x.unknownFields;
        e0 e0Var2 = ((AbstractC0351x) obj2).unknownFields;
        e0 e0Var3 = e0.f4095f;
        if (!e0Var3.equals(e0Var2)) {
            if (e0Var3.equals(e0Var)) {
                int i = e0Var.f4096a + e0Var2.f4096a;
                int[] copyOf = Arrays.copyOf(e0Var.f4097b, i);
                System.arraycopy(e0Var2.f4097b, 0, copyOf, e0Var.f4096a, e0Var2.f4096a);
                Object[] copyOf2 = Arrays.copyOf(e0Var.f4098c, i);
                System.arraycopy(e0Var2.f4098c, 0, copyOf2, e0Var.f4096a, e0Var2.f4096a);
                e0Var = new e0(i, copyOf, copyOf2, true);
            } else {
                e0Var.getClass();
                if (!e0Var2.equals(e0Var3)) {
                    if (e0Var.f4100e) {
                        int i3 = e0Var.f4096a + e0Var2.f4096a;
                        e0Var.a(i3);
                        System.arraycopy(e0Var2.f4097b, 0, e0Var.f4097b, e0Var.f4096a, e0Var2.f4096a);
                        System.arraycopy(e0Var2.f4098c, 0, e0Var.f4098c, e0Var.f4096a, e0Var2.f4096a);
                        e0Var.f4096a = i3;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        abstractC0351x.unknownFields = e0Var;
    }

    public static boolean x(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void y(int i, List list, K k4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            C0341m c0341m = (C0341m) k4.f4050a;
            if (z3) {
                c0341m.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Boolean) list.get(i4)).getClass();
                    Logger logger = C0341m.f4129n;
                    i3++;
                }
                c0341m.X(i3);
                for (int i5 = 0; i5 < list.size(); i5++) {
                    c0341m.P(((Boolean) list.get(i5)).booleanValue() ? (byte) 1 : (byte) 0);
                }
                return;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                boolean booleanValue = ((Boolean) list.get(i6)).booleanValue();
                c0341m.W(i, 0);
                c0341m.P(booleanValue ? (byte) 1 : (byte) 0);
            }
        }
    }

    public static void z(int i, List list, K k4) {
        if (list != null && !list.isEmpty()) {
            k4.getClass();
            for (int i3 = 0; i3 < list.size(); i3++) {
                C0341m c0341m = (C0341m) k4.f4050a;
                AbstractC0337i abstractC0337i = (AbstractC0337i) list.get(i3);
                c0341m.W(i, 2);
                c0341m.X(abstractC0337i.size());
                C0336h c0336h = (C0336h) abstractC0337i;
                c0341m.Q(c0336h.f4105d, c0336h.l(), c0336h.size());
            }
        }
    }
}
