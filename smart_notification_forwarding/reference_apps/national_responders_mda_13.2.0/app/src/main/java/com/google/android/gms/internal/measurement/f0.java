package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.h;

/* loaded from: classes.dex */
final class f0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Bundle f5302j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ Activity f5303k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ h.b f5304l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(h.b bVar, Bundle bundle, Activity activity) {
        super(h.this);
        this.f5304l = bVar;
        this.f5302j = bundle;
        this.f5303k = activity;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        Bundle bundle;
        qf qfVar;
        if (this.f5302j != null) {
            bundle = new Bundle();
            if (this.f5302j.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f5302j.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        qfVar = h.this.f5357h;
        qfVar.onActivityCreated(j2.b.z(this.f5303k), bundle, this.f5359g);
    }
}
