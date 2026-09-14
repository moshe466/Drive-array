package X1;

import F0.AbstractC0008a;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: d, reason: collision with root package name */
    public static final I2.b f2589d = new I2.b(3);

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f2590a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2591b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2592c;

    public a(byte[] bArr, int i) {
        if (AbstractC0008a.c(2)) {
            o.a(bArr.length);
            this.f2590a = new SecretKeySpec(bArr, "AES");
            int blockSize = ((Cipher) f2589d.get()).getBlockSize();
            this.f2592c = blockSize;
            if (i >= 12 && i <= blockSize) {
                this.f2591b = i;
                return;
            }
            throw new GeneralSecurityException("invalid IV size");
        }
        throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final void a(byte[] bArr, int i, int i3, byte[] bArr2, int i4, byte[] bArr3, boolean z3) {
        Cipher cipher = (Cipher) f2589d.get();
        byte[] bArr4 = new byte[this.f2592c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f2591b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        SecretKeySpec secretKeySpec = this.f2590a;
        if (z3) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i3, bArr2, i4) == i3) {
        } else {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
