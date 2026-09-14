package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K] */
/* loaded from: classes.dex */
public final class b4<K> extends f4<K> {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ y3 f5188j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(y3 y3Var) {
        super(y3Var, null);
        this.f5188j = y3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f4
    final K b(int i10) {
        return (K) this.f5188j.f5707h[i10];
    }
}
