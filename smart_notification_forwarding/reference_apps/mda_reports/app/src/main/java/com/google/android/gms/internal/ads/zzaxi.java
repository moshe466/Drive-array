package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* loaded from: classes.dex */
public final class zzaxi {
    public final int count;
    public final String name;
    private final double zzdtx;
    private final double zzdty;
    public final double zzdtz;

    public zzaxi(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzdty = d;
        this.zzdtx = d2;
        this.zzdtz = d3;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaxi)) {
            return false;
        }
        zzaxi zzaxiVar = (zzaxi) obj;
        return Objects.equal(this.name, zzaxiVar.name) && this.zzdtx == zzaxiVar.zzdtx && this.zzdty == zzaxiVar.zzdty && this.count == zzaxiVar.count && Double.compare(this.zzdtz, zzaxiVar.zzdtz) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzdtx), Double.valueOf(this.zzdty), Double.valueOf(this.zzdtz), Integer.valueOf(this.count));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("minBound", Double.valueOf(this.zzdty)).add("maxBound", Double.valueOf(this.zzdtx)).add("percent", Double.valueOf(this.zzdtz)).add("count", Integer.valueOf(this.count)).toString();
    }
}
