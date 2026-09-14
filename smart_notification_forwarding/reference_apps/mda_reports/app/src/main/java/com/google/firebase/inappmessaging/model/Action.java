package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.model.Button;

/* loaded from: classes2.dex */
public class Action {

    @Nullable
    private final String actionUrl;

    @Nullable
    private final Button button;

    /* loaded from: classes2.dex */
    public static class Builder {

        @Nullable
        private String actionUrl;

        @Nullable
        private Button button;

        public Action build() {
            return new Action(this.actionUrl, this.button);
        }

        public Builder setActionUrl(@Nullable String str) {
            if (!TextUtils.isEmpty(str)) {
                this.actionUrl = str;
            }
            return this;
        }

        public Builder setButton(MessagesProto.Button button) {
            Button.Builder builder = new Button.Builder();
            builder.setButtonHexColor(button.getButtonHexColor());
            builder.setText(button.getText());
            return this;
        }

        public Builder setButton(@Nullable Button button) {
            this.button = button;
            return this;
        }
    }

    private Action(@Nullable String str, @Nullable Button button) {
        this.actionUrl = str;
        this.button = button;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        String str;
        Button button;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        if (hashCode() != action.hashCode()) {
            return false;
        }
        if ((this.actionUrl != null || action.actionUrl == null) && ((str = this.actionUrl) == null || str.equals(action.actionUrl))) {
            return (this.button == null && action.button == null) || ((button = this.button) != null && button.equals(action.button));
        }
        return false;
    }

    @Nullable
    public String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    public Button getButton() {
        return this.button;
    }

    public int hashCode() {
        String str = this.actionUrl;
        int hashCode = str != null ? str.hashCode() : 0;
        Button button = this.button;
        return hashCode + (button != null ? button.hashCode() : 0);
    }
}
