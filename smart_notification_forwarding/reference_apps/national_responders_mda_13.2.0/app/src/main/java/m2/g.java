package m2;

import android.os.Build;

/* loaded from: classes.dex */
final class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 33 || Build.VERSION.CODENAME.charAt(0) == 'T';
    }
}
