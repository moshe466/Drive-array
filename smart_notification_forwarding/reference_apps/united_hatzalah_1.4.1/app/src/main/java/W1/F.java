package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.C0344p;

/* loaded from: classes.dex */
public final class F extends AbstractC0351x {
    private static final F DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0337i keyValue_ = AbstractC0337i.f4107b;
    private int version_;

    static {
        F f4 = new F();
        DEFAULT_INSTANCE = f4;
        AbstractC0351x.t(F.class, f4);
    }

    public static E A() {
        return (E) DEFAULT_INSTANCE.h();
    }

    public static F B(AbstractC0337i abstractC0337i, C0344p c0344p) {
        return (F) AbstractC0351x.r(DEFAULT_INSTANCE, abstractC0337i, c0344p);
    }

    public static void w(F f4) {
        f4.version_ = 0;
    }

    public static void x(F f4, C0336h c0336h) {
        f4.getClass();
        f4.keyValue_ = c0336h;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 3:
                return new F();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (F.class) {
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

    public final AbstractC0337i y() {
        return this.keyValue_;
    }

    public final int z() {
        return this.version_;
    }
}
