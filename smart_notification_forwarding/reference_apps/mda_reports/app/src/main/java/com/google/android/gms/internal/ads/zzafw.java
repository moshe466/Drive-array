package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzafw implements zzafv {
    private final /* synthetic */ zzazl zzcxt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafw(zzaft zzaftVar, zzazl zzazlVar) {
        this.zzcxt = zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafv
    public final void onFailure(@Nullable String str) {
        this.zzcxt.setException(new zzajr(str));
    }

    @Override // com.google.android.gms.internal.ads.zzafv
    public final void zzc(JSONObject jSONObject) {
        this.zzcxt.set(jSONObject);
    }
}
