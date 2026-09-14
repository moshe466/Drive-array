package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabt;
import com.google.android.gms.internal.ads.zzabv;
import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzacm;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzn;

/* loaded from: classes.dex */
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzbkf;
    private final zzacm zzbkg;

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    private final void zza(String str, View view) {
        try {
            this.zzbkg.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    private final View zzbp(String str) {
        try {
            IObjectWrapper zzco = this.zzbkg.zzco(str);
            if (zzco != null) {
                return (View) ObjectWrapper.unwrap(zzco);
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzacm zzjl() {
        Preconditions.checkNotNull(this.zzbkf, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzve.zzov().zza(this.zzbkf.getContext(), this, this.zzbkf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(ImageView.ScaleType scaleType) {
        try {
            if (scaleType instanceof ImageView.ScaleType) {
                this.zzbkg.zzg(ObjectWrapper.wrap(scaleType));
            }
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setMediaViewImageScaleType on delegate", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(UnifiedNativeAd.MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzaek) {
                this.zzbkg.zza(((zzaek) mediaContent).zzrr());
            } else if (mediaContent == null) {
                this.zzbkg.zza((zzacd) null);
            } else {
                zzayu.zzea("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setMediaContent on delegate", e);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbkf);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbkf;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void destroy() {
        try {
            this.zzbkg.destroy();
        } catch (RemoteException e) {
            zzayu.zzc("Unable to destroy native ad view", e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzacm zzacmVar;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzclq)).booleanValue() && (zzacmVar = this.zzbkg) != null) {
            try {
                zzacmVar.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbp = zzbp(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbp instanceof AdChoicesView) {
            return (AdChoicesView) zzbp;
        }
        return null;
    }

    public final View getAdvertiserView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getBodyView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getCallToActionView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getHeadlineView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getIconView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getImageView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final MediaView getMediaView() {
        View zzbp = zzbp(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (zzbp instanceof MediaView) {
            return (MediaView) zzbp;
        }
        if (zzbp == null) {
            return null;
        }
        zzayu.zzea("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getStarRatingView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final View getStoreView() {
        return zzbp(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzacm zzacmVar = this.zzbkg;
        if (zzacmVar != null) {
            try {
                zzacmVar.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbkf);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.zzbkf == view) {
            return;
        }
        super.removeView(view);
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setBodyView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setCallToActionView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbkg.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setIconView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setImageView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
        if (mediaView != null) {
            mediaView.a(new zzabt(this) { // from class: com.google.android.gms.ads.formats.zze
                private final UnifiedNativeAdView zzbkm;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbkm = this;
                }

                @Override // com.google.android.gms.internal.ads.zzabt
                public final void setMediaContent(UnifiedNativeAd.MediaContent mediaContent) {
                    this.zzbkm.a(mediaContent);
                }
            });
            mediaView.a(new zzabv(this) { // from class: com.google.android.gms.ads.formats.zzd
                private final UnifiedNativeAdView zzbkm;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbkm = this;
                }

                @Override // com.google.android.gms.internal.ads.zzabv
                public final void setImageScaleType(ImageView.ScaleType scaleType) {
                    this.zzbkm.a(scaleType);
                }
            });
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzbkg.zza((IObjectWrapper) unifiedNativeAd.a());
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setStarRatingView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setStoreView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }
}
