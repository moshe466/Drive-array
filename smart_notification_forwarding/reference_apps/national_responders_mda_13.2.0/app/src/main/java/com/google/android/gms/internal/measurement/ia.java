package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class ia extends AbstractList<String> implements e8, RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    private final e8 f5390f;

    public ia(e8 e8Var) {
        this.f5390f = e8Var;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final List<?> a() {
        return this.f5390f.a();
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final Object d(int i10) {
        return this.f5390f.d(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return (String) this.f5390f.get(i10);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final e8 h() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void i(d6 d6Var) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new ka(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i10) {
        return new la(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5390f.size();
    }
}
