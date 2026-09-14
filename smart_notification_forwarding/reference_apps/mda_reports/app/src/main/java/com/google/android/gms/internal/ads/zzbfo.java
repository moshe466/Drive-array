package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class zzbfo {

    @VisibleForTesting
    @GuardedBy("InvokeJavascriptWorkaround.class")
    private static Boolean zzeid;

    private zzbfo() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    public static void a(WebView webView, String str) {
        if (PlatformVersion.isAtLeastKitKat() && zzb(webView)) {
            webView.evaluateJavascript(str, null);
        } else {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
        }
    }

    @TargetApi(19)
    private static boolean zzb(WebView webView) {
        boolean booleanValue;
        synchronized (zzbfo.class) {
            if (zzeid == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zzeid = true;
                } catch (IllegalStateException unused) {
                    zzeid = false;
                }
            }
            booleanValue = zzeid.booleanValue();
        }
        return booleanValue;
    }
}
