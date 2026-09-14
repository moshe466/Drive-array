package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import h0.a;
import v2.e;
import v2.f;

/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends a implements f {

    /* renamed from: c, reason: collision with root package name */
    private e f5788c;

    @Override // v2.f
    public final void a(Context context, Intent intent) {
        a.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f5788c == null) {
            this.f5788c = new e(this);
        }
        this.f5788c.a(context, intent);
    }
}
