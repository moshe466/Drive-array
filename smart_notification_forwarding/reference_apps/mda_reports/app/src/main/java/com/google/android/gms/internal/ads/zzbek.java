package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(11)
/* loaded from: classes.dex */
public final class zzbek extends zzben {
    public zzbek(zzbdi zzbdiVar, zzsm zzsmVar, boolean z) {
        super(zzbdiVar, zzsmVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdl, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str, null);
    }
}
