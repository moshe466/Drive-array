package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class zzduj<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzhqv;
    private final /* synthetic */ zzdub zzhqw;
    private boolean zzhqz;

    private zzduj(zzdub zzdubVar) {
        this.zzhqw = zzdubVar;
        this.pos = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzduj(zzdub zzdubVar, zzdue zzdueVar) {
        this(zzdubVar);
    }

    private final Iterator<Map.Entry<K, V>> zzbcc() {
        Map map;
        if (this.zzhqv == null) {
            map = this.zzhqw.zzhqn;
            this.zzhqv = map.entrySet().iterator();
        }
        return this.zzhqv;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.pos + 1;
        list = this.zzhqw.zzhqm;
        if (i >= list.size()) {
            map = this.zzhqw.zzhqn;
            if (map.isEmpty() || !zzbcc().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> next;
        List list2;
        this.zzhqz = true;
        int i = this.pos + 1;
        this.pos = i;
        list = this.zzhqw.zzhqm;
        if (i < list.size()) {
            list2 = this.zzhqw.zzhqm;
            next = (Map.Entry<K, V>) list2.get(this.pos);
        } else {
            next = zzbcc().next();
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzhqz) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzhqz = false;
        this.zzhqw.zzbbv();
        int i = this.pos;
        list = this.zzhqw.zzhqm;
        if (i >= list.size()) {
            zzbcc().remove();
            return;
        }
        zzdub zzdubVar = this.zzhqw;
        int i2 = this.pos;
        this.pos = i2 - 1;
        zzdubVar.zzgx(i2);
    }
}
