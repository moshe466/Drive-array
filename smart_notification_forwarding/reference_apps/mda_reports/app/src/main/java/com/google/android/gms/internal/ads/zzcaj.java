package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcaj {
    private final zzbdr zzbmj;
    private final zzazb zzdij;
    private final zzdq zzefv;
    private final Executor zzfci;
    private final com.google.android.gms.ads.internal.zza zzfpj;
    private final zzcas zzfqf = new zzcas(null);
    private final zzaft zzfqg = new zzaft();
    private zzdhe<zzbdi> zzfqh;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcaj(zzcat zzcatVar) {
        this.zzup = zzcat.a(zzcatVar);
        this.zzfci = zzcat.b(zzcatVar);
        this.zzefv = zzcat.c(zzcatVar);
        this.zzdij = zzcat.d(zzcatVar);
        this.zzfpj = zzcat.e(zzcatVar);
        this.zzbmj = zzcat.f(zzcatVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbdi a(zzbdi zzbdiVar) {
        zzbdiVar.zza("/result", this.zzfqg);
        zzbev zzaaa = zzbdiVar.zzaaa();
        zzcas zzcasVar = this.zzfqf;
        zzaaa.zza(null, zzcasVar, zzcasVar, zzcasVar, zzcasVar, false, null, new com.google.android.gms.ads.internal.zzc(this.zzup, null, null), null, null);
        return zzbdiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(String str, JSONObject jSONObject, zzbdi zzbdiVar) {
        return this.zzfqg.zza(zzbdiVar, str, jSONObject);
    }

    public final synchronized void destroy() {
        if (this.zzfqh == null) {
            return;
        }
        zzdgs.zza(this.zzfqh, new zzcao(this), this.zzfci);
        this.zzfqh = null;
    }

    public final synchronized void zza(String str, zzafn<Object> zzafnVar) {
        if (this.zzfqh == null) {
            return;
        }
        zzdgs.zza(this.zzfqh, new zzcan(this, str, zzafnVar), this.zzfci);
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzfqh == null) {
            return;
        }
        zzdgs.zza(this.zzfqh, new zzcap(this, str, map), this.zzfci);
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzafn<T> zzafnVar) {
        zza(str, new zzcaw(this, weakReference, str, zzafnVar, null));
    }

    public final synchronized void zzakq() {
        this.zzfqh = zzdgs.zzb(zzbdr.zza(this.zzup, this.zzdij, (String) zzve.zzoy().zzd(zzzn.zzclx), this.zzefv, this.zzfpj), new zzded(this) { // from class: com.google.android.gms.internal.ads.zzcam
            private final zzcaj zzfqj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfqj = this;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                return this.zzfqj.a((zzbdi) obj);
            }
        }, this.zzfci);
        zzazh.zza(this.zzfqh, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb(String str, zzafn<Object> zzafnVar) {
        if (this.zzfqh == null) {
            return;
        }
        zzdgs.zza(this.zzfqh, new zzcaq(this, str, zzafnVar), this.zzfci);
    }

    public final synchronized zzdhe<JSONObject> zzc(final String str, final JSONObject jSONObject) {
        if (this.zzfqh == null) {
            return zzdgs.zzaj(null);
        }
        return zzdgs.zzb(this.zzfqh, new zzdgf(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcal
            private final String zzcyr;
            private final zzcaj zzfqj;
            private final JSONObject zzfqk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfqj = this;
                this.zzcyr = str;
                this.zzfqk = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfqj.a(this.zzcyr, this.zzfqk, (zzbdi) obj);
            }
        }, this.zzfci);
    }
}
