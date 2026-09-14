package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class dc implements ac {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5268a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5269b;

    /* renamed from: c, reason: collision with root package name */
    private static final t2<Boolean> f5270c;

    /* renamed from: d, reason: collision with root package name */
    private static final t2<Long> f5271d;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5268a = y2Var.d("measurement.client.consent_state_v1", false);
        f5269b = y2Var.d("measurement.client.3p_consent_state_v1", false);
        f5270c = y2Var.d("measurement.service.consent_state_v1_W36", false);
        y2Var.b("measurement.id.service.consent_state_v1_W36", 0L);
        f5271d = y2Var.b("measurement.service.storage_consent_support_version", 203590L);
    }

    @Override // com.google.android.gms.internal.measurement.ac
    public final boolean a() {
        return f5268a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ac
    public final boolean b() {
        return f5269b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ac
    public final boolean c() {
        return f5270c.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ac
    public final long d() {
        return f5271d.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ac
    public final boolean zza() {
        return true;
    }
}
