package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@TargetApi(16)
/* loaded from: classes.dex */
public final class zzbcy extends zzbcn implements zzbca {
    private String zzdyg;
    private boolean zzedo;
    private zzbbs zzedr;
    private Exception zzeds;
    private boolean zzedt;

    public zzbcy(zzbaz zzbazVar, zzbaw zzbawVar) {
        super(zzbazVar);
        this.zzedr = new zzbbs(zzbazVar.getContext(), zzbawVar);
        this.zzedr.zza(this);
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    private final void zzfl(String str) {
        synchronized (this) {
            this.zzedo = true;
            notify();
            release();
        }
        String str2 = this.zzdyg;
        if (str2 != null) {
            String a = a(str2);
            Exception exc = this.zzeds;
            if (exc != null) {
                zza(this.zzdyg, a, "badUrl", zzb(str, exc));
            } else {
                zza(this.zzdyg, a, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbcn
    public final String a(String str) {
        String valueOf = String.valueOf(super.a(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void abort() {
        zzfl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzbbs zzbbsVar = this.zzedr;
        if (zzbbsVar != null) {
            zzbbsVar.zza((zzbca) null);
            this.zzedr.release();
        }
        super.release();
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zza(String str, Exception exc) {
        String str2 = (String) zzve.zzoy().zzd(zzzn.zzcgs);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzeds = exc;
        zzayu.zzd("Precache error", exc);
        zzfl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzb(final boolean z, final long j) {
        final zzbaz zzbazVar = this.c.get();
        if (zzbazVar != null) {
            zzazd.zzdwi.execute(new Runnable(zzbazVar, z, j) { // from class: com.google.android.gms.internal.ads.zzbdb
                private final boolean zzdym;
                private final long zzebn;
                private final zzbaz zzedz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzedz = zzbazVar;
                    this.zzdym = z;
                    this.zzebn = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzedz.zza(this.zzdym, this.zzebn);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzcv(int i) {
        this.zzedr.zzzp().zzdc(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzcw(int i) {
        this.zzedr.zzzp().zzdd(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzcx(int i) {
        this.zzedr.zzzp().zzcx(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzcy(int i) {
        this.zzedr.zzzp().zzcy(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzda(int i) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [long] */
    /* JADX WARN: Type inference failed for: r1v27 */
    @Override // com.google.android.gms.internal.ads.zzbcn
    public final boolean zze(String str, String[] strArr) {
        String str2;
        long j;
        long j2;
        long j3;
        ?? r1;
        long j4;
        this.zzdyg = str;
        String a = a(str);
        String str3 = "error";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    uriArr[i] = Uri.parse(strArr[i]);
                } catch (Exception e) {
                    e = e;
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str);
                    sb.append(" Exception: ");
                    sb.append(message);
                    zzayu.zzez(sb.toString());
                    release();
                    zza(str, a, str3, zzb(str3, e));
                    return false;
                }
            }
            this.zzedr.zza(uriArr, this.b);
            zzbaz zzbazVar = this.c.get();
            if (zzbazVar != null) {
                zzbazVar.zza(a, this);
            }
            Clock zzkx = com.google.android.gms.ads.internal.zzq.zzkx();
            long currentTimeMillis = zzkx.currentTimeMillis();
            long longValue = ((Long) zzve.zzoy().zzd(zzzn.zzcgy)).longValue();
            long longValue2 = ((Long) zzve.zzoy().zzd(zzzn.zzcgx)).longValue() * 1000;
            long intValue = ((Integer) zzve.zzoy().zzd(zzzn.zzcgw)).intValue();
            long j5 = -1;
            while (true) {
                try {
                    synchronized (this) {
                        try {
                            if (zzkx.currentTimeMillis() - currentTimeMillis > longValue2) {
                                long j6 = longValue2;
                                StringBuilder sb2 = new StringBuilder(47);
                                sb2.append("Timeout reached. Limit: ");
                                sb2.append(j6);
                                sb2.append(" ms");
                                throw new IOException(sb2.toString());
                            }
                            if (this.zzedo) {
                                if (this.zzeds != null) {
                                    throw this.zzeds;
                                }
                                throw new IOException("Abort requested before buffering finished. ");
                            }
                            if (!this.zzedt) {
                                zzgk zzzm = this.zzedr.zzzm();
                                str2 = str3;
                                if (zzzm == null) {
                                    throw new IOException("ExoPlayer was released during preloading.");
                                }
                                try {
                                    long duration = zzzm.getDuration();
                                    if (duration > 0) {
                                        long bufferedPosition = zzzm.getBufferedPosition();
                                        if (bufferedPosition != j5) {
                                            j = intValue;
                                            j2 = longValue2;
                                            j4 = longValue;
                                            zza(str, a, bufferedPosition, duration, bufferedPosition > 0, zzbbs.zzzn(), zzbbs.zzzo());
                                            j5 = bufferedPosition;
                                        } else {
                                            j = intValue;
                                            j2 = longValue2;
                                            j4 = longValue;
                                        }
                                        if (bufferedPosition >= duration) {
                                            zzb(str, a, duration);
                                            break;
                                        }
                                        if (this.zzedr.getBytesTransferred() >= j && bufferedPosition > 0) {
                                            break;
                                        }
                                        j3 = j5;
                                        r1 = j4;
                                    } else {
                                        j = intValue;
                                        j2 = longValue2;
                                        j3 = j5;
                                        r1 = longValue;
                                    }
                                    try {
                                        try {
                                            wait(r1);
                                        } catch (Throwable th) {
                                            th = th;
                                            str3 = r1;
                                            throw th;
                                        }
                                    } catch (InterruptedException unused) {
                                        throw new IOException("Wait interrupted.");
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str3 = str2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    longValue = r1;
                    j5 = j3;
                    str3 = str2;
                    intValue = j;
                    longValue2 = j2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            return true;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final boolean zzfi(String str) {
        return zze(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzn(int i, int i2) {
    }

    public final zzbbs zzzr() {
        synchronized (this) {
            this.zzedt = true;
            notify();
        }
        this.zzedr.zza((zzbca) null);
        zzbbs zzbbsVar = this.zzedr;
        this.zzedr = null;
        return zzbbsVar;
    }
}
