package com.google.android.gms.gass;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzddh;
import com.google.android.gms.internal.ads.zzddn;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzf {
    private final Looper zzgse;
    private final Context zzup;

    public zzf(@NonNull Context context, @NonNull Looper looper) {
        this.zzup = context;
        this.zzgse = looper;
    }

    public final void zzgq(@NonNull String str) {
        new zzh(this.zzup, this.zzgse, (zzddn) zzddn.zzaqn().zzgt(this.zzup.getPackageName()).zzb(zzddn.zza.BLOCKED_IMPRESSION).zza(zzddh.zzaqk().zzgs(str).zzb(zzddh.zza.BLOCKED_REASON_BACKGROUND)).zzbaf()).a();
    }
}
