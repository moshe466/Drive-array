package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzso;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbdl extends WebViewClient implements zzbev {
    protected zzbdi a;

    @Nullable
    protected zzato b;
    private final Object lock;

    @GuardedBy("lock")
    private boolean zzbmb;
    private zzty zzcbt;
    private zzaew zzcwq;
    private zzaey zzcws;
    private com.google.android.gms.ads.internal.zzc zzcxo;
    private zzaoe zzcxp;
    private com.google.android.gms.ads.internal.overlay.zzo zzdhq;
    private com.google.android.gms.ads.internal.overlay.zzt zzdhu;
    private boolean zzdll;

    @Nullable
    private final zzsm zzeeg;
    private final HashMap<String, List<zzafn<? super zzbdi>>> zzeeh;
    private zzbeu zzeei;
    private zzbex zzeej;
    private zzbew zzeek;
    private boolean zzeel;

    @GuardedBy("lock")
    private boolean zzeem;

    @GuardedBy("lock")
    private boolean zzeen;

    @GuardedBy("lock")
    private boolean zzeeo;
    private final zzaol zzeep;
    private boolean zzeer;
    private boolean zzees;
    private int zzeet;
    private View.OnAttachStateChangeListener zzeeu;

    public zzbdl(zzbdi zzbdiVar, zzsm zzsmVar, boolean z) {
        this(zzbdiVar, zzsmVar, z, new zzaol(zzbdiVar, zzbdiVar.zzzv(), new zzyy(zzbdiVar.getContext())), null);
    }

    @VisibleForTesting
    private zzbdl(zzbdi zzbdiVar, zzsm zzsmVar, boolean z, zzaol zzaolVar, zzaoe zzaoeVar) {
        this.zzeeh = new HashMap<>();
        this.lock = new Object();
        this.zzeel = false;
        this.zzeeg = zzsmVar;
        this.a = zzbdiVar;
        this.zzbmb = z;
        this.zzeep = zzaolVar;
        this.zzcxp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzato zzatoVar, int i) {
        if (!zzatoVar.zzul() || i <= 0) {
            return;
        }
        zzatoVar.zzj(view);
        if (zzatoVar.zzul()) {
            zzawb.zzdsr.postDelayed(new zzbdm(this, view, zzatoVar, i), 100L);
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        zzaoe zzaoeVar = this.zzcxp;
        boolean zztg = zzaoeVar != null ? zzaoeVar.zztg() : false;
        com.google.android.gms.ads.internal.zzq.zzkp();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.a.getContext(), adOverlayInfoParcel, !zztg);
        if (this.b != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzdVar = adOverlayInfoParcel.zzdhp) != null) {
                str = zzdVar.url;
            }
            this.b.zzdv(str);
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

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ee, code lost:
    
        com.google.android.gms.ads.internal.zzq.zzkq();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f5, code lost:
    
        return com.google.android.gms.internal.ads.zzawb.zzd(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse zze(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdl.zze(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse a(String str, Map<String, String> map) {
        zzrx zza;
        try {
            String zzb = zzauk.zzb(str, this.a.getContext(), this.zzdll);
            if (!zzb.equals(str)) {
                return zze(zzb, map);
            }
            zzry zzby = zzry.zzby(str);
            if (zzby != null && (zza = com.google.android.gms.ads.internal.zzq.zzkw().zza(zzby)) != null && zza.zzmp()) {
                return new WebResourceResponse("", "", zza.zzmq());
            }
            if (zzayo.isEnabled() && zzaax.zzcte.get().booleanValue()) {
                return zze(str, map);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AdWebViewClient.interceptRequest");
            return zzabe();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzavs.zzed(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.lock) {
            if (this.a.isDestroyed()) {
                zzavs.zzed("Blank page loaded, 1...");
                this.a.zzaag();
                return;
            }
            this.zzeer = true;
            zzbex zzbexVar = this.zzeej;
            if (zzbexVar != null) {
                zzbexVar.zzsb();
                this.zzeej = null;
            }
            zzabd();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzro zzaaq = this.a.zzaaq();
        if (zzaaq != null && webView == zzaaq.getWebView()) {
            zzaaq.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.a.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void reset() {
        zzato zzatoVar = this.b;
        if (zzatoVar != null) {
            zzatoVar.zzun();
            this.b = null;
        }
        zzaay();
        synchronized (this.lock) {
            this.zzeeh.clear();
            this.zzcbt = null;
            this.zzdhq = null;
            this.zzeei = null;
            this.zzeej = null;
            this.zzcwq = null;
            this.zzcws = null;
            this.zzeel = false;
            this.zzbmb = false;
            this.zzeem = false;
            this.zzeeo = false;
            this.zzdhu = null;
            this.zzeek = null;
            if (this.zzcxp != null) {
                this.zzcxp.zzac(true);
                this.zzcxp = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzavs.zzed(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else {
            if (this.zzeel && webView == this.a.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzty zztyVar = this.zzcbt;
                    if (zztyVar != null) {
                        zztyVar.onAdClicked();
                        zzato zzatoVar = this.b;
                        if (zzatoVar != null) {
                            zzatoVar.zzdv(str);
                        }
                        this.zzcbt = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.a.getWebView().willNotDraw()) {
                String valueOf2 = String.valueOf(str);
                zzayu.zzez(valueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf2) : new String("AdWebView unable to handle URL: "));
            } else {
                try {
                    zzdq zzaad = this.a.zzaad();
                    if (zzaad != null && zzaad.zzb(parse)) {
                        parse = zzaad.zza(parse, this.a.getContext(), this.a.getView(), this.a.zzyn());
                    }
                } catch (zzdt unused) {
                    String valueOf3 = String.valueOf(str);
                    zzayu.zzez(valueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf3) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zzc zzcVar = this.zzcxo;
                if (zzcVar == null || zzcVar.zzjq()) {
                    zza(new com.google.android.gms.ads.internal.overlay.zzd("android.intent.action.VIEW", parse.toString(), null, null, null, null, null));
                } else {
                    this.zzcxo.zzbq(str);
                }
            }
        }
        return true;
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

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zza(zzty zztyVar, zzaew zzaewVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzaey zzaeyVar, com.google.android.gms.ads.internal.overlay.zzt zztVar, boolean z, @Nullable zzafq zzafqVar, com.google.android.gms.ads.internal.zzc zzcVar, zzaon zzaonVar, @Nullable zzato zzatoVar) {
        if (zzcVar == null) {
            zzcVar = new com.google.android.gms.ads.internal.zzc(this.a.getContext(), zzatoVar, null);
        }
        this.zzcxp = new zzaoe(this.a, zzaonVar);
        this.b = zzatoVar;
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
        synchronized (this.lock) {
            List<zzafn<? super zzbdi>> list = this.zzeeh.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzafn<? super zzbdi> zzafnVar : list) {
                if (predicate.apply(zzafnVar)) {
                    arrayList.add(zzafnVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void zza(String str, zzafn<? super zzbdi> zzafnVar) {
        synchronized (this.lock) {
            List<zzafn<? super zzbdi>> list = this.zzeeh.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzeeh.put(str, list);
            }
            list.add(zzafnVar);
        }
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzaaf = this.a.zzaaf();
        zzty zztyVar = (!zzaaf || this.a.zzzy().zzabt()) ? this.zzcbt : null;
        zzbdo zzbdoVar = zzaaf ? null : new zzbdo(this.a, this.zzdhq);
        zzaew zzaewVar = this.zzcwq;
        zzaey zzaeyVar = this.zzcws;
        com.google.android.gms.ads.internal.overlay.zzt zztVar = this.zzdhu;
        zzbdi zzbdiVar = this.a;
        zza(new AdOverlayInfoParcel(zztyVar, zzbdoVar, zzaewVar, zzaeyVar, zztVar, zzbdiVar, z, i, str, zzbdiVar.zzyr()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzaaf = this.a.zzaaf();
        zzty zztyVar = (!zzaaf || this.a.zzzy().zzabt()) ? this.zzcbt : null;
        zzbdo zzbdoVar = zzaaf ? null : new zzbdo(this.a, this.zzdhq);
        zzaew zzaewVar = this.zzcwq;
        zzaey zzaeyVar = this.zzcws;
        com.google.android.gms.ads.internal.overlay.zzt zztVar = this.zzdhu;
        zzbdi zzbdiVar = this.a;
        zza(new AdOverlayInfoParcel(zztyVar, zzbdoVar, zzaewVar, zzaeyVar, zztVar, zzbdiVar, z, i, str, str2, zzbdiVar.zzyr()));
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final com.google.android.gms.ads.internal.zzc zzaas() {
        return this.zzcxo;
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final boolean zzaat() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbmb;
        }
        return z;
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
        zzato zzatoVar = this.b;
        if (zzatoVar != null) {
            WebView webView = this.a.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzatoVar, 10);
                return;
            }
            zzaay();
            this.zzeeu = new zzbdp(this, zzatoVar);
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
        zzsm zzsmVar = this.zzeeg;
        if (zzsmVar != null) {
            zzsmVar.zza(zzso.zza.EnumC0023zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzees = true;
        zzabd();
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcpe)).booleanValue()) {
            this.a.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final zzato zzabf() {
        return this.b;
    }

    public final void zzav(boolean z) {
        this.zzeel = z;
    }

    public final void zzb(String str, zzafn<? super zzbdi> zzafnVar) {
        synchronized (this.lock) {
            List<zzafn<? super zzbdi>> list = this.zzeeh.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzafnVar);
        }
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

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzh(Uri uri) {
        final String path = uri.getPath();
        List<zzafn<? super zzbdi>> list = this.zzeeh.get(path);
        if (list == null) {
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
            sb.append("No GMSG handler found for GMSG: ");
            sb.append(valueOf);
            zzavs.zzed(sb.toString());
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcre)).booleanValue() || com.google.android.gms.ads.internal.zzq.zzku().zzuz() == null) {
                return;
            }
            zzazd.zzdwe.execute(new Runnable(path) { // from class: com.google.android.gms.internal.ads.zzbdn
                private final String zzcyz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcyz = path;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzq.zzku().zzuz().zzcr(this.zzcyz.substring(1));
                }
            });
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzkq();
        Map<String, String> zzi = zzawb.zzi(uri);
        if (zzayu.isLoggable(2)) {
            String valueOf2 = String.valueOf(path);
            zzavs.zzed(valueOf2.length() != 0 ? "Received GMSG: ".concat(valueOf2) : new String("Received GMSG: "));
            for (String str : zzi.keySet()) {
                String str2 = zzi.get(str);
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length());
                sb2.append("  ");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                zzavs.zzed(sb2.toString());
            }
        }
        Iterator<zzafn<? super zzbdi>> it = list.iterator();
        while (it.hasNext()) {
            it.next().zza(this.a, zzi);
        }
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
            zzazd.zzdwi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdk
                private final zzbdl zzeee;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeee = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbdl zzbdlVar = this.zzeee;
                    zzbdlVar.a.zzaaj();
                    com.google.android.gms.ads.internal.overlay.zzc zzzw = zzbdlVar.a.zzzw();
                    if (zzzw != null) {
                        zzzw.zztn();
                    }
                }
            });
        }
    }
}
