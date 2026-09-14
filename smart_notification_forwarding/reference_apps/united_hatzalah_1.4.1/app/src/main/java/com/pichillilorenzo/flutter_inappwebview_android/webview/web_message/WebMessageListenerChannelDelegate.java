package com.pichillilorenzo.flutter_inappwebview_android.webview.web_message;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WebMessageListenerChannelDelegate extends ChannelDelegateImpl {
    private WebMessageListener webMessageListener;

    public WebMessageListenerChannelDelegate(WebMessageListener webMessageListener, MethodChannel methodChannel) {
        super(methodChannel);
        this.webMessageListener = webMessageListener;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.webMessageListener = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        if (!str.equals("postMessage")) {
            result.notImplemented();
            return;
        }
        WebMessageListener webMessageListener = this.webMessageListener;
        if (webMessageListener != null && (webMessageListener.webView instanceof InAppWebView)) {
            this.webMessageListener.postMessageForInAppWebView(WebMessageCompatExt.fromMap((Map) methodCall.argument(Constants.MESSAGE)), result);
        } else {
            result.success(Boolean.FALSE);
        }
    }

    public void onPostMessage(WebMessageCompatExt webMessageCompatExt, String str, boolean z3) {
        Map<String, Object> map;
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (webMessageCompatExt != null) {
            map = webMessageCompatExt.toMap();
        } else {
            map = null;
        }
        hashMap.put(Constants.MESSAGE, map);
        hashMap.put("sourceOrigin", str);
        hashMap.put("isMainFrame", Boolean.valueOf(z3));
        channel.invokeMethod("onPostMessage", hashMap);
    }
}
