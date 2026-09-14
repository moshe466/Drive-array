package r;

import android.net.Uri;
import android.os.Bundle;

/* renamed from: r.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0626a {
    public static final int ACTIVITY_LAYOUT_STATE_BOTTOM_SHEET = 1;
    public static final int ACTIVITY_LAYOUT_STATE_BOTTOM_SHEET_MAXIMIZED = 2;
    public static final int ACTIVITY_LAYOUT_STATE_FULL_SCREEN = 5;
    public static final int ACTIVITY_LAYOUT_STATE_SIDE_SHEET = 3;
    public static final int ACTIVITY_LAYOUT_STATE_SIDE_SHEET_MAXIMIZED = 4;
    public static final int ACTIVITY_LAYOUT_STATE_UNKNOWN = 0;
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;
    public static final String ONLINE_EXTRAS_KEY = "online";
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    public abstract void extraCallback(String str, Bundle bundle);

    public Bundle extraCallbackWithResult(String str, Bundle bundle) {
        return null;
    }

    public abstract void onMessageChannelReady(Bundle bundle);

    public abstract void onNavigationEvent(int i, Bundle bundle);

    public abstract void onPostMessage(String str, Bundle bundle);

    public abstract void onRelationshipValidationResult(int i, Uri uri, boolean z3, Bundle bundle);

    public void onMinimized(Bundle bundle) {
    }

    public void onUnminimized(Bundle bundle) {
    }

    public void onWarmupCompleted(Bundle bundle) {
    }

    public void onActivityResized(int i, int i3, Bundle bundle) {
    }

    public void onActivityLayout(int i, int i3, int i4, int i5, int i6, Bundle bundle) {
    }
}
