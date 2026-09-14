package q;

import android.app.KeyguardManager;
import android.content.Intent;

/* renamed from: q.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0614k {
    public static Intent a(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
        return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
    }
}
