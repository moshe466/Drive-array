package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzbrm;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcwl implements zzcox<zzbke> {
    private final Executor zzfci;
    private final ViewGroup zzfdu;

    @GuardedBy("this")
    private final zzczw zzgcs;

    @GuardedBy("this")
    @Nullable
    private zzdhe<zzbke> zzgdb;
    private final zzbfx zzgea;
    private final Context zzgim;
    private final zzcwz zzgin;
    private final zzcxt<zzbka, zzbke> zzgio;

    public zzcwl(Context context, Executor executor, zzbfx zzbfxVar, zzcxt<zzbka, zzbke> zzcxtVar, zzcwz zzcwzVar, zzczw zzczwVar) {
        this.zzgim = context;
        this.zzfci = executor;
        this.zzgea = zzbfxVar;
        this.zzgio = zzcxtVar;
        this.zzgin = zzcwzVar;
        this.zzgcs = zzczwVar;
        this.zzfdu = new FrameLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzdhe a(zzcwl zzcwlVar, zzdhe zzdheVar) {
        zzcwlVar.zzgdb = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzbjz a(zzcxs zzcxsVar) {
        zzbrm.zza zzaVar;
        zzcwz zza = zzcwz.zza(this.zzgin);
        zzaVar = new zzbrm.zza();
        zzaVar.zza((zzbow) zza, this.zzfci);
        zzaVar.zza((zzbqg) zza, this.zzfci);
        zzaVar.zza(zza);
        return this.zzgea.zzaci().zza(new zzbkf(this.zzfdu)).zzb(new zzbod.zza().zzbz(this.zzgim).zza(((zzcwp) zzcxsVar).zzfgl).zzahh()).zzb(zzaVar.zzahw());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.zzgin.onAdFailedToLoad(1);
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final boolean isLoading() {
        zzdhe<zzbke> zzdheVar = this.zzgdb;
        return (zzdheVar == null || zzdheVar.isDone()) ? false : true;
    }

    public final void zza(zzuo zzuoVar) {
        this.zzgcs.zzb(zzuoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final synchronized boolean zza(zzug zzugVar, String str, zzcpa zzcpaVar, zzcoz<? super zzbke> zzcozVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzayu.zzex("Ad unit ID should not be null for app open ad.");
            this.zzfci.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcwk
                private final zzcwl zzgil;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgil = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgil.a();
                }
            });
            return false;
        }
        if (this.zzgdb != null) {
            return false;
        }
        zzdad.zze(this.zzgim, zzugVar.zzccb);
        zzczu zzaos = this.zzgcs.zzgk(str).zzd(zzuj.zzom()).zzg(zzugVar).zzaos();
        zzcwp zzcwpVar = new zzcwp(null);
        zzcwpVar.zzfgl = zzaos;
        this.zzgdb = this.zzgio.zza(zzcwpVar, new zzcxv(this) { // from class: com.google.android.gms.internal.ads.zzcwn
            private final zzcwl zzgil;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgil = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcxv
            public final zzboe zzc(zzcxs zzcxsVar) {
                return this.zzgil.a(zzcxsVar);
            }
        });
        zzdgs.zza(this.zzgdb, new zzcwm(this, zzcozVar), this.zzgea.zzaca());
        return true;
    }
}
