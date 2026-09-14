package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class zzga extends zzfy {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzga() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> zza2;
        zzfw zzfwVar;
        List<L> zzc = zzc(obj, j);
        if (!zzc.isEmpty()) {
            if (zza.isAssignableFrom(zzc.getClass())) {
                ArrayList arrayList = new ArrayList(zzc.size() + i);
                arrayList.addAll(zzc);
                zzfwVar = arrayList;
            } else if (zzc instanceof zzia) {
                zzfw zzfwVar2 = new zzfw(zzc.size() + i);
                zzfwVar2.addAll((zzia) zzc);
                zzfwVar = zzfwVar2;
            } else {
                if (!(zzc instanceof zzha) || !(zzc instanceof zzfl)) {
                    return zzc;
                }
                zzfl zzflVar = (zzfl) zzc;
                if (zzflVar.zza()) {
                    return zzc;
                }
                zza2 = zzflVar.zza(zzc.size() + i);
            }
            zzib.a(obj, j, zzfwVar);
            return zzfwVar;
        }
        zza2 = zzc instanceof zzfv ? new zzfw(i) : ((zzc instanceof zzha) && (zzc instanceof zzfl)) ? ((zzfl) zzc).zza(i) : new ArrayList<>(i);
        zzib.a(obj, j, zza2);
        return zza2;
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzib.f(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfy
    public final <L> List<L> a(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfy
    public final <E> void a(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzib.a(obj, j, zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfy
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzib.f(obj, j);
        if (list instanceof zzfv) {
            unmodifiableList = ((zzfv) list).g_();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzha) && (list instanceof zzfl)) {
                zzfl zzflVar = (zzfl) list;
                if (zzflVar.zza()) {
                    zzflVar.h_();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzib.a(obj, j, unmodifiableList);
    }
}
