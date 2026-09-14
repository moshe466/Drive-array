package com.google.firebase.inappmessaging.model;

import androidx.annotation.NonNull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class ImageOnlyMessage extends InAppMessage {

    @Nullable
    private Action action;

    @NonNull
    private ImageData imageData;

    /* loaded from: classes2.dex */
    public static class Builder {

        @Nullable
        ImageData a;

        @Nullable
        Action b;

        public ImageOnlyMessage build(CampaignMetadata campaignMetadata) {
            ImageData imageData = this.a;
            if (imageData != null) {
                return new ImageOnlyMessage(campaignMetadata, imageData, this.b);
            }
            throw new IllegalArgumentException("ImageOnly model must have image data");
        }

        public Builder setAction(@Nullable Action action) {
            this.b = action;
            return this;
        }

        public Builder setImageData(@Nullable ImageData imageData) {
            this.a = imageData;
            return this;
        }
    }

    private ImageOnlyMessage(@NonNull CampaignMetadata campaignMetadata, @NonNull ImageData imageData, @Nullable Action action) {
        super(campaignMetadata, MessageType.IMAGE_ONLY);
        this.imageData = imageData;
        this.action = action;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        Action action;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageOnlyMessage)) {
            return false;
        }
        ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj;
        if (hashCode() != imageOnlyMessage.hashCode()) {
            return false;
        }
        return (this.action != null || imageOnlyMessage.action == null) && ((action = this.action) == null || action.equals(imageOnlyMessage.action)) && this.imageData.equals(imageOnlyMessage.imageData);
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public Action getAction() {
        return this.action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public ImageData getImageData() {
        return this.imageData;
    }

    public int hashCode() {
        Action action = this.action;
        return this.imageData.hashCode() + (action != null ? action.hashCode() : 0);
    }
}
