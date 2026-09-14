package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class zzamt extends zzalu {
    private final UnifiedNativeAdMapper zzdeh;

    public zzamt(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdeh = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final String getAdvertiser() {
        return this.zzdeh.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final String getBody() {
        return this.zzdeh.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final String getCallToAction() {
        return this.zzdeh.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final Bundle getExtras() {
        return this.zzdeh.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final String getHeadline() {
        return this.zzdeh.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdeh.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzabu(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final float getMediaContentAspectRatio() {
        return this.zzdeh.getMediaContentAspectRatio();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final boolean getOverrideClickHandling() {
        return this.zzdeh.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final boolean getOverrideImpressionRecording() {
        return this.zzdeh.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final String getPrice() {
        return this.zzdeh.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final double getStarRating() {
        if (this.zzdeh.getStarRating() != null) {
            return this.zzdeh.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final String getStore() {
        return this.zzdeh.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final zzxb getVideoController() {
        if (this.zzdeh.getVideoController() != null) {
            return this.zzdeh.getVideoController().zzdl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final void recordImpression() {
        this.zzdeh.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdeh.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final zzaci zzrg() {
        NativeAd.Image icon = this.zzdeh.getIcon();
        if (icon != null) {
            return new zzabu(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final zzaca zzrh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final IObjectWrapper zzri() {
        Object zzjo = this.zzdeh.zzjo();
        if (zzjo == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzjo);
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final IObjectWrapper zzsu() {
        View adChoicesContent = this.zzdeh.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final IObjectWrapper zzsv() {
        View zzabz = this.zzdeh.zzabz();
        if (zzabz == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzabz);
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdeh.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalr
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdeh.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
