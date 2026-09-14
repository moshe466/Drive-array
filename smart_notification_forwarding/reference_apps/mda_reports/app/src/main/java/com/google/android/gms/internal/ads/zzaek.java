package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzaek implements UnifiedNativeAd.MediaContent {
    private final zzacd zzcwg;

    public zzaek(zzacd zzacdVar) {
        this.zzcwg = zzacdVar;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent
    public final float getAspectRatio() {
        try {
            return this.zzcwg.getAspectRatio();
        } catch (RemoteException unused) {
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent
    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzre = this.zzcwg.zzre();
            if (zzre != null) {
                return (Drawable) ObjectWrapper.unwrap(zzre);
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent
    public final void setMainImage(Drawable drawable) {
        try {
            this.zzcwg.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    public final zzacd zzrr() {
        return this.zzcwg;
    }
}
