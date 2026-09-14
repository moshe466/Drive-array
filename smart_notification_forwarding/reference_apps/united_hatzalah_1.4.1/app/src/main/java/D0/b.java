package D0;

import J.p0;
import android.content.Context;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f108a = new Object();

    public final p0 a(Context context) {
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        j.e(context, "context");
        currentWindowMetrics = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
        windowInsets = currentWindowMetrics.getWindowInsets();
        j.d(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        return p0.c(windowInsets, null);
    }
}
