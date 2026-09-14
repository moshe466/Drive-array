package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzmj;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzp {
    private String zza;
    private boolean zzb;
    private zzbr.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzn zzh;

    private zzp(zzn zznVar, String str) {
        this.zzh = zznVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzp(zzn zznVar, String str, zzbr.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zznVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zziVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzp(zzn zznVar, String str, zzbr.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzqVar) {
        this(zznVar, str, zziVar, bitSet, bitSet2, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzp(zzn zznVar, String str, zzq zzqVar) {
        this(zznVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BitSet a(zzp zzpVar) {
        return zzpVar.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final zzbr.zza a(int i, List<Integer> list) {
        ArrayList arrayList;
        List list2;
        zzbr.zza.C0032zza zzh = zzbr.zza.zzh();
        zzh.zza(i);
        zzh.zza(this.zzb);
        zzbr.zzi zziVar = this.zzc;
        if (zziVar != null) {
            zzh.zza(zziVar);
        }
        zzbr.zzi.zza zza = zzbr.zzi.zzi().zzb(zzki.a(this.zzd)).zza(zzki.a(this.zze));
        Map<Integer, Long> map = this.zzf;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(map.size());
            Iterator<Integer> it = this.zzf.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                arrayList.add((zzbr.zzb) zzbr.zzb.zze().zza(intValue).zza(this.zzf.get(Integer.valueOf(intValue)).longValue()).zzu());
            }
        }
        zza.zzc(arrayList);
        Map<Integer, List<Long>> map2 = this.zzg;
        if (map2 == null) {
            list2 = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(map2.size());
            for (Integer num : this.zzg.keySet()) {
                zzbr.zzj.zza zza2 = zzbr.zzj.zze().zza(num.intValue());
                List<Long> list3 = this.zzg.get(num);
                if (list3 != null) {
                    Collections.sort(list3);
                    zza2.zza(list3);
                }
                arrayList2.add((zzbr.zzj) zza2.zzu());
            }
            list2 = arrayList2;
        }
        if ((!zzmj.zzb() || !this.zzh.zzt().zzd(this.zza, zzap.zzbs)) && zzh.zza()) {
            List<zzbr.zzj> zzg = zzh.zzb().zzg();
            if (!zzg.isEmpty()) {
                ArrayList arrayList3 = new ArrayList(list2);
                ArrayMap arrayMap = new ArrayMap();
                for (zzbr.zzj zzjVar : zzg) {
                    if (zzjVar.zza() && zzjVar.zzd() > 0) {
                        arrayMap.put(Integer.valueOf(zzjVar.zzb()), Long.valueOf(zzjVar.zza(zzjVar.zzd() - 1)));
                    }
                }
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    zzbr.zzj zzjVar2 = (zzbr.zzj) arrayList3.get(i2);
                    Long l = (Long) arrayMap.remove(zzjVar2.zza() ? Integer.valueOf(zzjVar2.zzb()) : null);
                    if (l != null && (list == null || !list.contains(Integer.valueOf(zzjVar2.zzb())))) {
                        ArrayList arrayList4 = new ArrayList();
                        if (l.longValue() < zzjVar2.zza(0)) {
                            arrayList4.add(l);
                        }
                        arrayList4.addAll(zzjVar2.zzc());
                        arrayList3.set(i2, (zzbr.zzj) zzjVar2.zzbm().zza().zza(arrayList4).zzu());
                    }
                }
                for (Integer num2 : arrayMap.keySet()) {
                    arrayList3.add((zzbr.zzj) zzbr.zzj.zze().zza(num2.intValue()).zza(((Long) arrayMap.get(num2)).longValue()).zzu());
                }
                list2 = arrayList3;
            }
        }
        zza.zzd(list2);
        zzh.zza(zza);
        return (zzbr.zza) zzh.zzu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@NonNull zzu zzuVar) {
        int a = zzuVar.a();
        Boolean bool = zzuVar.c;
        if (bool != null) {
            this.zze.set(a, bool.booleanValue());
        }
        Boolean bool2 = zzuVar.d;
        if (bool2 != null) {
            this.zzd.set(a, bool2.booleanValue());
        }
        if (zzuVar.e != null) {
            Long l = this.zzf.get(Integer.valueOf(a));
            long longValue = zzuVar.e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(a), Long.valueOf(longValue));
            }
        }
        if (zzuVar.f != null) {
            List<Long> list = this.zzg.get(Integer.valueOf(a));
            if (list == null) {
                list = new ArrayList<>();
                this.zzg.put(Integer.valueOf(a), list);
            }
            if (zzmj.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbs) && zzuVar.b()) {
                list.clear();
            }
            list.add(Long.valueOf(zzuVar.f.longValue() / 1000));
        }
    }
}
