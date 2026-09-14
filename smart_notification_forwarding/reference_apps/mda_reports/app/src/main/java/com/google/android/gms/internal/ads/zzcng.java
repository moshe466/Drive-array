package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcng implements zzcio<zzbkk> {
    private final zzdcr zzfgm;
    private final zzblg zzfyj;
    private final zzdhd zzgbh;
    private final Context zzgbm;

    @Nullable
    private final zzaak zzgbn;

    public zzcng(Context context, zzblg zzblgVar, zzdcr zzdcrVar, zzdhd zzdhdVar, @Nullable zzaak zzaakVar) {
        this.zzgbm = context;
        this.zzfyj = zzblgVar;
        this.zzfgm = zzdcrVar;
        this.zzgbh = zzdhdVar;
        this.zzgbn = zzaakVar;
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
    public final zzdhe<zzbkk> zzb(zzczt zzcztVar, zzczl zzczlVar) {
        zzbkj zza = this.zzfyj.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzcnh(this, new View(this.zzgbm), null, zzcnf.a, zzczlVar.zzglq.get(0)));
        zzcnk zzaej = zza.zzaej();
        zzczp zzczpVar = zzczlVar.zzglo;
        final zzaad zzaadVar = new zzaad(zzaej, zzczpVar.zzdhr, zzczpVar.zzdht);
        return this.zzfgm.zzu(zzdco.CUSTOM_RENDER_SYN).zza(new zzdcb(this, zzaadVar) { // from class: com.google.android.gms.internal.ads.zzcni
            private final zzcng zzgbo;
            private final zzaad zzgbp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = this;
                this.zzgbp = zzaadVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdcb
            public final void run() {
                this.zzgbo.a(this.zzgbp);
            }
        }, this.zzgbh).zzw(zzdco.CUSTOM_RENDER_ACK).zzc(zzdgs.zzaj(zza.zzaeh())).zzaqg();
    }
}
