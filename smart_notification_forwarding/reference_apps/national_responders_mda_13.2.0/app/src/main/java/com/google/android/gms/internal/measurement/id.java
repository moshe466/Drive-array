package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class id implements fd {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5395a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5396b;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5395a = y2Var.d("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f5396b = y2Var.d("measurement.collection.redundant_engagement_removal_enabled", false);
        y2Var.b("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.fd
    public final boolean a() {
        return f5396b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.fd
    public final boolean zza() {
        return f5395a.o().booleanValue();
    }
}
