package com.google.android.recaptcha.internal;

import P2.C0169t;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;
import org.apache.tika.mime.MimeTypes;

/* loaded from: classes.dex */
public final class zzik extends WebViewClient {
    final /* synthetic */ zzja zza;

    public zzik(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        System.currentTimeMillis();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        zzjh zzjhVar;
        zzjhVar = this.zza.zzh;
        long zza = zzjhVar.zza(TimeUnit.MICROSECONDS);
        int i = zzbk.zza;
        zzbk.zza(zzbl.zzg.zza(), zza);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Map map;
        super.onReceivedError(webView, i, str, str2);
        zzbb zzbbVar = zzbb.zzc;
        map = this.zza.zzd;
        zzba zzbaVar = (zzba) map.get(Integer.valueOf(i));
        if (zzbaVar == null) {
            zzbaVar = zzba.zzM;
        }
        zzbd zzbdVar = new zzbd(zzbbVar, zzbaVar, null);
        this.zza.zzA().hashCode();
        zzbdVar.getMessage();
        ((C0169t) this.zza.zzA()).P(zzbdVar);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        zzja zzjaVar = this.zza;
        Uri parse = Uri.parse(str);
        zzja.zzp(zzjaVar);
        j.b(parse);
        if (zzfk.zzc(parse) && !zzja.zzp(this.zza).zza(parse)) {
            zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzQ, null);
            this.zza.zzA().hashCode();
            parse.toString();
            ((C0169t) this.zza.zzA()).P(zzbdVar);
            return new WebResourceResponse(MimeTypes.PLAIN_TEXT, "UTF-8", new ByteArrayInputStream(new byte[0]));
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
