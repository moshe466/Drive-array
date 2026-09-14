package com.google.crypto.tink.shaded.protobuf;

import F0.AbstractC0008a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import org.apache.tika.pipes.PipesConfigBase;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class S implements b0 {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f4056o = new int[0];
    public static final Unsafe p = n0.j();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4057a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f4058b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4059c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4060d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0329a f4061e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4062f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4063g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f4064h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4065j;

    /* renamed from: k, reason: collision with root package name */
    public final U f4066k;

    /* renamed from: l, reason: collision with root package name */
    public final H f4067l;

    /* renamed from: m, reason: collision with root package name */
    public final d0 f4068m;

    /* renamed from: n, reason: collision with root package name */
    public final M f4069n;

    public S(int[] iArr, Object[] objArr, int i, int i3, AbstractC0329a abstractC0329a, boolean z3, int[] iArr2, int i4, int i5, U u3, H h2, d0 d0Var, C0345q c0345q, M m4) {
        this.f4057a = iArr;
        this.f4058b = objArr;
        this.f4059c = i;
        this.f4060d = i3;
        this.f4062f = abstractC0329a instanceof AbstractC0351x;
        this.f4063g = z3;
        this.f4064h = iArr2;
        this.i = i4;
        this.f4065j = i5;
        this.f4066k = u3;
        this.f4067l = h2;
        this.f4068m = d0Var;
        this.f4061e = abstractC0329a;
        this.f4069n = m4;
    }

    public static S A(a0 a0Var, U u3, H h2, d0 d0Var, C0345q c0345q, M m4) {
        if (a0Var instanceof a0) {
            return B(a0Var, u3, h2, d0Var, c0345q, m4);
        }
        a0Var.getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.crypto.tink.shaded.protobuf.S B(com.google.crypto.tink.shaded.protobuf.a0 r34, com.google.crypto.tink.shaded.protobuf.U r35, com.google.crypto.tink.shaded.protobuf.H r36, com.google.crypto.tink.shaded.protobuf.d0 r37, com.google.crypto.tink.shaded.protobuf.C0345q r38, com.google.crypto.tink.shaded.protobuf.M r39) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.S.B(com.google.crypto.tink.shaded.protobuf.a0, com.google.crypto.tink.shaded.protobuf.U, com.google.crypto.tink.shaded.protobuf.H, com.google.crypto.tink.shaded.protobuf.d0, com.google.crypto.tink.shaded.protobuf.q, com.google.crypto.tink.shaded.protobuf.M):com.google.crypto.tink.shaded.protobuf.S");
    }

    public static long C(int i) {
        return i & 1048575;
    }

    public static int D(long j2, Object obj) {
        return ((Integer) n0.f4138c.i(j2, obj)).intValue();
    }

    public static long E(long j2, Object obj) {
        return ((Long) n0.f4138c.i(j2, obj)).longValue();
    }

    public static Field O(Class cls, String str) {
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

    public static int U(int i) {
        return (i & 267386880) >>> 20;
    }

    public static void X(int i, Object obj, K k4) {
        if (obj instanceof String) {
            String str = (String) obj;
            C0341m c0341m = (C0341m) k4.f4050a;
            c0341m.W(i, 2);
            int i3 = c0341m.f4133l;
            byte[] bArr = c0341m.f4132k;
            int i4 = c0341m.f4134m;
            try {
                int N3 = C0341m.N(str.length() * 3);
                int N4 = C0341m.N(str.length());
                if (N4 == N3) {
                    int i5 = i4 + N4;
                    c0341m.f4134m = i5;
                    int m4 = q0.f4147a.m(str, bArr, i5, i3 - i5);
                    c0341m.f4134m = i4;
                    c0341m.X((m4 - i4) - N4);
                    c0341m.f4134m = m4;
                    return;
                }
                c0341m.X(q0.b(str));
                int i6 = c0341m.f4134m;
                c0341m.f4134m = q0.f4147a.m(str, bArr, i6, i3 - i6);
                return;
            } catch (p0 e4) {
                c0341m.f4134m = i4;
                C0341m.f4129n.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e4);
                byte[] bytes = str.getBytes(B.f4029a);
                try {
                    c0341m.X(bytes.length);
                    c0341m.Q(bytes, 0, bytes.length);
                    return;
                } catch (IndexOutOfBoundsException e5) {
                    throw new CodedOutputStream$OutOfSpaceException(e5);
                }
            } catch (IndexOutOfBoundsException e6) {
                throw new CodedOutputStream$OutOfSpaceException(e6);
            }
        }
        k4.a(i, (AbstractC0337i) obj);
    }

    public static void k(Object obj) {
        if (s(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    public static boolean s(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC0351x) {
            return ((AbstractC0351x) obj).n();
        }
        return true;
    }

    public static List u(AbstractC0351x abstractC0351x, long j2) {
        return (List) n0.f4138c.i(j2, abstractC0351x);
    }

    public final void F(Object obj, int i, long j2) {
        Unsafe unsafe = p;
        Object n4 = n(i);
        Object object = unsafe.getObject(obj, j2);
        this.f4069n.getClass();
        if (!((L) object).f4052a) {
            L c4 = L.f4051b.c();
            M.b(c4, object);
            unsafe.putObject(obj, j2, c4);
        }
        AbstractC0008a.z(n4);
        throw null;
    }

    public final int G(Object obj, byte[] bArr, int i, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, C0332d c0332d) {
        int i10;
        Unsafe unsafe = p;
        long j3 = this.f4057a[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j2, Double.valueOf(Double.longBitsToDouble(T.b.k(bArr, i))));
                int i11 = i + 8;
                unsafe.putInt(obj, j3, i5);
                return i11;
            case 52:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j2, Float.valueOf(Float.intBitsToFloat(T.b.j(bArr, i))));
                int i12 = i + 4;
                unsafe.putInt(obj, j3, i5);
                return i12;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i;
                }
                int s3 = T.b.s(bArr, i, c0332d);
                unsafe.putObject(obj, j2, Long.valueOf(c0332d.f4093b));
                unsafe.putInt(obj, j3, i5);
                return s3;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i;
                }
                int q3 = T.b.q(bArr, i, c0332d);
                unsafe.putObject(obj, j2, Integer.valueOf(c0332d.f4092a));
                unsafe.putInt(obj, j3, i5);
                return q3;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j2, Long.valueOf(T.b.k(bArr, i)));
                int i13 = i + 8;
                unsafe.putInt(obj, j3, i5);
                return i13;
            case 57:
            case 64:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(T.b.j(bArr, i)));
                int i14 = i + 4;
                unsafe.putInt(obj, j3, i5);
                return i14;
            case 58:
                if (i6 != 0) {
                    return i;
                }
                int s4 = T.b.s(bArr, i, c0332d);
                unsafe.putObject(obj, j2, Boolean.valueOf(c0332d.f4093b != 0));
                unsafe.putInt(obj, j3, i5);
                return s4;
            case 59:
                if (i6 != 2) {
                    return i;
                }
                int q4 = T.b.q(bArr, i, c0332d);
                int i15 = c0332d.f4092a;
                if (i15 == 0) {
                    unsafe.putObject(obj, j2, "");
                } else {
                    if ((i7 & 536870912) != 0) {
                        if (!q0.f4147a.r(bArr, q4, q4 + i15)) {
                            throw InvalidProtocolBufferException.b();
                        }
                    }
                    unsafe.putObject(obj, j2, new String(bArr, q4, i15, B.f4029a));
                    q4 += i15;
                }
                unsafe.putInt(obj, j3, i5);
                return q4;
            case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                i10 = i;
                if (i6 == 2) {
                    Object z3 = z(obj, i5, i9);
                    int C3 = T.b.C(z3, o(i9), bArr, i10, i3, c0332d);
                    T(obj, i5, i9, z3);
                    return C3;
                }
                break;
            case 61:
                i10 = i;
                if (i6 == 2) {
                    int i16 = T.b.i(bArr, i10, c0332d);
                    unsafe.putObject(obj, j2, c0332d.f4094c);
                    unsafe.putInt(obj, j3, i5);
                    return i16;
                }
                break;
            case 63:
                i10 = i;
                if (i6 == 0) {
                    int q5 = T.b.q(bArr, i10, c0332d);
                    int i17 = c0332d.f4092a;
                    m(i9);
                    unsafe.putObject(obj, j2, Integer.valueOf(i17));
                    unsafe.putInt(obj, j3, i5);
                    return q5;
                }
                break;
            case 66:
                i10 = i;
                if (i6 == 0) {
                    int q6 = T.b.q(bArr, i10, c0332d);
                    unsafe.putObject(obj, j2, Integer.valueOf(M1.d.d(c0332d.f4092a)));
                    unsafe.putInt(obj, j3, i5);
                    return q6;
                }
                break;
            case 67:
                i10 = i;
                if (i6 == 0) {
                    int s5 = T.b.s(bArr, i10, c0332d);
                    unsafe.putObject(obj, j2, Long.valueOf(M1.d.e(c0332d.f4093b)));
                    unsafe.putInt(obj, j3, i5);
                    return s5;
                }
                break;
            case 68:
                if (i6 == 3) {
                    Object z4 = z(obj, i5, i9);
                    int H3 = ((S) o(i9)).H(z4, bArr, i, i3, (i4 & (-8)) | 4, c0332d);
                    c0332d.f4094c = z4;
                    T(obj, i5, i9, z4);
                    return H3;
                }
            default:
                return i;
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0142, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r7;
        r7 = r13;
        r13 = r4;
        r4 = r33;
        r5 = r2;
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x025a, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r4;
        r4 = r13;
        r13 = r7;
        r7 = r4;
        r4 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x046b, code lost:
    
        if (r8 == 1048575) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x046d, code lost:
    
        r15.putInt(r10, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0471, code lost:
    
        r0 = r6.i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0475, code lost:
    
        if (r0 >= r6.f4065j) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0477, code lost:
    
        r6.l(r6.f4064h[r0], r10, r32);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0483, code lost:
    
        if (r34 != 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0485, code lost:
    
        if (r5 != r4) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x048c, code lost:
    
        throw com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0491, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x048d, code lost:
    
        if (r5 > r4) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x048f, code lost:
    
        if (r12 != r34) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0496, code lost:
    
        throw com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:98:0x00a1. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int H(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.crypto.tink.shaded.protobuf.C0332d r35) {
        /*
            Method dump skipped, instructions count: 1216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.S.H(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.d):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:83:0x009b. Please report as an issue. */
    public final void I(Object obj, byte[] bArr, int i, int i3, C0332d c0332d) {
        int i4;
        int i5;
        Object obj2;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        char c4;
        Unsafe unsafe2;
        Object obj3;
        byte[] bArr2;
        int i11;
        byte[] bArr3;
        Object obj4;
        byte[] bArr4;
        Unsafe unsafe3;
        int i12;
        int n4;
        Object obj5;
        Object obj6;
        int i13;
        int i14;
        int i15;
        S s3 = this;
        Object obj7 = obj;
        byte[] bArr5 = bArr;
        int i16 = i3;
        C0332d c0332d2 = c0332d;
        k(obj7);
        Unsafe unsafe4 = p;
        int i17 = i;
        int i18 = -1;
        int i19 = 0;
        int i20 = 1048575;
        int i21 = 0;
        while (i17 < i16) {
            int i22 = i17 + 1;
            int i23 = bArr5[i17];
            if (i23 < 0) {
                i22 = T.b.p(i23, bArr5, i22, c0332d2);
                i23 = c0332d2.f4092a;
            }
            int i24 = i23 >>> 3;
            int i25 = i23 & 7;
            int i26 = s3.f4060d;
            int i27 = s3.f4059c;
            if (i24 > i18) {
                i5 = (i24 < i27 || i24 > i26) ? -1 : s3.R(i24, i19 / 3);
                i4 = 0;
            } else if (i24 < i27 || i24 > i26) {
                i4 = 0;
                i5 = -1;
            } else {
                i4 = 0;
                i5 = s3.R(i24, 0);
            }
            int i28 = i5;
            if (i28 == -1) {
                int i29 = i22;
                obj2 = obj7;
                i6 = i29;
                unsafe = unsafe4;
                i7 = i23;
                i8 = i24;
                i9 = i4;
            } else {
                int[] iArr = s3.f4057a;
                int i30 = iArr[i28 + 1];
                int U3 = U(i30);
                int i31 = i23;
                long j2 = i30 & 1048575;
                if (U3 <= 17) {
                    int i32 = iArr[i28 + 2];
                    int i33 = 1 << (i32 >>> 20);
                    int i34 = i32 & 1048575;
                    if (i34 != i20) {
                        int i35 = 1048575;
                        i10 = i30;
                        if (i20 != 1048575) {
                            unsafe4.putInt(obj7, i20, i21);
                            i35 = 1048575;
                        }
                        if (i34 != i35) {
                            i21 = unsafe4.getInt(obj7, i34);
                        }
                        i20 = i34;
                    } else {
                        i10 = i30;
                    }
                    switch (U3) {
                        case 0:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            c4 = 65535;
                            i11 = i22;
                            if (i25 != 1) {
                                obj3 = obj7;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                n0.f4138c.m(obj7, j2, Double.longBitsToDouble(T.b.k(bArr2, i11)));
                                i17 = i11 + 8;
                                i21 |= i33;
                                bArr5 = bArr2;
                                i19 = i28;
                                i18 = i24;
                                unsafe4 = unsafe2;
                                i16 = i3;
                                break;
                            }
                        case 1:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            c4 = 65535;
                            i11 = i22;
                            if (i25 != 5) {
                                obj3 = obj7;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                n0.f4138c.n(obj7, j2, Float.intBitsToFloat(T.b.j(bArr2, i11)));
                                i17 = i11 + 4;
                                i21 |= i33;
                                bArr5 = bArr2;
                                i19 = i28;
                                i18 = i24;
                                unsafe4 = unsafe2;
                                i16 = i3;
                                break;
                            }
                        case 2:
                        case 3:
                            bArr3 = bArr5;
                            c4 = 65535;
                            i11 = i22;
                            if (i25 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                int s4 = T.b.s(bArr3, i11, c0332d2);
                                unsafe4.putLong(obj7, j2, c0332d2.f4093b);
                                i21 |= i33;
                                i17 = s4;
                                bArr5 = bArr3;
                                i19 = i28;
                                i18 = i24;
                                i16 = i3;
                                break;
                            }
                        case 4:
                        case 11:
                            bArr3 = bArr5;
                            c4 = 65535;
                            i11 = i22;
                            if (i25 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                int q3 = T.b.q(bArr3, i11, c0332d2);
                                unsafe4.putInt(obj7, j2, c0332d2.f4092a);
                                i21 |= i33;
                                i17 = q3;
                                bArr5 = bArr3;
                                i19 = i28;
                                i18 = i24;
                                i16 = i3;
                                break;
                            }
                        case 5:
                        case 14:
                            Object obj8 = obj7;
                            bArr3 = bArr5;
                            c4 = 65535;
                            Unsafe unsafe5 = unsafe4;
                            int i36 = i22;
                            if (i25 != 1) {
                                i11 = i36;
                                unsafe2 = unsafe5;
                                obj3 = obj8;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                long k4 = T.b.k(bArr3, i36);
                                unsafe4 = unsafe5;
                                obj7 = obj8;
                                unsafe4.putLong(obj7, j2, k4);
                                i17 = i36 + 8;
                                i21 |= i33;
                                bArr5 = bArr3;
                                i19 = i28;
                                i18 = i24;
                                i16 = i3;
                                break;
                            }
                        case 6:
                        case 13:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c4 = 65535;
                            unsafe3 = unsafe4;
                            i12 = i22;
                            if (i25 != 5) {
                                Unsafe unsafe6 = unsafe3;
                                i11 = i12;
                                obj3 = obj4;
                                unsafe2 = unsafe6;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                unsafe3.putInt(obj4, j2, T.b.j(bArr4, i12));
                                i17 = i12 + 4;
                                i21 |= i33;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i19 = i28;
                                i18 = i24;
                                obj7 = obj4;
                                i16 = i3;
                                break;
                            }
                        case 7:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c4 = 65535;
                            unsafe3 = unsafe4;
                            i12 = i22;
                            if (i25 != 0) {
                                Unsafe unsafe62 = unsafe3;
                                i11 = i12;
                                obj3 = obj4;
                                unsafe2 = unsafe62;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                i17 = T.b.s(bArr4, i12, c0332d2);
                                n0.f4138c.k(obj4, j2, c0332d2.f4093b != 0);
                                i21 |= i33;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i19 = i28;
                                i18 = i24;
                                obj7 = obj4;
                                i16 = i3;
                                break;
                            }
                        case 8:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c4 = 65535;
                            unsafe3 = unsafe4;
                            i12 = i22;
                            if (i25 != 2) {
                                Unsafe unsafe622 = unsafe3;
                                i11 = i12;
                                obj3 = obj4;
                                unsafe2 = unsafe622;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                if ((i10 & 536870912) == 0) {
                                    n4 = T.b.m(bArr4, i12, c0332d2);
                                } else {
                                    n4 = T.b.n(bArr4, i12, c0332d2);
                                }
                                i17 = n4;
                                unsafe3.putObject(obj4, j2, c0332d2.f4094c);
                                i21 |= i33;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i19 = i28;
                                i18 = i24;
                                obj7 = obj4;
                                i16 = i3;
                                break;
                            }
                        case 9:
                            obj4 = obj7;
                            c4 = 65535;
                            if (i25 != 2) {
                                Unsafe unsafe7 = unsafe4;
                                obj3 = obj4;
                                unsafe2 = unsafe7;
                                i11 = i22;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                Unsafe unsafe8 = unsafe4;
                                Object y = s3.y(i28, obj4);
                                byte[] bArr6 = bArr5;
                                unsafe3 = unsafe8;
                                int C3 = T.b.C(y, s3.o(i28), bArr6, i22, i16, c0332d2);
                                bArr4 = bArr6;
                                s3.S(i28, obj4, y);
                                i21 |= i33;
                                i17 = C3;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i19 = i28;
                                i18 = i24;
                                obj7 = obj4;
                                i16 = i3;
                                break;
                            }
                        case 10:
                            obj5 = obj7;
                            c4 = 65535;
                            if (i25 != 2) {
                                Object obj9 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj9;
                                i11 = i22;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                i17 = T.b.i(bArr5, i22, c0332d2);
                                unsafe4.putObject(obj5, j2, c0332d2.f4094c);
                                i21 |= i33;
                                i19 = i28;
                                i18 = i24;
                                obj7 = obj5;
                                break;
                            }
                        case Code.UNIMPLEMENTED /* 12 */:
                            obj5 = obj7;
                            c4 = 65535;
                            if (i25 != 0) {
                                Object obj92 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj92;
                                i11 = i22;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                i17 = T.b.q(bArr5, i22, c0332d2);
                                unsafe4.putInt(obj5, j2, c0332d2.f4092a);
                                i21 |= i33;
                                i19 = i28;
                                i18 = i24;
                                obj7 = obj5;
                                break;
                            }
                        case 15:
                            obj5 = obj7;
                            c4 = 65535;
                            if (i25 != 0) {
                                Object obj922 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj922;
                                i11 = i22;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                i17 = T.b.q(bArr5, i22, c0332d2);
                                unsafe4.putInt(obj5, j2, M1.d.d(c0332d2.f4092a));
                                i21 |= i33;
                                i19 = i28;
                                i18 = i24;
                                obj7 = obj5;
                                break;
                            }
                        case 16:
                            if (i25 != 0) {
                                c4 = 65535;
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i11 = i22;
                                i7 = i31;
                                obj2 = obj3;
                                i6 = i11;
                                unsafe = unsafe2;
                                i8 = i24;
                                i9 = i28;
                                break;
                            } else {
                                int s5 = T.b.s(bArr5, i22, c0332d2);
                                unsafe4.putLong(obj7, j2, M1.d.e(c0332d2.f4093b));
                                i21 |= i33;
                                i19 = i28;
                                i18 = i24;
                                i17 = s5;
                                break;
                            }
                        default:
                            unsafe2 = unsafe4;
                            obj3 = obj7;
                            c4 = 65535;
                            i11 = i22;
                            i7 = i31;
                            obj2 = obj3;
                            i6 = i11;
                            unsafe = unsafe2;
                            i8 = i24;
                            i9 = i28;
                            break;
                    }
                } else {
                    Object obj10 = obj7;
                    Unsafe unsafe9 = unsafe4;
                    byte[] bArr7 = bArr5;
                    int i37 = i22;
                    if (U3 != 27) {
                        i7 = i31;
                        i13 = i37;
                        if (U3 <= 49) {
                            unsafe = unsafe9;
                            i8 = i24;
                            int i38 = i20;
                            int i39 = i21;
                            int J3 = s3.J(obj, bArr, i13, i3, i7, i25, i28, i30, U3, j2, c0332d);
                            i9 = i28;
                            if (J3 != i13) {
                                bArr5 = bArr;
                                i16 = i3;
                                c0332d2 = c0332d;
                                obj7 = obj;
                                i17 = J3;
                                i19 = i9;
                                i20 = i38;
                                i21 = i39;
                                i18 = i8;
                                unsafe4 = unsafe;
                            } else {
                                i6 = J3;
                                i20 = i38;
                                i21 = i39;
                                obj2 = obj;
                            }
                        } else {
                            unsafe = unsafe9;
                            i14 = i20;
                            i8 = i24;
                            obj6 = obj;
                            i9 = i28;
                            i15 = i21;
                            if (U3 != 50) {
                                int G3 = s3.G(obj6, bArr, i13, i3, i7, i8, i25, i30, U3, j2, i9, c0332d);
                                obj2 = obj6;
                                if (G3 != i13) {
                                    s3 = this;
                                    i16 = i3;
                                    c0332d2 = c0332d;
                                    obj7 = obj2;
                                    i17 = G3;
                                    i19 = i9;
                                    i20 = i14;
                                    i21 = i15;
                                    i18 = i8;
                                    unsafe4 = unsafe;
                                    bArr5 = bArr;
                                } else {
                                    i6 = G3;
                                    i20 = i14;
                                    i21 = i15;
                                }
                            } else if (i25 == 2) {
                                s3.F(obj6, i9, j2);
                                throw null;
                            }
                        }
                    } else if (i25 == 2) {
                        A a2 = (A) unsafe9.getObject(obj10, j2);
                        if (!((AbstractC0330b) a2).f4085a) {
                            int size = a2.size();
                            a2 = a2.a(size == 0 ? 10 : size * 2);
                            unsafe9.putObject(obj10, j2, a2);
                        }
                        int l3 = T.b.l(s3.o(i28), i31, bArr7, i37, i3, a2, c0332d2);
                        obj7 = obj;
                        bArr5 = bArr;
                        c0332d2 = c0332d;
                        i17 = l3;
                        unsafe4 = unsafe9;
                        i19 = i28;
                        i18 = i24;
                        i16 = i3;
                    } else {
                        obj6 = obj;
                        i7 = i31;
                        unsafe = unsafe9;
                        i13 = i37;
                        i14 = i20;
                        i15 = i21;
                        i8 = i24;
                        i9 = i28;
                    }
                    i6 = i13;
                    obj2 = obj6;
                    i20 = i14;
                    i21 = i15;
                }
            }
            AbstractC0351x abstractC0351x = (AbstractC0351x) obj2;
            e0 e0Var = abstractC0351x.unknownFields;
            if (e0Var == e0.f4095f) {
                e0Var = e0.c();
                abstractC0351x.unknownFields = e0Var;
            }
            int o2 = T.b.o(i7, bArr, i6, i3, e0Var, c0332d);
            bArr5 = bArr;
            c0332d2 = c0332d;
            i16 = i3;
            obj7 = obj2;
            i19 = i9;
            i18 = i8;
            unsafe4 = unsafe;
            i17 = o2;
            s3 = this;
        }
        Unsafe unsafe10 = unsafe4;
        Object obj11 = obj7;
        int i40 = i16;
        int i41 = i20;
        int i42 = i21;
        if (i41 != 1048575) {
            unsafe10.putInt(obj11, i41, i42);
        }
        if (i17 != i40) {
            throw InvalidProtocolBufferException.g();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002e. Please report as an issue. */
    public final int J(Object obj, byte[] bArr, int i, int i3, int i4, int i5, int i6, long j2, int i7, long j3, C0332d c0332d) {
        int i8;
        int i9;
        int i10;
        int i11;
        int r3;
        Unsafe unsafe = p;
        A a2 = (A) unsafe.getObject(obj, j3);
        if (!((AbstractC0330b) a2).f4085a) {
            int size = a2.size();
            a2 = a2.a(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j3, a2);
        }
        A a4 = a2;
        switch (i7) {
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
            case Build.API_LEVELS.API_35 /* 35 */:
                int i12 = i;
                if (i5 == 2) {
                    AbstractC0342n abstractC0342n = (AbstractC0342n) a4;
                    int q3 = T.b.q(bArr, i12, c0332d);
                    int i13 = c0332d.f4092a + q3;
                    while (q3 < i13) {
                        abstractC0342n.g(Double.longBitsToDouble(T.b.k(bArr, q3)));
                        q3 += 8;
                    }
                    if (q3 == i13) {
                        return q3;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 != 1) {
                    return i12;
                }
                AbstractC0342n abstractC0342n2 = (AbstractC0342n) a4;
                abstractC0342n2.g(Double.longBitsToDouble(T.b.k(bArr, i)));
                while (true) {
                    i8 = i12 + 8;
                    if (i8 < i3) {
                        i12 = T.b.q(bArr, i8, c0332d);
                        if (i4 == c0332d.f4092a) {
                            abstractC0342n2.g(Double.longBitsToDouble(T.b.k(bArr, i12)));
                        }
                    }
                }
                return i8;
            case 19:
            case Build.API_LEVELS.API_36 /* 36 */:
                int i14 = i;
                if (i5 == 2) {
                    AbstractC0347t abstractC0347t = (AbstractC0347t) a4;
                    int q4 = T.b.q(bArr, i14, c0332d);
                    int i15 = c0332d.f4092a + q4;
                    while (q4 < i15) {
                        abstractC0347t.g(Float.intBitsToFloat(T.b.j(bArr, q4)));
                        q4 += 4;
                    }
                    if (q4 == i15) {
                        return q4;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 != 5) {
                    return i14;
                }
                AbstractC0347t abstractC0347t2 = (AbstractC0347t) a4;
                abstractC0347t2.g(Float.intBitsToFloat(T.b.j(bArr, i)));
                while (true) {
                    i9 = i14 + 4;
                    if (i9 < i3) {
                        i14 = T.b.q(bArr, i9, c0332d);
                        if (i4 == c0332d.f4092a) {
                            abstractC0347t2.g(Float.intBitsToFloat(T.b.j(bArr, i14)));
                        }
                    }
                }
                return i9;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    I i16 = (I) a4;
                    int q5 = T.b.q(bArr, i, c0332d);
                    int i17 = c0332d.f4092a + q5;
                    while (q5 < i17) {
                        q5 = T.b.s(bArr, q5, c0332d);
                        i16.g(c0332d.f4093b);
                    }
                    if (q5 == i17) {
                        return q5;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 != 0) {
                    return i;
                }
                I i18 = (I) a4;
                int s3 = T.b.s(bArr, i, c0332d);
                i18.g(c0332d.f4093b);
                while (s3 < i3) {
                    int q6 = T.b.q(bArr, s3, c0332d);
                    if (i4 != c0332d.f4092a) {
                        return s3;
                    }
                    s3 = T.b.s(bArr, q6, c0332d);
                    i18.g(c0332d.f4093b);
                }
                return s3;
            case 22:
            case Build.API_LEVELS.API_29 /* 29 */:
            case 39:
            case 43:
                i10 = i;
                if (i5 != 2) {
                    if (i5 == 0) {
                        return T.b.r(i4, bArr, i10, i3, a4, c0332d);
                    }
                    return i10;
                }
                AbstractC0352y abstractC0352y = (AbstractC0352y) a4;
                int q7 = T.b.q(bArr, i10, c0332d);
                int i19 = c0332d.f4092a + q7;
                while (q7 < i19) {
                    q7 = T.b.q(bArr, q7, c0332d);
                    abstractC0352y.g(c0332d.f4092a);
                }
                if (q7 == i19) {
                    return q7;
                }
                throw InvalidProtocolBufferException.h();
            case 23:
            case 32:
            case 40:
            case 46:
                i10 = i;
                if (i5 == 2) {
                    I i20 = (I) a4;
                    int q8 = T.b.q(bArr, i10, c0332d);
                    int i21 = c0332d.f4092a + q8;
                    while (q8 < i21) {
                        i20.g(T.b.k(bArr, q8));
                        q8 += 8;
                    }
                    if (q8 == i21) {
                        return q8;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 == 1) {
                    I i22 = (I) a4;
                    i22.g(T.b.k(bArr, i));
                    int i23 = i10 + 8;
                    while (i23 < i3) {
                        int q9 = T.b.q(bArr, i23, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return i23;
                        }
                        i22.g(T.b.k(bArr, q9));
                        i23 = q9 + 8;
                    }
                    return i23;
                }
                return i10;
            case 24:
            case Build.API_LEVELS.API_31 /* 31 */:
            case 41:
            case 45:
                i10 = i;
                if (i5 == 2) {
                    AbstractC0352y abstractC0352y2 = (AbstractC0352y) a4;
                    int q10 = T.b.q(bArr, i10, c0332d);
                    int i24 = c0332d.f4092a + q10;
                    while (q10 < i24) {
                        abstractC0352y2.g(T.b.j(bArr, q10));
                        q10 += 4;
                    }
                    if (q10 == i24) {
                        return q10;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 == 5) {
                    AbstractC0352y abstractC0352y3 = (AbstractC0352y) a4;
                    abstractC0352y3.g(T.b.j(bArr, i));
                    int i25 = i10 + 4;
                    while (i25 < i3) {
                        int q11 = T.b.q(bArr, i25, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return i25;
                        }
                        abstractC0352y3.g(T.b.j(bArr, q11));
                        i25 = q11 + 4;
                    }
                    return i25;
                }
                return i10;
            case Build.API_LEVELS.API_25 /* 25 */:
            case 42:
                i10 = i;
                if (i5 == 2) {
                    AbstractC0333e abstractC0333e = (AbstractC0333e) a4;
                    int q12 = T.b.q(bArr, i10, c0332d);
                    int i26 = c0332d.f4092a + q12;
                    while (q12 < i26) {
                        q12 = T.b.s(bArr, q12, c0332d);
                        abstractC0333e.g(c0332d.f4093b != 0);
                    }
                    if (q12 == i26) {
                        return q12;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 == 0) {
                    AbstractC0333e abstractC0333e2 = (AbstractC0333e) a4;
                    int s4 = T.b.s(bArr, i10, c0332d);
                    abstractC0333e2.g(c0332d.f4093b != 0);
                    while (s4 < i3) {
                        int q13 = T.b.q(bArr, s4, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return s4;
                        }
                        s4 = T.b.s(bArr, q13, c0332d);
                        abstractC0333e2.g(c0332d.f4093b != 0);
                    }
                    return s4;
                }
                return i10;
            case Build.API_LEVELS.API_26 /* 26 */:
                i10 = i;
                if (i5 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int q14 = T.b.q(bArr, i10, c0332d);
                        int i27 = c0332d.f4092a;
                        if (i27 < 0) {
                            throw InvalidProtocolBufferException.f();
                        }
                        if (i27 == 0) {
                            a4.add("");
                        } else {
                            a4.add(new String(bArr, q14, i27, B.f4029a));
                            q14 += i27;
                        }
                        while (q14 < i3) {
                            int q15 = T.b.q(bArr, q14, c0332d);
                            if (i4 != c0332d.f4092a) {
                                return q14;
                            }
                            q14 = T.b.q(bArr, q15, c0332d);
                            int i28 = c0332d.f4092a;
                            if (i28 < 0) {
                                throw InvalidProtocolBufferException.f();
                            }
                            if (i28 == 0) {
                                a4.add("");
                            } else {
                                a4.add(new String(bArr, q14, i28, B.f4029a));
                                q14 += i28;
                            }
                        }
                        return q14;
                    }
                    int q16 = T.b.q(bArr, i10, c0332d);
                    int i29 = c0332d.f4092a;
                    if (i29 < 0) {
                        throw InvalidProtocolBufferException.f();
                    }
                    if (i29 == 0) {
                        a4.add("");
                    } else {
                        int i30 = q16 + i29;
                        if (q0.f4147a.r(bArr, q16, i30)) {
                            a4.add(new String(bArr, q16, i29, B.f4029a));
                            q16 = i30;
                        } else {
                            throw InvalidProtocolBufferException.b();
                        }
                    }
                    while (q16 < i3) {
                        int q17 = T.b.q(bArr, q16, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return q16;
                        }
                        q16 = T.b.q(bArr, q17, c0332d);
                        int i31 = c0332d.f4092a;
                        if (i31 < 0) {
                            throw InvalidProtocolBufferException.f();
                        }
                        if (i31 == 0) {
                            a4.add("");
                        } else {
                            int i32 = q16 + i31;
                            if (q0.f4147a.r(bArr, q16, i32)) {
                                a4.add(new String(bArr, q16, i31, B.f4029a));
                                q16 = i32;
                            } else {
                                throw InvalidProtocolBufferException.b();
                            }
                        }
                    }
                    return q16;
                }
                return i10;
            case Build.API_LEVELS.API_27 /* 27 */:
                return i5 == 2 ? T.b.l(o(i6), i4, bArr, i, i3, a4, c0332d) : i;
            case Build.API_LEVELS.API_28 /* 28 */:
                if (i5 != 2) {
                    return i;
                }
                int q18 = T.b.q(bArr, i, c0332d);
                int i33 = c0332d.f4092a;
                if (i33 >= 0) {
                    if (i33 > bArr.length - q18) {
                        throw InvalidProtocolBufferException.h();
                    }
                    if (i33 == 0) {
                        a4.add(AbstractC0337i.f4107b);
                    } else {
                        a4.add(AbstractC0337i.i(bArr, q18, i33));
                        q18 += i33;
                    }
                    while (q18 < i3) {
                        int q19 = T.b.q(bArr, q18, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return q18;
                        }
                        q18 = T.b.q(bArr, q19, c0332d);
                        int i34 = c0332d.f4092a;
                        if (i34 >= 0) {
                            if (i34 > bArr.length - q18) {
                                throw InvalidProtocolBufferException.h();
                            }
                            if (i34 == 0) {
                                a4.add(AbstractC0337i.f4107b);
                            } else {
                                a4.add(AbstractC0337i.i(bArr, q18, i34));
                                q18 += i34;
                            }
                        } else {
                            throw InvalidProtocolBufferException.f();
                        }
                    }
                    return q18;
                }
                throw InvalidProtocolBufferException.f();
            case Build.API_LEVELS.API_30 /* 30 */:
            case 44:
                i11 = i;
                if (i5 != 2) {
                    if (i5 == 0) {
                        r3 = T.b.r(i4, bArr, i11, i3, a4, c0332d);
                    }
                    return i11;
                }
                AbstractC0352y abstractC0352y4 = (AbstractC0352y) a4;
                r3 = T.b.q(bArr, i11, c0332d);
                int i35 = c0332d.f4092a + r3;
                while (r3 < i35) {
                    r3 = T.b.q(bArr, r3, c0332d);
                    abstractC0352y4.g(c0332d.f4092a);
                }
                if (r3 != i35) {
                    throw InvalidProtocolBufferException.h();
                }
                m(i6);
                Class cls = c0.f4088a;
                return r3;
            case Build.API_LEVELS.API_33 /* 33 */:
            case 47:
                i11 = i;
                if (i5 == 2) {
                    AbstractC0352y abstractC0352y5 = (AbstractC0352y) a4;
                    int q20 = T.b.q(bArr, i11, c0332d);
                    int i36 = c0332d.f4092a + q20;
                    while (q20 < i36) {
                        q20 = T.b.q(bArr, q20, c0332d);
                        abstractC0352y5.g(M1.d.d(c0332d.f4092a));
                    }
                    if (q20 == i36) {
                        return q20;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 == 0) {
                    AbstractC0352y abstractC0352y6 = (AbstractC0352y) a4;
                    int q21 = T.b.q(bArr, i11, c0332d);
                    abstractC0352y6.g(M1.d.d(c0332d.f4092a));
                    while (q21 < i3) {
                        int q22 = T.b.q(bArr, q21, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return q21;
                        }
                        q21 = T.b.q(bArr, q22, c0332d);
                        abstractC0352y6.g(M1.d.d(c0332d.f4092a));
                    }
                    return q21;
                }
                return i11;
            case Build.API_LEVELS.API_34 /* 34 */:
            case 48:
                i11 = i;
                if (i5 == 2) {
                    I i37 = (I) a4;
                    int q23 = T.b.q(bArr, i11, c0332d);
                    int i38 = c0332d.f4092a + q23;
                    while (q23 < i38) {
                        q23 = T.b.s(bArr, q23, c0332d);
                        i37.g(M1.d.e(c0332d.f4093b));
                    }
                    if (q23 == i38) {
                        return q23;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                if (i5 == 0) {
                    I i39 = (I) a4;
                    int s5 = T.b.s(bArr, i11, c0332d);
                    i39.g(M1.d.e(c0332d.f4093b));
                    while (s5 < i3) {
                        int q24 = T.b.q(bArr, s5, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return s5;
                        }
                        s5 = T.b.s(bArr, q24, c0332d);
                        i39.g(M1.d.e(c0332d.f4093b));
                    }
                    return s5;
                }
                return i11;
            case 49:
                if (i5 == 3) {
                    b0 o2 = o(i6);
                    int i40 = (i4 & (-8)) | 4;
                    Object newInstance = o2.newInstance();
                    S s6 = (S) o2;
                    int H3 = s6.H(newInstance, bArr, i, i3, i40, c0332d);
                    c0332d.f4094c = newInstance;
                    o2.b(newInstance);
                    c0332d.f4094c = newInstance;
                    a4.add(newInstance);
                    while (H3 < i3) {
                        int q25 = T.b.q(bArr, H3, c0332d);
                        if (i4 != c0332d.f4092a) {
                            return H3;
                        }
                        Object newInstance2 = o2.newInstance();
                        H3 = s6.H(newInstance2, bArr, q25, i3, i40, c0332d);
                        c0332d.f4094c = newInstance2;
                        o2.b(newInstance2);
                        c0332d.f4094c = newInstance2;
                        a4.add(newInstance2);
                    }
                    return H3;
                }
            default:
                return i;
        }
    }

    public final void K(Object obj, long j2, C0340l c0340l, b0 b0Var, C0344p c0344p) {
        int C3;
        List c4 = this.f4067l.c(j2, obj);
        M1.d dVar = c0340l.f4125a;
        int i = c0340l.f4126b;
        if ((i & 7) != 3) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            Object newInstance = b0Var.newInstance();
            c0340l.b(newInstance, b0Var, c0344p);
            b0Var.b(newInstance);
            c4.add(newInstance);
            if (!dVar.g() && c0340l.f4128d == 0) {
                C3 = dVar.C();
            } else {
                return;
            }
        } while (C3 == i);
        c0340l.f4128d = C3;
    }

    public final void L(Object obj, int i, C0340l c0340l, b0 b0Var, C0344p c0344p) {
        int C3;
        List c4 = this.f4067l.c(i & 1048575, obj);
        M1.d dVar = c0340l.f4125a;
        int i3 = c0340l.f4126b;
        if ((i3 & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            Object newInstance = b0Var.newInstance();
            c0340l.c(newInstance, b0Var, c0344p);
            b0Var.b(newInstance);
            c4.add(newInstance);
            if (!dVar.g() && c0340l.f4128d == 0) {
                C3 = dVar.C();
            } else {
                return;
            }
        } while (C3 == i3);
        c0340l.f4128d = C3;
    }

    public final void M(Object obj, int i, C0340l c0340l) {
        if ((536870912 & i) != 0) {
            c0340l.v(2);
            n0.p(obj, i & 1048575, c0340l.f4125a.B());
        } else if (this.f4062f) {
            c0340l.v(2);
            n0.p(obj, i & 1048575, c0340l.f4125a.A());
        } else {
            n0.p(obj, i & 1048575, c0340l.e());
        }
    }

    public final void N(Object obj, int i, C0340l c0340l) {
        int i3 = 536870912 & i;
        H h2 = this.f4067l;
        if (i3 != 0) {
            c0340l.r(h2.c(i & 1048575, obj), true);
        } else {
            c0340l.r(h2.c(i & 1048575, obj), false);
        }
    }

    public final void P(int i, Object obj) {
        int i3 = this.f4057a[i + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        n0.n(obj, (1 << (i3 >>> 20)) | n0.f4138c.g(j2, obj), j2);
    }

    public final void Q(Object obj, int i, int i3) {
        n0.n(obj, i, this.f4057a[i3 + 2] & 1048575);
    }

    public final int R(int i, int i3) {
        int[] iArr = this.f4057a;
        int length = (iArr.length / 3) - 1;
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
        return -1;
    }

    public final void S(int i, Object obj, Object obj2) {
        p.putObject(obj, V(i) & 1048575, obj2);
        P(i, obj);
    }

    public final void T(Object obj, int i, int i3, Object obj2) {
        p.putObject(obj, V(i3) & 1048575, obj2);
        Q(obj, i, i3);
    }

    public final int V(int i) {
        return this.f4057a[i + 1];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0042. Please report as an issue. */
    public final void W(Object obj, K k4) {
        int i;
        int i3;
        int i4;
        int[] iArr = this.f4057a;
        int length = iArr.length;
        Unsafe unsafe = p;
        int i5 = 1048575;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 = i4 + 3) {
            int V2 = V(i7);
            int i8 = iArr[i7];
            int U3 = U(V2);
            if (U3 <= 17) {
                int i9 = iArr[i7 + 2];
                i = 1048575;
                int i10 = i9 & 1048575;
                if (i10 != i5) {
                    i6 = unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i3 = 1 << (i9 >>> 20);
            } else {
                i = 1048575;
                i3 = 0;
            }
            int i11 = i7;
            long j2 = V2 & i;
            switch (U3) {
                case 0:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        double e4 = n0.f4138c.e(j2, obj);
                        C0341m c0341m = (C0341m) k4.f4050a;
                        c0341m.getClass();
                        c0341m.T(i8, Double.doubleToRawLongBits(e4));
                    }
                case 1:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        float f4 = n0.f4138c.f(j2, obj);
                        C0341m c0341m2 = (C0341m) k4.f4050a;
                        c0341m2.getClass();
                        c0341m2.R(i8, Float.floatToRawIntBits(f4));
                    }
                case 2:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        ((C0341m) k4.f4050a).Y(i8, unsafe.getLong(obj, j2));
                    }
                case 3:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        ((C0341m) k4.f4050a).Y(i8, unsafe.getLong(obj, j2));
                    }
                case 4:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        int i12 = unsafe.getInt(obj, j2);
                        C0341m c0341m3 = (C0341m) k4.f4050a;
                        c0341m3.W(i8, 0);
                        c0341m3.V(i12);
                    }
                case 5:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        ((C0341m) k4.f4050a).T(i8, unsafe.getLong(obj, j2));
                    }
                case 6:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        ((C0341m) k4.f4050a).R(i8, unsafe.getInt(obj, j2));
                    }
                case 7:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        boolean c4 = n0.f4138c.c(j2, obj);
                        C0341m c0341m4 = (C0341m) k4.f4050a;
                        c0341m4.W(i8, 0);
                        c0341m4.P(c4 ? (byte) 1 : (byte) 0);
                    }
                case 8:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        X(i8, unsafe.getObject(obj, j2), k4);
                    }
                case 9:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        k4.c(i8, unsafe.getObject(obj, j2), o(i4));
                    }
                case 10:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        k4.a(i8, (AbstractC0337i) unsafe.getObject(obj, j2));
                    }
                case 11:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        int i13 = unsafe.getInt(obj, j2);
                        C0341m c0341m5 = (C0341m) k4.f4050a;
                        c0341m5.W(i8, 0);
                        c0341m5.X(i13);
                    }
                case Code.UNIMPLEMENTED /* 12 */:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        int i14 = unsafe.getInt(obj, j2);
                        C0341m c0341m6 = (C0341m) k4.f4050a;
                        c0341m6.W(i8, 0);
                        c0341m6.V(i14);
                    }
                case 13:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        ((C0341m) k4.f4050a).R(i8, unsafe.getInt(obj, j2));
                    }
                case 14:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        ((C0341m) k4.f4050a).T(i8, unsafe.getLong(obj, j2));
                    }
                case 15:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        int i15 = unsafe.getInt(obj, j2);
                        C0341m c0341m7 = (C0341m) k4.f4050a;
                        c0341m7.W(i8, 0);
                        c0341m7.X((i15 >> 31) ^ (i15 << 1));
                    }
                case 16:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        long j3 = unsafe.getLong(obj, j2);
                        ((C0341m) k4.f4050a).Y(i8, (j3 << 1) ^ (j3 >> 63));
                    }
                case 17:
                    i4 = i11;
                    if ((i3 & i6) != 0) {
                        k4.b(i8, unsafe.getObject(obj, j2), o(i4));
                    }
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    i4 = i11;
                    c0.A(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case 19:
                    i4 = i11;
                    c0.E(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case 20:
                    i4 = i11;
                    c0.H(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case 21:
                    i4 = i11;
                    c0.P(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case 22:
                    i4 = i11;
                    c0.G(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case 23:
                    i4 = i11;
                    c0.D(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case 24:
                    i4 = i11;
                    c0.C(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case Build.API_LEVELS.API_25 /* 25 */:
                    i4 = i11;
                    c0.y(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case Build.API_LEVELS.API_26 /* 26 */:
                    i4 = i11;
                    c0.N(iArr[i4], (List) unsafe.getObject(obj, j2), k4);
                case Build.API_LEVELS.API_27 /* 27 */:
                    i4 = i11;
                    c0.I(iArr[i4], (List) unsafe.getObject(obj, j2), k4, o(i4));
                case Build.API_LEVELS.API_28 /* 28 */:
                    i4 = i11;
                    c0.z(iArr[i4], (List) unsafe.getObject(obj, j2), k4);
                case Build.API_LEVELS.API_29 /* 29 */:
                    i4 = i11;
                    c0.O(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case Build.API_LEVELS.API_30 /* 30 */:
                    i4 = i11;
                    c0.B(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case Build.API_LEVELS.API_31 /* 31 */:
                    i4 = i11;
                    c0.J(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case 32:
                    i4 = i11;
                    c0.K(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case Build.API_LEVELS.API_33 /* 33 */:
                    i4 = i11;
                    c0.L(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case Build.API_LEVELS.API_34 /* 34 */:
                    i4 = i11;
                    c0.M(iArr[i4], (List) unsafe.getObject(obj, j2), k4, false);
                case Build.API_LEVELS.API_35 /* 35 */:
                    i4 = i11;
                    c0.A(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case Build.API_LEVELS.API_36 /* 36 */:
                    i4 = i11;
                    c0.E(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 37:
                    i4 = i11;
                    c0.H(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 38:
                    i4 = i11;
                    c0.P(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 39:
                    i4 = i11;
                    c0.G(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 40:
                    i4 = i11;
                    c0.D(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 41:
                    i4 = i11;
                    c0.C(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 42:
                    i4 = i11;
                    c0.y(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 43:
                    i4 = i11;
                    c0.O(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 44:
                    i4 = i11;
                    c0.B(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 45:
                    i4 = i11;
                    c0.J(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 46:
                    i4 = i11;
                    c0.K(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 47:
                    i4 = i11;
                    c0.L(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 48:
                    i4 = i11;
                    c0.M(iArr[i4], (List) unsafe.getObject(obj, j2), k4, true);
                case 49:
                    i4 = i11;
                    c0.F(iArr[i4], (List) unsafe.getObject(obj, j2), k4, o(i4));
                case 50:
                    i4 = i11;
                    if (unsafe.getObject(obj, j2) != null) {
                        Object n4 = n(i4);
                        this.f4069n.getClass();
                        AbstractC0008a.z(n4);
                        throw null;
                    }
                case 51:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        double doubleValue = ((Double) n0.f4138c.i(j2, obj)).doubleValue();
                        C0341m c0341m8 = (C0341m) k4.f4050a;
                        c0341m8.getClass();
                        c0341m8.T(i8, Double.doubleToRawLongBits(doubleValue));
                    }
                case 52:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        float floatValue = ((Float) n0.f4138c.i(j2, obj)).floatValue();
                        C0341m c0341m9 = (C0341m) k4.f4050a;
                        c0341m9.getClass();
                        c0341m9.R(i8, Float.floatToRawIntBits(floatValue));
                    }
                case 53:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        ((C0341m) k4.f4050a).Y(i8, E(j2, obj));
                    }
                case 54:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        ((C0341m) k4.f4050a).Y(i8, E(j2, obj));
                    }
                case 55:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        int D3 = D(j2, obj);
                        C0341m c0341m10 = (C0341m) k4.f4050a;
                        c0341m10.W(i8, 0);
                        c0341m10.V(D3);
                    }
                case 56:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        ((C0341m) k4.f4050a).T(i8, E(j2, obj));
                    }
                case 57:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        ((C0341m) k4.f4050a).R(i8, D(j2, obj));
                    }
                case 58:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        boolean booleanValue = ((Boolean) n0.f4138c.i(j2, obj)).booleanValue();
                        C0341m c0341m11 = (C0341m) k4.f4050a;
                        c0341m11.W(i8, 0);
                        c0341m11.P(booleanValue ? (byte) 1 : (byte) 0);
                    }
                case 59:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        X(i8, unsafe.getObject(obj, j2), k4);
                    }
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        k4.c(i8, unsafe.getObject(obj, j2), o(i4));
                    }
                case 61:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        k4.a(i8, (AbstractC0337i) unsafe.getObject(obj, j2));
                    }
                case 62:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        int D4 = D(j2, obj);
                        C0341m c0341m12 = (C0341m) k4.f4050a;
                        c0341m12.W(i8, 0);
                        c0341m12.X(D4);
                    }
                case 63:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        int D5 = D(j2, obj);
                        C0341m c0341m13 = (C0341m) k4.f4050a;
                        c0341m13.W(i8, 0);
                        c0341m13.V(D5);
                    }
                case 64:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        ((C0341m) k4.f4050a).R(i8, D(j2, obj));
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        ((C0341m) k4.f4050a).T(i8, E(j2, obj));
                    }
                case 66:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        int D6 = D(j2, obj);
                        C0341m c0341m14 = (C0341m) k4.f4050a;
                        c0341m14.W(i8, 0);
                        c0341m14.X((D6 >> 31) ^ (D6 << 1));
                    }
                case 67:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        long E3 = E(j2, obj);
                        ((C0341m) k4.f4050a).Y(i8, (E3 << 1) ^ (E3 >> 63));
                    }
                case 68:
                    i4 = i11;
                    if (t(obj, i8, i4)) {
                        k4.b(i8, unsafe.getObject(obj, j2), o(i4));
                    }
                default:
                    i4 = i11;
            }
        }
        ((f0) this.f4068m).getClass();
        ((AbstractC0351x) obj).unknownFields.e(k4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void a(Object obj, Object obj2) {
        Object obj3;
        k(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.f4057a;
            if (i < iArr.length) {
                int V2 = V(i);
                long j2 = 1048575 & V2;
                int i3 = iArr[i];
                switch (U(V2)) {
                    case 0:
                        if (r(i, obj2)) {
                            m0 m0Var = n0.f4138c;
                            obj3 = obj;
                            m0Var.m(obj3, j2, m0Var.e(j2, obj2));
                            P(i, obj3);
                            break;
                        }
                        break;
                    case 1:
                        if (r(i, obj2)) {
                            m0 m0Var2 = n0.f4138c;
                            m0Var2.n(obj, j2, m0Var2.f(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 2:
                        if (r(i, obj2)) {
                            n0.o(obj, j2, n0.f4138c.h(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 3:
                        if (r(i, obj2)) {
                            n0.o(obj, j2, n0.f4138c.h(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 4:
                        if (r(i, obj2)) {
                            n0.n(obj, n0.f4138c.g(j2, obj2), j2);
                            P(i, obj);
                            break;
                        }
                        break;
                    case 5:
                        if (r(i, obj2)) {
                            n0.o(obj, j2, n0.f4138c.h(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 6:
                        if (r(i, obj2)) {
                            n0.n(obj, n0.f4138c.g(j2, obj2), j2);
                            P(i, obj);
                            break;
                        }
                        break;
                    case 7:
                        if (r(i, obj2)) {
                            m0 m0Var3 = n0.f4138c;
                            m0Var3.k(obj, j2, m0Var3.c(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 8:
                        if (r(i, obj2)) {
                            n0.p(obj, j2, n0.f4138c.i(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 9:
                        w(i, obj, obj2);
                        break;
                    case 10:
                        if (r(i, obj2)) {
                            n0.p(obj, j2, n0.f4138c.i(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 11:
                        if (r(i, obj2)) {
                            n0.n(obj, n0.f4138c.g(j2, obj2), j2);
                            P(i, obj);
                            break;
                        }
                        break;
                    case Code.UNIMPLEMENTED /* 12 */:
                        if (r(i, obj2)) {
                            n0.n(obj, n0.f4138c.g(j2, obj2), j2);
                            P(i, obj);
                            break;
                        }
                        break;
                    case 13:
                        if (r(i, obj2)) {
                            n0.n(obj, n0.f4138c.g(j2, obj2), j2);
                            P(i, obj);
                            break;
                        }
                        break;
                    case 14:
                        if (r(i, obj2)) {
                            n0.o(obj, j2, n0.f4138c.h(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 15:
                        if (r(i, obj2)) {
                            n0.n(obj, n0.f4138c.g(j2, obj2), j2);
                            P(i, obj);
                            break;
                        }
                        break;
                    case 16:
                        if (r(i, obj2)) {
                            n0.o(obj, j2, n0.f4138c.h(j2, obj2));
                            P(i, obj);
                            break;
                        }
                        break;
                    case 17:
                        w(i, obj, obj2);
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
                        this.f4067l.b(obj, j2, obj2);
                        break;
                    case 50:
                        Class cls = c0.f4088a;
                        m0 m0Var4 = n0.f4138c;
                        Object i4 = m0Var4.i(j2, obj);
                        Object i5 = m0Var4.i(j2, obj2);
                        this.f4069n.getClass();
                        n0.p(obj, j2, M.b(i4, i5));
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
                        if (t(obj2, i3, i)) {
                            n0.p(obj, j2, n0.f4138c.i(j2, obj2));
                            Q(obj, i3, i);
                            break;
                        }
                        break;
                    case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                        x(i, obj, obj2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    case 66:
                    case 67:
                        if (t(obj2, i3, i)) {
                            n0.p(obj, j2, n0.f4138c.i(j2, obj2));
                            Q(obj, i3, i);
                            break;
                        }
                        break;
                    case 68:
                        x(i, obj, obj2);
                        break;
                }
                obj3 = obj;
                i += 3;
                obj = obj3;
            } else {
                c0.w(this.f4068m, obj, obj2);
                return;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void b(Object obj) {
        if (!s(obj)) {
            return;
        }
        if (obj instanceof AbstractC0351x) {
            AbstractC0351x abstractC0351x = (AbstractC0351x) obj;
            abstractC0351x.u(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            abstractC0351x.memoizedHashCode = 0;
            abstractC0351x.o();
        }
        int length = this.f4057a.length;
        for (int i = 0; i < length; i += 3) {
            int V2 = V(i);
            long j2 = 1048575 & V2;
            int U3 = U(V2);
            if (U3 != 9) {
                switch (U3) {
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
                        this.f4067l.a(j2, obj);
                        break;
                    case 50:
                        Unsafe unsafe = p;
                        Object object = unsafe.getObject(obj, j2);
                        if (object != null) {
                            this.f4069n.getClass();
                            ((L) object).f4052a = false;
                            unsafe.putObject(obj, j2, object);
                            break;
                        } else {
                            break;
                        }
                }
            }
            if (r(i, obj)) {
                o(i).b(p.getObject(obj, j2));
            }
        }
        ((f0) this.f4068m).getClass();
        ((AbstractC0351x) obj).unknownFields.f4100e = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ee, code lost:
    
        return false;
     */
    @Override // com.google.crypto.tink.shaded.protobuf.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.S.c(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.c0.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0108, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.c0.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.c0.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0138, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.c0.x(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014c, code lost:
    
        if (r5.c(r7, r12) == r5.c(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019f, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b4, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cf, code lost:
    
        if (java.lang.Float.floatToIntBits(r5.f(r7, r12)) == java.lang.Float.floatToIntBits(r5.f(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ec, code lost:
    
        if (java.lang.Double.doubleToLongBits(r5.e(r7, r12)) == java.lang.Double.doubleToLongBits(r5.e(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (com.google.crypto.tink.shaded.protobuf.c0.x(r9.i(r7, r12), r9.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
    @Override // com.google.crypto.tink.shaded.protobuf.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(com.google.crypto.tink.shaded.protobuf.AbstractC0351x r12, com.google.crypto.tink.shaded.protobuf.AbstractC0351x r13) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.S.d(com.google.crypto.tink.shaded.protobuf.x, com.google.crypto.tink.shaded.protobuf.x):boolean");
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
    @Override // com.google.crypto.tink.shaded.protobuf.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(com.google.crypto.tink.shaded.protobuf.AbstractC0351x r12) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.S.e(com.google.crypto.tink.shaded.protobuf.x):int");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final int f(AbstractC0351x abstractC0351x) {
        if (this.f4063g) {
            return q(abstractC0351x);
        }
        return p(abstractC0351x);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void g(Object obj, byte[] bArr, int i, int i3, C0332d c0332d) {
        if (this.f4063g) {
            I(obj, bArr, i, i3, c0332d);
        } else {
            H(obj, bArr, i, i3, 0, c0332d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x006c, code lost:
    
        if (r13 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009e, code lost:
    
        if (r13 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0044, code lost:
    
        ((com.google.crypto.tink.shaded.protobuf.AbstractC0351x) r2).unknownFields = r13;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x007f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:41:0x05d2 A[Catch: all -> 0x0430, TryCatch #1 {all -> 0x0430, blocks: (B:39:0x05cd, B:41:0x05d2, B:42:0x05d7, B:134:0x0424, B:137:0x0433, B:138:0x044c, B:139:0x0466, B:140:0x0480, B:141:0x049c, B:142:0x04b5, B:143:0x04c9, B:144:0x04e3, B:145:0x04ef, B:146:0x050a, B:147:0x0524, B:148:0x053e, B:149:0x0557, B:150:0x0570, B:151:0x0589, B:152:0x05a4, B:157:0x05bf), top: B:38:0x05cd }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x05dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05fa A[LOOP:3: B:57:0x05f8->B:58:0x05fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0604  */
    @Override // com.google.crypto.tink.shaded.protobuf.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(java.lang.Object r20, com.google.crypto.tink.shaded.protobuf.C0340l r21, com.google.crypto.tink.shaded.protobuf.C0344p r22) {
        /*
            Method dump skipped, instructions count: 1694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.S.h(java.lang.Object, com.google.crypto.tink.shaded.protobuf.l, com.google.crypto.tink.shaded.protobuf.p):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void i(Object obj, K k4) {
        k4.getClass();
        C0341m c0341m = (C0341m) k4.f4050a;
        if (this.f4063g) {
            int[] iArr = this.f4057a;
            int length = iArr.length;
            for (int i = 0; i < length; i += 3) {
                int V2 = V(i);
                int i3 = iArr[i];
                switch (U(V2)) {
                    case 0:
                        if (r(i, obj)) {
                            double e4 = n0.f4138c.e(V2 & 1048575, obj);
                            c0341m.getClass();
                            c0341m.T(i3, Double.doubleToRawLongBits(e4));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (r(i, obj)) {
                            float f4 = n0.f4138c.f(V2 & 1048575, obj);
                            c0341m.getClass();
                            c0341m.R(i3, Float.floatToRawIntBits(f4));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (r(i, obj)) {
                            c0341m.Y(i3, n0.f4138c.h(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (r(i, obj)) {
                            c0341m.Y(i3, n0.f4138c.h(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (r(i, obj)) {
                            int g3 = n0.f4138c.g(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.V(g3);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (r(i, obj)) {
                            c0341m.T(i3, n0.f4138c.h(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (r(i, obj)) {
                            c0341m.R(i3, n0.f4138c.g(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (r(i, obj)) {
                            boolean c4 = n0.f4138c.c(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.P(c4 ? (byte) 1 : (byte) 0);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (r(i, obj)) {
                            X(i3, n0.f4138c.i(V2 & 1048575, obj), k4);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (r(i, obj)) {
                            k4.c(i3, n0.f4138c.i(V2 & 1048575, obj), o(i));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (r(i, obj)) {
                            k4.a(i3, (AbstractC0337i) n0.f4138c.i(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (r(i, obj)) {
                            int g4 = n0.f4138c.g(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.X(g4);
                            break;
                        } else {
                            break;
                        }
                    case Code.UNIMPLEMENTED /* 12 */:
                        if (r(i, obj)) {
                            int g5 = n0.f4138c.g(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.V(g5);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (r(i, obj)) {
                            c0341m.R(i3, n0.f4138c.g(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (r(i, obj)) {
                            c0341m.T(i3, n0.f4138c.h(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (r(i, obj)) {
                            int g6 = n0.f4138c.g(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.X((g6 >> 31) ^ (g6 << 1));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (r(i, obj)) {
                            long h2 = n0.f4138c.h(V2 & 1048575, obj);
                            c0341m.Y(i3, (h2 >> 63) ^ (h2 << 1));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (r(i, obj)) {
                            k4.b(i3, n0.f4138c.i(V2 & 1048575, obj), o(i));
                            break;
                        } else {
                            break;
                        }
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        c0.A(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case 19:
                        c0.E(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case 20:
                        c0.H(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case 21:
                        c0.P(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case 22:
                        c0.G(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case 23:
                        c0.D(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case 24:
                        c0.C(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        c0.y(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        c0.N(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4);
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        c0.I(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, o(i));
                        break;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        c0.z(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4);
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        c0.O(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        c0.B(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        c0.J(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case 32:
                        c0.K(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        c0.L(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        c0.M(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, false);
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        c0.A(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case Build.API_LEVELS.API_36 /* 36 */:
                        c0.E(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 37:
                        c0.H(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 38:
                        c0.P(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 39:
                        c0.G(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 40:
                        c0.D(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 41:
                        c0.C(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 42:
                        c0.y(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 43:
                        c0.O(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 44:
                        c0.B(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 45:
                        c0.J(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 46:
                        c0.K(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 47:
                        c0.L(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 48:
                        c0.M(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, true);
                        break;
                    case 49:
                        c0.F(iArr[i], (List) n0.f4138c.i(V2 & 1048575, obj), k4, o(i));
                        break;
                    case 50:
                        if (n0.f4138c.i(V2 & 1048575, obj) != null) {
                            Object n4 = n(i);
                            this.f4069n.getClass();
                            AbstractC0008a.z(n4);
                            throw null;
                        }
                        break;
                    case 51:
                        if (t(obj, i3, i)) {
                            double doubleValue = ((Double) n0.f4138c.i(V2 & 1048575, obj)).doubleValue();
                            c0341m.getClass();
                            c0341m.T(i3, Double.doubleToRawLongBits(doubleValue));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (t(obj, i3, i)) {
                            float floatValue = ((Float) n0.f4138c.i(V2 & 1048575, obj)).floatValue();
                            c0341m.getClass();
                            c0341m.R(i3, Float.floatToRawIntBits(floatValue));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (t(obj, i3, i)) {
                            c0341m.Y(i3, E(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (t(obj, i3, i)) {
                            c0341m.Y(i3, E(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (t(obj, i3, i)) {
                            int D3 = D(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.V(D3);
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (t(obj, i3, i)) {
                            c0341m.T(i3, E(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (t(obj, i3, i)) {
                            c0341m.R(i3, D(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (t(obj, i3, i)) {
                            boolean booleanValue = ((Boolean) n0.f4138c.i(V2 & 1048575, obj)).booleanValue();
                            c0341m.W(i3, 0);
                            c0341m.P(booleanValue ? (byte) 1 : (byte) 0);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (t(obj, i3, i)) {
                            X(i3, n0.f4138c.i(V2 & 1048575, obj), k4);
                            break;
                        } else {
                            break;
                        }
                    case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                        if (t(obj, i3, i)) {
                            k4.c(i3, n0.f4138c.i(V2 & 1048575, obj), o(i));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (t(obj, i3, i)) {
                            k4.a(i3, (AbstractC0337i) n0.f4138c.i(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (t(obj, i3, i)) {
                            int D4 = D(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.X(D4);
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (t(obj, i3, i)) {
                            int D5 = D(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.V(D5);
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (t(obj, i3, i)) {
                            c0341m.R(i3, D(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (t(obj, i3, i)) {
                            c0341m.T(i3, E(V2 & 1048575, obj));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (t(obj, i3, i)) {
                            int D6 = D(V2 & 1048575, obj);
                            c0341m.W(i3, 0);
                            c0341m.X((D6 >> 31) ^ (D6 << 1));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (t(obj, i3, i)) {
                            long E3 = E(V2 & 1048575, obj);
                            c0341m.Y(i3, (E3 >> 63) ^ (E3 << 1));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (t(obj, i3, i)) {
                            k4.b(i3, n0.f4138c.i(V2 & 1048575, obj), o(i));
                            break;
                        } else {
                            break;
                        }
                }
            }
            ((f0) this.f4068m).getClass();
            ((AbstractC0351x) obj).unknownFields.e(k4);
            return;
        }
        W(obj, k4);
    }

    public final boolean j(AbstractC0351x abstractC0351x, AbstractC0351x abstractC0351x2, int i) {
        if (r(i, abstractC0351x) == r(i, abstractC0351x2)) {
            return true;
        }
        return false;
    }

    public final void l(int i, Object obj, Object obj2) {
        int i3 = this.f4057a[i];
        if (n0.f4138c.i(V(i) & 1048575, obj) == null) {
            return;
        }
        m(i);
    }

    public final void m(int i) {
        if (this.f4058b[((i / 3) * 2) + 1] == null) {
        } else {
            throw new ClassCastException();
        }
    }

    public final Object n(int i) {
        return this.f4058b[(i / 3) * 2];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final Object newInstance() {
        this.f4066k.getClass();
        return ((AbstractC0351x) this.f4061e).q();
    }

    public final b0 o(int i) {
        int i3 = (i / 3) * 2;
        Object[] objArr = this.f4058b;
        b0 b0Var = (b0) objArr[i3];
        if (b0Var != null) {
            return b0Var;
        }
        b0 a2 = Y.f4075c.a((Class) objArr[i3 + 1]);
        objArr[i3] = a2;
        return a2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x003c. Please report as an issue. */
    public final int p(AbstractC0351x abstractC0351x) {
        int i;
        int M3;
        int O3;
        int M4;
        int K3;
        int I3;
        int M5;
        int L3;
        int F3;
        int M6;
        int i3;
        Unsafe unsafe = p;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr = this.f4057a;
            if (i6 < iArr.length) {
                int V2 = V(i6);
                int i9 = iArr[i6];
                int U3 = U(V2);
                if (U3 <= 17) {
                    int i10 = iArr[i6 + 2];
                    int i11 = i10 & i4;
                    i = 1 << (i10 >>> 20);
                    if (i11 != i5) {
                        i8 = unsafe.getInt(abstractC0351x, i11);
                        i5 = i11;
                    }
                } else {
                    i = 0;
                }
                long j2 = V2 & i4;
                switch (U3) {
                    case 0:
                        if ((i8 & i) != 0) {
                            i7 = AbstractC0008a.C(i9, 8, i7);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if ((i8 & i) != 0) {
                            i7 = AbstractC0008a.C(i9, 4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if ((i & i8) != 0) {
                            long j3 = unsafe.getLong(abstractC0351x, j2);
                            M3 = C0341m.M(i9);
                            O3 = C0341m.O(j3);
                            I3 = O3 + M3;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if ((i & i8) != 0) {
                            long j4 = unsafe.getLong(abstractC0351x, j2);
                            M3 = C0341m.M(i9);
                            O3 = C0341m.O(j4);
                            I3 = O3 + M3;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if ((i & i8) != 0) {
                            int i12 = unsafe.getInt(abstractC0351x, j2);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.K(i12);
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if ((i8 & i) != 0) {
                            I3 = C0341m.I(i9);
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if ((i8 & i) != 0) {
                            I3 = C0341m.H(i9);
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if ((i8 & i) != 0) {
                            i7 = AbstractC0008a.C(i9, 1, i7);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if ((i & i8) == 0) {
                            break;
                        } else {
                            Object object = unsafe.getObject(abstractC0351x, j2);
                            if (object instanceof AbstractC0337i) {
                                F3 = C0341m.F(i9, (AbstractC0337i) object);
                                i7 = F3 + i7;
                                break;
                            } else {
                                M5 = C0341m.M(i9);
                                L3 = C0341m.L((String) object);
                                F3 = L3 + M5;
                                i7 = F3 + i7;
                            }
                        }
                    case 9:
                        if ((i & i8) != 0) {
                            Object object2 = unsafe.getObject(abstractC0351x, j2);
                            b0 o2 = o(i6);
                            Class cls = c0.f4088a;
                            int M7 = C0341m.M(i9);
                            int b4 = ((AbstractC0329a) object2).b(o2);
                            i7 = AbstractC0008a.D(b4, b4, M7, i7);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if ((i & i8) != 0) {
                            I3 = C0341m.F(i9, (AbstractC0337i) unsafe.getObject(abstractC0351x, j2));
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if ((i & i8) != 0) {
                            int i13 = unsafe.getInt(abstractC0351x, j2);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.N(i13);
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case Code.UNIMPLEMENTED /* 12 */:
                        if ((i & i8) != 0) {
                            int i14 = unsafe.getInt(abstractC0351x, j2);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.K(i14);
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if ((i8 & i) != 0) {
                            i7 = AbstractC0008a.C(i9, 4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if ((i8 & i) != 0) {
                            i7 = AbstractC0008a.C(i9, 8, i7);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if ((i & i8) != 0) {
                            int i15 = unsafe.getInt(abstractC0351x, j2);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.N((i15 >> 31) ^ (i15 << 1));
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if ((i & i8) != 0) {
                            long j5 = unsafe.getLong(abstractC0351x, j2);
                            M3 = C0341m.M(i9);
                            O3 = C0341m.O((j5 >> 63) ^ (j5 << 1));
                            I3 = O3 + M3;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if ((i & i8) != 0) {
                            I3 = C0341m.J(i9, (AbstractC0329a) unsafe.getObject(abstractC0351x, j2), o(i6));
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        I3 = c0.f(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case 19:
                        I3 = c0.d(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case 20:
                        I3 = c0.j(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case 21:
                        I3 = c0.t(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case 22:
                        I3 = c0.h(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case 23:
                        I3 = c0.f(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case 24:
                        I3 = c0.d(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        List list = (List) unsafe.getObject(abstractC0351x, j2);
                        Class cls2 = c0.f4088a;
                        int size = list.size();
                        if (size == 0) {
                            M6 = 0;
                        } else {
                            M6 = (C0341m.M(i9) + 1) * size;
                        }
                        i7 += M6;
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        I3 = c0.q(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        I3 = c0.l(i9, (List) unsafe.getObject(abstractC0351x, j2), o(i6));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        I3 = c0.a(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        I3 = c0.r(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        I3 = c0.b(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        I3 = c0.d(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case 32:
                        I3 = c0.f(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        I3 = c0.m(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        I3 = c0.o(i9, (List) unsafe.getObject(abstractC0351x, j2));
                        i7 += I3;
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        int g3 = c0.g((List) unsafe.getObject(abstractC0351x, j2));
                        if (g3 > 0) {
                            i7 = AbstractC0008a.D(g3, C0341m.M(i9), g3, i7);
                            break;
                        } else {
                            break;
                        }
                    case Build.API_LEVELS.API_36 /* 36 */:
                        int e4 = c0.e((List) unsafe.getObject(abstractC0351x, j2));
                        if (e4 > 0) {
                            i7 = AbstractC0008a.D(e4, C0341m.M(i9), e4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int k4 = c0.k((List) unsafe.getObject(abstractC0351x, j2));
                        if (k4 > 0) {
                            i7 = AbstractC0008a.D(k4, C0341m.M(i9), k4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int u3 = c0.u((List) unsafe.getObject(abstractC0351x, j2));
                        if (u3 > 0) {
                            i7 = AbstractC0008a.D(u3, C0341m.M(i9), u3, i7);
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int i16 = c0.i((List) unsafe.getObject(abstractC0351x, j2));
                        if (i16 > 0) {
                            i7 = AbstractC0008a.D(i16, C0341m.M(i9), i16, i7);
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int g4 = c0.g((List) unsafe.getObject(abstractC0351x, j2));
                        if (g4 > 0) {
                            i7 = AbstractC0008a.D(g4, C0341m.M(i9), g4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int e5 = c0.e((List) unsafe.getObject(abstractC0351x, j2));
                        if (e5 > 0) {
                            i7 = AbstractC0008a.D(e5, C0341m.M(i9), e5, i7);
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list2 = (List) unsafe.getObject(abstractC0351x, j2);
                        Class cls3 = c0.f4088a;
                        int size2 = list2.size();
                        if (size2 > 0) {
                            i7 = AbstractC0008a.D(size2, C0341m.M(i9), size2, i7);
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int s3 = c0.s((List) unsafe.getObject(abstractC0351x, j2));
                        if (s3 > 0) {
                            i7 = AbstractC0008a.D(s3, C0341m.M(i9), s3, i7);
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int c4 = c0.c((List) unsafe.getObject(abstractC0351x, j2));
                        if (c4 > 0) {
                            i7 = AbstractC0008a.D(c4, C0341m.M(i9), c4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int e6 = c0.e((List) unsafe.getObject(abstractC0351x, j2));
                        if (e6 > 0) {
                            i7 = AbstractC0008a.D(e6, C0341m.M(i9), e6, i7);
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int g5 = c0.g((List) unsafe.getObject(abstractC0351x, j2));
                        if (g5 > 0) {
                            i7 = AbstractC0008a.D(g5, C0341m.M(i9), g5, i7);
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int n4 = c0.n((List) unsafe.getObject(abstractC0351x, j2));
                        if (n4 > 0) {
                            i7 = AbstractC0008a.D(n4, C0341m.M(i9), n4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int p2 = c0.p((List) unsafe.getObject(abstractC0351x, j2));
                        if (p2 > 0) {
                            i7 = AbstractC0008a.D(p2, C0341m.M(i9), p2, i7);
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list3 = (List) unsafe.getObject(abstractC0351x, j2);
                        b0 o4 = o(i6);
                        Class cls4 = c0.f4088a;
                        int size3 = list3.size();
                        if (size3 == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            for (int i17 = 0; i17 < size3; i17++) {
                                i3 += C0341m.J(i9, (AbstractC0329a) list3.get(i17), o4);
                            }
                        }
                        i7 += i3;
                        break;
                    case 50:
                        Object object3 = unsafe.getObject(abstractC0351x, j2);
                        Object n5 = n(i6);
                        this.f4069n.getClass();
                        M.a(object3, n5);
                        break;
                    case 51:
                        if (t(abstractC0351x, i9, i6)) {
                            i7 = AbstractC0008a.C(i9, 8, i7);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (t(abstractC0351x, i9, i6)) {
                            i7 = AbstractC0008a.C(i9, 4, i7);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (t(abstractC0351x, i9, i6)) {
                            long E3 = E(j2, abstractC0351x);
                            M3 = C0341m.M(i9);
                            O3 = C0341m.O(E3);
                            I3 = O3 + M3;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (t(abstractC0351x, i9, i6)) {
                            long E4 = E(j2, abstractC0351x);
                            M3 = C0341m.M(i9);
                            O3 = C0341m.O(E4);
                            I3 = O3 + M3;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (t(abstractC0351x, i9, i6)) {
                            int D3 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.K(D3);
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (t(abstractC0351x, i9, i6)) {
                            I3 = C0341m.I(i9);
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (t(abstractC0351x, i9, i6)) {
                            I3 = C0341m.H(i9);
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (t(abstractC0351x, i9, i6)) {
                            i7 = AbstractC0008a.C(i9, 1, i7);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!t(abstractC0351x, i9, i6)) {
                            break;
                        } else {
                            Object object4 = unsafe.getObject(abstractC0351x, j2);
                            if (object4 instanceof AbstractC0337i) {
                                F3 = C0341m.F(i9, (AbstractC0337i) object4);
                                i7 = F3 + i7;
                                break;
                            } else {
                                M5 = C0341m.M(i9);
                                L3 = C0341m.L((String) object4);
                                F3 = L3 + M5;
                                i7 = F3 + i7;
                            }
                        }
                    case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                        if (t(abstractC0351x, i9, i6)) {
                            Object object5 = unsafe.getObject(abstractC0351x, j2);
                            b0 o5 = o(i6);
                            Class cls5 = c0.f4088a;
                            int M8 = C0341m.M(i9);
                            int b5 = ((AbstractC0329a) object5).b(o5);
                            i7 = AbstractC0008a.D(b5, b5, M8, i7);
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (t(abstractC0351x, i9, i6)) {
                            I3 = C0341m.F(i9, (AbstractC0337i) unsafe.getObject(abstractC0351x, j2));
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (t(abstractC0351x, i9, i6)) {
                            int D4 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.N(D4);
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (t(abstractC0351x, i9, i6)) {
                            int D5 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.K(D5);
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (t(abstractC0351x, i9, i6)) {
                            i7 = AbstractC0008a.C(i9, 4, i7);
                            break;
                        } else {
                            break;
                        }
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (t(abstractC0351x, i9, i6)) {
                            i7 = AbstractC0008a.C(i9, 8, i7);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (t(abstractC0351x, i9, i6)) {
                            int D6 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i9);
                            K3 = C0341m.N((D6 >> 31) ^ (D6 << 1));
                            I3 = K3 + M4;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (t(abstractC0351x, i9, i6)) {
                            long E5 = E(j2, abstractC0351x);
                            M3 = C0341m.M(i9);
                            O3 = C0341m.O((E5 >> 63) ^ (E5 << 1));
                            I3 = O3 + M3;
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (t(abstractC0351x, i9, i6)) {
                            I3 = C0341m.J(i9, (AbstractC0329a) unsafe.getObject(abstractC0351x, j2), o(i6));
                            i7 += I3;
                            break;
                        } else {
                            break;
                        }
                }
                i6 += 3;
                i4 = 1048575;
            } else {
                ((f0) this.f4068m).getClass();
                return abstractC0351x.unknownFields.b() + i7;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x002f. Please report as an issue. */
    public final int q(AbstractC0351x abstractC0351x) {
        int M3;
        int O3;
        int M4;
        int K3;
        int I3;
        int M5;
        int L3;
        int F3;
        int M6;
        int O4;
        int M7;
        int i;
        Unsafe unsafe = p;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.f4057a;
            if (i3 < iArr.length) {
                int V2 = V(i3);
                int U3 = U(V2);
                int i5 = iArr[i3];
                long j2 = V2 & 1048575;
                if (U3 >= EnumC0346s.f4150b.f4154a && U3 <= EnumC0346s.f4151c.f4154a) {
                    int i6 = iArr[i3 + 2];
                }
                switch (U3) {
                    case 0:
                        if (r(i3, abstractC0351x)) {
                            i4 = AbstractC0008a.C(i5, 8, i4);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (r(i3, abstractC0351x)) {
                            i4 = AbstractC0008a.C(i5, 4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (r(i3, abstractC0351x)) {
                            long h2 = n0.f4138c.h(j2, abstractC0351x);
                            M3 = C0341m.M(i5);
                            O3 = C0341m.O(h2);
                            I3 = O3 + M3;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (r(i3, abstractC0351x)) {
                            long h3 = n0.f4138c.h(j2, abstractC0351x);
                            M3 = C0341m.M(i5);
                            O3 = C0341m.O(h3);
                            I3 = O3 + M3;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (r(i3, abstractC0351x)) {
                            int g3 = n0.f4138c.g(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.K(g3);
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (r(i3, abstractC0351x)) {
                            I3 = C0341m.I(i5);
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (r(i3, abstractC0351x)) {
                            I3 = C0341m.H(i5);
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (r(i3, abstractC0351x)) {
                            i4 = AbstractC0008a.C(i5, 1, i4);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (!r(i3, abstractC0351x)) {
                            break;
                        } else {
                            Object i7 = n0.f4138c.i(j2, abstractC0351x);
                            if (i7 instanceof AbstractC0337i) {
                                F3 = C0341m.F(i5, (AbstractC0337i) i7);
                                i4 = F3 + i4;
                                break;
                            } else {
                                M5 = C0341m.M(i5);
                                L3 = C0341m.L((String) i7);
                                F3 = L3 + M5;
                                i4 = F3 + i4;
                            }
                        }
                    case 9:
                        if (r(i3, abstractC0351x)) {
                            Object i8 = n0.f4138c.i(j2, abstractC0351x);
                            b0 o2 = o(i3);
                            Class cls = c0.f4088a;
                            int M8 = C0341m.M(i5);
                            int b4 = ((AbstractC0329a) i8).b(o2);
                            i4 = AbstractC0008a.D(b4, b4, M8, i4);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (r(i3, abstractC0351x)) {
                            I3 = C0341m.F(i5, (AbstractC0337i) n0.f4138c.i(j2, abstractC0351x));
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (r(i3, abstractC0351x)) {
                            int g4 = n0.f4138c.g(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.N(g4);
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case Code.UNIMPLEMENTED /* 12 */:
                        if (r(i3, abstractC0351x)) {
                            int g5 = n0.f4138c.g(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.K(g5);
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (r(i3, abstractC0351x)) {
                            i4 = AbstractC0008a.C(i5, 4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (r(i3, abstractC0351x)) {
                            i4 = AbstractC0008a.C(i5, 8, i4);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (r(i3, abstractC0351x)) {
                            int g6 = n0.f4138c.g(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.N((g6 >> 31) ^ (g6 << 1));
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (r(i3, abstractC0351x)) {
                            long h4 = n0.f4138c.h(j2, abstractC0351x);
                            M6 = C0341m.M(i5);
                            O4 = C0341m.O((h4 >> 63) ^ (h4 << 1));
                            I3 = O4 + M6;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (r(i3, abstractC0351x)) {
                            I3 = C0341m.J(i5, (AbstractC0329a) n0.f4138c.i(j2, abstractC0351x), o(i3));
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        I3 = c0.f(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case 19:
                        I3 = c0.d(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case 20:
                        I3 = c0.j(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case 21:
                        I3 = c0.t(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case 22:
                        I3 = c0.h(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case 23:
                        I3 = c0.f(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case 24:
                        I3 = c0.d(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        List u3 = u(abstractC0351x, j2);
                        Class cls2 = c0.f4088a;
                        int size = u3.size();
                        if (size == 0) {
                            M7 = 0;
                        } else {
                            M7 = (C0341m.M(i5) + 1) * size;
                        }
                        i4 += M7;
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        I3 = c0.q(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        I3 = c0.l(i5, u(abstractC0351x, j2), o(i3));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        I3 = c0.a(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        I3 = c0.r(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        I3 = c0.b(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        I3 = c0.d(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case 32:
                        I3 = c0.f(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        I3 = c0.m(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        I3 = c0.o(i5, u(abstractC0351x, j2));
                        i4 += I3;
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        int g7 = c0.g((List) unsafe.getObject(abstractC0351x, j2));
                        if (g7 > 0) {
                            i4 = AbstractC0008a.D(g7, C0341m.M(i5), g7, i4);
                            break;
                        } else {
                            break;
                        }
                    case Build.API_LEVELS.API_36 /* 36 */:
                        int e4 = c0.e((List) unsafe.getObject(abstractC0351x, j2));
                        if (e4 > 0) {
                            i4 = AbstractC0008a.D(e4, C0341m.M(i5), e4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int k4 = c0.k((List) unsafe.getObject(abstractC0351x, j2));
                        if (k4 > 0) {
                            i4 = AbstractC0008a.D(k4, C0341m.M(i5), k4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int u4 = c0.u((List) unsafe.getObject(abstractC0351x, j2));
                        if (u4 > 0) {
                            i4 = AbstractC0008a.D(u4, C0341m.M(i5), u4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int i9 = c0.i((List) unsafe.getObject(abstractC0351x, j2));
                        if (i9 > 0) {
                            i4 = AbstractC0008a.D(i9, C0341m.M(i5), i9, i4);
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int g8 = c0.g((List) unsafe.getObject(abstractC0351x, j2));
                        if (g8 > 0) {
                            i4 = AbstractC0008a.D(g8, C0341m.M(i5), g8, i4);
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int e5 = c0.e((List) unsafe.getObject(abstractC0351x, j2));
                        if (e5 > 0) {
                            i4 = AbstractC0008a.D(e5, C0341m.M(i5), e5, i4);
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list = (List) unsafe.getObject(abstractC0351x, j2);
                        Class cls3 = c0.f4088a;
                        int size2 = list.size();
                        if (size2 > 0) {
                            i4 = AbstractC0008a.D(size2, C0341m.M(i5), size2, i4);
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int s3 = c0.s((List) unsafe.getObject(abstractC0351x, j2));
                        if (s3 > 0) {
                            i4 = AbstractC0008a.D(s3, C0341m.M(i5), s3, i4);
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int c4 = c0.c((List) unsafe.getObject(abstractC0351x, j2));
                        if (c4 > 0) {
                            i4 = AbstractC0008a.D(c4, C0341m.M(i5), c4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int e6 = c0.e((List) unsafe.getObject(abstractC0351x, j2));
                        if (e6 > 0) {
                            i4 = AbstractC0008a.D(e6, C0341m.M(i5), e6, i4);
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int g9 = c0.g((List) unsafe.getObject(abstractC0351x, j2));
                        if (g9 > 0) {
                            i4 = AbstractC0008a.D(g9, C0341m.M(i5), g9, i4);
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int n4 = c0.n((List) unsafe.getObject(abstractC0351x, j2));
                        if (n4 > 0) {
                            i4 = AbstractC0008a.D(n4, C0341m.M(i5), n4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int p2 = c0.p((List) unsafe.getObject(abstractC0351x, j2));
                        if (p2 > 0) {
                            i4 = AbstractC0008a.D(p2, C0341m.M(i5), p2, i4);
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List u5 = u(abstractC0351x, j2);
                        b0 o4 = o(i3);
                        Class cls4 = c0.f4088a;
                        int size3 = u5.size();
                        if (size3 == 0) {
                            i = 0;
                        } else {
                            i = 0;
                            for (int i10 = 0; i10 < size3; i10++) {
                                i += C0341m.J(i5, (AbstractC0329a) u5.get(i10), o4);
                            }
                        }
                        i4 += i;
                        break;
                    case 50:
                        Object i11 = n0.f4138c.i(j2, abstractC0351x);
                        Object n5 = n(i3);
                        this.f4069n.getClass();
                        M.a(i11, n5);
                        break;
                    case 51:
                        if (t(abstractC0351x, i5, i3)) {
                            i4 = AbstractC0008a.C(i5, 8, i4);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (t(abstractC0351x, i5, i3)) {
                            i4 = AbstractC0008a.C(i5, 4, i4);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (t(abstractC0351x, i5, i3)) {
                            long E3 = E(j2, abstractC0351x);
                            M3 = C0341m.M(i5);
                            O3 = C0341m.O(E3);
                            I3 = O3 + M3;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (t(abstractC0351x, i5, i3)) {
                            long E4 = E(j2, abstractC0351x);
                            M3 = C0341m.M(i5);
                            O3 = C0341m.O(E4);
                            I3 = O3 + M3;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (t(abstractC0351x, i5, i3)) {
                            int D3 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.K(D3);
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (t(abstractC0351x, i5, i3)) {
                            I3 = C0341m.I(i5);
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (t(abstractC0351x, i5, i3)) {
                            I3 = C0341m.H(i5);
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (t(abstractC0351x, i5, i3)) {
                            i4 = AbstractC0008a.C(i5, 1, i4);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!t(abstractC0351x, i5, i3)) {
                            break;
                        } else {
                            Object i12 = n0.f4138c.i(j2, abstractC0351x);
                            if (i12 instanceof AbstractC0337i) {
                                F3 = C0341m.F(i5, (AbstractC0337i) i12);
                                i4 = F3 + i4;
                                break;
                            } else {
                                M5 = C0341m.M(i5);
                                L3 = C0341m.L((String) i12);
                                F3 = L3 + M5;
                                i4 = F3 + i4;
                            }
                        }
                    case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                        if (t(abstractC0351x, i5, i3)) {
                            Object i13 = n0.f4138c.i(j2, abstractC0351x);
                            b0 o5 = o(i3);
                            Class cls5 = c0.f4088a;
                            int M9 = C0341m.M(i5);
                            int b5 = ((AbstractC0329a) i13).b(o5);
                            i4 = AbstractC0008a.D(b5, b5, M9, i4);
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (t(abstractC0351x, i5, i3)) {
                            I3 = C0341m.F(i5, (AbstractC0337i) n0.f4138c.i(j2, abstractC0351x));
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (t(abstractC0351x, i5, i3)) {
                            int D4 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.N(D4);
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (t(abstractC0351x, i5, i3)) {
                            int D5 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.K(D5);
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (t(abstractC0351x, i5, i3)) {
                            i4 = AbstractC0008a.C(i5, 4, i4);
                            break;
                        } else {
                            break;
                        }
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (t(abstractC0351x, i5, i3)) {
                            i4 = AbstractC0008a.C(i5, 8, i4);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (t(abstractC0351x, i5, i3)) {
                            int D6 = D(j2, abstractC0351x);
                            M4 = C0341m.M(i5);
                            K3 = C0341m.N((D6 >> 31) ^ (D6 << 1));
                            I3 = K3 + M4;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (t(abstractC0351x, i5, i3)) {
                            long E5 = E(j2, abstractC0351x);
                            M6 = C0341m.M(i5);
                            O4 = C0341m.O((E5 >> 63) ^ (E5 << 1));
                            I3 = O4 + M6;
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (t(abstractC0351x, i5, i3)) {
                            I3 = C0341m.J(i5, (AbstractC0329a) n0.f4138c.i(j2, abstractC0351x), o(i3));
                            i4 += I3;
                            break;
                        } else {
                            break;
                        }
                }
                i3 += 3;
            } else {
                ((f0) this.f4068m).getClass();
                return abstractC0351x.unknownFields.b() + i4;
            }
        }
    }

    public final boolean r(int i, Object obj) {
        int i3 = this.f4057a[i + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int V2 = V(i);
            long j3 = V2 & 1048575;
            switch (U(V2)) {
                case 0:
                    if (Double.doubleToRawLongBits(n0.f4138c.e(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(n0.f4138c.f(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (n0.f4138c.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (n0.f4138c.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (n0.f4138c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (n0.f4138c.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (n0.f4138c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return n0.f4138c.c(j3, obj);
                case 8:
                    Object i4 = n0.f4138c.i(j3, obj);
                    if (i4 instanceof String) {
                        return !((String) i4).isEmpty();
                    }
                    if (i4 instanceof AbstractC0337i) {
                        return !AbstractC0337i.f4107b.equals(i4);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (n0.f4138c.i(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !AbstractC0337i.f4107b.equals(n0.f4138c.i(j3, obj));
                case 11:
                    if (n0.f4138c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    if (n0.f4138c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (n0.f4138c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (n0.f4138c.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (n0.f4138c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (n0.f4138c.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (n0.f4138c.i(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i3 >>> 20)) & n0.f4138c.g(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean t(Object obj, int i, int i3) {
        if (n0.f4138c.g(this.f4057a[i3 + 2] & 1048575, obj) == i) {
            return true;
        }
        return false;
    }

    public final void v(int i, Object obj, Object obj2) {
        long V2 = V(i) & 1048575;
        Object i3 = n0.f4138c.i(V2, obj);
        M m4 = this.f4069n;
        if (i3 != null) {
            m4.getClass();
            if (!((L) i3).f4052a) {
                L c4 = L.f4051b.c();
                M.b(c4, i3);
                n0.p(obj, V2, c4);
                i3 = c4;
            }
        } else {
            m4.getClass();
            i3 = L.f4051b.c();
            n0.p(obj, V2, i3);
        }
        m4.getClass();
        AbstractC0008a.z(obj2);
        throw null;
    }

    public final void w(int i, Object obj, Object obj2) {
        if (!r(i, obj2)) {
            return;
        }
        long V2 = V(i) & 1048575;
        Unsafe unsafe = p;
        Object object = unsafe.getObject(obj2, V2);
        if (object != null) {
            b0 o2 = o(i);
            if (!r(i, obj)) {
                if (!s(object)) {
                    unsafe.putObject(obj, V2, object);
                } else {
                    Object newInstance = o2.newInstance();
                    o2.a(newInstance, object);
                    unsafe.putObject(obj, V2, newInstance);
                }
                P(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, V2);
            if (!s(object2)) {
                Object newInstance2 = o2.newInstance();
                o2.a(newInstance2, object2);
                unsafe.putObject(obj, V2, newInstance2);
                object2 = newInstance2;
            }
            o2.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.f4057a[i] + " is present but null: " + obj2);
    }

    public final void x(int i, Object obj, Object obj2) {
        int[] iArr = this.f4057a;
        int i3 = iArr[i];
        if (!t(obj2, i3, i)) {
            return;
        }
        long V2 = V(i) & 1048575;
        Unsafe unsafe = p;
        Object object = unsafe.getObject(obj2, V2);
        if (object != null) {
            b0 o2 = o(i);
            if (!t(obj, i3, i)) {
                if (!s(object)) {
                    unsafe.putObject(obj, V2, object);
                } else {
                    Object newInstance = o2.newInstance();
                    o2.a(newInstance, object);
                    unsafe.putObject(obj, V2, newInstance);
                }
                Q(obj, i3, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, V2);
            if (!s(object2)) {
                Object newInstance2 = o2.newInstance();
                o2.a(newInstance2, object2);
                unsafe.putObject(obj, V2, newInstance2);
                object2 = newInstance2;
            }
            o2.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
    }

    public final Object y(int i, Object obj) {
        b0 o2 = o(i);
        long V2 = V(i) & 1048575;
        if (!r(i, obj)) {
            return o2.newInstance();
        }
        Object object = p.getObject(obj, V2);
        if (s(object)) {
            return object;
        }
        Object newInstance = o2.newInstance();
        if (object != null) {
            o2.a(newInstance, object);
        }
        return newInstance;
    }

    public final Object z(Object obj, int i, int i3) {
        b0 o2 = o(i3);
        if (!t(obj, i, i3)) {
            return o2.newInstance();
        }
        Object object = p.getObject(obj, V(i3) & 1048575);
        if (s(object)) {
            return object;
        }
        Object newInstance = o2.newInstance();
        if (object != null) {
            o2.a(newInstance, object);
        }
        return newInstance;
    }
}
