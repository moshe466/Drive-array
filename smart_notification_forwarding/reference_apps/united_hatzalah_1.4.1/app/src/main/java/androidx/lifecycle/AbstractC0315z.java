package androidx.lifecycle;

/* renamed from: androidx.lifecycle.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0315z {

    /* renamed from: a, reason: collision with root package name */
    public final C f3628a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3629b;

    /* renamed from: c, reason: collision with root package name */
    public int f3630c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ A f3631d;

    public AbstractC0315z(A a2, C c4) {
        this.f3631d = a2;
        this.f3628a = c4;
    }

    public final void b(boolean z3) {
        int i;
        boolean z4;
        boolean z5;
        if (z3 != this.f3629b) {
            this.f3629b = z3;
            if (z3) {
                i = 1;
            } else {
                i = -1;
            }
            A a2 = this.f3631d;
            int i3 = a2.f3542c;
            a2.f3542c = i + i3;
            if (!a2.f3543d) {
                a2.f3543d = true;
                while (true) {
                    try {
                        int i4 = a2.f3542c;
                        if (i3 == i4) {
                            break;
                        }
                        if (i3 == 0 && i4 > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (i3 > 0 && i4 == 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z4) {
                            a2.e();
                        } else if (z5) {
                            a2.f();
                        }
                        i3 = i4;
                    } catch (Throwable th) {
                        a2.f3543d = false;
                        throw th;
                    }
                }
                a2.f3543d = false;
            }
            if (this.f3629b) {
                a2.c(this);
            }
        }
    }

    public void c() {
    }

    public boolean d(InterfaceC0309t interfaceC0309t) {
        return false;
    }

    public abstract boolean e();
}
