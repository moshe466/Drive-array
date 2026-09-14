package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcai extends zzaef {

    @Nullable
    private final String zzfge;
    private final zzbws zzfkc;
    private final zzbwk zzfnf;

    public zzcai(@Nullable String str, zzbwk zzbwkVar, zzbws zzbwsVar) {
        this.zzfge = str;
        this.zzfnf = zzbwkVar;
        this.zzfkc = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void cancelUnconfirmedClick() {
        this.zzfnf.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void destroy() {
        this.zzfnf.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getAdvertiser() {
        return this.zzfkc.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getBody() {
        return this.zzfkc.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getCallToAction() {
        return this.zzfkc.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final Bundle getExtras() {
        return this.zzfkc.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getHeadline() {
        return this.zzfkc.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final List<?> getImages() {
        return this.zzfkc.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getMediationAdapterClassName() {
        return this.zzfge;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final List<?> getMuteThisAdReasons() {
        return isCustomMuteThisAdEnabled() ? this.zzfkc.getMuteThisAdReasons() : Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getPrice() {
        return this.zzfkc.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final double getStarRating() {
        return this.zzfkc.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getStore() {
        return this.zzfkc.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzxb getVideoController() {
        return this.zzfkc.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final boolean isCustomClickGestureEnabled() {
        return this.zzfnf.isCustomClickGestureEnabled();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final boolean isCustomMuteThisAdEnabled() {
        return (this.zzfkc.getMuteThisAdReasons().isEmpty() || this.zzfkc.zzajd() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void performClick(Bundle bundle) {
        this.zzfnf.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void recordCustomClickGesture() {
        this.zzfnf.recordCustomClickGesture();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final boolean recordImpression(Bundle bundle) {
        return this.zzfnf.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void reportTouchEvent(Bundle bundle) {
        this.zzfnf.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zza(zzaeb zzaebVar) {
        this.zzfnf.zza(zzaebVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zza(zzwn zzwnVar) {
        this.zzfnf.zza(zzwnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zza(@Nullable zzwr zzwrVar) {
        this.zzfnf.zza(zzwrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzxa zzkb() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcrf)).booleanValue()) {
            return this.zzfnf.zzags();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final IObjectWrapper zzrf() {
        return ObjectWrapper.wrap(this.zzfnf);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzaci zzrg() {
        return this.zzfkc.zzrg();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzaca zzrh() {
        return this.zzfkc.zzrh();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final IObjectWrapper zzri() {
        return this.zzfkc.zzri();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zzrp() {
        this.zzfnf.zzrp();
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzacd zzrq() {
        return this.zzfnf.zzaix().zzrq();
    }
}
