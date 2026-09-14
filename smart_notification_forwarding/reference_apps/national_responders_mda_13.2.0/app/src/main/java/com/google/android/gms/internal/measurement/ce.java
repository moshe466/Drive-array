package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class ce implements de {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Long> f5243a;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        y2Var.b("measurement.id.max_bundles_per_iteration", 0L);
        f5243a = y2Var.b("measurement.max_bundles_per_iteration", 2L);
    }

    @Override // com.google.android.gms.internal.measurement.de
    public final long zza() {
        return f5243a.o().longValue();
    }
}
