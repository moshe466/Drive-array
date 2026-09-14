package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0344p;

/* loaded from: classes.dex */
public final class T extends AbstractC0351x {
    private static final T DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private V params_;
    private int version_;

    /* JADX WARN: Type inference failed for: r0v0, types: [W1.T, com.google.crypto.tink.shaded.protobuf.x] */
    static {
        ?? abstractC0351x = new AbstractC0351x();
        DEFAULT_INSTANCE = abstractC0351x;
        AbstractC0351x.t(T.class, abstractC0351x);
    }

    public static S B() {
        return (S) DEFAULT_INSTANCE.h();
    }

    public static T C(AbstractC0337i abstractC0337i, C0344p c0344p) {
        return (T) AbstractC0351x.r(DEFAULT_INSTANCE, abstractC0337i, c0344p);
    }

    public static void w(T t3, V v2) {
        t3.getClass();
        t3.params_ = v2;
    }

    public static void x(T t3, int i) {
        t3.keySize_ = i;
    }

    public static T y() {
        return DEFAULT_INSTANCE;
    }

    public final V A() {
        V v2 = this.params_;
        if (v2 == null) {
            return V.y();
        }
        return v2;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 3:
                return new AbstractC0351x();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (T.class) {
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

    public final int z() {
        return this.keySize_;
    }
}
