package q;

import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.Build;
import android.security.identity.IdentityCredential;
import java.lang.ref.WeakReference;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0604a extends BiometricPrompt$AuthenticationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0607d f6018a;

    public C0604a(AbstractC0607d abstractC0607d) {
        this.f6018a = abstractC0607d;
    }

    public void onAuthenticationError(int i, CharSequence charSequence) {
        this.f6018a.a(i, charSequence);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    public void onAuthenticationFailed() {
        WeakReference weakReference = ((y) this.f6018a).f6049a;
        if (weakReference.get() != null && ((C0601A) weakReference.get()).f5999l) {
            C0601A c0601a = (C0601A) weakReference.get();
            if (c0601a.f6005s == null) {
                c0601a.f6005s = new androidx.lifecycle.A();
            }
            C0601A.h(c0601a.f6005s, Boolean.TRUE);
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [K1.m, java.lang.Object] */
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
        BiometricPrompt.CryptoObject cryptoObject;
        IdentityCredential b4;
        K1.m mVar = null;
        mVar = null;
        mVar = null;
        mVar = null;
        if (authenticationResult != null && (cryptoObject = authenticationResult.getCryptoObject()) != null) {
            Cipher d2 = E.d(cryptoObject);
            if (d2 != null) {
                mVar = new K1.m(d2);
            } else {
                Signature f4 = E.f(cryptoObject);
                if (f4 != null) {
                    mVar = new K1.m(f4);
                } else {
                    Mac e4 = E.e(cryptoObject);
                    if (e4 != null) {
                        mVar = new K1.m(e4);
                    } else if (Build.VERSION.SDK_INT >= 30 && (b4 = F.b(cryptoObject)) != null) {
                        ?? obj = new Object();
                        obj.f1102a = null;
                        obj.f1103b = null;
                        obj.f1104c = null;
                        obj.f1105d = b4;
                        mVar = obj;
                    }
                }
            }
        }
        int i = Build.VERSION.SDK_INT;
        int i3 = -1;
        if (i >= 30) {
            if (authenticationResult != null) {
                i3 = AbstractC0606c.a(authenticationResult);
            }
        } else if (i != 29) {
            i3 = 2;
        }
        this.f6018a.b(new u(mVar, i3));
    }

    public void onAuthenticationHelp(int i, CharSequence charSequence) {
    }
}
