package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.C0344p;

/* renamed from: W1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0204b extends AbstractC0351x {
    private static final C0204b DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0337i keyValue_ = AbstractC0337i.f4107b;
    private C0208f params_;
    private int version_;

    static {
        C0204b c0204b = new C0204b();
        DEFAULT_INSTANCE = c0204b;
        AbstractC0351x.t(C0204b.class, c0204b);
    }

    public static C0203a C() {
        return (C0203a) DEFAULT_INSTANCE.h();
    }

    public static C0204b D(AbstractC0337i abstractC0337i, C0344p c0344p) {
        return (C0204b) AbstractC0351x.r(DEFAULT_INSTANCE, abstractC0337i, c0344p);
    }

    public static void w(C0204b c0204b) {
        c0204b.version_ = 0;
    }

    public static void x(C0204b c0204b, C0336h c0336h) {
        c0204b.getClass();
        c0204b.keyValue_ = c0336h;
    }

    public static void y(C0204b c0204b, C0208f c0208f) {
        c0204b.getClass();
        c0208f.getClass();
        c0204b.params_ = c0208f;
    }

    public final C0208f A() {
        C0208f c0208f = this.params_;
        if (c0208f == null) {
            return C0208f.x();
        }
        return c0208f;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"version_", "keyValue_", "params_"});
            case 3:
                return new C0204b();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (C0204b.class) {
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

    public final AbstractC0337i z() {
        return this.keyValue_;
    }
}
