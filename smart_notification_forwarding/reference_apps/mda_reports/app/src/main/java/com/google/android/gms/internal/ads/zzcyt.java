package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzbrm;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcyt implements zzcox<zzcbb> {
    private final Executor zzfci;
    private final zzczs zzfhh;

    @GuardedBy("this")
    private final zzczw zzgcs;
    private final zzbfx zzgea;
    private final Context zzgim;
    private final zzcxt<zzcbi, zzcbb> zzgio;
    private final zzcxz zzgks;

    @GuardedBy("this")
    private zzdhe<zzcbb> zzgkt;

    public zzcyt(Context context, Executor executor, zzbfx zzbfxVar, zzcxt<zzcbi, zzcbb> zzcxtVar, zzcxz zzcxzVar, zzczw zzczwVar, zzczs zzczsVar) {
        this.zzgim = context;
        this.zzfci = executor;
        this.zzgea = zzbfxVar;
        this.zzgio = zzcxtVar;
        this.zzgks = zzcxzVar;
        this.zzgcs = zzczwVar;
        this.zzfhh = zzczsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcbh a(zzcxs zzcxsVar) {
        zzcyx zzcyxVar = (zzcyx) zzcxsVar;
        zzcxz zza = zzcxz.zza(this.zzgks);
        zzbrm.zza zzaVar = new zzbrm.zza();
        zzaVar.zza((zzbov) zza, this.zzfci);
        zzaVar.zza((zzbqb) zza, this.zzfci);
        zzaVar.zza((zzbow) zza, this.zzfci);
        zzaVar.zza((AdMetadataListener) zza, this.zzfci);
        zzaVar.zza((zzbpa) zza, this.zzfci);
        zzaVar.zza(zza);
        return this.zzgea.zzacm().zze(new zzbod.zza().zzbz(this.zzgim).zza(zzcyxVar.zzfgl).zzfs(zzcyxVar.zzgkq).zza(this.zzfhh).zzahh()).zze(zzaVar.zzahw());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.zzgcs.zzgms.add("new_rewarded");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        this.zzgks.onAdFailedToLoad(1);
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final boolean isLoading() {
        zzdhe<zzcbb> zzdheVar = this.zzgkt;
        return (zzdheVar == null || zzdheVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final boolean zza(zzug zzugVar, String str, zzcpa zzcpaVar, zzcoz<? super zzcbb> zzcozVar) {
        zzaru zzaruVar = new zzaru(zzugVar, str);
        zzcyu zzcyuVar = null;
        String str2 = zzcpaVar instanceof zzcyq ? ((zzcyq) zzcpaVar).zzgkq : null;
        if (zzaruVar.zzbqz == null) {
            zzayu.zzex("Ad unit ID should not be null for rewarded video ad.");
            this.zzfci.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcys
                private final zzcyt zzgkr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgkr = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgkr.b();
                }
            });
            return false;
        }
        zzdhe<zzcbb> zzdheVar = this.zzgkt;
        if (zzdheVar != null && !zzdheVar.isDone()) {
            return false;
        }
        zzdad.zze(this.zzgim, zzaruVar.zzdio.zzccb);
        zzczu zzaos = this.zzgcs.zzgk(zzaruVar.zzbqz).zzd(zzuj.zzol()).zzg(zzaruVar.zzdio).zzaos();
        zzcyx zzcyxVar = new zzcyx(zzcyuVar);
        zzcyxVar.zzfgl = zzaos;
        zzcyxVar.zzgkq = str2;
        this.zzgkt = this.zzgio.zza(zzcyxVar, new zzcxv(this) { // from class: com.google.android.gms.internal.ads.zzcyv
            private final zzcyt zzgkr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkr = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcxv
            public final zzboe zzc(zzcxs zzcxsVar) {
                return this.zzgkr.a(zzcxsVar);
            }
        });
        zzdgs.zza(this.zzgkt, new zzcyu(this, zzcozVar), this.zzfci);
        return true;
    }
}
