package X1;

import F0.C0035g2;
import F0.C0047j2;
import F0.G1;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f2612b = new i(new A.n(17));

    /* renamed from: c, reason: collision with root package name */
    public static final i f2613c = new i(new A.n(21));

    /* renamed from: a, reason: collision with root package name */
    public final h f2614a;

    static {
        new i(new A.n(23));
        new i(new A.n(22));
        new i(new A.n(18));
        new i(new A.n(20));
        new i(new A.n(19));
    }

    public i(A.n nVar) {
        if (O1.a.a()) {
            this.f2614a = new C0047j2(nVar, 10);
        } else if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            this.f2614a = new G1(nVar, 10);
        } else {
            this.f2614a = new C0035g2(nVar, 8);
        }
    }
}
