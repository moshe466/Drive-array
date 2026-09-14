package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zaai implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference zaa;
    private final Api zab;
    private final boolean zac;

    public zaai(zaar zaarVar, Api api, boolean z3) {
        this.zaa = new WeakReference(zaarVar);
        this.zab = api;
        this.zac = z3;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        boolean z3;
        zaar zaarVar = (zaar) this.zaa.get();
        if (zaarVar == null) {
            return;
        }
        if (Looper.myLooper() == zaarVar.zar().zag.getLooper()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zaarVar.zas().lock();
        try {
            if (zaarVar.zaq(0)) {
                if (!connectionResult.isSuccess()) {
                    zaarVar.zal(connectionResult, this.zab, this.zac);
                }
                if (zaarVar.zai()) {
                    zaarVar.zak();
                }
            }
        } finally {
            zaarVar.zas().unlock();
        }
    }

    public final /* synthetic */ boolean zaa() {
        return this.zac;
    }
}
