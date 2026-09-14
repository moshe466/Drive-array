package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbzh {
    private final Executor zzfci;
    private final zzczu zzfgl;
    private final zzcbn zzfod;
    private final Context zzup;

    public zzbzh(Context context, zzczu zzczuVar, Executor executor, zzcbn zzcbnVar) {
        this.zzup = context;
        this.zzfgl = zzczuVar;
        this.zzfci = executor;
        this.zzfod = zzcbnVar;
    }

    private final void zzk(zzbdi zzbdiVar) {
        zzbdiVar.zza("/video", zzafa.zzcxf);
        zzbdiVar.zza("/videoMeta", zzafa.zzcxg);
        zzbdiVar.zza("/precache", new zzbcs());
        zzbdiVar.zza("/delayPageLoaded", zzafa.zzcxj);
        zzbdiVar.zza("/instrument", zzafa.zzcxh);
        zzbdiVar.zza("/log", zzafa.zzcxa);
        zzbdiVar.zza("/videoClicked", zzafa.zzcxb);
        zzbdiVar.zzaaa().zzbb(true);
        zzbdiVar.zza("/click", zzafa.zzcww);
        if (this.zzfgl.zzdkf == null) {
            zzbdiVar.zzaaa().zzbc(false);
        } else {
            zzbdiVar.zzaaa().zzbc(true);
            zzbdiVar.zza("/open", new zzafr(null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(Object obj) {
        zzbdi zza = this.zzfod.zza(zzuj.zzg(this.zzup), false);
        final zzazi zzl = zzazi.zzl(zza);
        zzk(zza);
        zza.zzaaa().zza(new zzbex(zzl) { // from class: com.google.android.gms.internal.ads.zzbzl
            private final zzazi zzefc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzefc = zzl;
            }

            @Override // com.google.android.gms.internal.ads.zzbex
            public final void zzsb() {
                this.zzefc.zzxn();
            }
        });
        zza.loadUrl((String) zzve.zzoy().zzd(zzzn.zzclz));
        return zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(String str, String str2, Object obj) {
        final zzbdi zza = this.zzfod.zza(zzuj.zzg(this.zzup), false);
        final zzazi zzl = zzazi.zzl(zza);
        zzk(zza);
        zza.zza(this.zzfgl.zzdkf != null ? zzbey.zzabs() : zzbey.zzabr());
        zza.zzaaa().zza(new zzbeu(this, zza, zzl) { // from class: com.google.android.gms.internal.ads.zzbzo
            private final zzbzh zzfpu;
            private final zzbdi zzfpv;
            private final zzazi zzfpw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpu = this;
                this.zzfpv = zza;
                this.zzfpw = zzl;
            }

            @Override // com.google.android.gms.internal.ads.zzbeu
            public final void zzak(boolean z) {
                this.zzfpu.a(this.zzfpv, this.zzfpw, z);
            }
        });
        zza.zzb(str, str2, null);
        return zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(JSONObject jSONObject, final zzbdi zzbdiVar) {
        final zzazi zzl = zzazi.zzl(zzbdiVar);
        zzbdiVar.zza(this.zzfgl.zzdkf != null ? zzbey.zzabs() : zzbey.zzabr());
        zzbdiVar.zzaaa().zza(new zzbeu(this, zzbdiVar, zzl) { // from class: com.google.android.gms.internal.ads.zzbzn
            private final zzbzh zzfpu;
            private final zzbdi zzfpv;
            private final zzazi zzfpw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpu = this;
                this.zzfpv = zzbdiVar;
                this.zzfpw = zzl;
            }

            @Override // com.google.android.gms.internal.ads.zzbeu
            public final void zzak(boolean z) {
                this.zzfpu.b(this.zzfpv, this.zzfpw, z);
            }
        });
        zzbdiVar.zza("google.afma.nativeAds.renderVideo", jSONObject);
        return zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbdi zzbdiVar, zzazi zzaziVar, boolean z) {
        if (this.zzfgl.zzgmk != null && zzbdiVar.zzyl() != null) {
            zzbdiVar.zzyl().zzb(this.zzfgl.zzgmk);
        }
        zzaziVar.zzxn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzbdi zzbdiVar, zzazi zzaziVar, boolean z) {
        if (this.zzfgl.zzgmk != null && zzbdiVar.zzyl() != null) {
            zzbdiVar.zzyl().zzb(this.zzfgl.zzgmk);
        }
        zzaziVar.zzxn();
    }

    public final zzdhe<zzbdi> zzm(final JSONObject jSONObject) {
        return zzdgs.zzb(zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(this) { // from class: com.google.android.gms.internal.ads.zzbzm
            private final zzbzh zzfpu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpu = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfpu.a(obj);
            }
        }, this.zzfci), new zzdgf(this, jSONObject) { // from class: com.google.android.gms.internal.ads.zzbzk
            private final JSONObject zzfcs;
            private final zzbzh zzfpu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpu = this;
                this.zzfcs = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfpu.a(this.zzfcs, (zzbdi) obj);
            }
        }, this.zzfci);
    }

    public final zzdhe<zzbdi> zzo(final String str, final String str2) {
        return zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(this, str, str2) { // from class: com.google.android.gms.internal.ads.zzbzj
            private final String zzcyr;
            private final String zzdbl;
            private final zzbzh zzfpu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpu = this;
                this.zzcyr = str;
                this.zzdbl = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfpu.a(this.zzcyr, this.zzdbl, obj);
            }
        }, this.zzfci);
    }
}
