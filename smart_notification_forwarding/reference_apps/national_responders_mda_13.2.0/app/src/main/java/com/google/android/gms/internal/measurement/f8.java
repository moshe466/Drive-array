package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class f8 extends x5<String> implements e8, RandomAccess {

    /* renamed from: h, reason: collision with root package name */
    private static final f8 f5315h;

    /* renamed from: g, reason: collision with root package name */
    private final List<Object> f5316g;

    static {
        f8 f8Var = new f8();
        f5315h = f8Var;
        f8Var.n();
    }

    public f8() {
        this(10);
    }

    public f8(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    private f8(ArrayList<Object> arrayList) {
        this.f5316g = arrayList;
    }

    private static String f(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof d6 ? ((d6) obj).z() : o7.i((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final List<?> a() {
        return Collections.unmodifiableList(this.f5316g);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        c();
        this.f5316g.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends String> collection) {
        c();
        if (collection instanceof e8) {
            collection = ((e8) collection).a();
        }
        boolean addAll = this.f5316g.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.u7
    public final /* synthetic */ u7 b(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f5316g);
        return new f8((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.f5316g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final Object d(int i10) {
        return this.f5316g.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        Object obj = this.f5316g.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d6) {
            d6 d6Var = (d6) obj;
            String z10 = d6Var.z();
            if (d6Var.B()) {
                this.f5316g.set(i10, z10);
            }
            return z10;
        }
        byte[] bArr = (byte[]) obj;
        String i11 = o7.i(bArr);
        if (o7.h(bArr)) {
            this.f5316g.set(i10, i11);
        }
        return i11;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final e8 h() {
        return zza() ? new ia(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void i(d6 d6Var) {
        c();
        this.f5316g.add(d6Var);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        c();
        Object remove = this.f5316g.remove(i10);
        ((AbstractList) this).modCount++;
        return f(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        c();
        return f(this.f5316g.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5316g.size();
    }
}
