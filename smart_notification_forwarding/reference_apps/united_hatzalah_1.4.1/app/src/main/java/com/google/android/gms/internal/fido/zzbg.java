package com.google.android.gms.internal.fido;

import e0.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes.dex */
public final class zzbg extends zzbh implements NavigableMap {
    public static final /* synthetic */ int zzb = 0;
    private static final Comparator zzc;
    private static final zzbg zzd;
    private final transient zzbu zze;
    private final transient zzaz zzf;
    private final transient zzbg zzg;

    static {
        zzbp zzbpVar = zzbp.zza;
        zzc = zzbpVar;
        zzbu zzq = zzbi.zzq(zzbpVar);
        int i = zzaz.zzd;
        zzd = new zzbg(zzq, zzbs.zza, null);
    }

    public zzbg(zzbu zzbuVar, zzaz zzazVar, zzbg zzbgVar) {
        this.zze = zzbuVar;
        this.zzf = zzazVar;
        this.zzg = zzbgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzbg zzf(Map map) {
        boolean equals;
        final Comparator comparator = zzc;
        Comparator comparator2 = map.comparator();
        int i = 1;
        if (comparator2 == null) {
            equals = true;
        } else {
            equals = comparator.equals(comparator2);
        }
        Set entrySet = map.entrySet();
        Map.Entry[] entryArr = zzba.zza;
        if (entrySet == null) {
            Iterator it = entrySet.iterator();
            ArrayList arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            entrySet = arrayList;
        }
        Map.Entry[] entryArr2 = (Map.Entry[]) entrySet.toArray(entryArr);
        int length = entryArr2.length;
        if (length != 0) {
            if (length != 1) {
                Object[] objArr = new Object[length];
                Object[] objArr2 = new Object[length];
                if (equals) {
                    for (int i3 = 0; i3 < length; i3++) {
                        Map.Entry entry = entryArr2[i3];
                        entry.getClass();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        zzas.zza(key, value);
                        objArr[i3] = key;
                        objArr2[i3] = value;
                    }
                } else {
                    Arrays.sort(entryArr2, 0, length, new Comparator() { // from class: com.google.android.gms.internal.fido.zzbd
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            Comparator comparator3 = comparator;
                            Map.Entry entry2 = (Map.Entry) obj;
                            Map.Entry entry3 = (Map.Entry) obj2;
                            int i4 = zzbg.zzb;
                            entry2.getClass();
                            entry3.getClass();
                            return comparator3.compare(entry2.getKey(), entry3.getKey());
                        }
                    });
                    Map.Entry entry2 = entryArr2[0];
                    entry2.getClass();
                    Object key2 = entry2.getKey();
                    objArr[0] = key2;
                    Object value2 = entry2.getValue();
                    objArr2[0] = value2;
                    zzas.zza(objArr[0], value2);
                    while (i < length) {
                        Map.Entry entry3 = entryArr2[i - 1];
                        entry3.getClass();
                        Map.Entry entry4 = entryArr2[i];
                        entry4.getClass();
                        Object key3 = entry4.getKey();
                        Object value3 = entry4.getValue();
                        zzas.zza(key3, value3);
                        objArr[i] = key3;
                        objArr2[i] = value3;
                        if (comparator.compare(key2, key3) != 0) {
                            i++;
                            key2 = key3;
                        } else {
                            throw new IllegalArgumentException(a.f("Multiple entries with same key: ", String.valueOf(entry3), " and ", String.valueOf(entry4)));
                        }
                    }
                }
                return new zzbg(new zzbu(zzaz.zzh(objArr, length), comparator), zzaz.zzh(objArr2, length), null);
            }
            Map.Entry entry5 = entryArr2[0];
            entry5.getClass();
            return new zzbg(new zzbu(zzaz.zzj(entry5.getKey()), comparator), zzaz.zzj(entry5.getValue()), null);
        }
        return zzg(comparator);
    }

    public static zzbg zzg(Comparator comparator) {
        if (zzbp.zza.equals(comparator)) {
            return zzd;
        }
        zzbu zzq = zzbi.zzq(comparator);
        int i = zzaz.zzd;
        return new zzbg(zzq, zzbs.zza, null);
    }

    private final zzbg zzl(int i, int i3) {
        if (i == 0) {
            if (i3 != this.zzf.size()) {
                i = 0;
            } else {
                return this;
            }
        }
        if (i == i3) {
            return zzg(((zzbi) this.zze).zza);
        }
        return new zzbg(this.zze.zzu(i, i3), this.zzf.subList(i, i3), null);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return zzbn.zza(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((zzbi) this.zze).zza;
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet descendingKeySet() {
        return this.zze.descendingSet();
    }

    @Override // java.util.NavigableMap
    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        zzbr zzatVar;
        zzbg zzbgVar = this.zzg;
        if (zzbgVar == null) {
            if (isEmpty()) {
                Comparator comparator = ((zzbi) this.zze).zza;
                if (comparator instanceof zzbr) {
                    zzatVar = (zzbr) comparator;
                } else {
                    zzatVar = new zzat(comparator);
                }
                return zzg(zzatVar.zza());
            }
            return new zzbg((zzbu) this.zze.descendingSet(), this.zzf.zzf(), this);
        }
        return zzbgVar;
    }

    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(0);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.zze.first();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return zzbn.zza(floorEntry(obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x000f, code lost:
    
        if (r4 < 0) goto L4;
     */
    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.fido.zzbu r0 = r3.zze
            r1 = -1
            if (r4 != 0) goto L7
        L5:
            r4 = r1
            goto L12
        L7:
            com.google.android.gms.internal.fido.zzaz r2 = r0.zzd     // Catch: java.lang.ClassCastException -> L5
            java.util.Comparator r0 = r0.zza     // Catch: java.lang.ClassCastException -> L5
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch: java.lang.ClassCastException -> L5
            if (r4 >= 0) goto L12
            goto L5
        L12:
            if (r4 != r1) goto L16
            r4 = 0
            return r4
        L16:
            com.google.android.gms.internal.fido.zzaz r0 = r3.zzf
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbg.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return zzbn.zza(higherEntry(obj));
    }

    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    public final /* synthetic */ Set keySet() {
        return this.zze;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(this.zzf.size() - 1);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.zze.last();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return zzbn.zza(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.zze;
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzf.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    public final /* synthetic */ Collection values() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.fido.zzba
    /* renamed from: zza */
    public final zzav values() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.fido.zzba
    public final zzbc zzb() {
        if (isEmpty()) {
            return zzbt.zza;
        }
        return new zzbf(this);
    }

    @Override // com.google.android.gms.internal.fido.zzba
    /* renamed from: zzd */
    public final /* synthetic */ zzbc keySet() {
        return this.zze;
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzbg headMap(Object obj, boolean z3) {
        zzbu zzbuVar = this.zze;
        obj.getClass();
        return zzl(0, zzbuVar.zzs(obj, z3));
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzbg subMap(Object obj, boolean z3, Object obj2, boolean z4) {
        obj.getClass();
        obj2.getClass();
        if (((zzbi) this.zze).zza.compare(obj, obj2) <= 0) {
            return headMap(obj2, z4).tailMap(obj, z3);
        }
        throw new IllegalArgumentException(zzaq.zza("expected fromKey <= toKey but %s > %s", obj, obj2));
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final zzbg tailMap(Object obj, boolean z3) {
        zzbu zzbuVar = this.zze;
        obj.getClass();
        return zzl(zzbuVar.zzt(obj, z3), this.zzf.size());
    }
}
