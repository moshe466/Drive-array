package C;

import F.c;
import F0.C0110z2;
import F0.G1;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f84a;

    public b(Context context) {
        this.f84a = context;
    }

    public static FingerprintManager b(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        return null;
    }

    public final void a(C0110z2 c0110z2, c cVar, G1 g12) {
        CancellationSignal cancellationSignal;
        CancellationSignal cancellationSignal2;
        FingerprintManager.CryptoObject cryptoObject = null;
        if (cVar != null) {
            synchronized (cVar) {
                try {
                    if (((CancellationSignal) cVar.f157d) == null) {
                        CancellationSignal cancellationSignal3 = new CancellationSignal();
                        cVar.f157d = cancellationSignal3;
                        if (cVar.f154a) {
                            cancellationSignal3.cancel();
                        }
                    }
                    cancellationSignal2 = (CancellationSignal) cVar.f157d;
                } finally {
                }
            }
            cancellationSignal = cancellationSignal2;
        } else {
            cancellationSignal = null;
        }
        FingerprintManager b4 = b(this.f84a);
        if (b4 != null) {
            if (c0110z2 != null) {
                Mac mac = (Mac) c0110z2.f731d;
                Signature signature = (Signature) c0110z2.f729b;
                Cipher cipher = (Cipher) c0110z2.f730c;
                if (cipher != null) {
                    cryptoObject = new FingerprintManager.CryptoObject(cipher);
                } else if (signature != null) {
                    cryptoObject = new FingerprintManager.CryptoObject(signature);
                } else if (mac != null) {
                    cryptoObject = new FingerprintManager.CryptoObject(mac);
                }
            }
            b4.authenticate(cryptoObject, cancellationSignal, 0, new a(g12), null);
        }
    }
}
