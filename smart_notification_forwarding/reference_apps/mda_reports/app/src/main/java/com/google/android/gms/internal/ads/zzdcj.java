package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzdcj<O> {
    final /* synthetic */ zzdcd a;
    private final E zzgpx;

    @Nullable
    private final String zzgpy;
    private final List<zzdhe<?>> zzgqc;
    private final zzdhe<?> zzgqg;
    private final zzdhe<O> zzgqh;

    private zzdcj(zzdcd zzdcdVar, E e, String str, zzdhe<?> zzdheVar, List<zzdhe<?>> list, zzdhe<O> zzdheVar2) {
        this.a = zzdcdVar;
        this.zzgpx = e;
        this.zzgpy = str;
        this.zzgqg = zzdheVar;
        this.zzgqc = list;
        this.zzgqh = zzdheVar2;
    }

    private final <O2> zzdcj<O2> zza(zzdgf<O, O2> zzdgfVar, Executor executor) {
        return new zzdcj<>(this.a, this.zzgpx, this.zzgpy, this.zzgqg, this.zzgqc, zzdgs.zzb(this.zzgqh, zzdgfVar, executor));
    }

    public final zzdcj<O> zza(long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService;
        zzdcd zzdcdVar = this.a;
        E e = this.zzgpx;
        String str = this.zzgpy;
        zzdhe<?> zzdheVar = this.zzgqg;
        List<zzdhe<?>> list = this.zzgqc;
        zzdhe<O> zzdheVar2 = this.zzgqh;
        scheduledExecutorService = zzdcdVar.zzfdi;
        return new zzdcj<>(zzdcdVar, e, str, zzdheVar, list, zzdgs.zza(zzdheVar2, j, timeUnit, scheduledExecutorService));
    }

    public final <O2> zzdcj<O2> zza(zzdgf<O, O2> zzdgfVar) {
        zzdhd zzdhdVar;
        zzdhdVar = this.a.zzfov;
        return zza(zzdgfVar, zzdhdVar);
    }

    public final <T extends Throwable> zzdcj<O> zza(Class<T> cls, final zzdby<T, O> zzdbyVar) {
        return zza(cls, new zzdgf(zzdbyVar) { // from class: com.google.android.gms.internal.ads.zzdck
            private final zzdby zzgqf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqf = zzdbyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return zzdgs.zzaj(this.zzgqf.apply((Throwable) obj));
            }
        });
    }

    public final <T extends Throwable> zzdcj<O> zza(Class<T> cls, zzdgf<T, O> zzdgfVar) {
        zzdhd zzdhdVar;
        zzdcd zzdcdVar = this.a;
        E e = this.zzgpx;
        String str = this.zzgpy;
        zzdhe<?> zzdheVar = this.zzgqg;
        List<zzdhe<?>> list = this.zzgqc;
        zzdhe<O> zzdheVar2 = this.zzgqh;
        zzdhdVar = zzdcdVar.zzfov;
        return new zzdcj<>(zzdcdVar, e, str, zzdheVar, list, zzdgs.zzb(zzdheVar2, cls, zzdgfVar, zzdhdVar));
    }

    public final zzdca<E, O> zzaqg() {
        E e = this.zzgpx;
        String str = this.zzgpy;
        if (str == null) {
            str = this.a.a((zzdcd) e);
        }
        final zzdca<E, O> zzdcaVar = new zzdca<>(e, str, this.zzgqh);
        this.a.zzgqb.zza(zzdcaVar);
        this.zzgqg.addListener(new Runnable(this, zzdcaVar) { // from class: com.google.android.gms.internal.ads.zzdcn
            private final zzdcj zzgqk;
            private final zzdca zzgql;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqk = this;
                this.zzgql = zzdcaVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzdcj zzdcjVar = this.zzgqk;
                zzdcjVar.a.zzgqb.zzb(this.zzgql);
            }
        }, zzazd.zzdwj);
        zzdgs.zza(zzdcaVar, new zzdcm(this, zzdcaVar), zzazd.zzdwj);
        return zzdcaVar;
    }

    public final <O2> zzdcj<O2> zzb(final zzdby<O, O2> zzdbyVar) {
        return zza(new zzdgf(zzdbyVar) { // from class: com.google.android.gms.internal.ads.zzdci
            private final zzdby zzgqf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqf = zzdbyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return zzdgs.zzaj(this.zzgqf.apply(obj));
            }
        });
    }

    public final <O2> zzdcj<O2> zzc(final zzdhe<O2> zzdheVar) {
        return zza(new zzdgf(zzdheVar) { // from class: com.google.android.gms.internal.ads.zzdcl
            private final zzdhe zzfpn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpn = zzdheVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfpn;
            }
        }, zzazd.zzdwj);
    }

    public final zzdcj<O> zzgn(String str) {
        return new zzdcj<>(this.a, this.zzgpx, str, this.zzgqg, this.zzgqc, this.zzgqh);
    }

    public final zzdcj<O> zzw(E e) {
        return this.a.zza((zzdcd) e, zzaqg());
    }
}
