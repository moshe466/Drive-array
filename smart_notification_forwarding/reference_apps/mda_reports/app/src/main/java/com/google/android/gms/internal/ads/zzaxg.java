package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaxg {
    private final String[] zzdts;
    private final double[] zzdtt;
    private final double[] zzdtu;
    private final int[] zzdtv;
    private int zzdtw;

    private zzaxg(zzaxl zzaxlVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzaxlVar.zzdue;
        int size = list.size();
        list2 = zzaxlVar.zzdud;
        this.zzdts = (String[]) list2.toArray(new String[size]);
        list3 = zzaxlVar.zzdue;
        this.zzdtt = zze(list3);
        list4 = zzaxlVar.zzduf;
        this.zzdtu = zze(list4);
        this.zzdtv = new int[size];
        this.zzdtw = 0;
    }

    private static double[] zze(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzdtw++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzdtu;
            if (i >= dArr.length) {
                return;
            }
            if (dArr[i] <= d && d < this.zzdtt[i]) {
                int[] iArr = this.zzdtv;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.zzdtu[i]) {
                return;
            } else {
                i++;
            }
        }
    }

    public final List<zzaxi> zzwz() {
        ArrayList arrayList = new ArrayList(this.zzdts.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzdts;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzdtu[i];
            double d2 = this.zzdtt[i];
            int[] iArr = this.zzdtv;
            double d3 = iArr[i];
            double d4 = this.zzdtw;
            Double.isNaN(d3);
            Double.isNaN(d4);
            arrayList.add(new zzaxi(str, d, d2, d3 / d4, iArr[i]));
            i++;
        }
    }
}
