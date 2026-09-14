package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zza {
    private long zza = Long.MIN_VALUE;

    public final zza zza(long j2) {
        boolean z3;
        if (j2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "intervalMillis can't be negative.");
        this.zza = j2;
        return this;
    }

    public final zzb zzb() {
        boolean z3;
        if (this.zza != Long.MIN_VALUE) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Must set intervalMillis.");
        return new zzb(this.zza, true, null, null, null, false, null, 0L, null);
    }
}
