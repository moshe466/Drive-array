package K;

import android.app.ActivityOptions;
import android.app.Notification;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.BackEvent;

/* loaded from: classes.dex */
public abstract class e {
    public static int a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getChecked();
    }

    public static long b(BackEvent backEvent) {
        return backEvent.getFrameTimeMillis();
    }

    public static int c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExpandedState();
    }

    public static CharSequence d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getSupplementalDescription();
    }

    public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isFieldRequired();
    }

    public static void f(ActivityOptions activityOptions, boolean z3) {
        activityOptions.setAllowPassThroughOnTouchOutside(z3);
    }

    public static void g(Notification.Builder builder) {
        builder.setShortCriticalText(null);
    }
}
