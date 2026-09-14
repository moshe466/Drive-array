package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class d8<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: f, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f5261f;

    public d8(Iterator<Map.Entry<K, Object>> it) {
        this.f5261f = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5261f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f5261f.next();
        return next.getValue() instanceof y7 ? new a8(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5261f.remove();
    }
}
