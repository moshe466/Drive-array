package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class a4<K, V> extends f4<Map.Entry<K, V>> {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ y3 f5175j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(y3 y3Var) {
        super(y3Var, null);
        this.f5175j = y3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f4
    final /* synthetic */ Object b(int i10) {
        return new h4(this.f5175j, i10);
    }
}
