package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzajt {
    private final Object zzdam = new Object();
    private final Object zzdan = new Object();

    @GuardedBy("lockClient")
    private zzakc zzdao;

    @GuardedBy("lockService")
    private zzakc zzdap;

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzakc zza(Context context, zzazb zzazbVar) {
        zzakc zzakcVar;
        synchronized (this.zzdan) {
            if (this.zzdap == null) {
                this.zzdap = new zzakc(zzl(context), zzazbVar, zzabh.zzcuh.get());
            }
            zzakcVar = this.zzdap;
        }
        return zzakcVar;
    }

    public final zzakc zzb(Context context, zzazb zzazbVar) {
        zzakc zzakcVar;
        synchronized (this.zzdam) {
            if (this.zzdao == null) {
                this.zzdao = new zzakc(zzl(context), zzazbVar, (String) zzve.zzoy().zzd(zzzn.zzcgh));
            }
            zzakcVar = this.zzdao;
        }
        return zzakcVar;
    }
}
