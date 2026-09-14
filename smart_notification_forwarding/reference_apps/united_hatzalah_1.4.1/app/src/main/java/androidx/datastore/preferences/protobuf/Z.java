package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class Z {

    /* renamed from: f, reason: collision with root package name */
    public static final Z f3148f = new Z(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f3149a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f3150b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f3151c;

    /* renamed from: d, reason: collision with root package name */
    public int f3152d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3153e;

    public Z(int i, int[] iArr, Object[] objArr, boolean z3) {
        this.f3149a = i;
        this.f3150b = iArr;
        this.f3151c = objArr;
        this.f3153e = z3;
    }

    public final void a(int i) {
        int[] iArr = this.f3150b;
        if (i > iArr.length) {
            int i3 = this.f3149a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i) {
                i = i4;
            }
            if (i < 8) {
                i = 8;
            }
            this.f3150b = Arrays.copyOf(iArr, i);
            this.f3151c = Arrays.copyOf(this.f3151c, i);
        }
    }

    public final int b() {
        int M3;
        int O3;
        int M4;
        int i = this.f3152d;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3149a; i4++) {
            int i5 = this.f3150b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                ((Integer) this.f3151c[i4]).getClass();
                                M4 = C0244k.M(i6) + 4;
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.b());
                            }
                        } else {
                            M3 = C0244k.M(i6) * 2;
                            O3 = ((Z) this.f3151c[i4]).b();
                        }
                    } else {
                        M4 = C0244k.K(i6, (C0240g) this.f3151c[i4]);
                    }
                } else {
                    ((Long) this.f3151c[i4]).getClass();
                    M4 = C0244k.M(i6) + 8;
                }
                i3 = M4 + i3;
            } else {
                long longValue = ((Long) this.f3151c[i4]).longValue();
                M3 = C0244k.M(i6);
                O3 = C0244k.O(longValue);
            }
            i3 = O3 + M3 + i3;
        }
        this.f3152d = i3;
        return i3;
    }

    public final void c(int i, Object obj) {
        if (this.f3153e) {
            a(this.f3149a + 1);
            int[] iArr = this.f3150b;
            int i3 = this.f3149a;
            iArr[i3] = i;
            this.f3151c[i3] = obj;
            this.f3149a = i3 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(B b4) {
        if (this.f3149a != 0) {
            b4.getClass();
            C0244k c0244k = (C0244k) b4.f3089a;
            for (int i = 0; i < this.f3149a; i++) {
                int i3 = this.f3150b[i];
                Object obj = this.f3151c[i];
                int i4 = i3 >>> 3;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 == 5) {
                                    c0244k.W(i4, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(InvalidProtocolBufferException.b());
                                }
                            } else {
                                c0244k.f0(i4, 3);
                                ((Z) obj).d(b4);
                                c0244k.f0(i4, 4);
                            }
                        } else {
                            c0244k.U(i4, (C0240g) obj);
                        }
                    } else {
                        c0244k.Y(i4, ((Long) obj).longValue());
                    }
                } else {
                    c0244k.i0(i4, ((Long) obj).longValue());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Z)) {
            return false;
        }
        Z z3 = (Z) obj;
        int i = this.f3149a;
        if (i == z3.f3149a) {
            int[] iArr = this.f3150b;
            int[] iArr2 = z3.f3150b;
            int i3 = 0;
            while (true) {
                if (i3 < i) {
                    if (iArr[i3] != iArr2[i3]) {
                        break;
                    }
                    i3++;
                } else {
                    Object[] objArr = this.f3151c;
                    Object[] objArr2 = z3.f3151c;
                    int i4 = this.f3149a;
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
        int i = this.f3149a;
        int i3 = (527 + i) * 31;
        int[] iArr = this.f3150b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f3151c;
        int i8 = this.f3149a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }
}
