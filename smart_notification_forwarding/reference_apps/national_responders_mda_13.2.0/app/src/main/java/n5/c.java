package n5;

import android.os.Build;
import android.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f12226a;

    private c() {
    }

    private String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    public static c d() {
        if (f12226a == null) {
            f12226a = new c();
        }
        return f12226a;
    }

    private byte[] e() {
        byte[] bArr = new byte[32];
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                SecureRandom.getInstanceStrong().nextBytes(bArr);
            } catch (NoSuchAlgorithmException e10) {
                e10.printStackTrace();
            }
        } else {
            new SecureRandom().nextBytes(bArr);
        }
        return bArr;
    }

    public String b(byte[] bArr) {
        return a(bArr);
    }

    public byte[] c() {
        return e();
    }
}
