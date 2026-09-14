package g2;

import F0.C0018c1;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class b extends C0018c1 {
    @Override // F0.C0018c1
    public final String c() {
        return ((Context) this.f477b).getPackageName() + ".FlutterSecureStoragePluginKeyOAEP";
    }

    @Override // F0.C0018c1
    public final AlgorithmParameterSpec e() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    }

    @Override // F0.C0018c1
    public final Cipher f() {
        return Cipher.getInstance("RSA/ECB/OAEPPadding", "AndroidKeyStoreBCWorkaround");
    }

    @Override // F0.C0018c1
    public final KeyGenParameterSpec h(Calendar calendar, Calendar calendar2) {
        String str = (String) this.f476a;
        return new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal(e0.a.d("CN=", str))).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("OAEPPadding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }
}
