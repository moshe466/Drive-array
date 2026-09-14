package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class s9<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    private int f5594f;

    /* renamed from: g, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f5595g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q9 f5596h;

    private s9(q9 q9Var) {
        List list;
        this.f5596h = q9Var;
        list = q9Var.f5553g;
        this.f5594f = list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s9(q9 q9Var, t9 t9Var) {
        this(q9Var);
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f5595g == null) {
            map = this.f5596h.f5557k;
            this.f5595g = map.entrySet().iterator();
        }
        return this.f5595g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i10 = this.f5594f;
        if (i10 > 0) {
            list = this.f5596h.f5553g;
            if (i10 <= list.size()) {
                return true;
            }
        }
        return b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> entry;
        if (b().hasNext()) {
            entry = b().next();
        } else {
            list = this.f5596h.f5553g;
            int i10 = this.f5594f - 1;
            this.f5594f = i10;
            entry = (Map.Entry<K, V>) list.get(i10);
        }
        return entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
