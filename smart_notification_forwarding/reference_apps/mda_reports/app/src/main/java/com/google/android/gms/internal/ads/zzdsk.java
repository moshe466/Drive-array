package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzdsk<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzhoe;

    public zzdsk(Iterator<Map.Entry<K, Object>> it) {
        this.zzhoe = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzhoe.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzhoe.next();
        return next.getValue() instanceof zzdsf ? new zzdsh(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzhoe.remove();
    }
}
