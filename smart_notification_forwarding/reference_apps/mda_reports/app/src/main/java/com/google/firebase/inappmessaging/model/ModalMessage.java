package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class ModalMessage extends InAppMessage {

    @Nullable
    private final Action action;

    @NonNull
    private final String backgroundHexColor;

    @Nullable
    private final Text body;

    @Nullable
    private final ImageData imageData;

    @NonNull
    private final Text title;

    /* loaded from: classes2.dex */
    public static class Builder {

        @Nullable
        Text a;

        @Nullable
        Text b;

        @Nullable
        ImageData c;

        @Nullable
        Action d;

        @Nullable
        String e;

        public ModalMessage build(CampaignMetadata campaignMetadata) {
            if (this.a == null) {
                throw new IllegalArgumentException("Modal model must have a title");
            }
            Action action = this.d;
            if (action != null && action.getButton() == null) {
                throw new IllegalArgumentException("Modal model action must be null or have a button");
            }
            if (TextUtils.isEmpty(this.e)) {
                throw new IllegalArgumentException("Modal model must have a background color");
            }
            return new ModalMessage(campaignMetadata, this.a, this.b, this.c, this.d, this.e);
        }

        public Builder setAction(@Nullable Action action) {
            this.d = action;
            return this;
        }

        public Builder setBackgroundHexColor(@Nullable String str) {
            this.e = str;
            return this;
        }

        public Builder setBody(@Nullable Text text) {
            this.b = text;
            return this;
        }

        public Builder setImageData(@Nullable ImageData imageData) {
            this.c = imageData;
            return this;
        }

        public Builder setTitle(@Nullable Text text) {
            this.a = text;
            return this;
        }
    }

    private ModalMessage(@NonNull CampaignMetadata campaignMetadata, @NonNull Text text, @Nullable Text text2, @Nullable ImageData imageData, @Nullable Action action, @NonNull String str) {
        super(campaignMetadata, MessageType.MODAL);
        this.title = text;
        this.body = text2;
        this.imageData = imageData;
        this.action = action;
        this.backgroundHexColor = str;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        Text text;
        Action action;
        ImageData imageData;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModalMessage)) {
            return false;
        }
        ModalMessage modalMessage = (ModalMessage) obj;
        if (hashCode() != modalMessage.hashCode()) {
            return false;
        }
        if ((this.body == null && modalMessage.body != null) || ((text = this.body) != null && !text.equals(modalMessage.body))) {
            return false;
        }
        if ((this.action != null || modalMessage.action == null) && ((action = this.action) == null || action.equals(modalMessage.action))) {
            return (this.imageData != null || modalMessage.imageData == null) && ((imageData = this.imageData) == null || imageData.equals(modalMessage.imageData)) && this.title.equals(modalMessage.title) && this.backgroundHexColor.equals(modalMessage.backgroundHexColor);
        }
        return false;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public Action getAction() {
        return this.action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public Text getBody() {
        return this.body;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public ImageData getImageData() {
        return this.imageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public Text getTitle() {
        return this.title;
    }

    public int hashCode() {
        Text text = this.body;
        int hashCode = text != null ? text.hashCode() : 0;
        Action action = this.action;
        int hashCode2 = action != null ? action.hashCode() : 0;
        ImageData imageData = this.imageData;
        return this.title.hashCode() + hashCode + this.backgroundHexColor.hashCode() + hashCode2 + (imageData != null ? imageData.hashCode() : 0);
    }
}
