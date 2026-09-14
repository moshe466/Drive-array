package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.C0339k;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import java.io.ByteArrayInputStream;

/* loaded from: classes.dex */
public final class N extends AbstractC0351x {
    private static final N DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER;
    private AbstractC0337i encryptedKeyset_ = AbstractC0337i.f4107b;
    private k0 keysetInfo_;

    static {
        N n4 = new N();
        DEFAULT_INSTANCE = n4;
        AbstractC0351x.t(N.class, n4);
    }

    public static N A(ByteArrayInputStream byteArrayInputStream, C0344p c0344p) {
        AbstractC0351x s3 = AbstractC0351x.s(DEFAULT_INSTANCE, new C0339k(byteArrayInputStream), c0344p);
        AbstractC0351x.g(s3);
        return (N) s3;
    }

    public static void w(N n4, C0336h c0336h) {
        n4.getClass();
        n4.encryptedKeyset_ = c0336h;
    }

    public static void x(N n4, k0 k0Var) {
        n4.getClass();
        n4.keysetInfo_ = k0Var;
    }

    public static M z() {
        return (M) DEFAULT_INSTANCE.h();
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 3:
                return new N();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (N.class) {
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
        return this.encryptedKeyset_;
    }
}
