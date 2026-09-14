package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcty;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzcrk<S extends zzcty<?>> implements zzcub<S> {
    private final Clock zzbmq;
    private final AtomicReference<zzcrn<S>> zzgfm = new AtomicReference<>();
    private final zzcub<S> zzgfn;
    private final long zzgfo;

    public zzcrk(zzcub<S> zzcubVar, long j, Clock clock) {
        this.zzbmq = clock;
        this.zzgfn = zzcubVar;
        this.zzgfo = j;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<S> zzanc() {
        zzcrn<S> zzcrnVar = this.zzgfm.get();
        if (zzcrnVar == null || zzcrnVar.hasExpired()) {
            zzcrnVar = new zzcrn<>(this.zzgfn.zzanc(), this.zzgfo, this.zzbmq);
            this.zzgfm.set(zzcrnVar);
        }
        return zzcrnVar.zzgfq;
    }
}
