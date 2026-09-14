package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: f, reason: collision with root package name */
    public static final e0 f4095f = new e0(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f4096a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4097b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f4098c;

    /* renamed from: d, reason: collision with root package name */
    public int f4099d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4100e;

    public e0(int i, int[] iArr, Object[] objArr, boolean z3) {
        this.f4096a = i;
        this.f4097b = iArr;
        this.f4098c = objArr;
        this.f4100e = z3;
    }

    public static e0 c() {
        return new e0(0, new int[8], new Object[8], true);
    }

    public final void a(int i) {
        int[] iArr = this.f4097b;
        if (i > iArr.length) {
            int i3 = this.f4096a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i) {
                i = i4;
            }
            if (i < 8) {
                i = 8;
            }
            this.f4097b = Arrays.copyOf(iArr, i);
            this.f4098c = Arrays.copyOf(this.f4098c, i);
        }
    }

    public final int b() {
        int M3;
        int O3;
        int I3;
        int i = this.f4099d;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4096a; i4++) {
            int i5 = this.f4097b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                ((Integer) this.f4098c[i4]).getClass();
                                I3 = C0341m.H(i6);
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.c());
                            }
                        } else {
                            M3 = C0341m.M(i6) * 2;
                            O3 = ((e0) this.f4098c[i4]).b();
                        }
                    } else {
                        I3 = C0341m.F(i6, (AbstractC0337i) this.f4098c[i4]);
                    }
                } else {
                    ((Long) this.f4098c[i4]).getClass();
                    I3 = C0341m.I(i6);
                }
                i3 = I3 + i3;
            } else {
                long longValue = ((Long) this.f4098c[i4]).longValue();
                M3 = C0341m.M(i6);
                O3 = C0341m.O(longValue);
            }
            i3 = O3 + M3 + i3;
        }
        this.f4099d = i3;
        return i3;
    }

    public final void d(int i, Object obj) {
        if (this.f4100e) {
            a(this.f4096a + 1);
            int[] iArr = this.f4097b;
            int i3 = this.f4096a;
            iArr[i3] = i;
            this.f4098c[i3] = obj;
            this.f4096a = i3 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void e(K k4) {
        if (this.f4096a != 0) {
            k4.getClass();
            C0341m c0341m = (C0341m) k4.f4050a;
            for (int i = 0; i < this.f4096a; i++) {
                int i3 = this.f4097b[i];
                Object obj = this.f4098c[i];
                int i4 = i3 >>> 3;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 == 5) {
                                    c0341m.R(i4, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(InvalidProtocolBufferException.c());
                                }
                            } else {
                                c0341m.W(i4, 3);
                                ((e0) obj).e(k4);
                                c0341m.W(i4, 4);
                            }
                        } else {
                            k4.a(i4, (AbstractC0337i) obj);
                        }
                    } else {
                        c0341m.T(i4, ((Long) obj).longValue());
                    }
                } else {
                    c0341m.Y(i4, ((Long) obj).longValue());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        int i = this.f4096a;
        if (i == e0Var.f4096a) {
            int[] iArr = this.f4097b;
            int[] iArr2 = e0Var.f4097b;
            int i3 = 0;
            while (true) {
                if (i3 < i) {
                    if (iArr[i3] != iArr2[i3]) {
                        break;
                    }
                    i3++;
                } else {
                    Object[] objArr = this.f4098c;
                    Object[] objArr2 = e0Var.f4098c;
                    int i4 = this.f4096a;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f4096a;
        int i3 = (527 + i) * 31;
        int[] iArr = this.f4097b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f4098c;
        int i8 = this.f4096a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }
}
