package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class vd implements sd {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5647a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5648b;

    /* renamed from: c, reason: collision with root package name */
    private static final t2<Boolean> f5649c;

    /* renamed from: d, reason: collision with root package name */
    private static final t2<Boolean> f5650d;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5647a = y2Var.d("measurement.sdk.collection.enable_extend_user_property_size", true);
        f5648b = y2Var.d("measurement.sdk.collection.last_deep_link_referrer2", true);
        f5649c = y2Var.d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f5650d = y2Var.d("measurement.sdk.collection.last_gclid_from_referrer2", false);
        y2Var.b("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean a() {
        return f5648b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean b() {
        return f5649c.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean c() {
        return f5650d.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean zza() {
        return f5647a.o().booleanValue();
    }
}
