package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class zzame extends zzalp {
    private final NativeContentAdMapper zzdec;

    public zzame(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdec = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getAdvertiser() {
        return this.zzdec.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getBody() {
        return this.zzdec.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getCallToAction() {
        return this.zzdec.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final Bundle getExtras() {
        return this.zzdec.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getHeadline() {
        return this.zzdec.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdec.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzabu(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final boolean getOverrideClickHandling() {
        return this.zzdec.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final boolean getOverrideImpressionRecording() {
        return this.zzdec.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final zzxb getVideoController() {
        if (this.zzdec.getVideoController() != null) {
            return this.zzdec.getVideoController().zzdl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void recordImpression() {
        this.zzdec.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdec.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final zzaca zzrh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final IObjectWrapper zzri() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final zzaci zzrj() {
        NativeAd.Image logo = this.zzdec.getLogo();
        if (logo != null) {
            return new zzabu(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final IObjectWrapper zzsu() {
        View adChoicesContent = this.zzdec.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final IObjectWrapper zzsv() {
        View zzabz = this.zzdec.zzabz();
        if (zzabz == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzabz);
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdec.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdec.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdec.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
