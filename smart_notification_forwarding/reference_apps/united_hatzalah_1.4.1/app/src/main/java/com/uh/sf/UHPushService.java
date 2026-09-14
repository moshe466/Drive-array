package com.uh.sf;

import com.google.firebase.messaging.RemoteMessage;
import com.lt.plugin.lt_plugin.FCMNotificationIntentService;
import java.util.Map;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class UHPushService extends FCMNotificationIntentService {
    @Override // com.lt.plugin.lt_plugin.FCMNotificationIntentService
    public final String getNotificationChannelDescription() {
        return "Notifications from United Hatzalah application";
    }

    @Override // com.lt.plugin.lt_plugin.FCMNotificationIntentService
    public final String getNotificationChannelId() {
        return "uh_notifications";
    }

    @Override // com.lt.plugin.lt_plugin.FCMNotificationIntentService
    public final int getNotificationChannelLightColor() {
        return -36352;
    }

    @Override // com.lt.plugin.lt_plugin.FCMNotificationIntentService
    public final String getNotificationChannelName() {
        return "United Hatzalah Notifications";
    }

    @Override // com.lt.plugin.lt_plugin.FCMNotificationIntentService
    public final boolean onMessageReceivedInternal(RemoteMessage remoteMessage) {
        Map<String, String> data;
        if (remoteMessage != null) {
            remoteMessage.getMessageId();
        }
        if (remoteMessage != null && (data = remoteMessage.getData()) != null) {
            data.get("type");
            return false;
        }
        return false;
    }

    @Override // com.lt.plugin.lt_plugin.FCMNotificationIntentService
    public final void onNewTokenReceived(String token) {
        j.e(token, "token");
        super.onNewTokenReceived(token);
    }
}
