package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbob;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcxf<R extends zzbob<AdT>, AdT extends zzbmd> implements zzcxt<R, zzdbi<AdT>> {
    private final Executor executor = zzdhg.zzarw();
    private R zzgjp;

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final zzdhe<zzdbi<AdT>> zza(zzcxs zzcxsVar, zzcxv<R> zzcxvVar) {
        zzboe<R> zzc = zzcxvVar.zzc(zzcxsVar);
        zzc.zza(new zzcxw(true));
        this.zzgjp = zzc.zzadg();
        final zzbmz zzadc = this.zzgjp.zzadc();
        final zzdbi zzdbiVar = new zzdbi();
        return ((zzdgn) zzdgs.zzb(zzdgn.zze(zzadc.zzagz()), new zzdgf(this, zzdbiVar, zzadc) { // from class: com.google.android.gms.internal.ads.zzcxe
            private final zzcxf zzgjm;
            private final zzdbi zzgjn;
            private final zzbmz zzgjo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjm = this;
                this.zzgjn = zzdbiVar;
                this.zzgjo = zzadc;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                zzdbi zzdbiVar2 = this.zzgjn;
                zzbmz zzbmzVar = this.zzgjo;
                zzczt zzcztVar = (zzczt) obj;
                zzdbiVar2.zzelt = zzcztVar;
                Iterator<zzczl> it = zzcztVar.zzgmi.zzgme.iterator();
                boolean z = false;
                boolean z2 = false;
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    Iterator<String> it2 = it.next().zzgli.iterator();
                    while (it2.hasNext()) {
                        if (!it2.next().contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z2 = true;
                    }
                }
                return !z ? zzdgs.zzaj(null) : zzbmzVar.zza(zzdgs.zzaj(zzcztVar));
            }
        }, this.executor)).zza(new zzded(zzdbiVar) { // from class: com.google.android.gms.internal.ads.zzcxh
            private final zzdbi zzgjz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjz = zzdbiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                zzdbi zzdbiVar2 = this.zzgjz;
                zzdbiVar2.zzgpd = (AdT) obj;
                return zzdbiVar2;
            }
        }, this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final /* synthetic */ Object zzaog() {
        return this.zzgjp;
    }
}
