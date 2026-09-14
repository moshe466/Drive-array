package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakq implements zzafv {
    private final zzazl<O> zzdbf;
    private final /* synthetic */ zzako zzdbi;

    public zzakq(zzako zzakoVar, zzazl<O> zzazlVar) {
        this.zzdbi = zzakoVar;
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
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafv
    public final void zzc(JSONObject jSONObject) {
        zzajw zzajwVar;
        try {
            zzazl<O> zzazlVar = this.zzdbf;
            zzajwVar = this.zzdbi.zzdaw;
            zzazlVar.set(zzajwVar.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdbf.setException(e);
        }
    }
}
