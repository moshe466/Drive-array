package C;

import F0.C0110z2;
import F0.G1;
import android.hardware.fingerprint.FingerprintManager;
import androidx.lifecycle.A;
import java.lang.ref.WeakReference;
import q.C0601A;
import q.y;

/* loaded from: classes.dex */
public final class a extends FingerprintManager.AuthenticationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G1 f83a;

    public a(G1 g12) {
        this.f83a = g12;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationError(int i, CharSequence charSequence) {
        ((y) ((C0110z2) this.f83a.f218b).f731d).a(i, charSequence);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationFailed() {
        WeakReference weakReference = ((y) ((C0110z2) this.f83a.f218b).f731d).f6049a;
        if (weakReference.get() != null && ((C0601A) weakReference.get()).f5999l) {
            C0601A c0601a = (C0601A) weakReference.get();
            if (c0601a.f6005s == null) {
                c0601a.f6005s = new A();
            }
            C0601A.h(c0601a.f6005s, Boolean.TRUE);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        WeakReference weakReference = ((y) ((C0110z2) this.f83a.f218b).f731d).f6049a;
        if (weakReference.get() != null) {
            C0601A c0601a = (C0601A) weakReference.get();
            if (c0601a.f6004r == null) {
                c0601a.f6004r = new A();
            }
            C0601A.h(c0601a.f6004r, charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager.AuthenticationResult r4) {
        /*
            r3 = this;
            android.hardware.fingerprint.FingerprintManager$CryptoObject r4 = r4.getCryptoObject()
            r0 = 0
            if (r4 != 0) goto L8
            goto L38
        L8:
            javax.crypto.Cipher r1 = r4.getCipher()
            if (r1 == 0) goto L18
            F0.z2 r1 = new F0.z2
            javax.crypto.Cipher r4 = r4.getCipher()
            r1.<init>(r4)
            goto L39
        L18:
            java.security.Signature r1 = r4.getSignature()
            if (r1 == 0) goto L28
            F0.z2 r1 = new F0.z2
            java.security.Signature r4 = r4.getSignature()
            r1.<init>(r4)
            goto L39
        L28:
            javax.crypto.Mac r1 = r4.getMac()
            if (r1 == 0) goto L38
            F0.z2 r1 = new F0.z2
            javax.crypto.Mac r4 = r4.getMac()
            r1.<init>(r4)
            goto L39
        L38:
            r1 = r0
        L39:
            F0.G1 r4 = r3.f83a
            r4.getClass()
            if (r1 != 0) goto L41
            goto L64
        L41:
            java.lang.Object r2 = r1.f730c
            javax.crypto.Cipher r2 = (javax.crypto.Cipher) r2
            if (r2 == 0) goto L4d
            K1.m r0 = new K1.m
            r0.<init>(r2)
            goto L64
        L4d:
            java.lang.Object r2 = r1.f729b
            java.security.Signature r2 = (java.security.Signature) r2
            if (r2 == 0) goto L59
            K1.m r0 = new K1.m
            r0.<init>(r2)
            goto L64
        L59:
            java.lang.Object r1 = r1.f731d
            javax.crypto.Mac r1 = (javax.crypto.Mac) r1
            if (r1 == 0) goto L64
            K1.m r0 = new K1.m
            r0.<init>(r1)
        L64:
            q.u r1 = new q.u
            r2 = 2
            r1.<init>(r0, r2)
            java.lang.Object r4 = r4.f218b
            F0.z2 r4 = (F0.C0110z2) r4
            java.lang.Object r4 = r4.f731d
            q.y r4 = (q.y) r4
            r4.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C.a.onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager$AuthenticationResult):void");
    }
}
