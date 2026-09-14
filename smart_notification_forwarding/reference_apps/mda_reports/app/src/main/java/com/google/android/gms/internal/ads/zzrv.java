package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzrv implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzrq zzbrh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrv(zzrq zzrqVar) {
        this.zzbrh = zzrqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        Object obj;
        Object obj2;
        zzrz zzrzVar;
        zzrz zzrzVar2;
        obj = this.zzbrh.lock;
        synchronized (obj) {
            try {
                zzrzVar = this.zzbrh.zzbrd;
                if (zzrzVar != null) {
                    zzrq zzrqVar = this.zzbrh;
                    zzrzVar2 = this.zzbrh.zzbrd;
                    zzrqVar.zzbre = zzrzVar2.zzms();
                }
            } catch (DeadObjectException e) {
                zzayu.zzc("Unable to obtain a cache service instance.", e);
                this.zzbrh.disconnect();
            }
            obj2 = this.zzbrh.lock;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Object obj;
        Object obj2;
        obj = this.zzbrh.lock;
        synchronized (obj) {
            this.zzbrh.zzbre = null;
            obj2 = this.zzbrh.lock;
            obj2.notifyAll();
        }
    }
}
