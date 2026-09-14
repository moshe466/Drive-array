package com.pichillilorenzo.flutter_inappwebview_android.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.headless_in_app_webview.HeadlessInAppWebView;
import com.pichillilorenzo.flutter_inappwebview_android.headless_in_app_webview.HeadlessInAppWebViewManager;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.FlutterWebView;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FlutterWebViewFactory extends PlatformViewFactory {
    public static final String VIEW_TYPE_ID = "com.pichillilorenzo/flutter_inappwebview";
    private final InAppWebViewFlutterPlugin plugin;

    public FlutterWebViewFactory(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(StandardMessageCodec.INSTANCE);
        this.plugin = inAppWebViewFlutterPlugin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i, Object obj) {
        FlutterWebView flutterWebView;
        boolean z3;
        View view;
        ViewGroup viewGroup;
        HeadlessInAppWebView headlessInAppWebView;
        HashMap<String, Object> hashMap = (HashMap) obj;
        Integer valueOf = Integer.valueOf(i);
        String str = (String) hashMap.get("keepAliveId");
        String str2 = (String) hashMap.get("headlessWebViewId");
        HeadlessInAppWebViewManager headlessInAppWebViewManager = this.plugin.headlessInAppWebViewManager;
        if (str2 != null && headlessInAppWebViewManager != null && (headlessInAppWebView = headlessInAppWebViewManager.webViews.get(str2)) != null) {
            flutterWebView = headlessInAppWebView.disposeAndGetFlutterWebView();
            if (flutterWebView != null) {
                flutterWebView.keepAliveId = str;
            }
        } else {
            flutterWebView = null;
        }
        InAppWebViewManager inAppWebViewManager = this.plugin.inAppWebViewManager;
        if (str != 0 && flutterWebView == null && inAppWebViewManager != null && (flutterWebView = inAppWebViewManager.keepAliveWebViews.get(str)) != null && (view = flutterWebView.getView()) != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(view);
        }
        if (flutterWebView == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (flutterWebView == null) {
            if (str != 0) {
                valueOf = str;
            }
            flutterWebView = new FlutterWebView(this.plugin, context, valueOf, hashMap);
        }
        if (str != 0 && inAppWebViewManager != null) {
            inAppWebViewManager.keepAliveWebViews.put(str, flutterWebView);
        }
        if (z3) {
            flutterWebView.makeInitialLoad(hashMap);
        }
        return flutterWebView;
    }
}
