package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class MetricsLoggerClient {
    private final AnalyticsConnector analyticsConnector;
    private final Clock clock;
    private final DeveloperListenerManager developerListenerManager;
    private final EngagementMetricsLoggerInterface engagementMetricsLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstanceId firebaseInstanceId;
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> errorTransform = new HashMap();
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> dismissTransform = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MessageType.values().length];

        static {
            try {
                a[MessageType.CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.IMAGE_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface EngagementMetricsLoggerInterface {
        void logEvent(byte[] bArr);
    }

    static {
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
    }

    public MetricsLoggerClient(EngagementMetricsLoggerInterface engagementMetricsLoggerInterface, AnalyticsConnector analyticsConnector, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, Clock clock, DeveloperListenerManager developerListenerManager) {
        this.engagementMetricsLogger = engagementMetricsLoggerInterface;
        this.analyticsConnector = analyticsConnector;
        this.firebaseApp = firebaseApp;
        this.firebaseInstanceId = firebaseInstanceId;
        this.clock = clock;
        this.developerListenerManager = developerListenerManager;
    }

    private CampaignAnalytics.Builder createCampaignAnalyticsBuilder(InAppMessage inAppMessage) {
        return CampaignAnalytics.newBuilder().setFiamSdkVersion("19.0.2").setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).setCampaignId(inAppMessage.getCampaignMetadata().getCampaignId()).setClientApp(createClientAppInfo()).setClientTimestampMillis(this.clock.now());
    }

    private ClientAppInfo createClientAppInfo() {
        return ClientAppInfo.newBuilder().setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setFirebaseInstanceId(this.firebaseInstanceId.getId()).build();
    }

    private CampaignAnalytics createDismissEntry(InAppMessage inAppMessage, DismissType dismissType) {
        return createCampaignAnalyticsBuilder(inAppMessage).setDismissType(dismissType).build();
    }

    private CampaignAnalytics createEventEntry(InAppMessage inAppMessage, EventType eventType) {
        return createCampaignAnalyticsBuilder(inAppMessage).setEventType(eventType).build();
    }

    private CampaignAnalytics createRenderErrorEntry(InAppMessage inAppMessage, RenderErrorReason renderErrorReason) {
        return createCampaignAnalyticsBuilder(inAppMessage).setRenderErrorReason(renderErrorReason).build();
    }

    private boolean impressionCountsAsConversion(InAppMessage inAppMessage) {
        int i = AnonymousClass1.a[inAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            return (isValidAction(cardMessage.getPrimaryAction()) ^ true) && (isValidAction(cardMessage.getSecondaryAction()) ^ true);
        }
        if (i == 2) {
            return !isValidAction(((ModalMessage) inAppMessage).getAction());
        }
        if (i == 3) {
            return !isValidAction(((BannerMessage) inAppMessage).getAction());
        }
        if (i == 4) {
            return !isValidAction(((ImageOnlyMessage) inAppMessage).getAction());
        }
        Logging.loge("Unable to determine if impression should be counted as conversion.");
        return false;
    }

    private boolean isTestCampaign(InAppMessage inAppMessage) {
        return inAppMessage.getCampaignMetadata().getIsTestMessage();
    }

    private boolean isValidAction(@Nullable Action action) {
        return (action == null || action.getActionUrl() == null || action.getActionUrl().isEmpty()) ? false : true;
    }

    private void logEventAsync(InAppMessage inAppMessage, String str, boolean z) {
        String campaignId = inAppMessage.getCampaignMetadata().getCampaignId();
        Bundle a = a(inAppMessage.getCampaignMetadata().getCampaignName(), campaignId);
        Logging.logd("Sending event=" + str + " params=" + a);
        AnalyticsConnector analyticsConnector = this.analyticsConnector;
        if (analyticsConnector == null) {
            Logging.logw("Unable to log event: analytics library is missing");
            return;
        }
        analyticsConnector.logEvent("fiam", str, a);
        if (z) {
            this.analyticsConnector.setUserProperty("fiam", AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION, "fiam:" + campaignId);
        }
    }

    Bundle a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", str2);
        bundle.putString("_nmn", str);
        try {
            bundle.putInt("_ndt", (int) (this.clock.now() / 1000));
        } catch (NumberFormatException e) {
            Logging.logw("Error while parsing use_device_time in FIAM event: " + e.getMessage());
        }
        return bundle;
    }

    public void logDismiss(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (isTestCampaign(inAppMessage)) {
            return;
        }
        this.engagementMetricsLogger.logEvent(createDismissEntry(inAppMessage, dismissTransform.get(inAppMessagingDismissType)).toByteArray());
        logEventAsync(inAppMessage, "fiam_dismiss", false);
    }

    public void logImpression(InAppMessage inAppMessage) {
        if (!isTestCampaign(inAppMessage)) {
            this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, EventType.IMPRESSION_EVENT_TYPE).toByteArray());
            logEventAsync(inAppMessage, "fiam_impression", impressionCountsAsConversion(inAppMessage));
        }
        this.developerListenerManager.impressionDetected(inAppMessage);
    }

    public void logMessageClick(InAppMessage inAppMessage, Action action) {
        if (!isTestCampaign(inAppMessage)) {
            this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, EventType.CLICK_EVENT_TYPE).toByteArray());
            logEventAsync(inAppMessage, "fiam_action", true);
        }
        this.developerListenerManager.messageClicked(inAppMessage, action);
    }

    public void logRenderError(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!isTestCampaign(inAppMessage)) {
            this.engagementMetricsLogger.logEvent(createRenderErrorEntry(inAppMessage, errorTransform.get(inAppMessagingErrorReason)).toByteArray());
        }
        this.developerListenerManager.displayErrorEncountered(inAppMessage, inAppMessagingErrorReason);
    }
}
