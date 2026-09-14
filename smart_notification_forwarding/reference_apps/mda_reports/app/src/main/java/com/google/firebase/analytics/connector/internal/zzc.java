package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzc implements zza {
    Set<String> a;
    private AnalyticsConnector.AnalyticsConnectorListener zzb;
    private AppMeasurement zzc;
    private zzf zzd = new zzf(this);

    public zzc(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurement;
        this.zzc.registerOnMeasurementEventListener(this.zzd);
        this.a = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
        this.a.clear();
        Set<String> set2 = this.a;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzd.zzd(str) && zzd.zzc(str)) {
                hashSet.add(zzd.zzf(str));
            }
        }
        set2.addAll(hashSet);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
        this.a.clear();
    }
}
