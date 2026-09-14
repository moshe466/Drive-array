package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcqm implements zzcub<zzcqn> {
    private final zzczu zzfgl;
    private final zzdhd zzfov;

    public zzcqm(zzdhd zzdhdVar, zzczu zzczuVar) {
        this.zzfov = zzdhdVar;
        this.zzfgl = zzczuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcqn a() {
        return new zzcqn(this.zzfgl.zzgmp);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcqn> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcqp
            private final zzcqm zzgez;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgez = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgez.a();
            }
        });
    }
}
