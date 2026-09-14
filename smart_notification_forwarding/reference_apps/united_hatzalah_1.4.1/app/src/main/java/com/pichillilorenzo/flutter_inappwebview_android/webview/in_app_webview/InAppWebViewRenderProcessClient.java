package com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview;

import F0.AbstractC0008a;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate;
import e0.a;
import t0.AbstractC0696A;
import t0.d;
import t0.z;

/* loaded from: classes.dex */
public class InAppWebViewRenderProcessClient extends AbstractC0696A {
    protected static final String LOG_TAG = "IAWRenderProcessClient";

    public void dispose() {
    }

    @Override // t0.AbstractC0696A
    public void onRenderProcessResponsive(WebView webView, final z zVar) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        WebViewChannelDelegate.RenderProcessResponsiveCallback renderProcessResponsiveCallback = new WebViewChannelDelegate.RenderProcessResponsiveCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient.2
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public void defaultBehaviour(Integer num) {
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, io.flutter.plugin.common.MethodChannel.Result
            public void error(String str, String str2, Object obj) {
                StringBuilder i = a.i(str, ", ");
                if (str2 == null) {
                    str2 = "";
                }
                AbstractC0008a.B(i, str2, InAppWebViewRenderProcessClient.LOG_TAG);
                defaultBehaviour((Integer) null);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public boolean nonNullSuccess(Integer num) {
                if (zVar == null) {
                    return true;
                }
                if (num.intValue() != 0 || !d.a("WEB_VIEW_RENDERER_TERMINATE")) {
                    return false;
                }
                zVar.a();
                return false;
            }
        };
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onRenderProcessResponsive(inAppWebView.getUrl(), renderProcessResponsiveCallback);
        } else {
            renderProcessResponsiveCallback.defaultBehaviour(null);
        }
    }

    @Override // t0.AbstractC0696A
    public void onRenderProcessUnresponsive(WebView webView, final z zVar) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        WebViewChannelDelegate.RenderProcessUnresponsiveCallback renderProcessUnresponsiveCallback = new WebViewChannelDelegate.RenderProcessUnresponsiveCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient.1
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public void defaultBehaviour(Integer num) {
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, io.flutter.plugin.common.MethodChannel.Result
            public void error(String str, String str2, Object obj) {
                StringBuilder i = a.i(str, ", ");
                if (str2 == null) {
                    str2 = "";
                }
                AbstractC0008a.B(i, str2, InAppWebViewRenderProcessClient.LOG_TAG);
                defaultBehaviour((Integer) null);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public boolean nonNullSuccess(Integer num) {
                if (zVar == null) {
                    return true;
                }
                if (num.intValue() != 0 || !d.a("WEB_VIEW_RENDERER_TERMINATE")) {
                    return false;
                }
                zVar.a();
                return false;
            }
        };
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onRenderProcessUnresponsive(inAppWebView.getUrl(), renderProcessUnresponsiveCallback);
        } else {
            renderProcessUnresponsiveCallback.defaultBehaviour(null);
        }
    }
}
