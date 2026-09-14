package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z4<E> extends o4<E> {

    /* renamed from: j, reason: collision with root package name */
    static final o4<Object> f5734j = new z4(new Object[0], 0);

    /* renamed from: h, reason: collision with root package name */
    private final transient Object[] f5735h;

    /* renamed from: i, reason: collision with root package name */
    private final transient int f5736i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z4(Object[] objArr, int i10) {
        this.f5735h = objArr;
        this.f5736i = i10;
    }

    @Override // com.google.android.gms.internal.measurement.o4, com.google.android.gms.internal.measurement.k4
    final int c(Object[] objArr, int i10) {
        System.arraycopy(this.f5735h, 0, objArr, i10, this.f5736i);
        return i10 + this.f5736i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final Object[] g() {
        return this.f5735h;
    }

    @Override // java.util.List
    public final E get(int i10) {
        n3.a(i10, this.f5736i);
        return (E) this.f5735h[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final int j() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.k4
    final int l() {
        return this.f5736i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5736i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return false;
    }
}
