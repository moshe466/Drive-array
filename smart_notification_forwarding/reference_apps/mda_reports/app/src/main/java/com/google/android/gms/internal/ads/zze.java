package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public final class zze implements zzs {
    private final Map<String, List<zzq<?>>> zzn = new HashMap();
    private final zzc zzo;

    public zze(zzc zzcVar) {
        this.zzo = zzcVar;
    }

    public final synchronized boolean zzb(zzq<?> zzqVar) {
        String zzd = zzqVar.zzd();
        if (!this.zzn.containsKey(zzd)) {
            this.zzn.put(zzd, null);
            zzqVar.a((zzs) this);
            if (zzag.DEBUG) {
                zzag.d("new request, sending to network %s", zzd);
            }
            return false;
        }
        List<zzq<?>> list = this.zzn.get(zzd);
        if (list == null) {
            list = new ArrayList<>();
        }
        zzqVar.zzb("waiting-for-response");
        list.add(zzqVar);
        this.zzn.put(zzd, list);
        if (zzag.DEBUG) {
            zzag.d("Request for cacheKey=%s is in flight, putting on hold.", zzd);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzs
    public final synchronized void zza(zzq<?> zzqVar) {
        BlockingQueue blockingQueue;
        String zzd = zzqVar.zzd();
        List<zzq<?>> remove = this.zzn.remove(zzd);
        if (remove != null && !remove.isEmpty()) {
            if (zzag.DEBUG) {
                zzag.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zzd);
            }
            zzq<?> remove2 = remove.remove(0);
            this.zzn.put(zzd, remove);
            remove2.a((zzs) this);
            try {
                blockingQueue = this.zzo.zzb;
                blockingQueue.put(remove2);
            } catch (InterruptedException e) {
                zzag.e("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzo.quit();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzs
    public final void zza(zzq<?> zzqVar, zzz<?> zzzVar) {
        List<zzq<?>> remove;
        zzaa zzaaVar;
        zzd zzdVar = zzzVar.zzbh;
        if (zzdVar == null || zzdVar.isExpired()) {
            zza(zzqVar);
            return;
        }
        String zzd = zzqVar.zzd();
        synchronized (this) {
            remove = this.zzn.remove(zzd);
        }
        if (remove != null) {
            if (zzag.DEBUG) {
                zzag.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zzd);
            }
            for (zzq<?> zzqVar2 : remove) {
                zzaaVar = this.zzo.zzd;
                zzaaVar.zzb(zzqVar2, zzzVar);
            }
        }
    }
}
