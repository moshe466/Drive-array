package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import dagger.Module;
import dagger.Provides;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class ForegroundFlowableModule {
    @Provides
    @Singleton
    @AppForeground
    public ConnectableFlowable<String> providesAppForegroundEventStream(Application application, ForegroundNotifier foregroundNotifier) {
        application.registerActivityLifecycleCallbacks(foregroundNotifier);
        ConnectableFlowable<String> publish = Flowable.create(ForegroundFlowableModule$$Lambda$1.lambdaFactory$(foregroundNotifier), BackpressureStrategy.BUFFER).publish();
        publish.connect();
        return publish;
    }
}
