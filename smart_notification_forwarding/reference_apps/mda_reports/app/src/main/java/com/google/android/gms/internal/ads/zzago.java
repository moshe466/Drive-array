package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzago implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzazl zzbrs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzago(zzagh zzaghVar, zzazl zzazlVar) {
        this.zzbrs = zzazlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzbrs.setException(new RuntimeException("Connection failed."));
    }
}
