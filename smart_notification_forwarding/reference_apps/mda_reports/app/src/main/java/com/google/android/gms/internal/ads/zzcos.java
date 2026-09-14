package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcos implements AppEventListener {

    @GuardedBy("this")
    private zzwc zzgdh;

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzgdh != null) {
            try {
                this.zzgdh.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }

    public final synchronized zzwc zzamq() {
        return this.zzgdh;
    }

    public final synchronized void zzb(zzwc zzwcVar) {
        this.zzgdh = zzwcVar;
    }
}
