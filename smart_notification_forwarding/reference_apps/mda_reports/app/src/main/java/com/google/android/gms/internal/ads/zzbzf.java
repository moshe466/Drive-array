package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzbzf {
    public final int type;
    public final String zzcc;
    public final String zzfps;
    public final zzabu zzfpt;

    @VisibleForTesting
    public zzbzf(String str, zzabu zzabuVar) {
        this.type = 2;
        this.zzcc = str;
        this.zzfps = null;
        this.zzfpt = zzabuVar;
    }

    @VisibleForTesting
    public zzbzf(String str, String str2) {
        this.type = 1;
        this.zzcc = str;
        this.zzfps = str2;
        this.zzfpt = null;
    }
}
