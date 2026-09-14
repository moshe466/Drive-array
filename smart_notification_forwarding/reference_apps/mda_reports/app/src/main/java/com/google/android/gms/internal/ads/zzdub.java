package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzdub<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzhjq;
    private final int zzhql;
    private List<zzduk> zzhqm;
    private Map<K, V> zzhqn;
    private volatile zzdum zzhqo;
    private Map<K, V> zzhqp;
    private volatile zzdug zzhqq;

    private zzdub(int i) {
        this.zzhql = i;
        this.zzhqm = Collections.emptyList();
        this.zzhqn = Collections.emptyMap();
        this.zzhqp = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdub(int i, zzdue zzdueVar) {
        this(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzdro<FieldDescriptorType>> zzdub<FieldDescriptorType, Object> a(int i) {
        return new zzdue(i);
    }

    private final int zza(K k) {
        int size = this.zzhqm.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzhqm.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzhqm.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbbv() {
        if (this.zzhjq) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzbbw() {
        zzbbv();
        if (this.zzhqn.isEmpty() && !(this.zzhqn instanceof TreeMap)) {
            this.zzhqn = new TreeMap();
            this.zzhqp = ((TreeMap) this.zzhqn).descendingMap();
        }
        return (SortedMap) this.zzhqn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzgx(int i) {
        zzbbv();
        V v = (V) this.zzhqm.remove(i).getValue();
        if (!this.zzhqn.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzbbw().entrySet().iterator();
            this.zzhqm.add(new zzduk(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> a() {
        if (this.zzhqq == null) {
            this.zzhqq = new zzdug(this, null);
        }
        return this.zzhqq;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzbbv();
        if (!this.zzhqm.isEmpty()) {
            this.zzhqm.clear();
        }
        if (this.zzhqn.isEmpty()) {
            return;
        }
        this.zzhqn.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzhqn.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzhqo == null) {
            this.zzhqo = new zzdum(this, null);
        }
        return this.zzhqo;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdub)) {
            return super.equals(obj);
        }
        zzdub zzdubVar = (zzdub) obj;
        int size = size();
        if (size != zzdubVar.size()) {
            return false;
        }
        int zzbbs = zzbbs();
        if (zzbbs != zzdubVar.zzbbs()) {
            return entrySet().equals(zzdubVar.entrySet());
        }
        for (int i = 0; i < zzbbs; i++) {
            if (!zzgw(i).equals(zzdubVar.zzgw(i))) {
                return false;
            }
        }
        if (zzbbs != size) {
            return this.zzhqn.equals(zzdubVar.zzhqn);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? (V) this.zzhqm.get(zza).getValue() : this.zzhqn.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzbbs = zzbbs();
        int i = 0;
        for (int i2 = 0; i2 < zzbbs; i2++) {
            i += this.zzhqm.get(i2).hashCode();
        }
        return this.zzhqn.size() > 0 ? i + this.zzhqn.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzhjq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzbbv();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return (V) zzgx(zza);
        }
        if (this.zzhqn.isEmpty()) {
            return null;
        }
        return this.zzhqn.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzhqm.size() + this.zzhqn.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzbbv();
        int zza = zza(k);
        if (zza >= 0) {
            return (V) this.zzhqm.get(zza).setValue(v);
        }
        zzbbv();
        if (this.zzhqm.isEmpty() && !(this.zzhqm instanceof ArrayList)) {
            this.zzhqm = new ArrayList(this.zzhql);
        }
        int i = -(zza + 1);
        if (i >= this.zzhql) {
            return zzbbw().put(k, v);
        }
        int size = this.zzhqm.size();
        int i2 = this.zzhql;
        if (size == i2) {
            zzduk remove = this.zzhqm.remove(i2 - 1);
            zzbbw().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzhqm.add(i, new zzduk(this, k, v));
        return null;
    }

    public void zzaxq() {
        if (this.zzhjq) {
            return;
        }
        this.zzhqn = this.zzhqn.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzhqn);
        this.zzhqp = this.zzhqp.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzhqp);
        this.zzhjq = true;
    }

    public final int zzbbs() {
        return this.zzhqm.size();
    }

    public final Iterable<Map.Entry<K, V>> zzbbt() {
        return this.zzhqn.isEmpty() ? zzduf.a() : this.zzhqn.entrySet();
    }

    public final Map.Entry<K, V> zzgw(int i) {
        return this.zzhqm.get(i);
    }
}
