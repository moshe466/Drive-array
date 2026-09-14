package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class pc implements mc {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5536a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5537b;

    /* renamed from: c, reason: collision with root package name */
    private static final t2<Boolean> f5538c;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        y2Var.d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f5536a = y2Var.d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f5537b = y2Var.d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f5538c = y2Var.d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.mc
    public final boolean a() {
        return f5536a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.mc
    public final boolean b() {
        return f5537b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.mc
    public final boolean c() {
        return f5538c.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.mc
    public final boolean zza() {
        return true;
    }
}
