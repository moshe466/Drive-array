package com.google.firebase.inappmessaging;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import io.reactivex.Maybe;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class FirebaseInAppMessaging {
    private final DataCollectionHelper dataCollectionHelper;
    private final DeveloperListenerManager developerListenerManager;
    private final DisplayCallbacksFactory displayCallbacksFactory;
    private final InAppMessageStreamManager inAppMessageStreamManager;
    private final ProgramaticContextualTriggers programaticContextualTriggers;
    private Maybe<FirebaseInAppMessagingDisplay> listener = Maybe.empty();
    private boolean areMessagesSuppressed = false;

    @Inject
    @VisibleForTesting
    public FirebaseInAppMessaging(InAppMessageStreamManager inAppMessageStreamManager, @ProgrammaticTrigger ProgramaticContextualTriggers programaticContextualTriggers, DataCollectionHelper dataCollectionHelper, DisplayCallbacksFactory displayCallbacksFactory, DeveloperListenerManager developerListenerManager) {
        this.inAppMessageStreamManager = inAppMessageStreamManager;
        this.programaticContextualTriggers = programaticContextualTriggers;
        this.dataCollectionHelper = dataCollectionHelper;
        this.displayCallbacksFactory = displayCallbacksFactory;
        Logging.logi("Starting InAppMessaging runtime with Instance ID " + FirebaseInstanceId.getInstance().getId());
        this.developerListenerManager = developerListenerManager;
        initializeFiam();
    }

    @NonNull
    @Keep
    public static FirebaseInAppMessaging getInstance() {
        return (FirebaseInAppMessaging) FirebaseApp.getInstance().get(FirebaseInAppMessaging.class);
    }

    private void initializeFiam() {
        this.inAppMessageStreamManager.createFirebaseInAppMessageStream().subscribe(FirebaseInAppMessaging$$Lambda$1.lambdaFactory$(this));
    }

    public void addClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener);
    }

    public void addClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, @NonNull Executor executor) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener, executor);
    }

    public void addDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void addDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, @NonNull Executor executor) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener, executor);
    }

    public void addImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    public void addImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, @NonNull Executor executor) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener, executor);
    }

    @Keep
    public boolean areMessagesSuppressed() {
        return this.areMessagesSuppressed;
    }

    @Keep
    @KeepForSdk
    public void clearDisplayListener() {
        Logging.logi("Removing display event listener");
        this.listener = Maybe.empty();
    }

    @Keep
    public boolean isAutomaticDataCollectionEnabled() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    public void removeClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.removeClickListener(firebaseInAppMessagingClickListener);
    }

    public void removeDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.removeDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.removeImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    @Keep
    public void setAutomaticDataCollectionEnabled(boolean z) {
        this.dataCollectionHelper.setAutomaticDataCollectionEnabled(z);
    }

    @Keep
    public void setMessageDisplayComponent(@NonNull FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        Logging.logi("Setting display event listener");
        this.listener = Maybe.just(firebaseInAppMessagingDisplay);
    }

    @Keep
    public void setMessagesSuppressed(@NonNull Boolean bool) {
        this.areMessagesSuppressed = bool.booleanValue();
    }

    public void triggerEvent(String str) {
        this.programaticContextualTriggers.triggerEvent(str);
    }
}
