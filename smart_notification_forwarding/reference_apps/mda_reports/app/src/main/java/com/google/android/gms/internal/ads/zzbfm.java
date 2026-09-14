package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbfm extends zzbfl implements zzbfr {

    @GuardedBy("this")
    private boolean zzegh;

    @GuardedBy("this")
    private boolean zzeha;
    private final zzbfk zzeic;

    public zzbfm(Context context, zzbfk zzbfkVar) {
        super(context);
        com.google.android.gms.ads.internal.zzq.zzku().zzvc();
        this.zzeic = zzbfkVar;
        super.setWebViewClient(zzbfkVar);
    }

    private final synchronized void zzvd() {
        if (!this.zzeha) {
            this.zzeha = true;
            com.google.android.gms.ads.internal.zzq.zzku().zzvd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        super.destroy();
    }

    @GuardedBy("this")
    protected void a(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbfl, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (this.zzegh) {
            return;
        }
        this.zzegh = true;
        this.zzeic.a(this);
        a(false);
        zzavs.zzed("Initiating WebView self destruct sequence in 3...");
        zzavs.zzed("Loading blank page in WebView, 2...");
        try {
            super.loadUrl("about:blank");
        } catch (UnsatisfiedLinkError e) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            super.evaluateJavascript(str, valueCallback);
            return;
        }
        zzayu.zzez("#004 The webview is destroyed. Ignoring action.");
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
    }

    protected void finalize() {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    a(true);
                }
                zzvd();
            }
        } finally {
            super.finalize();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.zzegh;
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (isDestroyed()) {
            zzayu.zzez("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (isDestroyed()) {
            zzayu.zzez("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (isDestroyed()) {
            zzayu.zzez("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdi
    public void onPause() {
        if (isDestroyed()) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdi
    public void onResume() {
        if (isDestroyed()) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        super.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzbfr
    public final synchronized void zza(zzbfn zzbfnVar) {
        zzavs.zzed("Blank page loaded, 1...");
        zzaag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void zzaag() {
        zzavs.zzed("Destroying WebView!");
        zzvd();
        zzazd.zzdwi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbfp
            private final zzbfm zzeie;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeie = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeie.a();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbfl, com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzaip
    public /* bridge */ /* synthetic */ void zzcy(String str) {
        super.zzcy(str);
    }
}
