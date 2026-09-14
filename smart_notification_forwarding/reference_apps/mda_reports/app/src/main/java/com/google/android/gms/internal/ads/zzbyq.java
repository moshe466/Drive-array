package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbyq {
    private final zzdhd zzfov;
    private final zzbyu zzfow;
    private final zzbze zzfox;

    public zzbyq(zzdhd zzdhdVar, zzbyu zzbyuVar, zzbze zzbzeVar) {
        this.zzfov = zzdhdVar;
        this.zzfow = zzbyuVar;
        this.zzfox = zzbzeVar;
    }

    public final zzdhe<zzbws> zza(final zzczt zzcztVar, final zzczl zzczlVar, final JSONObject jSONObject) {
        JSONObject optJSONObject;
        zzdhe zzb;
        final zzdhe submit = this.zzfov.submit(new Callable(this, zzcztVar, zzczlVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzbyp
            private final zzczl zzfel;
            private final zzbyq zzfos;
            private final zzczt zzfot;
            private final JSONObject zzfou;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfos = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
                this.zzfou = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzczt zzcztVar2 = this.zzfot;
                zzczl zzczlVar2 = this.zzfel;
                JSONObject jSONObject2 = this.zzfou;
                zzbws zzbwsVar = new zzbws();
                zzbwsVar.zzdj(jSONObject2.optInt("template_id", -1));
                zzbwsVar.zzfw(jSONObject2.optString("custom_template_id"));
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                zzbwsVar.zzfx(optJSONObject2 != null ? optJSONObject2.optString("omid_partner_name") : null);
                zzczu zzczuVar = zzcztVar2.zzgmh.zzfgl;
                if (!zzczuVar.zzgmn.contains(Integer.toString(zzbwsVar.zzaja()))) {
                    int zzaja = zzbwsVar.zzaja();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Invalid template ID: ");
                    sb.append(zzaja);
                    throw new zzclr(sb.toString(), 0);
                }
                if (zzbwsVar.zzaja() == 3) {
                    if (zzbwsVar.getCustomTemplateId() == null) {
                        throw new zzclr("No custom template id for custom template ad response.", 0);
                    }
                    if (!zzczuVar.zzgmo.contains(zzbwsVar.getCustomTemplateId())) {
                        throw new zzclr("Unexpected custom template id in the response.", 0);
                    }
                }
                zzbwsVar.setStarRating(jSONObject2.optDouble("rating", -1.0d));
                String optString = jSONObject2.optString("headline", null);
                if (zzczlVar2.zzdmf) {
                    com.google.android.gms.ads.internal.zzq.zzkq();
                    String zzwn = zzawb.zzwn();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(zzwn).length() + 3 + String.valueOf(optString).length());
                    sb2.append(zzwn);
                    sb2.append(" : ");
                    sb2.append(optString);
                    optString = sb2.toString();
                }
                zzbwsVar.zzn("headline", optString);
                zzbwsVar.zzn("body", jSONObject2.optString("body", null));
                zzbwsVar.zzn("call_to_action", jSONObject2.optString("call_to_action", null));
                zzbwsVar.zzn("store", jSONObject2.optString("store", null));
                zzbwsVar.zzn(FirebaseAnalytics.Param.PRICE, jSONObject2.optString(FirebaseAnalytics.Param.PRICE, null));
                zzbwsVar.zzn("advertiser", jSONObject2.optString("advertiser", null));
                return zzbwsVar;
            }
        });
        final zzdhe<List<zzabu>> zzd = this.zzfow.zzd(jSONObject, "images");
        final zzdhe<zzabu> zzc = this.zzfow.zzc(jSONObject, "secondary_image");
        final zzdhe<zzabu> zzc2 = this.zzfow.zzc(jSONObject, "app_icon");
        final zzdhe<zzabp> zze = this.zzfow.zze(jSONObject, "attribution");
        final zzdhe<zzbdi> zzl = this.zzfow.zzl(jSONObject);
        final zzbyu zzbyuVar = this.zzfow;
        if (jSONObject.optBoolean("enable_omid") && (optJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String optString = optJSONObject.optString("omid_html");
            if (!TextUtils.isEmpty(optString)) {
                zzb = zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(zzbyuVar, optString) { // from class: com.google.android.gms.internal.ads.zzbyy
                    private final String zzcyr;
                    private final zzbyu zzfpl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfpl = zzbyuVar;
                        this.zzcyr = optString;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdgf
                    public final zzdhe zzf(Object obj) {
                        return this.zzfpl.a(this.zzcyr, obj);
                    }
                }, zzazd.zzdwi);
                final zzdhe zzdheVar = zzb;
                final zzdhe<List<zzbzf>> zzg = this.zzfox.zzg(jSONObject, "custom_assets");
                return zzdgs.zza(submit, zzd, zzc, zzc2, zze, zzl, zzdheVar, zzg).zza(new Callable(this, submit, zzd, zzc2, zzc, zze, jSONObject, zzl, zzdheVar, zzg) { // from class: com.google.android.gms.internal.ads.zzbys
                    private final zzdhe zzfgb;
                    private final zzbyq zzfos;
                    private final zzdhe zzfpa;
                    private final zzdhe zzfpb;
                    private final zzdhe zzfpc;
                    private final zzdhe zzfpd;
                    private final JSONObject zzfpe;
                    private final zzdhe zzfpf;
                    private final zzdhe zzfpg;
                    private final zzdhe zzfph;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfos = this;
                        this.zzfpa = submit;
                        this.zzfgb = zzd;
                        this.zzfpb = zzc2;
                        this.zzfpc = zzc;
                        this.zzfpd = zze;
                        this.zzfpe = jSONObject;
                        this.zzfpf = zzl;
                        this.zzfpg = zzdheVar;
                        this.zzfph = zzg;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        zzdhe zzdheVar2 = this.zzfpa;
                        zzdhe zzdheVar3 = this.zzfgb;
                        zzdhe zzdheVar4 = this.zzfpb;
                        zzdhe zzdheVar5 = this.zzfpc;
                        zzdhe zzdheVar6 = this.zzfpd;
                        JSONObject jSONObject2 = this.zzfpe;
                        zzdhe zzdheVar7 = this.zzfpf;
                        zzdhe zzdheVar8 = this.zzfpg;
                        zzdhe zzdheVar9 = this.zzfph;
                        zzbws zzbwsVar = (zzbws) zzdheVar2.get();
                        zzbwsVar.setImages((List) zzdheVar3.get());
                        zzbwsVar.zza((zzaci) zzdheVar4.get());
                        zzbwsVar.zzb((zzaci) zzdheVar5.get());
                        zzbwsVar.zza((zzaca) zzdheVar6.get());
                        zzbwsVar.zzf(zzbyu.zzi(jSONObject2));
                        zzbwsVar.zza(zzbyu.zzj(jSONObject2));
                        zzbdi zzbdiVar = (zzbdi) zzdheVar7.get();
                        if (zzbdiVar != null) {
                            zzbwsVar.zzi(zzbdiVar);
                            zzbwsVar.zzab(zzbdiVar.getView());
                            zzbwsVar.zzb(zzbdiVar.zzyl());
                        }
                        zzbdi zzbdiVar2 = (zzbdi) zzdheVar8.get();
                        if (zzbdiVar2 != null) {
                            zzbwsVar.zzj(zzbdiVar2);
                        }
                        for (zzbzf zzbzfVar : (List) zzdheVar9.get()) {
                            int i = zzbzfVar.type;
                            if (i == 1) {
                                zzbwsVar.zzn(zzbzfVar.zzcc, zzbzfVar.zzfps);
                            } else if (i == 2) {
                                zzbwsVar.zza(zzbzfVar.zzcc, zzbzfVar.zzfpt);
                            }
                        }
                        return zzbwsVar;
                    }
                }, this.zzfov);
            }
        }
        zzb = zzdgs.zzaj(null);
        final zzdhe zzdheVar2 = zzb;
        final zzdhe zzg2 = this.zzfox.zzg(jSONObject, "custom_assets");
        return zzdgs.zza(submit, zzd, zzc, zzc2, zze, zzl, zzdheVar2, zzg2).zza(new Callable(this, submit, zzd, zzc2, zzc, zze, jSONObject, zzl, zzdheVar2, zzg2) { // from class: com.google.android.gms.internal.ads.zzbys
            private final zzdhe zzfgb;
            private final zzbyq zzfos;
            private final zzdhe zzfpa;
            private final zzdhe zzfpb;
            private final zzdhe zzfpc;
            private final zzdhe zzfpd;
            private final JSONObject zzfpe;
            private final zzdhe zzfpf;
            private final zzdhe zzfpg;
            private final zzdhe zzfph;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfos = this;
                this.zzfpa = submit;
                this.zzfgb = zzd;
                this.zzfpb = zzc2;
                this.zzfpc = zzc;
                this.zzfpd = zze;
                this.zzfpe = jSONObject;
                this.zzfpf = zzl;
                this.zzfpg = zzdheVar2;
                this.zzfph = zzg2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdhe zzdheVar22 = this.zzfpa;
                zzdhe zzdheVar3 = this.zzfgb;
                zzdhe zzdheVar4 = this.zzfpb;
                zzdhe zzdheVar5 = this.zzfpc;
                zzdhe zzdheVar6 = this.zzfpd;
                JSONObject jSONObject2 = this.zzfpe;
                zzdhe zzdheVar7 = this.zzfpf;
                zzdhe zzdheVar8 = this.zzfpg;
                zzdhe zzdheVar9 = this.zzfph;
                zzbws zzbwsVar = (zzbws) zzdheVar22.get();
                zzbwsVar.setImages((List) zzdheVar3.get());
                zzbwsVar.zza((zzaci) zzdheVar4.get());
                zzbwsVar.zzb((zzaci) zzdheVar5.get());
                zzbwsVar.zza((zzaca) zzdheVar6.get());
                zzbwsVar.zzf(zzbyu.zzi(jSONObject2));
                zzbwsVar.zza(zzbyu.zzj(jSONObject2));
                zzbdi zzbdiVar = (zzbdi) zzdheVar7.get();
                if (zzbdiVar != null) {
                    zzbwsVar.zzi(zzbdiVar);
                    zzbwsVar.zzab(zzbdiVar.getView());
                    zzbwsVar.zzb(zzbdiVar.zzyl());
                }
                zzbdi zzbdiVar2 = (zzbdi) zzdheVar8.get();
                if (zzbdiVar2 != null) {
                    zzbwsVar.zzj(zzbdiVar2);
                }
                for (zzbzf zzbzfVar : (List) zzdheVar9.get()) {
                    int i = zzbzfVar.type;
                    if (i == 1) {
                        zzbwsVar.zzn(zzbzfVar.zzcc, zzbzfVar.zzfps);
                    } else if (i == 2) {
                        zzbwsVar.zza(zzbzfVar.zzcc, zzbzfVar.zzfpt);
                    }
                }
                return zzbwsVar;
            }
        }, this.zzfov);
    }
}
