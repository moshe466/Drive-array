package X1;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final I2.b f2622a = new I2.b(6);

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) f2622a.get()).nextBytes(bArr);
        return bArr;
    }
}
