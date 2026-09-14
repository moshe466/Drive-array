package u0;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.util.concurrent.Executor;
import t0.AbstractC0696A;

/* renamed from: u0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0734l {
    @Deprecated
    public static int a(WebSettings webSettings) {
        int forceDark;
        forceDark = webSettings.getForceDark();
        return forceDark;
    }

    public static WebViewRenderProcess b(WebView webView) {
        WebViewRenderProcess webViewRenderProcess;
        webViewRenderProcess = webView.getWebViewRenderProcess();
        return webViewRenderProcess;
    }

    public static WebViewRenderProcessClient c(WebView webView) {
        WebViewRenderProcessClient webViewRenderProcessClient;
        webViewRenderProcessClient = webView.getWebViewRenderProcessClient();
        return webViewRenderProcessClient;
    }

    @Deprecated
    public static void d(WebSettings webSettings, int i) {
        webSettings.setForceDark(i);
    }

    public static void e(WebView webView, Executor executor, AbstractC0696A abstractC0696A) {
        K k4;
        if (abstractC0696A != null) {
            k4 = new K(abstractC0696A);
        } else {
            k4 = null;
        }
        webView.setWebViewRenderProcessClient(executor, k4);
    }

    public static void f(WebView webView, AbstractC0696A abstractC0696A) {
        K k4;
        if (abstractC0696A != null) {
            k4 = new K(abstractC0696A);
        } else {
            k4 = null;
        }
        webView.setWebViewRenderProcessClient(k4);
    }

    public static boolean g(WebViewRenderProcess webViewRenderProcess) {
        boolean terminate;
        terminate = webViewRenderProcess.terminate();
        return terminate;
    }
}
