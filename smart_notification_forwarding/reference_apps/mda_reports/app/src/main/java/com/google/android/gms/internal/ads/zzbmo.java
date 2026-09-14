package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzbmo {
    private final Executor executor;
    private volatile boolean zzadd = true;
    private final ScheduledExecutorService zzffx;
    private final zzdhe<zzbmj> zzffy;

    public zzbmo(Executor executor, ScheduledExecutorService scheduledExecutorService, zzdhe<zzbmj> zzdheVar) {
        this.executor = executor;
        this.zzffx = scheduledExecutorService;
        this.zzffy = zzdheVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(List<? extends zzdhe<? extends zzbmd>> list, final zzdgt<zzbmd> zzdgtVar) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new Runnable(zzdgtVar) { // from class: com.google.android.gms.internal.ads.zzbmn
                private final zzdgt zzffw;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzffw = zzdgtVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzffw.zzb(new zzcfb(3));
                }
            });
            return;
        }
        zzdhe zzaj = zzdgs.zzaj(null);
        for (final zzdhe<? extends zzbmd> zzdheVar : list) {
            zzaj = zzdgs.zzb(zzdgs.zzb(zzaj, Throwable.class, new zzdgf(zzdgtVar) { // from class: com.google.android.gms.internal.ads.zzbmq
                private final zzdgt zzffw;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzffw = zzdgtVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdgf
                public final zzdhe zzf(Object obj) {
                    this.zzffw.zzb((Throwable) obj);
                    return zzdgs.zzaj(null);
                }
            }, this.executor), new zzdgf(this, zzdgtVar, zzdheVar) { // from class: com.google.android.gms.internal.ads.zzbmp
                private final zzbmo zzffz;
                private final zzdgt zzfga;
                private final zzdhe zzfgb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzffz = this;
                    this.zzfga = zzdgtVar;
                    this.zzfgb = zzdheVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdgf
                public final zzdhe zzf(Object obj) {
                    return this.zzffz.a(this.zzfga, this.zzfgb, (zzbmd) obj);
                }
            }, this.executor);
        }
        zzdgs.zza(zzaj, new zzbmu(this, zzdgtVar), this.executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzagu() {
        zzazd.zzdwi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbms
            private final zzbmo zzffz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzffz = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzffz.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzdgt zzdgtVar, zzdhe zzdheVar, zzbmd zzbmdVar) {
        if (zzbmdVar != null) {
            zzdgtVar.onSuccess(zzbmdVar);
        }
        return zzdgs.zza(zzdheVar, zzabj.zzcur.get().longValue(), TimeUnit.MILLISECONDS, this.zzffx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.zzadd = false;
    }

    public final boolean isLoading() {
        return this.zzadd;
    }

    public final void zza(zzdgt<zzbmd> zzdgtVar) {
        zzdgs.zza(this.zzffy, new zzbmr(this, zzdgtVar), this.executor);
    }
}
