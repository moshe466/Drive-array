package N1;

import F0.AbstractC0008a;
import I2.b;
import X1.n;
import X1.o;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class a implements K1.a {

    /* renamed from: b, reason: collision with root package name */
    public static final b f1505b = new b(2);

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f1506c;

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f1507a;

    static {
        boolean z3;
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            z3 = true;
        } catch (ClassNotFoundException unused) {
            z3 = false;
        }
        f1506c = z3;
    }

    public a(byte[] bArr) {
        o.a(bArr.length);
        this.f1507a = new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec c(byte[] bArr, int i) {
        if (f1506c) {
            return new GCMParameterSpec(128, bArr, 0, i);
        }
        if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            return new IvParameterSpec(bArr, 0, i);
        }
        throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
    }

    @Override // K1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[bArr.length + 28];
            byte[] a2 = n.a(12);
            System.arraycopy(a2, 0, bArr3, 0, 12);
            AlgorithmParameterSpec c4 = c(a2, a2.length);
            b bVar = f1505b;
            ((Cipher) bVar.get()).init(1, this.f1507a, c4);
            if (bArr2 != null && bArr2.length != 0) {
                ((Cipher) bVar.get()).updateAAD(bArr2);
            }
            int doFinal = ((Cipher) bVar.get()).doFinal(bArr, 0, bArr.length, bArr3, 12);
            if (doFinal == bArr.length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(AbstractC0008a.j(doFinal - bArr.length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // K1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= 28) {
            AlgorithmParameterSpec c4 = c(bArr, 12);
            b bVar = f1505b;
            ((Cipher) bVar.get()).init(2, this.f1507a, c4);
            if (bArr2 != null && bArr2.length != 0) {
                ((Cipher) bVar.get()).updateAAD(bArr2);
            }
            return ((Cipher) bVar.get()).doFinal(bArr, 12, bArr.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
