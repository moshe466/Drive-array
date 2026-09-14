package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzu {
    private final zzn zzaa;
    private final AtomicInteger zzav;
    private final Set<zzq<?>> zzaw;
    private final PriorityBlockingQueue<zzq<?>> zzax;
    private final PriorityBlockingQueue<zzq<?>> zzay;
    private final zzm[] zzaz;
    private final List<zzw> zzba;
    private final List<zzx> zzbb;
    private final zza zzc;
    private final zzaa zzd;
    private zzc zzo;

    public zzu(zza zzaVar, zzn zznVar) {
        this(zzaVar, zznVar, 4);
    }

    private zzu(zza zzaVar, zzn zznVar, int i) {
        this(zzaVar, zznVar, 4, new zzj(new Handler(Looper.getMainLooper())));
    }

    private zzu(zza zzaVar, zzn zznVar, int i, zzaa zzaaVar) {
        this.zzav = new AtomicInteger();
        this.zzaw = new HashSet();
        this.zzax = new PriorityBlockingQueue<>();
        this.zzay = new PriorityBlockingQueue<>();
        this.zzba = new ArrayList();
        this.zzbb = new ArrayList();
        this.zzc = zzaVar;
        this.zzaa = zznVar;
        this.zzaz = new zzm[4];
        this.zzd = zzaaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> void a(zzq<T> zzqVar) {
        synchronized (this.zzaw) {
            this.zzaw.remove(zzqVar);
        }
        synchronized (this.zzba) {
            Iterator<zzw> it = this.zzba.iterator();
            while (it.hasNext()) {
                it.next().zzg(zzqVar);
            }
        }
        a(zzqVar, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzq<?> zzqVar, int i) {
        synchronized (this.zzbb) {
            Iterator<zzx> it = this.zzbb.iterator();
            while (it.hasNext()) {
                it.next().zzb(zzqVar, i);
            }
        }
    }

    public final void start() {
        zzc zzcVar = this.zzo;
        if (zzcVar != null) {
            zzcVar.quit();
        }
        for (zzm zzmVar : this.zzaz) {
            if (zzmVar != null) {
                zzmVar.quit();
            }
        }
        this.zzo = new zzc(this.zzax, this.zzay, this.zzc, this.zzd);
        this.zzo.start();
        for (int i = 0; i < this.zzaz.length; i++) {
            zzm zzmVar2 = new zzm(this.zzay, this.zzaa, this.zzc, this.zzd);
            this.zzaz[i] = zzmVar2;
            zzmVar2.start();
        }
    }

    public final <T> zzq<T> zze(zzq<T> zzqVar) {
        zzqVar.zza(this);
        synchronized (this.zzaw) {
            this.zzaw.add(zzqVar);
        }
        zzqVar.zzb(this.zzav.incrementAndGet());
        zzqVar.zzb("add-to-queue");
        a(zzqVar, 0);
        (!zzqVar.zzg() ? this.zzay : this.zzax).add(zzqVar);
        return zzqVar;
    }
}
