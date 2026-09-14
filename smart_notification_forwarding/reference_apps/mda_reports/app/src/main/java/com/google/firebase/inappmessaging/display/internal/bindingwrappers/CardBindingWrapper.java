package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout;
import com.google.firebase.inappmessaging.display.internal.layout.FiamCardView;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
/* loaded from: classes2.dex */
public class CardBindingWrapper extends BindingWrapper {
    private ScrollView bodyScroll;
    private BaseModalLayout cardContentRoot;
    private CardMessage cardMessage;
    private FiamCardView cardRoot;
    private View.OnClickListener dismissListener;
    private ImageView imageView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private TextView messageBody;
    private TextView messageTitle;
    private Button primaryButton;
    private Button secondaryButton;

    /* loaded from: classes2.dex */
    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public ScrollViewAdjustableListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            CardBindingWrapper.this.imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Inject
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CardBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
        this.layoutListener = new ScrollViewAdjustableListener();
    }

    private void setButtons(Map<Action, View.OnClickListener> map) {
        Action primaryAction = this.cardMessage.getPrimaryAction();
        Action secondaryAction = this.cardMessage.getSecondaryAction();
        BindingWrapper.setupViewButtonFromModel(this.primaryButton, primaryAction.getButton());
        a(this.primaryButton, map.get(primaryAction));
        this.primaryButton.setVisibility(0);
        if (secondaryAction == null || secondaryAction.getButton() == null) {
            this.secondaryButton.setVisibility(8);
            return;
        }
        BindingWrapper.setupViewButtonFromModel(this.secondaryButton, secondaryAction.getButton());
        a(this.secondaryButton, map.get(secondaryAction));
        this.secondaryButton.setVisibility(0);
    }

    private void setDismissListener(View.OnClickListener onClickListener) {
        this.dismissListener = onClickListener;
        this.cardRoot.setDismissListener(onClickListener);
    }

    private void setImage(CardMessage cardMessage) {
        ImageView imageView;
        int i;
        if (cardMessage.getPortraitImageData() == null && cardMessage.getLandscapeImageData() == null) {
            imageView = this.imageView;
            i = 8;
        } else {
            imageView = this.imageView;
            i = 0;
        }
        imageView.setVisibility(i);
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.imageView.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.imageView.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setMessage(CardMessage cardMessage) {
        this.messageTitle.setText(cardMessage.getTitle().getText());
        this.messageTitle.setTextColor(Color.parseColor(cardMessage.getTitle().getHexColor()));
        if (cardMessage.getBody() == null || cardMessage.getBody().getText() == null) {
            this.bodyScroll.setVisibility(8);
            this.messageBody.setVisibility(8);
        } else {
            this.bodyScroll.setVisibility(0);
            this.messageBody.setVisibility(0);
            this.messageBody.setText(cardMessage.getBody().getText());
            this.messageBody.setTextColor(Color.parseColor(cardMessage.getBody().getHexColor()));
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.b;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public View getDialogView() {
        return this.cardContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public View.OnClickListener getDismissListener() {
        return this.dismissListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ImageView getImageView() {
        return this.imageView;
    }

    @NonNull
    public Button getPrimaryButton() {
        return this.primaryButton;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ViewGroup getRootView() {
        return this.cardRoot;
    }

    @NonNull
    public View getScrollView() {
        return this.bodyScroll;
    }

    @NonNull
    public Button getSecondaryButton() {
        return this.secondaryButton;
    }

    @NonNull
    public View getTitleView() {
        return this.messageTitle;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View inflate = this.c.inflate(R.layout.card, (ViewGroup) null);
        this.bodyScroll = (ScrollView) inflate.findViewById(R.id.body_scroll);
        this.primaryButton = (Button) inflate.findViewById(R.id.primary_button);
        this.secondaryButton = (Button) inflate.findViewById(R.id.secondary_button);
        this.imageView = (ImageView) inflate.findViewById(R.id.image_view);
        this.messageBody = (TextView) inflate.findViewById(R.id.message_body);
        this.messageTitle = (TextView) inflate.findViewById(R.id.message_title);
        this.cardRoot = (FiamCardView) inflate.findViewById(R.id.card_root);
        this.cardContentRoot = (BaseModalLayout) inflate.findViewById(R.id.card_content_root);
        if (this.a.getMessageType().equals(MessageType.CARD)) {
            this.cardMessage = (CardMessage) this.a;
            setMessage(this.cardMessage);
            setImage(this.cardMessage);
            setButtons(map);
            setLayoutConfig(this.b);
            setDismissListener(onClickListener);
            a(this.cardContentRoot, this.cardMessage.getBackgroundHexColor());
        }
        return this.layoutListener;
    }

    @VisibleForTesting
    public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.layoutListener = onGlobalLayoutListener;
    }
}
