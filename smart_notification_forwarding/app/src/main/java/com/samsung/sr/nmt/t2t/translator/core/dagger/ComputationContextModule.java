package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadPoolDispatcherKt;

/* compiled from: ComputationContextModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/ComputationContextModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideComputationContext", "Lkotlin/coroutines/CoroutineContext;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class ComputationContextModule {
    @Provides
    @Singleton
    public final CoroutineContext provideComputationContext() {
        return ThreadPoolDispatcherKt.newFixedThreadPoolContext(1, "PipelineThread");
    }
}
