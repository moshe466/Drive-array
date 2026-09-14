package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzdcf {
    private final E zzgpx;
    private final List<zzdhe<?>> zzgqc;
    private final /* synthetic */ zzdcd zzgqd;

    private zzdcf(zzdcd zzdcdVar, E e, List<zzdhe<?>> list) {
        this.zzgqd = zzdcdVar;
        this.zzgpx = e;
        this.zzgqc = list;
    }

    public final <O> zzdcj<O> zzb(Callable<O> callable) {
        zzdhd zzdhdVar;
        zzdgx zzi = zzdgs.zzi(this.zzgqc);
        zzdhe zza = zzi.zza(zzdce.a, zzazd.zzdwj);
        zzdcd zzdcdVar = this.zzgqd;
        E e = this.zzgpx;
        List<zzdhe<?>> list = this.zzgqc;
        zzdhdVar = zzdcdVar.zzfov;
        return new zzdcj<>(zzdcdVar, e, zza, list, zzi.zza(callable, zzdhdVar));
    }
}
