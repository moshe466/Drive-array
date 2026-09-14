package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0344p;

/* renamed from: W1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0212j extends AbstractC0351x {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final C0212j DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER;
    private C0216n aesCtrKeyFormat_;
    private T hmacKeyFormat_;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.crypto.tink.shaded.protobuf.x, W1.j] */
    static {
        ?? abstractC0351x = new AbstractC0351x();
        DEFAULT_INSTANCE = abstractC0351x;
        AbstractC0351x.t(C0212j.class, abstractC0351x);
    }

    public static C0211i A() {
        return (C0211i) DEFAULT_INSTANCE.h();
    }

    public static C0212j B(AbstractC0337i abstractC0337i, C0344p c0344p) {
        return (C0212j) AbstractC0351x.r(DEFAULT_INSTANCE, abstractC0337i, c0344p);
    }

    public static void w(C0212j c0212j, C0216n c0216n) {
        c0212j.getClass();
        c0212j.aesCtrKeyFormat_ = c0216n;
    }

    public static void x(C0212j c0212j, T t3) {
        c0212j.getClass();
        c0212j.hmacKeyFormat_ = t3;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 3:
                return new AbstractC0351x();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (C0212j.class) {
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

    public final C0216n y() {
        C0216n c0216n = this.aesCtrKeyFormat_;
        if (c0216n == null) {
            return C0216n.y();
        }
        return c0216n;
    }

    public final T z() {
        T t3 = this.hmacKeyFormat_;
        if (t3 == null) {
            return T.y();
        }
        return t3;
    }
}
