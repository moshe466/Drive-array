package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class e5<K, V> extends o4<Map.Entry<K, V>> {

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ b5 f5285h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e5(b5 b5Var) {
        this.f5285h = b5Var;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i10) {
        int i11;
        Object[] objArr;
        Object[] objArr2;
        i11 = this.f5285h.f5191j;
        n3.a(i10, i11);
        objArr = this.f5285h.f5190i;
        int i12 = i10 * 2;
        Object obj = objArr[i12];
        objArr2 = this.f5285h.f5190i;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i12 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i10;
        i10 = this.f5285h.f5191j;
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return true;
    }
}
