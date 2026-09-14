package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* loaded from: classes.dex */
public final class zzcax extends VideoController.VideoLifecycleCallbacks {
    private final zzbws zzfkc;

    public zzcax(zzbws zzbwsVar) {
        this.zzfkc = zzbwsVar;
    }

    private static zzxg zza(zzbws zzbwsVar) {
        zzxb videoController = zzbwsVar.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzpm();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzxg zza = zza(this.zzfkc);
        if (zza == null) {
            return;
        }
        try {
            zza.onVideoEnd();
        } catch (RemoteException e) {
            zzayu.zzd("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzxg zza = zza(this.zzfkc);
        if (zza == null) {
            return;
        }
        try {
            zza.onVideoPause();
        } catch (RemoteException e) {
            zzayu.zzd("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzxg zza = zza(this.zzfkc);
        if (zza == null) {
            return;
        }
        try {
            zza.onVideoStart();
        } catch (RemoteException e) {
            zzayu.zzd("Unable to call onVideoEnd()", e);
        }
    }
}
