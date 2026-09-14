package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaev implements zzafn<Object> {
    private final zzaey zzcws;

    public zzaev(zzaey zzaeyVar) {
        this.zzcws = zzaeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            zzayu.zzez("App event with no name parameter.");
        } else {
            this.zzcws.onAppEvent(str, map.get("info"));
        }
    }
}
