package F0;

/* renamed from: F0.f2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0031f2 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f509a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f510b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f511c;

    /* renamed from: d, reason: collision with root package name */
    public Long f512d;

    public C0031f2(boolean z3, boolean z4, boolean z5) {
        this.f509a = z3;
        this.f510b = z4;
        this.f511c = z5;
    }

    public final boolean a() {
        boolean z3 = false;
        char c4 = 47896;
        while (true) {
            if (c4 != 12902) {
                if (c4 != 9299) {
                    if (c4 != 43659) {
                        if (c4 != 47896 || !this.f509a) {
                            c4 = 12902;
                        } else {
                            c4 = 9299;
                        }
                    } else {
                        return z3;
                    }
                } else {
                    z3 = false;
                }
            } else {
                z3 = true;
            }
            c4 = 43659;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0008. Please report as an issue. */
    public final boolean b() {
        char c4 = 6324;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 21381:
                    z3 = true;
                    c4 = 55965;
                case 17368:
                    if (!this.f511c) {
                        c4 = 21381;
                    } else {
                        c4 = 26943;
                    }
                case 55965:
                    break;
                case 11119:
                    if (this.f510b) {
                        c4 = 17368;
                    } else {
                        c4 = 21381;
                    }
                case 6324:
                    if (this.f509a) {
                        c4 = 11119;
                    } else {
                        c4 = 21381;
                    }
                case 26943:
                    z3 = false;
                    c4 = 55965;
                default:
                    c4 = 26943;
            }
            return z3;
        }
    }
}
