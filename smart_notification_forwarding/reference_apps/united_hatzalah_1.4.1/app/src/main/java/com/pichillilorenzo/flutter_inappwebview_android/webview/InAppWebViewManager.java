package com.pichillilorenzo.flutter_inappwebview_android.webview;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.FlutterWebView;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t0.d;
import t0.y;
import u0.AbstractC0731i;
import u0.C0724b;
import u0.F;
import u0.H;

/* loaded from: classes.dex */
public class InAppWebViewManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "InAppWebViewManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_manager";
    public final Map<String, FlutterWebView> keepAliveWebViews;
    public InAppWebViewFlutterPlugin plugin;
    public int windowAutoincrementId;
    public final Map<Integer, Message> windowWebViewMessages;

    public InAppWebViewManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.keepAliveWebViews = new HashMap();
        this.windowWebViewMessages = new HashMap();
        this.windowAutoincrementId = 0;
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public void clearAllCache(Context context, boolean z3) {
        WebView webView = new WebView(context);
        webView.clearCache(z3);
        webView.destroy();
    }

    public Map<String, Object> convertWebViewPackageToMap(PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("versionName", packageInfo.versionName);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, packageInfo.packageName);
        return hashMap;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        Iterator<FlutterWebView> it = this.keepAliveWebViews.values().iterator();
        while (it.hasNext()) {
            String str = it.next().keepAliveId;
            if (str != null) {
                disposeKeepAlive(str);
            }
        }
        this.keepAliveWebViews.clear();
        this.windowWebViewMessages.clear();
        this.plugin = null;
    }

    public void disposeKeepAlive(String str) {
        ViewGroup viewGroup;
        FlutterWebView flutterWebView = this.keepAliveWebViews.get(str);
        if (flutterWebView != null) {
            flutterWebView.keepAliveId = null;
            View view = flutterWebView.getView();
            if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
                viewGroup.removeView(view);
            }
            flutterWebView.dispose();
        }
        if (this.keepAliveWebViews.containsKey(str)) {
            this.keepAliveWebViews.put(str, null);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Uri safeBrowsingPrivacyPolicyUrl;
        Context context;
        PackageInfo packageInfo;
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1496477679:
                if (str.equals("disableWebView")) {
                    c4 = 0;
                    break;
                }
                break;
            case -910403233:
                if (str.equals("setWebContentsDebuggingEnabled")) {
                    c4 = 1;
                    break;
                }
                break;
            case -633518365:
                if (str.equals("getVariationsHeader")) {
                    c4 = 2;
                    break;
                }
                break;
            case -436220260:
                if (str.equals("clearClientCertPreferences")) {
                    c4 = 3;
                    break;
                }
                break;
            case 258673215:
                if (str.equals("getSafeBrowsingPrivacyPolicyUrl")) {
                    c4 = 4;
                    break;
                }
                break;
            case 426229521:
                if (str.equals("setSafeBrowsingAllowlist")) {
                    c4 = 5;
                    break;
                }
                break;
            case 643643439:
                if (str.equals("getDefaultUserAgent")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1033609166:
                if (str.equals("clearAllCache")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1586319888:
                if (str.equals("getCurrentWebViewPackage")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1667434977:
                if (str.equals("isMultiProcessEnabled")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1867011305:
                if (str.equals("disposeKeepAlive")) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        Map<String, Object> map = null;
        switch (c4) {
            case 0:
                if (Build.VERSION.SDK_INT >= 28) {
                    WebView.disableWebView();
                }
                result.success(Boolean.TRUE);
                return;
            case 1:
                WebView.setWebContentsDebuggingEnabled(((Boolean) methodCall.argument("debuggingEnabled")).booleanValue());
                result.success(Boolean.TRUE);
                return;
            case 2:
                if (d.a("GET_VARIATIONS_HEADER")) {
                    Uri uri = y.f6390a;
                    if (F.f6521L.b()) {
                        result.success(H.f6549a.getStatics().getVariationsHeader());
                        return;
                    }
                    throw F.a();
                }
                result.success(null);
                return;
            case 3:
                WebView.clearClientCertPreferences(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        result.success(Boolean.TRUE);
                    }
                });
                return;
            case 4:
                if (d.a("SAFE_BROWSING_PRIVACY_POLICY_URL")) {
                    Uri uri2 = y.f6390a;
                    C0724b c0724b = F.f6531g;
                    if (c0724b.a()) {
                        safeBrowsingPrivacyPolicyUrl = AbstractC0731i.b();
                    } else if (c0724b.b()) {
                        safeBrowsingPrivacyPolicyUrl = H.f6549a.getStatics().getSafeBrowsingPrivacyPolicyUrl();
                    } else {
                        throw F.a();
                    }
                    result.success(safeBrowsingPrivacyPolicyUrl.toString());
                    return;
                }
                result.success(null);
                return;
            case 5:
                if (d.a("SAFE_BROWSING_ALLOWLIST")) {
                    y.f(new HashSet((List) methodCall.argument("hosts")), new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager.2
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Boolean bool) {
                            result.success(bool);
                        }
                    });
                    return;
                }
                if (d.a("SAFE_BROWSING_WHITELIST")) {
                    List list = (List) methodCall.argument("hosts");
                    ValueCallback<Boolean> valueCallback = new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager.3
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Boolean bool) {
                            result.success(bool);
                        }
                    };
                    Uri uri3 = y.f6390a;
                    y.f(new HashSet(list), valueCallback);
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 6:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
                if (inAppWebViewFlutterPlugin != null) {
                    result.success(WebSettings.getDefaultUserAgent(inAppWebViewFlutterPlugin.applicationContext));
                    return;
                } else {
                    result.success(null);
                    return;
                }
            case 7:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.plugin;
                if (inAppWebViewFlutterPlugin2 != null) {
                    Context context2 = inAppWebViewFlutterPlugin2.activity;
                    if (context2 == null) {
                        context2 = inAppWebViewFlutterPlugin2.applicationContext;
                    }
                    if (context2 != null) {
                        clearAllCache(context2, ((Boolean) methodCall.argument("includeDiskFiles")).booleanValue());
                    }
                }
                result.success(Boolean.TRUE);
                return;
            case '\b':
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin3 = this.plugin;
                if (inAppWebViewFlutterPlugin3 != null) {
                    context = inAppWebViewFlutterPlugin3.activity;
                    if (context == null) {
                        context = inAppWebViewFlutterPlugin3.applicationContext;
                    }
                } else {
                    context = null;
                }
                if (context != null) {
                    packageInfo = y.b(context);
                } else {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    map = convertWebViewPackageToMap(packageInfo);
                }
                result.success(map);
                return;
            case '\t':
                if (d.a("MULTI_PROCESS")) {
                    Uri uri4 = y.f6390a;
                    if (F.f6515F.b()) {
                        result.success(Boolean.valueOf(H.f6549a.getStatics().isMultiProcessEnabled()));
                        return;
                    }
                    throw F.a();
                }
                result.success(Boolean.FALSE);
                return;
            case '\n':
                String str2 = (String) methodCall.argument("keepAliveId");
                if (str2 != null) {
                    disposeKeepAlive(str2);
                }
                result.success(Boolean.TRUE);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
