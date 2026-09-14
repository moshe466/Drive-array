package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzgk implements zzgh {
    @Override // com.google.android.gms.internal.measurement.zzgh
    public final int zza(int i, Object obj, Object obj2) {
        zzgi zzgiVar = (zzgi) obj;
        if (zzgiVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgiVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Object zza(Object obj, Object obj2) {
        zzgi zzgiVar = (zzgi) obj;
        zzgi zzgiVar2 = (zzgi) obj2;
        if (!zzgiVar2.isEmpty()) {
            if (!zzgiVar.zzd()) {
                zzgiVar = zzgiVar.zzb();
            }
            zzgiVar.zza(zzgiVar2);
        }
        return zzgiVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Map<?, ?> zza(Object obj) {
        return (zzgi) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Map<?, ?> zzb(Object obj) {
        return (zzgi) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final boolean zzc(Object obj) {
        return !((zzgi) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Object zzd(Object obj) {
        ((zzgi) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Object zze(Object obj) {
        return zzgi.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final zzgf<?, ?> zzf(Object obj) {
        throw new NoSuchMethodError();
    }
}
