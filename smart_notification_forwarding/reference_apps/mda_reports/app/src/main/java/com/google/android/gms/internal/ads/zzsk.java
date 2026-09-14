package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzsk implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzazl zzbrs;
    private final /* synthetic */ zzse zzbrt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsk(zzse zzseVar, zzazl zzazlVar) {
        this.zzbrt = zzseVar;
        this.zzbrs = zzazlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Object obj;
        obj = this.zzbrt.lock;
        synchronized (obj) {
            this.zzbrs.setException(new RuntimeException("Connection failed."));
        }
    }
}
