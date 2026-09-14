package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbei;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbes;

@TargetApi(17)
/* loaded from: classes.dex */
public final class zzbee<WebViewT extends zzbei & zzbeq & zzbes> {
    private final zzbej zzehm;
    private final WebViewT zzehn;

    private zzbee(WebViewT webviewt, zzbej zzbejVar) {
        this.zzehm = zzbejVar;
        this.zzehn = webviewt;
    }

    public static zzbee<zzbdi> zzc(final zzbdi zzbdiVar) {
        return new zzbee<>(zzbdiVar, new zzbej(zzbdiVar) { // from class: com.google.android.gms.internal.ads.zzbeh
            private final zzbdi zzehp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehp = zzbdiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbej
            public final void zzh(Uri uri) {
                zzbev zzaaa = this.zzehp.zzaaa();
                if (zzaaa == null) {
                    zzayu.zzex("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                } else {
                    zzaaa.zzh(uri);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        this.zzehm.zzh(Uri.parse(str));
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "Click string is empty, not proceeding.";
        } else {
            zzdq zzaad = this.zzehn.zzaad();
            if (zzaad == null) {
                str2 = "Signal utils is empty, ignoring.";
            } else {
                zzdg zzbw = zzaad.zzbw();
                if (zzbw == null) {
                    str2 = "Signals object is empty, ignoring.";
                } else {
                    if (this.zzehn.getContext() != null) {
                        return zzbw.zza(this.zzehn.getContext(), str, this.zzehn.getView(), this.zzehn.zzyn());
                    }
                    str2 = "Context is null, ignoring.";
                }
            }
        }
        zzavs.zzed(str2);
        return "";
    }

    @JavascriptInterface
    public final void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            zzayu.zzez("URL is empty, ignoring message");
        } else {
            zzawb.zzdsr.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzbeg
                private final String zzcyr;
                private final zzbee zzeho;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeho = this;
                    this.zzcyr = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeho.a(this.zzcyr);
                }
            });
        }
    }
}
