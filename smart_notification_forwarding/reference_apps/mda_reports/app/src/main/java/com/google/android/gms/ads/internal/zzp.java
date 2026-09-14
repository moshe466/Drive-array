package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzdq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final class zzp extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzl zzblk;

    private zzp(zzl zzlVar) {
        this.zzblk = zzlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzp(zzl zzlVar, zzk zzkVar) {
        this(zzlVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String doInBackground(Void... voidArr) {
        Future future;
        try {
            zzl zzlVar = this.zzblk;
            future = this.zzblk.zzbln;
            zzlVar.zzblr = (zzdq) future.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzayu.zzd("", e);
        }
        return this.zzblk.c();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        WebView webView;
        WebView webView2;
        String str2 = str;
        webView = this.zzblk.zzblp;
        if (webView == null || str2 == null) {
            return;
        }
        webView2 = this.zzblk.zzblp;
        webView2.loadUrl(str2);
    }
}
