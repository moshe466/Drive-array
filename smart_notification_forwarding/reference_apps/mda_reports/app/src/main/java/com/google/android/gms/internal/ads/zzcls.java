package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class zzcls<T> implements zzdgt<T> {
    private final /* synthetic */ String zzgae;
    private final /* synthetic */ long zzgaf;
    private final /* synthetic */ zzclp zzgag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcls(zzclp zzclpVar, String str, long j) {
        this.zzgag = zzclpVar;
        this.zzgae = str;
        this.zzgaf = j;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void onSuccess(T t) {
        Clock clock;
        clock = this.zzgag.zzbmq;
        this.zzgag.zza(this.zzgae, 0, clock.elapsedRealtime() - this.zzgaf);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        Clock clock;
        clock = this.zzgag.zzbmq;
        long elapsedRealtime = clock.elapsedRealtime();
        int i = 3;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (!(th instanceof zzclf)) {
            i = th instanceof CancellationException ? 4 : ((th instanceof zzcfb) && ((zzcfb) th).getErrorCode() == 3) ? 1 : 6;
        }
        this.zzgag.zza(this.zzgae, i, elapsedRealtime - this.zzgaf);
    }
}
