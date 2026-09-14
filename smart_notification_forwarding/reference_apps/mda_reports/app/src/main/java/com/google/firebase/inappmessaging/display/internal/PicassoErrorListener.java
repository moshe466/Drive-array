package com.google.firebase.inappmessaging.display.internal;

import android.net.Uri;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import javax.inject.Inject;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class PicassoErrorListener implements Picasso.Listener {
    private FirebaseInAppMessagingDisplayCallbacks displayCallbacks;
    private InAppMessage inAppMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public PicassoErrorListener() {
    }

    @Override // com.squareup.picasso.Picasso.Listener
    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exc) {
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks;
        FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason;
        if (this.inAppMessage == null || this.displayCallbacks == null) {
            return;
        }
        if ((exc instanceof IOException) && exc.getLocalizedMessage().contains("Failed to decode")) {
            firebaseInAppMessagingDisplayCallbacks = this.displayCallbacks;
            inAppMessagingErrorReason = FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT;
        } else {
            firebaseInAppMessagingDisplayCallbacks = this.displayCallbacks;
            inAppMessagingErrorReason = FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR;
        }
        firebaseInAppMessagingDisplayCallbacks.displayErrorEncountered(inAppMessagingErrorReason);
    }

    public void setInAppMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.displayCallbacks = firebaseInAppMessagingDisplayCallbacks;
    }
}
