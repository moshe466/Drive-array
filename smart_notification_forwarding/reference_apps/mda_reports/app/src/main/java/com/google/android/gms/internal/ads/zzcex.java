package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcex implements zzdgt<String> {
    final /* synthetic */ zzceq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcex(zzceq zzceqVar) {
        this.a = zzceqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        long j;
        Executor executor;
        final String str2 = str;
        synchronized (this) {
            zzceq.a(this.a, true);
            zzceq zzceqVar = this.a;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
            j = this.a.zzftn;
            zzceqVar.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (elapsedRealtime - j));
            executor = this.a.executor;
            executor.execute(new Runnable(this, str2) { // from class: com.google.android.gms.internal.ads.zzcfa
                private final String zzcyr;
                private final zzcex zzfue;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfue = this;
                    this.zzcyr = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcex zzcexVar = this.zzfue;
                    zzcexVar.a.zzgf(this.zzcyr);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        long j;
        zzazl zzazlVar;
        synchronized (this) {
            zzceq.a(this.a, true);
            zzceq zzceqVar = this.a;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
            j = this.a.zzftn;
            zzceqVar.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (elapsedRealtime - j));
            zzazlVar = this.a.zzfto;
            zzazlVar.setException(new Exception());
        }
    }
}
