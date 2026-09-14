package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcuz implements zzcub<zzcuw> {
    private final String packageName;
    private final zzdhd zzfov;
    private final zzaqr zzghs;
    private final Context zzup;

    public zzcuz(@Nullable zzaqr zzaqrVar, Context context, String str, zzdhd zzdhdVar) {
        this.zzghs = zzaqrVar;
        this.zzup = context;
        this.packageName = str;
        this.zzfov = zzdhdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcuw a() {
        JSONObject jSONObject = new JSONObject();
        zzaqr zzaqrVar = this.zzghs;
        if (zzaqrVar != null) {
            zzaqrVar.zza(this.zzup, this.packageName, jSONObject);
        }
        return new zzcuw(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcuw> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcuy
            private final zzcuz zzghr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzghr = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzghr.a();
            }
        });
    }
}
