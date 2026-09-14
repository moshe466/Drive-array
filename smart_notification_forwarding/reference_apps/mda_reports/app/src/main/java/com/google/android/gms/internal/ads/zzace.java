package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzace implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzade zzcvr;

    public zzace(zzade zzadeVar) {
        this.zzcvr = zzadeVar;
        try {
            zzadeVar.zzrn();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzcvr.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzcvr.zzrm();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return false;
        }
    }
}
