package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class zzej {
    private final String zza;
    private final long zzb;
    private final int zzc;

    public zzej(String str, long j2, int i) {
        this.zza = str;
        this.zzb = j2;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzej) {
            zzej zzejVar = (zzej) obj;
            if (j.a(zzejVar.zza, this.zza) && zzejVar.zzb == this.zzb && zzejVar.zzc == this.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
