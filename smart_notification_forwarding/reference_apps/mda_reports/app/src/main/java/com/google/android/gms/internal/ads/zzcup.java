package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcup implements zzcub<zzcum> {
    private final Executor executor;
    private final ScheduledExecutorService zzffx;
    private final zzava zzghl;
    private final Context zzup;

    public zzcup(zzava zzavaVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzghl = zzavaVar;
        this.zzup = context;
        this.zzffx = scheduledExecutorService;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcum a(Throwable th) {
        zzve.zzou();
        return new zzcum(null, zzayk.zzbj(this.zzup));
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcum> zzanc() {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcjd)).booleanValue()) {
            return zzdgs.zzk(new Exception("Did not ad Ad ID into query param."));
        }
        return zzdgn.zze(this.zzghl.zzak(this.zzup)).zza(zzcuo.a, this.executor).zza(((Long) zzve.zzoy().zzd(zzzn.zzcje)).longValue(), TimeUnit.MILLISECONDS, this.zzffx).zza(Throwable.class, new zzded(this) { // from class: com.google.android.gms.internal.ads.zzcur
            private final zzcup zzghm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzghm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                return this.zzghm.a((Throwable) obj);
            }
        }, this.executor);
    }
}
