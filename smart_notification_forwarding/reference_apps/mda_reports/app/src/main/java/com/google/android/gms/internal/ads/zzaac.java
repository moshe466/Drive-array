package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaac {
    private final long time;

    @Nullable
    private final String zzcrw;

    @Nullable
    private final zzaac zzcrx;

    public zzaac(long j, @Nullable String str, @Nullable zzaac zzaacVar) {
        this.time = j;
        this.zzcrw = str;
        this.zzcrx = zzaacVar;
    }

    public final long getTime() {
        return this.time;
    }

    public final String zzqq() {
        return this.zzcrw;
    }

    @Nullable
    public final zzaac zzqr() {
        return this.zzcrx;
    }
}
