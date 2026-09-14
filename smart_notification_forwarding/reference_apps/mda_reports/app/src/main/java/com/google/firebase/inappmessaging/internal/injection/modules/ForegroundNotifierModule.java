package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class ForegroundNotifierModule {
    @Provides
    @Singleton
    public ForegroundNotifier providesForeground() {
        return new ForegroundNotifier();
    }
}
