package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class zzamb extends zzalo {
    private final NativeAppInstallAdMapper zzddx;

    public zzamb(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzddx = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getBody() {
        return this.zzddx.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getCallToAction() {
        return this.zzddx.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final Bundle getExtras() {
        return this.zzddx.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getHeadline() {
        return this.zzddx.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final List getImages() {
        List<NativeAd.Image> images = this.zzddx.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzabu(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final boolean getOverrideClickHandling() {
        return this.zzddx.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final boolean getOverrideImpressionRecording() {
        return this.zzddx.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getPrice() {
        return this.zzddx.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final double getStarRating() {
        return this.zzddx.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getStore() {
        return this.zzddx.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final zzxb getVideoController() {
        if (this.zzddx.getVideoController() != null) {
            return this.zzddx.getVideoController().zzdl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void recordImpression() {
        this.zzddx.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzddx.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final zzaci zzrg() {
        NativeAd.Image icon = this.zzddx.getIcon();
        if (icon != null) {
            return new zzabu(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final zzaca zzrh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final IObjectWrapper zzri() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final IObjectWrapper zzsu() {
        View adChoicesContent = this.zzddx.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final IObjectWrapper zzsv() {
        View zzabz = this.zzddx.zzabz();
        if (zzabz == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzabz);
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzddx.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzddx.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzddx.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
