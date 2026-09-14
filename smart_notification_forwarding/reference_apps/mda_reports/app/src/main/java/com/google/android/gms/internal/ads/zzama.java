package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* loaded from: classes.dex */
final class zzama implements InitializationCompleteCallback {
    private final /* synthetic */ zzagp zzddw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzama(zzaly zzalyVar, zzagp zzagpVar) {
        this.zzddw = zzagpVar;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.zzddw.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.zzddw.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
