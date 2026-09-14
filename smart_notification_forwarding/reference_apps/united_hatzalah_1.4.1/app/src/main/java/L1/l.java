package L1;

import J.C0119g;
import W1.O;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final R1.j f1320a;

    /* renamed from: b, reason: collision with root package name */
    public static final R1.i f1321b;

    /* renamed from: c, reason: collision with root package name */
    public static final R1.b f1322c;

    /* renamed from: d, reason: collision with root package name */
    public static final R1.a f1323d;

    static {
        Y1.a b4 = R1.s.b("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        f1320a = new R1.j(k.class);
        f1321b = new R1.i(b4);
        f1322c = new R1.b(f.class);
        f1323d = new R1.a(b4, new C0119g(2));
    }

    public static j a(O o2) {
        int ordinal = o2.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return j.f1294d;
                        }
                        throw new GeneralSecurityException("Unable to parse HashType: " + o2.a());
                    }
                    return j.f1297g;
                }
                return j.f1295e;
            }
            return j.f1296f;
        }
        return j.f1293c;
    }
}
