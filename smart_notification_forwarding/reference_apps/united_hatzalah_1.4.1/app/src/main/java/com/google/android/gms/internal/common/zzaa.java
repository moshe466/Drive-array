package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* loaded from: classes.dex */
class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    public zzaa(int i) {
    }

    public final zzaa zza(Object obj) {
        int i;
        obj.getClass();
        int length = this.zza.length;
        int i3 = this.zzb;
        int i4 = i3 + 1;
        if (i4 >= 0) {
            if (i4 <= length) {
                i = length;
            } else {
                i = (length >> 1) + length + 1;
                if (i < i4) {
                    int highestOneBit = Integer.highestOneBit(i3);
                    i = highestOneBit + highestOneBit;
                }
                if (i < 0) {
                    i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            if (i > length || this.zzc) {
                this.zza = Arrays.copyOf(this.zza, i);
                this.zzc = false;
            }
            Object[] objArr = this.zza;
            int i5 = this.zzb;
            this.zzb = i5 + 1;
            objArr[i5] = obj;
            return this;
        }
        throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
    }
}
