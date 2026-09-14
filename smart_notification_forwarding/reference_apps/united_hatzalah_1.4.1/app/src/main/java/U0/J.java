package u0;

import android.content.Context;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.WebView;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.util.WeakHashMap;
import java.util.zip.GZIPInputStream;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import t0.AbstractC0696A;

/* loaded from: classes.dex */
public final class J implements WebViewRendererClientBoundaryInterface, WebMessageCallbackBoundaryInterface, WebMessageListenerBoundaryInterface, I {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f6550c = {"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6551a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6552b;

    public /* synthetic */ J(int i) {
        this.f6551a = i;
    }

    public static String b(File file) {
        String canonicalPath = file.getCanonicalPath();
        if (!canonicalPath.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return canonicalPath.concat(RemoteSettings.FORWARD_SLASH_STRING);
        }
        return canonicalPath;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005d, code lost:
    
        if (r5.equals("mhtml") == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.J.c(java.lang.String):java.lang.String");
    }

    @Override // u0.I
    public String[] a() {
        return ((WebViewProviderFactoryBoundaryInterface) this.f6552b).getSupportedFeatures();
    }

    @Override // u0.I
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) m3.b.d(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f6552b).createWebView(webView));
    }

    public InputStream d(String str) {
        Context context = (Context) this.f6552b;
        if (str.length() > 1 && str.charAt(0) == '/') {
            str = str.substring(1);
        }
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            int lastIndexOf = str3.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = str3.substring(0, lastIndexOf);
            }
            int identifier = context.getResources().getIdentifier(str3, str2, context.getPackageName());
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(identifier, typedValue, true);
            int i = typedValue.type;
            if (i == 3) {
                InputStream openRawResource = context.getResources().openRawResource(identifier);
                if (str.endsWith(".svgz")) {
                    return new GZIPInputStream(openRawResource);
                }
                return openRawResource;
            }
            throw new IOException(String.format("Expected %s resource to be of TYPE_STRING but was %d", str, Integer.valueOf(i)));
        }
        throw new IllegalArgumentException("Incorrect resource path: ".concat(str));
    }

    @Override // u0.I
    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) m3.b.d(ProxyControllerBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f6552b).getProxyController());
    }

    @Override // u0.I
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) m3.b.d(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f6552b).getStatics());
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        switch (this.f6551a) {
            case 0:
                return f6550c;
            case 1:
            default:
                return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
            case 2:
                return new String[]{"WEB_MESSAGE_CALLBACK_ON_MESSAGE"};
        }
    }

    @Override // u0.I
    public TracingControllerBoundaryInterface getTracingController() {
        return (TracingControllerBoundaryInterface) m3.b.d(TracingControllerBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f6552b).getTracingController());
    }

    @Override // u0.I
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) m3.b.d(WebkitToCompatConverterBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f6552b).getWebkitToCompatConverter());
    }

    @Override // org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface
    public void onMessage(InvocationHandler invocationHandler, InvocationHandler invocationHandler2) {
        t0.n a2 = z.a((WebMessageBoundaryInterface) m3.b.d(WebMessageBoundaryInterface.class, invocationHandler2));
        if (a2 != null) {
            ((t0.o) this.f6552b).onMessage(new C0721B(invocationHandler), a2);
        }
    }

    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    public void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z3, InvocationHandler invocationHandler2) {
        t0.n a2 = z.a((WebMessageBoundaryInterface) m3.b.d(WebMessageBoundaryInterface.class, invocationHandler));
        if (a2 != null) {
            JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) m3.b.d(JsReplyProxyBoundaryInterface.class, invocationHandler2);
            ((t0.x) this.f6552b).onPostMessage(webView, a2, uri, z3, (r) jsReplyProxyBoundaryInterface.getOrCreatePeer(new q(jsReplyProxyBoundaryInterface, 0)));
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public void onRendererResponsive(WebView webView, InvocationHandler invocationHandler) {
        WeakHashMap weakHashMap = L.f6554c;
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) m3.b.d(WebViewRendererBoundaryInterface.class, invocationHandler);
        ((AbstractC0696A) this.f6552b).onRenderProcessResponsive(webView, (L) webViewRendererBoundaryInterface.getOrCreatePeer(new q(webViewRendererBoundaryInterface, 1)));
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public void onRendererUnresponsive(WebView webView, InvocationHandler invocationHandler) {
        WeakHashMap weakHashMap = L.f6554c;
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) m3.b.d(WebViewRendererBoundaryInterface.class, invocationHandler);
        ((AbstractC0696A) this.f6552b).onRenderProcessUnresponsive(webView, (L) webViewRendererBoundaryInterface.getOrCreatePeer(new q(webViewRendererBoundaryInterface, 1)));
    }

    public /* synthetic */ J(Object obj, int i) {
        this.f6551a = i;
        this.f6552b = obj;
    }
}
