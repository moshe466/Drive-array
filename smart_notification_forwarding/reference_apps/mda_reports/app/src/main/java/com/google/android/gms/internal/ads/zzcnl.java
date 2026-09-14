package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcnl<AdT> implements zzcio<AdT> {
    private final zzdcr zzfgm;
    private final zzdhd zzgbh;

    @Nullable
    private final zzaak zzgbn;
    private final zzcnq<AdT> zzgbr;

    public zzcnl(zzdcr zzdcrVar, zzdhd zzdhdVar, @Nullable zzaak zzaakVar, zzcnq<AdT> zzcnqVar) {
        this.zzfgm = zzdcrVar;
        this.zzgbh = zzdhdVar;
        this.zzgbn = zzaakVar;
        this.zzgbr = zzcnqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzaad zzaadVar) {
        this.zzgbn.zza(zzaadVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        zzczp zzczpVar;
        return (this.zzgbn == null || (zzczpVar = zzczlVar.zzglo) == null || zzczpVar.zzdht == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<AdT> zzb(zzczt zzcztVar, zzczl zzczlVar) {
        zzazl zzazlVar = new zzazl();
        zzcnt zzcntVar = new zzcnt();
        zzcntVar.zza(new zzcnn(this, zzazlVar, zzcztVar, zzczlVar, zzcntVar));
        zzczp zzczpVar = zzczlVar.zzglo;
        final zzaad zzaadVar = new zzaad(zzcntVar, zzczpVar.zzdhr, zzczpVar.zzdht);
        return this.zzfgm.zzu(zzdco.CUSTOM_RENDER_SYN).zza(new zzdcb(this, zzaadVar) { // from class: com.google.android.gms.internal.ads.zzcno
            private final zzaad zzgbp;
            private final zzcnl zzgbx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbx = this;
                this.zzgbp = zzaadVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdcb
            public final void run() {
                this.zzgbx.a(this.zzgbp);
            }
        }, this.zzgbh).zzw(zzdco.CUSTOM_RENDER_ACK).zzc(zzazlVar).zzaqg();
    }
}
