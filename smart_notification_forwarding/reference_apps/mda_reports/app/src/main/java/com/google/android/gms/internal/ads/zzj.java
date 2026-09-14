package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzj implements zzaa {
    private final Executor zzv;

    public zzj(Handler handler) {
        this.zzv = new zzi(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final void zza(zzq<?> zzqVar, zzae zzaeVar) {
        zzqVar.zzb("post-error");
        this.zzv.execute(new zzl(zzqVar, zzz.zzd(zzaeVar), null));
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final void zza(zzq<?> zzqVar, zzz<?> zzzVar, Runnable runnable) {
        zzqVar.zzj();
        zzqVar.zzb("post-response");
        this.zzv.execute(new zzl(zzqVar, zzzVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final void zzb(zzq<?> zzqVar, zzz<?> zzzVar) {
        zza(zzqVar, zzzVar, null);
    }
}
