package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* loaded from: classes.dex */
public class zzazo<T> {
    private final zzazl<T> zzdwp = new zzazl<>();
    private final AtomicInteger zzdwq = new AtomicInteger(0);

    public zzazo() {
        zzdgs.zza(this.zzdwp, new zzazr(this), zzazd.zzdwj);
    }

    @Deprecated
    public final int getStatus() {
        return this.zzdwq.get();
    }

    @Deprecated
    public final void reject() {
        this.zzdwp.setException(new Exception());
    }

    @Deprecated
    public final void zza(zzazp<T> zzazpVar, zzazn zzaznVar) {
        zzdgs.zza(this.zzdwp, new zzazq(this, zzazpVar, zzaznVar), zzazd.zzdwj);
    }

    @Deprecated
    public final void zzm(T t) {
        this.zzdwp.set(t);
    }
}
