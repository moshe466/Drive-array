package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcqr implements zzcub<zzcty<Bundle>> {
    private final Executor executor;
    private final zzave zzbmm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcqr(Executor executor, zzave zzaveVar) {
        this.executor = executor;
        this.zzbmm = zzaveVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcty<Bundle>> zzanc() {
        return ((Boolean) zzve.zzoy().zzd(zzzn.zzclf)).booleanValue() ? zzdgs.zzaj(null) : zzdgs.zzb(this.zzbmm.zzvg(), zzcqq.a, this.executor);
    }
}
