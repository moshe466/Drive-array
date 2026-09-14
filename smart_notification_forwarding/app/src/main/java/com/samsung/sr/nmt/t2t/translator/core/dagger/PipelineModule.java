package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorModuleBuilderParams;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpecFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PipelineModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/PipelineModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "environmentHelper", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/Pipeline;", "languageSpecFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpecFactory;", "translationProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationProcessor;", "computationContext", "Lkotlin/coroutines/CoroutineContext;", "translatorModuleBuilderParams", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorModuleBuilderParams;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class PipelineModule {
    @Provides
    @Singleton
    public final Pipeline environmentHelper(LanguageSpecFactory languageSpecFactory, TranslationProcessor translationProcessor, CoroutineContext computationContext, TranslatorModuleBuilderParams translatorModuleBuilderParams) {
        Intrinsics.checkNotNullParameter(languageSpecFactory, "languageSpecFactory");
        Intrinsics.checkNotNullParameter(translationProcessor, "translationProcessor");
        Intrinsics.checkNotNullParameter(computationContext, "computationContext");
        Intrinsics.checkNotNullParameter(translatorModuleBuilderParams, "translatorModuleBuilderParams");
        return new Pipeline(languageSpecFactory, translationProcessor, computationContext, translatorModuleBuilderParams.getCharacterBatchSize());
    }
}
