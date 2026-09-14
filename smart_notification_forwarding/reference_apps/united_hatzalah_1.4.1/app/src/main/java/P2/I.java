package P2;

/* loaded from: classes.dex */
public abstract class I {

    /* renamed from: a, reason: collision with root package name */
    public static final L f1617a;

    static {
        String str;
        boolean z3;
        L l3;
        int i = U2.u.f2378a;
        try {
            str = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            z3 = Boolean.parseBoolean(str);
        } else {
            z3 = false;
        }
        if (!z3) {
            l3 = H.f1614m;
        } else {
            W2.e eVar = O.f1622a;
            Q2.e eVar2 = U2.n.f2372a;
            Q2.e eVar3 = eVar2.f1734e;
            l3 = eVar2;
            if (eVar2 == null) {
                l3 = H.f1614m;
            }
        }
        f1617a = l3;
    }
}
