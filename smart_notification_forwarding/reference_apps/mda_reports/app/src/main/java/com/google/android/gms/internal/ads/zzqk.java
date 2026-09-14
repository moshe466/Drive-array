package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzqk implements Runnable {
    final /* synthetic */ zzqc a;
    final /* synthetic */ WebView b;
    final /* synthetic */ boolean c;
    final /* synthetic */ zzqi d;
    private ValueCallback<String> zzbpv = new zzqn(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqk(zzqi zzqiVar, zzqc zzqcVar, WebView webView, boolean z) {
        this.d = zzqiVar;
        this.a = zzqcVar;
        this.b = webView;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.getSettings().getJavaScriptEnabled()) {
            try {
                this.b.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbpv);
            } catch (Throwable unused) {
                this.zzbpv.onReceiveValue("");
            }
        }
    }
}
