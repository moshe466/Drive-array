package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
/* loaded from: classes.dex */
public final class zzbaq {
    private long zzdyt;
    private final long zzdys = TimeUnit.MILLISECONDS.toNanos(((Long) zzve.zzoy().zzd(zzzn.zzchd)).longValue());
    private boolean zzdyu = true;

    public final void zza(SurfaceTexture surfaceTexture, zzbah zzbahVar) {
        if (zzbahVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.zzdyu || Math.abs(timestamp - this.zzdyt) >= this.zzdys) {
            this.zzdyu = false;
            this.zzdyt = timestamp;
            zzawb.zzdsr.post(new zzbat(this, zzbahVar));
        }
    }

    public final void zzxu() {
        this.zzdyu = true;
    }
}
