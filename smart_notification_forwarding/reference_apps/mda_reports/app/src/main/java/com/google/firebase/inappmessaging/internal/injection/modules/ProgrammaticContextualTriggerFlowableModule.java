package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import dagger.Module;
import dagger.Provides;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class ProgrammaticContextualTriggerFlowableModule {
    private ProgramaticContextualTriggers triggers;

    public ProgrammaticContextualTriggerFlowableModule(ProgramaticContextualTriggers programaticContextualTriggers) {
        this.triggers = programaticContextualTriggers;
    }

    @Provides
    @Singleton
    @ProgrammaticTrigger
    public ConnectableFlowable<String> providesProgramaticContextualTriggerStream() {
        ConnectableFlowable<String> publish = Flowable.create(ProgrammaticContextualTriggerFlowableModule$$Lambda$1.lambdaFactory$(this), BackpressureStrategy.BUFFER).publish();
        publish.connect();
        return publish;
    }

    @Provides
    @Singleton
    @ProgrammaticTrigger
    public ProgramaticContextualTriggers providesProgramaticContextualTriggers() {
        return this.triggers;
    }
}
