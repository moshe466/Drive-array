package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public DeveloperListenerManager developerListenerManager() {
        return new DeveloperListenerManager();
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return this.application;
    }
}
