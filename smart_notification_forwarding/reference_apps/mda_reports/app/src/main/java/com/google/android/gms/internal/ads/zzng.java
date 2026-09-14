package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzng {
    public final int length;
    private int zzafx;
    private final zzne[] zzbee;

    public zzng(zzne... zzneVarArr) {
        this.zzbee = zzneVarArr;
        this.length = zzneVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzng.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbee, ((zzng) obj).zzbee);
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = Arrays.hashCode(this.zzbee) + 527;
        }
        return this.zzafx;
    }

    public final zzne zzay(int i) {
        return this.zzbee[i];
    }

    public final zzne[] zzie() {
        return (zzne[]) this.zzbee.clone();
    }
}
