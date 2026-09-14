package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzcve implements zzcub<zzcty<JSONObject>> {
    private final JSONObject zzghw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcve(Context context) {
        this.zzghw = zzaqw.zzy(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzghw);
        } catch (JSONException unused) {
            zzavs.zzed("Failed putting version constants.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcty<JSONObject>> zzanc() {
        return zzdgs.zzaj(new zzcty(this) { // from class: com.google.android.gms.internal.ads.zzcvh
            private final zzcve zzghx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzghx = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcty
            public final void zzr(Object obj) {
                this.zzghx.a((JSONObject) obj);
            }
        });
    }
}
