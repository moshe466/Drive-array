package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.l;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.Task;

/* loaded from: classes.dex */
final class c {
    private static final com.google.android.play.core.splitcompat.a b = new com.google.android.play.core.splitcompat.a("AppUpdateService");
    private static final Intent c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    final t<l> a;
    private final String d;
    private final Context e;

    public c(Context context) {
        this.d = context.getPackageName();
        this.e = context;
        this.a = new t<>(ag.a(context), b, "AppUpdateService", c, f.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @InstallErrorCode
    public static int b(Bundle bundle) {
        return bundle.getInt("error.code", -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AppUpdateInfo b(Bundle bundle, String str) {
        return AppUpdateInfo.a(str, bundle.getInt("version.code", -1), bundle.getInt("update.availability"), bundle.getInt("install.status", 0), bundle.getInt("client.version.staleness", -1), bundle.getLong("bytes.downloaded"), bundle.getLong("total.bytes.to.download"), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10604);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle c(String str) {
        Bundle bundle = new Bundle();
        bundle.putAll(c());
        bundle.putString("package.name", str);
        Integer d = d();
        if (d != null) {
            bundle.putInt("app.version.code", d.intValue());
        }
        return bundle;
    }

    private final Integer d() {
        try {
            return Integer.valueOf(this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            b.d("The current version of the app could not be retrieved", new Object[0]);
            return null;
        }
    }

    public final Task<AppUpdateInfo> a(String str) {
        b.a("requestUpdateInfo(%s)", str);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new e(this, hVar, str, hVar));
        return hVar.a();
    }

    public final Task<Void> b(String str) {
        b.a("completeUpdate(%s)", str);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new h(this, hVar, hVar, str));
        return hVar.a();
    }
}
