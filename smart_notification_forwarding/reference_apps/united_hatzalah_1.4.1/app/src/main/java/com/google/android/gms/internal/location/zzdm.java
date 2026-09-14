package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzdm extends zzn {
    final /* synthetic */ TaskCompletionSource zza;

    public zzdm(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzb(Status status, boolean z3) {
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z3), (TaskCompletionSource<Boolean>) this.zza);
    }
}
