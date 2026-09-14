package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcvi implements zzcub<zzcvj> {
    private String packageName;
    private zzdhd zzfov;
    private zzauw zzghy;

    public zzcvi(zzauw zzauwVar, zzdhd zzdhdVar, String str) {
        this.zzghy = zzauwVar;
        this.zzfov = zzdhdVar;
        this.packageName = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcvj> zzanc() {
        new zzazl();
        final zzdhe<String> zzaj = zzdgs.zzaj(null);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcpj)).booleanValue()) {
            zzaj = this.zzghy.zzeb(this.packageName);
        }
        final zzdhe<String> zzec = this.zzghy.zzec(this.packageName);
        return zzdgs.zzb(zzaj, zzec).zza(new Callable(zzaj, zzec) { // from class: com.google.android.gms.internal.ads.zzcvl
            private final zzdhe zzfpa;
            private final zzdhe zzfpn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpn = zzaj;
                this.zzfpa = zzec;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcvj((String) this.zzfpn.get(), (String) this.zzfpa.get());
            }
        }, zzazd.zzdwe);
    }
}
