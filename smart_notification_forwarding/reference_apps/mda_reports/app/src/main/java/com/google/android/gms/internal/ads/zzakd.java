package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzakd<I, O> implements zzaju<I, O> {
    private final zzais zzdav;
    private final zzajw<O> zzdaw;
    private final zzajv<I> zzdax;
    private final String zzday;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakd(zzais zzaisVar, String str, zzajv<I> zzajvVar, zzajw<O> zzajwVar) {
        this.zzdav = zzaisVar;
        this.zzday = str;
        this.zzdax = zzajvVar;
        this.zzdaw = zzajwVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzajf zzajfVar, zzajq zzajqVar, I i, zzazl<O> zzazlVar) {
        try {
            com.google.android.gms.ads.internal.zzq.zzkq();
            String zzwk = zzawb.zzwk();
            zzafa.zzcxi.zza(zzwk, new zzaki(this, zzajfVar, zzazlVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzwk);
            jSONObject.put("args", this.zzdax.zzj(i));
            zzajqVar.zza(this.zzday, jSONObject);
        } catch (Exception e) {
            try {
                zzazlVar.setException(e);
                zzayu.zzc("Unable to invokeJavascript", e);
            } finally {
                zzajfVar.release();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final zzdhe<O> zzf(@Nullable I i) {
        return zzi(i);
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final zzdhe<O> zzi(I i) {
        zzazl zzazlVar = new zzazl();
        zzajf zzb = this.zzdav.zzb(null);
        zzb.zza(new zzakg(this, zzb, i, zzazlVar), new zzakf(this, zzazlVar, zzb));
        return zzazlVar;
    }
}
