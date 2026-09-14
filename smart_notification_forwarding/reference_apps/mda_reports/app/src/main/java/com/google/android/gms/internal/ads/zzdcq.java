package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
final class zzdcq extends zzbrl<zzdcx> implements zzdcp<zzdco> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdcq(Set<zzbsu<zzdcx>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdcp
    public final void zza(final zzdca<zzdco, ?> zzdcaVar) {
        a(new zzbrn(zzdcaVar) { // from class: com.google.android.gms.internal.ads.zzdct
            private final zzdca zzgrk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrk = zzdcaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                zzdca zzdcaVar2 = this.zzgrk;
                ((zzdcx) obj).zza((zzdco) zzdcaVar2.zzaqd(), zzdcaVar2.zzaqe());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcp
    public final void zza(final zzdca<zzdco, ?> zzdcaVar, final Throwable th) {
        a(new zzbrn(zzdcaVar, th) { // from class: com.google.android.gms.internal.ads.zzdcv
            private final zzdca zzgrk;
            private final Throwable zzgrl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrk = zzdcaVar;
                this.zzgrl = th;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                zzdca zzdcaVar2 = this.zzgrk;
                ((zzdcx) obj).zza((zzdco) zzdcaVar2.zzaqd(), zzdcaVar2.zzaqe(), this.zzgrl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcp
    public final void zzb(final zzdca<zzdco, ?> zzdcaVar) {
        a(new zzbrn(zzdcaVar) { // from class: com.google.android.gms.internal.ads.zzdcs
            private final zzdca zzgrk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrk = zzdcaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                zzdca zzdcaVar2 = this.zzgrk;
                ((zzdcx) obj).zzb((zzdco) zzdcaVar2.zzaqd(), zzdcaVar2.zzaqe());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcp
    public final void zzc(final zzdca<zzdco, ?> zzdcaVar) {
        a(new zzbrn(zzdcaVar) { // from class: com.google.android.gms.internal.ads.zzdcu
            private final zzdca zzgrk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrk = zzdcaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                zzdca zzdcaVar2 = this.zzgrk;
                ((zzdcx) obj).zzc((zzdco) zzdcaVar2.zzaqd(), zzdcaVar2.zzaqe());
            }
        });
    }
}
