package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class d5<K> extends t4<K> {

    /* renamed from: h, reason: collision with root package name */
    private final transient p4<K, ?> f5254h;

    /* renamed from: i, reason: collision with root package name */
    private final transient o4<K> f5255i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d5(p4<K, ?> p4Var, o4<K> o4Var) {
        this.f5254h = p4Var;
        this.f5255i = o4Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final int c(Object[] objArr, int i10) {
        return s().c(objArr, i10);
    }

    @Override // com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        return this.f5254h.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.measurement.k4
    /* renamed from: f */
    public final k5<K> iterator() {
        return (k5) s().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.t4, com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.measurement.t4, com.google.android.gms.internal.measurement.k4
    public final o4<K> s() {
        return this.f5255i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5254h.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return true;
    }
}
