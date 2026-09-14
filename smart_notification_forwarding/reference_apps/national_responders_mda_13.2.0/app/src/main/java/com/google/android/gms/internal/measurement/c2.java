package com.google.android.gms.internal.measurement;

import android.os.Build;

/* loaded from: classes.dex */
public class c2 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f5226a = !a();

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
