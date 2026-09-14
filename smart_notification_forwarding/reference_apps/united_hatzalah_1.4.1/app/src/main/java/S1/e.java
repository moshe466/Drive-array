package S1;

import J.C0119g;
import R1.s;
import W1.r0;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final R1.j f2134a;

    /* renamed from: b, reason: collision with root package name */
    public static final R1.i f2135b;

    /* renamed from: c, reason: collision with root package name */
    public static final R1.b f2136c;

    /* renamed from: d, reason: collision with root package name */
    public static final R1.a f2137d;

    static {
        Y1.a b4 = s.b("type.googleapis.com/google.crypto.tink.AesCmacKey");
        f2134a = new R1.j(d.class);
        f2135b = new R1.i(b4);
        f2136c = new R1.b(a.class);
        f2137d = new R1.a(b4, new C0119g(10));
    }

    public static c a(r0 r0Var) {
        int ordinal = r0Var.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return c.f2118d;
                    }
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var.b());
                }
                return c.f2120f;
            }
            return c.f2119e;
        }
        return c.f2117c;
    }
}
