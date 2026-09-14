package androidx.datastore.preferences.protobuf;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class c0 extends e0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3157b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(Unsafe unsafe, int i) {
        super(unsafe);
        this.f3157b = i;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final boolean c(long j2, Object obj) {
        switch (this.f3157b) {
            case 0:
                if (f0.f3172g) {
                    return f0.b(j2, obj);
                }
                return f0.c(j2, obj);
            default:
                if (f0.f3172g) {
                    return f0.b(j2, obj);
                }
                return f0.c(j2, obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final double d(long j2, Object obj) {
        switch (this.f3157b) {
            case 0:
                return Double.longBitsToDouble(g(j2, obj));
            default:
                return Double.longBitsToDouble(g(j2, obj));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final float e(long j2, Object obj) {
        switch (this.f3157b) {
            case 0:
                return Float.intBitsToFloat(f(j2, obj));
            default:
                return Float.intBitsToFloat(f(j2, obj));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final void j(Object obj, long j2, boolean z3) {
        switch (this.f3157b) {
            case 0:
                if (f0.f3172g) {
                    f0.k(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                } else {
                    f0.l(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                }
            default:
                if (f0.f3172g) {
                    f0.k(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                } else {
                    f0.l(obj, j2, z3 ? (byte) 1 : (byte) 0);
                    return;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final void k(Object obj, long j2, byte b4) {
        switch (this.f3157b) {
            case 0:
                if (f0.f3172g) {
                    f0.k(obj, j2, b4);
                    return;
                } else {
                    f0.l(obj, j2, b4);
                    return;
                }
            default:
                if (f0.f3172g) {
                    f0.k(obj, j2, b4);
                    return;
                } else {
                    f0.l(obj, j2, b4);
                    return;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final void l(Object obj, long j2, double d2) {
        switch (this.f3157b) {
            case 0:
                o(obj, j2, Double.doubleToLongBits(d2));
                return;
            default:
                o(obj, j2, Double.doubleToLongBits(d2));
                return;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final void m(Object obj, long j2, float f4) {
        switch (this.f3157b) {
            case 0:
                n(obj, Float.floatToIntBits(f4), j2);
                return;
            default:
                n(obj, Float.floatToIntBits(f4), j2);
                return;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final boolean r() {
        switch (this.f3157b) {
            case 0:
                return false;
            default:
                return false;
        }
    }
}
