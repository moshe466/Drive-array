package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbga;
import com.google.android.gms.internal.ads.zzbhq;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public abstract class zzbfx implements zzbij {

    @GuardedBy("AppComponent.class")
    private static zzbfx zzejp;

    public static zzbfx zza(Context context, zzalc zzalcVar, int i) {
        zzbfx zzd = zzd(context, i);
        zzd.zzacf().zzb(zzalcVar);
        return zzd;
    }

    @Deprecated
    private static zzbfx zza(zzazb zzazbVar, Context context, zzbhq.zza zzaVar) {
        zzbfx zzbfxVar;
        synchronized (zzbfx.class) {
            if (zzejp == null) {
                zzejp = new zzbhh().zzc(new zzbga(new zzbga.zza().zza(zzazbVar).zzbs(context))).zza(new zzbhq(zzaVar)).zzael();
                zzzn.initialize(context);
                com.google.android.gms.ads.internal.zzq.zzku().zzd(context, zzazbVar);
                com.google.android.gms.ads.internal.zzq.zzkw().initialize(context);
                com.google.android.gms.ads.internal.zzq.zzkq().zzao(context);
                com.google.android.gms.ads.internal.zzq.zzkq().zzap(context);
                zzavq.zzan(context);
                com.google.android.gms.ads.internal.zzq.zzkt().initialize(context);
                com.google.android.gms.ads.internal.zzq.zzll().initialize(context);
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue()) {
                    new zzcik(context, zzazbVar, new zzsm(new zzsr(context)), new zzcht(new zzchr(context), zzejp.zzacd())).zzamc();
                }
            }
            zzbfxVar = zzejp;
        }
        return zzbfxVar;
    }

    @Deprecated
    public static zzbfx zzd(Context context, int i) {
        synchronized (zzbfx.class) {
            if (zzejp == null) {
                return zza(new zzazb(19649000, i, true, false), context, new zzbgo());
            }
            return zzejp;
        }
    }

    protected abstract zzcut a(zzcvw zzcvwVar);

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzcut zza(zzaqk zzaqkVar) {
        return a(new zzcvw(zzaqkVar));
    }

    public abstract Executor zzaca();

    public abstract ScheduledExecutorService zzacb();

    public abstract Executor zzacc();

    public abstract zzdhd zzacd();

    public abstract zzbqp zzace();

    public abstract zzcka zzacf();

    public abstract zzbht zzacg();

    public abstract zzblf zzach();

    public abstract zzbjz zzaci();

    public abstract zzcww zzacj();

    public abstract zzbus zzack();

    public abstract zzbvl zzacl();

    public abstract zzcbh zzacm();

    public abstract zzczc zzacn();

    public abstract zzcpf zzaco();
}
