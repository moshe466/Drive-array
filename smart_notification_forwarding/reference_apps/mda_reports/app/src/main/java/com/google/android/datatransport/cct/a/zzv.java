package com.google.android.datatransport.cct.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zzk;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
/* loaded from: classes.dex */
public abstract class zzv {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class zza {
        @NonNull
        abstract zza a(int i);

        @NonNull
        abstract zza a(@Nullable String str);

        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzaa zzaaVar);

        @NonNull
        public abstract zza zza(@Nullable zzq zzqVar);

        @NonNull
        public abstract zza zza(@Nullable List<zzt> list);

        @NonNull
        public abstract zzv zza();

        @NonNull
        public zza zzb(int i) {
            return a(i);
        }

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public zza zzb(@NonNull String str) {
            return a(str);
        }
    }

    @NonNull
    public static zza zza() {
        return new zzk.zza().a(Integer.MIN_VALUE);
    }
}
