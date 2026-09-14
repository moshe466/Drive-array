package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;

/* loaded from: classes.dex */
public final class f0 extends AbstractC0351x {
    private static final f0 DEFAULT_INSTANCE;
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private Y keyData_;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.crypto.tink.shaded.protobuf.x, W1.f0] */
    static {
        ?? abstractC0351x = new AbstractC0351x();
        DEFAULT_INSTANCE = abstractC0351x;
        AbstractC0351x.t(f0.class, abstractC0351x);
    }

    public static e0 F() {
        return (e0) DEFAULT_INSTANCE.h();
    }

    public static void w(f0 f0Var, Y y) {
        f0Var.getClass();
        f0Var.keyData_ = y;
    }

    public static void x(f0 f0Var, r0 r0Var) {
        f0Var.getClass();
        f0Var.outputPrefixType_ = r0Var.b();
    }

    public static void y(f0 f0Var) {
        f0Var.getClass();
        f0Var.status_ = Z.ENABLED.a();
    }

    public static void z(f0 f0Var, int i) {
        f0Var.keyId_ = i;
    }

    public final Y A() {
        Y y = this.keyData_;
        if (y == null) {
            return Y.z();
        }
        return y;
    }

    public final int B() {
        return this.keyId_;
    }

    public final r0 C() {
        r0 a2 = r0.a(this.outputPrefixType_);
        if (a2 == null) {
            return r0.UNRECOGNIZED;
        }
        return a2;
    }

    public final Z D() {
        Z z3;
        int i = this.status_;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        z3 = null;
                    } else {
                        z3 = Z.DESTROYED;
                    }
                } else {
                    z3 = Z.DISABLED;
                }
            } else {
                z3 = Z.ENABLED;
            }
        } else {
            z3 = Z.UNKNOWN_STATUS;
        }
        if (z3 == null) {
            return Z.UNRECOGNIZED;
        }
        return z3;
    }

    public final boolean E() {
        if (this.keyData_ != null) {
            return true;
        }
        return false;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new AbstractC0351x();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (f0.class) {
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
