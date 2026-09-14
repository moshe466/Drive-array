package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0344p;

/* renamed from: W1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0210h extends AbstractC0351x {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    private static final C0210h DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private C0214l aesCtrKey_;
    private Q hmacKey_;
    private int version_;

    /* JADX WARN: Type inference failed for: r0v0, types: [W1.h, com.google.crypto.tink.shaded.protobuf.x] */
    static {
        ?? abstractC0351x = new AbstractC0351x();
        DEFAULT_INSTANCE = abstractC0351x;
        AbstractC0351x.t(C0210h.class, abstractC0351x);
    }

    public static C0209g C() {
        return (C0209g) DEFAULT_INSTANCE.h();
    }

    public static C0210h D(AbstractC0337i abstractC0337i, C0344p c0344p) {
        return (C0210h) AbstractC0351x.r(DEFAULT_INSTANCE, abstractC0337i, c0344p);
    }

    public static void w(C0210h c0210h) {
        c0210h.version_ = 0;
    }

    public static void x(C0210h c0210h, C0214l c0214l) {
        c0210h.getClass();
        c0214l.getClass();
        c0210h.aesCtrKey_ = c0214l;
    }

    public static void y(C0210h c0210h, Q q3) {
        c0210h.getClass();
        q3.getClass();
        c0210h.hmacKey_ = q3;
    }

    public final Q A() {
        Q q3 = this.hmacKey_;
        if (q3 == null) {
            return Q.z();
        }
        return q3;
    }

    public final int B() {
        return this.version_;
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object, com.google.crypto.tink.shaded.protobuf.W] */
    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0351x
    public final Object i(int i) {
        com.google.crypto.tink.shaded.protobuf.W w3;
        switch (T.k.b(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 3:
                return new AbstractC0351x();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (C0210h.class) {
                        try {
                            com.google.crypto.tink.shaded.protobuf.W w5 = PARSER;
                            w3 = w5;
                            if (w5 == null) {
                                ?? obj = new Object();
                                PARSER = obj;
                                w3 = obj;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return w3;
                }
                return w4;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final C0214l z() {
        C0214l c0214l = this.aesCtrKey_;
        if (c0214l == null) {
            return C0214l.z();
        }
        return c0214l;
    }
}
