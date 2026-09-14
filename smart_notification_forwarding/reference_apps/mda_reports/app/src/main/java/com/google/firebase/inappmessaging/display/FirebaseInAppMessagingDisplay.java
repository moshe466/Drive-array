package com.google.firebase.inappmessaging.display;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.squareup.picasso.Callback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

@Keep
@FirebaseAppScope
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
    static final long DISMISS_THRESHOLD_MILLIS = 20000;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000;
    static final long INTERVAL_MILLIS = 1000;
    private final FiamAnimator animator;
    private final Application application;
    private final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    private FirebaseInAppMessagingDisplayCallbacks callbacks;
    private FiamListener fiamListener;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    private final RenewableTimer impressionTimer;
    private InAppMessage inAppMessage;
    private final Map<String, Provider<InAppMessageLayoutConfig>> layoutConfigs;
    private final FiamWindowManager windowManager;

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ BindingWrapper b;

        AnonymousClass1(Activity activity, BindingWrapper bindingWrapper) {
            r2 = activity;
            r3 = bindingWrapper;
        }

        @Override // java.lang.Runnable
        public void run() {
            FirebaseInAppMessagingDisplay.this.inflateBinding(r2, r3);
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$2 */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ Activity a;

        AnonymousClass2(Activity activity) {
            r2 = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
            }
            FirebaseInAppMessagingDisplay.this.dismissFiam(r2);
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$3 */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ Action a;
        final /* synthetic */ Activity b;

        AnonymousClass3(Action action, Activity activity) {
            r2 = action;
            r3 = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(r2);
            }
            new CustomTabsIntent.Builder().setShowTitle(true).build().launchUrl(r3, Uri.parse(r2.getActionUrl()));
            FirebaseInAppMessagingDisplay.this.notifyFiamClick();
            FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(r3);
            FirebaseInAppMessagingDisplay.this.inAppMessage = null;
            FirebaseInAppMessagingDisplay.this.callbacks = null;
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4 */
    /* loaded from: classes2.dex */
    public class AnonymousClass4 implements Callback {
        final /* synthetic */ BindingWrapper a;
        final /* synthetic */ Activity b;
        final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener c;

        /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$1 */
        /* loaded from: classes2.dex */
        class AnonymousClass1 implements View.OnTouchListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                }
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
                return true;
            }
        }

        /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$2 */
        /* loaded from: classes2.dex */
        class AnonymousClass2 implements RenewableTimer.Callback {
            AnonymousClass2() {
            }

            @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
            public void onFinish() {
                if (FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null) {
                    return;
                }
                Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
            }
        }

        /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$3 */
        /* loaded from: classes2.dex */
        class AnonymousClass3 implements RenewableTimer.Callback {
            AnonymousClass3() {
            }

            @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
            public void onFinish() {
                if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                }
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
            }
        }

        /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$4 */
        /* loaded from: classes2.dex */
        class RunnableC00604 implements Runnable {
            RunnableC00604() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FiamWindowManager fiamWindowManager = FirebaseInAppMessagingDisplay.this.windowManager;
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                fiamWindowManager.show(r2, r3);
                if (r2.getConfig().animate().booleanValue()) {
                    FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, r2.getRootView(), FiamAnimator.Position.TOP);
                }
            }
        }

        AnonymousClass4(BindingWrapper bindingWrapper, Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            r2 = bindingWrapper;
            r3 = activity;
            r4 = onGlobalLayoutListener;
        }

        @Override // com.squareup.picasso.Callback
        public void onError(Exception exc) {
            Logging.loge("Image download failure ");
            if (r4 != null) {
                r2.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(r4);
            }
            FirebaseInAppMessagingDisplay.this.cancelTimers();
            FirebaseInAppMessagingDisplay.this.inAppMessage = null;
            FirebaseInAppMessagingDisplay.this.callbacks = null;
        }

        @Override // com.squareup.picasso.Callback
        public void onSuccess() {
            if (!r2.getConfig().backgroundEnabled().booleanValue()) {
                r2.getRootView().setOnTouchListener(new View.OnTouchListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.1
                    AnonymousClass1() {
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() != 4) {
                            return false;
                        }
                        if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                        }
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
                        return true;
                    }
                });
            }
            FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.2
                AnonymousClass2() {
                }

                @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                public void onFinish() {
                    if (FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null) {
                        return;
                    }
                    Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                    FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                }
            }, FirebaseInAppMessagingDisplay.IMPRESSION_THRESHOLD_MILLIS, 1000L);
            if (r2.getConfig().autoDismiss().booleanValue()) {
                FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.3
                    AnonymousClass3() {
                    }

                    @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                    public void onFinish() {
                        if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                        }
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
                    }
                }, FirebaseInAppMessagingDisplay.DISMISS_THRESHOLD_MILLIS, 1000L);
            }
            r3.runOnUiThread(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.4
                RunnableC00604() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    FiamWindowManager fiamWindowManager = FirebaseInAppMessagingDisplay.this.windowManager;
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    fiamWindowManager.show(r2, r3);
                    if (r2.getConfig().animate().booleanValue()) {
                        FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, r2.getRootView(), FiamAnimator.Position.TOP);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$5 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a = new int[MessageType.values().length];

        static {
            try {
                a[MessageType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Inject
    public FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application, BindingWrapperFactory bindingWrapperFactory, FiamAnimator fiamAnimator) {
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map;
        this.imageLoader = fiamImageLoader;
        this.impressionTimer = renewableTimer;
        this.autoDismissTimer = renewableTimer2;
        this.windowManager = fiamWindowManager;
        this.application = application;
        this.bindingWrapperFactory = bindingWrapperFactory;
        this.animator = fiamAnimator;
    }

    public void cancelTimers() {
        this.impressionTimer.cancel();
        this.autoDismissTimer.cancel();
    }

    public void dismissFiam(Activity activity) {
        Logging.logd("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        this.inAppMessage = null;
        this.callbacks = null;
    }

    private List<Action> extractActions(InAppMessage inAppMessage) {
        Action action;
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass5.a[inAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            action = ((BannerMessage) inAppMessage).getAction();
        } else if (i == 2) {
            action = ((ModalMessage) inAppMessage).getAction();
        } else if (i == 3) {
            action = ((ImageOnlyMessage) inAppMessage).getAction();
        } else if (i != 4) {
            action = Action.builder().build();
        } else {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            arrayList.add(cardMessage.getPrimaryAction());
            action = cardMessage.getSecondaryAction();
        }
        arrayList.add(action);
        return arrayList;
    }

    private ImageData extractImageData(InAppMessage inAppMessage) {
        if (inAppMessage.getMessageType() != MessageType.CARD) {
            return inAppMessage.getImageData();
        }
        CardMessage cardMessage = (CardMessage) inAppMessage;
        ImageData portraitImageData = cardMessage.getPortraitImageData();
        ImageData landscapeImageData = cardMessage.getLandscapeImageData();
        return getScreenOrientation(this.application) == 1 ? isValidImageData(portraitImageData) ? portraitImageData : landscapeImageData : isValidImageData(landscapeImageData) ? landscapeImageData : portraitImageData;
    }

    @NonNull
    @Keep
    public static FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay) FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application) {
        return application.getResources().getConfiguration().orientation;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void inflateBinding(Activity activity, BindingWrapper bindingWrapper) {
        View.OnClickListener onClickListener;
        AnonymousClass2 anonymousClass2 = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.2
            final /* synthetic */ Activity a;

            AnonymousClass2(Activity activity2) {
                r2 = activity2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
                }
                FirebaseInAppMessagingDisplay.this.dismissFiam(r2);
            }
        };
        HashMap hashMap = new HashMap();
        for (Action action : extractActions(this.inAppMessage)) {
            if (action == null || TextUtils.isEmpty(action.getActionUrl())) {
                Logging.loge("No action url found for action.");
                onClickListener = anonymousClass2;
            } else {
                onClickListener = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.3
                    final /* synthetic */ Action a;
                    final /* synthetic */ Activity b;

                    AnonymousClass3(Action action2, Activity activity2) {
                        r2 = action2;
                        r3 = activity2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(r2);
                        }
                        new CustomTabsIntent.Builder().setShowTitle(true).build().launchUrl(r3, Uri.parse(r2.getActionUrl()));
                        FirebaseInAppMessagingDisplay.this.notifyFiamClick();
                        FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(r3);
                        FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                        FirebaseInAppMessagingDisplay.this.callbacks = null;
                    }
                };
            }
            hashMap.put(action2, onClickListener);
        }
        ViewTreeObserver.OnGlobalLayoutListener inflate = bindingWrapper.inflate(hashMap, anonymousClass2);
        if (inflate != null) {
            bindingWrapper.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(inflate);
        }
        loadNullableImage(activity2, bindingWrapper, extractImageData(this.inAppMessage), new Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4
            final /* synthetic */ BindingWrapper a;
            final /* synthetic */ Activity b;
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener c;

            /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$1 */
            /* loaded from: classes2.dex */
            class AnonymousClass1 implements View.OnTouchListener {
                AnonymousClass1() {
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 4) {
                        return false;
                    }
                    if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                        FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                    }
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
                    return true;
                }
            }

            /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$2 */
            /* loaded from: classes2.dex */
            class AnonymousClass2 implements RenewableTimer.Callback {
                AnonymousClass2() {
                }

                @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                public void onFinish() {
                    if (FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null) {
                        return;
                    }
                    Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                    FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                }
            }

            /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$3 */
            /* loaded from: classes2.dex */
            class AnonymousClass3 implements RenewableTimer.Callback {
                AnonymousClass3() {
                }

                @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                public void onFinish() {
                    if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                        FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                    }
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
                }
            }

            /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$4$4 */
            /* loaded from: classes2.dex */
            class RunnableC00604 implements Runnable {
                RunnableC00604() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    FiamWindowManager fiamWindowManager = FirebaseInAppMessagingDisplay.this.windowManager;
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    fiamWindowManager.show(r2, r3);
                    if (r2.getConfig().animate().booleanValue()) {
                        FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, r2.getRootView(), FiamAnimator.Position.TOP);
                    }
                }
            }

            AnonymousClass4(BindingWrapper bindingWrapper2, Activity activity2, ViewTreeObserver.OnGlobalLayoutListener inflate2) {
                r2 = bindingWrapper2;
                r3 = activity2;
                r4 = inflate2;
            }

            @Override // com.squareup.picasso.Callback
            public void onError(Exception exc) {
                Logging.loge("Image download failure ");
                if (r4 != null) {
                    r2.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(r4);
                }
                FirebaseInAppMessagingDisplay.this.cancelTimers();
                FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                FirebaseInAppMessagingDisplay.this.callbacks = null;
            }

            @Override // com.squareup.picasso.Callback
            public void onSuccess() {
                if (!r2.getConfig().backgroundEnabled().booleanValue()) {
                    r2.getRootView().setOnTouchListener(new View.OnTouchListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.1
                        AnonymousClass1() {
                        }

                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 4) {
                                return false;
                            }
                            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
                            return true;
                        }
                    });
                }
                FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.2
                    AnonymousClass2() {
                    }

                    @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                    public void onFinish() {
                        if (FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null) {
                            return;
                        }
                        Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                        FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                    }
                }, FirebaseInAppMessagingDisplay.IMPRESSION_THRESHOLD_MILLIS, 1000L);
                if (r2.getConfig().autoDismiss().booleanValue()) {
                    FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.3
                        AnonymousClass3() {
                        }

                        @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                        public void onFinish() {
                            if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FirebaseInAppMessagingDisplay.this.dismissFiam(r3);
                        }
                    }, FirebaseInAppMessagingDisplay.DISMISS_THRESHOLD_MILLIS, 1000L);
                }
                r3.runOnUiThread(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.4
                    RunnableC00604() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        FiamWindowManager fiamWindowManager = FirebaseInAppMessagingDisplay.this.windowManager;
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        fiamWindowManager.show(r2, r3);
                        if (r2.getConfig().animate().booleanValue()) {
                            FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, r2.getRootView(), FiamAnimator.Position.TOP);
                        }
                    }
                });
            }
        });
    }

    private boolean isValidImageData(@Nullable ImageData imageData) {
        return (imageData == null || TextUtils.isEmpty(imageData.getImageUrl())) ? false : true;
    }

    public static /* synthetic */ void lambda$onActivityStarted$0(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        if (firebaseInAppMessagingDisplay.inAppMessage != null || firebaseInAppMessagingDisplay.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.logd("Active FIAM exists. Skipping trigger");
            return;
        }
        firebaseInAppMessagingDisplay.inAppMessage = inAppMessage;
        firebaseInAppMessagingDisplay.callbacks = firebaseInAppMessagingDisplayCallbacks;
        firebaseInAppMessagingDisplay.showActiveFiam(activity);
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper, ImageData imageData, Callback callback) {
        if (isValidImageData(imageData)) {
            this.imageLoader.load(imageData.getImageUrl()).tag(activity.getClass()).placeholder(R.drawable.image_placeholder).into(bindingWrapper.getImageView(), callback);
        } else {
            callback.onSuccess();
        }
    }

    public void notifyFiamClick() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    private void notifyFiamTrigger() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    public void removeDisplayedFiam(Activity activity) {
        if (this.windowManager.isFiamDisplayed()) {
            this.windowManager.destroy(activity);
            cancelTimers();
        }
    }

    private void showActiveFiam(@NonNull Activity activity) {
        BindingWrapper createBannerBindingWrapper;
        if (this.inAppMessage == null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.loge("No active message found to render");
            return;
        }
        if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
            Logging.loge("The message being triggered is not supported by this version of the sdk.");
            return;
        }
        notifyFiamTrigger();
        InAppMessageLayoutConfig inAppMessageLayoutConfig = this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), getScreenOrientation(this.application))).get();
        int i = AnonymousClass5.a[this.inAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            createBannerBindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i == 2) {
            createBannerBindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i == 3) {
            createBannerBindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else {
            if (i != 4) {
                Logging.loge("No bindings found for this message type");
                return;
            }
            createBannerBindingWrapper = this.bindingWrapperFactory.createCardBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        }
        activity.findViewById(android.R.id.content).post(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.1
            final /* synthetic */ Activity a;
            final /* synthetic */ BindingWrapper b;

            AnonymousClass1(Activity activity2, BindingWrapper createBannerBindingWrapper2) {
                r2 = activity2;
                r3 = createBannerBindingWrapper2;
            }

            @Override // java.lang.Runnable
            public void run() {
                FirebaseInAppMessagingDisplay.this.inflateBinding(r2, r3);
            }
        });
    }

    @Keep
    public void clearFiamListener() {
        this.fiamListener = null;
    }

    @VisibleForTesting
    InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    @Keep
    public void onActivityDestroyed(Activity activity) {
        this.headlessInAppMessaging.clearDisplayListener();
        this.imageLoader.cancelTag(activity.getClass());
        removeDisplayedFiam(activity);
        super.onActivityDestroyed(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    @Keep
    public void onActivityPaused(Activity activity) {
        this.headlessInAppMessaging.clearDisplayListener();
        this.imageLoader.cancelTag(activity.getClass());
        removeDisplayedFiam(activity);
        super.onActivityPaused(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    @Keep
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    @Keep
    public void onActivityStarted(Activity activity) {
        super.onActivityStarted(activity);
        this.headlessInAppMessaging.setMessageDisplayComponent(FirebaseInAppMessagingDisplay$$Lambda$1.lambdaFactory$(this, activity));
    }

    @Keep
    public void setFiamListener(FiamListener fiamListener) {
        this.fiamListener = fiamListener;
    }

    @Keep
    public void testMessage(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
        showActiveFiam(activity);
    }
}
