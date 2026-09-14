package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbdr {
    public static zzbdi zza(final Context context, final zzbey zzbeyVar, final String str, final boolean z, final boolean z2, @Nullable final zzdq zzdqVar, final zzazb zzazbVar, zzaae zzaaeVar, final com.google.android.gms.ads.internal.zzi zziVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzsm zzsmVar, final zzro zzroVar, final boolean z3) {
        zzzn.initialize(context);
        if (zzabl.zzcuv.get().booleanValue()) {
            return zzbfe.zza(context, zzbeyVar, str, z, z2, zzdqVar, zzazbVar, null, zziVar, zzaVar, zzsmVar, zzroVar, z3);
        }
        try {
            final zzaae zzaaeVar2 = null;
            return (zzbdi) zzayc.zza(new zzden(context, zzbeyVar, str, z, z2, zzdqVar, zzazbVar, zzaaeVar2, zziVar, zzaVar, zzsmVar, zzroVar, z3) { // from class: com.google.android.gms.internal.ads.zzbdt
                private final Context zzcri;
                private final String zzdbl;
                private final zzbey zzefd;
                private final boolean zzefe;
                private final boolean zzeff;
                private final zzdq zzefg;
                private final zzazb zzefh;
                private final zzaae zzefi = null;
                private final com.google.android.gms.ads.internal.zzi zzefj;
                private final com.google.android.gms.ads.internal.zza zzefk;
                private final zzsm zzefl;
                private final zzro zzefm;
                private final boolean zzefn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcri = context;
                    this.zzefd = zzbeyVar;
                    this.zzdbl = str;
                    this.zzefe = z;
                    this.zzeff = z2;
                    this.zzefg = zzdqVar;
                    this.zzefh = zzazbVar;
                    this.zzefj = zziVar;
                    this.zzefk = zzaVar;
                    this.zzefl = zzsmVar;
                    this.zzefm = zzroVar;
                    this.zzefn = z3;
                }

                @Override // com.google.android.gms.internal.ads.zzden
                public final Object get() {
                    Context context2 = this.zzcri;
                    zzbey zzbeyVar2 = this.zzefd;
                    String str2 = this.zzdbl;
                    boolean z4 = this.zzefe;
                    boolean z5 = this.zzeff;
                    zzdq zzdqVar2 = this.zzefg;
                    zzazb zzazbVar2 = this.zzefh;
                    zzaae zzaaeVar3 = this.zzefi;
                    com.google.android.gms.ads.internal.zzi zziVar2 = this.zzefj;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.zzefk;
                    zzsm zzsmVar2 = this.zzefl;
                    zzbdu zzbduVar = new zzbdu(zzbdz.a(context2, zzbeyVar2, str2, z4, z5, zzdqVar2, zzazbVar2, zzaaeVar3, zziVar2, zzaVar2, zzsmVar2, this.zzefm, this.zzefn));
                    zzbduVar.setWebViewClient(com.google.android.gms.ads.internal.zzq.zzks().zza(zzbduVar, zzsmVar2, z5));
                    zzbduVar.setWebChromeClient(new zzbda(zzbduVar));
                    return zzbduVar;
                }
            });
        } catch (Throwable th) {
            throw new zzbdv("Webview initialization failed.", th);
        }
    }

    public static zzdhe<zzbdi> zza(final Context context, final zzazb zzazbVar, final String str, final zzdq zzdqVar, final com.google.android.gms.ads.internal.zza zzaVar) {
        return zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(context, zzdqVar, zzazbVar, zzaVar, str) { // from class: com.google.android.gms.internal.ads.zzbdq
            private final Context zzcri;
            private final zzdq zzczj;
            private final zzazb zzeez;
            private final com.google.android.gms.ads.internal.zza zzefa;
            private final String zzefb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
                this.zzczj = zzdqVar;
                this.zzeez = zzazbVar;
                this.zzefa = zzaVar;
                this.zzefb = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                Context context2 = this.zzcri;
                zzdq zzdqVar2 = this.zzczj;
                zzazb zzazbVar2 = this.zzeez;
                com.google.android.gms.ads.internal.zza zzaVar2 = this.zzefa;
                String str2 = this.zzefb;
                com.google.android.gms.ads.internal.zzq.zzkr();
                zzbdi zza = zzbdr.zza(context2, zzbey.zzabq(), "", false, false, zzdqVar2, zzazbVar2, null, null, zzaVar2, zzsm.zzmt(), null, false);
                final zzazi zzl = zzazi.zzl(zza);
                zza.zzaaa().zza(new zzbeu(zzl) { // from class: com.google.android.gms.internal.ads.zzbds
                    private final zzazi zzefc;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzefc = zzl;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbeu
                    public final void zzak(boolean z) {
                        this.zzefc.zzxn();
                    }
                });
                zza.loadUrl(str2);
                return zzl;
            }
        }, zzazd.zzdwi);
    }
}
