package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaki implements zzafv {
    private final /* synthetic */ zzakd zzdbb;
    private final zzajf zzdbe;
    private final zzazl<O> zzdbf;

    public zzaki(zzakd zzakdVar, zzajf zzajfVar, zzazl<O> zzazlVar) {
        this.zzdbb = zzakdVar;
        this.zzdbe = zzajfVar;
        this.zzdbf = zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafv
    public final void onFailure(@Nullable String str) {
        try {
            if (str == null) {
                this.zzdbf.setException(new zzajr());
            } else {
                this.zzdbf.setException(new zzajr(str));
            }
        } catch (IllegalStateException unused) {
        } catch (Throwable th) {
            this.zzdbe.release();
            throw th;
        }
        this.zzdbe.release();
    }

    @Override // com.google.android.gms.internal.ads.zzafv
    public final void zzc(JSONObject jSONObject) {
        zzajw zzajwVar;
        try {
            try {
                zzazl<O> zzazlVar = this.zzdbf;
                zzajwVar = this.zzdbb.zzdaw;
                zzazlVar.set(zzajwVar.zzd(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e) {
                this.zzdbf.setException(e);
            }
        } finally {
            this.zzdbe.release();
        }
    }
}
