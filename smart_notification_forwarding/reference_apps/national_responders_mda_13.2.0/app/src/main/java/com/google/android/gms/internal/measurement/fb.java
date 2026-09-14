package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class fb implements gb {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5317a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5318b;

    /* renamed from: c, reason: collision with root package name */
    private static final t2<Boolean> f5319c;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5317a = y2Var.d("measurement.client.ad_impression", true);
        f5318b = y2Var.d("measurement.service.separate_public_internal_event_blacklisting", true);
        f5319c = y2Var.d("measurement.service.ad_impression", true);
        y2Var.b("measurement.id.service.ad_impression", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final boolean a() {
        return f5317a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final boolean b() {
        return f5318b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final boolean c() {
        return f5319c.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final boolean zza() {
        return true;
    }
}
