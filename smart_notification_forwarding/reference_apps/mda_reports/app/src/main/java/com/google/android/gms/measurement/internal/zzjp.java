package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzks;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjp {
    final /* synthetic */ zzjo a;
    private zzju zzb;
    private final Runnable zzc = new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzjs
        private final zzjp zza;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.zza = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            zzjp zzjpVar = this.zza;
            zzjpVar.a.zzq().zza(new Runnable(zzjpVar) { // from class: com.google.android.gms.measurement.internal.zzjr
                private final zzjp zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = zzjpVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzjp zzjpVar2 = this.zza;
                    zzjpVar2.a.zzd();
                    zzjpVar2.a.zzr().zzw().zza("Application backgrounded");
                    zzjpVar2.a.zzf().a("auto", "_ab", new Bundle());
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjp(zzjo zzjoVar) {
        this.a = zzjoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a() {
        Handler handler;
        Handler handler2;
        this.a.zzd();
        if (this.a.zzt().zza(zzap.zzcd)) {
            if (!zzks.zzb() || !this.a.zzt().zze(this.a.zzg().zzab(), zzap.zzcq)) {
                handler = this.a.zzc;
                handler.removeCallbacks(this.zzc);
            } else if (this.zzb != null) {
                handler2 = this.a.zzc;
                handler2.removeCallbacks(this.zzb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b() {
        Handler handler;
        Handler handler2;
        if (this.a.zzt().zza(zzap.zzcd)) {
            if (!zzks.zzb() || !this.a.zzt().zze(this.a.zzg().zzab(), zzap.zzcq)) {
                handler = this.a.zzc;
                handler.postDelayed(this.zzc, 2000L);
            } else {
                this.zzb = new zzju(this, this.a.zzm().currentTimeMillis());
                handler2 = this.a.zzc;
                handler2.postDelayed(this.zzb, 2000L);
            }
        }
    }
}
