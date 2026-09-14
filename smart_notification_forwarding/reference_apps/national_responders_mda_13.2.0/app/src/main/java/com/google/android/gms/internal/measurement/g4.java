package com.google.android.gms.internal.measurement;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [V] */
/* loaded from: classes.dex */
final class g4<V> extends AbstractCollection<V> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ y3 f5328f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g4(y3 y3Var) {
        this.f5328f = y3Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f5328f.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return this.f5328f.u();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f5328f.size();
    }
}
