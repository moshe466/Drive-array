package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.ResizableImageView;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
/* loaded from: classes2.dex */
public class BannerBindingWrapper extends BindingWrapper {
    private TextView bannerBody;
    private ViewGroup bannerContentRoot;
    private ResizableImageView bannerImage;
    private FiamFrameLayout bannerRoot;
    private TextView bannerTitle;
    private View.OnClickListener mDismissListener;

    @Inject
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BannerBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    private void setActionListener(View.OnClickListener onClickListener) {
        this.bannerContentRoot.setOnClickListener(onClickListener);
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        int min = Math.min(inAppMessageLayoutConfig.maxDialogWidthPx().intValue(), inAppMessageLayoutConfig.maxDialogHeightPx().intValue());
        ViewGroup.LayoutParams layoutParams = this.bannerRoot.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = min;
        this.bannerRoot.setLayoutParams(layoutParams);
        this.bannerImage.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.bannerImage.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setMessage(@NonNull BannerMessage bannerMessage) {
        if (!TextUtils.isEmpty(bannerMessage.getBackgroundHexColor())) {
            a(this.bannerContentRoot, bannerMessage.getBackgroundHexColor());
        }
        this.bannerImage.setVisibility((bannerMessage.getImageData() == null || TextUtils.isEmpty(bannerMessage.getImageData().getImageUrl())) ? 8 : 0);
        if (bannerMessage.getTitle() != null) {
            if (!TextUtils.isEmpty(bannerMessage.getTitle().getText())) {
                this.bannerTitle.setText(bannerMessage.getTitle().getText());
            }
            if (!TextUtils.isEmpty(bannerMessage.getTitle().getHexColor())) {
                this.bannerTitle.setTextColor(Color.parseColor(bannerMessage.getTitle().getHexColor()));
            }
        }
        if (bannerMessage.getBody() != null) {
            if (!TextUtils.isEmpty(bannerMessage.getBody().getText())) {
                this.bannerBody.setText(bannerMessage.getBody().getText());
            }
            if (TextUtils.isEmpty(bannerMessage.getBody().getHexColor())) {
                return;
            }
            this.bannerBody.setTextColor(Color.parseColor(bannerMessage.getBody().getHexColor()));
        }
    }

    private void setSwipeDismissListener(View.OnClickListener onClickListener) {
        this.mDismissListener = onClickListener;
        this.bannerRoot.setDismissListener(this.mDismissListener);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public boolean canSwipeToDismiss() {
        return true;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.b;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public View getDialogView() {
        return this.bannerContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @Nullable
    public View.OnClickListener getDismissListener() {
        return this.mDismissListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ImageView getImageView() {
        return this.bannerImage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ViewGroup getRootView() {
        return this.bannerRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @Nullable
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View inflate = this.c.inflate(R.layout.banner, (ViewGroup) null);
        this.bannerRoot = (FiamFrameLayout) inflate.findViewById(R.id.banner_root);
        this.bannerContentRoot = (ViewGroup) inflate.findViewById(R.id.banner_content_root);
        this.bannerBody = (TextView) inflate.findViewById(R.id.banner_body);
        this.bannerImage = (ResizableImageView) inflate.findViewById(R.id.banner_image);
        this.bannerTitle = (TextView) inflate.findViewById(R.id.banner_title);
        if (this.a.getMessageType().equals(MessageType.BANNER)) {
            BannerMessage bannerMessage = (BannerMessage) this.a;
            setMessage(bannerMessage);
            setLayoutConfig(this.b);
            setSwipeDismissListener(onClickListener);
            setActionListener(map.get(bannerMessage.getAction()));
        }
        return null;
    }
}
