package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
/* loaded from: classes2.dex */
public class ImageBindingWrapper extends BindingWrapper {
    private Button collapseButton;
    private ViewGroup imageContentRoot;
    private FiamFrameLayout imageRoot;
    private ImageView imageView;

    @Inject
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @NonNull
    public View getCollapseButton() {
        return this.collapseButton;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public View getDialogView() {
        return this.imageContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ViewGroup getRootView() {
        return this.imageRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @Nullable
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View inflate = this.c.inflate(R.layout.image, (ViewGroup) null);
        this.imageRoot = (FiamFrameLayout) inflate.findViewById(R.id.image_root);
        this.imageContentRoot = (ViewGroup) inflate.findViewById(R.id.image_content_root);
        this.imageView = (ImageView) inflate.findViewById(R.id.image_view);
        this.collapseButton = (Button) inflate.findViewById(R.id.collapse_button);
        this.imageView.setMaxHeight(this.b.getMaxImageHeight());
        this.imageView.setMaxWidth(this.b.getMaxImageWidth());
        if (this.a.getMessageType().equals(MessageType.IMAGE_ONLY)) {
            ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) this.a;
            this.imageView.setVisibility((imageOnlyMessage.getImageData() == null || TextUtils.isEmpty(imageOnlyMessage.getImageData().getImageUrl())) ? 8 : 0);
            this.imageView.setOnClickListener(map.get(imageOnlyMessage.getAction()));
        }
        this.imageRoot.setDismissListener(onClickListener);
        this.collapseButton.setOnClickListener(onClickListener);
        return null;
    }
}
