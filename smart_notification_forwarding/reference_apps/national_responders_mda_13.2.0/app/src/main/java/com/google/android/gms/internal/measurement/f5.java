package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class f5<E> extends t4<E> {

    /* renamed from: m, reason: collision with root package name */
    static final f5<Object> f5309m = new f5<>(new Object[0], 0, null, 0, 0);

    /* renamed from: h, reason: collision with root package name */
    private final transient Object[] f5310h;

    /* renamed from: i, reason: collision with root package name */
    private final transient Object[] f5311i;

    /* renamed from: j, reason: collision with root package name */
    private final transient int f5312j;

    /* renamed from: k, reason: collision with root package name */
    private final transient int f5313k;

    /* renamed from: l, reason: collision with root package name */
    private final transient int f5314l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f5(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f5310h = objArr;
        this.f5311i = objArr2;
        this.f5312j = i11;
        this.f5313k = i10;
        this.f5314l = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final int c(Object[] objArr, int i10) {
        System.arraycopy(this.f5310h, 0, objArr, i10, this.f5314l);
        return i10 + this.f5314l;
    }

    @Override // com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.f5311i;
        if (obj == null || objArr == null) {
            return false;
        }
        int b10 = l4.b(obj);
        while (true) {
            int i10 = b10 & this.f5312j;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b10 = i10 + 1;
        }
    }

    @Override // com.google.android.gms.internal.measurement.k4
    /* renamed from: f */
    public final k5<E> iterator() {
        return (k5) s().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final Object[] g() {
        return this.f5310h;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f5313k;
    }

    @Override // com.google.android.gms.internal.measurement.t4, com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final int j() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.k4
    final int l() {
        return this.f5314l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5314l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.t4
    final boolean v() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.t4
    final o4<E> w() {
        return o4.x(this.f5310h, this.f5314l);
    }
}
