package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzakc {

    @VisibleForTesting
    private static final zzaxh<zzaif> zzdat = new zzakb();

    @VisibleForTesting
    private static final zzaxh<zzaif> zzdau = new zzake();
    private final zzais zzdav;

    public zzakc(Context context, zzazb zzazbVar, String str) {
        this.zzdav = new zzais(context, zzazbVar, str, zzdat, zzdau);
    }

    public final <I, O> zzaju<I, O> zza(String str, zzajv<I> zzajvVar, zzajw<O> zzajwVar) {
        return new zzakd(this.zzdav, str, zzajvVar, zzajwVar);
    }

    public final zzakh zzsh() {
        return new zzakh(this.zzdav);
    }
}
