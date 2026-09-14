package F;

import android.app.Activity;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import e.C0359a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public abstract class b {
    public static OnBackInvokedDispatcher a(Activity activity) {
        j.e(activity, "activity");
        OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        j.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
        return onBackInvokedDispatcher;
    }

    public static Object b(Bundle bundle, String str) {
        return bundle.getParcelable(str, C0359a.class);
    }

    public static String c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    public static void e(Object dispatcher, Object callback) {
        j.e(dispatcher, "dispatcher");
        j.e(callback, "callback");
        ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(0, (OnBackInvokedCallback) callback);
    }

    public static void f(Object dispatcher, Object callback) {
        j.e(dispatcher, "dispatcher");
        j.e(callback, "callback");
        ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
    }
}
