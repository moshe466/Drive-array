package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes2.dex */
public class TransportClientModule {
    private static final String TRANSPORT_NAME = "731";

    @Provides
    @FirebaseAppScope
    public static MetricsLoggerClient a(FirebaseApp firebaseApp, TransportFactory transportFactory, AnalyticsConnector analyticsConnector, FirebaseInstanceId firebaseInstanceId, Clock clock, DeveloperListenerManager developerListenerManager) {
        Transformer transformer;
        transformer = TransportClientModule$$Lambda$1.instance;
        return new MetricsLoggerClient(TransportClientModule$$Lambda$2.lambdaFactory$(transportFactory.getTransport(TRANSPORT_NAME, byte[].class, transformer)), analyticsConnector, firebaseApp, firebaseInstanceId, clock, developerListenerManager);
    }

    public static /* synthetic */ byte[] a(byte[] bArr) {
        return bArr;
    }
}
