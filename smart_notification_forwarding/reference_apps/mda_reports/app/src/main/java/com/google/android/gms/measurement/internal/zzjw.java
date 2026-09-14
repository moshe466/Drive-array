package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjw {

    @VisibleForTesting
    private long zza;

    @VisibleForTesting
    private long zzb;
    private final zzaf zzc;
    private final /* synthetic */ zzjo zzd;

    public zzjw(zzjo zzjoVar) {
        this.zzd = zzjoVar;
        this.zzc = new zzjv(this, this.zzd.a);
        this.zza = zzjoVar.zzm().elapsedRealtime();
        this.zzb = this.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false);
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.zzc.a();
        this.zza = 0L;
        this.zzb = this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(long j) {
        this.zzd.zzd();
        this.zzc.a();
        this.zza = j;
        this.zzb = this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final long b() {
        long elapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = elapsedRealtime - this.zzb;
        this.zzb = elapsedRealtime;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(long j) {
        this.zzc.a();
        if (this.zza != 0) {
            this.zzd.zzs().zzr.zza(this.zzd.zzs().zzr.zza() + (j - this.zza));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c4, code lost:
    
        if (r10 == false) goto L23;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjw.zza(boolean, boolean):boolean");
    }
}
