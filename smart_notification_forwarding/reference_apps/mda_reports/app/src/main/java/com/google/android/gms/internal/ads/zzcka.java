package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcka {
    private final AtomicReference<zzalc> zzfzi = new AtomicReference<>();

    private final zzalc zzamg() {
        zzalc zzalcVar = this.zzfzi.get();
        if (zzalcVar != null) {
            return zzalcVar;
        }
        zzayu.zzez("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    private final zzald zzf(String str, JSONObject jSONObject) {
        zzalc zzamg = zzamg();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                return zzamg.zzdf(jSONObject.getString("class_name")) ? zzamg.zzde("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : zzamg.zzde("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzayu.zzc("Invalid custom event.", e);
            }
        }
        return zzamg.zzde(str);
    }

    public final boolean zzamf() {
        return this.zzfzi.get() != null;
    }

    public final void zzb(zzalc zzalcVar) {
        this.zzfzi.compareAndSet(null, zzalcVar);
    }

    public final zzani zzdi(String str) {
        return zzamg().zzdi(str);
    }

    public final zzdac zze(String str, JSONObject jSONObject) {
        try {
            return new zzdac("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? new zzaly(new AdMobAdapter()) : "com.google.ads.mediation.AdUrlAdapter".equals(str) ? new zzaly(new AdUrlAdapter()) : "com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str) ? new zzaly(new zzany()) : zzf(str, jSONObject));
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }
}
