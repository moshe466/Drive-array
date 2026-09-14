package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbpu;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzcna<AdT, AdapterT, ListenerT extends zzbpu> implements zzcio<AdT> {
    private final zzcis<AdapterT, ListenerT> zzfaq;
    private final zzdcr zzfgm;
    private final zzcir<AdT, AdapterT, ListenerT> zzgbg;
    private final zzdhd zzgbh;

    public zzcna(zzdcr zzdcrVar, zzdhd zzdhdVar, zzcis<AdapterT, ListenerT> zzcisVar, zzcir<AdT, AdapterT, ListenerT> zzcirVar) {
        this.zzfgm = zzdcrVar;
        this.zzgbh = zzdhdVar;
        this.zzgbg = zzcirVar;
        this.zzfaq = zzcisVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object a(zzczt zzcztVar, zzczl zzczlVar, zzcip zzcipVar, Void r4) {
        return this.zzgbg.zzb(zzcztVar, zzczlVar, zzcipVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzczt zzcztVar, zzczl zzczlVar, zzcip zzcipVar) {
        this.zzgbg.zza(zzcztVar, zzczlVar, zzcipVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        return !zzczlVar.zzglp.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<AdT> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        final zzcip<AdapterT, ListenerT> zzcipVar;
        Iterator<String> it = zzczlVar.zzglp.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcipVar = null;
                break;
            }
            try {
                zzcipVar = this.zzfaq.zzd(it.next(), zzczlVar.zzglr);
                break;
            } catch (zzdab unused) {
            }
        }
        if (zzcipVar == null) {
            return zzdgs.zzk(new zzclf("unable to instantiate mediation adapter class"));
        }
        zzazl zzazlVar = new zzazl();
        zzcipVar.zzfyf.zza(new zzcnb(this, zzazlVar, zzcipVar));
        if (zzczlVar.zzdmf) {
            Bundle bundle = zzcztVar.zzgmh.zzfgl.zzgml.zzccf;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfgm.zzu(zzdco.ADAPTER_LOAD_AD_SYN).zza(new zzdcb(this, zzcztVar, zzczlVar, zzcipVar) { // from class: com.google.android.gms.internal.ads.zzcmz
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzcip zzgau;
            private final zzcna zzgbf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbf = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
                this.zzgau = zzcipVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdcb
            public final void run() {
                this.zzgbf.a(this.zzfot, this.zzfel, this.zzgau);
            }
        }, this.zzgbh).zzw(zzdco.ADAPTER_LOAD_AD_ACK).zzc(zzazlVar).zzw(zzdco.ADAPTER_WRAP_ADAPTER).zzb(new zzdby(this, zzcztVar, zzczlVar, zzcipVar) { // from class: com.google.android.gms.internal.ads.zzcnc
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzcip zzgau;
            private final zzcna zzgbf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbf = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
                this.zzgau = zzcipVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdby
            public final Object apply(Object obj) {
                return this.zzgbf.a(this.zzfot, this.zzfel, this.zzgau, (Void) obj);
            }
        }).zzaqg();
    }
}
