package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class b5<K, V> extends t4<Map.Entry<K, V>> {

    /* renamed from: h, reason: collision with root package name */
    private final transient p4<K, V> f5189h;

    /* renamed from: i, reason: collision with root package name */
    private final transient Object[] f5190i;

    /* renamed from: j, reason: collision with root package name */
    private final transient int f5191j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b5(p4<K, V> p4Var, Object[] objArr, int i10, int i11) {
        this.f5189h = p4Var;
        this.f5190i = objArr;
        this.f5191j = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final int c(Object[] objArr, int i10) {
        return s().c(objArr, i10);
    }

    @Override // com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f5189h.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.k4
    /* renamed from: f */
    public final k5<Map.Entry<K, V>> iterator() {
        return (k5) s().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.t4, com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5191j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.t4
    final o4<Map.Entry<K, V>> w() {
        return new e5(this);
    }
}
