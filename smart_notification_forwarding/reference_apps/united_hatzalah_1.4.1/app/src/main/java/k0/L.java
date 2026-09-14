package k0;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public int f5197a;

    /* renamed from: b, reason: collision with root package name */
    public int f5198b;

    /* renamed from: c, reason: collision with root package name */
    public int f5199c;

    /* renamed from: d, reason: collision with root package name */
    public int f5200d;

    /* renamed from: e, reason: collision with root package name */
    public int f5201e;

    public final boolean a() {
        int i;
        int i3;
        int i4;
        int i5 = this.f5197a;
        int i6 = 2;
        if ((i5 & 7) != 0) {
            int i7 = this.f5200d;
            int i8 = this.f5198b;
            if (i7 > i8) {
                i4 = 1;
            } else if (i7 == i8) {
                i4 = 2;
            } else {
                i4 = 4;
            }
            if ((i4 & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 112) != 0) {
            int i9 = this.f5200d;
            int i10 = this.f5199c;
            if (i9 > i10) {
                i3 = 1;
            } else if (i9 == i10) {
                i3 = 2;
            } else {
                i3 = 4;
            }
            if (((i3 << 4) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 1792) != 0) {
            int i11 = this.f5201e;
            int i12 = this.f5198b;
            if (i11 > i12) {
                i = 1;
            } else if (i11 == i12) {
                i = 2;
            } else {
                i = 4;
            }
            if (((i << 8) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 28672) != 0) {
            int i13 = this.f5201e;
            int i14 = this.f5199c;
            if (i13 > i14) {
                i6 = 1;
            } else if (i13 != i14) {
                i6 = 4;
            }
            if ((i5 & (i6 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
