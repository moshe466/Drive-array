package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class zzbd {
    final Intent a;
    private final BroadcastReceiver.PendingResult zzb;
    private boolean zzc = false;
    private final ScheduledFuture<?> zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(final Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.a = intent;
        this.zzb = pendingResult;
        this.zzd = scheduledExecutorService.schedule(new Runnable(this, intent) { // from class: com.google.firebase.iid.zzbc
            private final zzbd zza;
            private final Intent zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = intent;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbd zzbdVar = this.zza;
                String action = this.zzb.getAction();
                StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
                sb.append("Service took too long to process intent: ");
                sb.append(action);
                sb.append(" App may get closed.");
                Log.w("FirebaseInstanceId", sb.toString());
                zzbdVar.a();
            }
        }, 9000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.zzc) {
            this.zzb.finish();
            this.zzd.cancel(false);
            this.zzc = true;
        }
    }
}
