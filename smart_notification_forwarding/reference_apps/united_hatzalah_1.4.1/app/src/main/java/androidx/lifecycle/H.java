package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import androidx.lifecycle.J;

/* loaded from: classes.dex */
public abstract class H {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, EnumC0303m event) {
        kotlin.jvm.internal.j.e(event, "event");
        if (activity instanceof InterfaceC0309t) {
            AbstractC0305o lifecycle = ((InterfaceC0309t) activity).getLifecycle();
            if (lifecycle instanceof C0311v) {
                ((C0311v) lifecycle).e(event);
            }
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            J.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new J.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new J(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
