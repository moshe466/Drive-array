package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0336h;

/* loaded from: classes.dex */
public final class Y extends AbstractC0351x {
    private static final Y DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = "";
    private AbstractC0337i value_ = AbstractC0337i.f4107b;

    static {
        Y y = new Y();
        DEFAULT_INSTANCE = y;
        AbstractC0351x.t(Y.class, y);
    }

    public static W D() {
        return (W) DEFAULT_INSTANCE.h();
    }

    public static void w(Y y, String str) {
        y.getClass();
        str.getClass();
        y.typeUrl_ = str;
    }

    public static void x(Y y, C0336h c0336h) {
        y.getClass();
        y.value_ = c0336h;
    }

    public static void y(Y y, X x3) {
        y.getClass();
        if (x3 != X.UNRECOGNIZED) {
            y.keyMaterialType_ = x3.f2489a;
        } else {
            x3.getClass();
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static Y z() {
        return DEFAULT_INSTANCE;
    }

    public final X A() {
        X x3;
        int i = this.keyMaterialType_;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            x3 = null;
                        } else {
                            x3 = X.REMOTE;
                        }
                    } else {
                        x3 = X.ASYMMETRIC_PUBLIC;
                    }
                } else {
                    x3 = X.ASYMMETRIC_PRIVATE;
                }
            } else {
                x3 = X.SYMMETRIC;
            }
        } else {
            x3 = X.UNKNOWN_KEYMATERIAL;
        }
        if (x3 == null) {
            return X.UNRECOGNIZED;
        }
        return x3;
    }

    public final String B() {
        return this.typeUrl_;
    }

    public final AbstractC0337i C() {
        return this.value_;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 3:
                return new Y();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (Y.class) {
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
