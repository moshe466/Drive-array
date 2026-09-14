package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzms {
    public final int length;
    private int zzafx;
    private final zzgw[] zzbbx;

    public zzms(zzgw... zzgwVarArr) {
        zzoc.checkState(zzgwVarArr.length > 0);
        this.zzbbx = zzgwVarArr;
        this.length = zzgwVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzms.class == obj.getClass()) {
            zzms zzmsVar = (zzms) obj;
            if (this.length == zzmsVar.length && Arrays.equals(this.zzbbx, zzmsVar.zzbbx)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = Arrays.hashCode(this.zzbbx) + 527;
        }
        return this.zzafx;
    }

    public final zzgw zzaw(int i) {
        return this.zzbbx[i];
    }

    public final int zzh(zzgw zzgwVar) {
        int i = 0;
        while (true) {
            zzgw[] zzgwVarArr = this.zzbbx;
            if (i >= zzgwVarArr.length) {
                return -1;
            }
            if (zzgwVar == zzgwVarArr[i]) {
                return i;
            }
            i++;
        }
    }
}
