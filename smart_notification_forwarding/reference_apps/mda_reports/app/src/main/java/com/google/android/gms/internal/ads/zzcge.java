package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcge {
    private final Executor executor;
    private final zzczu zzfgl;
    private final zzazb zzfvm;
    private final Context zzup;

    public zzcge(Context context, zzazb zzazbVar, zzczu zzczuVar, Executor executor) {
        this.zzup = context;
        this.zzfvm = zzazbVar;
        this.zzfgl = zzczuVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(JSONObject jSONObject) {
        return zzdgs.zzaj(new zzczt(new zzczo(this.zzfgl), zzczr.zza(new StringReader(jSONObject.toString()))));
    }

    public final zzdhe<zzczt> zzalt() {
        zzakc zzb = com.google.android.gms.ads.internal.zzq.zzld().zzb(this.zzup, this.zzfvm);
        zzajy<JSONObject> zzajyVar = zzajx.zzdaq;
        final zzaju zza = zzb.zza("google.afma.response.normalize", zzajyVar, zzajyVar);
        final zzua zzuaVar = this.zzfgl.zzgml.zzccm;
        return zzdgs.zzb(zzdgs.zzb(zzdgs.zzb(zzdgs.zzaj(""), new zzdgf(this, zzuaVar) { // from class: com.google.android.gms.internal.ads.zzcgd
            private final zzcge zzfvk;
            private final zzua zzfvl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfvk = this;
                this.zzfvl = zzuaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                zzua zzuaVar2 = this.zzfvl;
                String str = zzuaVar2.zzcbu;
                String str2 = zzuaVar2.zzcbv;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("headers", new JSONObject());
                jSONObject3.put("body", str);
                jSONObject2.put("base_url", "");
                jSONObject2.put("signals", new JSONObject(str2));
                jSONObject.put("request", jSONObject2);
                jSONObject.put("response", jSONObject3);
                jSONObject.put("flags", new JSONObject());
                return zzdgs.zzaj(jSONObject);
            }
        }, this.executor), new zzdgf(zza) { // from class: com.google.android.gms.internal.ads.zzcgg
            private final zzaju zzfvn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfvn = zza;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfvn.zzi((JSONObject) obj);
            }
        }, this.executor), new zzdgf(this) { // from class: com.google.android.gms.internal.ads.zzcgf
            private final zzcge zzfvk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfvk = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfvk.a((JSONObject) obj);
            }
        }, this.executor);
    }
}
