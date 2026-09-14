package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcrr implements zzcub<zzcrs> {
    private final zzdhd zzfov;
    private final Context zzyv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrr(Context context, zzdhd zzdhdVar) {
        this.zzyv = context;
        this.zzfov = zzdhdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcrs a() {
        com.google.android.gms.ads.internal.zzq.zzkq();
        String zzaz = zzawb.zzaz(this.zzyv);
        String string = ((Boolean) zzve.zzoy().zzd(zzzn.zzcpy)).booleanValue() ? this.zzyv.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        com.google.android.gms.ads.internal.zzq.zzkq();
        return new zzcrs(zzaz, string, zzawb.zzba(this.zzyv));
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcrs> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcrq
            private final zzcrr zzgfs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfs = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgfs.a();
            }
        });
    }
}
