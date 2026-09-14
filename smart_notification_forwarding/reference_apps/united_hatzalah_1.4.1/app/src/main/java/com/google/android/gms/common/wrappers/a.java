package com.google.android.gms.common.wrappers;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import com.google.firebase.messaging.CommonNotificationBuilder;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ boolean B(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }

    public static /* synthetic */ NotificationChannel d() {
        return new NotificationChannel("downloads", "Downloads", 2);
    }

    public static /* bridge */ /* synthetic */ NotificationChannel f(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel g(String str) {
        return new NotificationChannel(CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL, str, 3);
    }

    public static /* synthetic */ void s() {
    }

    public static /* bridge */ /* synthetic */ void v(Context context, Intent intent) {
        context.startForegroundService(intent);
    }
}
