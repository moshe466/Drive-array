package u0;

import android.content.Context;
import android.net.Uri;
import android.webkit.SafeBrowsingResponse;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.List;

/* renamed from: u0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0731i {
    public static void a(SafeBrowsingResponse safeBrowsingResponse, boolean z3) {
        safeBrowsingResponse.backToSafety(z3);
    }

    public static Uri b() {
        Uri safeBrowsingPrivacyPolicyUrl;
        safeBrowsingPrivacyPolicyUrl = WebView.getSafeBrowsingPrivacyPolicyUrl();
        return safeBrowsingPrivacyPolicyUrl;
    }

    public static void c(SafeBrowsingResponse safeBrowsingResponse, boolean z3) {
        safeBrowsingResponse.proceed(z3);
    }

    public static void d(List<String> list, ValueCallback<Boolean> valueCallback) {
        WebView.setSafeBrowsingWhitelist(list, valueCallback);
    }

    public static void e(SafeBrowsingResponse safeBrowsingResponse, boolean z3) {
        safeBrowsingResponse.showInterstitial(z3);
    }

    public static void f(Context context, ValueCallback<Boolean> valueCallback) {
        WebView.startSafeBrowsing(context, valueCallback);
    }
}
