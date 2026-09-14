package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class g5 extends o4<Object> {

    /* renamed from: h, reason: collision with root package name */
    private final transient Object[] f5329h;

    /* renamed from: i, reason: collision with root package name */
    private final transient int f5330i;

    /* renamed from: j, reason: collision with root package name */
    private final transient int f5331j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g5(Object[] objArr, int i10, int i11) {
        this.f5329h = objArr;
        this.f5330i = i10;
        this.f5331j = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        n3.a(i10, this.f5331j);
        return this.f5329h[(i10 * 2) + this.f5330i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5331j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return true;
    }
}
