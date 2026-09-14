package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0336h;

/* renamed from: W1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0214l extends AbstractC0351x {
    private static final C0214l DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0337i keyValue_ = AbstractC0337i.f4107b;
    private C0218p params_;
    private int version_;

    static {
        C0214l c0214l = new C0214l();
        DEFAULT_INSTANCE = c0214l;
        AbstractC0351x.t(C0214l.class, c0214l);
    }

    public static C0213k D() {
        return (C0213k) DEFAULT_INSTANCE.h();
    }

    public static void w(C0214l c0214l) {
        c0214l.version_ = 0;
    }

    public static void x(C0214l c0214l, C0218p c0218p) {
        c0214l.getClass();
        c0218p.getClass();
        c0214l.params_ = c0218p;
    }

    public static void y(C0214l c0214l, C0336h c0336h) {
        c0214l.getClass();
        c0214l.keyValue_ = c0336h;
    }

    public static C0214l z() {
        return DEFAULT_INSTANCE;
    }

    public final AbstractC0337i A() {
        return this.keyValue_;
    }

    public final C0218p B() {
        C0218p c0218p = this.params_;
        if (c0218p == null) {
            return C0218p.x();
        }
        return c0218p;
    }

    public final int C() {
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 3:
                return new C0214l();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (C0214l.class) {
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
}
