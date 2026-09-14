package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import b.C0317b;
import b.InterfaceC0319d;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsSecondaryToolbar;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r.BinderC0632g;
import r.C0640o;

/* loaded from: classes.dex */
public class ChromeCustomTabsChannelDelegate extends ChannelDelegateImpl {
    private ChromeCustomTabsActivity chromeCustomTabsActivity;

    public ChromeCustomTabsChannelDelegate(ChromeCustomTabsActivity chromeCustomTabsActivity, MethodChannel methodChannel) {
        super(methodChannel);
        this.chromeCustomTabsActivity = chromeCustomTabsActivity;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.chromeCustomTabsActivity = null;
    }

    public void onClosed() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onClosed", new HashMap());
    }

    public void onCompletedInitialLoad() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onCompletedInitialLoad", new HashMap());
    }

    public void onGreatestScrollPercentageIncreased(int i) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scrollPercentage", Integer.valueOf(i));
        channel.invokeMethod("onGreatestScrollPercentageIncreased", hashMap);
    }

    public void onItemActionPerform(int i, String str, String str2) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i));
        hashMap.put(ImagesContract.URL, str);
        hashMap.put("title", str2);
        channel.invokeMethod("onItemActionPerform", hashMap);
    }

    public void onMessageChannelReady() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onMessageChannelReady", new HashMap());
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        C0640o c0640o;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        Activity activity;
        Uri uri;
        int i;
        String str = methodCall.method;
        str.getClass();
        boolean z3 = false;
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1526944655:
                if (str.equals("isEngagementSignalsApiAvailable")) {
                    c4 = 0;
                    break;
                }
                break;
            case -675108676:
                if (str.equals("launchUrl")) {
                    c4 = 1;
                    break;
                }
                break;
            case -334843312:
                if (str.equals("updateSecondaryToolbar")) {
                    c4 = 2;
                    break;
                }
                break;
            case 50870385:
                if (str.equals("updateActionButton")) {
                    c4 = 3;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1256059502:
                if (str.equals("validateRelationship")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1392239787:
                if (str.equals("requestPostMessageChannel")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1490029383:
                if (str.equals("postMessage")) {
                    c4 = 7;
                    break;
                }
                break;
            case 2000053463:
                if (str.equals("mayLaunchUrl")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        Bundle bundle = null;
        switch (c4) {
            case 0:
                ChromeCustomTabsActivity chromeCustomTabsActivity = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity != null && (c0640o = chromeCustomTabsActivity.customTabsSession) != null) {
                    try {
                        result.success(Boolean.valueOf(c0640o.b(new Bundle())));
                        return;
                    } catch (Throwable unused) {
                        result.success(Boolean.FALSE);
                        return;
                    }
                }
                result.success(Boolean.FALSE);
                return;
            case 1:
                if (this.chromeCustomTabsActivity != null) {
                    String str2 = (String) methodCall.argument(ImagesContract.URL);
                    if (str2 != null) {
                        this.chromeCustomTabsActivity.launchUrl(str2, (Map) methodCall.argument("headers"), (String) methodCall.argument("referrer"), (List) methodCall.argument("otherLikelyURLs"));
                        result.success(Boolean.TRUE);
                        return;
                    } else {
                        result.success(Boolean.FALSE);
                        return;
                    }
                }
                result.success(Boolean.FALSE);
                return;
            case 2:
                if (this.chromeCustomTabsActivity != null) {
                    this.chromeCustomTabsActivity.updateSecondaryToolbar(CustomTabsSecondaryToolbar.fromMap((Map) methodCall.argument("secondaryToolbar")));
                    result.success(Boolean.TRUE);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 3:
                if (this.chromeCustomTabsActivity != null) {
                    this.chromeCustomTabsActivity.updateActionButton((byte[]) methodCall.argument("icon"), (String) methodCall.argument("description"));
                    result.success(Boolean.TRUE);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 4:
                ChromeCustomTabsActivity chromeCustomTabsActivity2 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity2 != null) {
                    chromeCustomTabsActivity2.onStop();
                    this.chromeCustomTabsActivity.onDestroy();
                    this.chromeCustomTabsActivity.close();
                    ChromeSafariBrowserManager chromeSafariBrowserManager = this.chromeCustomTabsActivity.manager;
                    if (chromeSafariBrowserManager != null && (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) != null && (activity = inAppWebViewFlutterPlugin.activity) != null) {
                        Intent intent = new Intent(activity, activity.getClass());
                        intent.addFlags(67108864);
                        intent.addFlags(536870912);
                        activity.startActivity(intent);
                    }
                    this.chromeCustomTabsActivity.dispose();
                    result.success(Boolean.TRUE);
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 5:
                ChromeCustomTabsActivity chromeCustomTabsActivity3 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity3 != null && chromeCustomTabsActivity3.customTabsSession != null) {
                    Integer num = (Integer) methodCall.argument("relation");
                    String str3 = (String) methodCall.argument(ClientData.KEY_ORIGIN);
                    C0640o c0640o2 = this.chromeCustomTabsActivity.customTabsSession;
                    int intValue = num.intValue();
                    Uri parse = Uri.parse(str3);
                    c0640o2.getClass();
                    if (intValue >= 1 && intValue <= 2) {
                        try {
                            z3 = ((C0317b) c0640o2.f6201b).m(c0640o2.f6202c, intValue, parse, c0640o2.a(null));
                        } catch (RemoteException unused2) {
                        }
                    }
                    result.success(Boolean.valueOf(z3));
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 6:
                ChromeCustomTabsActivity chromeCustomTabsActivity4 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity4 != null && chromeCustomTabsActivity4.customTabsSession != null) {
                    String str4 = (String) methodCall.argument("sourceOrigin");
                    String str5 = (String) methodCall.argument("targetOrigin");
                    C0640o c0640o3 = this.chromeCustomTabsActivity.customTabsSession;
                    Uri parse2 = Uri.parse(str4);
                    if (str5 != null) {
                        uri = Uri.parse(str5);
                    } else {
                        uri = null;
                    }
                    Bundle bundle2 = new Bundle();
                    BinderC0632g binderC0632g = c0640o3.f6202c;
                    InterfaceC0319d interfaceC0319d = c0640o3.f6201b;
                    try {
                        Bundle bundle3 = new Bundle();
                        if (uri != null) {
                            bundle3.putParcelable("target_origin", uri);
                        }
                        if (!bundle3.isEmpty()) {
                            bundle = bundle3;
                        }
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                            z3 = ((C0317b) interfaceC0319d).j(binderC0632g, parse2, bundle2);
                        } else {
                            z3 = ((C0317b) interfaceC0319d).i(binderC0632g, parse2);
                        }
                    } catch (RemoteException unused3) {
                    }
                    result.success(Boolean.valueOf(z3));
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 7:
                ChromeCustomTabsActivity chromeCustomTabsActivity5 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity5 != null && chromeCustomTabsActivity5.customTabsSession != null) {
                    String str6 = (String) methodCall.argument(Constants.MESSAGE);
                    C0640o c0640o4 = this.chromeCustomTabsActivity.customTabsSession;
                    Bundle a2 = c0640o4.a(new Bundle());
                    synchronized (c0640o4.f6200a) {
                        try {
                            try {
                                i = ((C0317b) c0640o4.f6201b).h(c0640o4.f6202c, str6, a2);
                            } finally {
                            }
                        } catch (RemoteException unused4) {
                            i = -2;
                        }
                    }
                    result.success(Integer.valueOf(i));
                    return;
                }
                result.success(-3);
                return;
            case '\b':
                if (this.chromeCustomTabsActivity != null) {
                    result.success(Boolean.valueOf(this.chromeCustomTabsActivity.mayLaunchUrl((String) methodCall.argument(ImagesContract.URL), (List) methodCall.argument("otherLikelyURLs"))));
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            default:
                result.notImplemented();
                return;
        }
    }

    public void onNavigationEvent(int i) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("navigationEvent", Integer.valueOf(i));
        channel.invokeMethod("onNavigationEvent", hashMap);
    }

    public void onOpened() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onOpened", new HashMap());
    }

    public void onPostMessage(String str) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.MESSAGE, str);
        channel.invokeMethod("onPostMessage", hashMap);
    }

    public void onRelationshipValidationResult(int i, Uri uri, boolean z3) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("relation", Integer.valueOf(i));
        hashMap.put("requestedOrigin", uri.toString());
        hashMap.put("result", Boolean.valueOf(z3));
        channel.invokeMethod("onRelationshipValidationResult", hashMap);
    }

    public void onSecondaryItemActionPerform(String str, String str2) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put(ImagesContract.URL, str2);
        channel.invokeMethod("onSecondaryItemActionPerform", hashMap);
    }

    public void onServiceConnected() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onServiceConnected", new HashMap());
    }

    public void onSessionEnded(boolean z3) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("didUserInteract", Boolean.valueOf(z3));
        channel.invokeMethod("onSessionEnded", hashMap);
    }

    public void onVerticalScrollEvent(boolean z3) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isDirectionUp", Boolean.valueOf(z3));
        channel.invokeMethod("onVerticalScrollEvent", hashMap);
    }
}
