package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzdki;
    private String zzeil;
    private List<NativeAd.Image> zzeim;
    private NativeAd.Image zzein;
    private String zzeio;
    private double zzeip;
    private String zzeiq;
    private String zzeir;

    public final String getBody() {
        return this.zzdki;
    }

    public final String getCallToAction() {
        return this.zzeio;
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

    public final String getPrice() {
        return this.zzeir;
    }

    public final double getStarRating() {
        return this.zzeip;
    }

    public final String getStore() {
        return this.zzeiq;
    }

    public final void setBody(String str) {
        this.zzdki = str;
    }

    public final void setCallToAction(String str) {
        this.zzeio = str;
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

    public final void setPrice(String str) {
        this.zzeir = str;
    }

    public final void setStarRating(double d) {
        this.zzeip = d;
    }

    public final void setStore(String str) {
        this.zzeiq = str;
    }
}
