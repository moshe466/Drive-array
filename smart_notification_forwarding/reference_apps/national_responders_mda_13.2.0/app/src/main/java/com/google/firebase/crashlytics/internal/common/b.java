package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f7070a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7071b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7072c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7073d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7074e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7075f;

    /* renamed from: g, reason: collision with root package name */
    public final j4.b f7076g;

    public b(String str, String str2, String str3, String str4, String str5, String str6, j4.b bVar) {
        this.f7070a = str;
        this.f7071b = str2;
        this.f7072c = str3;
        this.f7073d = str4;
        this.f7074e = str5;
        this.f7075f = str6;
        this.f7076g = bVar;
    }

    public static b a(Context context, x xVar, String str, String str2, j4.b bVar) {
        String packageName = context.getPackageName();
        String e10 = xVar.e();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String num = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new b(str, str2, e10, packageName, num, str3, bVar);
    }
}
