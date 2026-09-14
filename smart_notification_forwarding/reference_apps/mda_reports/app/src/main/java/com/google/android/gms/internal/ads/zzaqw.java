package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import io.fabric.sdk.android.services.network.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzaqw extends zzaqy {
    private final Object lock = new Object();

    @Nullable
    private SharedPreferences zzdnj;
    private final zzaju<JSONObject, JSONObject> zzdnk;
    private final Context zzyv;

    public zzaqw(Context context, zzaju<JSONObject, JSONObject> zzajuVar) {
        this.zzyv = context.getApplicationContext();
        this.zzdnk = zzajuVar;
    }

    public static JSONObject zzy(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzazb.zzxm().zzbma);
            jSONObject.put("mf", zzaaz.zzcti.get());
            jSONObject.put("cl", "278033407");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", HttpRequest.METHOD_HEAD);
            jSONObject.put("admob_module_version", 20360);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void a(JSONObject jSONObject) {
        zzzn.zza(this.zzyv, 1, jSONObject);
        this.zzdnj.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis()).apply();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final zzdhe<Void> zzuh() {
        synchronized (this.lock) {
            if (this.zzdnj == null) {
                this.zzdnj = this.zzyv.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis() - this.zzdnj.getLong("js_last_update", 0L) < zzaaz.zzctj.get().longValue()) {
            return zzdgs.zzaj(null);
        }
        return zzdgs.zzb(this.zzdnk.zzi(zzy(this.zzyv)), new zzded(this) { // from class: com.google.android.gms.internal.ads.zzaqz
            private final zzaqw zzdnn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdnn = this;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                return this.zzdnn.a((JSONObject) obj);
            }
        }, zzazd.zzdwj);
    }
}
