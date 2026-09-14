package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzagl implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzazl zzbrs;
    private final /* synthetic */ zzagh zzcyb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagl(zzagh zzaghVar, zzazl zzazlVar) {
        this.zzcyb = zzaghVar;
        this.zzbrs = zzazlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        zzaga zzagaVar;
        try {
            zzazl zzazlVar = this.zzbrs;
            zzagaVar = this.zzcyb.zzcxz;
            zzazlVar.set(zzagaVar.zzru());
        } catch (DeadObjectException e) {
            this.zzbrs.setException(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzazl zzazlVar = this.zzbrs;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzazlVar.setException(new RuntimeException(sb.toString()));
    }
}
