package com.google.firebase.inappmessaging.display;

import android.app.Application;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplayRegistrar implements ComponentRegistrar {
    public FirebaseInAppMessagingDisplay buildFirebaseInAppMessagingUI(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        FirebaseInAppMessaging firebaseInAppMessaging = (FirebaseInAppMessaging) componentContainer.get(FirebaseInAppMessaging.class);
        Application application = (Application) firebaseApp.getApplicationContext();
        FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI = DaggerAppComponent.builder().universalComponent(DaggerUniversalComponent.builder().applicationModule(new ApplicationModule(application)).build()).headlessInAppMessagingModule(new HeadlessInAppMessagingModule(firebaseInAppMessaging)).build().providesFirebaseInAppMessagingUI();
        application.registerActivityLifecycleCallbacks(providesFirebaseInAppMessagingUI);
        return providesFirebaseInAppMessagingUI;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInAppMessagingDisplay.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(AnalyticsConnector.class)).add(Dependency.required(FirebaseInAppMessaging.class)).factory(FirebaseInAppMessagingDisplayRegistrar$$Lambda$1.lambdaFactory$(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-fiamd", "19.0.2"));
    }
}
