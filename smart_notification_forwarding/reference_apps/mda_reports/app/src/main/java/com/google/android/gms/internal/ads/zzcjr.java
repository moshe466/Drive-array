package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcjr implements zzcio<zzbkk> {
    private final ScheduledExecutorService zzffx;
    private final zzbou zzfik;
    private final zzdhd zzfov;
    private final zzblg zzfyy;
    private final zzcix zzfyz;

    public zzcjr(zzblg zzblgVar, zzcix zzcixVar, zzbou zzbouVar, ScheduledExecutorService scheduledExecutorService, zzdhd zzdhdVar) {
        this.zzfyy = zzblgVar;
        this.zzfyz = zzcixVar;
        this.zzfik = zzbouVar;
        this.zzffx = scheduledExecutorService;
        this.zzfov = zzdhdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbkk a(final zzczt zzcztVar, final zzczl zzczlVar) {
        return this.zzfyy.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzbls(zzcztVar.zzgmh.zzfgl.zzaoo(), new Runnable(this, zzcztVar, zzczlVar) { // from class: com.google.android.gms.internal.ads.zzcjt
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzcjr zzfzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzb = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfzb.b(this.zzfot, this.zzfel);
            }
        })).zzaef();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzczt zzcztVar, zzczl zzczlVar) {
        zzdgs.zza(zzdgs.zza(this.zzfyz.zzb(zzcztVar, zzczlVar), zzczlVar.zzglx, TimeUnit.SECONDS, this.zzffx), new zzcjw(this), this.zzfov);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        return zzcztVar.zzgmh.zzfgl.zzaoo() != null && this.zzfyz.zza(zzcztVar, zzczlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<zzbkk> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        return this.zzfov.submit(new Callable(this, zzcztVar, zzczlVar) { // from class: com.google.android.gms.internal.ads.zzcju
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzcjr zzfzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzb = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzfzb.a(this.zzfot, this.zzfel);
            }
        });
    }
}
