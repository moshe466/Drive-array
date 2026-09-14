package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class y9<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    private int f5722f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5723g;

    /* renamed from: h, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f5724h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ q9 f5725i;

    private y9(q9 q9Var) {
        this.f5725i = q9Var;
        this.f5722f = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y9(q9 q9Var, t9 t9Var) {
        this(q9Var);
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f5724h == null) {
            map = this.f5725i.f5554h;
            this.f5724h = map.entrySet().iterator();
        }
        return this.f5724h;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i10 = this.f5722f + 1;
        list = this.f5725i.f5553g;
        if (i10 >= list.size()) {
            map = this.f5725i.f5554h;
            if (map.isEmpty() || !b().hasNext()) {
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
        this.f5723g = true;
        int i10 = this.f5722f + 1;
        this.f5722f = i10;
        list = this.f5725i.f5553g;
        if (i10 < list.size()) {
            list2 = this.f5725i.f5553g;
            next = (Map.Entry<K, V>) list2.get(this.f5722f);
        } else {
            next = b().next();
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.f5723g) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f5723g = false;
        this.f5725i.q();
        int i10 = this.f5722f;
        list = this.f5725i.f5553g;
        if (i10 >= list.size()) {
            b().remove();
            return;
        }
        q9 q9Var = this.f5725i;
        int i11 = this.f5722f;
        this.f5722f = i11 - 1;
        q9Var.k(i11);
    }
}
