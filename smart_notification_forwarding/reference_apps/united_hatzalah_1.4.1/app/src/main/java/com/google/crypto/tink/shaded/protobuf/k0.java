package com.google.crypto.tink.shaded.protobuf;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class k0 extends m0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4124b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(Unsafe unsafe, int i) {
        super(unsafe);
        this.f4124b = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final boolean c(long j2, Object obj) {
        switch (this.f4124b) {
            case 0:
                if (n0.f4142g) {
                    if (n0.h(j2, obj) == 0) {
                        return false;
                    }
                } else if (n0.i(j2, obj) == 0) {
                    return false;
                }
                return true;
            default:
                if (n0.f4142g) {
                    if (n0.h(j2, obj) == 0) {
                        return false;
                    }
                } else if (n0.i(j2, obj) == 0) {
                    return false;
                }
                return true;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final byte d(long j2, Object obj) {
        switch (this.f4124b) {
            case 0:
                if (n0.f4142g) {
                    return n0.h(j2, obj);
                }
                return n0.i(j2, obj);
            default:
                if (n0.f4142g) {
                    return n0.h(j2, obj);
                }
                return n0.i(j2, obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final double e(long j2, Object obj) {
        switch (this.f4124b) {
            case 0:
                return Double.longBitsToDouble(h(j2, obj));
            default:
                return Double.longBitsToDouble(h(j2, obj));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final float f(long j2, Object obj) {
        switch (this.f4124b) {
            case 0:
                return Float.intBitsToFloat(g(j2, obj));
            default:
                return Float.intBitsToFloat(g(j2, obj));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final void k(Object obj, long j2, boolean z3) {
        switch (this.f4124b) {
            case 0:
                if (n0.f4142g) {
                    n0.l(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                } else {
                    n0.m(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                }
            default:
                if (n0.f4142g) {
                    n0.l(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                } else {
                    n0.m(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final void l(Object obj, long j2, byte b4) {
        switch (this.f4124b) {
            case 0:
                if (n0.f4142g) {
                    n0.l(obj, j2, b4);
                    return;
                } else {
                    n0.m(obj, j2, b4);
                    return;
                }
            default:
                if (n0.f4142g) {
                    n0.l(obj, j2, b4);
                    return;
                } else {
                    n0.m(obj, j2, b4);
                    return;
                }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final void m(Object obj, long j2, double d2) {
        switch (this.f4124b) {
            case 0:
                p(obj, j2, Double.doubleToLongBits(d2));
                return;
            default:
                p(obj, j2, Double.doubleToLongBits(d2));
                return;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final void n(Object obj, long j2, float f4) {
        switch (this.f4124b) {
            case 0:
                o(obj, Float.floatToIntBits(f4), j2);
                return;
            default:
                o(obj, Float.floatToIntBits(f4), j2);
                return;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m0
    public final boolean s() {
        switch (this.f4124b) {
            case 0:
                return false;
            default:
                return false;
        }
    }
}
