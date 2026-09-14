package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzsy;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcxg<R extends zzbob<AdT>, AdT extends zzbmd> implements zzcxt<R, AdT> {
    private final Executor executor;
    private final zzcxt<R, AdT> zzgio;
    private final zzdbb zzgjq;
    private final zzdax zzgjr;
    private final zzcxt<R, zzdbi<AdT>> zzgjs;

    @GuardedBy("this")
    private zzcxn<R> zzgju;

    @GuardedBy("this")
    private zzdhe<zzdbi<AdT>> zzgjv;

    @GuardedBy("this")
    private R zzgjx;

    @GuardedBy("this")
    private int zzgjw = zzcxm.zzgkd;
    private final zzdgt<zzdbi<AdT>> zzgjy = new zzcxk(this);
    private final LinkedList<zzcxn<R>> zzgjt = new LinkedList<>();

    public zzcxg(zzdbb zzdbbVar, zzdax zzdaxVar, zzcxt<R, AdT> zzcxtVar, zzcxt<R, zzdbi<AdT>> zzcxtVar2, Executor executor) {
        this.zzgjq = zzdbbVar;
        this.zzgjr = zzdaxVar;
        this.zzgio = zzcxtVar;
        this.zzgjs = zzcxtVar2;
        this.executor = executor;
        this.zzgjr.zza(new zzdaw(this) { // from class: com.google.android.gms.internal.ads.zzcxl
            private final zzcxg zzgka;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgka = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdaw
            public final void execute() {
                this.zzgka.a();
            }
        });
    }

    private final zzdhe<AdT> zza(zzdbi<AdT> zzdbiVar, zzcxs zzcxsVar, zzcxv<R> zzcxvVar) {
        final zzboe<R> zzc = zzcxvVar.zzc(zzcxsVar);
        if (zzdbiVar.zzgpd == null) {
            zzc.zza(zzdbiVar.zzelt);
            return zzdgs.zzb(this.zzgio.zza(zzcxsVar, zzcxvVar), new zzdgf(zzc) { // from class: com.google.android.gms.internal.ads.zzcxj
                private final zzboe zzgkb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgkb = zzc;
                }

                @Override // com.google.android.gms.internal.ads.zzdgf
                public final zzdhe zzf(Object obj) {
                    zzbmd zzbmdVar = (zzbmd) obj;
                    zzbmdVar.zzagt().zzb(((zzbob) this.zzgkb.zzadg()).zzadz());
                    return zzdgs.zzaj(zzbmdVar);
                }
            }, this.executor);
        }
        zzdbiVar.zzgpd.zzagt().zzb(zzc.zzadg().zzadz());
        return zzdgs.zzaj(zzdbiVar.zzgpd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzcxn<R> zzcxnVar) {
        while (true) {
            zzdhe<zzdbi<AdT>> zzdheVar = this.zzgjv;
            if (!(zzdheVar == null || zzdheVar.isDone())) {
                return;
            }
            if (zzcxnVar == null && this.zzgjt.isEmpty()) {
                return;
            }
            if (zzcxnVar == null) {
                zzcxnVar = this.zzgjt.remove();
            }
            zzdbb zzdbbVar = this.zzgjq;
            if (zzdbbVar.zzb(zzdbbVar.zza(zzcxnVar.zzdio, zzcxnVar.zzbqz, zzcxnVar.zzgey))) {
                this.zzgju = zzcxnVar;
                this.zzgjv = this.zzgjs.zza(zzcxnVar.zzgki, zzcxnVar.zzgkh);
                zzdgs.zza(this.zzgjv, this.zzgjy, zzcxnVar.executor);
                return;
            }
            zzcxnVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzcxt
    /* renamed from: zzaoh, reason: merged with bridge method [inline-methods] */
    public final synchronized R zzaog() {
        return this.zzgjx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzdbi zzdbiVar) {
        zzdbiVar.zzgpc.zzahb().zzc((zzsy.zza) zzsy.zza.zzmz().zza(zzsy.zza.C0024zza.zzmx().zzb(zzsy.zza.zzc.IN_MEMORY).zza(zzsy.zza.zzd.zznb())).zzbaf());
        zzcxn<R> zzcxnVar = this.zzgju;
        return zza(zzdbiVar, zzcxnVar.zzgki, zzcxnVar.zzgkh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        synchronized (this) {
            zza(this.zzgju);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final zzdhe<AdT> zza(zzcxs zzcxsVar, zzcxv<R> zzcxvVar) {
        zzczu zzady = zzcxvVar.zzc(zzcxsVar).zzadg().zzady();
        zzcxn<R> zzcxnVar = new zzcxn<>(zzcxvVar, zzcxsVar, zzady.zzgml, zzady.zzgmm, this.executor, zzady.zzgmp);
        zzdbb zzdbbVar = this.zzgjq;
        zzdbi<?> zza = zzdbbVar.zza(zzdbbVar.zza(zzcxnVar.zzdio, zzcxnVar.zzbqz, zzcxnVar.zzgey));
        if (zza != null) {
            this.zzgjx = null;
            this.zzgjt.add(zzcxnVar);
            return zza(zza, zzcxsVar, zzcxvVar);
        }
        zzdhe<zzdbi<AdT>> zzdheVar = this.zzgjv;
        if ((zzdheVar == null || zzdheVar.isDone()) ? false : true) {
            this.zzgjw = zzcxm.zzgkf;
            zzdbl zza2 = this.zzgjq.zza(zzcxnVar.zzdio, zzcxnVar.zzbqz, zzcxnVar.zzgey);
            zzdbb zzdbbVar2 = this.zzgjq;
            zzcxn<R> zzcxnVar2 = this.zzgju;
            if (zza2.equals(zzdbbVar2.zza(zzcxnVar2.zzdio, zzcxnVar2.zzbqz, zzcxnVar.zzgey))) {
                this.zzgjw = zzcxm.zzgke;
                this.zzgjx = this.zzgjs.zzaog();
                return zzdgs.zzb(this.zzgjv, new zzdgf(this) { // from class: com.google.android.gms.internal.ads.zzcxi
                    private final zzcxg zzgka;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgka = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdgf
                    public final zzdhe zzf(Object obj) {
                        return this.zzgka.a((zzdbi) obj);
                    }
                }, this.executor);
            }
        }
        this.zzgjt.add(zzcxnVar);
        zzdhe<AdT> zza3 = this.zzgio.zza(zzcxsVar, zzcxvVar);
        this.zzgjx = this.zzgio.zzaog();
        return zza3;
    }
}
