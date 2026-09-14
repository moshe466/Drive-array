package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzbwi extends zzacg {
    private final zzbws zzfkc;
    private IObjectWrapper zzfle;

    public zzbwi(zzbws zzbwsVar) {
        this.zzfkc = zzbwsVar;
    }

    private final float zzaiu() {
        try {
            return this.zzfkc.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzayu.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private static float zzap(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final float getAspectRatio() {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcqi)).booleanValue()) {
            return 0.0f;
        }
        if (this.zzfkc.getMediaContentAspectRatio() != 0.0f) {
            return this.zzfkc.getMediaContentAspectRatio();
        }
        if (this.zzfkc.getVideoController() != null) {
            return zzaiu();
        }
        IObjectWrapper iObjectWrapper = this.zzfle;
        if (iObjectWrapper != null) {
            return zzap(iObjectWrapper);
        }
        zzaci zzajc = this.zzfkc.zzajc();
        if (zzajc == null) {
            return 0.0f;
        }
        float width = (zzajc == null || zzajc.getWidth() == -1 || zzajc.getHeight() == -1) ? 0.0f : zzajc.getWidth() / zzajc.getHeight();
        return width != 0.0f ? width : zzap(zzajc.zzrc());
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcmd)).booleanValue()) {
            this.zzfle = iObjectWrapper;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final IObjectWrapper zzre() {
        IObjectWrapper iObjectWrapper = this.zzfle;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzaci zzajc = this.zzfkc.zzajc();
        if (zzajc == null) {
            return null;
        }
        return zzajc.zzrc();
    }
}
