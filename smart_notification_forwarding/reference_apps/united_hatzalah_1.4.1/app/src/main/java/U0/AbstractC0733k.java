package u0;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* renamed from: u0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0733k {
    public static TracingController a() {
        TracingController tracingController;
        tracingController = TracingController.getInstance();
        return tracingController;
    }

    public static ClassLoader b() {
        ClassLoader webViewClassLoader;
        webViewClassLoader = WebView.getWebViewClassLoader();
        return webViewClassLoader;
    }

    public static Looper c(WebView webView) {
        Looper webViewLooper;
        webViewLooper = webView.getWebViewLooper();
        return webViewLooper;
    }

    public static boolean d(TracingController tracingController) {
        boolean isTracing;
        isTracing = tracingController.isTracing();
        return isTracing;
    }

    public static void e(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    public static void f(TracingController tracingController, t0.k kVar) {
        TracingConfig.Builder addCategories;
        TracingConfig.Builder addCategories2;
        TracingConfig.Builder tracingMode;
        TracingConfig build;
        addCategories = K.c.k().addCategories(kVar.f6374a);
        addCategories2 = addCategories.addCategories(kVar.f6375b);
        tracingMode = addCategories2.setTracingMode(kVar.f6376c);
        build = tracingMode.build();
        tracingController.start(build);
    }

    public static boolean g(TracingController tracingController, OutputStream outputStream, Executor executor) {
        boolean stop;
        stop = tracingController.stop(outputStream, executor);
        return stop;
    }
}
