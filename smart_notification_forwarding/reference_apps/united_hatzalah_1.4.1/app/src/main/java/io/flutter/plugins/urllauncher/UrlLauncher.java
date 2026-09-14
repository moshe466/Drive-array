package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import io.flutter.plugins.urllauncher.Messages;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import r.AbstractC0633h;
import r.C0634i;
import r.C0635j;

/* loaded from: classes.dex */
final class UrlLauncher implements Messages.UrlLauncherApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "UrlLauncher";
    private Activity activity;
    private final Context applicationContext;
    private final IntentResolver intentResolver;

    /* loaded from: classes.dex */
    public interface IntentResolver {
        String getHandlerComponentName(Intent intent);
    }

    public UrlLauncher(Context context, IntentResolver intentResolver) {
        this.applicationContext = context;
        this.intentResolver = intentResolver;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0024. Please report as an issue. */
    private static boolean containsRestrictedHeader(Map<String, String> map) {
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            char c4 = 0;
            if (!it.hasNext()) {
                return false;
            }
            String lowerCase = it.next().toLowerCase(Locale.US);
            lowerCase.getClass();
            switch (lowerCase.hashCode()) {
                case -1423461112:
                    if (lowerCase.equals("accept")) {
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1229727188:
                    if (lowerCase.equals("content-language")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 785670158:
                    if (lowerCase.equals("content-type")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 802785917:
                    if (lowerCase.equals("accept-language")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                case 1:
                case 2:
                case 3:
                default:
                    return true;
            }
        }
    }

    private void ensureActivity() {
        if (this.activity != null) {
        } else {
            throw new Messages.FlutterError("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        }
    }

    private static Bundle extractBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public static /* synthetic */ String lambda$new$0(Context context, Intent intent) {
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity == null) {
            return null;
        }
        return resolveActivity.toShortString();
    }

    private static boolean openCustomTab(Context context, Uri uri, Bundle bundle, Messages.BrowserOptions browserOptions) {
        C0634i c0634i = new C0634i();
        c0634i.f6185a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", browserOptions.getShowTitle().booleanValue() ? 1 : 0);
        C0635j a2 = c0634i.a();
        Intent intent = a2.f6192a;
        intent.putExtra("com.android.browser.headers", bundle);
        try {
            intent.setData(uri);
            context.startActivity(intent, a2.f6193b);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean canLaunchUrl(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (this.intentResolver.getHandlerComponentName(intent) == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(!"{com.android.fallback/com.android.fallback.Fallback}".equals(r3));
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public void closeWebView() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean launchUrl(String str, Map<String, String> map, Boolean bool) {
        ensureActivity();
        Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", extractBundle(map));
        if (bool.booleanValue() && Build.VERSION.SDK_INT >= 30) {
            putExtra.addFlags(1024);
        }
        try {
            this.activity.startActivity(putExtra);
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean openUrlInApp(String str, Boolean bool, Messages.WebViewOptions webViewOptions, Messages.BrowserOptions browserOptions) {
        ensureActivity();
        Bundle extractBundle = extractBundle(webViewOptions.getHeaders());
        if (bool.booleanValue() && !containsRestrictedHeader(webViewOptions.getHeaders())) {
            if (openCustomTab(this.activity, Uri.parse(str), extractBundle, browserOptions)) {
                return Boolean.TRUE;
            }
        }
        try {
            this.activity.startActivity(WebViewActivity.createIntent(this.activity, str, webViewOptions.getEnableJavaScript().booleanValue(), webViewOptions.getEnableDomStorage().booleanValue(), extractBundle));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean supportsCustomTabs() {
        boolean z3 = false;
        if (AbstractC0633h.a(this.applicationContext, Collections.EMPTY_LIST, false) != null) {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }

    public UrlLauncher(Context context) {
        this(context, new a(context, 5));
    }
}
