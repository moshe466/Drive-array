package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b9<T> implements p9<T> {

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f5196p = new int[0];

    /* renamed from: q, reason: collision with root package name */
    private static final Unsafe f5197q = na.t();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f5198a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f5199b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5200c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5201d;

    /* renamed from: e, reason: collision with root package name */
    private final y8 f5202e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f5203f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5204g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f5205h;

    /* renamed from: i, reason: collision with root package name */
    private final int f5206i;

    /* renamed from: j, reason: collision with root package name */
    private final int f5207j;

    /* renamed from: k, reason: collision with root package name */
    private final f9 f5208k;

    /* renamed from: l, reason: collision with root package name */
    private final h8 f5209l;

    /* renamed from: m, reason: collision with root package name */
    private final ha<?, ?> f5210m;

    /* renamed from: n, reason: collision with root package name */
    private final a7<?> f5211n;

    /* renamed from: o, reason: collision with root package name */
    private final r8 f5212o;

    private b9(int[] iArr, Object[] objArr, int i10, int i11, y8 y8Var, boolean z10, boolean z11, int[] iArr2, int i12, int i13, f9 f9Var, h8 h8Var, ha<?, ?> haVar, a7<?> a7Var, r8 r8Var) {
        this.f5198a = iArr;
        this.f5199b = objArr;
        this.f5200c = i10;
        this.f5201d = i11;
        boolean z12 = y8Var instanceof l7;
        this.f5204g = z10;
        this.f5203f = a7Var != null && a7Var.e(y8Var);
        this.f5205h = iArr2;
        this.f5206i = i12;
        this.f5207j = i13;
        this.f5208k = f9Var;
        this.f5209l = h8Var;
        this.f5210m = haVar;
        this.f5211n = a7Var;
        this.f5202e = y8Var;
        this.f5212o = r8Var;
    }

    private final boolean A(T t10, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? y(t10, i10) : (i12 & i13) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean B(Object obj, int i10, p9 p9Var) {
        return p9Var.b(na.F(obj, i10 & 1048575));
    }

    private static <T> double C(T t10, long j10) {
        return ((Double) na.F(t10, j10)).doubleValue();
    }

    private final int D(int i10, int i11) {
        int length = (this.f5198a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f5198a[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private final Object E(int i10) {
        return this.f5199b[(i10 / 3) << 1];
    }

    private final void F(T t10, int i10) {
        int O = O(i10);
        long j10 = 1048575 & O;
        if (j10 == 1048575) {
            return;
        }
        na.h(t10, j10, (1 << (O >>> 20)) | na.b(t10, j10));
    }

    private final void G(T t10, int i10, int i11) {
        na.h(t10, O(i11) & 1048575, i10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x007e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:228:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void H(T r18, com.google.android.gms.internal.measurement.bb r19) {
        /*
            Method dump skipped, instructions count: 1222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.H(java.lang.Object, com.google.android.gms.internal.measurement.bb):void");
    }

    private final void I(T t10, T t11, int i10) {
        int M = M(i10);
        int i11 = this.f5198a[i10];
        long j10 = M & 1048575;
        if (z(t11, i11, i10)) {
            Object F = z(t10, i11, i10) ? na.F(t10, j10) : null;
            Object F2 = na.F(t11, j10);
            if (F != null && F2 != null) {
                na.j(t10, j10, o7.e(F, F2));
                G(t10, i11, i10);
            } else if (F2 != null) {
                na.j(t10, j10, F2);
                G(t10, i11, i10);
            }
        }
    }

    private static <T> float J(T t10, long j10) {
        return ((Float) na.F(t10, j10)).floatValue();
    }

    private final t7 K(int i10) {
        return (t7) this.f5199b[((i10 / 3) << 1) + 1];
    }

    private final boolean L(T t10, T t11, int i10) {
        return y(t10, i10) == y(t11, i10);
    }

    private final int M(int i10) {
        return this.f5198a[i10 + 1];
    }

    private static <T> int N(T t10, long j10) {
        return ((Integer) na.F(t10, j10)).intValue();
    }

    private final int O(int i10) {
        return this.f5198a[i10 + 2];
    }

    private static <T> long P(T t10, long j10) {
        return ((Long) na.F(t10, j10)).longValue();
    }

    private static ga Q(Object obj) {
        l7 l7Var = (l7) obj;
        ga gaVar = l7Var.zzb;
        if (gaVar != ga.a()) {
            return gaVar;
        }
        ga g10 = ga.g();
        l7Var.zzb = g10;
        return g10;
    }

    private static <T> boolean R(T t10, long j10) {
        return ((Boolean) na.F(t10, j10)).booleanValue();
    }

    private final int S(int i10) {
        if (i10 < this.f5200c || i10 > this.f5201d) {
            return -1;
        }
        return D(i10, 0);
    }

    private final int i(int i10, int i11) {
        if (i10 < this.f5200c || i10 > this.f5201d) {
            return -1;
        }
        return D(i10, i11);
    }

    private static <UT, UB> int j(ha<UT, UB> haVar, T t10) {
        return haVar.l(haVar.f(t10));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int k(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, c6 c6Var) {
        Object valueOf;
        Object valueOf2;
        int k10;
        long j11;
        int i18;
        Object valueOf3;
        Unsafe unsafe = f5197q;
        long j12 = this.f5198a[i17 + 2] & 1048575;
        switch (i16) {
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
                if (i14 == 1) {
                    valueOf = Double.valueOf(z5.m(bArr, i10));
                    unsafe.putObject(t10, j10, valueOf);
                    k10 = i10 + 8;
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
                if (i14 == 5) {
                    valueOf2 = Float.valueOf(z5.o(bArr, i10));
                    unsafe.putObject(t10, j10, valueOf2);
                    k10 = i10 + 4;
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
            case 54:
                if (i14 == 0) {
                    k10 = z5.k(bArr, i10, c6Var);
                    j11 = c6Var.f5234b;
                    valueOf3 = Long.valueOf(j11);
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 55:
            case 62:
                if (i14 == 0) {
                    k10 = z5.i(bArr, i10, c6Var);
                    i18 = c6Var.f5233a;
                    valueOf3 = Integer.valueOf(i18);
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 56:
            case 65:
                if (i14 == 1) {
                    valueOf = Long.valueOf(z5.l(bArr, i10));
                    unsafe.putObject(t10, j10, valueOf);
                    k10 = i10 + 8;
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 57:
            case 64:
                if (i14 == 5) {
                    valueOf2 = Integer.valueOf(z5.h(bArr, i10));
                    unsafe.putObject(t10, j10, valueOf2);
                    k10 = i10 + 4;
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 58:
                if (i14 == 0) {
                    k10 = z5.k(bArr, i10, c6Var);
                    valueOf3 = Boolean.valueOf(c6Var.f5234b != 0);
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 59:
                if (i14 == 2) {
                    k10 = z5.i(bArr, i10, c6Var);
                    int i19 = c6Var.f5233a;
                    if (i19 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t10, j10, valueOf3);
                        unsafe.putInt(t10, j12, i13);
                        return k10;
                    }
                    if ((i15 & 536870912) != 0 && !qa.g(bArr, k10, k10 + i19)) {
                        throw x7.f();
                    }
                    unsafe.putObject(t10, j10, new String(bArr, k10, i19, o7.f5516a));
                    k10 += i19;
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 60:
                if (i14 == 2) {
                    k10 = z5.g(p(i17), bArr, i10, i11, c6Var);
                    Object object = unsafe.getInt(t10, j12) == i13 ? unsafe.getObject(t10, j10) : null;
                    valueOf3 = c6Var.f5235c;
                    if (object != null) {
                        valueOf3 = o7.e(object, valueOf3);
                    }
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 61:
                if (i14 == 2) {
                    k10 = z5.q(bArr, i10, c6Var);
                    valueOf3 = c6Var.f5235c;
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 63:
                if (i14 == 0) {
                    int i20 = z5.i(bArr, i10, c6Var);
                    int i21 = c6Var.f5233a;
                    t7 K = K(i17);
                    if (K != null && !K.b(i21)) {
                        Q(t10).c(i12, Long.valueOf(i21));
                        return i20;
                    }
                    unsafe.putObject(t10, j10, Integer.valueOf(i21));
                    k10 = i20;
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 66:
                if (i14 == 0) {
                    k10 = z5.i(bArr, i10, c6Var);
                    i18 = q6.d(c6Var.f5233a);
                    valueOf3 = Integer.valueOf(i18);
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 67:
                if (i14 == 0) {
                    k10 = z5.k(bArr, i10, c6Var);
                    j11 = q6.a(c6Var.f5234b);
                    valueOf3 = Long.valueOf(j11);
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            case 68:
                if (i14 == 3) {
                    k10 = z5.f(p(i17), bArr, i10, i11, (i12 & (-8)) | 4, c6Var);
                    Object object2 = unsafe.getInt(t10, j12) == i13 ? unsafe.getObject(t10, j10) : null;
                    valueOf3 = c6Var.f5235c;
                    if (object2 != null) {
                        valueOf3 = o7.e(object2, valueOf3);
                    }
                    unsafe.putObject(t10, j10, valueOf3);
                    unsafe.putInt(t10, j12, i13);
                    return k10;
                }
                return i10;
            default:
                return i10;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x014d, code lost:
    
        r12.add(com.google.android.gms.internal.measurement.d6.t(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x026b, code lost:
    
        if (r29.f5234b != 0) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x026d, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0270, code lost:
    
        r12.f(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0273, code lost:
    
        if (r4 >= r19) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0275, code lost:
    
        r6 = com.google.android.gms.internal.measurement.z5.i(r17, r4, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x027b, code lost:
    
        if (r20 != r29.f5233a) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x027d, code lost:
    
        r4 = com.google.android.gms.internal.measurement.z5.k(r17, r6, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0285, code lost:
    
        if (r29.f5234b == 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x026f, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0270, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x013d, code lost:
    
        if (r4 == 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x013f, code lost:
    
        r12.add(com.google.android.gms.internal.measurement.d6.f5256g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014d, code lost:
    
        if (r1 >= r19) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014f, code lost:
    
        r4 = com.google.android.gms.internal.measurement.z5.i(r17, r1, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0155, code lost:
    
        if (r20 != r29.f5233a) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0157, code lost:
    
        r1 = com.google.android.gms.internal.measurement.z5.i(r17, r4, r29);
        r4 = r29.f5233a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x015d, code lost:
    
        if (r4 < 0) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0161, code lost:
    
        if (r4 > (r17.length - r1)) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0163, code lost:
    
        if (r4 != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0145, code lost:
    
        r12.add(com.google.android.gms.internal.measurement.d6.t(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x016a, code lost:
    
        throw com.google.android.gms.internal.measurement.x7.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x016f, code lost:
    
        throw com.google.android.gms.internal.measurement.x7.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0037. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0200  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0210 -> B:106:0x01e7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:149:0x0285 -> B:143:0x026d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0163 -> B:63:0x013f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01cc -> B:89:0x01ab). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int l(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.c6 r29) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.l(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.c6):int");
    }

    private final <K, V> int m(T t10, byte[] bArr, int i10, int i11, int i12, long j10, c6 c6Var) {
        Unsafe unsafe = f5197q;
        Object E = E(i12);
        Object object = unsafe.getObject(t10, j10);
        if (this.f5212o.d(object)) {
            Object g10 = this.f5212o.g(E);
            this.f5212o.c(g10, object);
            unsafe.putObject(t10, j10, g10);
            object = g10;
        }
        this.f5212o.f(E);
        this.f5212o.a(object);
        int i13 = z5.i(bArr, i10, c6Var);
        int i14 = c6Var.f5233a;
        if (i14 < 0 || i14 > i11 - i13) {
            throw x7.a();
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.android.gms.internal.measurement.b9<T> o(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.w8 r34, com.google.android.gms.internal.measurement.f9 r35, com.google.android.gms.internal.measurement.h8 r36, com.google.android.gms.internal.measurement.ha<?, ?> r37, com.google.android.gms.internal.measurement.a7<?> r38, com.google.android.gms.internal.measurement.r8 r39) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.o(java.lang.Class, com.google.android.gms.internal.measurement.w8, com.google.android.gms.internal.measurement.f9, com.google.android.gms.internal.measurement.h8, com.google.android.gms.internal.measurement.ha, com.google.android.gms.internal.measurement.a7, com.google.android.gms.internal.measurement.r8):com.google.android.gms.internal.measurement.b9");
    }

    private final p9 p(int i10) {
        int i11 = (i10 / 3) << 1;
        p9 p9Var = (p9) this.f5199b[i11];
        if (p9Var != null) {
            return p9Var;
        }
        p9<T> b10 = l9.a().b((Class) this.f5199b[i11 + 1]);
        this.f5199b[i11] = b10;
        return b10;
    }

    private final <K, V, UT, UB> UB q(int i10, int i11, Map<K, V> map, t7 t7Var, UB ub2, ha<UT, UB> haVar) {
        p8<?, ?> f10 = this.f5212o.f(E(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!t7Var.b(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = haVar.a();
                }
                l6 A = d6.A(q8.a(f10, next.getKey(), next.getValue()));
                try {
                    q8.b(A.b(), f10, next.getKey(), next.getValue());
                    haVar.c(ub2, i11, A.a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    private final <UT, UB> UB r(Object obj, int i10, UB ub2, ha<UT, UB> haVar) {
        t7 K;
        int i11 = this.f5198a[i10];
        Object F = na.F(obj, M(i10) & 1048575);
        return (F == null || (K = K(i10)) == null) ? ub2 : (UB) q(i10, i11, this.f5212o.a(F), K, ub2, haVar);
    }

    private static Field s(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb2.append("Field ");
            sb2.append(str);
            sb2.append(" for ");
            sb2.append(name);
            sb2.append(" not found. Known fields are ");
            sb2.append(arrays);
            throw new RuntimeException(sb2.toString());
        }
    }

    private static List<?> t(Object obj, long j10) {
        return (List) na.F(obj, j10);
    }

    private static void u(int i10, Object obj, bb bbVar) {
        if (obj instanceof String) {
            bbVar.C(i10, (String) obj);
        } else {
            bbVar.x(i10, (d6) obj);
        }
    }

    private static <UT, UB> void v(ha<UT, UB> haVar, T t10, bb bbVar) {
        haVar.d(haVar.f(t10), bbVar);
    }

    private final <K, V> void w(bb bbVar, int i10, Object obj, int i11) {
        if (obj != null) {
            bbVar.E(i10, this.f5212o.f(E(i11)), this.f5212o.e(obj));
        }
    }

    private final void x(T t10, T t11, int i10) {
        long M = M(i10) & 1048575;
        if (y(t11, i10)) {
            Object F = na.F(t10, M);
            Object F2 = na.F(t11, M);
            if (F != null && F2 != null) {
                na.j(t10, M, o7.e(F, F2));
                F(t10, i10);
            } else if (F2 != null) {
                na.j(t10, M, F2);
                F(t10, i10);
            }
        }
    }

    private final boolean y(T t10, int i10) {
        int O = O(i10);
        long j10 = O & 1048575;
        if (j10 != 1048575) {
            return (na.b(t10, j10) & (1 << (O >>> 20))) != 0;
        }
        int M = M(i10);
        long j11 = M & 1048575;
        switch ((M & 267386880) >>> 20) {
            case 0:
                return na.C(t10, j11) != 0.0d;
            case 1:
                return na.x(t10, j11) != 0.0f;
            case 2:
                return na.o(t10, j11) != 0;
            case 3:
                return na.o(t10, j11) != 0;
            case 4:
                return na.b(t10, j11) != 0;
            case 5:
                return na.o(t10, j11) != 0;
            case 6:
                return na.b(t10, j11) != 0;
            case 7:
                return na.w(t10, j11);
            case 8:
                Object F = na.F(t10, j11);
                if (F instanceof String) {
                    return !((String) F).isEmpty();
                }
                if (F instanceof d6) {
                    return !d6.f5256g.equals(F);
                }
                throw new IllegalArgumentException();
            case 9:
                return na.F(t10, j11) != null;
            case 10:
                return !d6.f5256g.equals(na.F(t10, j11));
            case 11:
                return na.b(t10, j11) != 0;
            case 12:
                return na.b(t10, j11) != 0;
            case 13:
                return na.b(t10, j11) != 0;
            case 14:
                return na.o(t10, j11) != 0;
            case 15:
                return na.b(t10, j11) != 0;
            case 16:
                return na.o(t10, j11) != 0;
            case 17:
                return na.F(t10, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean z(T t10, int i10, int i11) {
        return na.b(t10, (long) (O(i11) & 1048575)) == i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ce, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e6, code lost:
    
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e2, code lost:
    
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e0, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.p9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(T r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.a(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.p9
    public final boolean b(T t10) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            boolean z10 = true;
            if (i14 >= this.f5206i) {
                return !this.f5203f || this.f5211n.b(t10).q();
            }
            int i15 = this.f5205h[i14];
            int i16 = this.f5198a[i15];
            int M = M(i15);
            int i17 = this.f5198a[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = f5197q.getInt(t10, i18);
                }
                i11 = i13;
                i10 = i18;
            } else {
                i10 = i12;
                i11 = i13;
            }
            if (((268435456 & M) != 0) && !A(t10, i15, i10, i11, i19)) {
                return false;
            }
            int i20 = (267386880 & M) >>> 20;
            if (i20 != 9 && i20 != 17) {
                if (i20 != 27) {
                    if (i20 == 60 || i20 == 68) {
                        if (z(t10, i16, i15) && !B(t10, M, p(i15))) {
                            return false;
                        }
                    } else if (i20 != 49) {
                        if (i20 == 50 && !this.f5212o.e(na.F(t10, M & 1048575)).isEmpty()) {
                            this.f5212o.f(E(i15));
                            throw null;
                        }
                    }
                }
                List list = (List) na.F(t10, M & 1048575);
                if (!list.isEmpty()) {
                    p9 p10 = p(i15);
                    int i21 = 0;
                    while (true) {
                        if (i21 >= list.size()) {
                            break;
                        }
                        if (!p10.b(list.get(i21))) {
                            z10 = false;
                            break;
                        }
                        i21++;
                    }
                }
                if (!z10) {
                    return false;
                }
            } else if (A(t10, i15, i10, i11, i19) && !B(t10, M, p(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        if (com.google.android.gms.internal.measurement.r9.q(com.google.android.gms.internal.measurement.na.F(r10, r6), com.google.android.gms.internal.measurement.na.F(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        if (com.google.android.gms.internal.measurement.na.o(r10, r6) == com.google.android.gms.internal.measurement.na.o(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (com.google.android.gms.internal.measurement.na.b(r10, r6) == com.google.android.gms.internal.measurement.na.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        if (com.google.android.gms.internal.measurement.na.o(r10, r6) == com.google.android.gms.internal.measurement.na.o(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        if (com.google.android.gms.internal.measurement.na.b(r10, r6) == com.google.android.gms.internal.measurement.na.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
    
        if (com.google.android.gms.internal.measurement.na.b(r10, r6) == com.google.android.gms.internal.measurement.na.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        if (com.google.android.gms.internal.measurement.na.b(r10, r6) == com.google.android.gms.internal.measurement.na.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
    
        if (com.google.android.gms.internal.measurement.r9.q(com.google.android.gms.internal.measurement.na.F(r10, r6), com.google.android.gms.internal.measurement.na.F(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:
    
        if (com.google.android.gms.internal.measurement.r9.q(com.google.android.gms.internal.measurement.na.F(r10, r6), com.google.android.gms.internal.measurement.na.F(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010e, code lost:
    
        if (com.google.android.gms.internal.measurement.r9.q(com.google.android.gms.internal.measurement.na.F(r10, r6), com.google.android.gms.internal.measurement.na.F(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0120, code lost:
    
        if (com.google.android.gms.internal.measurement.na.w(r10, r6) == com.google.android.gms.internal.measurement.na.w(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0132, code lost:
    
        if (com.google.android.gms.internal.measurement.na.b(r10, r6) == com.google.android.gms.internal.measurement.na.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
    
        if (com.google.android.gms.internal.measurement.na.o(r10, r6) == com.google.android.gms.internal.measurement.na.o(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0156, code lost:
    
        if (com.google.android.gms.internal.measurement.na.b(r10, r6) == com.google.android.gms.internal.measurement.na.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0169, code lost:
    
        if (com.google.android.gms.internal.measurement.na.o(r10, r6) == com.google.android.gms.internal.measurement.na.o(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017c, code lost:
    
        if (com.google.android.gms.internal.measurement.na.o(r10, r6) == com.google.android.gms.internal.measurement.na.o(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0195, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.na.x(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.na.x(r11, r6))) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b0, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.na.C(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.na.C(r11, r6))) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.measurement.r9.q(com.google.android.gms.internal.measurement.na.F(r10, r6), com.google.android.gms.internal.measurement.na.F(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b6 A[LOOP:0: B:2:0x0005->B:85:0x01b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b5 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.p9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.c(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final void d(T t10) {
        int i10;
        int i11 = this.f5206i;
        while (true) {
            i10 = this.f5207j;
            if (i11 >= i10) {
                break;
            }
            long M = M(this.f5205h[i11]) & 1048575;
            Object F = na.F(t10, M);
            if (F != null) {
                na.j(t10, M, this.f5212o.b(F));
            }
            i11++;
        }
        int length = this.f5205h.length;
        while (i10 < length) {
            this.f5209l.d(t10, this.f5205h[i10]);
            i10++;
        }
        this.f5210m.j(t10);
        if (this.f5203f) {
            this.f5211n.g(t10);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x02f1, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.measurement.d6) != false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x03b8, code lost:
    
        if (z(r19, r15, r3) != false) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0634, code lost:
    
        r4 = com.google.android.gms.internal.measurement.v6.U(r15, (com.google.android.gms.internal.measurement.y8) r2.getObject(r19, r8), p(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x03d8, code lost:
    
        if (z(r19, r15, r3) != false) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0661, code lost:
    
        r4 = com.google.android.gms.internal.measurement.v6.u0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x03e0, code lost:
    
        if (z(r19, r15, r3) != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x066c, code lost:
    
        r8 = com.google.android.gms.internal.measurement.v6.A0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0400, code lost:
    
        if (z(r19, r15, r3) != false) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0691, code lost:
    
        r4 = r2.getObject(r19, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0695, code lost:
    
        r4 = com.google.android.gms.internal.measurement.v6.T(r15, (com.google.android.gms.internal.measurement.d6) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0408, code lost:
    
        if (z(r19, r15, r3) != false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06a0, code lost:
    
        r4 = com.google.android.gms.internal.measurement.r9.a(r15, r2.getObject(r19, r8), p(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0418, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.measurement.d6) != false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x06bb, code lost:
    
        r4 = com.google.android.gms.internal.measurement.v6.G(r15, (java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x04b9, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x056a, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.v6.g0(r15) + com.google.android.gms.internal.measurement.v6.o0(r4)) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x04c7, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x04d5, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x04e3, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x04f1, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x04ff, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x050d, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x051a, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0527, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0534, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0541, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x054e, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x055b, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0568, code lost:
    
        if (r4 > 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0632, code lost:
    
        if ((r12 & r11) != 0) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x065f, code lost:
    
        if ((r12 & r11) != 0) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x066a, code lost:
    
        if ((r12 & r11) != 0) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x068f, code lost:
    
        if ((r12 & r11) != 0) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x069e, code lost:
    
        if ((r12 & r11) != 0) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x06b8, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.measurement.d6) != false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a8, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.measurement.d6) != false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02f4, code lost:
    
        r3 = com.google.android.gms.internal.measurement.v6.G(r3, (java.lang.String) r5);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x003f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:232:0x03af. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.p9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(T r19) {
        /*
            Method dump skipped, instructions count: 2238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.e(java.lang.Object):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0065. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:306:0x0524. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x097a  */
    @Override // com.google.android.gms.internal.measurement.p9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(T r14, com.google.android.gms.internal.measurement.bb r15) {
        /*
            Method dump skipped, instructions count: 2740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.f(java.lang.Object, com.google.android.gms.internal.measurement.bb):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x02c6, code lost:
    
        if (r0 == r5) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02ca, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0330, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x030d, code lost:
    
        if (r0 == r15) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x032e, code lost:
    
        if (r0 == r15) goto L119;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0095. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // com.google.android.gms.internal.measurement.p9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.c6 r35) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.g(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.c6):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.p9
    public final void h(T t10, T t11) {
        Objects.requireNonNull(t11);
        for (int i10 = 0; i10 < this.f5198a.length; i10 += 3) {
            int M = M(i10);
            long j10 = 1048575 & M;
            int i11 = this.f5198a[i10];
            switch ((M & 267386880) >>> 20) {
                case 0:
                    if (y(t11, i10)) {
                        na.f(t10, j10, na.C(t11, j10));
                        F(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (y(t11, i10)) {
                        na.g(t10, j10, na.x(t11, j10));
                        F(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.i(t10, j10, na.o(t11, j10));
                    F(t10, i10);
                    break;
                case 3:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.i(t10, j10, na.o(t11, j10));
                    F(t10, i10);
                    break;
                case 4:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.h(t10, j10, na.b(t11, j10));
                    F(t10, i10);
                    break;
                case 5:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.i(t10, j10, na.o(t11, j10));
                    F(t10, i10);
                    break;
                case 6:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.h(t10, j10, na.b(t11, j10));
                    F(t10, i10);
                    break;
                case 7:
                    if (y(t11, i10)) {
                        na.k(t10, j10, na.w(t11, j10));
                        F(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.j(t10, j10, na.F(t11, j10));
                    F(t10, i10);
                    break;
                case 9:
                case 17:
                    x(t10, t11, i10);
                    break;
                case 10:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.j(t10, j10, na.F(t11, j10));
                    F(t10, i10);
                    break;
                case 11:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.h(t10, j10, na.b(t11, j10));
                    F(t10, i10);
                    break;
                case 12:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.h(t10, j10, na.b(t11, j10));
                    F(t10, i10);
                    break;
                case 13:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.h(t10, j10, na.b(t11, j10));
                    F(t10, i10);
                    break;
                case 14:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.i(t10, j10, na.o(t11, j10));
                    F(t10, i10);
                    break;
                case 15:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.h(t10, j10, na.b(t11, j10));
                    F(t10, i10);
                    break;
                case 16:
                    if (!y(t11, i10)) {
                        break;
                    }
                    na.i(t10, j10, na.o(t11, j10));
                    F(t10, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                case 37:
                case androidx.constraintlayout.widget.j.W4 /* 38 */:
                case androidx.constraintlayout.widget.j.X4 /* 39 */:
                case androidx.constraintlayout.widget.j.Y4 /* 40 */:
                case androidx.constraintlayout.widget.j.Z4 /* 41 */:
                case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
                case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
                case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
                case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
                case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
                case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
                case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
                    this.f5209l.b(t10, t11, j10);
                    break;
                case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
                    r9.n(this.f5212o, t10, t11, j10);
                    break;
                case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
                case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
                case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!z(t11, i11, i10)) {
                        break;
                    }
                    na.j(t10, j10, na.F(t11, j10));
                    G(t10, i11, i10);
                    break;
                case 60:
                case 68:
                    I(t10, t11, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!z(t11, i11, i10)) {
                        break;
                    }
                    na.j(t10, j10, na.F(t11, j10));
                    G(t10, i11, i10);
                    break;
            }
        }
        r9.o(this.f5210m, t10, t11);
        if (this.f5203f) {
            r9.m(this.f5211n, t10, t11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x04c0, code lost:
    
        if (r6 == 1048575) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x04c2, code lost:
    
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x04c8, code lost:
    
        r1 = null;
        r2 = r9.f5206i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x04cd, code lost:
    
        if (r2 >= r9.f5207j) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x04cf, code lost:
    
        r1 = (com.google.android.gms.internal.measurement.ga) r9.r(r12, r9.f5205h[r2], r1, r9.f5210m);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x04de, code lost:
    
        if (r1 == null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x04e0, code lost:
    
        r9.f5210m.h(r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x04e7, code lost:
    
        if (r7 != 0) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x04e9, code lost:
    
        if (r0 != r31) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x04f0, code lost:
    
        throw com.google.android.gms.internal.measurement.x7.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x04f5, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x04f1, code lost:
    
        if (r0 > r31) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x04f3, code lost:
    
        if (r3 != r7) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x04fa, code lost:
    
        throw com.google.android.gms.internal.measurement.x7.e();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:110:0x0088. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.c6 r33) {
        /*
            Method dump skipped, instructions count: 1316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b9.n(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.c6):int");
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final T zza() {
        return (T) this.f5208k.a(this.f5202e);
    }
}
