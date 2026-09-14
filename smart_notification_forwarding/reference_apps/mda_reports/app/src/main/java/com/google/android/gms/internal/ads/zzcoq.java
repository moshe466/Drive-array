package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcoq implements zzty {

    @GuardedBy("this")
    private zzvg zzgdd;

    @Override // com.google.android.gms.internal.ads.zzty
    public final synchronized void onAdClicked() {
        if (this.zzgdd != null) {
            try {
                this.zzgdd.onAdClicked();
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zzb(zzvg zzvgVar) {
        this.zzgdd = zzvgVar;
    }
}
