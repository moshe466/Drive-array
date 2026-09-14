package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzvh;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzk extends WebViewClient {
    private final /* synthetic */ zzl zzblk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzl zzlVar) {
        this.zzblk = zzlVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzvh zzvhVar;
        zzvh zzvhVar2;
        zzvhVar = this.zzblk.zzblq;
        if (zzvhVar != null) {
            try {
                zzvhVar2 = this.zzblk.zzblq;
                zzvhVar2.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzvh zzvhVar;
        zzvh zzvhVar2;
        String zzbt;
        zzvh zzvhVar3;
        zzvh zzvhVar4;
        zzvh zzvhVar5;
        zzvh zzvhVar6;
        zzvh zzvhVar7;
        zzvh zzvhVar8;
        if (str.startsWith(this.zzblk.d())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzvhVar7 = this.zzblk.zzblq;
            if (zzvhVar7 != null) {
                try {
                    zzvhVar8 = this.zzblk.zzblq;
                    zzvhVar8.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
            this.zzblk.b(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzvhVar5 = this.zzblk.zzblq;
            if (zzvhVar5 != null) {
                try {
                    zzvhVar6 = this.zzblk.zzblq;
                    zzvhVar6.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzayu.zze("#007 Could not call remote method.", e2);
                }
            }
            this.zzblk.b(0);
            return true;
        }
        if (str.startsWith("gmsg://adResized")) {
            zzvhVar3 = this.zzblk.zzblq;
            if (zzvhVar3 != null) {
                try {
                    zzvhVar4 = this.zzblk.zzblq;
                    zzvhVar4.onAdLoaded();
                } catch (RemoteException e3) {
                    zzayu.zze("#007 Could not call remote method.", e3);
                }
            }
            this.zzblk.b(this.zzblk.a(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        zzvhVar = this.zzblk.zzblq;
        if (zzvhVar != null) {
            try {
                zzvhVar2 = this.zzblk.zzblq;
                zzvhVar2.onAdLeftApplication();
            } catch (RemoteException e4) {
                zzayu.zze("#007 Could not call remote method.", e4);
            }
        }
        zzbt = this.zzblk.zzbt(str);
        this.zzblk.zzbu(zzbt);
        return true;
    }
}
