package u0;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* renamed from: u0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0728f {
    public static void a(WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    public static WebMessage b(t0.n nVar) {
        WebMessagePort[] webMessagePortArr;
        nVar.a(0);
        String str = nVar.f6379b;
        t0.p[] pVarArr = nVar.f6378a;
        if (pVarArr == null) {
            webMessagePortArr = null;
        } else {
            int length = pVarArr.length;
            WebMessagePort[] webMessagePortArr2 = new WebMessagePort[length];
            for (int i = 0; i < length; i++) {
                webMessagePortArr2[i] = ((C0721B) pVarArr[i]).c();
            }
            webMessagePortArr = webMessagePortArr2;
        }
        return new WebMessage(str, webMessagePortArr);
    }

    public static WebMessagePort[] c(WebView webView) {
        return webView.createWebMessageChannel();
    }

    public static t0.n d(WebMessage webMessage) {
        t0.p[] pVarArr;
        String data = webMessage.getData();
        WebMessagePort[] ports = webMessage.getPorts();
        if (ports == null) {
            pVarArr = null;
        } else {
            t0.p[] pVarArr2 = new t0.p[ports.length];
            for (int i = 0; i < ports.length; i++) {
                pVarArr2[i] = new C0721B(ports[i]);
            }
            pVarArr = pVarArr2;
        }
        return new t0.n(data, pVarArr);
    }

    public static CharSequence e(WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static int f(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    public static boolean g(WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    public static void h(WebMessagePort webMessagePort, WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    public static void i(WebView webView, long j2, t0.w wVar) {
        webView.postVisualStateCallback(j2, new WebView.VisualStateCallback());
    }

    public static void j(WebView webView, WebMessage webMessage, Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    public static void k(WebSettings webSettings, boolean z3) {
        webSettings.setOffscreenPreRaster(z3);
    }

    public static void l(WebMessagePort webMessagePort, t0.o oVar) {
        webMessagePort.setWebMessageCallback(new C0726d(oVar, 0));
    }

    public static void m(WebMessagePort webMessagePort, t0.o oVar, Handler handler) {
        webMessagePort.setWebMessageCallback(new C0726d(oVar, 1), handler);
    }
}
