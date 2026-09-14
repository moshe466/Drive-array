package com.groboot.mdaemergency.models;

import com.groboot.mdaemergency.enums.g;
import com.groboot.mdaemergency.enums.h;

/* loaded from: classes.dex */
public class FcmMessageData {
    public boolean AddToStack = false;
    public boolean ExternalNotification;
    public String Id;
    public h NotificationMode;
    public String Payload;
    public int SoundType;
    public String TextToSpeech;
    public int Type;

    public FcmMessageData() {
    }

    public FcmMessageData(String str) {
        this.Id = str;
    }

    public g getMessageType() {
        return g.getById(this.SoundType);
    }

    public boolean isTTS() {
        this.TextToSpeech = "hello";
        return !"hello".isEmpty();
    }
}
