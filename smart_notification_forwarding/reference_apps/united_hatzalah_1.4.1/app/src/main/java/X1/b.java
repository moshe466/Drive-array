package X1;

import F0.AbstractC0008a;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class b implements K1.a {

    /* renamed from: e, reason: collision with root package name */
    public static final I2.b f2593e = new I2.b(4);

    /* renamed from: f, reason: collision with root package name */
    public static final I2.b f2594f = new I2.b(5);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2595a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2596b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f2597c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2598d;

    public b(byte[] bArr, int i) {
        if (AbstractC0008a.b(1)) {
            if (i != 12 && i != 16) {
                throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
            }
            this.f2598d = i;
            o.a(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f2597c = secretKeySpec;
            Cipher cipher = (Cipher) f2593e.get();
            cipher.init(1, secretKeySpec);
            byte[] c4 = c(cipher.doFinal(new byte[16]));
            this.f2595a = c4;
            this.f2596b = c(c4);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i3 = i + 1;
            bArr2[i] = (byte) (((bArr[i] << 1) ^ ((bArr[i3] & ForkServer.ERROR) >>> 7)) & 255);
            i = i3;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // K1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        int length = bArr.length;
        int i = this.f2598d;
        if (length <= 2147483631 - i) {
            byte[] bArr4 = new byte[bArr.length + i + 16];
            byte[] a2 = n.a(i);
            System.arraycopy(a2, 0, bArr4, 0, i);
            Cipher cipher = (Cipher) f2593e.get();
            SecretKeySpec secretKeySpec = this.f2597c;
            cipher.init(1, secretKeySpec);
            byte[] d2 = d(cipher, 0, a2, 0, a2.length);
            if (bArr2 == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr2;
            }
            byte[] d4 = d(cipher, 1, bArr3, 0, bArr3.length);
            Cipher cipher2 = (Cipher) f2594f.get();
            cipher2.init(1, secretKeySpec, new IvParameterSpec(d2));
            cipher2.doFinal(bArr, 0, bArr.length, bArr4, this.f2598d);
            byte[] d5 = d(cipher, 2, bArr4, this.f2598d, bArr.length);
            int length2 = bArr.length + i;
            for (int i3 = 0; i3 < 16; i3++) {
                bArr4[length2 + i3] = (byte) ((d4[i3] ^ d2[i3]) ^ d5[i3]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // K1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        int length = bArr.length;
        int i = this.f2598d;
        int i3 = (length - i) - 16;
        if (i3 >= 0) {
            Cipher cipher = (Cipher) f2593e.get();
            SecretKeySpec secretKeySpec = this.f2597c;
            cipher.init(1, secretKeySpec);
            byte[] d2 = d(cipher, 0, bArr, 0, this.f2598d);
            if (bArr2 == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr2;
            }
            byte[] d4 = d(cipher, 1, bArr3, 0, bArr3.length);
            byte[] d5 = d(cipher, 2, bArr, this.f2598d, i3);
            int length2 = bArr.length - 16;
            byte b4 = 0;
            for (int i4 = 0; i4 < 16; i4++) {
                b4 = (byte) (b4 | (((bArr[length2 + i4] ^ d4[i4]) ^ d2[i4]) ^ d5[i4]));
            }
            if (b4 == 0) {
                Cipher cipher2 = (Cipher) f2594f.get();
                cipher2.init(1, secretKeySpec, new IvParameterSpec(d2));
                return cipher2.doFinal(bArr, i, i3);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] d(Cipher cipher, int i, byte[] bArr, int i3, int i4) {
        byte[] copyOf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        byte[] bArr3 = this.f2595a;
        if (i4 == 0) {
            return cipher.doFinal(e(bArr2, bArr3));
        }
        byte[] doFinal = cipher.doFinal(bArr2);
        int i5 = 0;
        while (i4 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                doFinal[i6] = (byte) (doFinal[i6] ^ bArr[(i3 + i5) + i6]);
            }
            doFinal = cipher.doFinal(doFinal);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i3, i3 + i4);
        if (copyOfRange.length == 16) {
            copyOf = e(copyOfRange, bArr3);
        } else {
            copyOf = Arrays.copyOf(this.f2596b, 16);
            for (int i7 = 0; i7 < copyOfRange.length; i7++) {
                copyOf[i7] = (byte) (copyOf[i7] ^ copyOfRange[i7]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
        }
        return cipher.doFinal(e(doFinal, copyOf));
    }
}
