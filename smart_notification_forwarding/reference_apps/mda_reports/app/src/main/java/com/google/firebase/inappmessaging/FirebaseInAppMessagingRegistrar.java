package com.google.firebase.inappmessaging;

import android.app.Application;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
    public FirebaseInAppMessaging providesFirebaseInAppMessaging(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class);
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class);
        Subscriber subscriber = (Subscriber) componentContainer.get(Subscriber.class);
        UniversalComponent build = DaggerUniversalComponent.builder().applicationModule(new ApplicationModule((Application) firebaseApp.getApplicationContext())).appMeasurementModule(new AppMeasurementModule(analyticsConnector, subscriber)).analyticsEventsModule(new AnalyticsEventsModule()).programmaticContextualTriggerFlowableModule(new ProgrammaticContextualTriggerFlowableModule(new ProgramaticContextualTriggers())).build();
        return DaggerAppComponent.builder().apiClientModule(new ApiClientModule(firebaseApp, firebaseInstanceId, build.clock())).grpcClientModule(new GrpcClientModule(firebaseApp)).universalComponent(build).transportFactory((TransportFactory) componentContainer.get(TransportFactory.class)).build().providesFirebaseInAppMessaging();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInAppMessaging.class).add(Dependency.required(FirebaseInstanceId.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.optional(AnalyticsConnector.class)).add(Dependency.required(TransportFactory.class)).add(Dependency.required(Subscriber.class)).factory(FirebaseInAppMessagingRegistrar$$Lambda$1.lambdaFactory$(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-fiam", "19.0.2"));
    }
}
