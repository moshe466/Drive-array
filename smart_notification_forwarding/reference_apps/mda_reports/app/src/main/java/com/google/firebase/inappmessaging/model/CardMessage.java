package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class CardMessage extends InAppMessage {

    @NonNull
    private final String backgroundHexColor;

    @Nullable
    private final Text body;

    @Nullable
    private final ImageData landscapeImageData;

    @Nullable
    private final ImageData portraitImageData;

    @NonNull
    private final Action primaryAction;

    @Nullable
    private final Action secondaryAction;

    @NonNull
    private final Text title;

    /* loaded from: classes2.dex */
    public static class Builder {

        @Nullable
        ImageData a;

        @Nullable
        ImageData b;

        @Nullable
        String c;

        @Nullable
        Action d;

        @Nullable
        Text e;

        @Nullable
        Text f;

        @Nullable
        Action g;

        public CardMessage build(CampaignMetadata campaignMetadata) {
            Action action = this.d;
            if (action == null) {
                throw new IllegalArgumentException("Card model must have a primary action");
            }
            if (action.getButton() == null) {
                throw new IllegalArgumentException("Card model must have a primary action button");
            }
            Action action2 = this.g;
            if (action2 != null && action2.getButton() == null) {
                throw new IllegalArgumentException("Card model secondary action must be null or have a button");
            }
            if (this.e == null) {
                throw new IllegalArgumentException("Card model must have a title");
            }
            if (this.a == null && this.b == null) {
                throw new IllegalArgumentException("Card model must have at least one image");
            }
            if (TextUtils.isEmpty(this.c)) {
                throw new IllegalArgumentException("Card model must have a background color");
            }
            return new CardMessage(campaignMetadata, this.e, this.f, this.a, this.b, this.c, this.d, this.g);
        }

        public Builder setBackgroundHexColor(@Nullable String str) {
            this.c = str;
            return this;
        }

        public Builder setBody(@Nullable Text text) {
            this.f = text;
            return this;
        }

        public Builder setLandscapeImageData(@Nullable ImageData imageData) {
            this.b = imageData;
            return this;
        }

        public Builder setPortraitImageData(@Nullable ImageData imageData) {
            this.a = imageData;
            return this;
        }

        public Builder setPrimaryAction(@Nullable Action action) {
            this.d = action;
            return this;
        }

        public Builder setSecondaryAction(@Nullable Action action) {
            this.g = action;
            return this;
        }

        public Builder setTitle(@Nullable Text text) {
            this.e = text;
            return this;
        }
    }

    private CardMessage(@NonNull CampaignMetadata campaignMetadata, @NonNull Text text, @Nullable Text text2, @Nullable ImageData imageData, @Nullable ImageData imageData2, @NonNull String str, @NonNull Action action, @Nullable Action action2) {
        super(campaignMetadata, MessageType.CARD);
        this.title = text;
        this.body = text2;
        this.portraitImageData = imageData;
        this.landscapeImageData = imageData2;
        this.backgroundHexColor = str;
        this.primaryAction = action;
        this.secondaryAction = action2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        Text text;
        Action action;
        ImageData imageData;
        ImageData imageData2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardMessage)) {
            return false;
        }
        CardMessage cardMessage = (CardMessage) obj;
        if (hashCode() != cardMessage.hashCode()) {
            return false;
        }
        if ((this.body == null && cardMessage.body != null) || ((text = this.body) != null && !text.equals(cardMessage.body))) {
            return false;
        }
        if ((this.secondaryAction == null && cardMessage.secondaryAction != null) || ((action = this.secondaryAction) != null && !action.equals(cardMessage.secondaryAction))) {
            return false;
        }
        if ((this.portraitImageData != null || cardMessage.portraitImageData == null) && ((imageData = this.portraitImageData) == null || imageData.equals(cardMessage.portraitImageData))) {
            return (this.landscapeImageData != null || cardMessage.landscapeImageData == null) && ((imageData2 = this.landscapeImageData) == null || imageData2.equals(cardMessage.landscapeImageData)) && this.title.equals(cardMessage.title) && this.primaryAction.equals(cardMessage.primaryAction) && this.backgroundHexColor.equals(cardMessage.backgroundHexColor);
        }
        return false;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    @Deprecated
    public Action getAction() {
        return this.primaryAction;
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
    @Deprecated
    public ImageData getImageData() {
        return this.portraitImageData;
    }

    @Nullable
    public ImageData getLandscapeImageData() {
        return this.landscapeImageData;
    }

    @Nullable
    public ImageData getPortraitImageData() {
        return this.portraitImageData;
    }

    @NonNull
    public Action getPrimaryAction() {
        return this.primaryAction;
    }

    @Nullable
    public Action getSecondaryAction() {
        return this.secondaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public Text getTitle() {
        return this.title;
    }

    public int hashCode() {
        Text text = this.body;
        int hashCode = text != null ? text.hashCode() : 0;
        Action action = this.secondaryAction;
        int hashCode2 = action != null ? action.hashCode() : 0;
        ImageData imageData = this.portraitImageData;
        int hashCode3 = imageData != null ? imageData.hashCode() : 0;
        ImageData imageData2 = this.landscapeImageData;
        return this.title.hashCode() + hashCode + this.backgroundHexColor.hashCode() + this.primaryAction.hashCode() + hashCode2 + hashCode3 + (imageData2 != null ? imageData2.hashCode() : 0);
    }
}
