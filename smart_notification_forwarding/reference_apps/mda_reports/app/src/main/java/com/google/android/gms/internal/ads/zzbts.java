package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import io.fabric.sdk.android.services.network.HttpRequest;

/* loaded from: classes.dex */
public final class zzbts implements zzro {
    private zzddz zzfiw;

    @Override // com.google.android.gms.internal.ads.zzro
    public final View getView() {
        return this.zzfiw;
    }

    @Override // com.google.android.gms.internal.ads.zzro
    public final WebView getWebView() {
        if (this.zzfiw == null) {
            return null;
        }
        return zzddz.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzro
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.zzfiw != null) {
            zzddz.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzro
    public final void zza(Activity activity, WebView webView) {
        try {
            this.zzfiw = new zzddz(activity, webView);
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46);
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(valueOf);
            zzayu.zzex(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzro
    public final void zzc(String str, String str2) {
        if (this.zzfiw == null) {
            zzayu.zzex("ArWebView is not initialized.");
        } else {
            zzddz.getWebView().loadDataWithBaseURL(str, str2, "text/html", HttpRequest.CHARSET_UTF8, null);
        }
    }
}
