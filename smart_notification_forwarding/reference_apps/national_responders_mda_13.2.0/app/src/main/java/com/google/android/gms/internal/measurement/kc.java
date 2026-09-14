package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class kc implements lc {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5436a = new y2(q2.a("com.google.android.gms.measurement")).d("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.lc
    public final boolean a() {
        return f5436a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.lc
    public final boolean zza() {
        return true;
    }
}
