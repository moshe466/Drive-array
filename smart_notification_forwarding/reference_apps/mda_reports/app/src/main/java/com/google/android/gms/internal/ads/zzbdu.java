package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbdu extends FrameLayout implements zzbdi {
    private final zzbdi zzefo;
    private final zzbao zzefp;
    private final AtomicBoolean zzefq;

    public zzbdu(zzbdi zzbdiVar) {
        super(zzbdiVar.getContext());
        this.zzefq = new AtomicBoolean();
        this.zzefo = zzbdiVar;
        this.zzefp = new zzbao(zzbdiVar.zzzv(), this, this);
        if (zzaar()) {
            return;
        }
        addView(this.zzefo.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void destroy() {
        final IObjectWrapper zzaae = zzaae();
        if (zzaae == null) {
            this.zzefo.destroy();
            return;
        }
        zzawb.zzdsr.post(new Runnable(zzaae) { // from class: com.google.android.gms.internal.ads.zzbdx
            private final IObjectWrapper zzefs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzefs = zzaae;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.zzq.zzlf().zzac(this.zzefs);
            }
        });
        zzawb.zzdsr.postDelayed(new zzbdw(this), ((Integer) zzve.zzoy().zzd(zzzn.zzcod)).intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbes
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final WebView getWebView() {
        return this.zzefo.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean isDestroyed() {
        return this.zzefo.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void loadData(String str, String str2, String str3) {
        this.zzefo.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzefo.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void loadUrl(String str) {
        this.zzefo.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void onPause() {
        this.zzefp.onPause();
        this.zzefo.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void onResume() {
        this.zzefo.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdi
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzefo.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzefo.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void setRequestedOrientation(int i) {
        this.zzefo.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzefo.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzefo.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.zzefo.zza(this, activity, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzefo.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzefo.zza(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(zzabr zzabrVar) {
        this.zzefo.zza(zzabrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(@Nullable zzabw zzabwVar) {
        this.zzefo.zza(zzabwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final void zza(zzbed zzbedVar) {
        this.zzefo.zza(zzbedVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(zzbey zzbeyVar) {
        this.zzefo.zza(zzbeyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final void zza(zzpt zzptVar) {
        this.zzefo.zza(zzptVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(zzra zzraVar) {
        this.zzefo.zza(zzraVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(String str, Predicate<zzafn<? super zzbdi>> predicate) {
        this.zzefo.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(String str, zzafn<? super zzbdi> zzafnVar) {
        this.zzefo.zza(str, zzafnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final void zza(String str, zzbcn zzbcnVar) {
        this.zzefo.zza(str, zzbcnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahs
    public final void zza(String str, Map<String, ?> map) {
        this.zzefo.zza(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zza(String str, JSONObject jSONObject) {
        this.zzefo.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zza(boolean z, int i, String str) {
        this.zzefo.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzefo.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zza(boolean z, long j) {
        this.zzefo.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final zzbev zzaaa() {
        return this.zzefo.zzaaa();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final WebViewClient zzaab() {
        return this.zzefo.zzaab();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzaac() {
        return this.zzefo.zzaac();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbeq
    public final zzdq zzaad() {
        return this.zzefo.zzaad();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final IObjectWrapper zzaae() {
        return this.zzefo.zzaae();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbel
    public final boolean zzaaf() {
        return this.zzefo.zzaaf();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaag() {
        this.zzefp.onDestroy();
        this.zzefo.zzaag();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzaah() {
        return this.zzefo.zzaah();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzaai() {
        return this.zzefo.zzaai();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaaj() {
        this.zzefo.zzaaj();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaak() {
        this.zzefo.zzaak();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    @Nullable
    public final zzabw zzaal() {
        return this.zzefo.zzaal();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaam() {
        setBackgroundColor(0);
        this.zzefo.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaan() {
        TextView textView = new TextView(getContext());
        Resources resources = com.google.android.gms.ads.internal.zzq.zzku().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final zzra zzaao() {
        return this.zzefo.zzaao();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzaap() {
        return this.zzefq.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final zzro zzaaq() {
        return this.zzefo.zzaaq();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzaar() {
        return this.zzefo.zzaar();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzal(boolean z) {
        this.zzefo.zzal(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzan(IObjectWrapper iObjectWrapper) {
        this.zzefo.zzan(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzav(boolean z) {
        this.zzefo.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzax(boolean z) {
        this.zzefo.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzay(boolean z) {
        this.zzefo.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzaz(boolean z) {
        this.zzefo.zzaz(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzefo.zzb(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzb(String str, zzafn<? super zzbdi> zzafnVar) {
        this.zzefo.zzb(str, zzafnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzb(String str, String str2, @Nullable String str3) {
        this.zzefo.zzb(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzahs
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzefo.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final boolean zzb(boolean z, int i) {
        if (!this.zzefq.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcis)).booleanValue()) {
            return false;
        }
        if (this.zzefo.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zzefo.getParent()).removeView(this.zzefo.getView());
        }
        return this.zzefo.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzba(boolean z) {
        this.zzefo.zzba(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzbr(Context context) {
        this.zzefo.zzbr(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbep
    public final void zzc(boolean z, int i) {
        this.zzefo.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zzcy(String str) {
        this.zzefo.zzcy(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzde(int i) {
        this.zzefo.zzde(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final zzbcn zzfe(String str) {
        return this.zzefo.zzfe(str);
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzjv() {
        this.zzefo.zzjv();
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzjw() {
        this.zzefo.zzjw();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zztr() {
        this.zzefo.zztr();
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzts() {
        this.zzefo.zzts();
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final zzbao zzyk() {
        return this.zzefp;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final zzbed zzyl() {
        return this.zzefo.zzyl();
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final zzaac zzym() {
        return this.zzefo.zzym();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz, com.google.android.gms.internal.ads.zzbei
    public final Activity zzyn() {
        return this.zzefo.zzyn();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final com.google.android.gms.ads.internal.zza zzyo() {
        return this.zzefo.zzyo();
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final String zzyp() {
        return this.zzefo.zzyp();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz
    public final zzaab zzyq() {
        return this.zzefo.zzyq();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzbaz, com.google.android.gms.internal.ads.zzbet
    public final zzazb zzyr() {
        return this.zzefo.zzyr();
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
    public final void zzyu() {
        this.zzefo.zzyu();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzzt() {
        this.zzefo.zzzt();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzzu() {
        this.zzefo.zzzu();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final Context zzzv() {
        return this.zzefo.zzzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final com.google.android.gms.ads.internal.overlay.zzc zzzw() {
        return this.zzefo.zzzw();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final com.google.android.gms.ads.internal.overlay.zzc zzzx() {
        return this.zzefo.zzzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi, com.google.android.gms.internal.ads.zzber
    public final zzbey zzzy() {
        return this.zzefo.zzzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final String zzzz() {
        return this.zzefo.zzzz();
    }
}
