package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class zzdsq extends zzdso {
    private static final Class<?> zzhok = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdsq() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> zzfd;
        zzdsm zzdsmVar;
        List<L> zzd = zzd(obj, j);
        if (!zzd.isEmpty()) {
            if (zzhok.isAssignableFrom(zzd.getClass())) {
                ArrayList arrayList = new ArrayList(zzd.size() + i);
                arrayList.addAll(zzd);
                zzdsmVar = arrayList;
            } else if (zzd instanceof zzdut) {
                zzdsm zzdsmVar2 = new zzdsm(zzd.size() + i);
                zzdsmVar2.addAll((zzdut) zzd);
                zzdsmVar = zzdsmVar2;
            } else {
                if (!(zzd instanceof zzdtq) || !(zzd instanceof zzdsb)) {
                    return zzd;
                }
                zzdsb zzdsbVar = (zzdsb) zzd;
                if (zzdsbVar.zzaxp()) {
                    return zzd;
                }
                zzfd = zzdsbVar.zzfd(zzd.size() + i);
            }
            zzduy.a(obj, j, zzdsmVar);
            return zzdsmVar;
        }
        zzfd = zzd instanceof zzdsl ? new zzdsm(i) : ((zzd instanceof zzdtq) && (zzd instanceof zzdsb)) ? ((zzdsb) zzd).zzfd(i) : new ArrayList<>(i);
        zzduy.a(obj, j, zzfd);
        return zzfd;
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzduy.f(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdso
    public final <L> List<L> a(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdso
    public final <E> void a(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzduy.a(obj, j, zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdso
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzduy.f(obj, j);
        if (list instanceof zzdsl) {
            unmodifiableList = ((zzdsl) list).zzbaw();
        } else {
            if (zzhok.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzdtq) && (list instanceof zzdsb)) {
                zzdsb zzdsbVar = (zzdsb) list;
                if (zzdsbVar.zzaxp()) {
                    zzdsbVar.zzaxq();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzduy.a(obj, j, unmodifiableList);
    }
}
