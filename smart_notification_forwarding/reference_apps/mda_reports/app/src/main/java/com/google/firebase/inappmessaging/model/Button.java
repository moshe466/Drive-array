package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.model.Text;

/* loaded from: classes2.dex */
public class Button {

    @NonNull
    private final String buttonHexColor;

    @NonNull
    private final Text text;

    /* loaded from: classes2.dex */
    public static class Builder {

        @Nullable
        private String buttonHexColor;

        @Nullable
        private Text text;

        public Button build() {
            if (TextUtils.isEmpty(this.buttonHexColor)) {
                throw new IllegalArgumentException("Button model must have a color");
            }
            Text text = this.text;
            if (text != null) {
                return new Button(text, this.buttonHexColor);
            }
            throw new IllegalArgumentException("Button model must have text");
        }

        public Builder setButtonHexColor(@Nullable String str) {
            this.buttonHexColor = str;
            return this;
        }

        public Builder setText(MessagesProto.Text text) {
            Text.Builder builder = new Text.Builder();
            builder.setText(text);
            this.text = builder.build();
            return this;
        }

        public Builder setText(@Nullable Text text) {
            this.text = text;
            return this;
        }
    }

    private Button(@NonNull Text text, @NonNull String str) {
        this.text = text;
        this.buttonHexColor = str;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Button)) {
            return false;
        }
        Button button = (Button) obj;
        return hashCode() == button.hashCode() && this.text.equals(button.text) && this.buttonHexColor.equals(button.buttonHexColor);
    }

    @NonNull
    public String getButtonHexColor() {
        return this.buttonHexColor;
    }

    @NonNull
    public Text getText() {
        return this.text;
    }

    public int hashCode() {
        return this.text.hashCode() + this.buttonHexColor.hashCode();
    }
}
