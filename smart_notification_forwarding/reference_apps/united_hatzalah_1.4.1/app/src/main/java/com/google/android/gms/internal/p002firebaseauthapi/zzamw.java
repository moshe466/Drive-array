package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzamw<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private Object[] zza;
    private int zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzanc zze;
    private Map<K, V> zzf;

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        if (!this.zzd) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zza((zzamw<K, V>) comparable) < 0 && !this.zzc.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzanc(this);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzamw)) {
            return super.equals(obj);
        }
        zzamw zzamwVar = (zzamw) obj;
        int size = size();
        if (size != zzamwVar.size()) {
            return false;
        }
        int i = this.zzb;
        if (i != zzamwVar.zzb) {
            return entrySet().equals(zzamwVar.entrySet());
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (!zza(i3).equals(zzamwVar.zza(i3))) {
                return false;
            }
        }
        if (i == size) {
            return true;
        }
        return this.zzc.equals(zzamwVar.zzc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzamw<K, V>) comparable);
        if (zza >= 0) {
            return (V) ((zzana) this.zza[zza]).getValue();
        }
        return this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i = this.zzb;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += this.zza[i4].hashCode();
        }
        if (this.zzc.size() > 0) {
            return this.zzc.hashCode() + i3;
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzamw<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzamw<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzb(zza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzc.size() + this.zzb;
    }

    private zzamw() {
        Map<K, V> map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }

    public final Iterable<Map.Entry<K, V>> zzb() {
        if (this.zzc.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return this.zzc.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzc() {
        return new zzanb(this);
    }

    public void zzd() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.zzd) {
            return;
        }
        if (this.zzc.isEmpty()) {
            unmodifiableMap = Collections.EMPTY_MAP;
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.zzc);
        }
        this.zzc = unmodifiableMap;
        if (this.zzf.isEmpty()) {
            unmodifiableMap2 = Collections.EMPTY_MAP;
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
        }
        this.zzf = unmodifiableMap2;
        this.zzd = true;
    }

    public final boolean zze() {
        return this.zzd;
    }

    private final int zza(K k4) {
        int i;
        int i3 = this.zzb;
        int i4 = i3 - 1;
        if (i4 >= 0) {
            int compareTo = k4.compareTo((Comparable) ((zzana) this.zza[i4]).getKey());
            if (compareTo > 0) {
                i = i3 + 1;
                return -i;
            }
            if (compareTo == 0) {
                return i4;
            }
        }
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) / 2;
            int compareTo2 = k4.compareTo((Comparable) ((zzana) this.zza[i6]).getKey());
            if (compareTo2 < 0) {
                i4 = i6 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i6;
                }
                i5 = i6 + 1;
            }
        }
        i = i5 + 1;
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzb(int i) {
        zzg();
        V v2 = (V) ((zzana) this.zza[i]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i + 1, objArr, i, (this.zzb - i) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzf().entrySet().iterator();
            this.zza[this.zzb] = new zzana(this, it.next());
            this.zzb++;
            it.remove();
        }
        return v2;
    }

    public final int zza() {
        return this.zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V zza(K k4, V v2) {
        zzg();
        int zza = zza((zzamw<K, V>) k4);
        if (zza >= 0) {
            return (V) ((zzana) this.zza[zza]).setValue(v2);
        }
        zzg();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i = -(zza + 1);
        if (i >= 16) {
            return zzf().put(k4, v2);
        }
        int i3 = this.zzb;
        if (i3 == 16) {
            zzana zzanaVar = (zzana) this.zza[15];
            this.zzb = i3 - 1;
            zzf().put((Comparable) zzanaVar.getKey(), zzanaVar.getValue());
        }
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i, objArr, i + 1, (objArr.length - i) - 1);
        this.zza[i] = new zzana(this, k4, v2);
        this.zzb++;
        return null;
    }

    public final Map.Entry<K, V> zza(int i) {
        if (i < this.zzb) {
            return (zzana) this.zza[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }
}
