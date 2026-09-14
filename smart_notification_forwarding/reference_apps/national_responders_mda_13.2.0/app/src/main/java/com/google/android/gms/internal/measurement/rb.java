package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class rb implements nb {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5575a;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5575a = y2Var.d("measurement.service.directly_maybe_log_error_events", false);
        y2Var.b("measurement.id.service.directly_maybe_log_error_events", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final boolean a() {
        return f5575a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final boolean zza() {
        return true;
    }
}
