package Q1;

import X1.n;
import X1.o;
import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f1725b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public KeyStore f1726a;

    public c() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.f1726a = keyStore;
        } catch (IOException | GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static boolean a(String str) {
        c cVar = new c();
        synchronized (f1725b) {
            try {
                if (!cVar.d(str)) {
                    b(str);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(String str) {
        String b4 = o.b(str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(b4, 3).setKeySize(UserVerificationMethods.USER_VERIFY_HANDPRINT).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    public final synchronized b c(String str) {
        b bVar;
        bVar = new b(o.b(str), this.f1726a);
        byte[] a2 = n.a(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(a2, bVar.b(bVar.a(a2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return bVar;
    }

    public final synchronized boolean d(String str) {
        String b4;
        b4 = o.b(str);
        try {
            try {
            } catch (NullPointerException unused) {
                try {
                    Thread.sleep((int) (Math.random() * 40.0d));
                } catch (InterruptedException unused2) {
                }
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f1726a = keyStore;
                keyStore.load(null);
                return this.f1726a.containsAlias(b4);
            }
        } catch (IOException e4) {
            throw new GeneralSecurityException(e4);
        }
        return this.f1726a.containsAlias(b4);
    }
}
