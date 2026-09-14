package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcss implements zzcub<zzcst> {
    private final zzdhd zzgej;
    private final Set<String> zzgeu;
    private final Context zzup;

    public zzcss(zzdhd zzdhdVar, Context context, Set<String> set) {
        this.zzgej = zzdhdVar;
        this.zzup = context;
        this.zzgeu = set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcst a() {
        boolean zzd;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue()) {
            zzd = zzcst.zzd(this.zzgeu);
            if (zzd) {
                return new zzcst(com.google.android.gms.ads.internal.zzq.zzlf().getVersion(this.zzup));
            }
        }
        return new zzcst(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcst> zzanc() {
        return this.zzgej.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcsv
            private final zzcss zzggd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggd = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzggd.a();
            }
        });
    }
}
