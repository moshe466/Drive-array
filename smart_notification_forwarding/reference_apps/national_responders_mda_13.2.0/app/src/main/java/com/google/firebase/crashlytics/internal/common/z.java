package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* loaded from: classes.dex */
class z {

    /* renamed from: a, reason: collision with root package name */
    private String f7255a;

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        if (this.f7255a == null) {
            this.f7255a = b(context);
        }
        return "".equals(this.f7255a) ? null : this.f7255a;
    }
}
