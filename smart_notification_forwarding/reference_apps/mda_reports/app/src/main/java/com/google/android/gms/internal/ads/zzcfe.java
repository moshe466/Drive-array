package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcfe {
    private final zzdhd zzfov;
    private final zzdhd zzfuj;
    private final zzcgi zzfuk;
    private final zzdxa<zzcgw> zzful;

    public zzcfe(zzdhd zzdhdVar, zzdhd zzdhdVar2, zzcgi zzcgiVar, zzdxa<zzcgw> zzdxaVar) {
        this.zzfuj = zzdhdVar;
        this.zzfov = zzdhdVar2;
        this.zzfuk = zzcgiVar;
        this.zzful = zzdxaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzaqk zzaqkVar, zzcgr zzcgrVar) {
        return this.zzful.get().zzh(zzaqkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream a(zzaqk zzaqkVar) {
        return this.zzfuk.zzf(zzaqkVar).get(((Integer) zzve.zzoy().zzd(zzzn.zzcox)).intValue(), TimeUnit.SECONDS);
    }

    public final zzdhe<InputStream> zzc(final zzaqk zzaqkVar) {
        String str = zzaqkVar.packageName;
        com.google.android.gms.ads.internal.zzq.zzkq();
        return zzdgs.zzb(zzawb.zzem(str) ? zzdgs.zzk(new zzcgr(0)) : zzdgs.zzb(this.zzfuj.submit(new Callable(this, zzaqkVar) { // from class: com.google.android.gms.internal.ads.zzcfd
            private final zzcfe zzfuh;
            private final zzaqk zzfui;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfuh = this;
                this.zzfui = zzaqkVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzfuh.a(this.zzfui);
            }
        }), ExecutionException.class, zzcfg.a, this.zzfov), zzcgr.class, new zzdgf(this, zzaqkVar) { // from class: com.google.android.gms.internal.ads.zzcff
            private final zzcfe zzfuh;
            private final zzaqk zzfui;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfuh = this;
                this.zzfui = zzaqkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfuh.a(this.zzfui, (zzcgr) obj);
            }
        }, this.zzfov);
    }
}
