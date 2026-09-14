package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcua<T> {
    private final Executor executor;
    private final Set<zzcub<? extends zzcty<T>>> zzggz;

    public zzcua(Executor executor, Set<zzcub<? extends zzcty<T>>> set) {
        this.executor = executor;
        this.zzggz = set;
    }

    public final zzdhe<T> zzs(final T t) {
        final ArrayList arrayList = new ArrayList(this.zzggz.size());
        for (final zzcub<? extends zzcty<T>> zzcubVar : this.zzggz) {
            zzdhe<? extends zzcty<T>> zzanc = zzcubVar.zzanc();
            if (zzabc.zzctx.get().booleanValue()) {
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
                zzanc.addListener(new Runnable(zzcubVar, elapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzcud
                    private final zzcub zzgha;
                    private final long zzghb;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgha = zzcubVar;
                        this.zzghb = elapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcub zzcubVar2 = this.zzgha;
                        long j = this.zzghb;
                        String canonicalName = zzcubVar2.getClass().getCanonicalName();
                        long elapsedRealtime2 = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - j;
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(elapsedRealtime2);
                        zzavs.zzed(sb.toString());
                    }
                }, zzazd.zzdwj);
            }
            arrayList.add(zzanc);
        }
        return zzdgs.zzi(arrayList).zza(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.zzcuc
            private final Object zzdbh;
            private final List zzggn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggn = arrayList;
                this.zzdbh = t;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List list = this.zzggn;
                Object obj = this.zzdbh;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzcty zzctyVar = (zzcty) ((zzdhe) it.next()).get();
                    if (zzctyVar != null) {
                        zzctyVar.zzr(obj);
                    }
                }
                return obj;
            }
        }, this.executor);
    }
}
