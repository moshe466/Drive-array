package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcgw extends zzaqa {
    private final Executor zzfci;
    private final zzarb zzfwb;
    private final zzaqy zzfwc;
    private final zzbij zzfwd;
    private final HashMap<String, zzchh> zzfwe;
    private final Context zzup;

    public zzcgw(Context context, Executor executor, zzarb zzarbVar, zzbij zzbijVar, zzaqy zzaqyVar, HashMap<String, zzchh> hashMap) {
        zzzn.initialize(context);
        this.zzup = context;
        this.zzfci = executor;
        this.zzfwb = zzarbVar;
        this.zzfwc = zzaqyVar;
        this.zzfwd = zzbijVar;
        this.zzfwe = hashMap;
    }

    private static zzdhe<JSONObject> zza(zzaqk zzaqkVar, zzdcr zzdcrVar, final zzcut zzcutVar) {
        zzdgf zzdgfVar = new zzdgf(zzcutVar) { // from class: com.google.android.gms.internal.ads.zzcha
            private final zzcut zzfwf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfwf = zzcutVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfwf.zzadt().zzs(com.google.android.gms.ads.internal.zzq.zzkq().zzd((Bundle) obj));
            }
        };
        return zzdcrVar.zza((zzdcr) zzdco.GMS_SIGNALS, zzdgs.zzaj(zzaqkVar.zzdlu)).zza(zzdgfVar).zzb(zzcgz.a).zzaqg();
    }

    private static zzdhe<zzaqq> zza(zzdhe<JSONObject> zzdheVar, zzdcr zzdcrVar, zzakc zzakcVar) {
        return zzdcrVar.zza((zzdcr) zzdco.BUILD_URL, (zzdhe) zzdheVar).zza(zzakcVar.zza("AFMA_getAdDictionary", zzajx.zzdaq, zzchc.a)).zzaqg();
    }

    private final void zza(zzdhe<InputStream> zzdheVar, zzaqe zzaqeVar) {
        zzdgs.zza(zzdgs.zzb(zzdheVar, new zzdgf(this) { // from class: com.google.android.gms.internal.ads.zzchg
            private final zzcgw zzfwg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfwg = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return zzdgs.zzaj(zzdae.zze((InputStream) obj));
            }
        }, zzazd.zzdwe), new zzchi(this, zzaqeVar), zzazd.zzdwj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ InputStream a(zzdhe zzdheVar, zzdhe zzdheVar2) {
        String zzuf = ((zzaqq) zzdheVar.get()).zzuf();
        this.zzfwe.put(zzuf, new zzchh((zzaqq) zzdheVar.get(), (JSONObject) zzdheVar2.get()));
        return new ByteArrayInputStream(zzuf.getBytes(zzdeb.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        zzazh.zza(this.zzfwc.zzuh(), "persistFlags");
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final zzapx zza(zzapv zzapvVar) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zza(zzapv zzapvVar, zzaqc zzaqcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zza(zzaqk zzaqkVar, zzaqe zzaqeVar) {
        zzdhe<InputStream> zzh = zzh(zzaqkVar);
        zza(zzh, zzaqeVar);
        zzh.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzchb
            private final zzcgw zzfwg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfwg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfwg.c();
            }
        }, this.zzfci);
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zza(String str, zzaqe zzaqeVar) {
        zzdhe<InputStream> zzaj;
        if (zzabd.zzcty.get().booleanValue()) {
            zzchf zzchfVar = new zzchf(this);
            if (this.zzfwe.remove(str) == null) {
                String valueOf = String.valueOf(str);
                zzaj = zzdgs.zzk(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
            } else {
                zzaj = zzdgs.zzaj(zzchfVar);
            }
        } else {
            zzaj = zzdgs.zzk(new Exception("Split request is disabled."));
        }
        zza(zzaj, zzaqeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zzb(zzaqk zzaqkVar, zzaqe zzaqeVar) {
        zzdhe<InputStream> zzaqg;
        zzakc zza = com.google.android.gms.ads.internal.zzq.zzld().zza(this.zzup, zzazb.zzxm());
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcpp)).booleanValue()) {
            zzcut zza2 = this.zzfwd.zza(zzaqkVar);
            final zzcua<JSONObject> zzadu = this.zzfwd.zza(zzaqkVar).zzadu();
            zzaqg = zza2.zzadv().zza((zzdcr) zzdco.GET_SIGNALS, zzdgs.zzaj(zzaqkVar.zzdlu)).zza(new zzdgf(zzadu) { // from class: com.google.android.gms.internal.ads.zzchd
                private final zzcua zzfwh;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfwh = zzadu;
                }

                @Override // com.google.android.gms.internal.ads.zzdgf
                public final zzdhe zzf(Object obj) {
                    return this.zzfwh.zzs(com.google.android.gms.ads.internal.zzq.zzkq().zzd((Bundle) obj));
                }
            }).zzw(zzdco.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzajx.zzdaq, zzajx.zzdar)).zzaqg();
        } else {
            zzaqg = zzdgs.zzk(new Exception("Signal collection disabled."));
        }
        zza(zzaqg, zzaqeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zzc(zzaqk zzaqkVar, zzaqe zzaqeVar) {
        Exception exc;
        zzdhe<InputStream> zzaqg;
        if (zzabd.zzcty.get().booleanValue()) {
            zzdbe zzdbeVar = zzaqkVar.zzdlx;
            if (zzdbeVar == null) {
                exc = new Exception("Pool configuration missing from request.");
            } else {
                if (zzdbeVar.zzgoi != 0 && zzdbeVar.zzgoj != 0) {
                    zzakc zza = com.google.android.gms.ads.internal.zzq.zzld().zza(this.zzup, zzazb.zzxm());
                    zzcut zza2 = this.zzfwd.zza(zzaqkVar);
                    zzdcr zzadv = zza2.zzadv();
                    final zzdhe<JSONObject> zza3 = zza(zzaqkVar, zzadv, zza2);
                    final zzdhe<zzaqq> zza4 = zza(zza3, zzadv, zza);
                    zzaqg = zzadv.zza((zzdcr) zzdco.GET_URL_AND_CACHE_KEY, zza3, zza4).zzb(new Callable(this, zza4, zza3) { // from class: com.google.android.gms.internal.ads.zzche
                        private final zzdhe zzfgb;
                        private final zzdhe zzfpa;
                        private final zzcgw zzfwg;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzfwg = this;
                            this.zzfpa = zza4;
                            this.zzfgb = zza3;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzfwg.a(this.zzfpa, this.zzfgb);
                        }
                    }).zzaqg();
                    zza(zzaqg, zzaqeVar);
                }
                exc = new Exception("Caching is disabled.");
            }
        } else {
            exc = new Exception("Split request is disabled.");
        }
        zzaqg = zzdgs.zzk(exc);
        zza(zzaqg, zzaqeVar);
    }

    public final zzdhe<InputStream> zzh(zzaqk zzaqkVar) {
        String str;
        zzdcj zzb;
        zzakc zza = com.google.android.gms.ads.internal.zzq.zzld().zza(this.zzup, zzazb.zzxm());
        zzcut zza2 = this.zzfwd.zza(zzaqkVar);
        zzaju zza3 = zza.zza("google.afma.response.normalize", zzchk.zzfwm, zzajx.zzdar);
        zzchl zzchlVar = new zzchl(this.zzup, zzaqkVar.zzdij.zzbma, this.zzfwb, zzaqkVar.zzdjj);
        zzdcr zzadv = zza2.zzadv();
        zzchh zzchhVar = null;
        if (zzabd.zzcty.get().booleanValue()) {
            String str2 = zzaqkVar.zzdly;
            if (str2 != null && !str2.isEmpty() && (zzchhVar = this.zzfwe.remove(zzaqkVar.zzdly)) == null) {
                str = "Request contained a PoolKey but no matching parameters were found.";
                zzavs.zzed(str);
            }
        } else {
            String str3 = zzaqkVar.zzdly;
            if (str3 != null && !str3.isEmpty()) {
                str = "Request contained a PoolKey but split request is disabled.";
                zzavs.zzed(str);
            }
        }
        if (zzchhVar == null) {
            final zzdhe<JSONObject> zza4 = zza(zzaqkVar, zzadv, zza2);
            final zzdhe<zzaqq> zza5 = zza(zza4, zzadv, zza);
            final zzdca zzaqg = zzadv.zza((zzdcr) zzdco.HTTP, zza5, zza4).zzb(new Callable(zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcgv
                private final zzdhe zzfpa;
                private final zzdhe zzfpn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfpn = zza4;
                    this.zzfpa = zza5;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcho((JSONObject) this.zzfpn.get(), (zzaqq) this.zzfpa.get());
                }
            }).zzb(zzchlVar).zzaqg();
            zzb = zzadv.zza((zzdcr) zzdco.PRE_PROCESS, zza4, zza5, zzaqg).zzb(new Callable(zzaqg, zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcgy
                private final zzdhe zzfgb;
                private final zzdhe zzfpa;
                private final zzdhe zzfpn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfpn = zzaqg;
                    this.zzfpa = zza4;
                    this.zzfgb = zza5;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzchk((zzchn) this.zzfpn.get(), (JSONObject) this.zzfpa.get(), (zzaqq) this.zzfgb.get());
                }
            });
        } else {
            final zzdca zzaqg2 = zzadv.zza((zzdcr) zzdco.HTTP, zzdgs.zzaj(new zzcho(zzchhVar.zzfwj, zzchhVar.zzfwi))).zzb(zzchlVar).zzaqg();
            final zzdhe<?> zzaj = zzdgs.zzaj(zzchhVar);
            zzb = zzadv.zza((zzdcr) zzdco.PRE_PROCESS, zzaqg2, zzaj).zzb(new Callable(zzaqg2, zzaj) { // from class: com.google.android.gms.internal.ads.zzcgx
                private final zzdhe zzfpa;
                private final zzdhe zzfpn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfpn = zzaqg2;
                    this.zzfpa = zzaj;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdhe zzdheVar = this.zzfpn;
                    zzdhe zzdheVar2 = this.zzfpa;
                    return new zzchk((zzchn) zzdheVar.get(), ((zzchh) zzdheVar2.get()).zzfwj, ((zzchh) zzdheVar2.get()).zzfwi);
                }
            });
        }
        return zzb.zza(zza3).zzaqg();
    }
}
