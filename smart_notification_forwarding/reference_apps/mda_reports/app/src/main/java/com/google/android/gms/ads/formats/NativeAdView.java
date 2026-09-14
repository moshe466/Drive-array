package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacm;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzn;

@Deprecated
/* loaded from: classes.dex */
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzbkf;
    private final zzacm zzbkg;

    public NativeAdView(Context context) {
        super(context);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbkf = zzd(context);
        this.zzbkg = zzjl();
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzacm zzjl() {
        Preconditions.checkNotNull(this.zzbkf, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzve.zzov().zza(this.zzbkf.getContext(), this, this.zzbkf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(String str) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, View view) {
        try {
            this.zzbkg.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbkf);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbkf;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void destroy() {
        try {
            this.zzbkg.destroy();
        } catch (RemoteException e) {
            zzayu.zzc("Unable to destroy native ad view", e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
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

    public AdChoicesView getAdChoicesView() {
        View a = a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (a instanceof AdChoicesView) {
            return (AdChoicesView) a;
        }
        return null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
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
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbkf);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.zzbkf == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzbkg.zza((IObjectWrapper) nativeAd.a());
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setNativeAd on delegate", e);
        }
    }
}
