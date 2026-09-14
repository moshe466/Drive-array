package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbix implements zzafn<Object> {
    final /* synthetic */ zzbiy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbix(zzbiy zzbiyVar) {
        this.a = zzbiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        boolean zzl;
        Executor executor;
        zzl = this.a.zzl(map);
        if (zzl) {
            executor = this.a.executor;
            executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbja
                private final zzbix zzfcb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfcb = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbjd zzbjdVar;
                    zzbjdVar = this.zzfcb.a.zzfby;
                    zzbjdVar.zzafn();
                }
            });
        }
    }
}
