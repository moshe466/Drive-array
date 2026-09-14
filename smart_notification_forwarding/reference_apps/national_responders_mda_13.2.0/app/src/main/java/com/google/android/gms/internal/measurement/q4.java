package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes.dex */
public final class q4<E> extends o4<E> {

    /* renamed from: h, reason: collision with root package name */
    private final transient int f5548h;

    /* renamed from: i, reason: collision with root package name */
    private final transient int f5549i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ o4 f5550j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4(o4 o4Var, int i10, int i11) {
        this.f5550j = o4Var;
        this.f5548h = i10;
        this.f5549i = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final Object[] g() {
        return this.f5550j.g();
    }

    @Override // java.util.List
    public final E get(int i10) {
        n3.a(i10, this.f5549i);
        return this.f5550j.get(i10 + this.f5548h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final int j() {
        return this.f5550j.j() + this.f5548h;
    }

    @Override // com.google.android.gms.internal.measurement.k4
    final int l() {
        return this.f5550j.j() + this.f5548h + this.f5549i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5549i;
    }

    @Override // com.google.android.gms.internal.measurement.o4, java.util.List
    public final /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.o4
    /* renamed from: u */
    public final o4<E> subList(int i10, int i11) {
        n3.e(i10, i11, this.f5549i);
        o4 o4Var = this.f5550j;
        int i12 = this.f5548h;
        return (o4) o4Var.subList(i10 + i12, i11 + i12);
    }
}
