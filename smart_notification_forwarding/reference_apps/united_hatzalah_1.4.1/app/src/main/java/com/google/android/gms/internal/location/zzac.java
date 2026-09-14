package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzac extends zzae {
    final /* synthetic */ long zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzaf zzafVar, GoogleApiClient googleApiClient, long j2, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = j2;
        this.zzb = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        boolean z3;
        PendingIntent pendingIntent = this.zzb;
        zzg zzgVar = (zzg) anyClient;
        Preconditions.checkNotNull(pendingIntent);
        long j2 = this.zza;
        if (j2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "detectionIntervalMillis must be >= 0");
        ((zzv) zzgVar.getService()).zzh(j2, true, pendingIntent);
        setResult((zzac) Status.RESULT_SUCCESS);
    }
}
