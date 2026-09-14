package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcqz implements zzcub<zzcqw> {
    private final Executor executor;
    private final ScheduledExecutorService zzffx;
    private final Context zzup;

    public zzcqz(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzup = context;
        this.zzffx = scheduledExecutorService;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcqw> zzanc() {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcqj)).booleanValue()) {
            return zzdgs.zzaj(null);
        }
        final zzazl zzazlVar = new zzazl();
        try {
            new zzddw(zzazlVar) { // from class: com.google.android.gms.internal.ads.zzcqy
                private final zzazl zzbru;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbru = zzazlVar;
                }

                @Override // com.google.android.gms.internal.ads.zzddw
                public final void zzbk(boolean z) {
                    this.zzbru.set(false);
                }
            }.zzbk(false);
        } catch (Throwable unused) {
            zzayu.zzex("ArCoreApk is not ready.");
            zzazlVar.set(false);
        }
        return zzdgs.zzb(zzdgs.zzb(zzdgs.zza(zzazlVar, 200L, TimeUnit.MILLISECONDS, this.zzffx), new zzded(this) { // from class: com.google.android.gms.internal.ads.zzcrb
            private final zzcqz zzgfi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfi = this;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                return new zzcqw(false, false, ((Boolean) obj).booleanValue());
            }
        }, this.executor), Throwable.class, zzcra.a, this.executor);
    }
}
