package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbwq {

    @Nullable
    private zzacd zzcwg;

    public zzbwq(zzbwi zzbwiVar) {
        this.zzcwg = zzbwiVar;
    }

    public final synchronized void zza(@Nullable zzacd zzacdVar) {
        this.zzcwg = zzacdVar;
    }

    @Nullable
    public final synchronized zzacd zzrq() {
        return this.zzcwg;
    }
}
