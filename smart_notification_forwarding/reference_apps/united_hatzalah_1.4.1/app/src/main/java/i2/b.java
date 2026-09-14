package I2;

import X1.i;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class b extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f931a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f931a) {
            case 0:
                return new Random();
            case 1:
                try {
                    return (Cipher) i.f2612b.f2614a.k("AES/GCM/NoPadding");
                } catch (GeneralSecurityException e4) {
                    throw new IllegalStateException(e4);
                }
            case 2:
                try {
                    return (Cipher) i.f2612b.f2614a.k("AES/GCM-SIV/NoPadding");
                } catch (GeneralSecurityException e5) {
                    throw new IllegalStateException(e5);
                }
            case 3:
                try {
                    return (Cipher) i.f2612b.f2614a.k("AES/CTR/NoPadding");
                } catch (GeneralSecurityException e6) {
                    throw new IllegalStateException(e6);
                }
            case 4:
                try {
                    return (Cipher) i.f2612b.f2614a.k("AES/ECB/NOPADDING");
                } catch (GeneralSecurityException e7) {
                    throw new IllegalStateException(e7);
                }
            case 5:
                try {
                    return (Cipher) i.f2612b.f2614a.k("AES/CTR/NOPADDING");
                } catch (GeneralSecurityException e8) {
                    throw new IllegalStateException(e8);
                }
            default:
                SecureRandom secureRandom = new SecureRandom();
                secureRandom.nextLong();
                return secureRandom;
        }
    }
}
