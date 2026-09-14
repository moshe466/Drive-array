package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbfe {
    public static zzbdi zza(final Context context, final zzbey zzbeyVar, final String str, final boolean z, final boolean z2, @Nullable final zzdq zzdqVar, final zzazb zzazbVar, zzaae zzaaeVar, final com.google.android.gms.ads.internal.zzi zziVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzsm zzsmVar, final zzro zzroVar, final boolean z3) {
        try {
            final zzaae zzaaeVar2 = null;
            return (zzbdi) zzayc.zza(new zzden(context, zzbeyVar, str, z, z2, zzdqVar, zzazbVar, zzaaeVar2, zziVar, zzaVar, zzsmVar, zzroVar, z3) { // from class: com.google.android.gms.internal.ads.zzbfh
                private final Context zzcri;
                private final String zzdbl;
                private final zzbey zzefd;
                private final boolean zzefe;
                private final boolean zzeff;
                private final zzdq zzefg;
                private final zzazb zzefh;
                private final zzaae zzefi;
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
                    this.zzefi = zzaaeVar2;
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
                    zzro zzroVar2 = this.zzefm;
                    boolean z6 = this.zzefn;
                    zzbfb zzbfbVar = new zzbfb();
                    zzbfg zzbfgVar = new zzbfg(new zzbez(context2), zzbfbVar, zzbeyVar2, str2, z4, z5, zzdqVar2, zzazbVar2, zzaaeVar3, zziVar2, zzaVar2, zzsmVar2, zzroVar2, z6);
                    zzbdu zzbduVar = new zzbdu(zzbfgVar);
                    zzbfgVar.setWebChromeClient(new zzbda(zzbduVar));
                    zzbfbVar.a(zzbduVar, z5);
                    return zzbduVar;
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbdv("Webview initialization failed.", th);
        }
    }
}
