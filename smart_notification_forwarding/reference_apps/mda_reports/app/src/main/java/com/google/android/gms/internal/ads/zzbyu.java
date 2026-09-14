package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.gass.AdShield2Logger;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbyu {
    private final Executor executor;
    private final zzazb zzbll;
    private final zzaby zzddz;
    private final zzsm zzeeg;
    private final zzdq zzefv;
    private final ScheduledExecutorService zzffx;
    private final zzbyl zzfpi;
    private final com.google.android.gms.ads.internal.zza zzfpj;
    private final zzbzh zzfpk;
    private final Context zzup;

    public zzbyu(Context context, zzbyl zzbylVar, zzdq zzdqVar, zzazb zzazbVar, com.google.android.gms.ads.internal.zza zzaVar, zzsm zzsmVar, Executor executor, zzczu zzczuVar, zzbzh zzbzhVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzup = context;
        this.zzfpi = zzbylVar;
        this.zzefv = zzdqVar;
        this.zzbll = zzazbVar;
        this.zzfpj = zzaVar;
        this.zzeeg = zzsmVar;
        this.executor = executor;
        this.zzddz = zzczuVar.zzddz;
        this.zzfpk = zzbzhVar;
        this.zzffx = scheduledExecutorService;
    }

    private static <T> zzdhe<T> zza(zzdhe<T> zzdheVar, T t) {
        final Object obj = null;
        return zzdgs.zzb(zzdheVar, Exception.class, new zzdgf(obj) { // from class: com.google.android.gms.internal.ads.zzbza
            private final Object zzfpo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpo = obj;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj2) {
                Object obj3 = this.zzfpo;
                zzavs.zza("Error during loading assets.", (Exception) obj2);
                return zzdgs.zzaj(obj3);
            }
        }, zzazd.zzdwj);
    }

    private final zzdhe<List<zzabu>> zza(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdgs.zzaj(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzdgs.zzb(zzdgs.zzg(arrayList), zzbyt.a, this.executor);
    }

    private final zzdhe<zzabu> zza(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdgs.zzaj(null);
        }
        final String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzdgs.zzaj(null);
        }
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        final int optInt = jSONObject.optInt(SettingsJsonConstants.ICON_WIDTH_KEY, -1);
        final int optInt2 = jSONObject.optInt(SettingsJsonConstants.ICON_HEIGHT_KEY, -1);
        if (z) {
            return zzdgs.zzaj(new zzabu(null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), (zzdhe<Object>) zzdgs.zzb(this.zzfpi.zza(optString, optDouble, optBoolean), new zzded(optString, optDouble, optInt, optInt2) { // from class: com.google.android.gms.internal.ads.zzbyw
            private final String zzcyz;
            private final int zzdtg;
            private final int zzdth;
            private final double zzfpm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyz = optString;
                this.zzfpm = optDouble;
                this.zzdtg = optInt;
                this.zzdth = optInt2;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                String str = this.zzcyz;
                return new zzabu(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzfpm, this.zzdtg, this.zzdth);
            }
        }, this.executor), (Object) null);
    }

    private static <T> zzdhe<T> zza(boolean z, final zzdhe<T> zzdheVar, T t) {
        return z ? zzdgs.zzb(zzdheVar, new zzdgf(zzdheVar) { // from class: com.google.android.gms.internal.ads.zzbyz
            private final zzdhe zzfpn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpn = zzdheVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return obj != null ? this.zzfpn : zzdgs.zzk(new zzclr("Retrieve required value in native ad response failed.", 0));
            }
        }, zzazd.zzdwj) : zza(zzdheVar, (Object) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<zzxy> zzi(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzxy zzk = zzk(optJSONArray.optJSONObject(i));
            if (zzk != null) {
                arrayList.add(zzk);
            }
        }
        return arrayList;
    }

    @Nullable
    public static zzxy zzj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzk(optJSONObject);
    }

    @Nullable
    private static zzxy zzk(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzxy(optString, optString2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzabp a(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzabp(optString, list, zzf, zzf2, optInt > 0 ? Integer.valueOf(optInt) : null, jSONObject.optInt("presentation_ms", AdShield2Logger.EVENTID_ERROR_RUN_VM_INIT) + optInt2, this.zzddz.zzbjz, optBoolean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(String str, Object obj) {
        com.google.android.gms.ads.internal.zzq.zzkr();
        zzbdi zza = zzbdr.zza(this.zzup, zzbey.zzabq(), "native-omid", false, false, this.zzefv, this.zzbll, null, null, this.zzfpj, this.zzeeg, null, false);
        final zzazi zzl = zzazi.zzl(zza);
        zza.zzaaa().zza(new zzbeu(zzl) { // from class: com.google.android.gms.internal.ads.zzbzc
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
        zza.loadData(str, "text/html", HttpRequest.CHARSET_UTF8);
        return zzl;
    }

    public final zzdhe<zzabu> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzddz.zzcvo);
    }

    public final zzdhe<List<zzabu>> zzd(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        zzaby zzabyVar = this.zzddz;
        return zza(optJSONArray, zzabyVar.zzcvo, zzabyVar.zzbjy);
    }

    public final zzdhe<zzabp> zze(JSONObject jSONObject, String str) {
        final JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdgs.zzaj(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), (zzdhe<Object>) zzdgs.zzb(zza(optJSONArray, false, true), new zzded(this, optJSONObject) { // from class: com.google.android.gms.internal.ads.zzbyv
            private final JSONObject zzfcs;
            private final zzbyu zzfpl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpl = this;
                this.zzfcs = optJSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                return this.zzfpl.a(this.zzfcs, (List) obj);
            }
        }, this.executor), (Object) null);
    }

    public final zzdhe<zzbdi> zzl(JSONObject jSONObject) {
        JSONObject zza = zzaxs.zza(jSONObject, "html_containers", "instream");
        if (zza != null) {
            final zzdhe<zzbdi> zzo = this.zzfpk.zzo(zza.optString("base_url"), zza.optString("html"));
            return zzdgs.zzb(zzo, new zzdgf(zzo) { // from class: com.google.android.gms.internal.ads.zzbyx
                private final zzdhe zzfpn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfpn = zzo;
                }

                @Override // com.google.android.gms.internal.ads.zzdgf
                public final zzdhe zzf(Object obj) {
                    zzdhe zzdheVar = this.zzfpn;
                    zzbdi zzbdiVar = (zzbdi) obj;
                    if (zzbdiVar == null || zzbdiVar.zzyl() == null) {
                        throw new zzclr("Retrieve video view in instream ad response failed.", 0);
                    }
                    return zzdheVar;
                }
            }, zzazd.zzdwj);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzdgs.zzaj(null);
        }
        if (!TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            return zza((zzdhe<Object>) zzdgs.zza(this.zzfpk.zzm(optJSONObject), ((Integer) zzve.zzoy().zzd(zzzn.zzcma)).intValue(), TimeUnit.SECONDS, this.zzffx), (Object) null);
        }
        zzayu.zzez("Required field 'vast_xml' is missing");
        return zzdgs.zzaj(null);
    }
}
