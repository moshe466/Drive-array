package com.google.android.gms.common.stats;

import F0.AbstractC0008a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* loaded from: classes.dex */
    public interface Types {
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public final String toString() {
        long zza = zza();
        int zzb = zzb();
        String zzc = zzc();
        int length = String.valueOf(zza).length();
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(zzb).length() + 3 + zzc.length());
        sb.append(zza);
        sb.append("\t");
        sb.append(zzb);
        return AbstractC0008a.u(sb, "\t-1", zzc);
    }

    public abstract long zza();

    public abstract int zzb();

    public abstract String zzc();
}
