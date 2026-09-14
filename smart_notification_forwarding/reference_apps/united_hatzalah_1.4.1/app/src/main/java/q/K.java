package q;

import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public abstract class K {
    public static boolean a(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.hardware.fingerprint");
    }
}
