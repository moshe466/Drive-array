package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class zzdud<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzhqv;
    private final /* synthetic */ zzdub zzhqw;

    private zzdud(zzdub zzdubVar) {
        List list;
        this.zzhqw = zzdubVar;
        list = this.zzhqw.zzhqm;
        this.pos = list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdud(zzdub zzdubVar, zzdue zzdueVar) {
        this(zzdubVar);
    }

    private final Iterator<Map.Entry<K, V>> zzbcc() {
        Map map;
        if (this.zzhqv == null) {
            map = this.zzhqw.zzhqp;
            this.zzhqv = map.entrySet().iterator();
        }
        return this.zzhqv;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.pos;
        if (i > 0) {
            list = this.zzhqw.zzhqm;
            if (i <= list.size()) {
                return true;
            }
        }
        return zzbcc().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> entry;
        if (zzbcc().hasNext()) {
            entry = zzbcc().next();
        } else {
            list = this.zzhqw.zzhqm;
            int i = this.pos - 1;
            this.pos = i;
            entry = (Map.Entry<K, V>) list.get(i);
        }
        return entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
