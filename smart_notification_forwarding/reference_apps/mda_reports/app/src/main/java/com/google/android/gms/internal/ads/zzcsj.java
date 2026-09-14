package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcsj implements zzcub<zzcsg> {
    private final zzczj zzfbj;
    private final zzdhd zzfov;

    public zzcsj(zzdhd zzdhdVar, zzczj zzczjVar) {
        this.zzfov = zzdhdVar;
        this.zzfbj = zzczjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcsg a() {
        return new zzcsg(this.zzfbj);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcsg> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcsi
            private final zzcsj zzgfy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfy = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgfy.a();
            }
        });
    }
}
