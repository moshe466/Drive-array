package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaoo;
import com.google.android.gms.internal.ads.zzaos;
import com.google.android.gms.internal.ads.zzawb;
import com.google.android.gms.internal.ads.zzawh;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzbdi;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzn;
import java.util.Collections;

/* loaded from: classes.dex */
public class zzc extends zzaos implements zzy {

    @VisibleForTesting
    private static final int zzdgm = Color.argb(0, 0, 0, 0);
    protected final Activity a;

    @VisibleForTesting
    AdOverlayInfoParcel b;

    @VisibleForTesting
    zzbdi c;

    @VisibleForTesting
    private zzi zzdgo;

    @VisibleForTesting
    private zzq zzdgp;

    @VisibleForTesting
    private FrameLayout zzdgr;

    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdgs;

    @VisibleForTesting
    private zzj zzdgu;
    private Runnable zzdgy;
    private boolean zzdgz;
    private boolean zzdha;

    @VisibleForTesting
    private boolean zzdgq = false;

    @VisibleForTesting
    private boolean zzdgt = false;

    @VisibleForTesting
    private boolean zzbkx = false;

    @VisibleForTesting
    private boolean zzdgv = false;

    @VisibleForTesting
    int d = 0;
    private final Object zzdgx = new Object();
    private boolean zzdhb = false;
    private boolean zzdhc = false;
    private boolean zzdhd = true;

    public zzc(Activity activity) {
        this.a = activity;
    }

