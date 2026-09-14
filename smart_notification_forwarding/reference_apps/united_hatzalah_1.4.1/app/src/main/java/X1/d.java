package X1;

import F0.AbstractC0008a;
import F0.b3;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class d implements K1.c {

    /* renamed from: c, reason: collision with root package name */
    public static final List f2601c = Arrays.asList(64);

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f2602d = new byte[16];

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f2603e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public final b3 f2604a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2605b;

    public d(byte[] bArr) {
        if (AbstractC0008a.b(1)) {
            if (f2601c.contains(Integer.valueOf(bArr.length))) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
                this.f2605b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
                this.f2604a = new b3(copyOfRange);
                return;
            }
            throw new InvalidKeyException(AbstractC0008a.r(new StringBuilder("invalid key size: "), bArr.length, " bytes; key must have 64 bytes"));
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    @Override // K1.c
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 2147483631) {
            Cipher cipher = (Cipher) i.f2612b.f2614a.k("AES/CTR/NoPadding");
            byte[] c4 = c(bArr2, bArr);
            byte[] bArr3 = (byte[]) c4.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            cipher.init(1, new SecretKeySpec(this.f2605b, "AES"), new IvParameterSpec(bArr3));
            return T.b.e(c4, cipher.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // K1.c
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= 16) {
            Cipher cipher = (Cipher) i.f2612b.f2614a.k("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr3 = (byte[]) copyOfRange.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            cipher.init(2, new SecretKeySpec(this.f2605b, "AES"), new IvParameterSpec(bArr3));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
            byte[] doFinal = cipher.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && "The Android Project".equals(System.getProperty("java.vendor"))) {
                doFinal = new byte[0];
            }
            if (MessageDigest.isEqual(copyOfRange, c(bArr2, doFinal))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }

    public final byte[] c(byte[]... bArr) {
        byte[] U3;
        int length = bArr.length;
        b3 b3Var = this.f2604a;
        if (length == 0) {
            return b3Var.d(f2603e, 16);
        }
        byte[] d2 = b3Var.d(f2602d, 16);
        for (int i = 0; i < bArr.length - 1; i++) {
            byte[] bArr2 = bArr[i];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            d2 = T.b.U(E1.b.j(d2), b3Var.d(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length >= 16) {
            if (bArr3.length >= d2.length) {
                int length2 = bArr3.length - d2.length;
                U3 = Arrays.copyOf(bArr3, bArr3.length);
                for (int i3 = 0; i3 < d2.length; i3++) {
                    int i4 = length2 + i3;
                    U3[i4] = (byte) (U3[i4] ^ d2[i3]);
                }
            } else {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
        } else if (bArr3.length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr3, 16);
            copyOf[bArr3.length] = Byte.MIN_VALUE;
            U3 = T.b.U(copyOf, E1.b.j(d2));
        } else {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        return b3Var.d(U3, 16);
    }
}
