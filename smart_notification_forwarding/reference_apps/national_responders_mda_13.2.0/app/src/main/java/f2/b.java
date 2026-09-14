package f2;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

@Deprecated
/* loaded from: classes.dex */
public class b {
    public static String a(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock));
        if (true == TextUtils.isEmpty(str)) {
            str = "";
        }
        return String.valueOf(valueOf).concat(String.valueOf(str));
    }
}
