package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public interface zzbdi extends com.google.android.gms.ads.internal.zzi, zzahs, zzaip, zzbaz, zzbei, zzbel, zzbep, zzbeq, zzbes, zzbet, zzps {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbaz, com.google.android.gms.internal.ads.zzbei
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    @Override // com.google.android.gms.internal.ads.zzbes
    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbaz
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(ViewGroup viewGroup, Activity activity, String str, String str2);

    void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar);

    void zza(zzabr zzabrVar);

    void zza(zzabw zzabwVar);

    @Override // com.google.android.gms.internal.ads.zzbaz
    void zza(zzbed zzbedVar);

    void zza(zzbey zzbeyVar);

    void zza(zzra zzraVar);

    void zza(String str, Predicate<zzafn<? super zzbdi>> predicate);

    void zza(String str, zzafn<? super zzbdi> zzafnVar);

    @Override // com.google.android.gms.internal.ads.zzbaz
    void zza(String str, zzbcn zzbcnVar);

    @Nullable
    zzbev zzaaa();

    WebViewClient zzaab();

    boolean zzaac();

    @Override // com.google.android.gms.internal.ads.zzbeq
    zzdq zzaad();

    @Nullable
    IObjectWrapper zzaae();

    @Override // com.google.android.gms.internal.ads.zzbel
    boolean zzaaf();

    void zzaag();

    boolean zzaah();

    boolean zzaai();

    void zzaaj();

    void zzaak();

    zzabw zzaal();

    void zzaam();

    void zzaan();

    zzra zzaao();

    boolean zzaap();

    zzro zzaaq();

    boolean zzaar();

    void zzal(boolean z);

    void zzan(IObjectWrapper iObjectWrapper);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzaz(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zzc zzcVar);

    void zzb(String str, zzafn<? super zzbdi> zzafnVar);

    void zzb(String str, String str2, @Nullable String str3);

    boolean zzb(boolean z, int i);

    void zzba(boolean z);

    void zzbr(Context context);

    void zzde(int i);

    void zztr();

    @Override // com.google.android.gms.internal.ads.zzbaz
    @Nullable
    zzbed zzyl();

    @Override // com.google.android.gms.internal.ads.zzbaz, com.google.android.gms.internal.ads.zzbei
    Activity zzyn();

    @Override // com.google.android.gms.internal.ads.zzbaz
    com.google.android.gms.ads.internal.zza zzyo();

    @Override // com.google.android.gms.internal.ads.zzbaz
    zzaab zzyq();

    @Override // com.google.android.gms.internal.ads.zzbaz, com.google.android.gms.internal.ads.zzbet
    zzazb zzyr();

    void zzzt();

    void zzzu();

    Context zzzv();

    com.google.android.gms.ads.internal.overlay.zzc zzzw();

    com.google.android.gms.ads.internal.overlay.zzc zzzx();

    @Override // com.google.android.gms.internal.ads.zzber
    zzbey zzzy();

    String zzzz();
}
