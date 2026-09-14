package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzdch {
    private final E zzgpx;
    private final /* synthetic */ zzdcd zzgqd;

    private zzdch(zzdcd zzdcdVar, E e) {
        this.zzgqd = zzdcdVar;
        this.zzgpx = e;
    }

    private final <O> zzdcj<O> zza(Callable<O> callable, zzdhd zzdhdVar) {
        zzdhe zzdheVar;
        zzdcd zzdcdVar = this.zzgqd;
        E e = this.zzgpx;
        zzdheVar = zzdcd.zzgqa;
        return new zzdcj<>(zzdcdVar, e, zzdheVar, Collections.emptyList(), zzdhdVar.submit(callable));
    }

    public final zzdcj<?> zza(final zzdcb zzdcbVar, zzdhd zzdhdVar) {
        return zza(new Callable(zzdcbVar) { // from class: com.google.android.gms.internal.ads.zzdcg
            private final zzdcb zzgqe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqe = zzdcbVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.zzgqe.run();
                return null;
            }
        }, zzdhdVar);
    }

    public final <O> zzdcj<O> zzc(zzdhe<O> zzdheVar) {
        zzdhe zzdheVar2;
        zzdcd zzdcdVar = this.zzgqd;
        E e = this.zzgpx;
        zzdheVar2 = zzdcd.zzgqa;
        return new zzdcj<>(zzdcdVar, e, zzdheVar2, Collections.emptyList(), zzdheVar);
    }

    public final <O> zzdcj<O> zzc(Callable<O> callable) {
        zzdhd zzdhdVar;
        zzdhdVar = this.zzgqd.zzfov;
        return zza(callable, zzdhdVar);
    }
}
