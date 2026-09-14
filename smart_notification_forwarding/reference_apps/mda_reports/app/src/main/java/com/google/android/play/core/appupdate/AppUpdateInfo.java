package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

/* loaded from: classes.dex */
public abstract class AppUpdateInfo {
    public static AppUpdateInfo a(String str, int i, @UpdateAvailability int i2, @InstallStatus int i3, int i4, long j, long j2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        return new k(str, i, i2, i3, i4, j, j2, pendingIntent, pendingIntent2);
    }

    public abstract int a();

    public abstract int availableVersionCode();

    public abstract long b();

    public abstract long c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract PendingIntent d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract PendingIntent e();

    @InstallStatus
    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(@AppUpdateType int i) {
        return i == 0 ? e() != null : i == 1 && d() != null;
    }

    public abstract String packageName();

    @UpdateAvailability
    public abstract int updateAvailability();
}
