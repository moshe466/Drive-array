package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzmr {
    public static final zzmr zzbdd = new zzmr(new zzms[0]);
    public final int length;
    private int zzafx;
    private final zzms[] zzbde;

    public zzmr(zzms... zzmsVarArr) {
        this.zzbde = zzmsVarArr;
        this.length = zzmsVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmr.class == obj.getClass()) {
            zzmr zzmrVar = (zzmr) obj;
            if (this.length == zzmrVar.length && Arrays.equals(this.zzbde, zzmrVar.zzbde)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = Arrays.hashCode(this.zzbde);
        }
        return this.zzafx;
    }

    public final int zza(zzms zzmsVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbde[i] == zzmsVar) {
                return i;
            }
        }
        return -1;
    }

    public final zzms zzav(int i) {
        return this.zzbde[i];
    }
}
