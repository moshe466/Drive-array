package com.google.android.datatransport.cct.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zzi;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class zzt {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class zza {
        @NonNull
        abstract zza a(@Nullable String str);

        @NonNull
        abstract zza a(@Nullable byte[] bArr);

        @NonNull
        public abstract zza zza(int i);

        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzy zzyVar);

        @NonNull
        public abstract zzt zza();

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public abstract zza zzc(long j);
    }

    @NonNull
    public static zza zza(@NonNull String str) {
        return new zzi.zza().zza(Integer.MIN_VALUE).a(str);
    }

    @NonNull
    public static zza zza(@NonNull byte[] bArr) {
        return new zzi.zza().zza(Integer.MIN_VALUE).a(bArr);
    }

    public abstract long zza();

    public abstract long zzb();

    public abstract long zzc();
}
