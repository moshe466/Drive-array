package t0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import u0.AbstractC0728f;
import u0.AbstractC0730h;
import u0.AbstractC0731i;
import u0.AbstractC0734l;
import u0.C0724b;
import u0.F;
import u0.H;
import u0.J;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f6390a = Uri.parse("*");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f6391b = Uri.parse("");

    public static u0.u a(WebView webView, String str, Set set) {
        if (F.f6519J.b()) {
            J d2 = d(webView);
            return new u0.u((ScriptHandlerBoundaryInterface) m3.b.d(ScriptHandlerBoundaryInterface.class, ((WebViewProviderBoundaryInterface) d2.f6552b).addDocumentStartJavaScript(str, (String[]) set.toArray(new String[0]))));
        }
        throw F.a();
    }

    public static PackageInfo b(Context context) {
        PackageInfo packageInfo;
        if (Build.VERSION.SDK_INT >= 26) {
            packageInfo = AbstractC0730h.a();
        } else {
            try {
                packageInfo = c();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                packageInfo = null;
            }
        }
        if (packageInfo != null) {
            return packageInfo;
        }
        try {
            String str = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", null).invoke(null, null);
            if (str != null) {
                return context.getPackageManager().getPackageInfo(str, 0);
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return null;
    }

    public static PackageInfo c() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static J d(WebView webView) {
        WebViewProviderBoundaryInterface createWebView = H.f6549a.createWebView(webView);
        J j2 = new J(5);
        j2.f6552b = createWebView;
        return j2;
    }

    public static void e(WebView webView, n nVar, Uri uri) {
        int i = nVar.f6381d;
        if (f6390a.equals(uri)) {
            uri = f6391b;
        }
        C0724b c0724b = F.f6546x;
        c0724b.getClass();
        if (i == 0) {
            AbstractC0728f.j(webView, AbstractC0728f.b(nVar), uri);
        } else {
            if (c0724b.b() && (i == 0 || (i == 1 && F.f6543u.b()))) {
                ((WebViewProviderBoundaryInterface) d(webView).f6552b).postMessageToMainFrame(new m3.a(new u0.z(nVar)), uri);
                return;
            }
            throw F.a();
        }
    }

    public static void f(HashSet hashSet, ValueCallback valueCallback) {
        C0724b c0724b = F.f6530f;
        C0724b c0724b2 = F.f6529e;
        if (c0724b.b()) {
            H.f6549a.getStatics().setSafeBrowsingAllowlist(hashSet, valueCallback);
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        if (c0724b2.a()) {
            AbstractC0731i.d(arrayList, valueCallback);
        } else {
            if (c0724b2.b()) {
                H.f6549a.getStatics().setSafeBrowsingWhitelist(arrayList, valueCallback);
                return;
            }
            throw F.a();
        }
    }

    public static void g(InAppWebView inAppWebView, InAppWebViewRenderProcessClient inAppWebViewRenderProcessClient) {
        m3.a aVar;
        C0724b c0724b = F.f6512C;
        if (c0724b.a()) {
            AbstractC0734l.f(inAppWebView, inAppWebViewRenderProcessClient);
            return;
        }
        if (c0724b.b()) {
            J d2 = d(inAppWebView);
            if (inAppWebViewRenderProcessClient != null) {
                aVar = new m3.a(new J(inAppWebViewRenderProcessClient, 0));
            } else {
                aVar = null;
            }
            ((WebViewProviderBoundaryInterface) d2.f6552b).setWebViewRendererClient(aVar);
            return;
        }
        throw F.a();
    }
}
