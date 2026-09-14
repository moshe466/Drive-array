package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaxl {
    private final List<String> zzdud = new ArrayList();
    private final List<Double> zzdue = new ArrayList();
    private final List<Double> zzduf = new ArrayList();

    public final zzaxl zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzdud.size()) {
            double doubleValue = this.zzduf.get(i).doubleValue();
            double doubleValue2 = this.zzdue.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzdud.add(i, str);
        this.zzduf.add(i, Double.valueOf(d));
        this.zzdue.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzaxg zzxa() {
        return new zzaxg(this);
    }
}
