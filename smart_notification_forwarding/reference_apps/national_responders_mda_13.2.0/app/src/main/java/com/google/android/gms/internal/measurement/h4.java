package com.google.android.gms.internal.measurement;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class h4<K, V> extends u3<K, V> {

    /* renamed from: f, reason: collision with root package name */
    @NullableDecl
    private final K f5367f;

    /* renamed from: g, reason: collision with root package name */
    private int f5368g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ y3 f5369h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h4(y3 y3Var, int i10) {
        this.f5369h = y3Var;
        this.f5367f = (K) y3Var.f5707h[i10];
        this.f5368g = i10;
    }

    private final void a() {
        int d10;
        int i10 = this.f5368g;
        if (i10 == -1 || i10 >= this.f5369h.size() || !l3.a(this.f5367f, this.f5369h.f5707h[this.f5368g])) {
            d10 = this.f5369h.d(this.f5367f);
            this.f5368g = d10;
        }
    }

    @Override // com.google.android.gms.internal.measurement.u3, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.f5367f;
    }

    @Override // com.google.android.gms.internal.measurement.u3, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        Map<K, V> m10 = this.f5369h.m();
        if (m10 != null) {
            return m10.get(this.f5367f);
        }
        a();
        int i10 = this.f5368g;
        if (i10 == -1) {
            return null;
        }
        return (V) this.f5369h.f5708i[i10];
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v10) {
        Map<K, V> m10 = this.f5369h.m();
        if (m10 != null) {
            return m10.put(this.f5367f, v10);
        }
        a();
        int i10 = this.f5368g;
        if (i10 == -1) {
            this.f5369h.put(this.f5367f, v10);
            return null;
        }
        Object[] objArr = this.f5369h.f5708i;
        V v11 = (V) objArr[i10];
        objArr[i10] = v10;
        return v11;
    }
}
