package q;

import android.hardware.biometrics.BiometricPrompt;

/* loaded from: classes.dex */
public abstract class m {
    public static void a(BiometricPrompt.Builder builder, boolean z3) {
        builder.setConfirmationRequired(z3);
    }

    public static void b(BiometricPrompt.Builder builder, boolean z3) {
        builder.setDeviceCredentialAllowed(z3);
    }
}
