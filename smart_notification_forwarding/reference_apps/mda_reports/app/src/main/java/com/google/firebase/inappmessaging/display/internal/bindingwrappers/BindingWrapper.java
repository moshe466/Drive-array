package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BindingWrapper {
    protected final InAppMessage a;
    final InAppMessageLayoutConfig b;
    final LayoutInflater c;

    /* JADX INFO: Access modifiers changed from: protected */
    public BindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        this.b = inAppMessageLayoutConfig;
        this.c = layoutInflater;
        this.a = inAppMessage;
    }

    public static void setButtonBgColorFromHex(Button button, String str) {
        try {
            Drawable wrap = DrawableCompat.wrap(button.getBackground());
            DrawableCompat.setTint(wrap, Color.parseColor(str));
            button.setBackground(wrap);
        } catch (IllegalArgumentException e) {
            Logging.loge("Error parsing background color: " + e.toString());
        }
    }

    public static void setupViewButtonFromModel(Button button, com.google.firebase.inappmessaging.model.Button button2) {
        String hexColor = button2.getText().getHexColor();
        setButtonBgColorFromHex(button, button2.getButtonHexColor());
        button.setText(button2.getText().getText());
        button.setTextColor(Color.parseColor(hexColor));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable View view, @Nullable String str) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            view.setBackgroundColor(Color.parseColor(str));
        } catch (IllegalArgumentException e) {
            Logging.loge("Error parsing background color: " + e.toString() + " color: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable Button button, View.OnClickListener onClickListener) {
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }

    public boolean canSwipeToDismiss() {
        return false;
    }

    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.b;
    }

    @NonNull
    public abstract View getDialogView();

    @Nullable
    public View.OnClickListener getDismissListener() {
        return null;
    }

    @NonNull
    public abstract ImageView getImageView();

    @NonNull
    public abstract ViewGroup getRootView();

    @Nullable
    public abstract ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener);
}
