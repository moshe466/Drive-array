package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;

/* renamed from: W1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0208f extends AbstractC0351x {
    private static final C0208f DEFAULT_INSTANCE;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int TAG_SIZE_FIELD_NUMBER = 1;
    private int tagSize_;

    /* JADX WARN: Type inference failed for: r0v0, types: [W1.f, com.google.crypto.tink.shaded.protobuf.x] */
    static {
        ?? abstractC0351x = new AbstractC0351x();
        DEFAULT_INSTANCE = abstractC0351x;
        AbstractC0351x.t(C0208f.class, abstractC0351x);
    }

    public static void w(C0208f c0208f) {
        c0208f.tagSize_ = 16;
    }

    public static C0208f x() {
        return DEFAULT_INSTANCE;
    }

    public static C0207e z() {
        return (C0207e) DEFAULT_INSTANCE.h();
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"tagSize_"});
            case 3:
                return new AbstractC0351x();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (C0208f.class) {
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
        return this.tagSize_;
    }
}
