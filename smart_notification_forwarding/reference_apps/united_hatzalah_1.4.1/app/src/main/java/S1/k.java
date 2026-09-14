package S1;

import J.C0119g;
import R1.s;
import W1.O;
import W1.r0;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final R1.j f2145a;

    /* renamed from: b, reason: collision with root package name */
    public static final R1.i f2146b;

    /* renamed from: c, reason: collision with root package name */
    public static final R1.b f2147c;

    /* renamed from: d, reason: collision with root package name */
    public static final R1.a f2148d;

    static {
        Y1.a b4 = s.b("type.googleapis.com/google.crypto.tink.HmacKey");
        f2145a = new R1.j(j.class);
        f2146b = new R1.i(b4);
        f2147c = new R1.b(i.class);
        f2148d = new R1.a(b4, new C0119g(12));
    }

    public static c a(O o2) {
        int ordinal = o2.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return c.f2122h;
                        }
                        throw new GeneralSecurityException("Unable to parse HashType: " + o2.a());
                    }
                    return c.f2124k;
                }
                return c.i;
            }
            return c.f2123j;
        }
        return c.f2121g;
    }

    public static c b(r0 r0Var) {
        int ordinal = r0Var.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return c.f2126m;
                    }
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var.b());
                }
                return c.f2128o;
            }
            return c.f2127n;
        }
        return c.f2125l;
    }
}
