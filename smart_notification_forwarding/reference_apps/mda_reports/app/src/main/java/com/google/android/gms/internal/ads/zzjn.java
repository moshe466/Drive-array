package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzjn {
    public final int zzanc = 1;
    public final byte[] zzand;

    public zzjn(int i, byte[] bArr) {
        this.zzand = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzjn.class == obj.getClass()) {
            zzjn zzjnVar = (zzjn) obj;
            if (this.zzanc == zzjnVar.zzanc && Arrays.equals(this.zzand, zzjnVar.zzand)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzanc * 31) + Arrays.hashCode(this.zzand);
    }
}
