package W1;

import com.google.crypto.tink.shaded.protobuf.AbstractC0330b;
import com.google.crypto.tink.shaded.protobuf.AbstractC0349v;
import com.google.crypto.tink.shaded.protobuf.AbstractC0351x;
import com.google.crypto.tink.shaded.protobuf.C0339k;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.UninitializedMessageException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class g0 extends AbstractC0351x {
    private static final g0 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.W PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.A key_ = com.google.crypto.tink.shaded.protobuf.Z.f4078d;
    private int primaryKeyId_;

    static {
        g0 g0Var = new g0();
        DEFAULT_INSTANCE = g0Var;
        AbstractC0351x.t(g0.class, g0Var);
    }

    public static d0 C() {
        return (d0) DEFAULT_INSTANCE.h();
    }

    public static g0 D(ByteArrayInputStream byteArrayInputStream, C0344p c0344p) {
        AbstractC0351x s3 = AbstractC0351x.s(DEFAULT_INSTANCE, new C0339k(byteArrayInputStream), c0344p);
        AbstractC0351x.g(s3);
        return (g0) s3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, com.google.crypto.tink.shaded.protobuf.d] */
    public static g0 E(byte[] bArr, C0344p c0344p) {
        g0 g0Var = DEFAULT_INSTANCE;
        int length = bArr.length;
        AbstractC0351x q3 = g0Var.q();
        try {
            com.google.crypto.tink.shaded.protobuf.Y y = com.google.crypto.tink.shaded.protobuf.Y.f4075c;
            y.getClass();
            com.google.crypto.tink.shaded.protobuf.b0 a2 = y.a(q3.getClass());
            ?? obj = new Object();
            c0344p.getClass();
            a2.g(q3, bArr, 0, length, obj);
            a2.b(q3);
            AbstractC0351x.g(q3);
            return (g0) q3;
        } catch (InvalidProtocolBufferException e4) {
            if (e4.f4047a) {
                throw new IOException(e4.getMessage(), e4);
            }
            throw e4;
        } catch (UninitializedMessageException e5) {
            throw new IOException(e5.getMessage());
        } catch (IOException e6) {
            if (e6.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e6.getCause());
            }
            throw new IOException(e6.getMessage(), e6);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.h();
        }
    }

    public static void w(g0 g0Var, int i) {
        g0Var.primaryKeyId_ = i;
    }

    public static void x(g0 g0Var, f0 f0Var) {
        int i;
        g0Var.getClass();
        com.google.crypto.tink.shaded.protobuf.A a2 = g0Var.key_;
        if (!((AbstractC0330b) a2).f4085a) {
            int size = a2.size();
            if (size == 0) {
                i = 10;
            } else {
                i = size * 2;
            }
            g0Var.key_ = a2.a(i);
        }
        g0Var.key_.add(f0Var);
    }

    public final List A() {
        return this.key_;
    }

    public final int B() {
        return this.primaryKeyId_;
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
                return new com.google.crypto.tink.shaded.protobuf.a0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", f0.class});
            case 3:
                return new g0();
            case 4:
                return new AbstractC0349v(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.W w4 = PARSER;
                if (w4 == null) {
                    synchronized (g0.class) {
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

    public final f0 y(int i) {
        return (f0) this.key_.get(i);
    }

    public final int z() {
        return this.key_.size();
    }
}
