package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [K] */
/* loaded from: classes.dex */
final class e4<K> extends AbstractSet<K> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ y3 f5284f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e4(y3 y3Var) {
        this.f5284f = y3Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f5284f.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f5284f.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        return this.f5284f.s();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        Object k10;
        Object obj2;
        Map m10 = this.f5284f.m();
        if (m10 != null) {
            return m10.keySet().remove(obj);
        }
        k10 = this.f5284f.k(obj);
        obj2 = y3.f5704o;
        return k10 != obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5284f.size();
    }
}
