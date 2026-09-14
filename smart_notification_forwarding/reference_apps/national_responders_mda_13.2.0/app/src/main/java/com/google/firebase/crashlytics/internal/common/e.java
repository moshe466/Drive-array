package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final Float f7079a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7080b;

    private e(Float f10, boolean z10) {
        this.f7080b = z10;
        this.f7079a = f10;
    }

    public static e a(Context context) {
        boolean z10;
        Float f10 = null;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            z10 = e(registerReceiver);
            f10 = d(registerReceiver);
        } else {
            z10 = false;
        }
        return new e(f10, z10);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float b() {
        return this.f7079a;
    }

    public int c() {
        Float f10;
        if (!this.f7080b || (f10 = this.f7079a) == null) {
            return 1;
        }
        return ((double) f10.floatValue()) < 0.99d ? 2 : 3;
    }
}
