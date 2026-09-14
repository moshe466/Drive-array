package q;

import android.hardware.biometrics.BiometricPrompt;

/* loaded from: classes.dex */
public abstract class n {
    public static void a(BiometricPrompt.Builder builder, int i) {
        builder.setAllowedAuthenticators(i);
    }
}
