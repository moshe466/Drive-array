package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class SchedulerModule {
    @Provides
    @Singleton
    @Named("compute")
    public Scheduler providesComputeScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named("io")
    public Scheduler providesIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named("main")
    public Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
