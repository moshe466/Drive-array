package com.google.firebase.inappmessaging.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class ImageData {

    @Nullable
    private final Bitmap bitmapData;

    @NonNull
    private final String imageUrl;

    /* loaded from: classes2.dex */
    public static class Builder {

        @Nullable
        private Bitmap bitmapData;

        @Nullable
        private String imageUrl;

        public ImageData build() {
            if (TextUtils.isEmpty(this.imageUrl)) {
                throw new IllegalArgumentException("ImageData model must have an imageUrl");
            }
            return new ImageData(this.imageUrl, this.bitmapData);
        }

        public Builder setBitmapData(@Nullable Bitmap bitmap) {
            this.bitmapData = bitmap;
            return this;
        }

        public Builder setImageUrl(@Nullable String str) {
            if (!TextUtils.isEmpty(str)) {
                this.imageUrl = str;
            }
            return this;
        }
    }

    public ImageData(@NonNull String str, @Nullable Bitmap bitmap) {
        this.imageUrl = str;
        this.bitmapData = bitmap;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageData)) {
            return false;
        }
        ImageData imageData = (ImageData) obj;
        return hashCode() == imageData.hashCode() && this.imageUrl.equals(imageData.imageUrl);
    }

    @Nullable
    public Bitmap getBitmapData() {
        return this.bitmapData;
    }

    @NonNull
    public String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        Bitmap bitmap = this.bitmapData;
        return this.imageUrl.hashCode() + (bitmap != null ? bitmap.hashCode() : 0);
    }
}
