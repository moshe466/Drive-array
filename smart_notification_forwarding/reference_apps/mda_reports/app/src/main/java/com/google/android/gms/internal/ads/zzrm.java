package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* loaded from: classes.dex */
public final class zzrm extends AppOpenAd {
    private final zzrf zzbqx;

    public zzrm(zzrf zzrfVar) {
        this.zzbqx = zzrfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final zzvu a() {
        try {
            return this.zzbqx.zzdm();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void a(zzrl zzrlVar) {
        try {
            this.zzbqx.zza(zzrlVar);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
