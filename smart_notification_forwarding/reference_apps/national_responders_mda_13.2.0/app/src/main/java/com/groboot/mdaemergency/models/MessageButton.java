package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class MessageButton {
    public boolean Close;
    public boolean Enable;
    private int MessageButtonID;
    private String MessageButtonText;
    public boolean Selected;

    public int getMessageButtonID() {
        return this.MessageButtonID;
    }

    public String getMessageButtonText() {
        return this.MessageButtonText;
    }

    public void setMessageButtonID(int i10) {
        this.MessageButtonID = i10;
    }

    public void setMessageButtonText(String str) {
        this.MessageButtonText = str;
    }
}
