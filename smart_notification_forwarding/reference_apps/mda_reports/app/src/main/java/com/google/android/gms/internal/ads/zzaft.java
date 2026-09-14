package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaft implements zzafn<Object> {
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Map<String, zzafv> zzcxs = new HashMap();

    public final <EngineT extends zzaip> zzdhe<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzazl zzazlVar = new zzazl();
        com.google.android.gms.ads.internal.zzq.zzkq();
        String zzwk = zzawb.zzwk();
        zza(zzwk, new zzafw(this, zzazlVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", zzwk);
            jSONObject2.put("args", jSONObject);
            enginet.zza(str, jSONObject2);
        } catch (Exception e) {
            zzazlVar.setException(e);
        }
        return zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        String concat;
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            concat = "";
        } else {
            String valueOf = String.valueOf(str4);
            concat = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.lock) {
            zzafv remove = this.zzcxs.remove(str);
            if (remove == null) {
                String valueOf2 = String.valueOf(str);
                zzayu.zzez(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                String valueOf3 = String.valueOf(str3);
                String valueOf4 = String.valueOf(concat);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else {
                if (str5 == null) {
                    remove.zzc(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (zzavs.zzvs()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzavs.zzed(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e) {
                    remove.onFailure(e.getMessage());
                }
            }
        }
    }

    public final void zza(String str, zzafv zzafvVar) {
        synchronized (this.lock) {
            this.zzcxs.put(str, zzafvVar);
        }
    }
}
