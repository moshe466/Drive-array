package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcok extends zzvt {
    private final ViewGroup zzfdu;
    private final zzczu zzfgl;
    private final zzvh zzfjw;
    private final zzbkk zzgcp;
    private final Context zzup;

    public zzcok(Context context, @Nullable zzvh zzvhVar, zzczu zzczuVar, zzbkk zzbkkVar) {
        this.zzup = context;
        this.zzfjw = zzvhVar;
        this.zzfgl = zzczuVar;
        this.zzgcp = zzbkkVar;
        FrameLayout frameLayout = new FrameLayout(this.zzup);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzgcp.zzaga(), com.google.android.gms.ads.internal.zzq.zzks().zzwp());
        frameLayout.setMinimumHeight(zzjz().heightPixels);
        frameLayout.setMinimumWidth(zzjz().widthPixels);
        this.zzfdu = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgcp.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final Bundle getAdMetadata() {
        zzayu.zzey("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final String getAdUnitId() {
        return this.zzfgl.zzgmm;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final String getMediationAdapterClassName() {
        if (this.zzgcp.zzags() != null) {
            return this.zzgcp.zzags().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzxb getVideoController() {
        return this.zzgcp.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean isLoading() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void pause() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgcp.zzagr().zzbv(null);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void resume() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgcp.zzagr().zzbw(null);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setManualImpressionsEnabled(boolean z) {
        zzayu.zzey("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaak zzaakVar) {
        zzayu.zzey("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaoy zzaoyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzape zzapeVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaro zzaroVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzrg zzrgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuj zzujVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbkk zzbkkVar = this.zzgcp;
        if (zzbkkVar != null) {
            zzbkkVar.zza(this.zzfdu, zzujVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuo zzuoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvg zzvgVar) {
        zzayu.zzey("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvh zzvhVar) {
        zzayu.zzey("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvx zzvxVar) {
        zzayu.zzey("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwc zzwcVar) {
        zzayu.zzey("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwi zzwiVar) {
        zzayu.zzey("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzxh zzxhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzyw zzywVar) {
        zzayu.zzey("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean zza(zzug zzugVar) {
        zzayu.zzey("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzbr(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final IObjectWrapper zzjx() {
        return ObjectWrapper.wrap(this.zzfdu);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzjy() {
        this.zzgcp.zzjy();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzuj zzjz() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzczy.zza(this.zzup, (List<zzczk>) Collections.singletonList(this.zzgcp.zzafz()));
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final String zzka() {
        if (this.zzgcp.zzags() != null) {
            return this.zzgcp.zzags().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzxa zzkb() {
        return this.zzgcp.zzags();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzwc zzkc() {
        return this.zzfgl.zzgmr;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzvh zzkd() {
        return this.zzfjw;
    }
}
