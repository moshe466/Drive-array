package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class s1 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    Context f4977a;

    /* renamed from: b, reason: collision with root package name */
    private final r1 f4978b;

    public s1(r1 r1Var) {
        this.f4978b = r1Var;
    }

    public final void a(Context context) {
        this.f4977a = context;
    }

    public final synchronized void b() {
        Context context = this.f4977a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f4977a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f4978b.a();
            b();
        }
    }
}
