package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcoh extends zzanm {
    private final String zzcyc;
    private final zzani zzgcj;
    private zzazl<JSONObject> zzgck;
    private final JSONObject zzgcl = new JSONObject();

    @GuardedBy("this")
    private boolean zzgcm = false;

    public zzcoh(String str, zzani zzaniVar, zzazl<JSONObject> zzazlVar) {
        this.zzgck = zzazlVar;
        this.zzcyc = str;
        this.zzgcj = zzaniVar;
        try {
            this.zzgcl.put("adapter_version", this.zzgcj.zztc().toString());
            this.zzgcl.put("sdk_version", this.zzgcj.zztd().toString());
            this.zzgcl.put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.zzcyc);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final synchronized void onFailure(String str) {
        if (this.zzgcm) {
            return;
        }
        try {
            this.zzgcl.put("signal_error", str);
        } catch (JSONException unused) {
        }
        this.zzgck.set(this.zzgcl);
        this.zzgcm = true;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final synchronized void zzdn(String str) {
        if (this.zzgcm) {
            return;
        }
        if (str == null) {
            onFailure("Adapter returned null signals");
            return;
        }
        try {
            this.zzgcl.put("signals", str);
        } catch (JSONException unused) {
        }
        this.zzgck.set(this.zzgcl);
        this.zzgcm = true;
    }
}
