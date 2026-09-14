package com.google.android.play.core.integrity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class be extends I1.z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3955a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f3956b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bn bnVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f3956b = bnVar;
        this.f3955a = context;
    }

    @Override // I1.z
    public final void b() {
        TaskCompletionSource taskCompletionSource;
        int i;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        Context context = this.f3955a;
        taskCompletionSource = this.f3956b.f3982d;
        I1.y yVar = I1.e.f919a;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.android.vending", 64);
            applicationInfo = packageInfo.applicationInfo;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (applicationInfo != null && applicationInfo.enabled && I1.e.a(packageInfo.signatures)) {
            i = packageInfo.versionCode;
            taskCompletionSource.trySetResult(Integer.valueOf(i));
        }
        i = 0;
        taskCompletionSource.trySetResult(Integer.valueOf(i));
    }
}
