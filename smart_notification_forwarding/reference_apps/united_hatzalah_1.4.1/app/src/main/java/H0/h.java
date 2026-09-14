package H0;

import F0.AbstractC0008a;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.WindowManager;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import x.AbstractC0773d;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f855b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f856c;

    /* renamed from: a, reason: collision with root package name */
    public static final h f854a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashSet f857d = new LinkedHashSet();

    /* renamed from: e, reason: collision with root package name */
    public static final f f858e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static final g f859f = new g(0);

    /* JADX WARN: Code restructure failed: missing block: B:113:0x029b, code lost:
    
        if (r6 != 0) goto L85;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x004d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:79:0x0120. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:83:0x01cb. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [F0.Q] */
    /* JADX WARN: Type inference failed for: r14v3, types: [F0.Q] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r26v9, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v50 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(H0.j r27) {
        /*
            Method dump skipped, instructions count: 1173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H0.h.a(H0.j):void");
    }

    public static void b(Activity activity) {
        Executor mainExecutor;
        int addScreenRecordingCallback;
        Executor mainExecutor2;
        if (f856c) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            Context applicationContext = activity.getApplicationContext();
            kotlin.jvm.internal.j.b(applicationContext);
            if (AbstractC0773d.a(applicationContext, "android.permission.DETECT_SCREEN_CAPTURE") == 0) {
                mainExecutor2 = applicationContext.getMainExecutor();
                activity.registerScreenCaptureCallback(mainExecutor2, f858e);
            } else {
                c("screenshot", "android.permission.DETECT_SCREEN_CAPTURE");
            }
        }
        if (i >= 35) {
            Context applicationContext2 = activity.getApplicationContext();
            kotlin.jvm.internal.j.b(applicationContext2);
            if (AbstractC0773d.a(applicationContext2, "android.permission.DETECT_SCREEN_RECORDING") == 0) {
                WindowManager windowManager = activity.getWindowManager();
                mainExecutor = applicationContext2.getMainExecutor();
                g gVar = f859f;
                addScreenRecordingCallback = windowManager.addScreenRecordingCallback(mainExecutor, gVar);
                gVar.accept(Integer.valueOf(addScreenRecordingCallback));
            } else {
                c("screen record", "android.permission.DETECT_SCREEN_RECORDING");
            }
        }
        f856c = true;
    }

    public static void c(String str, String str2) {
        Log.e("TalsecScreenProtector", AbstractC0008a.p("Failed to register ", str, " callback. Check if ", str2, " permission is granted in AndroidManifest.xml"));
    }

    public static void d(Activity currentActivity) {
        WindowManager windowManager;
        kotlin.jvm.internal.j.e(currentActivity, "currentActivity");
        if (!f856c) {
            return;
        }
        Context applicationContext = currentActivity.getApplicationContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            kotlin.jvm.internal.j.b(applicationContext);
            if (AbstractC0773d.a(applicationContext, "android.permission.DETECT_SCREEN_CAPTURE") == 0) {
                currentActivity.unregisterScreenCaptureCallback(f858e);
            }
        }
        if (i >= 35) {
            kotlin.jvm.internal.j.b(applicationContext);
            if (AbstractC0773d.a(applicationContext, "android.permission.DETECT_SCREEN_RECORDING") == 0 && (windowManager = currentActivity.getWindowManager()) != null) {
                windowManager.removeScreenRecordingCallback(f859f);
            }
        }
        f856c = false;
    }
}
