package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0344p;

/* renamed from: W1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0206d extends AbstractC0351x {
    private static final C0206d DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER;
    private int keySize_;
    private C0208f params_;

    /* JADX WARN: Type inference failed for: r0v0, types: [W1.d, com.google.crypto.tink.shaded.protobuf.x] */
    static {
        ?? abstractC0351x = new AbstractC0351x();
        DEFAULT_INSTANCE = abstractC0351x;
        AbstractC0351x.t(C0206d.class, abstractC0351x);
    }

    public static C0205c A() {
        return (C0205c) DEFAULT_INSTANCE.h();
    }

    public static C0206d B(AbstractC0337i abstractC0337i, C0344p c0344p) {
        return (C0206d) AbstractC0351x.r(DEFAULT_INSTANCE, abstractC0337i, c0344p);
    }

    public static void w(C0206d c0206d) {
        c0206d.keySize_ = 32;
    }

    public static void x(C0206d c0206d, C0208f c0208f) {
        c0206d.getClass();
        c0206d.params_ = c0208f;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"keySize_", "params_"});
            case 3:
                return new AbstractC0351x();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (C0206d.class) {
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

    public final int y() {
        return this.keySize_;
    }

    public final C0208f z() {
        C0208f c0208f = this.params_;
        if (c0208f == null) {
            return C0208f.x();
        }
        return c0208f;
    }
}
