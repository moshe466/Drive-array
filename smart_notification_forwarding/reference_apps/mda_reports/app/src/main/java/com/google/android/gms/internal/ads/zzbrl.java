package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public class zzbrl<ListenerT> {

    @GuardedBy("this")
    private final Map<ListenerT, Executor> zzfia = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbrl(Set<zzbsu<ListenerT>> set) {
        zzb(set);
    }

    private final synchronized void zzb(Set<zzbsu<ListenerT>> set) {
        Iterator<zzbsu<ListenerT>> it = set.iterator();
        while (it.hasNext()) {
            zza(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(final zzbrn<ListenerT> zzbrnVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.zzfia.entrySet()) {
            final ListenerT key = entry.getKey();
            entry.getValue().execute(new Runnable(zzbrnVar, key) { // from class: com.google.android.gms.internal.ads.zzbrk
                private final Object zzdbh;
                private final zzbrn zzfhz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfhz = zzbrnVar;
                    this.zzdbh = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zzfhz.zzp(this.zzdbh);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzq.zzku().zzb(th, "EventEmitter.notify");
                        zzavs.zza("Event emitter exception.", th);
                    }
                }
            });
        }
    }

    public final synchronized void zza(zzbsu<ListenerT> zzbsuVar) {
        zza(zzbsuVar.zzfir, zzbsuVar.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfia.put(listenert, executor);
    }
}
