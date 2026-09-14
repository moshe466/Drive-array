package L1;

import F0.AbstractC0083t;
import W1.b0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class y implements K1.a {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f1350c = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final b0 f1351a;

    /* renamed from: b, reason: collision with root package name */
    public final Q1.b f1352b;

    public y(b0 b0Var, Q1.b bVar) {
        this.f1351a = b0Var;
        this.f1352b = bVar;
    }

    @Override // K1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        AbstractC0329a c4;
        b0 b0Var = this.f1351a;
        AtomicReference atomicReference = K1.o.f1106a;
        synchronized (K1.o.class) {
            try {
                R1.d dVar = ((K1.e) K1.o.f1106a.get()).a(b0Var.B()).f1082a;
                Class cls = dVar.f1986c;
                if (!dVar.f1985b.keySet().contains(cls) && !Void.class.equals(cls)) {
                    throw new IllegalArgumentException("Given internalKeyMananger " + dVar.toString() + " does not support primitive class " + cls.getName());
                }
                if (((Boolean) K1.o.f1108c.get(b0Var.B())).booleanValue()) {
                    AbstractC0337i C3 = b0Var.C();
                    try {
                        AbstractC0083t d2 = dVar.d();
                        AbstractC0329a n4 = d2.n(C3);
                        d2.o(n4);
                        c4 = d2.c(n4);
                    } catch (InvalidProtocolBufferException e4) {
                        throw new GeneralSecurityException("Failures parsing proto of type ".concat(((Class) dVar.d().f662a).getName()), e4);
                    }
                } else {
                    throw new GeneralSecurityException("newKey-operation not permitted for key type " + b0Var.B());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byte[] e5 = c4.e();
        byte[] a2 = this.f1352b.a(e5, f1350c);
        byte[] a4 = ((K1.a) K1.o.d(this.f1351a.B(), e5)).a(bArr, bArr2);
        return ByteBuffer.allocate(a2.length + 4 + a4.length).putInt(a2.length).put(a2).put(a4).array();
    }

    @Override // K1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i > 0 && i <= bArr.length - 4) {
                byte[] bArr3 = new byte[i];
                wrap.get(bArr3, 0, i);
                byte[] bArr4 = new byte[wrap.remaining()];
                wrap.get(bArr4, 0, wrap.remaining());
                return ((K1.a) K1.o.d(this.f1351a.B(), this.f1352b.b(bArr3, f1350c))).b(bArr4, bArr2);
            }
            throw new GeneralSecurityException("invalid ciphertext");
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e5) {
            e = e5;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e6) {
            e = e6;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
