package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class zzcfx extends zzcfv {
    private static final Pattern zzfvg = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzffx;
    private final zzczu zzfgl;
    private final zzdhd zzfov;
    private final zzcfe zzfve;
    private final zzchz zzfvf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfx(zzbqs zzbqsVar, zzczu zzczuVar, zzcfe zzcfeVar, zzdhd zzdhdVar, ScheduledExecutorService scheduledExecutorService, zzchz zzchzVar) {
        super(zzbqsVar);
        this.zzfgl = zzczuVar;
        this.zzfve = zzcfeVar;
        this.zzfov = zzdhdVar;
        this.zzffx = scheduledExecutorService;
        this.zzfvf = zzchzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(InputStream inputStream) {
        return zzdgs.zzaj(new zzczt(new zzczo(this.zzfgl), zzczr.zza(new InputStreamReader(inputStream))));
    }

    @Override // com.google.android.gms.internal.ads.zzcfv
    public final zzdhe<zzczt> zze(zzaqk zzaqkVar) {
        zzdhe<zzczt> zzb = zzdgs.zzb(this.zzfve.zzc(zzaqkVar), new zzdgf(this) { // from class: com.google.android.gms.internal.ads.zzcga
            private final zzcfx zzfvi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfvi = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfvi.a((InputStream) obj);
            }
        }, this.zzfov);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcow)).booleanValue()) {
            zzb = zzdgs.zzb(zzdgs.zza(zzb, ((Integer) zzve.zzoy().zzd(zzzn.zzcox)).intValue(), TimeUnit.SECONDS, this.zzffx), TimeoutException.class, zzcfz.a, zzazd.zzdwj);
        }
        zzdgs.zza(zzb, new zzcgc(this), zzazd.zzdwj);
        return zzb;
    }
}
