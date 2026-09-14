package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.MessagesProto;

/* loaded from: classes2.dex */
public class Text {

    @NonNull
    private final String hexColor;

    @Nullable
    private final String text;

    /* loaded from: classes2.dex */
    public static class Builder {

        @Nullable
        private String hexColor;

        @Nullable
        private String text;

        public Text build() {
            if (TextUtils.isEmpty(this.hexColor)) {
                throw new IllegalArgumentException("Text model must have a color");
            }
            return new Text(this.text, this.hexColor);
        }

        public Builder setHexColor(@Nullable String str) {
            this.hexColor = str;
            return this;
        }

        public Builder setText(MessagesProto.Text text) {
            setText(text.getText());
            setHexColor(text.getHexColor());
            return this;
        }

        public Builder setText(@Nullable String str) {
            this.text = str;
            return this;
        }
    }

    private Text(@Nullable String str, @NonNull String str2) {
        this.text = str;
        this.hexColor = str2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Text)) {
            return false;
        }
        Text text = (Text) obj;
        if (hashCode() != text.hashCode()) {
            return false;
        }
        return (this.text != null || text.text == null) && ((str = this.text) == null || str.equals(text.text)) && this.hexColor.equals(text.hexColor);
    }

    @NonNull
    public String getHexColor() {
        return this.hexColor;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        return str != null ? str.hashCode() + this.hexColor.hashCode() : this.hexColor.hashCode();
    }
}
