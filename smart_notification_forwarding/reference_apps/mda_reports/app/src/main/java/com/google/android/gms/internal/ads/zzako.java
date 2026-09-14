package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzako<I, O> implements zzdgf<I, O> {
    private final zzajw<O> zzdaw;
    private final zzajv<I> zzdax;
    private final String zzday;
    private final zzdhe<zzajq> zzdbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzako(zzdhe<zzajq> zzdheVar, String str, zzajv<I> zzajvVar, zzajw<O> zzajwVar) {
        this.zzdbd = zzdheVar;
        this.zzday = str;
        this.zzdax = zzajvVar;
        this.zzdaw = zzajwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(Object obj, zzajq zzajqVar) {
        zzazl zzazlVar = new zzazl();
        com.google.android.gms.ads.internal.zzq.zzkq();
        String zzwk = zzawb.zzwk();
        zzafa.zzcxi.zza(zzwk, new zzakq(this, zzazlVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzwk);
        jSONObject.put("args", this.zzdax.zzj(obj));
        zzajqVar.zza(this.zzday, jSONObject);
        return zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final zzdhe<O> zzf(final I i) {
        return zzdgs.zzb(this.zzdbd, new zzdgf(this, i) { // from class: com.google.android.gms.internal.ads.zzakn
            private final zzako zzdbg;
            private final Object zzdbh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbg = this;
                this.zzdbh = i;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzdbg.a(this.zzdbh, (zzajq) obj);
            }
        }, zzazd.zzdwj);
    }
}
