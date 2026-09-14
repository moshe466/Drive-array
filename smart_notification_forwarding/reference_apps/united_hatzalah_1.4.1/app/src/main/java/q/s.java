package q;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.util.Log;
import com.uh.sf.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final V.n f6037a;

    /* renamed from: b, reason: collision with root package name */
    public final BiometricManager f6038b;

    /* renamed from: c, reason: collision with root package name */
    public final C.b f6039c;

    public s(V.n nVar) {
        BiometricManager biometricManager;
        Context context = nVar.f2408a;
        this.f6037a = nVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            biometricManager = q.b(context);
        } else {
            biometricManager = null;
        }
        this.f6038b = biometricManager;
        this.f6039c = i <= 29 ? new C.b(context) : null;
    }

    public final int a(int i) {
        boolean b4;
        int a2;
        boolean b5;
        BiometricPrompt.CryptoObject K3;
        boolean b6;
        int i3 = Build.VERSION.SDK_INT;
        boolean z3 = true;
        if (i3 >= 30) {
            BiometricManager biometricManager = this.f6038b;
            if (biometricManager == null) {
                Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
                return 1;
            }
            return r.a(biometricManager, i);
        }
        if (!m3.b.C(i)) {
            return -2;
        }
        if (i != 0) {
            V.n nVar = this.f6037a;
            Context context = nVar.f2408a;
            if (J.a(context) != null) {
                int i4 = 0;
                if (m3.b.A(i)) {
                    KeyguardManager a4 = J.a(context);
                    if (a4 == null) {
                        b6 = false;
                    } else {
                        b6 = J.b(a4);
                    }
                    if (b6) {
                        return 0;
                    }
                    return 11;
                }
                if (i3 == 29) {
                    if ((i & 255) == 255) {
                        BiometricManager biometricManager2 = this.f6038b;
                        if (biometricManager2 == null) {
                            Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
                            return 1;
                        }
                        return q.a(biometricManager2);
                    }
                    Method c4 = q.c();
                    if (c4 != null && (K3 = p3.h.K(p3.h.m())) != null) {
                        try {
                            Object invoke = c4.invoke(this.f6038b, K3);
                            if (invoke instanceof Integer) {
                                return ((Integer) invoke).intValue();
                            }
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                        }
                    }
                    BiometricManager biometricManager3 = this.f6038b;
                    if (biometricManager3 == null) {
                        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
                        a2 = 1;
                    } else {
                        a2 = q.a(biometricManager3);
                    }
                    String str = Build.MODEL;
                    if (Build.VERSION.SDK_INT < 30 && str != null) {
                        for (String str2 : context.getResources().getStringArray(R.array.assume_strong_biometrics_models)) {
                            if (str.equals(str2)) {
                                break;
                            }
                        }
                    }
                    z3 = false;
                    if (!z3 && a2 == 0) {
                        KeyguardManager a5 = J.a(nVar.f2408a);
                        if (a5 == null) {
                            b5 = false;
                        } else {
                            b5 = J.b(a5);
                        }
                        if (!b5) {
                            i4 = b();
                        } else if (b() != 0) {
                            i4 = -1;
                        }
                        return i4;
                    }
                    return a2;
                }
                if (i3 == 28) {
                    if (context == null || context.getPackageManager() == null || !K.a(context.getPackageManager())) {
                        z3 = false;
                    }
                    if (z3) {
                        KeyguardManager a6 = J.a(nVar.f2408a);
                        if (a6 == null) {
                            b4 = false;
                        } else {
                            b4 = J.b(a6);
                        }
                        if (!b4) {
                            return b();
                        }
                        if (b() == 0) {
                            return 0;
                        }
                        return -1;
                    }
                    return 12;
                }
                return b();
            }
            return 12;
        }
        return 12;
    }

    public final int b() {
        C.b bVar = this.f6039c;
        if (bVar == null) {
            Log.e("BiometricManager", "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        }
        Context context = bVar.f84a;
        FingerprintManager b4 = C.b.b(context);
        if (b4 != null && b4.isHardwareDetected()) {
            FingerprintManager b5 = C.b.b(context);
            if (b5 != null && b5.hasEnrolledFingerprints()) {
                return 0;
            }
            return 11;
        }
        return 12;
    }
}
