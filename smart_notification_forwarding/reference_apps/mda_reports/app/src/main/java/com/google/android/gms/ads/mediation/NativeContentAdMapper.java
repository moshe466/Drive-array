package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class NativeContentAdMapper extends NativeAdMapper {
    private String zzdki;
    private String zzeil;
    private List<NativeAd.Image> zzeim;
    private String zzeio;
    private NativeAd.Image zzeiu;
    private String zzeiv;

    public final String getAdvertiser() {
        return this.zzeiv;
    }

    public final String getBody() {
        return this.zzdki;
    }

    public final String getCallToAction() {
        return this.zzeio;
    }

    public final String getHeadline() {
        return this.zzeil;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzeim;
    }

    public final NativeAd.Image getLogo() {
        return this.zzeiu;
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

    public final void setHeadline(String str) {
        this.zzeil = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzeim = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzeiu = image;
    }
}
