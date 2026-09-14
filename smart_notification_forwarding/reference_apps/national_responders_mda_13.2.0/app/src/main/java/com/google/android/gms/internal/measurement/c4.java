package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class c4<K, V> extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ y3 f5228f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c4(y3 y3Var) {
        this.f5228f = y3Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f5228f.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        int d10;
        Map<K, V> m10 = this.f5228f.m();
        if (m10 != null) {
            return m10.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            d10 = this.f5228f.d(entry.getKey());
            if (d10 != -1 && l3.a(this.f5228f.f5708i[d10], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.f5228f.t();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        int w10;
        Object obj2;
        Map<K, V> m10 = this.f5228f.m();
        if (m10 != null) {
            return m10.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.f5228f.g()) {
            return false;
        }
        w10 = this.f5228f.w();
        Object key = entry.getKey();
        Object value = entry.getValue();
        obj2 = this.f5228f.f5705f;
        y3 y3Var = this.f5228f;
        int c10 = j4.c(key, value, w10, obj2, y3Var.f5706g, y3Var.f5707h, y3Var.f5708i);
        if (c10 == -1) {
            return false;
        }
        this.f5228f.f(c10, w10);
        y3.r(this.f5228f);
        this.f5228f.p();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5228f.size();
    }
}
