package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzagh implements zzn {
    private volatile zzaga zzcxz;
    private final Context zzup;

    public zzagh(Context context) {
        this.zzup = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzcxz == null) {
            return;
        }
        this.zzcxz.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzn
    public final zzo zzc(zzq<?> zzqVar) {
        zzafz zzh = zzafz.zzh(zzqVar);
        long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
        try {
            zzazl zzazlVar = new zzazl();
            this.zzcxz = new zzaga(this.zzup, com.google.android.gms.ads.internal.zzq.zzle().zzxb(), new zzagl(this, zzazlVar), new zzago(this, zzazlVar));
            this.zzcxz.checkAvailabilityAndConnect();
            zzdhe zza = zzdgs.zza(zzdgs.zzb(zzazlVar, new zzagk(this, zzh), zzazd.zzdwe), ((Integer) zzve.zzoy().zzd(zzzn.zzcni)).intValue(), TimeUnit.MILLISECONDS, zzazd.zzdwh);
            zza.addListener(new zzagm(this), zzazd.zzdwe);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzavs.zzed(sb.toString());
            zzagb zzagbVar = (zzagb) new zzaqj(parcelFileDescriptor).zza(zzagb.CREATOR);
            if (zzagbVar == null) {
                return null;
            }
            if (zzagbVar.zzcxx) {
                throw new zzae(zzagbVar.zzcxy);
            }
            if (zzagbVar.zzcxv.length != zzagbVar.zzcxw.length) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                String[] strArr = zzagbVar.zzcxv;
                if (i >= strArr.length) {
                    return new zzo(zzagbVar.statusCode, zzagbVar.data, hashMap, zzagbVar.zzac, zzagbVar.zzad);
                }
                hashMap.put(strArr[i], zzagbVar.zzcxw[i]);
                i++;
            }
        } catch (InterruptedException | ExecutionException unused) {
            long elapsedRealtime3 = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(elapsedRealtime3);
            sb2.append("ms");
            zzavs.zzed(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime4 = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime4);
            sb3.append("ms");
            zzavs.zzed(sb3.toString());
            throw th;
        }
    }
}
