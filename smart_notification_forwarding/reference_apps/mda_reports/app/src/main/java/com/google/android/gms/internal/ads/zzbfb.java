package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbfb extends zzbfk implements zzbev {
    protected zzbdi a;
    private volatile boolean zzbmb;
    private zzty zzcbt;
    private zzaew zzcwq;
    private zzaey zzcws;
    private com.google.android.gms.ads.internal.zzc zzcxo;
    private zzaoe zzcxp;
    private com.google.android.gms.ads.internal.overlay.zzo zzdhq;
    private com.google.android.gms.ads.internal.overlay.zzt zzdhu;
    private boolean zzdll;
    private zzbeu zzeei;
    private zzbex zzeej;
    private zzbew zzeek;

    @GuardedBy("lock")
    private boolean zzeem;

    @GuardedBy("lock")
    private boolean zzeen;

    @GuardedBy("lock")
    private boolean zzeeo;
    private zzaol zzeep;

    @Nullable
    private zzato zzeeq;
    private boolean zzeer;
    private boolean zzees;
    private int zzeet;
    private View.OnAttachStateChangeListener zzeeu;
    private final Object lock = new Object();
    private boolean zzeel = false;
    private final zzaie<zzbdi> zzehu = new zzaie<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzato zzatoVar, int i) {
        if (!zzatoVar.zzul() || i <= 0) {
            return;
        }
        zzatoVar.zzj(view);
        if (zzatoVar.zzul()) {
            zzawb.zzdsr.postDelayed(new zzbfd(this, view, zzatoVar, i), 100L);
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        zzaoe zzaoeVar = this.zzcxp;
        boolean zztg = zzaoeVar != null ? zzaoeVar.zztg() : false;
        com.google.android.gms.ads.internal.zzq.zzkp();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.a.getContext(), adOverlayInfoParcel, !zztg);
        if (this.zzeeq != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzdVar = adOverlayInfoParcel.zzdhp) != null) {
                str = zzdVar.url;
            }
            this.zzeeq.zzdv(str);
        }
    }

    private final void zzaay() {
        if (this.zzeeu == null) {
            return;
        }
        this.a.getView().removeOnAttachStateChangeListener(this.zzeeu);
    }

    private final void zzabd() {
        if (this.zzeei != null && ((this.zzeer && this.zzeet <= 0) || this.zzees)) {
            this.zzeei.zzak(!this.zzees);
            this.zzeei = null;
        }
        this.a.zzaak();
    }

    private static WebResourceResponse zzabe() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcip)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f2, code lost:
    
        com.google.android.gms.ads.internal.zzq.zzkq();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f9, code lost:
    
        return com.google.android.gms.internal.ads.zzawb.zzd(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse zze(com.google.android.gms.internal.ads.zzbfn r8) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfb.zze(com.google.android.gms.internal.ads.zzbfn):android.webkit.WebResourceResponse");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzbdi zzbdiVar, boolean z) {
        zzaol zzaolVar = new zzaol(zzbdiVar, zzbdiVar.zzzv(), new zzyy(zzbdiVar.getContext()));
        this.a = zzbdiVar;
        this.zzbmb = z;
        this.zzeep = zzaolVar;
        this.zzcxp = null;
        this.zzehu.zzg((zzaie<zzbdi>) zzbdiVar);
    }

    public final void destroy() {
        zzato zzatoVar = this.zzeeq;
        if (zzatoVar != null) {
            zzatoVar.zzun();
            this.zzeeq = null;
        }
        zzaay();
        this.zzehu.reset();
        this.zzehu.zzg((zzaie<zzbdi>) null);
        synchronized (this.lock) {
            this.zzcbt = null;
            this.zzdhq = null;
            this.zzeei = null;
            this.zzeej = null;
            this.zzcwq = null;
            this.zzcws = null;
            this.zzdhu = null;
            this.zzeek = null;
            if (this.zzcxp != null) {
                this.zzcxp.zzac(true);
                this.zzcxp = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzro zzaaq = this.a.zzaaq();
        if (zzaaq != null && webView == zzaaq.getWebView()) {
            zzaaq.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.a.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zza(int i, int i2, boolean z) {
        this.zzeep.zzj(i, i2);
        zzaoe zzaoeVar = this.zzcxp;
        if (zzaoeVar != null) {
            zzaoeVar.zza(i, i2, false);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        boolean zzaaf = this.a.zzaaf();
        zza(new AdOverlayInfoParcel(zzdVar, (!zzaaf || this.a.zzzy().zzabt()) ? this.zzcbt : null, zzaaf ? null : this.zzdhq, this.zzdhu, this.a.zzyr()));
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zza(zzbeu zzbeuVar) {
        this.zzeei = zzbeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zza(zzbex zzbexVar) {
        this.zzeej = zzbexVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(zzbfn zzbfnVar) {
        this.zzeer = true;
        zzbex zzbexVar = this.zzeej;
        if (zzbexVar != null) {
            zzbexVar.zzsb();
            this.zzeej = null;
        }
        zzabd();
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zza(zzty zztyVar, zzaew zzaewVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzaey zzaeyVar, com.google.android.gms.ads.internal.overlay.zzt zztVar, boolean z, @Nullable zzafq zzafqVar, com.google.android.gms.ads.internal.zzc zzcVar, zzaon zzaonVar, @Nullable zzato zzatoVar) {
        if (zzcVar == null) {
            zzcVar = new com.google.android.gms.ads.internal.zzc(this.a.getContext(), zzatoVar, null);
        }
        this.zzcxp = new zzaoe(this.a, zzaonVar);
        this.zzeeq = zzatoVar;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzciz)).booleanValue()) {
            zza("/adMetadata", new zzaet(zzaewVar));
        }
        zza("/appEvent", new zzaev(zzaeyVar));
        zza("/backButton", zzafa.zzcxd);
        zza("/refresh", zzafa.zzcxe);
        zza("/canOpenURLs", zzafa.zzcwu);
        zza("/canOpenIntents", zzafa.zzcwv);
        zza("/click", zzafa.zzcww);
        zza("/close", zzafa.zzcwx);
        zza("/customClose", zzafa.zzcwy);
        zza("/instrument", zzafa.zzcxh);
        zza("/delayPageLoaded", zzafa.zzcxj);
        zza("/delayPageClosed", zzafa.zzcxk);
        zza("/getLocationInfo", zzafa.zzcxl);
        zza("/httpTrack", zzafa.zzcwz);
        zza("/log", zzafa.zzcxa);
        zza("/mraid", new zzafs(zzcVar, this.zzcxp, zzaonVar));
        zza("/mraidLoaded", this.zzeep);
        zza("/open", new zzafr(zzcVar, this.zzcxp));
        zza("/precache", new zzbcs());
        zza("/touch", zzafa.zzcxc);
        zza("/video", zzafa.zzcxf);
        zza("/videoMeta", zzafa.zzcxg);
        if (com.google.android.gms.ads.internal.zzq.zzlo().zzab(this.a.getContext())) {
            zza("/logScionEvent", new zzafp(this.a.getContext()));
        }
        this.zzcbt = zztyVar;
        this.zzdhq = zzoVar;
        this.zzcwq = zzaewVar;
        this.zzcws = zzaeyVar;
        this.zzdhu = zztVar;
        this.zzcxo = zzcVar;
        this.zzeel = z;
    }

    public final void zza(String str, Predicate<zzafn<? super zzbdi>> predicate) {
        this.zzehu.zza(str, predicate);
    }

    public final void zza(String str, zzafn<? super zzbdi> zzafnVar) {
        this.zzehu.zza(str, zzafnVar);
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzaaf = this.a.zzaaf();
        zzty zztyVar = (!zzaaf || this.a.zzzy().zzabt()) ? this.zzcbt : null;
        zzbff zzbffVar = zzaaf ? null : new zzbff(this.a, this.zzdhq);
        zzaew zzaewVar = this.zzcwq;
        zzaey zzaeyVar = this.zzcws;
        com.google.android.gms.ads.internal.overlay.zzt zztVar = this.zzdhu;
        zzbdi zzbdiVar = this.a;
        zza(new AdOverlayInfoParcel(zztyVar, zzbffVar, zzaewVar, zzaeyVar, zztVar, zzbdiVar, z, i, str, zzbdiVar.zzyr()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzaaf = this.a.zzaaf();
        zzty zztyVar = (!zzaaf || this.a.zzzy().zzabt()) ? this.zzcbt : null;
        zzbff zzbffVar = zzaaf ? null : new zzbff(this.a, this.zzdhq);
        zzaew zzaewVar = this.zzcwq;
        zzaey zzaeyVar = this.zzcws;
        com.google.android.gms.ads.internal.overlay.zzt zztVar = this.zzdhu;
        zzbdi zzbdiVar = this.a;
        zza(new AdOverlayInfoParcel(zztyVar, zzbffVar, zzaewVar, zzaeyVar, zztVar, zzbdiVar, z, i, str, str2, zzbdiVar.zzyr()));
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final com.google.android.gms.ads.internal.zzc zzaas() {
        return this.zzcxo;
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final boolean zzaat() {
        return this.zzbmb;
    }

    public final boolean zzaau() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeem;
        }
        return z;
    }

    public final boolean zzaav() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeen;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaaw() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzaax() {
        synchronized (this.lock) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzaaz() {
        zzato zzatoVar = this.zzeeq;
        if (zzatoVar != null) {
            WebView webView = this.a.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzatoVar, 10);
                return;
            }
            zzaay();
            this.zzeeu = new zzbfc(this, zzatoVar);
            this.a.getView().addOnAttachStateChangeListener(this.zzeeu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzaba() {
        synchronized (this.lock) {
            this.zzeeo = true;
        }
        this.zzeet++;
        zzabd();
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzabb() {
        this.zzeet--;
        zzabd();
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzabc() {
        this.zzees = true;
        zzabd();
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final zzato zzabf() {
        return this.zzeeq;
    }

    public final void zzav(boolean z) {
        this.zzeel = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzb(zzbfn zzbfnVar) {
        this.zzehu.zzg(zzbfnVar.uri);
    }

    public final void zzb(String str, zzafn<? super zzbdi> zzafnVar) {
        this.zzehu.zzb(str, zzafnVar);
    }

    public final void zzba(boolean z) {
        this.zzdll = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzbb(boolean z) {
        synchronized (this.lock) {
            this.zzeem = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzbc(boolean z) {
        synchronized (this.lock) {
            this.zzeen = z;
        }
    }

    public final void zzc(boolean z, int i) {
        zzty zztyVar = (!this.a.zzaaf() || this.a.zzzy().zzabt()) ? this.zzcbt : null;
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.zzdhq;
        com.google.android.gms.ads.internal.overlay.zzt zztVar = this.zzdhu;
        zzbdi zzbdiVar = this.a;
        zza(new AdOverlayInfoParcel(zztyVar, zzoVar, zztVar, zzbdiVar, z, i, zzbdiVar.zzyr()));
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final boolean zzc(zzbfn zzbfnVar) {
        String valueOf = String.valueOf(zzbfnVar.url);
        zzavs.zzed(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbfnVar.uri;
        if (this.zzehu.zzg(uri)) {
            return true;
        }
        if (this.zzeel) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzty zztyVar = this.zzcbt;
                if (zztyVar != null) {
                    zztyVar.onAdClicked();
                    zzato zzatoVar = this.zzeeq;
                    if (zzatoVar != null) {
                        zzatoVar.zzdv(zzbfnVar.url);
                    }
                    this.zzcbt = null;
                }
                return false;
            }
        }
        if (this.a.getWebView().willNotDraw()) {
            String valueOf2 = String.valueOf(zzbfnVar.url);
            zzayu.zzez(valueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf2) : new String("AdWebView unable to handle URL: "));
        } else {
            try {
                zzdq zzaad = this.a.zzaad();
                if (zzaad != null && zzaad.zzb(uri)) {
                    uri = zzaad.zza(uri, this.a.getContext(), this.a.getView(), this.a.zzyn());
                }
            } catch (zzdt unused) {
                String valueOf3 = String.valueOf(zzbfnVar.url);
                zzayu.zzez(valueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf3) : new String("Unable to append parameter to URL: "));
            }
            com.google.android.gms.ads.internal.zzc zzcVar = this.zzcxo;
            if (zzcVar == null || zzcVar.zzjq()) {
                zza(new com.google.android.gms.ads.internal.overlay.zzd("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzcxo.zzbq(zzbfnVar.url);
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    @Nullable
    public final WebResourceResponse zzd(zzbfn zzbfnVar) {
        WebResourceResponse zzd;
        zzrx zza;
        zzato zzatoVar = this.zzeeq;
        if (zzatoVar != null) {
            zzatoVar.zza(zzbfnVar.url, zzbfnVar.zzab, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(zzbfnVar.url).getName())) {
            zztn();
            String str = (String) zzve.zzoy().zzd(this.a.zzzy().zzabt() ? zzzn.zzchn : this.a.zzaaf() ? zzzn.zzchm : zzzn.zzchl);
            com.google.android.gms.ads.internal.zzq.zzkq();
            zzd = zzawb.zzd(this.a.getContext(), this.a.zzyr().zzbma, str);
        } else {
            zzd = null;
        }
        if (zzd != null) {
            return zzd;
        }
        try {
            if (!zzauk.zzb(zzbfnVar.url, this.a.getContext(), this.zzdll).equals(zzbfnVar.url)) {
                return zze(zzbfnVar);
            }
            zzry zzby = zzry.zzby(zzbfnVar.url);
            if (zzby != null && (zza = com.google.android.gms.ads.internal.zzq.zzkw().zza(zzby)) != null && zza.zzmp()) {
                return new WebResourceResponse("", "", zza.zzmq());
            }
            if (zzayo.isEnabled() && zzaax.zzcte.get().booleanValue()) {
                return zze(zzbfnVar);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AdWebViewClient.interceptRequest");
            return zzabe();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzh(Uri uri) {
        this.zzehu.zzh(uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzi(int i, int i2) {
        zzaoe zzaoeVar = this.zzcxp;
        if (zzaoeVar != null) {
            zzaoeVar.zzi(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zztn() {
        synchronized (this.lock) {
            this.zzeel = false;
            this.zzbmb = true;
            zzazd.zzdwi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbfa
                private final zzbfb zzeht;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeht = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbfb zzbfbVar = this.zzeht;
                    zzbfbVar.a.zzaaj();
                    com.google.android.gms.ads.internal.overlay.zzc zzzw = zzbfbVar.a.zzzw();
                    if (zzzw != null) {
                        zzzw.zztn();
                    }
                }
            });
        }
    }
}
