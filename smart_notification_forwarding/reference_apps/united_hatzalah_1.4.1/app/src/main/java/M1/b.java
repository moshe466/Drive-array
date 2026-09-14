package M1;

import F0.AbstractC0008a;
import R1.s;
import X1.o;
import android.os.Build;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final I2.b f1398c = new I2.b(1);

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f1399a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1400b;

    public b(byte[] bArr) {
        if (AbstractC0008a.c(2)) {
            o.a(bArr.length);
            this.f1399a = new SecretKeySpec(bArr, "AES");
            this.f1400b = true;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static AlgorithmParameterSpec a(byte[] bArr) {
        Integer valueOf;
        int length = bArr.length;
        int i = s.f2017a;
        if (!Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(Build.VERSION.SDK_INT);
        }
        if (valueOf != null && valueOf.intValue() <= 19) {
            return new IvParameterSpec(bArr, 0, length);
        }
        return new GCMParameterSpec(128, bArr, 0, length);
    }
}
