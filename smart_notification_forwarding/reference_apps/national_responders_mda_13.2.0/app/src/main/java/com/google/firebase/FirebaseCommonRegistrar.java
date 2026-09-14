package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import r3.i;
import x4.e;
import x4.h;

/* loaded from: classes.dex */
public class FirebaseCommonRegistrar implements i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String b(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String c(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        return (i10 < 16 || !context.getPackageManager().hasSystemFeature("android.hardware.type.television")) ? (i10 < 20 || !context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) ? (i10 < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i10 < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto" : "watch" : "tv";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String d(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? e(installerPackageName) : "";
    }

    private static String e(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // r3.i
    public List<r3.d<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x4.c.b());
        arrayList.add(p4.d.b());
        arrayList.add(h.a("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(h.a("fire-core", "19.5.0"));
        arrayList.add(h.a("device-name", e(Build.PRODUCT)));
        arrayList.add(h.a("device-model", e(Build.DEVICE)));
        arrayList.add(h.a("device-brand", e(Build.BRAND)));
        arrayList.add(h.b("android-target-sdk", a.b()));
        arrayList.add(h.b("android-min-sdk", b.b()));
        arrayList.add(h.b("android-platform", c.b()));
        arrayList.add(h.b("android-installer", d.b()));
        String a10 = e.a();
        if (a10 != null) {
            arrayList.add(h.a("kotlin", a10));
        }
        return arrayList;
    }
}
