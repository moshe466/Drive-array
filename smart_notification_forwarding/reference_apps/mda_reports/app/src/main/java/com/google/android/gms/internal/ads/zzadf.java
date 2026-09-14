package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzadf implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzadf> zzcwa = new WeakHashMap<>();
    private final VideoController zzcel = new VideoController();
    private final zzade zzcwb;
    private final MediaView zzcwc;
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzcwd;

    @VisibleForTesting
    private zzadf(zzade zzadeVar) {
        Context context;
        this.zzcwb = zzadeVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzadeVar.zzrk());
        } catch (RemoteException | NullPointerException e) {
            zzayu.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzcwb.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzayu.zzc("", e2);
            }
        }
        this.zzcwc = mediaView;
    }

    public static zzadf zza(zzade zzadeVar) {
        synchronized (zzcwa) {
            zzadf zzadfVar = zzcwa.get(zzadeVar.asBinder());
            if (zzadfVar != null) {
                return zzadfVar;
            }
            zzadf zzadfVar2 = new zzadf(zzadeVar);
            zzcwa.put(zzadeVar.asBinder(), zzadfVar2);
            return zzadfVar2;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void destroy() {
        try {
            this.zzcwb.destroy();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzcwb.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.zzcwb.getCustomTemplateId();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzcwd == null && this.zzcwb.zzrl()) {
                this.zzcwd = new zzace(this.zzcwb);
            }
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
        return this.zzcwd;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeAd.Image getImage(String str) {
        try {
            zzaci zzcu = this.zzcwb.zzcu(str);
            if (zzcu != null) {
                return new zzacj(zzcu);
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final CharSequence getText(String str) {
        try {
            return this.zzcwb.zzct(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final VideoController getVideoController() {
        try {
            zzxb videoController = this.zzcwb.getVideoController();
            if (videoController != null) {
                this.zzcel.zza(videoController);
            }
        } catch (RemoteException e) {
            zzayu.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcel;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final MediaView getVideoMediaView() {
        return this.zzcwc;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void performClick(String str) {
        try {
            this.zzcwb.performClick(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void recordImpression() {
        try {
            this.zzcwb.recordImpression();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    public final zzade zzro() {
        return this.zzcwb;
    }
}
