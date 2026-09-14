package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class sb implements tb {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5597a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Long> f5598b;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5597a = y2Var.d("measurement.sdk.attribution.cache", true);
        f5598b = y2Var.b("measurement.sdk.attribution.cache.ttl", 604800000L);
    }

    @Override // com.google.android.gms.internal.measurement.tb
    public final long a() {
        return f5598b.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.tb
    public final boolean zza() {
        return f5597a.o().booleanValue();
    }
}