    private final void zza(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzg zzgVar;
        com.google.android.gms.ads.internal.zzg zzgVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.b;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || (zzgVar2 = adOverlayInfoParcel2.zzdhx) == null || !zzgVar2.zzbky) ? false : true;
        boolean zza = com.google.android.gms.ads.internal.zzq.zzks().zza(this.a, configuration);
        if ((this.zzbkx && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && (adOverlayInfoParcel = this.b) != null && (zzgVar = adOverlayInfoParcel.zzdhx) != null && zzgVar.zzbld) {
            z2 = true;
        }
        Window window = this.a.getWindow();
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcjj)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
            return;
        }
        if (!z) {
            window.addFlags(2048);
            window.clearFlags(1024);
            return;
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        if (Build.VERSION.SDK_INT < 19 || !z2) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
    }

    private final void zzai(boolean z) {
        int intValue = ((Integer) zzve.zzoy().zzd(zzzn.zzcnv)).intValue();
        zzp zzpVar = new zzp();
        zzpVar.size = 50;
        zzpVar.paddingLeft = z ? intValue : 0;
        zzpVar.paddingRight = z ? 0 : intValue;
        zzpVar.paddingTop = 0;
        zzpVar.paddingBottom = intValue;
        this.zzdgp = new zzq(this.a, zzpVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.b.zzdhs);
        this.zzdgu.addView(this.zzdgp, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (r19.a.getResources().getConfiguration().orientation == 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r19.zzdgv = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        if (r19.a.getResources().getConfiguration().orientation == 2) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzaj(boolean r20) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zzaj(boolean):void");
    }

    private static void zzc(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzlf().zza(iObjectWrapper, view);
    }

    private final void zzto() {
        if (!this.a.isFinishing() || this.zzdhb) {
            return;
        }
        this.zzdhb = true;
        zzbdi zzbdiVar = this.c;
        if (zzbdiVar != null) {
            zzbdiVar.zzde(this.d);
            synchronized (this.zzdgx) {
                if (!this.zzdgz && this.c.zzaai()) {
                    this.zzdgy = new Runnable(this) { // from class: com.google.android.gms.ads.internal.overlay.zze
                        private final zzc zzdhi;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdhi = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzdhi.c();
                        }
                    };
                    zzawb.zzdsr.postDelayed(this.zzdgy, ((Long) zzve.zzoy().zzd(zzzn.zzcjg)).longValue());
                    return;
                }
            }
        }
        c();
    }

    private final void zztr() {
        this.c.zztr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void c() {
        zzbdi zzbdiVar;
        zzo zzoVar;
        if (this.zzdhc) {
            return;
        }
        this.zzdhc = true;
        zzbdi zzbdiVar2 = this.c;
        if (zzbdiVar2 != null) {
            this.zzdgu.removeView(zzbdiVar2.getView());
            zzi zziVar = this.zzdgo;
            if (zziVar != null) {
                this.c.zzbr(zziVar.zzup);
                this.c.zzax(false);
                ViewGroup viewGroup = this.zzdgo.parent;
                View view = this.c.getView();
                zzi zziVar2 = this.zzdgo;
                viewGroup.addView(view, zziVar2.index, zziVar2.zzdhj);
                this.zzdgo = null;
            } else if (this.a.getApplicationContext() != null) {
                this.c.zzbr(this.a.getApplicationContext());
            }
            this.c = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.b;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzdhq) != null) {
            zzoVar.zzte();
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.b;
        if (adOverlayInfoParcel2 == null || (zzbdiVar = adOverlayInfoParcel2.zzcza) == null) {
            return;
        }
        zzc(zzbdiVar.zzaae(), this.b.zzcza.getView());
    }

    public final void close() {
        this.d = 2;
        this.a.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onBackPressed() {
        this.d = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public void onCreate(Bundle bundle) {
        this.a.requestWindowFeature(1);
        this.zzdgt = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.b = AdOverlayInfoParcel.zzc(this.a.getIntent());
            if (this.b == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (this.b.zzbll.zzdwa > 7500000) {
                this.d = 3;
            }
            if (this.a.getIntent() != null) {
                this.zzdhd = this.a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.b.zzdhx != null) {
                this.zzbkx = this.b.zzdhx.zzbkx;
            } else {
                this.zzbkx = false;
            }
            if (this.zzbkx && this.b.zzdhx.zzblc != -1) {
                new zzl(this).zzvr();
            }
            if (bundle == null) {
                if (this.b.zzdhq != null && this.zzdhd) {
                    this.b.zzdhq.zztf();
                }
                if (this.b.zzdhv != 1 && this.b.zzcbt != null) {
                    this.b.zzcbt.onAdClicked();
                }
            }
            this.zzdgu = new zzj(this.a, this.b.zzdhw, this.b.zzbll.zzbma);
            this.zzdgu.setId(1000);
            com.google.android.gms.ads.internal.zzq.zzks().zzg(this.a);
            int i = this.b.zzdhv;
            if (i == 1) {
                zzaj(false);
                return;
            }
            if (i == 2) {
                this.zzdgo = new zzi(this.b.zzcza);
                zzaj(false);
            } else {
                if (i != 3) {
                    throw new zzg("Could not determine ad overlay type.");
                }
                zzaj(true);
            }
        } catch (zzg e) {
            zzayu.zzez(e.getMessage());
            this.d = 3;
            this.a.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onDestroy() {
        zzbdi zzbdiVar = this.c;
        if (zzbdiVar != null) {
            try {
                this.zzdgu.removeView(zzbdiVar.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzto();
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onPause() {
        zztk();
        zzo zzoVar = this.b.zzdhq;
        if (zzoVar != null) {
            zzoVar.onPause();
        }
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcnt)).booleanValue() && this.c != null && (!this.a.isFinishing() || this.zzdgo == null)) {
            com.google.android.gms.ads.internal.zzq.zzks();
            zzawh.zza(this.c);
        }
        zzto();
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onResume() {
        zzo zzoVar = this.b.zzdhq;
        if (zzoVar != null) {
            zzoVar.onResume();
        }
        zza(this.a.getResources().getConfiguration());
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnt)).booleanValue()) {
            return;
        }
        zzbdi zzbdiVar = this.c;
        if (zzbdiVar == null || zzbdiVar.isDestroyed()) {
            zzayu.zzez("The webview does not exist. Ignoring action.");
        } else {
            com.google.android.gms.ads.internal.zzq.zzks();
            zzawh.zzb(this.c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdgt);
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onStart() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnt)).booleanValue()) {
            zzbdi zzbdiVar = this.c;
            if (zzbdiVar == null || zzbdiVar.isDestroyed()) {
                zzayu.zzez("The webview does not exist. Ignoring action.");
            } else {
                com.google.android.gms.ads.internal.zzq.zzks();
                zzawh.zzb(this.c);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onStop() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnt)).booleanValue() && this.c != null && (!this.a.isFinishing() || this.zzdgo == null)) {
            com.google.android.gms.ads.internal.zzq.zzks();
            zzawh.zza(this.c);
        }
        zzto();
    }

    public final void setRequestedOrientation(int i) {
        if (this.a.getApplicationInfo().targetSdkVersion >= ((Integer) zzve.zzoy().zzd(zzzn.zzcpr)).intValue()) {
            if (this.a.getApplicationInfo().targetSdkVersion <= ((Integer) zzve.zzoy().zzd(zzzn.zzcps)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzve.zzoy().zzd(zzzn.zzcpt)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzve.zzoy().zzd(zzzn.zzcpu)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.a.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzq.zzku().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzdgr = new FrameLayout(this.a);
        this.zzdgr.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzdgr.addView(view, -1, -1);
        this.a.setContentView(this.zzdgr);
        this.zzdha = true;
        this.zzdgs = customViewCallback;
        this.zzdgq = true;
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzg zzgVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzg zzgVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzve.zzoy().zzd(zzzn.zzcjh)).booleanValue() && (adOverlayInfoParcel2 = this.b) != null && (zzgVar2 = adOverlayInfoParcel2.zzdhx) != null && zzgVar2.zzble;
        boolean z5 = ((Boolean) zzve.zzoy().zzd(zzzn.zzcji)).booleanValue() && (adOverlayInfoParcel = this.b) != null && (zzgVar = adOverlayInfoParcel.zzdhx) != null && zzgVar.zzblf;
        if (z && z2 && z4 && !z5) {
            new zzaoo(this.c, "useCustomClose").zzds("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzq zzqVar = this.zzdgp;
        if (zzqVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzqVar.zzal(z3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzdf() {
        this.zzdha = true;
    }

    public final void zztk() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.b;
        if (adOverlayInfoParcel != null && this.zzdgq) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdgr != null) {
            this.a.setContentView(this.zzdgu);
            this.zzdha = true;
            this.zzdgr.removeAllViews();
            this.zzdgr = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdgs;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdgs = null;
        }
        this.zzdgq = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zztl() {
        this.d = 1;
        this.a.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final boolean zztm() {
        this.d = 0;
        zzbdi zzbdiVar = this.c;
        if (zzbdiVar == null) {
            return true;
        }
        boolean zzaah = zzbdiVar.zzaah();
        if (!zzaah) {
            this.c.zza("onbackblocked", Collections.emptyMap());
        }
        return zzaah;
    }

    public final void zztn() {
        this.zzdgu.removeView(this.zzdgp);
        zzai(true);
    }

    public final void zztq() {
        if (this.zzdgv) {
            this.zzdgv = false;
            zztr();
        }
    }

    public final void zzts() {
        this.zzdgu.a = true;
    }

    public final void zztt() {
        synchronized (this.zzdgx) {
            this.zzdgz = true;
            if (this.zzdgy != null) {
                zzawb.zzdsr.removeCallbacks(this.zzdgy);
                zzawb.zzdsr.post(this.zzdgy);
            }
        }
    }
}
