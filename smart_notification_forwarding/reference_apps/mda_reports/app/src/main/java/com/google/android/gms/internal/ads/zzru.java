package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzru implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzrq zzbrh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzru(zzrq zzrqVar) {
        this.zzbrh = zzrqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Object obj;
        zzrz zzrzVar;
        Object obj2;
        obj = this.zzbrh.lock;
        synchronized (obj) {
            this.zzbrh.zzbre = null;
            zzrzVar = this.zzbrh.zzbrd;
            if (zzrzVar != null) {
                zzrq.a(this.zzbrh, (zzrz) null);
            }
            obj2 = this.zzbrh.lock;
            obj2.notifyAll();
        }
    }
}
