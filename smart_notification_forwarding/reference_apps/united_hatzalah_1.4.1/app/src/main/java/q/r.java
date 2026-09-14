package q;

import android.hardware.biometrics.BiometricManager;

/* loaded from: classes.dex */
public abstract class r {
    public static int a(BiometricManager biometricManager, int i) {
        return biometricManager.canAuthenticate(i);
    }
}
