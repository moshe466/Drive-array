package com.pichillilorenzo.flutter_inappwebview_android.headless_in_app_webview;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.Size2D;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HeadlessWebViewChannelDelegate extends ChannelDelegateImpl {
    private HeadlessInAppWebView headlessWebView;

    public HeadlessWebViewChannelDelegate(HeadlessInAppWebView headlessInAppWebView, MethodChannel methodChannel) {
        super(methodChannel);
        this.headlessWebView = headlessInAppWebView;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.headlessWebView = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -75151241:
                if (str.equals("getSize")) {
                    c4 = 0;
                    break;
                }
                break;
            case 1671767583:
                if (str.equals("dispose")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1984958339:
                if (str.equals("setSize")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                HeadlessInAppWebView headlessInAppWebView = this.headlessWebView;
                Map<String, Object> map = null;
                if (headlessInAppWebView != null) {
                    Size2D size = headlessInAppWebView.getSize();
                    if (size != null) {
                        map = size.toMap();
                    }
                    result.success(map);
                    return;
                }
                result.success(null);
                return;
            case 1:
                HeadlessInAppWebView headlessInAppWebView2 = this.headlessWebView;
                if (headlessInAppWebView2 != null) {
                    headlessInAppWebView2.dispose();
                    result.success(Boolean.TRUE);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 2:
                if (this.headlessWebView != null) {
                    Size2D fromMap = Size2D.fromMap((Map) methodCall.argument("size"));
                    if (fromMap != null) {
                        this.headlessWebView.setSize(fromMap);
                    }
                    result.success(Boolean.TRUE);
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void onWebViewCreated() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onWebViewCreated", new HashMap());
    }
}
