package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class UnifiedNativeAdMapper {
    private Bundle extras = new Bundle();
    private VideoController zzcel;
    private String zzdki;
    private String zzeil;
    private List<NativeAd.Image> zzeim;
    private NativeAd.Image zzein;
    private String zzeio;
    private String zzeiq;
    private String zzeir;
    private View zzeis;
    private boolean zzeit;
    private String zzeiv;
    private Double zzeiw;
    private View zzeix;
    private Object zzeiy;
    private boolean zzeiz;
    private boolean zzeja;
    private float zzejb;

    public View getAdChoicesContent() {
        return this.zzeix;
    }

    public final String getAdvertiser() {
        return this.zzeiv;
    }

    public final String getBody() {
        return this.zzdki;
    }

    public final String getCallToAction() {
        return this.zzeio;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getHeadline() {
        return this.zzeil;
    }

    public final NativeAd.Image getIcon() {
        return this.zzein;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzeim;
    }

    public float getMediaContentAspectRatio() {
        return this.zzejb;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzeja;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzeiz;
    }

    public final String getPrice() {
        return this.zzeir;
    }

    public final Double getStarRating() {
        return this.zzeiw;
    }

    public final String getStore() {
        return this.zzeiq;
    }

    public final VideoController getVideoController() {
        return this.zzcel;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.zzeit;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.zzeix = view;
    }

    public final void setAdvertiser(String str) {
        this.zzeiv = str;
    }

    public final void setBody(String str) {
        this.zzdki = str;
    }

    public final void setCallToAction(String str) {
        this.zzeio = str;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.zzeit = z;
    }

    public final void setHeadline(String str) {
        this.zzeil = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzein = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzeim = list;
    }

    public void setMediaContentAspectRatio(float f) {
        this.zzejb = f;
    }

    public void setMediaView(View view) {
        this.zzeis = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.zzeja = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.zzeiz = z;
    }

    public final void setPrice(String str) {
        this.zzeir = str;
    }

    public final void setStarRating(Double d) {
        this.zzeiw = d;
    }

    public final void setStore(String str) {
        this.zzeiq = str;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.zzcel = videoController;
    }

    public final View zzabz() {
        return this.zzeis;
    }

    public final Object zzjo() {
        return this.zzeiy;
    }

    public final void zzn(Object obj) {
        this.zzeiy = obj;
    }
}
