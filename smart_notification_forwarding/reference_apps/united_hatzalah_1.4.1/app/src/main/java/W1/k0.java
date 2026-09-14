package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0330b;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;

/* loaded from: classes.dex */
public final class k0 extends AbstractC0351x {
    private static final k0 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.A keyInfo_ = com.google.crypto.tink.shaded.protobuf.Z.f4078d;
    private int primaryKeyId_;

    static {
        k0 k0Var = new k0();
        DEFAULT_INSTANCE = k0Var;
        AbstractC0351x.t(k0.class, k0Var);
    }

    public static void w(k0 k0Var, int i) {
        k0Var.primaryKeyId_ = i;
    }

    public static void x(k0 k0Var, j0 j0Var) {
        int i;
        k0Var.getClass();
        com.google.crypto.tink.shaded.protobuf.A a2 = k0Var.keyInfo_;
        if (!((AbstractC0330b) a2).f4085a) {
            int size = a2.size();
            if (size == 0) {
                i = 10;
            } else {
                i = size * 2;
            }
            k0Var.keyInfo_ = a2.a(i);
        }
        k0Var.keyInfo_.add(j0Var);
    }

    public static h0 z() {
        return (h0) DEFAULT_INSTANCE.h();
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", j0.class});
            case 3:
                return new k0();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (k0.class) {
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

    public final j0 y() {
        return (j0) this.keyInfo_.get(0);
    }
}
