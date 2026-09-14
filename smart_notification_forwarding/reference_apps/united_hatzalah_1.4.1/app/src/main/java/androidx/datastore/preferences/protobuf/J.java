package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.tika.pipes.PipesConfigBase;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class J implements S {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f3101n = new int[0];

    /* renamed from: o, reason: collision with root package name */
    public static final Unsafe f3102o = f0.i();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3103a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f3104b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3105c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3106d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0234a f3107e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3108f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f3109g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3110h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final L f3111j;

    /* renamed from: k, reason: collision with root package name */
    public final C0257y f3112k;

    /* renamed from: l, reason: collision with root package name */
    public final Y f3113l;

    /* renamed from: m, reason: collision with root package name */
    public final F f3114m;

    public J(int[] iArr, Object[] objArr, int i, int i3, AbstractC0234a abstractC0234a, int[] iArr2, int i4, int i5, L l3, C0257y c0257y, Y y, C0247n c0247n, F f4) {
        this.f3103a = iArr;
        this.f3104b = objArr;
        this.f3105c = i;
        this.f3106d = i3;
        this.f3108f = abstractC0234a instanceof AbstractC0253u;
        this.f3109g = iArr2;
        this.f3110h = i4;
        this.i = i5;
        this.f3111j = l3;
        this.f3112k = c0257y;
        this.f3113l = y;
        this.f3107e = abstractC0234a;
        this.f3114m = f4;
    }

    public static Field E(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int J(int i) {
        return (i & 267386880) >>> 20;
    }

    public static boolean o(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC0253u) {
            return ((AbstractC0253u) obj).g();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.J v(androidx.datastore.preferences.protobuf.Q r34, androidx.datastore.preferences.protobuf.L r35, androidx.datastore.preferences.protobuf.C0257y r36, androidx.datastore.preferences.protobuf.Y r37, androidx.datastore.preferences.protobuf.C0247n r38, androidx.datastore.preferences.protobuf.F r39) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.J.v(androidx.datastore.preferences.protobuf.Q, androidx.datastore.preferences.protobuf.L, androidx.datastore.preferences.protobuf.y, androidx.datastore.preferences.protobuf.Y, androidx.datastore.preferences.protobuf.n, androidx.datastore.preferences.protobuf.F):androidx.datastore.preferences.protobuf.J");
    }

    public static long w(int i) {
        return i & 1048575;
    }

    public static int x(long j2, Object obj) {
        return ((Integer) f0.f3168c.h(j2, obj)).intValue();
    }

    public static long y(long j2, Object obj) {
        return ((Long) f0.f3168c.h(j2, obj)).longValue();
    }

    public final void A(Object obj, long j2, C0243j c0243j, S s3, C0246m c0246m) {
        int C3;
        this.f3112k.getClass();
        InterfaceC0254v a2 = C0257y.a(j2, obj);
        M1.d dVar = c0243j.f3192a;
        int i = c0243j.f3193b;
        if ((i & 7) != 3) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            AbstractC0253u newInstance = s3.newInstance();
            c0243j.b(newInstance, s3, c0246m);
            s3.b(newInstance);
            ((P) a2).add(newInstance);
            if (!dVar.g() && c0243j.f3195d == 0) {
                C3 = dVar.C();
            } else {
                return;
            }
        } while (C3 == i);
        c0243j.f3195d = C3;
    }

    public final void B(Object obj, int i, C0243j c0243j, S s3, C0246m c0246m) {
        int C3;
        this.f3112k.getClass();
        InterfaceC0254v a2 = C0257y.a(i & 1048575, obj);
        M1.d dVar = c0243j.f3192a;
        int i3 = c0243j.f3193b;
        if ((i3 & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            AbstractC0253u newInstance = s3.newInstance();
            c0243j.c(newInstance, s3, c0246m);
            s3.b(newInstance);
            ((P) a2).add(newInstance);
            if (!dVar.g() && c0243j.f3195d == 0) {
                C3 = dVar.C();
            } else {
                return;
            }
        } while (C3 == i3);
        c0243j.f3195d = C3;
    }

    public final void C(int i, C0243j c0243j, Object obj) {
        if ((536870912 & i) != 0) {
            c0243j.w(2);
            f0.o(obj, i & 1048575, c0243j.f3192a.B());
        } else if (this.f3108f) {
            c0243j.w(2);
            f0.o(obj, i & 1048575, c0243j.f3192a.A());
        } else {
            f0.o(obj, i & 1048575, c0243j.e());
        }
    }

    public final void D(int i, C0243j c0243j, Object obj) {
        int i3 = 536870912 & i;
        C0257y c0257y = this.f3112k;
        if (i3 != 0) {
            c0257y.getClass();
            c0243j.s(C0257y.a(i & 1048575, obj), true);
        } else {
            c0257y.getClass();
            c0243j.s(C0257y.a(i & 1048575, obj), false);
        }
    }

    public final void F(int i, Object obj) {
        int i3 = this.f3103a[i + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        f0.m(obj, (1 << (i3 >>> 20)) | f0.f3168c.f(j2, obj), j2);
    }

    public final void G(Object obj, int i, int i3) {
        f0.m(obj, i, this.f3103a[i3 + 2] & 1048575);
    }

    public final void H(Object obj, int i, AbstractC0234a abstractC0234a) {
        f3102o.putObject(obj, K(i) & 1048575, abstractC0234a);
        F(i, obj);
    }

    public final void I(Object obj, int i, int i3, AbstractC0234a abstractC0234a) {
        f3102o.putObject(obj, K(i3) & 1048575, abstractC0234a);
        G(obj, i, i3);
    }

    public final int K(int i) {
        return this.f3103a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0045. Please report as an issue. */
    public final void L(Object obj, B b4) {
        int i;
        int i3;
        int i4;
        int i5;
        boolean z3;
        J j2 = this;
        int[] iArr = j2.f3103a;
        int length = iArr.length;
        Unsafe unsafe = f3102o;
        int i6 = 1048575;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int K3 = j2.K(i8);
            int i10 = iArr[i8];
            int J3 = J(K3);
            if (J3 <= 17) {
                int i11 = iArr[i8 + 2];
                int i12 = i11 & i6;
                if (i12 != i7) {
                    if (i12 == i6) {
                        i9 = 0;
                    } else {
                        i9 = unsafe.getInt(obj, i12);
                    }
                    i7 = i12;
                }
                i = K3;
                i3 = 1 << (i11 >>> 20);
            } else {
                i = K3;
                i3 = 0;
            }
            long j3 = i & i6;
            switch (J3) {
                case 0:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        double d2 = f0.f3168c.d(j3, obj);
                        C0244k c0244k = (C0244k) b4.f3089a;
                        c0244k.getClass();
                        c0244k.Y(i10, Double.doubleToRawLongBits(d2));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        float e4 = f0.f3168c.e(j3, obj);
                        C0244k c0244k2 = (C0244k) b4.f3089a;
                        c0244k2.getClass();
                        c0244k2.W(i10, Float.floatToRawIntBits(e4));
                    }
                    j2 = this;
                    break;
                case 2:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).i0(i10, unsafe.getLong(obj, j3));
                    }
                    j2 = this;
                    break;
                case 3:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).i0(i10, unsafe.getLong(obj, j3));
                    }
                    j2 = this;
                    break;
                case 4:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).a0(i10, unsafe.getInt(obj, j3));
                    }
                    j2 = this;
                    break;
                case 5:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).Y(i10, unsafe.getLong(obj, j3));
                    }
                    j2 = this;
                    break;
                case 6:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).W(i10, unsafe.getInt(obj, j3));
                    }
                    j2 = this;
                    break;
                case 7:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).T(i10, f0.f3168c.c(j3, obj));
                    }
                    j2 = this;
                    break;
                case 8:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        Object object = unsafe.getObject(obj, j3);
                        if (object instanceof String) {
                            ((C0244k) b4.f3089a).d0(i10, (String) object);
                        } else {
                            ((C0244k) b4.f3089a).U(i10, (C0240g) object);
                        }
                    }
                    j2 = this;
                    break;
                case 9:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).c0(i10, (AbstractC0234a) unsafe.getObject(obj, j3), j2.l(i8));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).U(i10, (C0240g) unsafe.getObject(obj, j3));
                    }
                    j2 = this;
                    break;
                case 11:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).g0(i10, unsafe.getInt(obj, j3));
                    }
                    j2 = this;
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).a0(i10, unsafe.getInt(obj, j3));
                    }
                    j2 = this;
                    break;
                case 13:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).W(i10, unsafe.getInt(obj, j3));
                    }
                    j2 = this;
                    break;
                case 14:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        ((C0244k) b4.f3089a).Y(i10, unsafe.getLong(obj, j3));
                    }
                    j2 = this;
                    break;
                case 15:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        int i13 = unsafe.getInt(obj, j3);
                        ((C0244k) b4.f3089a).g0(i10, (i13 >> 31) ^ (i13 << 1));
                    }
                    j2 = this;
                    break;
                case 16:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        long j4 = unsafe.getLong(obj, j3);
                        ((C0244k) b4.f3089a).i0(i10, (j4 >> 63) ^ (j4 << 1));
                    }
                    j2 = this;
                    break;
                case 17:
                    if (j2.n(obj, i8, i7, i9, i3)) {
                        b4.a(i10, unsafe.getObject(obj, j3), j2.l(i8));
                        break;
                    } else {
                        break;
                    }
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    i4 = i7;
                    T.n(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case 19:
                    i4 = i7;
                    T.r(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case 20:
                    i4 = i7;
                    T.t(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case 21:
                    i4 = i7;
                    T.z(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case 22:
                    i4 = i7;
                    T.s(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case 23:
                    i4 = i7;
                    T.q(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case 24:
                    i4 = i7;
                    T.p(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    i4 = i7;
                    T.m(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    i5 = i7;
                    int i14 = iArr[i8];
                    List list = (List) unsafe.getObject(obj, j3);
                    Class cls = T.f3130a;
                    if (list != null && !list.isEmpty()) {
                        b4.getClass();
                        for (int i15 = 0; i15 < list.size(); i15++) {
                            ((C0244k) b4.f3089a).d0(i14, (String) list.get(i15));
                        }
                    }
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    i5 = i7;
                    int i16 = iArr[i8];
                    List list2 = (List) unsafe.getObject(obj, j3);
                    S l3 = j2.l(i8);
                    Class cls2 = T.f3130a;
                    if (list2 != null && !list2.isEmpty()) {
                        b4.getClass();
                        for (int i17 = 0; i17 < list2.size(); i17++) {
                            ((C0244k) b4.f3089a).c0(i16, (AbstractC0234a) list2.get(i17), l3);
                        }
                    }
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    i5 = i7;
                    int i18 = iArr[i8];
                    List list3 = (List) unsafe.getObject(obj, j3);
                    Class cls3 = T.f3130a;
                    if (list3 != null && !list3.isEmpty()) {
                        b4.getClass();
                        for (int i19 = 0; i19 < list3.size(); i19++) {
                            ((C0244k) b4.f3089a).U(i18, (C0240g) list3.get(i19));
                        }
                    }
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    i4 = i7;
                    z3 = false;
                    T.y(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    i4 = i7;
                    z3 = false;
                    T.o(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    i4 = i7;
                    z3 = false;
                    T.u(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case 32:
                    i4 = i7;
                    z3 = false;
                    T.v(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    i4 = i7;
                    z3 = false;
                    T.w(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    i4 = i7;
                    z3 = false;
                    T.x(iArr[i8], (List) unsafe.getObject(obj, j3), b4, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    i5 = i7;
                    T.n(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    i5 = i7;
                    T.r(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 37:
                    i5 = i7;
                    T.t(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 38:
                    i5 = i7;
                    T.z(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 39:
                    i5 = i7;
                    T.s(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 40:
                    i5 = i7;
                    T.q(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 41:
                    i5 = i7;
                    T.p(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 42:
                    i5 = i7;
                    T.m(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 43:
                    i5 = i7;
                    T.y(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 44:
                    i5 = i7;
                    T.o(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 45:
                    i5 = i7;
                    T.u(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 46:
                    i5 = i7;
                    T.v(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 47:
                    i5 = i7;
                    T.w(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 48:
                    i5 = i7;
                    T.x(iArr[i8], (List) unsafe.getObject(obj, j3), b4, true);
                    i7 = i5;
                    break;
                case 49:
                    i5 = i7;
                    int i20 = iArr[i8];
                    List list4 = (List) unsafe.getObject(obj, j3);
                    S l4 = j2.l(i8);
                    Class cls4 = T.f3130a;
                    if (list4 != null && !list4.isEmpty()) {
                        b4.getClass();
                        for (int i21 = 0; i21 < list4.size(); i21++) {
                            b4.a(i20, list4.get(i21), l4);
                        }
                    }
                    i7 = i5;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j3);
                    if (object2 != null) {
                        int i22 = 2;
                        Object obj2 = j2.f3104b[(i8 / 3) * 2];
                        j2.f3114m.getClass();
                        C c4 = ((D) obj2).f3093a;
                        C0244k c0244k3 = (C0244k) b4.f3089a;
                        c0244k3.getClass();
                        for (Map.Entry entry : ((E) object2).entrySet()) {
                            c0244k3.f0(i10, i22);
                            c0244k3.h0(D.a(c4, entry.getKey(), entry.getValue()));
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            C0249p.b(c0244k3, c4.f3090a, 1, key);
                            i22 = 2;
                            C0249p.b(c0244k3, c4.f3091b, 2, value);
                            i7 = i7;
                        }
                    }
                    i5 = i7;
                    i7 = i5;
                    break;
                case 51:
                    if (j2.p(obj, i10, i8)) {
                        double doubleValue = ((Double) f0.f3168c.h(j3, obj)).doubleValue();
                        C0244k c0244k4 = (C0244k) b4.f3089a;
                        c0244k4.getClass();
                        c0244k4.Y(i10, Double.doubleToRawLongBits(doubleValue));
                    }
                    break;
                case 52:
                    if (j2.p(obj, i10, i8)) {
                        float floatValue = ((Float) f0.f3168c.h(j3, obj)).floatValue();
                        C0244k c0244k5 = (C0244k) b4.f3089a;
                        c0244k5.getClass();
                        c0244k5.W(i10, Float.floatToRawIntBits(floatValue));
                    }
                    break;
                case 53:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).i0(i10, y(j3, obj));
                    }
                    break;
                case 54:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).i0(i10, y(j3, obj));
                    }
                    break;
                case 55:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).a0(i10, x(j3, obj));
                    }
                    break;
                case 56:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).Y(i10, y(j3, obj));
                    }
                    break;
                case 57:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).W(i10, x(j3, obj));
                    }
                    break;
                case 58:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).T(i10, ((Boolean) f0.f3168c.h(j3, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (j2.p(obj, i10, i8)) {
                        Object object3 = unsafe.getObject(obj, j3);
                        if (object3 instanceof String) {
                            ((C0244k) b4.f3089a).d0(i10, (String) object3);
                        } else {
                            ((C0244k) b4.f3089a).U(i10, (C0240g) object3);
                        }
                    }
                    break;
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).c0(i10, (AbstractC0234a) unsafe.getObject(obj, j3), j2.l(i8));
                    }
                    break;
                case 61:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).U(i10, (C0240g) unsafe.getObject(obj, j3));
                    }
                    break;
                case 62:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).g0(i10, x(j3, obj));
                    }
                    break;
                case 63:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).a0(i10, x(j3, obj));
                    }
                    break;
                case 64:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).W(i10, x(j3, obj));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (j2.p(obj, i10, i8)) {
                        ((C0244k) b4.f3089a).Y(i10, y(j3, obj));
                    }
                    break;
                case 66:
                    if (j2.p(obj, i10, i8)) {
                        int x3 = x(j3, obj);
                        ((C0244k) b4.f3089a).g0(i10, (x3 >> 31) ^ (x3 << 1));
                    }
                    break;
                case 67:
                    if (j2.p(obj, i10, i8)) {
                        long y = y(j3, obj);
                        ((C0244k) b4.f3089a).i0(i10, (y << 1) ^ (y >> 63));
                    }
                    break;
                case 68:
                    if (j2.p(obj, i10, i8)) {
                        b4.a(i10, unsafe.getObject(obj, j3), j2.l(i8));
                    }
                    break;
            }
            i8 += 3;
            i6 = 1048575;
        }
        ((a0) j2.f3113l).getClass();
        ((AbstractC0253u) obj).unknownFields.d(b4);
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final void a(Object obj, Object obj2) {
        Object obj3;
        if (o(obj)) {
            obj2.getClass();
            int i = 0;
            while (true) {
                int[] iArr = this.f3103a;
                if (i < iArr.length) {
                    int K3 = K(i);
                    long j2 = 1048575 & K3;
                    int i3 = iArr[i];
                    switch (J(K3)) {
                        case 0:
                            if (m(i, obj2)) {
                                e0 e0Var = f0.f3168c;
                                obj3 = obj;
                                e0Var.l(obj3, j2, e0Var.d(j2, obj2));
                                F(i, obj3);
                                break;
                            }
                            break;
                        case 1:
                            if (m(i, obj2)) {
                                e0 e0Var2 = f0.f3168c;
                                e0Var2.m(obj, j2, e0Var2.e(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 2:
                            if (m(i, obj2)) {
                                f0.n(obj, j2, f0.f3168c.g(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 3:
                            if (m(i, obj2)) {
                                f0.n(obj, j2, f0.f3168c.g(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 4:
                            if (m(i, obj2)) {
                                f0.m(obj, f0.f3168c.f(j2, obj2), j2);
                                F(i, obj);
                                break;
                            }
                            break;
                        case 5:
                            if (m(i, obj2)) {
                                f0.n(obj, j2, f0.f3168c.g(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 6:
                            if (m(i, obj2)) {
                                f0.m(obj, f0.f3168c.f(j2, obj2), j2);
                                F(i, obj);
                                break;
                            }
                            break;
                        case 7:
                            if (m(i, obj2)) {
                                e0 e0Var3 = f0.f3168c;
                                e0Var3.j(obj, j2, e0Var3.c(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 8:
                            if (m(i, obj2)) {
                                f0.o(obj, j2, f0.f3168c.h(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 9:
                            r(i, obj, obj2);
                            break;
                        case 10:
                            if (m(i, obj2)) {
                                f0.o(obj, j2, f0.f3168c.h(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 11:
                            if (m(i, obj2)) {
                                f0.m(obj, f0.f3168c.f(j2, obj2), j2);
                                F(i, obj);
                                break;
                            }
                            break;
                        case Code.UNIMPLEMENTED /* 12 */:
                            if (m(i, obj2)) {
                                f0.m(obj, f0.f3168c.f(j2, obj2), j2);
                                F(i, obj);
                                break;
                            }
                            break;
                        case 13:
                            if (m(i, obj2)) {
                                f0.m(obj, f0.f3168c.f(j2, obj2), j2);
                                F(i, obj);
                                break;
                            }
                            break;
                        case 14:
                            if (m(i, obj2)) {
                                f0.n(obj, j2, f0.f3168c.g(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 15:
                            if (m(i, obj2)) {
                                f0.m(obj, f0.f3168c.f(j2, obj2), j2);
                                F(i, obj);
                                break;
                            }
                            break;
                        case 16:
                            if (m(i, obj2)) {
                                f0.n(obj, j2, f0.f3168c.g(j2, obj2));
                                F(i, obj);
                                break;
                            }
                            break;
                        case 17:
                            r(i, obj, obj2);
                            break;
                        case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case Build.API_LEVELS.API_25 /* 25 */:
                        case Build.API_LEVELS.API_26 /* 26 */:
                        case Build.API_LEVELS.API_27 /* 27 */:
                        case Build.API_LEVELS.API_28 /* 28 */:
                        case Build.API_LEVELS.API_29 /* 29 */:
                        case Build.API_LEVELS.API_30 /* 30 */:
                        case Build.API_LEVELS.API_31 /* 31 */:
                        case 32:
                        case Build.API_LEVELS.API_33 /* 33 */:
                        case Build.API_LEVELS.API_34 /* 34 */:
                        case Build.API_LEVELS.API_35 /* 35 */:
                        case Build.API_LEVELS.API_36 /* 36 */:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.f3112k.getClass();
                            e0 e0Var4 = f0.f3168c;
                            InterfaceC0254v interfaceC0254v = (InterfaceC0254v) e0Var4.h(j2, obj);
                            InterfaceC0254v interfaceC0254v2 = (InterfaceC0254v) e0Var4.h(j2, obj2);
                            P p = (P) interfaceC0254v;
                            int i4 = p.f3125c;
                            int i5 = ((P) interfaceC0254v2).f3125c;
                            if (i4 > 0 && i5 > 0) {
                                if (!((AbstractC0235b) interfaceC0254v).f3154a) {
                                    interfaceC0254v = p.h(i5 + i4);
                                }
                                ((AbstractC0235b) interfaceC0254v).addAll(interfaceC0254v2);
                            }
                            if (i4 > 0) {
                                interfaceC0254v2 = interfaceC0254v;
                            }
                            f0.o(obj, j2, interfaceC0254v2);
                            break;
                        case 50:
                            Class cls = T.f3130a;
                            e0 e0Var5 = f0.f3168c;
                            Object h2 = e0Var5.h(j2, obj);
                            Object h3 = e0Var5.h(j2, obj2);
                            this.f3114m.getClass();
                            f0.o(obj, j2, F.a(h2, h3));
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            if (p(obj2, i3, i)) {
                                f0.o(obj, j2, f0.f3168c.h(j2, obj2));
                                G(obj, i3, i);
                                break;
                            }
                            break;
                        case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                            s(i, obj, obj2);
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        case 66:
                        case 67:
                            if (p(obj2, i3, i)) {
                                f0.o(obj, j2, f0.f3168c.h(j2, obj2));
                                G(obj, i3, i);
                                break;
                            }
                            break;
                        case 68:
                            s(i, obj, obj2);
                            break;
                    }
                    obj3 = obj;
                    i += 3;
                    obj = obj3;
                } else {
                    T.k(this.f3113l, obj, obj2);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final void b(Object obj) {
        if (o(obj)) {
            if (obj instanceof AbstractC0253u) {
                AbstractC0253u abstractC0253u = (AbstractC0253u) obj;
                abstractC0253u.k(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                abstractC0253u.memoizedHashCode = 0;
                abstractC0253u.h();
            }
            int[] iArr = this.f3103a;
            int length = iArr.length;
            for (int i = 0; i < length; i += 3) {
                int K3 = K(i);
                long j2 = 1048575 & K3;
                int J3 = J(K3);
                if (J3 != 9) {
                    if (J3 != 60 && J3 != 68) {
                        switch (J3) {
                            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case Build.API_LEVELS.API_25 /* 25 */:
                            case Build.API_LEVELS.API_26 /* 26 */:
                            case Build.API_LEVELS.API_27 /* 27 */:
                            case Build.API_LEVELS.API_28 /* 28 */:
                            case Build.API_LEVELS.API_29 /* 29 */:
                            case Build.API_LEVELS.API_30 /* 30 */:
                            case Build.API_LEVELS.API_31 /* 31 */:
                            case 32:
                            case Build.API_LEVELS.API_33 /* 33 */:
                            case Build.API_LEVELS.API_34 /* 34 */:
                            case Build.API_LEVELS.API_35 /* 35 */:
                            case Build.API_LEVELS.API_36 /* 36 */:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.f3112k.getClass();
                                AbstractC0235b abstractC0235b = (AbstractC0235b) ((InterfaceC0254v) f0.f3168c.h(j2, obj));
                                if (abstractC0235b.f3154a) {
                                    abstractC0235b.f3154a = false;
                                    break;
                                } else {
                                    break;
                                }
                            case 50:
                                Unsafe unsafe = f3102o;
                                Object object = unsafe.getObject(obj, j2);
                                if (object != null) {
                                    this.f3114m.getClass();
                                    ((E) object).f3096a = false;
                                    unsafe.putObject(obj, j2, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (p(obj, iArr[i], i)) {
                        l(i).b(f3102o.getObject(obj, j2));
                    }
                }
                if (m(i, obj)) {
                    l(i).b(f3102o.getObject(obj, j2));
                }
            }
            ((a0) this.f3113l).getClass();
            Z z3 = ((AbstractC0253u) obj).unknownFields;
            if (z3.f3153e) {
                z3.f3153e = false;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final boolean c(Object obj) {
        int i;
        int i3;
        int i4;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < this.f3110h) {
            int i8 = this.f3109g[i7];
            int[] iArr = this.f3103a;
            int i9 = iArr[i8];
            int K3 = K(i8);
            int i10 = iArr[i8 + 2];
            int i11 = i10 & 1048575;
            int i12 = 1 << (i10 >>> 20);
            if (i11 != i5) {
                if (i11 != 1048575) {
                    i6 = f3102o.getInt(obj, i11);
                }
                i3 = i8;
                i4 = i6;
                i = i11;
            } else {
                int i13 = i6;
                i = i5;
                i3 = i8;
                i4 = i13;
            }
            if ((268435456 & K3) == 0 || n(obj, i3, i, i4, i12)) {
                int J3 = J(K3);
                if (J3 != 9 && J3 != 17) {
                    if (J3 != 27) {
                        if (J3 != 60 && J3 != 68) {
                            if (J3 != 49) {
                                if (J3 != 50) {
                                    continue;
                                } else {
                                    Object h2 = f0.f3168c.h(K3 & 1048575, obj);
                                    this.f3114m.getClass();
                                    E e4 = (E) h2;
                                    if (e4.isEmpty()) {
                                        continue;
                                    } else {
                                        if (((D) this.f3104b[(i3 / 3) * 2]).f3093a.f3091b.f3209a != o0.MESSAGE) {
                                            continue;
                                        } else {
                                            S s3 = null;
                                            for (Object obj2 : e4.values()) {
                                                if (s3 == null) {
                                                    s3 = O.f3120c.a(obj2.getClass());
                                                }
                                                if (!s3.c(obj2)) {
                                                }
                                            }
                                        }
                                    }
                                }
                                i7++;
                                i5 = i;
                                i6 = i4;
                            }
                        } else {
                            if (p(obj, i9, i3)) {
                                if (!l(i3).c(f0.f3168c.h(K3 & 1048575, obj))) {
                                }
                            } else {
                                continue;
                            }
                            i7++;
                            i5 = i;
                            i6 = i4;
                        }
                    }
                    List list = (List) f0.f3168c.h(K3 & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        S l3 = l(i3);
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            if (l3.c(list.get(i14))) {
                            }
                        }
                    }
                    i7++;
                    i5 = i;
                    i6 = i4;
                } else {
                    if (n(obj, i3, i, i4, i12)) {
                        if (!l(i3).c(f0.f3168c.h(K3 & 1048575, obj))) {
                        }
                    } else {
                        continue;
                    }
                    i7++;
                    i5 = i;
                    i6 = i4;
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final void d(Object obj, B b4) {
        b4.getClass();
        L(obj, b4);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0048. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.S
    public final int e(AbstractC0253u abstractC0253u) {
        int i;
        int M3;
        int M4;
        int M5;
        int O3;
        int M6;
        int O4;
        int M7;
        int M8;
        int L3;
        int K3;
        int M9;
        int a2;
        int c4;
        int M10;
        int size;
        int i3;
        int M11;
        int M12;
        int M13;
        int size2;
        int M14;
        int N3;
        int i4;
        int i5;
        int M15;
        int L4;
        int N4;
        J j2 = this;
        AbstractC0253u abstractC0253u2 = abstractC0253u;
        Unsafe unsafe = f3102o;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = j2.f3103a;
            if (i7 < iArr.length) {
                int K4 = j2.K(i7);
                int J3 = J(K4);
                int i10 = iArr[i7];
                int i11 = iArr[i7 + 2];
                int i12 = i11 & 1048575;
                if (J3 <= 17) {
                    if (i12 != i6) {
                        if (i12 == 1048575) {
                            i8 = 0;
                        } else {
                            i8 = unsafe.getInt(abstractC0253u2, i12);
                        }
                        i6 = i12;
                    }
                    i = 1 << (i11 >>> 20);
                } else {
                    i = 0;
                }
                long j3 = K4 & 1048575;
                if (J3 >= EnumC0250q.f3227b.f3231a) {
                    int i13 = EnumC0250q.f3228c.f3231a;
                }
                switch (J3) {
                    case 0:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            M3 = C0244k.M(i10);
                            c4 = M3 + 8;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            M4 = C0244k.M(i10);
                            M8 = M4 + 4;
                            i9 += M8;
                        }
                        j2 = this;
                        abstractC0253u2 = abstractC0253u;
                        break;
                    case 2:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            long j4 = unsafe.getLong(abstractC0253u2, j3);
                            M5 = C0244k.M(i10);
                            O3 = C0244k.O(j4);
                            i9 += O3 + M5;
                        }
                        j2 = this;
                        break;
                    case 3:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            long j5 = unsafe.getLong(abstractC0253u2, j3);
                            M5 = C0244k.M(i10);
                            O3 = C0244k.O(j5);
                            i9 += O3 + M5;
                        }
                        j2 = this;
                        break;
                    case 4:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            int i14 = unsafe.getInt(abstractC0253u2, j3);
                            M6 = C0244k.M(i10);
                            O4 = C0244k.O(i14);
                            K3 = O4 + M6;
                            i9 += K3;
                        }
                        j2 = this;
                        break;
                    case 5:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            M7 = C0244k.M(i10);
                            M8 = M7 + 8;
                            i9 += M8;
                        }
                        j2 = this;
                        abstractC0253u2 = abstractC0253u;
                        break;
                    case 6:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            M4 = C0244k.M(i10);
                            M8 = M4 + 4;
                            i9 += M8;
                        }
                        j2 = this;
                        abstractC0253u2 = abstractC0253u;
                        break;
                    case 7:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            M8 = C0244k.M(i10) + 1;
                            i9 += M8;
                        }
                        j2 = this;
                        abstractC0253u2 = abstractC0253u;
                        break;
                    case 8:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            Object object = unsafe.getObject(abstractC0253u2, j3);
                            if (object instanceof C0240g) {
                                L3 = C0244k.K(i10, (C0240g) object);
                            } else {
                                L3 = C0244k.L((String) object) + C0244k.M(i10);
                            }
                            i9 = L3 + i9;
                        }
                        j2 = this;
                        break;
                    case 9:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            Object object2 = unsafe.getObject(abstractC0253u2, j3);
                            S l3 = j2.l(i7);
                            Class cls = T.f3130a;
                            int M16 = C0244k.M(i10);
                            int a4 = ((AbstractC0234a) object2).a(l3);
                            i9 += C0244k.N(a4) + a4 + M16;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            K3 = C0244k.K(i10, (C0240g) unsafe.getObject(abstractC0253u2, j3));
                            i9 += K3;
                        }
                        j2 = this;
                        break;
                    case 11:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            int i15 = unsafe.getInt(abstractC0253u2, j3);
                            M6 = C0244k.M(i10);
                            O4 = C0244k.N(i15);
                            K3 = O4 + M6;
                            i9 += K3;
                        }
                        j2 = this;
                        break;
                    case Code.UNIMPLEMENTED /* 12 */:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            int i16 = unsafe.getInt(abstractC0253u2, j3);
                            M6 = C0244k.M(i10);
                            O4 = C0244k.O(i16);
                            K3 = O4 + M6;
                            i9 += K3;
                        }
                        j2 = this;
                        break;
                    case 13:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            M4 = C0244k.M(i10);
                            M8 = M4 + 4;
                            i9 += M8;
                        }
                        j2 = this;
                        abstractC0253u2 = abstractC0253u;
                        break;
                    case 14:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            M7 = C0244k.M(i10);
                            M8 = M7 + 8;
                            i9 += M8;
                        }
                        j2 = this;
                        abstractC0253u2 = abstractC0253u;
                        break;
                    case 15:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            int i17 = unsafe.getInt(abstractC0253u2, j3);
                            M6 = C0244k.M(i10);
                            O4 = C0244k.N((i17 >> 31) ^ (i17 << 1));
                            K3 = O4 + M6;
                            i9 += K3;
                        }
                        j2 = this;
                        break;
                    case 16:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            long j6 = unsafe.getLong(abstractC0253u2, j3);
                            M5 = C0244k.M(i10);
                            O3 = C0244k.O((j6 << 1) ^ (j6 >> 63));
                            i9 += O3 + M5;
                        }
                        j2 = this;
                        break;
                    case 17:
                        if (j2.n(abstractC0253u2, i7, i6, i8, i)) {
                            AbstractC0234a abstractC0234a = (AbstractC0234a) unsafe.getObject(abstractC0253u2, j3);
                            S l4 = j2.l(i7);
                            M9 = C0244k.M(i10) * 2;
                            a2 = abstractC0234a.a(l4);
                            c4 = a2 + M9;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        c4 = T.c(i10, (List) unsafe.getObject(abstractC0253u2, j3));
                        i9 += c4;
                        break;
                    case 19:
                        c4 = T.b(i10, (List) unsafe.getObject(abstractC0253u2, j3));
                        i9 += c4;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls2 = T.f3130a;
                        if (list.size() != 0) {
                            M10 = (C0244k.M(i10) * list.size()) + T.e(list);
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case 21:
                        List list2 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls3 = T.f3130a;
                        size = list2.size();
                        if (size != 0) {
                            i3 = T.i(list2);
                            M11 = C0244k.M(i10);
                            M10 = (M11 * size) + i3;
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case 22:
                        List list3 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls4 = T.f3130a;
                        size = list3.size();
                        if (size != 0) {
                            i3 = T.d(list3);
                            M11 = C0244k.M(i10);
                            M10 = (M11 * size) + i3;
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case 23:
                        c4 = T.c(i10, (List) unsafe.getObject(abstractC0253u2, j3));
                        i9 += c4;
                        break;
                    case 24:
                        c4 = T.b(i10, (List) unsafe.getObject(abstractC0253u2, j3));
                        i9 += c4;
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        List list4 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls5 = T.f3130a;
                        int size3 = list4.size();
                        if (size3 == 0) {
                            M12 = 0;
                        } else {
                            M12 = (C0244k.M(i10) + 1) * size3;
                        }
                        i9 += M12;
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        List list5 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls6 = T.f3130a;
                        int size4 = list5.size();
                        if (size4 != 0) {
                            M10 = C0244k.M(i10) * size4;
                            for (int i18 = 0; i18 < size4; i18++) {
                                Object obj = list5.get(i18);
                                if (obj instanceof C0240g) {
                                    int size5 = ((C0240g) obj).size();
                                    M10 = C0244k.N(size5) + size5 + M10;
                                } else {
                                    M10 = C0244k.L((String) obj) + M10;
                                }
                            }
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        List list6 = (List) unsafe.getObject(abstractC0253u2, j3);
                        S l5 = j2.l(i7);
                        Class cls7 = T.f3130a;
                        int size6 = list6.size();
                        if (size6 != 0) {
                            M13 = C0244k.M(i10) * size6;
                            for (int i19 = 0; i19 < size6; i19++) {
                                int a5 = ((AbstractC0234a) list6.get(i19)).a(l5);
                                M13 += C0244k.N(a5) + a5;
                            }
                            i9 += M13;
                            break;
                        }
                        M13 = 0;
                        i9 += M13;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        List list7 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls8 = T.f3130a;
                        int size7 = list7.size();
                        if (size7 != 0) {
                            M10 = C0244k.M(i10) * size7;
                            for (int i20 = 0; i20 < list7.size(); i20++) {
                                int size8 = ((C0240g) list7.get(i20)).size();
                                M10 += C0244k.N(size8) + size8;
                            }
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        List list8 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls9 = T.f3130a;
                        size = list8.size();
                        if (size != 0) {
                            i3 = T.h(list8);
                            M11 = C0244k.M(i10);
                            M10 = (M11 * size) + i3;
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        List list9 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls10 = T.f3130a;
                        size = list9.size();
                        if (size != 0) {
                            i3 = T.a(list9);
                            M11 = C0244k.M(i10);
                            M10 = (M11 * size) + i3;
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        c4 = T.b(i10, (List) unsafe.getObject(abstractC0253u2, j3));
                        i9 += c4;
                        break;
                    case 32:
                        c4 = T.c(i10, (List) unsafe.getObject(abstractC0253u2, j3));
                        i9 += c4;
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        List list10 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls11 = T.f3130a;
                        size = list10.size();
                        if (size != 0) {
                            i3 = T.f(list10);
                            M11 = C0244k.M(i10);
                            M10 = (M11 * size) + i3;
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        List list11 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls12 = T.f3130a;
                        size = list11.size();
                        if (size != 0) {
                            i3 = T.g(list11);
                            M11 = C0244k.M(i10);
                            M10 = (M11 * size) + i3;
                            i9 += M10;
                            break;
                        }
                        M10 = 0;
                        i9 += M10;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        List list12 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls13 = T.f3130a;
                        size2 = list12.size() * 8;
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case Build.API_LEVELS.API_36 /* 36 */:
                        List list13 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls14 = T.f3130a;
                        size2 = list13.size() * 4;
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        size2 = T.e((List) unsafe.getObject(abstractC0253u2, j3));
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        size2 = T.i((List) unsafe.getObject(abstractC0253u2, j3));
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        size2 = T.d((List) unsafe.getObject(abstractC0253u2, j3));
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        List list14 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls15 = T.f3130a;
                        size2 = list14.size() * 8;
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        List list15 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls16 = T.f3130a;
                        size2 = list15.size() * 4;
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list16 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls17 = T.f3130a;
                        size2 = list16.size();
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        size2 = T.h((List) unsafe.getObject(abstractC0253u2, j3));
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        size2 = T.a((List) unsafe.getObject(abstractC0253u2, j3));
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        List list17 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls18 = T.f3130a;
                        size2 = list17.size() * 4;
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        List list18 = (List) unsafe.getObject(abstractC0253u2, j3);
                        Class cls19 = T.f3130a;
                        size2 = list18.size() * 8;
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        size2 = T.f((List) unsafe.getObject(abstractC0253u2, j3));
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        size2 = T.g((List) unsafe.getObject(abstractC0253u2, j3));
                        if (size2 > 0) {
                            M14 = C0244k.M(i10);
                            N3 = C0244k.N(size2);
                            i4 = N3 + M14;
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list19 = (List) unsafe.getObject(abstractC0253u2, j3);
                        S l6 = j2.l(i7);
                        Class cls20 = T.f3130a;
                        int size9 = list19.size();
                        if (size9 == 0) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                            for (int i21 = 0; i21 < size9; i21++) {
                                i5 += ((AbstractC0234a) list19.get(i21)).a(l6) + (C0244k.M(i10) * 2);
                            }
                        }
                        i9 += i5;
                        break;
                    case 50:
                        Object object3 = unsafe.getObject(abstractC0253u2, j3);
                        Object obj2 = j2.f3104b[(i7 / 3) * 2];
                        j2.f3114m.getClass();
                        E e4 = (E) object3;
                        D d2 = (D) obj2;
                        if (!e4.isEmpty()) {
                            M13 = 0;
                            for (Map.Entry entry : e4.entrySet()) {
                                Object key = entry.getKey();
                                Object value = entry.getValue();
                                d2.getClass();
                                int M17 = C0244k.M(i10);
                                int a6 = D.a(d2.f3093a, key, value);
                                M13 += C0244k.N(a6) + a6 + M17;
                            }
                            i9 += M13;
                            break;
                        }
                        M13 = 0;
                        i9 += M13;
                    case 51:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            M3 = C0244k.M(i10);
                            c4 = M3 + 8;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            M15 = C0244k.M(i10);
                            c4 = M15 + 4;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            long y = y(j3, abstractC0253u2);
                            size2 = C0244k.M(i10);
                            i4 = C0244k.O(y);
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            long y3 = y(j3, abstractC0253u2);
                            size2 = C0244k.M(i10);
                            i4 = C0244k.O(y3);
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            int x3 = x(j3, abstractC0253u2);
                            M9 = C0244k.M(i10);
                            a2 = C0244k.O(x3);
                            c4 = a2 + M9;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            M3 = C0244k.M(i10);
                            c4 = M3 + 8;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            M15 = C0244k.M(i10);
                            c4 = M15 + 4;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            c4 = C0244k.M(i10) + 1;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            Object object4 = unsafe.getObject(abstractC0253u2, j3);
                            if (object4 instanceof C0240g) {
                                L4 = C0244k.K(i10, (C0240g) object4);
                            } else {
                                L4 = C0244k.L((String) object4) + C0244k.M(i10);
                            }
                            i9 = L4 + i9;
                            break;
                        } else {
                            break;
                        }
                    case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            Object object5 = unsafe.getObject(abstractC0253u2, j3);
                            S l7 = j2.l(i7);
                            Class cls21 = T.f3130a;
                            int M18 = C0244k.M(i10);
                            int a7 = ((AbstractC0234a) object5).a(l7);
                            N4 = C0244k.N(a7) + a7 + M18;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            c4 = C0244k.K(i10, (C0240g) unsafe.getObject(abstractC0253u2, j3));
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            int x4 = x(j3, abstractC0253u2);
                            M9 = C0244k.M(i10);
                            a2 = C0244k.N(x4);
                            c4 = a2 + M9;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            int x5 = x(j3, abstractC0253u2);
                            M9 = C0244k.M(i10);
                            a2 = C0244k.O(x5);
                            c4 = a2 + M9;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            M15 = C0244k.M(i10);
                            c4 = M15 + 4;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            M3 = C0244k.M(i10);
                            c4 = M3 + 8;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            int x6 = x(j3, abstractC0253u2);
                            M9 = C0244k.M(i10);
                            a2 = C0244k.N((x6 >> 31) ^ (x6 << 1));
                            c4 = a2 + M9;
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            long y4 = y(j3, abstractC0253u2);
                            size2 = C0244k.M(i10);
                            i4 = C0244k.O((y4 << 1) ^ (y4 >> 63));
                            N4 = i4 + size2;
                            i9 += N4;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (j2.p(abstractC0253u2, i10, i7)) {
                            c4 = ((AbstractC0234a) unsafe.getObject(abstractC0253u2, j3)).a(j2.l(i7)) + (C0244k.M(i10) * 2);
                            i9 += c4;
                            break;
                        } else {
                            break;
                        }
                }
                i7 += 3;
            } else {
                ((a0) j2.f3113l).getClass();
                return abstractC0253u2.unknownFields.b() + i9;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0216, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00df, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
    
        r8 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e2, code lost:
    
        r3 = r8 + r3;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001c. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.S
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(androidx.datastore.preferences.protobuf.AbstractC0253u r12) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.J.f(androidx.datastore.preferences.protobuf.u):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        if (androidx.datastore.preferences.protobuf.T.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0108, code lost:
    
        if (androidx.datastore.preferences.protobuf.T.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (androidx.datastore.preferences.protobuf.T.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0138, code lost:
    
        if (androidx.datastore.preferences.protobuf.T.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014c, code lost:
    
        if (r5.c(r7, r12) == r5.c(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019f, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b4, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cf, code lost:
    
        if (java.lang.Float.floatToIntBits(r5.e(r7, r12)) == java.lang.Float.floatToIntBits(r5.e(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ec, code lost:
    
        if (java.lang.Double.doubleToLongBits(r5.d(r7, r12)) == java.lang.Double.doubleToLongBits(r5.d(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (androidx.datastore.preferences.protobuf.T.l(r9.h(r7, r12), r9.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.S
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(androidx.datastore.preferences.protobuf.AbstractC0253u r12, androidx.datastore.preferences.protobuf.AbstractC0253u r13) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.J.g(androidx.datastore.preferences.protobuf.u, androidx.datastore.preferences.protobuf.u):boolean");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // androidx.datastore.preferences.protobuf.S
    public final void h(java.lang.Object r19, androidx.datastore.preferences.protobuf.C0243j r20, androidx.datastore.preferences.protobuf.C0246m r21) {
        /*
            Method dump skipped, instructions count: 1882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.J.h(java.lang.Object, androidx.datastore.preferences.protobuf.j, androidx.datastore.preferences.protobuf.m):void");
    }

    public final boolean i(AbstractC0253u abstractC0253u, AbstractC0253u abstractC0253u2, int i) {
        if (m(i, abstractC0253u) == m(i, abstractC0253u2)) {
            return true;
        }
        return false;
    }

    public final void j(int i, Object obj, Object obj2) {
        int i3 = this.f3103a[i];
        if (f0.f3168c.h(K(i) & 1048575, obj) == null) {
            return;
        }
        k(i);
    }

    public final void k(int i) {
        if (this.f3104b[((i / 3) * 2) + 1] == null) {
        } else {
            throw new ClassCastException();
        }
    }

    public final S l(int i) {
        int i3 = (i / 3) * 2;
        Object[] objArr = this.f3104b;
        S s3 = (S) objArr[i3];
        if (s3 != null) {
            return s3;
        }
        S a2 = O.f3120c.a((Class) objArr[i3 + 1]);
        objArr[i3] = a2;
        return a2;
    }

    public final boolean m(int i, Object obj) {
        int i3 = this.f3103a[i + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int K3 = K(i);
            long j3 = K3 & 1048575;
            switch (J(K3)) {
                case 0:
                    if (Double.doubleToRawLongBits(f0.f3168c.d(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(f0.f3168c.e(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (f0.f3168c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (f0.f3168c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (f0.f3168c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (f0.f3168c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (f0.f3168c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return f0.f3168c.c(j3, obj);
                case 8:
                    Object h2 = f0.f3168c.h(j3, obj);
                    if (h2 instanceof String) {
                        return !((String) h2).isEmpty();
                    }
                    if (h2 instanceof C0240g) {
                        return !C0240g.f3173c.equals(h2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (f0.f3168c.h(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !C0240g.f3173c.equals(f0.f3168c.h(j3, obj));
                case 11:
                    if (f0.f3168c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    if (f0.f3168c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (f0.f3168c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (f0.f3168c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (f0.f3168c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (f0.f3168c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (f0.f3168c.h(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i3 >>> 20)) & f0.f3168c.f(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean n(Object obj, int i, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return m(i, obj);
        }
        if ((i4 & i5) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final AbstractC0253u newInstance() {
        this.f3111j.getClass();
        return ((AbstractC0253u) this.f3107e).i();
    }

    public final boolean p(Object obj, int i, int i3) {
        if (f0.f3168c.f(this.f3103a[i3 + 2] & 1048575, obj) == i) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
    
        r10.put(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
    
        r0.j(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(java.lang.Object r9, int r10, java.lang.Object r11, androidx.datastore.preferences.protobuf.C0246m r12, androidx.datastore.preferences.protobuf.C0243j r13) {
        /*
            r8 = this;
            int r10 = r8.K(r10)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r0
            long r0 = (long) r10
            androidx.datastore.preferences.protobuf.e0 r10 = androidx.datastore.preferences.protobuf.f0.f3168c
            java.lang.Object r10 = r10.h(r0, r9)
            androidx.datastore.preferences.protobuf.F r2 = r8.f3114m
            if (r10 != 0) goto L20
            r2.getClass()
            androidx.datastore.preferences.protobuf.E r10 = androidx.datastore.preferences.protobuf.E.f3095b
            androidx.datastore.preferences.protobuf.E r10 = r10.b()
            androidx.datastore.preferences.protobuf.f0.o(r9, r0, r10)
            goto L37
        L20:
            r2.getClass()
            r3 = r10
            androidx.datastore.preferences.protobuf.E r3 = (androidx.datastore.preferences.protobuf.E) r3
            boolean r3 = r3.f3096a
            if (r3 != 0) goto L37
            androidx.datastore.preferences.protobuf.E r3 = androidx.datastore.preferences.protobuf.E.f3095b
            androidx.datastore.preferences.protobuf.E r3 = r3.b()
            androidx.datastore.preferences.protobuf.F.a(r3, r10)
            androidx.datastore.preferences.protobuf.f0.o(r9, r0, r3)
            r10 = r3
        L37:
            r2.getClass()
            androidx.datastore.preferences.protobuf.E r10 = (androidx.datastore.preferences.protobuf.E) r10
            androidx.datastore.preferences.protobuf.D r11 = (androidx.datastore.preferences.protobuf.D) r11
            androidx.datastore.preferences.protobuf.C r9 = r11.f3093a
            r11 = 2
            r13.w(r11)
            M1.d r0 = r13.f3192a
            int r1 = r0.D()
            int r1 = r0.l(r1)
            java.lang.Object r2 = r9.f3092c
            java.lang.String r3 = ""
            r4 = r2
        L53:
            int r5 = r13.a()     // Catch: java.lang.Throwable -> L77
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r6) goto L99
            boolean r6 = r0.g()     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L63
            goto L99
        L63:
            r6 = 1
            java.lang.String r7 = "Unable to parse map entry."
            if (r5 == r6) goto L84
            if (r5 == r11) goto L79
            boolean r5 = r13.x()     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            if (r5 == 0) goto L71
            goto L53
        L71:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            throw r5     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
        L77:
            r9 = move-exception
            goto La0
        L79:
            androidx.datastore.preferences.protobuf.n0 r5 = r9.f3091b     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            java.lang.Class r6 = r2.getClass()     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            java.lang.Object r4 = r13.i(r5, r6, r12)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            goto L53
        L84:
            androidx.datastore.preferences.protobuf.n0 r5 = r9.f3090a     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            r6 = 0
            java.lang.Object r3 = r13.i(r5, r6, r6)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8c
            goto L53
        L8c:
            boolean r5 = r13.x()     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L93
            goto L53
        L93:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L77
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L77
            throw r9     // Catch: java.lang.Throwable -> L77
        L99:
            r10.put(r3, r4)     // Catch: java.lang.Throwable -> L77
            r0.j(r1)
            return
        La0:
            r0.j(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.J.q(java.lang.Object, int, java.lang.Object, androidx.datastore.preferences.protobuf.m, androidx.datastore.preferences.protobuf.j):void");
    }

    public final void r(int i, Object obj, Object obj2) {
        if (!m(i, obj2)) {
            return;
        }
        long K3 = K(i) & 1048575;
        Unsafe unsafe = f3102o;
        Object object = unsafe.getObject(obj2, K3);
        if (object != null) {
            S l3 = l(i);
            if (!m(i, obj)) {
                if (!o(object)) {
                    unsafe.putObject(obj, K3, object);
                } else {
                    AbstractC0253u newInstance = l3.newInstance();
                    l3.a(newInstance, object);
                    unsafe.putObject(obj, K3, newInstance);
                }
                F(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, K3);
            if (!o(object2)) {
                AbstractC0253u newInstance2 = l3.newInstance();
                l3.a(newInstance2, object2);
                unsafe.putObject(obj, K3, newInstance2);
                object2 = newInstance2;
            }
            l3.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.f3103a[i] + " is present but null: " + obj2);
    }

    public final void s(int i, Object obj, Object obj2) {
        int[] iArr = this.f3103a;
        int i3 = iArr[i];
        if (!p(obj2, i3, i)) {
            return;
        }
        long K3 = K(i) & 1048575;
        Unsafe unsafe = f3102o;
        Object object = unsafe.getObject(obj2, K3);
        if (object != null) {
            S l3 = l(i);
            if (!p(obj, i3, i)) {
                if (!o(object)) {
                    unsafe.putObject(obj, K3, object);
                } else {
                    AbstractC0253u newInstance = l3.newInstance();
                    l3.a(newInstance, object);
                    unsafe.putObject(obj, K3, newInstance);
                }
                G(obj, i3, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, K3);
            if (!o(object2)) {
                AbstractC0253u newInstance2 = l3.newInstance();
                l3.a(newInstance2, object2);
                unsafe.putObject(obj, K3, newInstance2);
                object2 = newInstance2;
            }
            l3.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
    }

    public final Object t(int i, Object obj) {
        S l3 = l(i);
        long K3 = K(i) & 1048575;
        if (!m(i, obj)) {
            return l3.newInstance();
        }
        Object object = f3102o.getObject(obj, K3);
        if (o(object)) {
            return object;
        }
        AbstractC0253u newInstance = l3.newInstance();
        if (object != null) {
            l3.a(newInstance, object);
        }
        return newInstance;
    }

    public final Object u(Object obj, int i, int i3) {
        S l3 = l(i3);
        if (!p(obj, i, i3)) {
            return l3.newInstance();
        }
        Object object = f3102o.getObject(obj, K(i3) & 1048575);
        if (o(object)) {
            return object;
        }
        AbstractC0253u newInstance = l3.newInstance();
        if (object != null) {
            l3.a(newInstance, object);
        }
        return newInstance;
    }

    public final int z(int i) {
        if (i >= this.f3105c && i <= this.f3106d) {
            int[] iArr = this.f3103a;
            int length = (iArr.length / 3) - 1;
            int i3 = 0;
            while (i3 <= length) {
                int i4 = (length + i3) >>> 1;
                int i5 = i4 * 3;
                int i6 = iArr[i5];
                if (i == i6) {
                    return i5;
                }
                if (i < i6) {
                    length = i4 - 1;
                } else {
                    i3 = i4 + 1;
                }
            }
        }
        return -1;
    }
}
