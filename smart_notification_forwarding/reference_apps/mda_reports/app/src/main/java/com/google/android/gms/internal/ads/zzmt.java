package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public class zzmt implements zzne {
    private final int length;
    private int zzafx;
    private final zzgw[] zzbbx;
    private final zzms zzbdf;
    private final int[] zzbdg;
    private final long[] zzbdh;

    public zzmt(zzms zzmsVar, int... iArr) {
        int i = 0;
        zzoc.checkState(iArr.length > 0);
        this.zzbdf = (zzms) zzoc.checkNotNull(zzmsVar);
        this.length = iArr.length;
        this.zzbbx = new zzgw[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbbx[i2] = zzmsVar.zzaw(iArr[i2]);
        }
        Arrays.sort(this.zzbbx, new zzmv());
        this.zzbdg = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i >= i3) {
                this.zzbdh = new long[i3];
                return;
            } else {
                this.zzbdg[i] = zzmsVar.zzh(this.zzbbx[i]);
                i++;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmt zzmtVar = (zzmt) obj;
            if (this.zzbdf == zzmtVar.zzbdf && Arrays.equals(this.zzbdg, zzmtVar.zzbdg)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = (System.identityHashCode(this.zzbdf) * 31) + Arrays.hashCode(this.zzbdg);
        }
        return this.zzafx;
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final int length() {
        return this.zzbdg.length;
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final zzgw zzaw(int i) {
        return this.zzbbx[i];
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final int zzax(int i) {
        return this.zzbdg[0];
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final zzms zzid() {
        return this.zzbdf;
    }
}
