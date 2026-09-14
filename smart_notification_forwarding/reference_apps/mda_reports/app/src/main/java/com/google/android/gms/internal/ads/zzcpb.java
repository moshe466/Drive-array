package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzbrm;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcpb implements zzcox<zzbmd> {
    private final zzbfx zzfzz;
    private final Context zzgcr;

    @GuardedBy("this")
    private final zzczw zzgcs;
    private final zzcov zzgds;

    @Nullable
    @GuardedBy("this")
    private zzbmo zzgdt;

    public zzcpb(zzbfx zzbfxVar, Context context, zzcov zzcovVar, zzczw zzczwVar) {
        this.zzfzz = zzbfxVar;
        this.zzgcr = context;
        this.zzgds = zzcovVar;
        this.zzgcs = zzczwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.zzgds.zzamu().onAdFailedToLoad(1);
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final boolean isLoading() {
        zzbmo zzbmoVar = this.zzgdt;
        return zzbmoVar != null && zzbmoVar.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final boolean zza(zzug zzugVar, String str, zzcpa zzcpaVar, zzcoz<? super zzbmd> zzcozVar) {
        if (str == null) {
            zzayu.zzex("Ad unit ID should not be null for NativeAdLoader.");
            this.zzfzz.zzaca().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcpe
                private final zzcpb zzgdy;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgdy = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgdy.a();
                }
            });
            return false;
        }
        zzdad.zze(this.zzgcr, zzugVar.zzccb);
        zzczu zzaos = this.zzgcs.zzg(zzugVar).zzdl(zzcpaVar instanceof zzcpc ? ((zzcpc) zzcpaVar).zzgdu : 1).zzaos();
        zzbvm zzadf = this.zzfzz.zzacl().zza(new zzbod.zza().zzbz(this.zzgcr).zza(zzaos).zzahh()).zza(new zzbrm.zza().zza(this.zzgds.zzamt(), this.zzfzz.zzaca()).zza(this.zzgds.zzamu(), this.zzfzz.zzaca()).zza(this.zzgds.zzamv(), this.zzfzz.zzaca()).zza(this.zzgds.zzamw(), this.zzfzz.zzaca()).zza(this.zzgds.zzams(), this.zzfzz.zzaca()).zza(zzaos.zzgmr, this.zzfzz.zzaca()).zzahw()).zza(this.zzgds.zzamr()).zzadf();
        zzadf.zzade().zzdm(1);
        this.zzgdt = new zzbmo(this.zzfzz.zzacc(), this.zzfzz.zzacb(), zzadf.zzadc().zzaha());
        this.zzgdt.zza(new zzcpd(this, zzcozVar, zzadf));
        return true;
    }
}
