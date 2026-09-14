package com.lt.plugin.lt_plugin.services;

import android.app.NotificationChannel;
import android.view.autofill.AutofillManager;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ void C(NotificationChannel notificationChannel) {
        notificationChannel.enableLights(true);
    }

    public static /* bridge */ /* synthetic */ void D(NotificationChannel notificationChannel) {
        notificationChannel.setImportance(2);
    }

    public static /* synthetic */ NotificationChannel d() {
        return new NotificationChannel("ActiveDispatchOverlayChannel", "הזנקה פעילה", 2);
    }

    public static /* synthetic */ NotificationChannel e(CharSequence charSequence) {
        return new NotificationChannel("BackgroundServiceChannel", charSequence, 1);
    }

    public static /* synthetic */ NotificationChannel f(String str) {
        return new NotificationChannel("AfterBootChannel", str, 4);
    }

    public static /* synthetic */ NotificationChannel g(String str, String str2) {
        return new NotificationChannel(str, str2, 4);
    }

    public static /* bridge */ /* synthetic */ AutofillManager k(Object obj) {
        return (AutofillManager) obj;
    }

    public static /* bridge */ /* synthetic */ void n(NotificationChannel notificationChannel) {
        notificationChannel.setShowBadge(false);
    }

    public static /* synthetic */ NotificationChannel x(CharSequence charSequence) {
        return new NotificationChannel("FloatingServiceChannel", charSequence, 2);
    }

    public static /* bridge */ /* synthetic */ void y(NotificationChannel notificationChannel) {
        notificationChannel.setSound(null, null);
    }

    public static /* synthetic */ NotificationChannel z(CharSequence charSequence) {
        return new NotificationChannel("LocationServiceChannel", charSequence, 1);
    }
}
