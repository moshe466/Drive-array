package com.google.firebase.inappmessaging.model;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class InAppMessage {

    @Deprecated
    Text a;

    @Deprecated
    Text b;

    @Deprecated
    String c;

    @Deprecated
    ImageData d;

    @Deprecated
    Button e;

    @Deprecated
    String f;
    MessageType g;
    CampaignMetadata h;

    public InAppMessage(CampaignMetadata campaignMetadata, MessageType messageType) {
        this.h = campaignMetadata;
        this.g = messageType;
    }

    @Deprecated
    public InAppMessage(Text text, Text text2, String str, ImageData imageData, Button button, Action action, String str2, String str3, String str4, Boolean bool, MessageType messageType) {
        this.a = text;
        this.b = text2;
        this.c = str;
        this.d = imageData;
        this.e = button;
        this.f = str2;
        this.g = messageType;
        this.h = new CampaignMetadata(str3, str4, bool.booleanValue());
    }

    @Nullable
    @Deprecated
    public abstract Action getAction();

    @Nullable
    @Deprecated
    public Button getActionButton() {
        return getAction() != null ? getAction().getButton() : this.e;
    }

    @Nullable
    @Deprecated
    public String getBackgroundHexColor() {
        return this.f;
    }

    @Nullable
    @Deprecated
    public Text getBody() {
        return this.b;
    }

    @Nullable
    @Deprecated
    public String getCampaignId() {
        return this.h.getCampaignId();
    }

    @Nullable
    public CampaignMetadata getCampaignMetadata() {
        return this.h;
    }

    @Nullable
    @Deprecated
    public String getCampaignName() {
        return this.h.getCampaignName();
    }

    @Nullable
    @Deprecated
    public ImageData getImageData() {
        return this.d;
    }

    @Nullable
    @Deprecated
    public String getImageUrl() {
        return this.c;
    }

    @Nullable
    @Deprecated
    public Boolean getIsTestMessage() {
        return Boolean.valueOf(this.h.getIsTestMessage());
    }

    @Nullable
    public MessageType getMessageType() {
        return this.g;
    }

    @Nullable
    @Deprecated
    public Text getTitle() {
        return this.a;
    }
}
