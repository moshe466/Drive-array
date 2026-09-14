package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcku implements zzckr<zzbwk> {
    private final zzdhd zzfov;
    private final zzbvm zzfzt;
    private final zzbyq zzfzu;

    public zzcku(zzbvm zzbvmVar, zzdhd zzdhdVar, zzbyq zzbyqVar) {
        this.zzfzt = zzbvmVar;
        this.zzfov = zzdhdVar;
        this.zzfzu = zzbyqVar;
    }

    private final zzdhe<zzbwk> zzb(final zzczt zzcztVar, final zzczl zzczlVar, final JSONObject jSONObject) {
        final zzdhe<zzcaj> zzaou = this.zzfzt.zzade().zzaou();
        final zzdhe<zzbws> zza = this.zzfzu.zza(zzcztVar, zzczlVar, jSONObject);
        return zzdgs.zzb(zzaou, zza).zza(new Callable(this, zza, zzaou, zzcztVar, zzczlVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzckx
            private final zzdhe zzfgb;
            private final zzdhe zzfpa;
            private final zzczt zzfzm;
            private final zzcku zzfzs;
            private final zzczl zzfzv;
            private final JSONObject zzfzw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzs = this;
                this.zzfpa = zza;
                this.zzfgb = zzaou;
                this.zzfzm = zzcztVar;
                this.zzfzv = zzczlVar;
                this.zzfzw = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzfzs.a(this.zzfpa, this.zzfgb, this.zzfzm, this.zzfzv, this.zzfzw);
            }
        }, this.zzfov);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzbwk a(zzdhe zzdheVar, zzdhe zzdheVar2, zzczt zzcztVar, zzczl zzczlVar, JSONObject jSONObject) {
        zzbws zzbwsVar = (zzbws) zzdheVar.get();
        zzcaj zzcajVar = (zzcaj) zzdheVar2.get();
        zzbwu zza = this.zzfzt.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzbxe(zzbwsVar), new zzbvy(jSONObject, zzcajVar));
        zza.zzado().zzakr();
        zza.zzadp().zzb(zzcajVar);
        zza.zzadq().zzl(zzbwsVar.zzajf());
        return zza.zzadn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzczl zzczlVar, zzcaj zzcajVar) {
        JSONObject zza = zzaxs.zza("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzczlVar.zzglo.zzfka);
        jSONObject.put("sdk_params", zza);
        return zzdgs.zzb(zzcajVar.zzc("google.afma.nativeAds.preProcessJson", jSONObject), zzckv.a, this.zzfov);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzczt zzcztVar, zzczl zzczlVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzdgs.zzk(new zzcfb(3));
        }
        int i = 0;
        if (zzcztVar.zzgmh.zzfgl.zzgdu <= 1) {
            return zzdgs.zzb(zzb(zzcztVar, zzczlVar, jSONArray.getJSONObject(0)), zzcky.a, this.zzfov);
        }
        int length = jSONArray.length();
        this.zzfzt.zzade().zzdm(Math.min(length, zzcztVar.zzgmh.zzfgl.zzgdu));
        ArrayList arrayList = new ArrayList(zzcztVar.zzgmh.zzfgl.zzgdu);
        while (i < zzcztVar.zzgmh.zzfgl.zzgdu) {
            arrayList.add(i < length ? zzb(zzcztVar, zzczlVar, jSONArray.getJSONObject(i)) : zzdgs.zzk(new zzcfb(3)));
            i++;
        }
        return zzdgs.zzaj(arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        zzczp zzczpVar = zzczlVar.zzglo;
        return (zzczpVar == null || zzczpVar.zzfka == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<List<zzdhe<zzbwk>>> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        zzdhe<zzcaj> zzaou = this.zzfzt.zzade().zzaou();
        this.zzfzt.zzade().zzb(zzaou);
        return zzdgs.zzb(zzdgs.zzb(zzaou, new zzdgf(this, zzczlVar) { // from class: com.google.android.gms.internal.ads.zzckt
            private final zzczl zzfzk;
            private final zzcku zzfzs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzs = this;
                this.zzfzk = zzczlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfzs.a(this.zzfzk, (zzcaj) obj);
            }
        }, this.zzfov), new zzdgf(this, zzcztVar, zzczlVar) { // from class: com.google.android.gms.internal.ads.zzckw
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzcku zzfzs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzs = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfzs.a(this.zzfot, this.zzfel, (JSONArray) obj);
            }
        }, this.zzfov);
    }
}
