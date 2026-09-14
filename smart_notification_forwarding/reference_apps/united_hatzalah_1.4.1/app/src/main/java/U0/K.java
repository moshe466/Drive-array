package u0;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import t0.AbstractC0696A;

/* loaded from: classes.dex */
public final class K extends WebViewRenderProcessClient {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0696A f6553a;

    public K(AbstractC0696A abstractC0696A) {
        this.f6553a = abstractC0696A;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, u0.L] */
    public final void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap weakHashMap = L.f6554c;
        L l3 = (L) weakHashMap.get(webViewRenderProcess);
        L l4 = l3;
        if (l3 == null) {
            ?? obj = new Object();
            obj.f6556b = new WeakReference(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, obj);
            l4 = obj;
        }
        this.f6553a.onRenderProcessResponsive(webView, l4);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, u0.L] */
    public final void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap weakHashMap = L.f6554c;
        L l3 = (L) weakHashMap.get(webViewRenderProcess);
        L l4 = l3;
        if (l3 == null) {
            ?? obj = new Object();
            obj.f6556b = new WeakReference(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, obj);
            l4 = obj;
        }
        this.f6553a.onRenderProcessUnresponsive(webView, l4);
    }
}
