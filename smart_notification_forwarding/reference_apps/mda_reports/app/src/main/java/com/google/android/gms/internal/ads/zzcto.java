package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcto implements zzcub<zzctp> {
    private final zzatv zzbng;
    private final zzdhd zzfov;
    private final Context zzup;

    public zzcto(zzatv zzatvVar, zzdhd zzdhdVar, Context context) {
        this.zzbng = zzatvVar;
        this.zzfov = zzdhdVar;
        this.zzup = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzctp a() {
        if (!this.zzbng.zzab(this.zzup)) {
            return new zzctp(null, null, null, null, null);
        }
        String zzae = this.zzbng.zzae(this.zzup);
        String str = zzae == null ? "" : zzae;
        String zzaf = this.zzbng.zzaf(this.zzup);
        String str2 = zzaf == null ? "" : zzaf;
        String zzag = this.zzbng.zzag(this.zzup);
        String str3 = zzag == null ? "" : zzag;
        String zzah = this.zzbng.zzah(this.zzup);
        return new zzctp(str, str2, str3, zzah == null ? "" : zzah, "TIME_OUT".equals(str2) ? (Long) zzve.zzoy().zzd(zzzn.zzcie) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzctp> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzctr
            private final zzcto zzggs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggs = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzggs.a();
            }
        });
    }
}
