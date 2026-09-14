package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcvm implements zzcub<zzcvn> {
    zzyz a;
    List<String> b;
    private zzdhd zzfov;

    public zzcvm(zzyz zzyzVar, zzdhd zzdhdVar, List<String> list) {
        this.a = zzyzVar;
        this.zzfov = zzdhdVar;
        this.b = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcvn> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcvp
            private final zzcvm zzgic;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgic = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcvm zzcvmVar = this.zzgic;
                return new zzcvn(zzcvmVar.a.zzd(zzcvmVar.b));
            }
        });
    }
}
