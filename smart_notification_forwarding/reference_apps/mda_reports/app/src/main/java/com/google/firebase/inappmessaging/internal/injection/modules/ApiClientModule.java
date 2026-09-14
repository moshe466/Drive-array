package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes2.dex */
public class ApiClientModule {
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstanceId firebaseInstanceId;

    public ApiClientModule(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, Clock clock) {
        this.firebaseApp = firebaseApp;
        this.firebaseInstanceId = firebaseInstanceId;
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FirebaseApp a() {
        return this.firebaseApp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @FirebaseAppScope
    public ApiClient a(Lazy<GrpcClient> lazy, Application application, DataCollectionHelper dataCollectionHelper, ProviderInstaller providerInstaller) {
        return new ApiClient(lazy, this.firebaseApp, application, this.firebaseInstanceId, dataCollectionHelper, this.clock, providerInstaller);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public DataCollectionHelper a(SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return new DataCollectionHelper(this.firebaseApp, sharedPreferencesUtils, this.firebaseInstanceId, subscriber);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public TestDeviceHelper a(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FirebaseInstanceId b() {
        return this.firebaseInstanceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SharedPreferencesUtils c() {
        return new SharedPreferencesUtils(this.firebaseApp);
    }
}
