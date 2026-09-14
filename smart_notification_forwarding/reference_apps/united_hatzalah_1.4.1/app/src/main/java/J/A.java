package J;

import android.app.ActivityOptions;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.BackEvent;

/* loaded from: classes.dex */
public abstract class A {
    public static AccessibilityNodeInfo.AccessibilityAction a() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getAxisVelocity(i);
    }

    public static void c(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static int e(ViewConfiguration viewConfiguration, int i, int i3, int i4) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i, i3, i4);
    }

    public static int f(ViewConfiguration viewConfiguration, int i, int i3, int i4) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i, i3, i4);
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static float h(BackEvent backEvent) {
        return backEvent.getProgress();
    }

    public static void i(ActivityOptions activityOptions) {
        activityOptions.setShareIdentityEnabled(false);
    }

    public static int j(BackEvent backEvent) {
        return backEvent.getSwipeEdge();
    }

    public static float k(BackEvent backEvent) {
        return backEvent.getTouchX();
    }

    public static float l(BackEvent backEvent) {
        return backEvent.getTouchY();
    }
}
