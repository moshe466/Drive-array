package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzso;
import com.google.android.gms.internal.ads.zzsy;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class zzbfg extends zzbfm implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzaia, zzbdi {
    private int maxHeight;
    private int maxWidth;

    @GuardedBy("this")
    private String zzabg;
    private final zzazb zzbll;
    private final WindowManager zzbnl;
    private int zzdgf;
    private int zzdgg;

    @GuardedBy("this")
    private boolean zzdhs;

    @GuardedBy("this")
    private String zzdiy;
    private zzaac zzeao;
    private final zzsm zzeeg;
    private final zzbez zzefu;

    @Nullable
    private final zzdq zzefv;
    private final com.google.android.gms.ads.internal.zzi zzefw;
    private final com.google.android.gms.ads.internal.zza zzefx;

    @Nullable
    private final zzro zzefz;
    private final boolean zzega;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzc zzege;

    @GuardedBy("this")
    private zzbey zzegg;

    @GuardedBy("this")
    private boolean zzegi;

    @GuardedBy("this")
    private boolean zzegj;

    @GuardedBy("this")
    private int zzegk;

    @GuardedBy("this")
    private boolean zzegl;

    @GuardedBy("this")
    private boolean zzegm;

    @GuardedBy("this")
    private zzbed zzegn;

    @GuardedBy("this")
    private boolean zzego;

    @GuardedBy("this")
    private boolean zzegp;

    @GuardedBy("this")
    private zzabw zzegq;

    @GuardedBy("this")
    private zzabr zzegr;

    @GuardedBy("this")
    private zzra zzegs;

    @GuardedBy("this")
    private int zzegt;

    @GuardedBy("this")
    private int zzegu;
    private zzaac zzegv;
    private zzaac zzegw;
    private zzaab zzegx;
    private WeakReference<View.OnClickListener> zzegy;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzc zzegz;
    private zzayl zzehb;
    private Map<String, zzbcn> zzehc;
    private final zzbfb zzehw;
    private final AtomicReference<IObjectWrapper> zzehx;
    private final DisplayMetrics zzwe;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public zzbfg(zzbez zzbezVar, zzbfb zzbfbVar, zzbey zzbeyVar, String str, boolean z, boolean z2, @Nullable zzdq zzdqVar, zzazb zzazbVar, zzaae zzaaeVar, com.google.android.gms.ads.internal.zzi zziVar, com.google.android.gms.ads.internal.zza zzaVar, zzsm zzsmVar, zzro zzroVar, boolean z3) {
        super(zzbezVar, zzbfbVar);
        this.zzegl = true;
        this.zzegm = false;
        this.zzdiy = "";
        this.zzehx = new AtomicReference<>();
        this.zzdgg = -1;
        this.zzdgf = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.zzefu = zzbezVar;
        this.zzehw = zzbfbVar;
        this.zzegg = zzbeyVar;
        this.zzabg = str;
        this.zzegi = z;
        this.zzegk = -1;
        this.zzefv = zzdqVar;
        this.zzbll = zzazbVar;
        this.zzefw = zziVar;
        this.zzefx = zzaVar;
        this.zzbnl = (WindowManager) getContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzq.zzkq();
        this.zzwe = zzawb.zza(this.zzbnl);
        this.zzeeg = zzsmVar;
        this.zzefz = zzroVar;
        this.zzega = z3;
        this.zzehb = new zzayl(this.zzefu.zzyn(), this, this, null);
        com.google.android.gms.ads.internal.zzq.zzkq().zza(zzbezVar, zzazbVar.zzbma, getSettings());
        setDownloadListener(this);
        zzabj();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbee.zzc(this), "googleAdsJsInterface");
        }
        zzabn();
        this.zzegx = new zzaab(new zzaae(true, "make_wv", this.zzabg));
        this.zzegx.zzqp().zzc(zzaaeVar);
        this.zzeao = zzzv.zzb(this.zzegx.zzqp());
        this.zzegx.zza("native:view_create", this.zzeao);
        this.zzegw = null;
        this.zzegv = null;
        com.google.android.gms.ads.internal.zzq.zzks().zzbc(zzbezVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(boolean z, int i, zztu zztuVar) {
        zzsy.zzw.zza zzog = zzsy.zzw.zzog();
        if (zzog.zzof() != z) {
            zzog.zzw(z);
        }
        zztuVar.zzcba = (zzsy.zzw) zzog.zzci(i).zzbaf();
    }

    private final boolean zzabg() {
        int i;
        int i2;
        if (!this.zzehw.zzaat() && !this.zzehw.zzaau()) {
            return false;
        }
        zzve.zzou();
        DisplayMetrics displayMetrics = this.zzwe;
        int zzb = zzayk.zzb(displayMetrics, displayMetrics.widthPixels);
        zzve.zzou();
        DisplayMetrics displayMetrics2 = this.zzwe;
        int zzb2 = zzayk.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzyn = this.zzefu.zzyn();
        if (zzyn == null || zzyn.getWindow() == null) {
            i = zzb;
            i2 = zzb2;
        } else {
            com.google.android.gms.ads.internal.zzq.zzkq();
            int[] zzd = zzawb.zzd(zzyn);
            zzve.zzou();
            int zzb3 = zzayk.zzb(this.zzwe, zzd[0]);
            zzve.zzou();
            i2 = zzayk.zzb(this.zzwe, zzd[1]);
            i = zzb3;
        }
        if (this.zzdgf == zzb && this.zzdgg == zzb2 && this.maxWidth == i && this.maxHeight == i2) {
            return false;
        }
        boolean z = (this.zzdgf == zzb && this.zzdgg == zzb2) ? false : true;
        this.zzdgf = zzb;
        this.zzdgg = zzb2;
        this.maxWidth = i;
        this.maxHeight = i2;
        new zzaoo(this).zza(zzb, zzb2, i, i2, this.zzwe.density, this.zzbnl.getDefaultDisplay().getRotation());
        return z;
    }

    private final void zzabi() {
        zzzv.zza(this.zzegx.zzqp(), this.zzeao, "aeh2");
    }

    private final synchronized void zzabj() {
        if (!this.zzegi && !this.zzegg.zzabt()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzayu.zzea("Disabling hardware acceleration on an AdView.");
                zzabk();
                return;
            } else {
                zzayu.zzea("Enabling hardware acceleration on an AdView.");
                zzabl();
                return;
            }
        }
        zzayu.zzea("Enabling hardware acceleration on an overlay.");
        zzabl();
    }

    private final synchronized void zzabk() {
        if (!this.zzegj) {
            com.google.android.gms.ads.internal.zzq.zzks();
            setLayerType(1, null);
        }
        this.zzegj = true;
    }

    private final synchronized void zzabl() {
        if (this.zzegj) {
            com.google.android.gms.ads.internal.zzq.zzks();
            setLayerType(0, null);
        }
        this.zzegj = false;
    }

    private final synchronized void zzabm() {
        if (this.zzehc != null) {
            Iterator<zzbcn> it = this.zzehc.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
        this.zzehc = null;
    }

    private final void zzabn() {
        zzaae zzqp;
        zzaab zzaabVar = this.zzegx;
        if (zzaabVar == null || (zzqp = zzaabVar.zzqp()) == null || com.google.android.gms.ads.internal.zzq.zzku().zzuz() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzku().zzuz().zza(zzqp);
    }

    private final void zzbd(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzahz.zza(this, "onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfm
    protected final synchronized void a(boolean z) {
        if (!z) {
            zzabn();
            this.zzehb.zzxh();
            if (this.zzege != null) {
                this.zzege.close();
                this.zzege.onDestroy();
                this.zzege = null;
            }
        }
        this.zzehx.set(null);
        this.zzehw.destroy();
        com.google.android.gms.ads.internal.zzq.zzlm();
        zzbck.zzc(this);
        zzabm();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbes
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final WebView getWebView() {
        return this;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzehb.onAttachedToWindow();
        }
        boolean z = this.zzego;
        if (this.zzehw != null && this.zzehw.zzaau()) {
            if (!this.zzegp) {
                this.zzehw.zzaaw();
                this.zzehw.zzaax();
                this.zzegp = true;
            }
            zzabg();
            z = true;
        }
        zzbd(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzehb.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzegp && this.zzehw != null && this.zzehw.zzaau() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzehw.zzaaw();
                this.zzehw.zzaax();
                this.zzegp = false;
            }
        }
        zzbd(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzq.zzkq();
            zzawb.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzayu.zzea(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbfm, android.webkit.WebView, android.view.View
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zzabg = zzabg();
        com.google.android.gms.ads.internal.overlay.zzc zzzw = zzzw();
        if (zzzw == null || !zzabg) {
            return;
        }
        zzzw.zztq();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d8 A[Catch: all -> 0x01f3, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0155, B:94:0x0172, B:96:0x01cf, B:97:0x01d3, B:100:0x01d8, B:102:0x01de, B:103:0x01e1, B:109:0x01ee), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141 A[Catch: all -> 0x01f3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0155, B:94:0x0172, B:96:0x01cf, B:97:0x01d3, B:100:0x01d8, B:102:0x01de, B:103:0x01e1, B:109:0x01ee), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0172 A[Catch: all -> 0x01f3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0155, B:94:0x0172, B:96:0x01cf, B:97:0x01d3, B:100:0x01d8, B:102:0x01de, B:103:0x01e1, B:109:0x01ee), top: B:2:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfg.onMeasure(int, int):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbfm, android.webkit.WebView, com.google.android.gms.internal.ads.zzbdi
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzayu.zzc("Could not pause webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfm, android.webkit.WebView, com.google.android.gms.internal.ads.zzbdi
    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzayu.zzc("Could not resume webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfm, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzehw.zzaau() || this.zzehw.zzaav()) {
            zzdq zzdqVar = this.zzefv;
            if (zzdqVar != null) {
                zzdqVar.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                if (this.zzegq != null) {
                    this.zzegq.zzc(motionEvent);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdi
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzegy = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void setRequestedOrientation(int i) {
        this.zzegk = i;
        if (this.zzege != null) {
            this.zzege.setRequestedOrientation(this.zzegk);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfm, android.webkit.WebView
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzayu.zzc("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzaar()) {
            zzavs.zzed("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzavs.zzed("Initializing ArWebView object.");
        this.zzefz.zza(activity, this);
        this.zzefz.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.zzefz.getView());
        } else {
            zzayu.zzex("The FrameLayout object cannot be null.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzege = zzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzehw.zza(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zza(zzabr zzabrVar) {
        this.zzegr = zzabrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zza(zzabw zzabwVar) {
        this.zzegq = zzabwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final synchronized void zza(zzbed zzbedVar) {
        if (this.zzegn != null) {
            zzayu.zzex("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzegn = zzbedVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zza(zzbey zzbeyVar) {
        this.zzegg = zzbeyVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final void zza(zzpt zzptVar) {
        synchronized (this) {
            this.zzego = zzptVar.zzbnq;
        }
        zzbd(zzptVar.zzbnq);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zza(zzra zzraVar) {
        this.zzegs = zzraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(String str, Predicate<zzafn<? super zzbdi>> predicate) {
        zzbfb zzbfbVar = this.zzehw;
        if (zzbfbVar != null) {
            zzbfbVar.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(String str, zzafn<? super zzbdi> zzafnVar) {
        zzbfb zzbfbVar = this.zzehw;
        if (zzbfbVar != null) {
            zzbfbVar.zza(str, zzafnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final synchronized void zza(String str, zzbcn zzbcnVar) {
        if (this.zzehc == null) {
            this.zzehc = new HashMap();
        }
        this.zzehc.put(str, zzbcnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahs
    public final void zza(String str, Map map) {
        zzahz.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zza(String str, JSONObject jSONObject) {
        zzahz.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zza(boolean z, int i, String str) {
        this.zzehw.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzehw.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zzahz.zza(this, "onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final /* synthetic */ zzbev zzaaa() {
        return this.zzehw;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final WebViewClient zzaab() {
        return this.zzehw;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized boolean zzaac() {
        return this.zzdhs;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbeq
    public final zzdq zzaad() {
        return this.zzefv;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final IObjectWrapper zzaae() {
        return this.zzehx.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbel
    public final synchronized boolean zzaaf() {
        return this.zzegi;
    }

    @Override // com.google.android.gms.internal.ads.zzbfm, com.google.android.gms.internal.ads.zzbdi
    public final void zzaag() {
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized boolean zzaah() {
        return this.zzegl;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized boolean zzaai() {
        return this.zzegt > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaaj() {
        this.zzehb.zzxg();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaak() {
        if (this.zzegw == null) {
            this.zzegw = zzzv.zzb(this.zzegx.zzqp());
            this.zzegx.zza("native:view_load", this.zzegw);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized zzabw zzaal() {
        return this.zzegq;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaam() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaan() {
        zzavs.zzed("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized zzra zzaao() {
        return this.zzegs;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzaap() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final zzro zzaaq() {
        return this.zzefz;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzaar() {
        return ((Boolean) zzve.zzoy().zzd(zzzn.zzcqj)).booleanValue() && this.zzefz != null && this.zzega;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zzal(boolean z) {
        if (this.zzege != null) {
            this.zzege.zza(this.zzehw.zzaat(), z);
        } else {
            this.zzdhs = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzan(IObjectWrapper iObjectWrapper) {
        this.zzehx.set(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzav(boolean z) {
        this.zzehw.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zzax(boolean z) {
        boolean z2 = z != this.zzegi;
        this.zzegi = z;
        zzabj();
        if (z2) {
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzchp)).booleanValue() || !this.zzegg.zzabt()) {
                new zzaoo(this).zzdu(z ? "expanded" : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zzay(boolean z) {
        this.zzegl = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zzaz(boolean z) {
        this.zzegt += z ? 1 : -1;
        if (this.zzegt <= 0 && this.zzege != null) {
            this.zzege.zztt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzegz = zzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzb(String str, zzafn<? super zzbdi> zzafnVar) {
        zzbfb zzbfbVar = this.zzehw;
        if (zzbfbVar != null) {
            zzbfbVar.zzb(str, zzafnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        super.loadDataWithBaseURL(str, zzbeo.zzf(str2, zzbeo.zzabp()), "text/html", HttpRequest.CHARSET_UTF8, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzahs
    public final void zzb(String str, JSONObject jSONObject) {
        zzahz.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzb(final boolean z, final int i) {
        destroy();
        this.zzeeg.zza(new zzsp(z, i) { // from class: com.google.android.gms.internal.ads.zzbfj
            private final int zzdtf;
            private final boolean zzeft;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeft = z;
                this.zzdtf = i;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                zzbfg.a(this.zzeft, this.zzdtf, zztuVar);
            }
        });
        this.zzeeg.zza(zzso.zza.EnumC0023zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzba(boolean z) {
        this.zzehw.zzba(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzbr(Context context) {
        this.zzefu.setBaseContext(context);
        this.zzehb.zzh(this.zzefu.zzyn());
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zzc(boolean z, int i) {
        this.zzehw.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfm, com.google.android.gms.internal.ads.zzbfl, com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzaip
    public final synchronized void zzcy(String str) {
        if (isDestroyed()) {
            zzayu.zzez("The webview is destroyed. Ignoring action.");
        } else {
            super.zzcy(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzde(int i) {
        if (i == 0) {
            zzzv.zza(this.zzegx.zzqp(), this.zzeao, "aebb2");
        }
        zzabi();
        if (this.zzegx.zzqp() != null) {
            this.zzegx.zzqp().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbll.zzbma);
        zzahz.zza(this, "onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final synchronized zzbcn zzfe(String str) {
        if (this.zzehc == null) {
            return null;
        }
        return this.zzehc.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zzj(String str, String str2) {
        zzahz.zza(this, str, str2);
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final synchronized void zzjv() {
        this.zzegm = true;
        if (this.zzefw != null) {
            this.zzefw.zzjv();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final synchronized void zzjw() {
        this.zzegm = false;
        if (this.zzefw != null) {
            this.zzefw.zzjw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zztr() {
        if (this.zzegv == null) {
            zzzv.zza(this.zzegx.zzqp(), this.zzeao, "aes2");
            this.zzegv = zzzv.zzb(this.zzegx.zzqp());
            this.zzegx.zza("native:view_show", this.zzegv);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbll.zzbma);
        zzahz.zza(this, "onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzts() {
        com.google.android.gms.ads.internal.overlay.zzc zzzw = zzzw();
        if (zzzw != null) {
            zzzw.zzts();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final zzbao zzyk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final synchronized zzbed zzyl() {
        return this.zzegn;
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final zzaac zzym() {
        return this.zzeao;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz, com.google.android.gms.internal.ads.zzbei
    public final Activity zzyn() {
        return this.zzefu.zzyn();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final com.google.android.gms.ads.internal.zza zzyo() {
        return this.zzefx;
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final synchronized String zzyp() {
        return this.zzdiy;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final zzaab zzyq() {
        return this.zzegx;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz, com.google.android.gms.internal.ads.zzbet
    public final zzazb zzyr() {
        return this.zzbll;
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final int zzys() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final int zzyt() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final synchronized void zzyu() {
        if (this.zzegr != null) {
            this.zzegr.zzrb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzzt() {
        zzabi();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbll.zzbma);
        zzahz.zza(this, "onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzzu() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzq.zzkv().zzpf()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzq.zzkv().zzpe()));
        hashMap.put("device_volume", String.valueOf(zzawq.zzbe(getContext())));
        zzahz.zza(this, "volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final Context zzzv() {
        return this.zzefu.zzzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized com.google.android.gms.ads.internal.overlay.zzc zzzw() {
        return this.zzege;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized com.google.android.gms.ads.internal.overlay.zzc zzzx() {
        return this.zzegz;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzber
    public final synchronized zzbey zzzy() {
        return this.zzegg;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final synchronized String zzzz() {
        return this.zzabg;
    }
}
