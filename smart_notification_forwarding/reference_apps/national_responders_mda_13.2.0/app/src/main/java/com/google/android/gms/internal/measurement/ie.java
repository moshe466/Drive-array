package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class ie implements je {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5397a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Double> f5398b;

    /* renamed from: c, reason: collision with root package name */
    private static final t2<Long> f5399c;

    /* renamed from: d, reason: collision with root package name */
    private static final t2<Long> f5400d;

    /* renamed from: e, reason: collision with root package name */
    private static final t2<String> f5401e;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5397a = y2Var.d("measurement.test.boolean_flag", false);
        f5398b = y2Var.a("measurement.test.double_flag", -3.0d);
        f5399c = y2Var.b("measurement.test.int_flag", -2L);
        f5400d = y2Var.b("measurement.test.long_flag", -1L);
        f5401e = y2Var.c("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final double a() {
        return f5398b.o().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final long b() {
        return f5399c.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final long c() {
        return f5400d.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final String d() {
        return f5401e.o();
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final boolean zza() {
        return f5397a.o().booleanValue();
    }
}
