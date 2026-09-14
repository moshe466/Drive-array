package q;

import android.hardware.biometrics.BiometricPrompt;

/* renamed from: q.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0606c {
    public static int a(BiometricPrompt.AuthenticationResult authenticationResult) {
        return authenticationResult.getAuthenticationType();
    }
}
