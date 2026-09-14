package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcvd implements zzcub<zzcva> {
    zzsa a;
    Context b;
    private zzdhd zzfov;

    public zzcvd(zzsa zzsaVar, zzdhd zzdhdVar, Context context) {
        this.a = zzsaVar;
        this.zzfov = zzdhdVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcva> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcvc
            private final zzcvd zzghu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzghu = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcvd zzcvdVar = this.zzghu;
                return new zzcva(zzcvdVar.a.zzf(zzcvdVar.b));
            }
        });
    }
}
