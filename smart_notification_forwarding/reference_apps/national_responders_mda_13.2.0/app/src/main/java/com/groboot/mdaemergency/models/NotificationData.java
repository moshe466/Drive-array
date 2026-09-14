package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class NotificationData {
    public String message;
    public FcmMessageData messageData;
    public String serverNotificationId;
    public String title;

    public NotificationData(String str, String str2, FcmMessageData fcmMessageData) {
        this.message = str;
        this.title = str2;
        this.messageData = fcmMessageData;
    }
}
