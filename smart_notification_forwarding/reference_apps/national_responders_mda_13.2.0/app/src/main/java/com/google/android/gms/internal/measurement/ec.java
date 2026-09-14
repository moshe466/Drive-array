package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class ec implements fc {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5292a;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5292a = y2Var.d("measurement.sdk.dynamite.allow_remote_dynamite3", true);
        y2Var.d("measurement.collection.init_params_control_enabled", true);
        y2Var.d("measurement.sdk.dynamite.use_dynamite3", true);
        y2Var.b("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final boolean zza() {
        return f5292a.o().booleanValue();
    }
}
