package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay_Factory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener_Factory;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule_ProvidesFiamControllerFactory;
import com.squareup.picasso.Picasso;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerAppComponent implements AppComponent {
    private Provider<FiamAnimator> fiamAnimatorProvider;
    private Provider<FiamImageLoader> fiamImageLoaderProvider;
    private Provider<FiamWindowManager> fiamWindowManagerProvider;
    private Provider<FirebaseInAppMessagingDisplay> firebaseInAppMessagingDisplayProvider;
    private Provider<BindingWrapperFactory> inflaterClientProvider;
    private Provider<Map<String, Provider<InAppMessageLayoutConfig>>> myKeyStringMapProvider;
    private Provider<PicassoErrorListener> picassoErrorListenerProvider;
    private Provider<Application> providesApplicationProvider;
    private Provider<Picasso> providesFiamControllerProvider;
    private Provider<FirebaseInAppMessaging> providesHeadlesssSingletonProvider;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private HeadlessInAppMessagingModule headlessInAppMessagingModule;
        private PicassoModule picassoModule;
        private UniversalComponent universalComponent;

        private Builder() {
        }

        public AppComponent build() {
            Preconditions.checkBuilderRequirement(this.headlessInAppMessagingModule, HeadlessInAppMessagingModule.class);
            if (this.picassoModule == null) {
                this.picassoModule = new PicassoModule();
            }
            Preconditions.checkBuilderRequirement(this.universalComponent, UniversalComponent.class);
            return new DaggerAppComponent(this.headlessInAppMessagingModule, this.picassoModule, this.universalComponent);
        }

        public Builder headlessInAppMessagingModule(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
            this.headlessInAppMessagingModule = (HeadlessInAppMessagingModule) Preconditions.checkNotNull(headlessInAppMessagingModule);
            return this;
        }

        public Builder picassoModule(PicassoModule picassoModule) {
            this.picassoModule = (PicassoModule) Preconditions.checkNotNull(picassoModule);
            return this;
        }

        public Builder universalComponent(UniversalComponent universalComponent) {
            this.universalComponent = (UniversalComponent) Preconditions.checkNotNull(universalComponent);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager implements Provider<FiamWindowManager> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public FiamWindowManager get() {
            return (FiamWindowManager) Preconditions.checkNotNull(this.universalComponent.fiamWindowManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient implements Provider<BindingWrapperFactory> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public BindingWrapperFactory get() {
            return (BindingWrapperFactory) Preconditions.checkNotNull(this.universalComponent.inflaterClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap implements Provider<Map<String, Provider<InAppMessageLayoutConfig>>> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        @Override // javax.inject.Provider
        public Map<String, Provider<InAppMessageLayoutConfig>> get() {
            return (Map) Preconditions.checkNotNull(this.universalComponent.myKeyStringMap(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication implements Provider<Application> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNull(this.universalComponent.providesApplication(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerAppComponent(HeadlessInAppMessagingModule headlessInAppMessagingModule, PicassoModule picassoModule, UniversalComponent universalComponent) {
        initialize(headlessInAppMessagingModule, picassoModule, universalComponent);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(HeadlessInAppMessagingModule headlessInAppMessagingModule, PicassoModule picassoModule, UniversalComponent universalComponent) {
        this.providesHeadlesssSingletonProvider = DoubleCheck.provider(HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory.create(headlessInAppMessagingModule));
        this.myKeyStringMapProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap(universalComponent);
        this.providesApplicationProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication(universalComponent);
        this.picassoErrorListenerProvider = DoubleCheck.provider(PicassoErrorListener_Factory.create());
        this.providesFiamControllerProvider = DoubleCheck.provider(PicassoModule_ProvidesFiamControllerFactory.create(picassoModule, this.providesApplicationProvider, this.picassoErrorListenerProvider));
        this.fiamImageLoaderProvider = DoubleCheck.provider(FiamImageLoader_Factory.create(this.providesFiamControllerProvider));
        this.fiamWindowManagerProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager(universalComponent);
        this.inflaterClientProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient(universalComponent);
        this.fiamAnimatorProvider = DoubleCheck.provider(FiamAnimator_Factory.create());
        this.firebaseInAppMessagingDisplayProvider = DoubleCheck.provider(FirebaseInAppMessagingDisplay_Factory.create(this.providesHeadlesssSingletonProvider, this.myKeyStringMapProvider, this.fiamImageLoaderProvider, RenewableTimer_Factory.create(), this.fiamWindowManagerProvider, this.providesApplicationProvider, this.inflaterClientProvider, this.fiamAnimatorProvider));
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
    public FiamImageLoader fiamImageLoader() {
        return this.fiamImageLoaderProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
    public PicassoErrorListener picassoErrorListener() {
        return this.picassoErrorListenerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
    public FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI() {
        return this.firebaseInAppMessagingDisplayProvider.get();
    }
}
