package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class cd implements zc {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5242a;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5242a = y2Var.d("measurement.client.sessions.check_on_reset_and_enable2", true);
        y2Var.d("measurement.client.sessions.check_on_startup", true);
        y2Var.d("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean a() {
        return f5242a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean zza() {
        return true;
    }
}
